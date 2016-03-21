(ns dctools.core-test
  (:require [clojure.test :refer :all]
            [dctools.core :refer :all]
            [dctools.database :as db]
            [dctools.fixtures :as fx]))

(def pitch-and-octaves
  {:description "Pitch refers to how high or low a sound is."
   :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship"
   :title       "Pitch and Octaves"
   :type        :lesson
   :url-title   "pitch-and-octaves"
   :youtube-id  "aDutr6g8SeY"})

(deftest test-reconciliate
  (testing "blank case"
    (is (= (reconcile-lessons []
                              [])
           [])))

  (testing "new data"
    (is (= (reconcile-lessons []
                              [pitch-and-octaves])
           [[:add pitch-and-octaves]])))

  (testing "don't add when it's already present"
    (is (= (reconcile-lessons [(assoc pitch-and-octaves
                                 :id "123")]
                              [pitch-and-octaves])
           [])))

  (testing "updating"
    (let [updated-lesson (assoc pitch-and-octaves
                           :title "New Title")]
      (is (= (reconcile-lessons [pitch-and-octaves]
                                [updated-lesson])
             [[:update {:new updated-lesson
                        :old pitch-and-octaves}]]))))

  (testing "removing"
    (is (= (reconcile-lessons [pitch-and-octaves]
                              [])
           [[:remove pitch-and-octaves]])))

  (testing "discard non-lessons"
    (is (= (reconcile-lessons [{}]
                              [])
           []))))

(deftest test-import-topic
  (binding [db/*db-settings* fx/db-settings]
    (is (= (->> (import-topic fx/pitch-topic)
                (map first))
           [:update :update :update :update]))

    (let [response (import-topic (assoc fx/pitch-topic :title "Another"))]
      (is (= (first response) [:create-topic "Another"]))
      (is (= (map first response)
             [:create-topic :add :add :add :add])))))
