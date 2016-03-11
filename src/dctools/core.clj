(ns dctools.core
  (:require [dctools.youtube :as yt]
            [clojure.edn :as edn]))

(def credentials (edn/read-string (slurp "credentials.edn")))
(def youtube-key (get-in credentials [:youtube :api-key]))

(defn playlist->topic [playlist-id]
  (yt/topic-from-playlist youtube-key playlist-id))
