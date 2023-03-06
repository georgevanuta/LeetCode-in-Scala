-- https://leetcode.com/problems/second-highest-salary/solutions/
SELECT MAX(salary) As "SecondHighestSalary"
FROM
(
    SELECT salary
    FROM Employee
    WHERE salary < (SELECT MAX(salary) FROM Employee)
)