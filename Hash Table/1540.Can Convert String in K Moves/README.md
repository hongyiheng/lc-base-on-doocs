# [1540. K 次操作转变字符串](https://leetcode-cn.com/problems/can-convert-string-in-k-moves)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串&nbsp;<code>s</code>&nbsp;和&nbsp;<code>t</code>&nbsp;，你的目标是在 <code>k</code>&nbsp;次操作以内把字符串&nbsp;<code>s</code>&nbsp;转变成&nbsp;<code>t</code>&nbsp;。</p>

<p>在第 <code>i</code>&nbsp;次操作时（<code>1 &lt;= i &lt;= k</code>），你可以选择进行如下操作：</p>

<ul>
	<li>选择字符串 <code>s</code>&nbsp;中满足 <code>1 &lt;= j &lt;= s.length</code>&nbsp;且之前未被选过的任意下标 <code>j</code>&nbsp;（下标从 1 开始），并将此位置的字符切换 <code>i</code>&nbsp;次。</li>
	<li>不进行任何操作。</li>
</ul>

<p>切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 <code>&#39;z&#39;</code>&nbsp;切换后会变成 <code>&#39;a&#39;</code>）。</p>

<p>请记住任意一个下标 <code>j</code>&nbsp;最多只能被操作&nbsp;1 次。</p>

<p>如果在不超过 <code>k</code>&nbsp;次操作内可以把字符串 <code>s</code>&nbsp;转变成 <code>t</code>&nbsp;，那么请你返回&nbsp;<code>true</code>&nbsp;，否则请你返回&nbsp;<code>false</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;input&quot;, t = &quot;ouput&quot;, k = 9
<strong>输出：</strong>true
<strong>解释：</strong>第 6 次操作时，我们将 &#39;i&#39; 切换 6 次得到 &#39;o&#39; 。第 7 次操作时，我们将 &#39;n&#39; 切换 7 次得到 &#39;u&#39; 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;abc&quot;, t = &quot;bcd&quot;, k = 10
<strong>输出：</strong>false
<strong>解释：</strong>我们需要将每个字符切换 1 次才能得到 t 。我们可以在第 1 次操作时将 &#39;a&#39; 切换成 &#39;b&#39; ，但另外 2 个字母在剩余操作中无法再转变为 t 中对应字母。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;aab&quot;, t = &quot;bbb&quot;, k = 27
<strong>输出：</strong>true
<strong>解释：</strong>第 1 次操作时，我们将第一个 &#39;a&#39; 切换 1 次得到 &#39;b&#39; 。在第 27 次操作时，我们将第二个字母 &#39;a&#39; 切换 27 次得到 &#39;b&#39; 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 10^5</code></li>
	<li><code>0 &lt;= k &lt;= 10^9</code></li>
	<li><code>s</code>&nbsp;和&nbsp;<code>t</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        if len(s) != len(t):
            return False
        cnt = [0] * 26
        mx = 0
        for a, b in zip(s, t):
            if a == b:
                continue
            diff = (ord(b) - ord(a) + 26) % 26
            cnt[diff] += 1
            diff += (cnt[diff] - 1) * 26
            mx = max(mx, diff)
        return mx <= k
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int[] cnt = new int[26];
        int n = s.length(), m = t.length();
        if (n != m) {
            return false;
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            diff += 26 * cnt[diff]++;
            mx = Math.max(mx, diff);
        }
        return mx <= k;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
