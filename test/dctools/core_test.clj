(ns dctools.core-test
  (:require [clojure.test :refer :all]
            [dctools.core :refer :all]
            [dctools.fixtures :as fx]))

(deftest test-youtube-video->lesson
  (is (= (youtube-video->lesson (-> fx/youtube-pitch-playlist-items first))
         fx/lesson-pitch-octaves)))

(deftest test-youtube-playlist->topic
  (is (= (youtube-playlist->topic fx/pitch-playlist-with-items)
         fx/pitch-topic)))
