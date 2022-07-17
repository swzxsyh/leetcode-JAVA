SELECT employee_id,
       IF(MOD(employee_id, 2) <> 0 AND LEFT (name,1)!='M', salary, 0) AS bonus
FROM Employees
ORDER BY employee_id