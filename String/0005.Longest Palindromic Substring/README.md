# [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "a"
<strong>输出：</strong>"a"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "ac"
<strong>输出：</strong>"a"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>s</code> 仅由数字和英文字母（大写和/或小写）组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        mx = mx_l = mx_r = 0
        for i in range(n):
            l = r = i
            while l > 0 and s[l - 1] == s[i]:
                l -= 1
            while r < n - 1 and s[r + 1] == s[i]:
                r += 1
            while l > 0 and r < n - 1 and s[l - 1] == s[r + 1]:
                l -= 1
                r += 1
            if r - l + 1 > mx:
                mx = r - l + 1
                mx_l = l
                mx_r = r
        return s[mx_l:mx_r + 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String longestPalindrome(String s) {
        int mx = 0, mxL = 0, mxR = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l > 0 && s.charAt(l - 1) == s.charAt(i)) {
                l--;
            }
            while (r < n - 1 && s.charAt(r + 1) == s.charAt(i)) {
                r++;
            }
            while (l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }
            if (r - l + 1 > mx) {
                mx = r - l + 1;
                mxL = l;
                mxR = r;
            }
        }
        return s.substring(mxL, mxR + 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
