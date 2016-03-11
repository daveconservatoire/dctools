(ns dctools.core-test
  (:require [clojure.test :refer :all]
            [dctools.core :refer :all]
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
           {:add    []
            :update []
            :remove []})))

  (testing "new data"
    (is (= (reconcile-lessons []
                              [pitch-and-octaves])
           {:add    [pitch-and-octaves]
            :update []
            :remove []})))

  (testing "don't add when it's already present"
    (is (= (reconcile-lessons [(assoc pitch-and-octaves
                                 :id "123")]
                              [pitch-and-octaves])
           {:add    []
            :update []
            :remove []})))

  (testing "updating"
    (let [updated-lesson (assoc pitch-and-octaves
                           :title "New Title")]
      (is (= (reconcile-lessons [pitch-and-octaves]
                                [updated-lesson])
             {:add    []
              :update [{:new updated-lesson
                        :old pitch-and-octaves}]
              :remove []}))))

  (testing "removing"
    (is (= (reconcile-lessons [pitch-and-octaves]
                              [])
           {:add    []
            :update []
            :remove [pitch-and-octaves]})))

  (testing "discard non-lessons"
    (is (= (reconcile-lessons [{}]
                              [])
           {:add    []
            :update []
            :remove []}))))
