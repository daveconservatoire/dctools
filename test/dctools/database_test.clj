(ns dctools.database-test
  (:require [clojure.test :refer :all]
            [dctools.database :refer :all]
            [dctools.fixtures :as fx]))

(deftest test-sql-get-courses
  (is (= (sql-get-courses {} {:connection fx/db-settings})
         fx/db-courses)))

(deftest test-sql-topic-by-title
  (binding [*db-settings* fx/db-settings]
    (is (= (topic-by-title "Pitch")
           fx/db-pitch-topic))

    (is (nil? (topic-by-title "Invalid")))))

(deftest test-sql-topic-lessons
  (is (= (->> (sql-topic-lessons {:title "Pitch"} {:connection fx/db-settings})
              (take 2))
         fx/db-pitch-lessons)))

(deftest test-sql-playlist-items
  (binding [*db-settings* fx/db-settings]
    (is (= (take 5 (playlist-items))
           fx/db-playlist-items))))

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
