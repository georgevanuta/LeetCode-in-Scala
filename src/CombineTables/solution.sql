-- https://leetcode.com/problems/combine-two-tables/
SELECT firstName, lastName, city, state
FROM Person
LEFT OUTER JOIN Address
ON Person.personId = Address.personId; 