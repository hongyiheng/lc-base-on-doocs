SELECT
    score,
    dense_rank() over ( ORDER BY score DESC ) AS "rank"
FROM
    Scores