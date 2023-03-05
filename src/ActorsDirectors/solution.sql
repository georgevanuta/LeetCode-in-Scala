-- https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/
SELECT actor_id, director_id
FROM
(
    SELECT actor_id, director_id, COUNT(*) AS NR
    FROM ActorDirector
    GROUP BY (actor_id, director_id)
)
WHERE NR >= 3;