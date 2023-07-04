SELECT name
FROM
    customer
WHERE
    ifnull( referee_id, 0 ) != 2