(ns dctools.database
  (:require [yesql.core :refer [defqueries]]))

(def type-map
  {"l" :lesson
   "p" :playlist
   "e" :exercice})

(defqueries "queries.sql"
  {:connection {:subprotocol "mysql"
                :subname     "//127.0.0.1:8889/dcsite?zeroDateTimeBehavior=convertToNull"
                :user        "root"
                :password    "root"}})

(defn parse-lesson [row]
  {:type        (get type-map (get row :filetype))
   :id          (get row :id)
   :description (get row :description)
   :keywords    (get row :keywords)
   :title       (get row :title)
   :url-title   (get row :urltitle)
   :youtube-id  (get row :youtubeid)})

(defn topic-lessons [title]
  (->> (sql-topic-lessons {:title title})
       (map parse-lesson)))
