-- https://leetcode.com/problems/top-travellers/description/
WITH Aux AS
(
    SELECT id, SUM(distance) AS travelled_distance
    FROM
    (
        SELECT Users.id, name, NVL(distance, 0) as distance
        FROM Users
        LEFT OUTER JOIN Rides
        ON Users.id = Rides.user_id
    )
    GROUP BY id
)
SELECT name, travelled_distance
FROM Users
JOIN Aux
ON Users.id = Aux.id
ORDER BY travelled_distance DESC, name
