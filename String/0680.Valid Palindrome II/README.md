# [680. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非空字符串 <code>s</code>，<strong>最多</strong>删除一个字符。判断是否能成为回文字符串。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> s = "aba"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> s = "abca"
<strong>输出:</strong> true
<strong>解释:</strong> 你可以删除c字符。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "abc"
<strong>输出:</strong> false</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= s.length <= 10<sup>5</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validPalindrome(self, s: str) -> bool:
        def dfs(t, skip):
            if len(t) <= 1:
                return True
            if not skip and len(t) <= 2:
                return True
            if t[0] != t[-1]:
                if skip:
                    return False
                return dfs(t[1:], True) or dfs(t[:-1], True)
            return dfs(t[1:-1], skip)
        
        return dfs(s, False)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean dfs(String s, int l, int r, boolean skip) {
        if (r - l + 1 <= 1) {
            return true;
        }
        if (r - l + 1 <= 2 && !skip) {
            return true;
        }
        if (s.charAt(l) != s.charAt(r)) {
            if (skip) {
                return false;
            }
            return dfs(s, l + 1, r, true) || dfs(s, l, r - 1, true);
        }
        return dfs(s, l + 1, r - 1, skip);
    }

    public boolean validPalindrome(String s) {
        return dfs(s, 0, s.length() - 1, false);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
