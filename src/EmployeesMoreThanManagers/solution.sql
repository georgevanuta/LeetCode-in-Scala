-- https://leetcode.com/problems/employees-earning-more-than-their-managers/description/
SELECT "Employee"
FROM
(
    SELECT
        a.name AS "Manager", a.salary AS "ManagerSalary", b.name AS "Employee", b.salary AS "EmployeeSalary"
    FROM Employee a
    INNER JOIN Employee b
    ON a.id = b.managerId
)
WHERE "EmployeeSalary" > "ManagerSalary"