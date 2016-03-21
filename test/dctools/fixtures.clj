(ns dctools.fixtures
  (:require [dctools.database :as db]))

(def db-settings
  {:subprotocol "mysql"
   :subname     "//127.0.0.1:8889/dcsite?zeroDateTimeBehavior=convertToNull"
   :user        "root"
   :password    "root"})

(def youtube-pitch-playlist
  {:etag     "\"q5k97EMVGxODeKcDgp8gnMu79wM/4eh4SMi7riOvCsFNLaan3yQ2vmw\""
   :items    [{:contentDetails {:itemCount 4}
               :etag           "\"q5k97EMVGxODeKcDgp8gnMu79wM/nT9TShGjOz3cvtXOOVBRE6Y4IP4\""
               :id             "PLaitaNxyd8SGtC20Xi6eo-Rpka3XcIFwj"
               :kind           "youtube#playlist"
               :snippet        {:channelId    "UCAeRP44QtKybmsR7oNbmR0g"
                                :channelTitle "Dave Conservatoire"
                                :description  ""
                                :localized    {:description ""
                                               :title       "Pitch"}
                                :publishedAt  "2016-01-08T15:44:36.000Z"
                                :thumbnails   {:default  {:height 90
                                                          :url    "https://i.ytimg.com/vi/aDutr6g8SeY/default.jpg"
                                                          :width  120}
                                               :high     {:height 360
                                                          :url    "https://i.ytimg.com/vi/aDutr6g8SeY/hqdefault.jpg"
                                                          :width  480}
                                               :maxres   {:height 720
                                                          :url    "https://i.ytimg.com/vi/aDutr6g8SeY/maxresdefault.jpg"
                                                          :width  1280}
                                               :medium   {:height 180
                                                          :url    "https://i.ytimg.com/vi/aDutr6g8SeY/mqdefault.jpg"
                                                          :width  320}
                                               :standard {:height 480
                                                          :url    "https://i.ytimg.com/vi/aDutr6g8SeY/sddefault.jpg"
                                                          :width  640}}
                                :title        "Pitch"}
               :status         {:privacyStatus "public"}}]
   :kind     "youtube#playlistListResponse"
   :pageInfo {:resultsPerPage 5
              :totalResults   1}})

(def youtube-pitch-playlist-items
  [{:etag    "\"q5k97EMVGxODeKcDgp8gnMu79wM/lw7FygOaJeAAEaEC5TUEUnozQXw\""
    :id      "aDutr6g8SeY"
    :kind    "youtube#video"
    :snippet {:categoryId           "27"
              :channelId            "UCAeRP44QtKybmsR7oNbmR0g"
              :channelTitle         "Dave Conservatoire"
              :description          "Pitch refers to how high or low a sound is.  We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  

All sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  

If we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  

Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :liveBroadcastContent "none"
              :localized            {:description "Pitch refers to how high or low a sound is.  We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  

All sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  

If we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  

Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
                                     :title       "Pitch and Octaves"}
              :publishedAt          "2012-02-08T21:07:19.000Z"
              :tags                 ["pitch"
                                     "frequency"
                                     "what is pitch"
                                     "octaves"
                                     "octave"
                                     "octave relationship"
                                     "music theory"
                                     "music"
                                     "online music lessons"]
              :thumbnails           {:default  {:height 90
                                                :url    "https://i.ytimg.com/vi/aDutr6g8SeY/default.jpg"
                                                :width  120}
                                     :high     {:height 360
                                                :url    "https://i.ytimg.com/vi/aDutr6g8SeY/hqdefault.jpg"
                                                :width  480}
                                     :maxres   {:height 720
                                                :url    "https://i.ytimg.com/vi/aDutr6g8SeY/maxresdefault.jpg"
                                                :width  1280}
                                     :medium   {:height 180
                                                :url    "https://i.ytimg.com/vi/aDutr6g8SeY/mqdefault.jpg"
                                                :width  320}
                                     :standard {:height 480
                                                :url    "https://i.ytimg.com/vi/aDutr6g8SeY/sddefault.jpg"
                                                :width  640}}
              :title                "Pitch and Octaves"}}
   {:etag    "\"q5k97EMVGxODeKcDgp8gnMu79wM/KHllfVCKmZ__UFfoncTa-fwmt-A\""
    :id      "nVkeCH3GA9s"
    :kind    "youtube#video"
    :snippet {:categoryId           "27"
              :channelId            "UCAeRP44QtKybmsR7oNbmR0g"
              :channelTitle         "Dave Conservatoire"
              :description          "In Western music, we split the octave up into 12 different pitches.  These twelve pitches are used to create almost all of our music.  

One of the best ways to learn about how we think about these twelve pitches is to look at the piano keyboard where they are clearly laid out for us.  

The first thing you might notice is that the white and black keys follow a certain pattern and this helps us to understand how the 12 basic pitches are organised.  The white notes on the piano are named after the first seven letters of the alphabet - A B C D E F G.  

The black notes fill in the pitches between these letter named notes.  We talk about these notes as being - flats and sharps.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :liveBroadcastContent "none"
              :localized            {:description "In Western music, we split the octave up into 12 different pitches.  These twelve pitches are used to create almost all of our music.  

One of the best ways to learn about how we think about these twelve pitches is to look at the piano keyboard where they are clearly laid out for us.  

The first thing you might notice is that the white and black keys follow a certain pattern and this helps us to understand how the 12 basic pitches are organised.  The white notes on the piano are named after the first seven letters of the alphabet - A B C D E F G.  

The black notes fill in the pitches between these letter named notes.  We talk about these notes as being - flats and sharps.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
                                     :title       "The 12 Pitches"}
              :publishedAt          "2012-02-08T23:17:54.000Z"
              :tags                 ["note names"
                                     "letter names for music notes"
                                     "piano keyboard"
                                     "piano layout"
                                     "music theory"
                                     "music"
                                     "online music lessons"]
              :thumbnails           {:default  {:height 90
                                                :url    "https://i.ytimg.com/vi/nVkeCH3GA9s/default.jpg"
                                                :width  120}
                                     :high     {:height 360
                                                :url    "https://i.ytimg.com/vi/nVkeCH3GA9s/hqdefault.jpg"
                                                :width  480}
                                     :maxres   {:height 720
                                                :url    "https://i.ytimg.com/vi/nVkeCH3GA9s/maxresdefault.jpg"
                                                :width  1280}
                                     :medium   {:height 180
                                                :url    "https://i.ytimg.com/vi/nVkeCH3GA9s/mqdefault.jpg"
                                                :width  320}
                                     :standard {:height 480
                                                :url    "https://i.ytimg.com/vi/nVkeCH3GA9s/sddefault.jpg"
                                                :width  640}}
              :title                "The 12 Pitches"}}
   {:etag    "\"q5k97EMVGxODeKcDgp8gnMu79wM/9d3VajCkLdFZGbII1WJO2HcUW8g\""
    :id      "hPou3ube_Rg"
    :kind    "youtube#video"
    :snippet {:categoryId           "27"
              :channelId            "UCAeRP44QtKybmsR7oNbmR0g"
              :channelTitle         "Dave Conservatoire"
              :description          "A useful way to measure pitch is to work out how far apart two notes are in terms of their pitch. 

We already know about octaves as one measure of pitch, but what about for smaller steps up and down in pitch. 

To measure these distances we can talk about tones and semitones.  On a keyboard instrument like a piano or organ each of the keys is one semitone apart.  The distance between C and C#, for example, is one semitone.  

A tone is simply a distance in pitch of two tones.  F to G, for example is a distance of a tone.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :liveBroadcastContent "none"
              :localized            {:description "A useful way to measure pitch is to work out how far apart two notes are in terms of their pitch. 

We already know about octaves as one measure of pitch, but what about for smaller steps up and down in pitch. 

To measure these distances we can talk about tones and semitones.  On a keyboard instrument like a piano or organ each of the keys is one semitone apart.  The distance between C and C#, for example, is one semitone.  

A tone is simply a distance in pitch of two tones.  F to G, for example is a distance of a tone.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
                                     :title       "Tones and Semitones"}
              :publishedAt          "2012-02-10T23:58:31.000Z"
              :tags                 ["tones"
                                     "semitones"
                                     "pitch"
                                     "interval"
                                     "interval recognition"
                                     "music theory"
                                     "music"
                                     "online music lessons"]
              :thumbnails           {:default  {:height 90
                                                :url    "https://i.ytimg.com/vi/hPou3ube_Rg/default.jpg"
                                                :width  120}
                                     :high     {:height 360
                                                :url    "https://i.ytimg.com/vi/hPou3ube_Rg/hqdefault.jpg"
                                                :width  480}
                                     :maxres   {:height 720
                                                :url    "https://i.ytimg.com/vi/hPou3ube_Rg/maxresdefault.jpg"
                                                :width  1280}
                                     :medium   {:height 180
                                                :url    "https://i.ytimg.com/vi/hPou3ube_Rg/mqdefault.jpg"
                                                :width  320}
                                     :standard {:height 480
                                                :url    "https://i.ytimg.com/vi/hPou3ube_Rg/sddefault.jpg"
                                                :width  640}}
              :title                "Tones and Semitones"}}
   {:etag    "\"q5k97EMVGxODeKcDgp8gnMu79wM/n1WgCYgEznYDjrWJqNDS_AZ6adQ\""
    :id      "WESQHuwOizM"
    :kind    "youtube#video"
    :snippet {:categoryId           "27"
              :channelId            "UCAeRP44QtKybmsR7oNbmR0g"
              :channelTitle         "Dave Conservatoire"
              :description          "Melody is such a central element of almost all music.  I probably don't even need to explain what a melody is, you probably already know. 

A melody is a series of notes brought together in a particular rhythm to produce a memorable tune. 

The melody is perhaps the most important element of any piece of music and so composers spend a lot of time thinking up the best melodies they can.

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :liveBroadcastContent "none"
              :localized            {:description "Melody is such a central element of almost all music.  I probably don't even need to explain what a melody is, you probably already know. 

A melody is a series of notes brought together in a particular rhythm to produce a memorable tune. 

The melody is perhaps the most important element of any piece of music and so composers spend a lot of time thinking up the best melodies they can.

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
                                     :title       "Introducing Melody"}
              :publishedAt          "2012-04-13T13:53:10.000Z"
              :tags                 ["melody"
                                     "tune"
                                     "air"
                                     "composition"
                                     "music theory"
                                     "music"
                                     "online music lessons"]
              :thumbnails           {:default  {:height 90
                                                :url    "https://i.ytimg.com/vi/WESQHuwOizM/default.jpg"
                                                :width  120}
                                     :high     {:height 360
                                                :url    "https://i.ytimg.com/vi/WESQHuwOizM/hqdefault.jpg"
                                                :width  480}
                                     :maxres   {:height 720
                                                :url    "https://i.ytimg.com/vi/WESQHuwOizM/maxresdefault.jpg"
                                                :width  1280}
                                     :medium   {:height 180
                                                :url    "https://i.ytimg.com/vi/WESQHuwOizM/mqdefault.jpg"
                                                :width  320}
                                     :standard {:height 480
                                                :url    "https://i.ytimg.com/vi/WESQHuwOizM/sddefault.jpg"
                                                :width  640}}
              :title                "Introducing Melody"}}])

(def pitch-playlist-with-items
  (-> youtube-pitch-playlist :items first
      (assoc :items youtube-pitch-playlist-items)))

(def lesson-pitch-octaves
  {:description "Pitch refers to how high or low a sound is.  We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  

All sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  

If we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  

Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
   :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship, music theory, music, online music lessons"
   :title       "Pitch and Octaves"
   :type        :lesson
   :url-title   "pitch-and-octaves"
   :youtube-id  "aDutr6g8SeY"})

(def database-example
  {:type :course
   :title "Music: A Beginner's Guide"
   :topics [{:type :topic
             :title "Getting Started"
             :lessons [{:type :lesson
                        :title "Getting Started"}]}

            {:type :topic
             :title "Pitch"
             :lessons [{:type :lesson
                        :youtube-id "aDutr6g8SeY"
                        :title "Pitch and Octaves"
                        :description "Pitch refers to how high or low a sound is. We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  \n\nAll sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  \n\nIf we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  \n\n\n"
                        :keywords "pitch, frequency, what is pitch, octaves, octave, octave relationship"
                        :url-title "pitch-and-octaves"}]}]})

(def pitch-topic
  {:lessons [{:description "Pitch refers to how high or low a sound is.  We have a good sense of what high and low pitched sound are, even if we've not spoken about them in this way.  

All sounds are created when an object vibrates and the pitch of a sound depends on the pitch of this vibration.  The faster the vibration the higher in pitch the sound.  

If we double the speed of vibration (or frequency) of a sound then something interesting happens.  The two pitches will sound similar and will blend together well.  This special relationship is known as an octave and is a central part of almost all music around the world.  

Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :keywords    "pitch, frequency, what is pitch, octaves, octave, octave relationship, music theory, music, online music lessons"
              :title       "Pitch and Octaves"
              :type        :lesson
              :url-title   "pitch-and-octaves"
              :youtube-id  "aDutr6g8SeY"}
             {:description "In Western music, we split the octave up into 12 different pitches.  These twelve pitches are used to create almost all of our music.  

One of the best ways to learn about how we think about these twelve pitches is to look at the piano keyboard where they are clearly laid out for us.  

The first thing you might notice is that the white and black keys follow a certain pattern and this helps us to understand how the 12 basic pitches are organised.  The white notes on the piano are named after the first seven letters of the alphabet - A B C D E F G.  

The black notes fill in the pitches between these letter named notes.  We talk about these notes as being - flats and sharps.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :keywords    "note names, letter names for music notes, piano keyboard, piano layout, music theory, music, online music lessons"
              :title       "The 12 Pitches"
              :type        :lesson
              :url-title   "the-12-pitches"
              :youtube-id  "nVkeCH3GA9s"}
             {:description "A useful way to measure pitch is to work out how far apart two notes are in terms of their pitch. 

We already know about octaves as one measure of pitch, but what about for smaller steps up and down in pitch. 

To measure these distances we can talk about tones and semitones.  On a keyboard instrument like a piano or organ each of the keys is one semitone apart.  The distance between C and C#, for example, is one semitone.  

A tone is simply a distance in pitch of two tones.  F to G, for example is a distance of a tone.  

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :keywords    "tones, semitones, pitch, interval, interval recognition, music theory, music, online music lessons"
              :title       "Tones and Semitones"
              :type        :lesson
              :url-title   "tones-and-semitones"
              :youtube-id  "hPou3ube_Rg"}
             {:description "Melody is such a central element of almost all music.  I probably don't even need to explain what a melody is, you probably already know. 

A melody is a series of notes brought together in a particular rhythm to produce a memorable tune. 

The melody is perhaps the most important element of any piece of music and so composers spend a lot of time thinking up the best melodies they can.

 Visit http://www.daveconservatoire.org to watch hundreds of free video music lessons just like this one and complete interactive exercises to practice your skills!"
              :keywords    "melody, tune, air, composition, music theory, music, online music lessons"
              :title       "Introducing Melody"
              :type        :lesson
              :url-title   "introducing-melody"
              :youtube-id  "WESQHuwOizM"}]
   :title   "Pitch"
   :type    :topic})

(def db-courses
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
    :urltitle       "reading-music"}])

(def db-pitch-topic
  {:colour    "#000000"
   :courseid  7
   :id        3
   :sortorder 2
   :title     "Pitch"
   :urltitle  "pitch"})

(def db-pitch-lessons
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
    :youtubeid   "aDutr6g8SeY"}])

(def db-pitch-lessons-normalized (map db/parse-lesson db-pitch-lessons))
