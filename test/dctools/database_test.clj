(ns dctools.database-test
  (:require [clojure.test :refer :all]
            [dctools.database :refer :all]
            [dctools.fixtures :as fx]))

(def db-settings
  {:subprotocol "mysql"
   :subname     "//127.0.0.1:8889/dcsie"
   :user        "root"
   :password    "root"})

(deftest test-sql-get-courses
  (is (= (sql-get-courses)
         fx/db-courses)))

(deftest test-sql-topic-by-title
  (is (= (sql-topic-by-title {:title "Pitch"})
         fx/db-pitch-topic)))

(deftest test-sql-topic-lessons
  (is (= (->> (sql-topic-lessons {:title "Pitch"})
              (take 2))
         fx/db-pitch-lessons)))

(deftest test-db->lesson
  (is (= (parse-lesson {:description "Pitch refers to how high or low a sound is."
                        :filetype    "l"
                        :id          88
                        :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship"
                        :lessonno    3
                        :seriesno    7
                        :timestamp   nil
                        :title       "Pitch and Octaves"
                        :topicno     3
                        :urltitle    "pitch-and-octaves"
                        :youtubeid   "aDutr6g8SeY"})

         {:id          88
          :description "Pitch refers to how high or low a sound is."
          :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship"
          :title       "Pitch and Octaves"
          :type        :lesson
          :url-title   "pitch-and-octaves"
          :youtube-id  "aDutr6g8SeY"})))
