# [893. 特殊等价字符串组](https://leetcode-cn.com/problems/groups-of-special-equivalent-strings)

[English Version](/solution/0800-0899/0893.Groups%20of%20Special-Equivalent%20Strings/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>你将得到一个字符串数组 <code>words</code>。</p>

<p>每次操作都可以交换 <code>s</code> 的任意两个偶数下标的字符或任意两个奇数下标的字符。</p>

<p>如果经过任意次数的操作，<code>s == t</code> ，那么两个字符串 <code>s</code> 和 <code>t</code> 是 <strong>特殊等价 </strong>的。</p>

<p>例如，<code>s = "zzxy"</code> 和 <code>t = "xyzz"</code> 是一对特殊等价字符串，因为可以先交换 <code>s[0]</code> 和 <code>s[2]</code>，然后交换 <code>s[1]</code> 和 <code>s[3]</code>，使得 <code>"zzxy" -&gt; "xzzy" -&gt; "xyzz"</code> 。</p>

<p>现在规定，<strong><code>words</code> </strong>的 <strong>一组特殊等价字符串 </strong>就是 <code>words</code> 的一个同时满足下述条件的非空子集：</p>

<ol>
	<li>该组中的每一对字符串都是<strong> 特殊等价 </strong>的</li>
	<li>该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 <strong>不会</strong> 与该组内任何字符串特殊等价）</li>
</ol>

<p>返回 <code>words</code> 中特殊等价字符串组的数量。</p>

<p>&nbsp;</p>

<ul>
</ul>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
<strong>输出：</strong>3
<strong>解释：</strong>
其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = ["abc","acb","bac","bca","cab","cba"]
<strong>输出：</strong>3
<strong>解释：</strong>3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 20</code></li>
	<li>所有 <code>words[i]</code>&nbsp;都具有相同的长度。</li>
	<li>所有 <code>words[i]</code>&nbsp;都只由小写字母组成。</li>
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
