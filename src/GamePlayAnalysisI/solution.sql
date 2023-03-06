-- https://leetcode.com/problems/game-play-analysis-i/description/
SELECT player_id as "player_id", TO_CHAR(MIN(event_date), 'YYYY-MM-DD') as "first_login"
FROM Activity
GROUP BY player_id