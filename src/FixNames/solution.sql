-- https://leetcode.com/problems/fix-names-in-a-table/
SELECT user_id, INITCAP(name) AS name
FROM Users
ORDER BY user_id;