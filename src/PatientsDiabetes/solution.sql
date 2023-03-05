-- https://leetcode.com/problems/patients-with-a-condition/description/
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE REGEXP_LIKE (conditions, '(\s|^)DIAB1.*(\s|$)');