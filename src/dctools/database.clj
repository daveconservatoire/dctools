(ns dctools.database
  (:require [yesql.core :refer [defqueries]]))

(def type-map
  {"l" :lesson
   "p" :playlist
   "e" :exercice})

(defqueries "queries.sql"
  {:connection {:subprotocol "mysql"
                :subname "//127.0.0.1:8889/dcsite?zeroDateTimeBehavior=convertToNull"
                :user "root"
                :password "root"}})
