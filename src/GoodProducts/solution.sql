-- https://leetcode.com/problems/recyclable-and-low-fat-products/description/
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';