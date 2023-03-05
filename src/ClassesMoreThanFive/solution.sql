-- https://leetcode.com/problems/classes-more-than-5-students/description/
SELECT class
FROM
(
SELECT class, COUNT(*) AS NR
FROM Courses
GROUP BY class
)
WHERE NR >= 5;
