# [3451. 查找无效的 IP 地址](https://leetcode.cn/problems/find-invalid-ip-addresses)

## 题目描述

<!-- 这里写题目描述 -->

<p>表：<code>logs</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| log_id      | int     |
| ip          | varchar |
| status_code | int     |
+-------------+---------+
log_id 是这张表的唯一主键。
每一行包含服务器访问日志信息，包括 IP 地址和 HTTP 状态码。
</pre>

<p>编写一个解决方案来查找 <strong>无效的 IP 地址</strong>。一个 IPv4 地址如果满足以下任何条件之一，则无效：</p>

<ul>
	<li>任何 8 位字节中包含大于 255 的数字</li>
	<li>任何 8 位字节中含有 <strong>前导零</strong>（如&nbsp;<code>01.02.03.04</code>）</li>
	<li><strong>少于或多于</strong>&nbsp;<code>4</code>&nbsp;个 8 位字节</li>
</ul>

<p>返回结果表分别以&nbsp;<code>invalid_count</code>，<code>ip</code>&nbsp;<strong>降序</strong>&nbsp;排序。</p>

<p>结果格式如下所示。</p>

<p>&nbsp;</p>

<p><strong class="example">示例：</strong></p>

<div class="example-block">
<p><strong>输入：</strong></p>

<p>logs 表：</p>

<pre class="example-io">
+--------+---------------+-------------+
| log_id | ip            | status_code | 
+--------+---------------+-------------+
| 1      | 192.168.1.1   | 200         | 
| 2      | 256.1.2.3     | 404         | 
| 3      | 192.168.001.1 | 200         | 
| 4      | 192.168.1.1   | 200         | 
| 5      | 192.168.1     | 500         | 
| 6      | 256.1.2.3     | 404         | 
| 7      | 192.168.001.1 | 200         | 
+--------+---------------+-------------+
</pre>

<p><strong>输出：</strong></p>

<pre class="example-io">
+---------------+--------------+
| ip            | invalid_count|
+---------------+--------------+
| 256.1.2.3     | 2            |
| 192.168.001.1 | 2            |
| 192.168.1     | 1            |
+---------------+--------------+
</pre>

<p><strong>解释：</strong></p>

<ul>
	<li>256.1.2.3 是无效的，因为&nbsp;256 &gt; 255</li>
	<li>192.168.001.1 是无效的，因为有前导零</li>
	<li>192.168.1 是非法的，因为只有 3 个 8 位字节</li>
</ul>

<p>输出表分别以&nbsp;<code>invalid_count</code>，<code>ip</code>&nbsp;降序排序。</p>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql

```

<!-- tabs:end -->
