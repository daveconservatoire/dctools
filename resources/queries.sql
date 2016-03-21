-- name: sql-get-courses
SELECT *
FROM Course
ORDER BY title;

-- name: sql-topic-by-title
SELECT *
FROM Topic
WHERE title = :title;

-- name: sql-topic-lessons
SELECT Lesson.*
FROM Lesson
LEFT JOIN Topic ON Lesson.topicno = Topic.id
WHERE Topic.title = :title;

-- name: sql-playlist-items
SELECT PlaylistItem.*
FROM PlaylistItem
ORDER BY id
