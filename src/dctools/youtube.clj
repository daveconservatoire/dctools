(ns dctools.youtube
  (:require [org.httpkit.client :as http]
            [clojure.data.json :as json]
            [camel-snake-kebab.core :as csk]
            [clojure.set :as set]
            [clojure.string :refer [join]]))

(defn http-get [url options]
  (let [{:keys [body error]} @(http/get url options)]
    (if error
      (throw error)
      body)))

(defn call [method args]
  (let [url (str "https://www.googleapis.com/youtube/v3/" method)]
    (json/read-str (http-get url {:query-params args})
                   :key-fn keyword)))

(defn raw-playlist [youtube-key playlist-id]
  (-> (call "playlists" {:part "id,status,snippet,contentDetails"
                         :id   playlist-id
                         :key  youtube-key})
      :items first))

(defn raw-video-info [youtube-key video-id]
  (-> (call "videos" {:part "snippet"
                      :id   video-id
                      :key  youtube-key})
      :items))

(defn get-playlist-video-ids [youtube-key playlist-id]
  (->> (call "playlistItems" {:part       "contentDetails"
                              :playlistId playlist-id
                              :maxResults 50
                              :key        youtube-key})
       :items
       (keep #(get-in % [:contentDetails :videoId]))
       (join ",")))

(defn get-missing-videos [youtube-key video-ids]
  "This function efficiently detecteds offline videos. The calls are batched in requests
  of 50 items per time (this is the max allowed by Youtube). For example, to check on
  225 items it makes 5 requests."
  (let [page-size 50]
    (loop [remaining video-ids
           valid-acc []]
      (let [[current rest] (split-at page-size remaining)
            valid-acc (concat
                        valid-acc
                        (->> (call "videos" {:part       "id"
                                             :id         (join "," current)
                                             :key        youtube-key
                                             :maxResults page-size})
                             :items
                             (map :id)))]
        (if (seq rest)
          (recur rest valid-acc)
          (set/difference (set video-ids) (set valid-acc)))))))

(defn raw-playlist-items [youtube-key playlist-id]
  (let [video-ids (get-playlist-video-ids youtube-key playlist-id)]
    (raw-video-info youtube-key video-ids)))

(defn get-playlist [youtube-key playlist-id]
  (-> (raw-playlist youtube-key playlist-id)
      (assoc :items (raw-playlist-items youtube-key playlist-id))))

(defn youtube-video->lesson [{:keys [snippet id]}]
  {:type        :lesson
   :youtube-id  id
   :title       (get snippet :title)
   :description (get snippet :description)
   :keywords    (join ", " (get snippet :tags))
   :url-title   (csk/->kebab-case (get snippet :title))})

(defn youtube-playlist->topic [{:keys [items] :as playlist}]
  {:type    :topic
   :title   (get-in playlist [:snippet :title])
   :lessons (map youtube-video->lesson items)})

(defn topic-from-playlist [youtube-key playlist-id]
  (-> (get-playlist youtube-key playlist-id)
      (youtube-playlist->topic)))
