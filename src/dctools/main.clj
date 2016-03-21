(ns dctools.main
  (:require [clojure.edn :as edn]
            [dctools.database :as db]
            [dctools.youtube :as yt]))

(def credentials (edn/read-string (slurp "credentials.edn")))
(def db-credentials (get credentials :database))
(def youtube-key (get-in credentials [:youtube :api-key]))

(defn check-missing-videos []
  (binding [db/*db-settings* db-credentials]
    (let [playlist-items (db/playlist-items)
          missing-ids (yt/get-missing-videos youtube-key (map :youtubeid playlist-items))]
      missing-ids)))
