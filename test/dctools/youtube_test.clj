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
    (is (= (playlist-video-ids youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           "aDutr6g8SeY,nVkeCH3GA9s,hPou3ube_Rg,WESQHuwOizM"))))

(deftest test-raw-playlist-items
  (vcr :fetch-playlist-items
    (is (= (raw-playlist-items youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           fx/youtube-pitch-playlist-items))))

(deftest test-get-playlist
  (vcr :get-playlist
    (is (= (get-playlist youtube-key "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj")
           fx/pitch-playlist-with-items))))
