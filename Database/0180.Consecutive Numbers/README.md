# [180. 连续出现的数字](https://leetcode-cn.com/problems/consecutive-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p>表：<code>Logs</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。</pre>

<p> </p>

<p>编写一个 SQL 查询，查找所有至少连续出现三次的数字。</p>

<p>返回的结果表中的数据可以按 <strong>任意顺序</strong> 排列。</p>

<p> </p>

<p>查询结果格式如下面的例子所示：</p>

<p> </p>

<pre>
Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+

Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
1 是唯一连续出现至少三次的数字。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql
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
```

<!-- tabs:end -->
