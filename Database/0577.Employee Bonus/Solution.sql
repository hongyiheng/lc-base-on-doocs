SELECT
    e.name,
    b.bonus
FROM
    Employee e
        LEFT JOIN Bonus b ON b.empId = e.empId
WHERE
        ifnull( bonus, 0 ) < 1000