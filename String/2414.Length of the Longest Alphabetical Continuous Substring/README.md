# [2414. 最长的字母序连续子字符串的长度](https://leetcode-cn.com/problems/length-of-the-longest-alphabetical-continuous-substring)

## 题目描述

<!-- 这里写题目描述 -->

<p><strong>字母序连续字符串</strong> 是由字母表中连续字母组成的字符串。换句话说，字符串 <code>"abcdefghijklmnopqrstuvwxyz"</code> 的任意子字符串都是 <strong>字母序连续字符串</strong> 。</p>

<ul>
	<li>例如，<code>"abc"</code> 是一个字母序连续字符串，而 <code>"acb"</code> 和 <code>"za"</code> 不是。</li>
</ul>

<p>给你一个仅由小写英文字母组成的字符串 <code>s</code> ，返回其 <strong>最长</strong> 的 字母序连续子字符串 的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "abacaba"
<strong>输出：</strong>2
<strong>解释：</strong>共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
"ab" 是最长的字母序连续子字符串。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "abcde"
<strong>输出：</strong>5
<strong>解释：</strong>"abcde" 是最长的字母序连续子字符串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        ans = start = 0
        for i in range(1, len(s)):
            if ord(s[i]) - ord(s[i - 1]) == 1:
                continue
            ans = max(ans, i - start)
            start = i     
        return max(ans, len(s) - start)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 0, start = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (cs[i] - cs[i - 1] == 1) {
                continue;
            }
            ans = Math.max(ans, i - start);
            start = i;
        }
        return Math.max(ans, n - start);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
