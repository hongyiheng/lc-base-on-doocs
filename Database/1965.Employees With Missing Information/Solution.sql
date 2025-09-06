# Write your MySQL query statement below
SELECT
    employee_id
FROM
    ( SELECT employee_id FROM Employees UNION ALL SELECT employee_id FROM Salaries ) t
GROUP BY
    employee_id
HAVING
        count( 0 ) = 1
ORDER BY
    employee_id