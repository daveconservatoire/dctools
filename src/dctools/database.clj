(ns dctools.database
  (:require [yesql.core :refer [defqueries]]))

(def type-map
  {"l" :lesson
   "p" :playlist
   "e" :exercice})

(def ^:dynamic *db-settings* {})

(defqueries "queries.sql")

(defn parse-lesson [row]
  {:type        (get type-map (get row :filetype))
   :id          (get row :id)
   :description (get row :description)
   :keywords    (get row :keywords)
   :title       (get row :title)
   :url-title   (get row :urltitle)
   :youtube-id  (get row :youtubeid)})

(defn topic-by-title [title]
  (first (sql-topic-by-title {:title title} {:connection *db-settings*})))

(defn topic-lessons [title]
  (->> (sql-topic-lessons {:title title} {:connection *db-settings*})
       (map parse-lesson)))

(defn playlist-items []
  (sql-playlist-items {} {:connection *db-settings*}))
