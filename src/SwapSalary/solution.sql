-- https://leetcode.com/problems/swap-salary/
UPDATE Salary
SET sex = CASE WHEN sex = 'f' THEN 'm'
               WHEN sex = 'm' THEN 'f'
          END
