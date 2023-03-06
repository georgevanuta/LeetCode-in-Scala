-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/description/
SELECT customer_number
FROM
(
    SELECT customer_number, COUNT(*) as nr
    FROM Orders
    GROUP BY customer_number
)
WHERE nr = (SELECT MAX(con) FROM (SELECT COUNT(*) as con FROM Orders GROUP BY customer_number))