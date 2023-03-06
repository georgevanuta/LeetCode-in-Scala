-- https://leetcode.com/problems/customers-who-never-order/description/
SELECT name as "Customers"
FROM
(
    SELECT name, customerId
    FROM Customers
    LEFT JOIN Orders
    ON Customers.id = Orders.customerId
)
WHERE customerId IS NULL