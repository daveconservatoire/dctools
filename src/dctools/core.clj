(ns dctools.core
  (:require [camel-snake-kebab.core :as csk]
            [clojure.string :refer [join]]))

(defn youtube-video->lesson [{:keys [snippet id] :as video}]
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
