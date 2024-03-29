# [2826. 将三个组排序](https://leetcode-cn.com/problems/sorting-three-groups)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;。<br />
<br />
从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;的数字被分为编号从&nbsp;<code>1</code>&nbsp;到&nbsp;<code>3</code>&nbsp;的三个组，数字&nbsp;<code>i</code>&nbsp;属于组&nbsp;<code>nums[i]</code>&nbsp;。注意，有的组可能是&nbsp;<strong>空的</strong>&nbsp;。<br />
<br />
你可以执行以下操作任意次：</p>

<ul>
	<li>选择数字&nbsp;<code>x</code>&nbsp;并改变它的组。更正式的，你可以将&nbsp;<code>nums[x]</code>&nbsp;改为数字&nbsp;<code>1</code>&nbsp;到&nbsp;<code>3</code>&nbsp;中的任意一个。</li>
</ul>

<p>你将按照以下过程构建一个新的数组&nbsp;<code>res</code>&nbsp;：</p>

<ol>
	<li>将每个组中的数字分别排序。</li>
	<li>将组&nbsp;<code>1</code>&nbsp;，<code>2</code>&nbsp;和&nbsp;<code>3</code>&nbsp;中的元素&nbsp;<strong>依次</strong>&nbsp;连接以得到&nbsp;<code>res</code>&nbsp;。</li>
</ol>

<p>如果得到的&nbsp;<code>res</code>&nbsp;是 <strong>非递减</strong>顺序的，那么我们称数组&nbsp;<code>nums</code>&nbsp;是 <strong>美丽数组</strong>&nbsp;。</p>

<p>请你返回将<em>&nbsp;</em><code>nums</code>&nbsp;变为&nbsp;<strong>美丽数组</strong>&nbsp;需要的最少步数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [2,1,3,2,1]
<b>输出：</b>3
<b>解释：</b>以下三步操作是最优方案：
1. 将 nums[0] 变为 1 。
2. 将 nums[2] 变为 1 。
3. 将 nums[3] 变为 1 。
执行以上操作后，将每组中的数字排序，组 1 为 [0,1,2,3,4] ，组 2 和组 3 都为空。所以 res 等于 [0,1,2,3,4] ，它是非递减顺序的。
三步操作是最少需要的步数。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1,3,2,1,3,3]
<b>输出：</b>2
<b>解释：</b>以下两步操作是最优方案：
1. 将 nums[1] 变为 1 。
2. 将 nums[2] 变为 1 。
执行以上操作后，将每组中的数字排序，组 1 为 [0,1,2,3] ，组 2 为空，组 3 为 [4,5] 。所以 res 等于 [0,1,2,3,4,5] ，它是非递减顺序的。
两步操作是最少需要的步数。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<b>输入：</b>nums = [2,2,2,2,3,3]
<b>输出：</b>0
<b>解释：</b>不需要执行任何操作。
组 1 为空，组 2 为 [0,1,2,3] ，组 3 为 [4,5] 。所以 res 等于 [0,1,2,3,4,5] ，它是非递减顺序的。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 3</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**

```

```

<!-- tabs:end -->
