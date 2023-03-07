-- https://leetcode.com/problems/employees-with-missing-information/description/
SELECT
    CASE
        WHEN e1 IS NULL THEN e2
        ELSE e1
    END AS employee_id
FROM
(
    SELECT Salaries.employee_id as e1, Employees.employee_id as e2
    FROM Employees
    FULL OUTER JOIN Salaries
    ON Employees.employee_id = Salaries.employee_id
    WHERE
        name IS NULL OR
        salary is NULL
)
ORDER BY employee_id;