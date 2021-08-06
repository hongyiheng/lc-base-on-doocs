# [1811. 寻找面试候选人](https://leetcode-cn.com/problems/find-interview-candidates)

[English Version](/solution/1800-1899/1811.Find%20Interview%20Candidates/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>表: <code>Contests</code></p>

<pre>
+--------------+------+
| Column Name  | Type |
+--------------+------+
| contest_id   | int  |
| gold_medal   | int  |
| silver_medal | int  |
| bronze_medal | int  |
+--------------+------+
contest_id 是该表的主键.
该表包含LeetCode竞赛的ID和该场比赛中金牌、银牌、铜牌的用户id。
可以保证，所有连续的比赛都有连续的ID，没有ID被跳过。

</pre>

<p>Table: <code>Users</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| user_id     | int     |
| mail        | varchar |
| name        | varchar |
+-------------+---------+
user_id 是该表的主键.
该表包含用户信息。</pre>

<p> </p>

<p>编写 SQL 语句来返回面试候选人的 <code>姓名</code>和 <code>邮件</code>.当用户满足以下两个要求中的任意一条，其成为面试候选人:</p>

<ul>
	<li>该用户在连续三场及更多比赛中赢得奖牌。</li>
	<li>该用户在三场及更多不同的比赛中赢得金牌（这些比赛可以不是连续的）</li>
</ul>

<p>可以以任何顺序返回结果。</p>

<p>查询结果格式如下例所示：</p>

<pre>
Contests表:
+------------+------------+--------------+--------------+
| contest_id | gold_medal | silver_medal | bronze_medal |
+------------+------------+--------------+--------------+
| 190        | 1          | 5            | 2            |
| 191        | 2          | 3            | 5            |
| 192        | 5          | 2            | 3            |
| 193        | 1          | 3            | 5            |
| 194        | 4          | 5            | 2            |
| 195        | 4          | 2            | 1            |
| 196        | 1          | 5            | 2            |
+------------+------------+--------------+--------------+

Users表:
+---------+--------------------+-------+
| user_id | mail               | name  |
+---------+--------------------+-------+
| 1       | sarah@leetcode.com | Sarah |
| 2       | bob@leetcode.com   | Bob   |
| 3       | alice@leetcode.com | Alice |
| 4       | hercy@leetcode.com | Hercy |
| 5       | quarz@leetcode.com | Quarz |
+---------+--------------------+-------+

结果表:
+-------+--------------------+
| name  | mail               |
+-------+--------------------+
| Sarah | sarah@leetcode.com |
| Bob   | bob@leetcode.com   |
| Alice | alice@leetcode.com |
| Quarz | quarz@leetcode.com |
+-------+--------------------+

Sarah 赢得了3块金牌 (190, 193, and 196),所以我们将她列入结果表。
Bob在连续3场竞赛中赢得了奖牌(190, 191, and 192), 所以我们将他列入结果表。
    - 注意他在另外的连续3场竞赛中也赢得了奖牌(194, 195, and 196).
Alice在连续3场竞赛中赢得了奖牌 (191, 192, and 193), 所以我们将她列入结果表。
Quarz在连续5场竞赛中赢得了奖牌(190, 191, 192, 193, and 194), 所以我们将他列入结果表。
</pre>

<p> </p>

<p><strong>进阶：</strong></p>

<ul>
	<li>如果第一个条件变成“该用户在连续n场及比赛中赢得任意奖牌。”呢？你如何更改你的解法，来选出面试候选人？可以把n想象成存储过程中的参数。</li>
	<li>有的用户可能没有参加每一场竞赛，但是在参加的每一场竞赛中都表现得不错。你如何更改你的解法，以达到只考虑那些<strong>用户参与了的</strong>比赛？可假设另一张表给出了每场比赛的注册用户信息。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql

```

<!-- tabs:end -->
