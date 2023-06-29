SELECT
    (
        CASE
            WHEN MOD ( id, 2 ) = 1 AND ( SELECT count( 0 ) FROM Seat ) = id THEN id
            WHEN MOD ( id, 2 ) = 1 THEN id + 1 ELSE id - 1
            END
        ) AS id, student
FROM
    Seat
ORDER BY id