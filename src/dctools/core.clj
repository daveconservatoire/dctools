(ns dctools.core
  (:require [dctools.youtube :as yt]
            [dctools.database :as db]
            [clojure.edn :as edn]))

(def credentials (edn/read-string (slurp "credentials.edn")))
(def youtube-key (get-in credentials [:youtube :api-key]))

(defn detect-added-by [identity a b]
  (let [index-set (set (map identity a))]
    (remove #(contains? index-set (identity %)) b)))

(defn conflicted-entries [db-entries entries]
  (let [b-index (group-by :youtube-id entries)]
    (keep (fn [{:keys [youtube-id] :as x}]
            (if-let [y (some-> b-index (get youtube-id) first)]
              (if (not= (dissoc x :id) y)
                {:new y
                 :old x}))) db-entries)))

(defn reconcile-lessons [db-lessons lessons]
  (let [db-lessons (filter #(= :lesson (:type %)) db-lessons)]
    {:add    (detect-added-by :youtube-id db-lessons lessons)
     :update (conflicted-entries db-lessons lessons)
     :remove (detect-added-by :youtube-id lessons db-lessons)}))

(defn playlist->topic [playlist-id]
  (let [{:keys [title lessons] :as topic} (yt/topic-from-playlist youtube-key playlist-id)
        db-lessons (db/topic-lessons title)]
    (reconcile-lessons db-lessons lessons)))
