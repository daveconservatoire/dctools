(ns dctools.main
  (:require [clojure.edn :as edn]
            [dctools.database :as db]
            [dctools.youtube :as yt]
            [clojure.pprint :refer [pprint]]
            [clojure.tools.cli :refer [parse-opts]]))

(def credentials (edn/read-string (slurp "credentials.edn")))
(def db-credentials (get credentials :database))
(def youtube-key (get-in credentials [:youtube :api-key]))

(defn check-missing-videos []
  (let [playlist-items (db/playlist-items)
        missing-ids (yt/get-missing-videos youtube-key (map :youtubeid playlist-items))]
    (filter #(missing-ids (:youtubeid %)) playlist-items)))

(defmulti run-command (fn [cmd & _] (keyword cmd)))

(defmethod run-command :check-missing-videos
  [& _]
  (pprint (check-missing-videos)))

(defmethod run-command :default
  [cmd & _]
  (println "Command" cmd "is not a valid command"))

(defn -main [& [cmd & args]]
  (binding [db/*db-settings* db-credentials]
    (run-command cmd args)))
