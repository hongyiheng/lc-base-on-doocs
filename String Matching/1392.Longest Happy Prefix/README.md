# [1392. 最长快乐前缀](https://leetcode-cn.com/problems/longest-happy-prefix)



## 题目描述

<!-- 这里写题目描述 -->

<p>「快乐前缀」是在原字符串中既是&nbsp;<strong>非空</strong> 前缀也是后缀（不包括原字符串自身）的字符串。</p>

<p>给你一个字符串 <code>s</code>，请你返回它的 <strong>最长快乐前缀</strong>。</p>

<p>如果不存在满足题意的前缀，则返回一个空字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;level&quot;
<strong>输出：</strong>&quot;l&quot;
<strong>解释：</strong>不包括 s 自己，一共有 4 个前缀（&quot;l&quot;, &quot;le&quot;, &quot;lev&quot;, &quot;leve&quot;）和 4 个后缀（&quot;l&quot;, &quot;el&quot;, &quot;vel&quot;, &quot;evel&quot;）。最长的既是前缀也是后缀的字符串是 &quot;l&quot; 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;ababab&quot;
<strong>输出：</strong>&quot;abab&quot;
<strong>解释：</strong>&quot;abab&quot; 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;leetcodeleet&quot;
<strong>输出：</strong>&quot;leet&quot;
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;a&quot;
<strong>输出：</strong>&quot;&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10^5</code></li>
	<li><code>s</code> 只含有小写英文字母</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestPrefix(self, s: str) -> str:
        nxt = [0]
        x, now = 1, 0
        while x < len(s):
            if s[now] == s[x]:
                now += 1
                x += 1
                nxt.append(now)
            elif now:
                now = nxt[now - 1]
            else:
                nxt.append(0)
                x += 1
        return s[:nxt[len(s) - 1]]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] nxt = new int[n + 1];
        int x = 1, now = 0;
        while (x < n) {
            if (s.charAt(x) == s.charAt(now)) {
                x++;
                now++;
                nxt[x - 1] = now;
            } else if (now != 0) {
                now = nxt[now - 1];
            } else {
                x++;
                nxt[x - 1] = 0;
            }
        }
        return s.substring(0, nxt[n - 1]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
