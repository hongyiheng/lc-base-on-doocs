# [570. 至少有5名直接下属的经理](https://leetcode-cn.com/problems/managers-with-at-least-5-direct-reports)



## 题目描述

<!-- 这里写题目描述 -->

<p><code>Employee</code> 表包含所有员工和他们的经理。每个员工都有一个 Id，并且还有一列是经理的 Id。</p>

<pre>+------+----------+-----------+----------+
|Id    |Name 	  |Department |ManagerId |
+------+----------+-----------+----------+
|101   |John 	  |A 	      |null      |
|102   |Dan 	  |A 	      |101       |
|103   |James 	  |A 	      |101       |
|104   |Amy 	  |A 	      |101       |
|105   |Anne 	  |A 	      |101       |
|106   |Ron 	  |B 	      |101       |
+------+----------+-----------+----------+
</pre>

<p>给定 <code>Employee</code> 表，请编写一个SQL查询来查找至少有5名直接下属的经理。对于上表，您的SQL查询应该返回：</p>

<pre>+-------+
| Name  |
+-------+
| John  |
+-------+
</pre>

<p><strong>注意:</strong><br>
没有人是自己的下属。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql
# Write your MySQL query statement below
SELECT 
	name 
FROM
	Employee 
WHERE
	id IN (
        SELECT
            managerId 
        FROM
            Employee 
        GROUP BY
            managerId 
        HAVING
            COUNT( 0 ) >= 5
    )
```

<!-- tabs:end -->
