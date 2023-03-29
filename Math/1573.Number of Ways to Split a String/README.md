# [1573. 分割字符串的方案数](https://leetcode-cn.com/problems/number-of-ways-to-split-a-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制串&nbsp;<code>s</code>&nbsp; （一个只包含 0 和 1 的字符串），我们可以将 <code>s</code>&nbsp;分割成 3 个 <strong>非空</strong>&nbsp;字符串 s1, s2, s3 （s1 + s2 + s3 = s）。</p>

<p>请你返回分割&nbsp;<code>s</code>&nbsp;的方案数，满足 s1，s2 和 s3 中字符 &#39;1&#39; 的数目相同。</p>

<p>由于答案可能很大，请将它对 10^9 + 7 取余后返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;10101&quot;
<strong>输出：</strong>4
<strong>解释：</strong>总共有 4 种方法将 s 分割成含有 &#39;1&#39; 数目相同的三个子字符串。
&quot;1|010|1&quot;
&quot;1|01|01&quot;
&quot;10|10|1&quot;
&quot;10|1|01&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;1001&quot;
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;0000&quot;
<strong>输出：</strong>3
<strong>解释：</strong>总共有 3 种分割 s 的方法。
&quot;0|0|00&quot;
&quot;0|00|0&quot;
&quot;00|0|0&quot;
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;100100010100110&quot;
<strong>输出：</strong>12
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>s[i] == &#39;0&#39;</code>&nbsp;或者&nbsp;<code>s[i] == &#39;1&#39;</code></li>
	<li><code>3 &lt;= s.length &lt;= 10^5</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numWays(self, s: str) -> int:
        cnt = 0
        for c in s:
            if c == '1':
                cnt += 1
        if cnt % 3:
            return 0
        n = len(s)
        mod = int(1e9 + 7)
        if cnt == 0:
            return (n - 1) * (n - 2) // 2 % mod
        t, cnt = cnt // 3, 0
        q = [0, 0]
        for c in s:
            if c == '1':
                cnt += 1
            else:
                if cnt == t:
                    q[0] += 1
                if cnt == 2 * t:
                    q[1] += 1
        return (q[0] + 1) * (q[1] + 1) % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numWays(String s) {
        int cnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        if (cnt % 3 != 0) {
            return 0;
        }
        int t = cnt / 3, mod = (int)1e9 + 7;
        if (cnt == 0) {
            return (int)(1L * (n - 1) * (n - 2) / 2 % mod);
        }
        cnt = 0;
        int[] q = new int[]{0, 0};
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                if (cnt == t) {
                    q[0]++;
                } else if (cnt == 2 * t) {
                    q[1]++;
                }
            }
        }
        return (int)(1L * (q[0] + 1) * (q[1] + 1) % mod);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
