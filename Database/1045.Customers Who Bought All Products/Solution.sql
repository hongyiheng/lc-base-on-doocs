# Write your MySQL query statement below
SELECT
	customer_id
FROM
	Customer
GROUP BY
	customer_id
HAVING
	count(DISTINCT(product_key)) = (select count(0) from Product)