(ns dctools.youtube-test
  (:require [clojure.test :refer :all]
            [clojure.edn :as edn]
            [vcr-clj.core :refer [with-cassette]]
            [dctools.youtube :refer :all]
            [dctools.fixtures :as fx]))

(defmacro vcr [name & body]
  `(with-cassette ~name [{:var #'dctools.youtube/http-get}]
     ~@body))

(def credentials (edn/read-string (slurp "credentials.edn")))

(def youtube-key (get-in credentials [:youtube :api-key]))

(deftest test-raw-playlist
  (vcr :playlist
    (is (= (raw-playlist youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           (-> fx/youtube-pitch-playlist :items first)))))

(deftest test-playlist-video-ids
  (vcr :playlist-video-ids
    (is (= (get-playlist-video-ids youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           "aDutr6g8SeY,nVkeCH3GA9s,hPou3ube_Rg,WESQHuwOizM"))))

(deftest test-raw-playlist-items
  (vcr :fetch-playlist-items
    (is (= (raw-playlist-items youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           fx/youtube-pitch-playlist-items))))

(deftest test-get-playlist
  (vcr :get-playlist
    (is (= (get-playlist youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           fx/pitch-playlist-with-items))))

(deftest test-youtube-video->lesson
  (is (= (youtube-video->lesson (-> fx/youtube-pitch-playlist-items first))
         fx/lesson-pitch-octaves)))

(deftest test-youtube-playlist->topic
  (is (= (youtube-playlist->topic fx/pitch-playlist-with-items)
         fx/pitch-topic)))

(deftest test-get-missing-videos
  (vcr :get-missing-videos
    (is (= (get-missing-videos youtube-key ["oyLfCPNf_hE" "tBZ8o0Kiz6w" "qj9QlWltv8s" "0UjsXo9l6I8" "N-dzfI3L5ic"])
           #{"0UjsXo9l6I8"}))))
