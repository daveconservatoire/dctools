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

(deftest test-sql-topic-by-title
  (is (= (sql-topic-by-title {:title "Pitch"})
         [{:colour    "#000000"
           :courseid  7
           :id        3
           :sortorder 2
           :title     "Pitch"
           :urltitle  "pitch"}])))

(deftest test-sql-topic-lessons
  (is (= (->> (sql-topic-lessons {:title "Pitch"})
              (take 2))
         [{:description ""
           :filetype    "p"
           :id          42
           :keywords    ""
           :lessonno    9
           :seriesno    7
           :timestamp   nil
           :title       "Pitch Playlist"
           :topicno     3
           :urltitle    "pitch-playlist"
           :youtubeid   ""}
          {:description "Pitch refers to how high or low a sound is.  We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  \r
\r
All sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  \r
\r
If we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  \r
\r
\r
"
           :filetype    "l"
           :id          88
           :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship"
           :lessonno    3
           :seriesno    7
           :timestamp   nil
           :title       "Pitch and Octaves"
           :topicno     3
           :urltitle    "pitch-and-octaves"
           :youtubeid   "aDutr6g8SeY"}])))
