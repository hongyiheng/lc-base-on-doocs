# [940. 不同的子序列 II](https://leetcode-cn.com/problems/distinct-subsequences-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串&nbsp;<code>S</code>，计算&nbsp;<code>S</code>&nbsp;的不同非空子序列的个数。</p>

<p>因为结果可能很大，所以<strong>返回答案模</strong><strong> <code>10^9 + 7</code></strong>.</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;abc&quot;
<strong>输出：</strong>7
<strong>解释：</strong>7 个不同的子序列分别是 &quot;a&quot;, &quot;b&quot;, &quot;c&quot;, &quot;ab&quot;, &quot;ac&quot;, &quot;bc&quot;, 以及 &quot;abc&quot;。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>&quot;aba&quot;
<strong>输出：</strong>6
<strong>解释：</strong>6 个不同的子序列分别是 &quot;a&quot;, &quot;b&quot;, &quot;ab&quot;, &quot;ba&quot;, &quot;aa&quot; 以及 &quot;aba&quot;。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>&quot;aaa&quot;
<strong>输出：</strong>3
<strong>解释：</strong>3 个不同的子序列分别是 &quot;a&quot;, &quot;aa&quot; 以及 &quot;aaa&quot;。
</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>S</code>&nbsp;只包含小写字母。</li>
	<li><code>1 &lt;= S.length &lt;= 2000</code></li>
</ol>

<p>&nbsp;</p>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distinctSubseqII(self, s: str) -> int:
        mod = int(1e9 + 7)
        tail = [0] * 26
        for c in s:
            cnt = 0
            for v in tail:
                cnt += v
            tail[ord(c) - ord('a')] = cnt % mod + 1
        ans = 0
        for v in tail:
            ans += v
        return ans % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int)1e9 + 7;
        int[] tail = new int[26];
        for (char c : s.toCharArray()) {
            long cnt = 0;
            for (int v : tail) {
                cnt = (cnt + v) % mod;
            }
            tail[c - 'a'] = (int)cnt + 1;
        }
        long ans = 0;
        for (int v : tail) {
            ans = (ans + v) % mod;
        }
        return (int)ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
