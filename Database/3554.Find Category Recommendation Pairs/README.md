# [3554. 查找类别推荐对](https://leetcode.cn/problems/find-category-recommendation-pairs)

## 题目描述

<!-- 这里写题目描述 -->

<p>表：<code>ProductPurchases</code></p>

<pre>
+-------------+------+
| Column Name | Type | 
+-------------+------+
| user_id     | int  |
| product_id  | int  |
| quantity    | int  |
+-------------+------+
(user_id, product_id) 是这张表的唯一主键。
每一行代表用户以特定数量购买的一种产品。
</pre>

<p>表：<code>ProductInfo</code></p>

<pre>
+-------------+---------+
| Column Name | Type    | 
+-------------+---------+
| product_id  | int     |
| category    | varchar |
| price       | decimal |
+-------------+---------+
product_id 是这张表的唯一主键。
每一行表示一件商品的类别和价格。
</pre>

<p>亚马逊想要了解不同产品类别的购物模式。编写一个解决方案：</p>

<ol>
	<li>查找所有 <strong>类别对</strong>（其中&nbsp;<code>category1</code> &lt; <code>category2</code>）</li>
	<li>对于 <strong>每个类别对</strong>，确定 <strong>同时</strong> 购买了两类别产品的 <strong>不同用户</strong> 数量</li>
</ol>

<p>如果至少有 <code>3</code> 个不同的客户购买了两个类别的产品，则类别对被视为 <strong>可报告的</strong>。</p>

<p>返回可报告类别对的结果表以<em>&nbsp;</em><strong>customer_count</strong><em>&nbsp;</em><strong>降序</strong><em> </em>排序，并且为了防止排序持平，以<em>&nbsp;</em><strong>category1 </strong>字典序<strong> 升序</strong>&nbsp;排序，然后以&nbsp;<strong>category2 升序</strong>&nbsp;排序。</p>

<p>结果格式如下所示。</p>

<p>&nbsp;</p>

<p><strong class="example">示例：</strong></p>

<div class="example-block">
<p><strong>输入：</strong></p>

<p>ProductPurchases 表：</p>

<pre class="example-io">
+---------+------------+----------+
| user_id | product_id | quantity |
+---------+------------+----------+
| 1       | 101        | 2        |
| 1       | 102        | 1        |
| 1       | 201        | 3        |
| 1       | 301        | 1        |
| 2       | 101        | 1        |
| 2       | 102        | 2        |
| 2       | 103        | 1        |
| 2       | 201        | 5        |
| 3       | 101        | 2        |
| 3       | 103        | 1        |
| 3       | 301        | 4        |
| 3       | 401        | 2        |
| 4       | 101        | 1        |
| 4       | 201        | 3        |
| 4       | 301        | 1        |
| 4       | 401        | 2        |
| 5       | 102        | 2        |
| 5       | 103        | 1        |
| 5       | 201        | 2        |
| 5       | 202        | 3        |
+---------+------------+----------+
</pre>

<p>ProductInfo 表：</p>

<pre class="example-io">
+------------+-------------+-------+
| product_id | category    | price |
+------------+-------------+-------+
| 101        | Electronics | 100   |
| 102        | Books       | 20    |
| 103        | Books       | 35    |
| 201        | Clothing    | 45    |
| 202        | Clothing    | 60    |
| 301        | Sports      | 75    |
| 401        | Kitchen     | 50    |
+------------+-------------+-------+
</pre>

<p><strong>输出：</strong></p>

<pre class="example-io">
+-------------+-------------+----------------+
| category1   | category2   | customer_count |
+-------------+-------------+----------------+
| Books       | Clothing    | 3              |
| Books       | Electronics | 3              |
| Clothing    | Electronics | 3              |
| Electronics | Sports      | 3              |
+-------------+-------------+----------------+
</pre>

<p><strong>解释：</strong></p>

<ul>
	<li><strong>Books-Clothing</strong>:

	<ul>
		<li>用户 1 购买来自 Books (102) 和 Clothing (201) 的商品</li>
		<li>用户 2 购买来自 Books (102, 103) 和 Clothing (201) 的商品</li>
		<li>用户 5 购买来自 Books (102, 103) 和 Clothing (201, 202) 的商品</li>
		<li>共计：3 个用户购买同一类别的商品</li>
	</ul>
	</li>
	<li><strong>Books-Electronics</strong>:
	<ul>
		<li>用户 1 购买来自 Books (102) 和 Electronics (101) 的商品</li>
		<li>用户 2 购买来自 Books (102, 103) 和 Electronics (101)&nbsp;的商品</li>
		<li>用户 3&nbsp;购买来自 Books (103) 和 Electronics (101)&nbsp;的商品</li>
		<li>共计：3 个消费者购买同一类别的商品</li>
	</ul>
	</li>
	<li><strong>Clothing-Electronics</strong>:
	<ul>
		<li>用户 1 购买来自 Clothing (201) 和 Electronics (101) 的商品</li>
		<li>用户 2 购买来自 Clothing (201) 和 Electronics (101) 的商品</li>
		<li>用户 4&nbsp;购买来自 Clothing (201) 和 Electronics (101) 的商品</li>
		<li>共计：3 个消费者购买同一类别的商品</li>
	</ul>
	</li>
	<li><strong>Electronics-Sports</strong>:
	<ul>
		<li>用户 1 购买来自 Electronics (101) 和 Sports (301) 的商品</li>
		<li>用户 3&nbsp;购买来自 Electronics (101) 和 Sports (301) 的商品</li>
		<li>用户 4&nbsp;购买来自 Electronics (101) 和 Sports (301) 的商品</li>
		<li>共计：3 个消费者购买同一类别的商品</li>
	</ul>
	</li>
	<li>其它类别对比如 Clothing-Sports（只有 2 个消费者：用户 1 和 4）和 Books-Kitchen（只有 1 个消费者：用户 3）共同的消费者少于 3 个，因此不包含在结果内。</li>
</ul>

<p>结果按&nbsp;customer_count 降序排列。由于所有对都有相同的客户数量 3，它们按 category1（然后是 category2）升序排列。</p>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql

```

<!-- tabs:end -->
