-- https://leetcode.com/problems/find-followers-count/description/
SELECT user_id, COUNT(*) AS followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id;