# [3560. 木材运输的最小成本](https://leetcode.cn/problems/find-minimum-log-transportation-cost)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你三个整数 <code>n</code>、<code>m</code> 和 <code>k</code>。</p>

<p>有两根长度分别为 <code>n</code> 和 <code>m</code> 单位的木材，需要通过三辆卡车运输。每辆卡车最多只能装载一根长度&nbsp;<strong>不超过</strong> <code>k</code> 单位的木材。</p>

<p>你可以将木材切成更小的段，其中将长度为 <code>x</code> 的木材切割成长度为 <code>len1</code> 和 <code>len2</code> 的段的成本为 <code>cost = len1 * len2</code>，并且满足 <code>len1 + len2 = x</code>。</p>

<p>返回将木材分配到卡车上的&nbsp;<strong>最小总成本&nbsp;</strong>。如果木材不需要切割，总成本为 0。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 6, m = 5, k = 5</span></p>

<p><strong>输出：</strong> <span class="example-io">5</span></p>

<p><strong>解释：</strong></p>

<p>将长度为 6 的木材切割成长度为 1 和 5 的两段，成本为 <code>1 * 5 == 5</code>。现在三段长度分别为 1、5 和 5 的木材可以分别装载到每辆卡车。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 4, m = 4, k = 6</span></p>

<p><strong>输出：</strong> <span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p>两根木材已经可以直接装载到卡车上，因此不需要切割。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= k &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= n, m &lt;= 2 * k</code></li>
	<li>输入数据保证木材总存在能被运输的方案。</li>
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
