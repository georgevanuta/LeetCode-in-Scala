-- https://leetcode.com/problems/duplicate-emails/description/
SELECT email
FROM
(
SELECT email, COUNT(*) as NR
FROM Person
GROUP BY email
)
WHERE NR > 1;
