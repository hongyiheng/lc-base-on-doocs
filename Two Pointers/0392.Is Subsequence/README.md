# [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence)

[English Version](/solution/0300-0399/0392.Is%20Subsequence/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定字符串 <strong>s</strong> 和 <strong>t</strong> ，判断 <strong>s</strong> 是否为 <strong>t</strong> 的子序列。</p>

<p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，<code>"ace"</code>是<code>"abcde"</code>的一个子序列，而<code>"aec"</code>不是）。</p>

<p><strong>进阶：</strong></p>

<p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？</p>

<p><strong>致谢：</strong></p>

<p>特别感谢<strong> </strong><a href="https://leetcode.com/pbrother/">@pbrother </a>添加此问题并且创建所有测试用例。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abc", t = "ahbgdc"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "axc", t = "ahbgdc"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 100</code></li>
	<li><code>0 <= t.length <= 10^4</code></li>
	<li>两个字符串都只由小写字符组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        t_len = len(t)
        s_len = len(s)
        if s_len > t_len:
            return False
        
        left = 0;
        for i in range(s_len):
            if left == t_len:
                return False
            while s[i] != t[left]:
                left += 1
                if left == t_len:
                    return False
            left += 1
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (sLen > tLen) {
            return false;
        }

        int left = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sLen; i++) {
            if (left == tLen) {
                return false;
            }
            while (tChars[left] != sChars[i]) {
                left++;
                if (left == tLen) {
                    return false;
                }
            }
            left++;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
