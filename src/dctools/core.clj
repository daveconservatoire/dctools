(ns dctools.core
  (:require [dctools.youtube :as yt]
            [dctools.database :as db]
            [clojure.edn :as edn]))

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
    (concat
      (map (partial vector :add) (detect-added-by :youtube-id db-lessons lessons))
      (map (partial vector :update) (conflicted-entries db-lessons lessons))
      (map (partial vector :remove) (detect-added-by :youtube-id lessons db-lessons)))))

(defn import-topic [{:keys [title lessons] :as topic}]
  (let [{:keys [id]} (db/topic-by-title title)
        db-lessons (db/topic-lessons title)]
    (cond-> (reconcile-lessons db-lessons lessons)
      (not id) (conj [:create-topic title]))))
