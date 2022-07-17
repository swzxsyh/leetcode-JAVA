SELECT employee_id
FROM (SELECT employee_id
      FROM Employees

      UNION ALL

      SELECT employee_id
      FROM Salaries) AS temp
group by employee_id
having COUNT(employee_id) = 1

ORDER BY employee_id ASC