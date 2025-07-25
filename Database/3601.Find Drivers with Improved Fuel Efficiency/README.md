# [3601. 寻找燃油效率提升的驾驶员](https://leetcode.cn/problems/find-drivers-with-improved-fuel-efficiency)

## 题目描述

<!-- 这里写题目描述 -->

<p>表：<code>drivers</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| driver_id   | int     |
| driver_name | varchar |
+-------------+---------+
driver_id 是这张表的唯一主键。
每一行都包含一个司机的信息。
</pre>

<p>表：<code>trips</code></p>

<pre>
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| trip_id       | int     |
| driver_id     | int     |
| trip_date     | date    |
| distance_km   | decimal |
| fuel_consumed | decimal |
+---------------+---------+
trip_id 是这张表的唯一主键。
每一行表示一名司机完成的一次行程，包括该次行程行驶的距离和消耗的燃油量。
</pre>

<p>编写一个解决方案，通过 <strong>比较</strong> 司机在 <strong>上半年</strong> 和 <strong>下半年</strong> 的 <strong>平均燃油效率</strong> 来找出 <strong>燃油效率有所提高</strong> 的司机。</p>

<ul>
	<li>通过&nbsp;<code>distance_km / fuel_consumed</code>&nbsp;计算 <strong>每次</strong>&nbsp;行程的 <strong>燃油效率</strong>。</li>
	<li><strong>上半年：</strong>一月到六月，<strong>下半年：</strong>七月到十二月</li>
	<li>只包含在上半年和下半年都有行程的司机</li>
	<li>通过（<code>second_half_avg - first_half_avg</code>）计算 <strong>提升效率</strong>。</li>
	<li>将所有结果 <strong>四舍五入</strong> 到小数点后 <code>2</code>&nbsp;位</li>
</ul>

<p>返回结果表按提升效率&nbsp;<strong>降序</strong> 排列，然后按司机姓名 <strong>升序</strong> 排列。</p>

<p>结果格式如下所示。</p>

<p>&nbsp;</p>

<p><strong class="example">示例：</strong></p>

<div class="example-block">
<p><strong>输入：</strong></p>

<p>drivers 表：</p>

<pre class="example-io">
+-----------+---------------+
| driver_id | driver_name   |
+-----------+---------------+
| 1         | Alice Johnson |
| 2         | Bob Smith     |
| 3         | Carol Davis   |
| 4         | David Wilson  |
| 5         | Emma Brown    |
+-----------+---------------+
</pre>

<p>trips 表：</p>

<pre class="example-io">
+---------+-----------+------------+-------------+---------------+
| trip_id | driver_id | trip_date  | distance_km | fuel_consumed |
+---------+-----------+------------+-------------+---------------+
| 1       | 1         | 2023-02-15 | 120.5       | 10.2          |
| 2       | 1         | 2023-03-20 | 200.0       | 16.5          |
| 3       | 1         | 2023-08-10 | 150.0       | 11.0          |
| 4       | 1         | 2023-09-25 | 180.0       | 12.5          |
| 5       | 2         | 2023-01-10 | 100.0       | 9.0           |
| 6       | 2         | 2023-04-15 | 250.0       | 22.0          |
| 7       | 2         | 2023-10-05 | 200.0       | 15.0          |
| 8       | 3         | 2023-03-12 | 80.0        | 8.5           |
| 9       | 3         | 2023-05-18 | 90.0        | 9.2           |
| 10      | 4         | 2023-07-22 | 160.0       | 12.8          |
| 11      | 4         | 2023-11-30 | 140.0       | 11.0          |
| 12      | 5         | 2023-02-28 | 110.0       | 11.5          |
+---------+-----------+------------+-------------+---------------+
</pre>

<p><strong>输出：</strong></p>

<pre class="example-io">
+-----------+---------------+------------------+-------------------+------------------------+
| driver_id | driver_name   | first_half_avg   | second_half_avg   | efficiency_improvement |
+-----------+---------------+------------------+-------------------+------------------------+
| 2         | Bob Smith     | 11.24            | 13.33             | 2.10                   |
| 1         | Alice Johnson | 11.97            | 14.02             | 2.05                   |
+-----------+---------------+------------------+-------------------+------------------------+
</pre>

<p><strong>解释：</strong></p>

<ul>
	<li><strong>Alice Johnson (driver_id = 1):</strong>

	<ul>
		<li>上半年行程（一月到六月）：Feb 15 (120.5/10.2 = 11.81), Mar 20 (200.0/16.5 = 12.12)</li>
		<li>上半年平均效率：(11.81 + 12.12) / 2 = 11.97</li>
		<li>下半年行程（七月到十二月）：Aug 10 (150.0/11.0 = 13.64), Sep 25 (180.0/12.5 = 14.40)</li>
		<li>下半年平均效率：(13.64 + 14.40) / 2 = 14.02</li>
		<li>效率提升：14.02 - 11.97 = 2.05</li>
	</ul>
	</li>
	<li><strong>Bob Smith (driver_id = 2):</strong>
	<ul>
		<li>上半年行程：Jan 10 (100.0/9.0 = 11.11), Apr 15 (250.0/22.0 = 11.36)</li>
		<li>上半年平均效率：(11.11 + 11.36) / 2 = 11.24</li>
		<li>下半年行程：Oct 5 (200.0/15.0 = 13.33)</li>
		<li>下半年平均效率：13.33</li>
		<li>效率提升：13.33 - 11.24 = 2.10（舍入到 2 位小数）</li>
	</ul>
	</li>
	<li><strong>未包含的司机：</strong>
	<ul>
		<li>Carol Davis (driver_id = 3)：只有上半年的行程（三月，五月）</li>
		<li>David Wilson (driver_id = 4)：只有下半年的行程（七月，十一月）</li>
		<li>Emma Brown (driver_id = 5)：只有上半年的行程（二月）</li>
	</ul>
	</li>
</ul>

<p>输出表按提升效率降序排列，然后按司机名字升序排列。</p>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql

```

<!-- tabs:end -->
