WITH t AS (
    SELECT
        LAG( num, 1 ) OVER ( ORDER BY Id ) AS a,
            num AS b,
        LEAD( num, 1 ) OVER ( ORDER BY Id ) AS c
    FROM
        logs
)
SELECT
    DISTINCT( a ) AS ConsecutiveNums
FROM
    t
WHERE
        a = b AND b = c