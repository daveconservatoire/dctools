(ns dctools.database-test
  (:require [clojure.test :refer :all]
            [dctools.database :refer :all]))

(def db-settings
  {:subprotocol "mysql"
   :subname "//127.0.0.1:8889/dcsie"
   :user "root"
   :password "root"})

(deftest test-sql-get-courses
  (is (= (sql-get-courses)
         [{:author         "David Rees"
           :description    "Love music? Want to learn about how it works? This is the place to start!"
           :homepage_order 0
           :id             7
           :title          "Music:  A Beginner's Guide"
           :urltitle       "music-theory"}
          {:author         "David Rees"
           :description    "How can learning to read some lines and squiggles help me learn other people's music?  Find out here!"
           :homepage_order 0
           :id             4
           :title          "Reading Music"
           :urltitle       "reading-music"}])))
