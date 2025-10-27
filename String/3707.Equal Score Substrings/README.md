# [3707. 相等子字符串分数](https://leetcode.cn/problems/equal-score-substrings)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由小写英文字母组成的字符串 <code>s</code>。</p>

<p>一个字符串的&nbsp;<strong>得分&nbsp;</strong>是其字符在字母表中的位置之和，其中 <code>'a' = 1</code>，<code>'b' = 2</code>，...，<code>'z' = 26</code>。</p>

<p>请你判断是否存在一个下标&nbsp;<code>i</code>，使得该字符串可以被拆分成两个&nbsp;<strong>非空子字符串</strong> <code>s[0..i]</code> 和 <code>s[(i + 1)..(n - 1)]</code>，且它们的得分&nbsp;<strong>相等&nbsp;</strong>。</p>

<p>如果存在这样的拆分，则返回 <code>true</code>，否则返回 <code>false</code>。</p>

<p>一个&nbsp;<strong>子字符串&nbsp;</strong>是字符串中&nbsp;<strong>非空&nbsp;</strong>的连续字符序列。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">s = "adcb"</span></p>

<p><strong>输出:</strong> <span class="example-io">true</span></p>

<p><strong>解释:</strong></p>

<p>在下标&nbsp;<code>i = 1</code> 处拆分：</p>

<ul>
	<li>左子字符串 = <code>s[0..1] = "ad"</code>，得分 =&nbsp;<code>1 + 4 = 5</code></li>
	<li>右子字符串 = <code>s[2..3] = "cb"</code>，得分 = <code>3 + 2 = 5</code></li>
</ul>

<p>两个子字符串的得分相等，因此输出为 <code>true</code>。</p>
</div>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">s = "bace"</span></p>

<p><strong>输出:</strong> <span class="example-io">false</span></p>

<p><strong>解释:​​​​​​</strong></p>

<p>没有拆分能产生相等的得分，因此输出为 <code>false</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> 由小写英文字母组成。</li>
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
