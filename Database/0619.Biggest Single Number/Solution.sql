SELECT (
           SELECT
               num
           FROM
               MyNumbers
           GROUP BY
               num
           HAVING
                count( 0 ) = 1
           ORDER BY num DESC
           LIMIT 1
) AS num