-- https://leetcode.com/problems/the-latest-login-in-2020/description/
SELECT user_id, MAX(time_stamp) AS last_stamp
FROM
(
    SELECT *
    FROM Logins
    WHERE REGEXP_LIKE (time_stamp, '^2020.*')
)
GROUP BY user_id;