(ns dctools.database
  (:require [yesql.core :refer [defqueries]]))

(defqueries "queries.sql"
  {:connection {:subprotocol "mysql"
                :subname "//127.0.0.1:8889/dcsite"
                :user "root"
                :password "root"}})
