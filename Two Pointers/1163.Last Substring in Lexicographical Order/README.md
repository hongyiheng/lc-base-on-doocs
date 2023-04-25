# [1163. 按字典序排在最后的子串](https://leetcode-cn.com/problems/last-substring-in-lexicographical-order)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>，找出它的所有子串并按字典序排列，返回排在最后的那个子串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;abab&quot;
<strong>输出：</strong>&quot;bab&quot;
<strong>解释：</strong>我们可以找出 7 个子串 [&quot;a&quot;, &quot;ab&quot;, &quot;aba&quot;, &quot;abab&quot;, &quot;b&quot;, &quot;ba&quot;, &quot;bab&quot;]。按字典序排在最后的子串是 &quot;bab&quot;。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre><strong>输入：</strong>&quot;leetcode&quot;
<strong>输出：</strong>&quot;tcode&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= s.length &lt;= 4 * 10^5</code></li>
	<li>s 仅含有小写英文字符。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lastSubstring(self, s: str) -> str:
        i, j, k = 0, 1, 0
        n = len(s)
        while j + k < n:
            if s[i + k] == s[j + k]:
                k += 1
            elif s[i + k] < s[j + k]:
                i += k + 1
                if i >= j:
                    j = i + 1
                k = 0
            else:
                j += k + 1
                k = 0
        return s[i:]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;
        while (j + k < s.length()) {
           if (s.charAt(i + k) == s.charAt(j + k)) {
               k++;
           } else if (s.charAt(i + k) < s.charAt(j + k)) {
               i += k + 1;
               if (i >= j) {
                   j = i + 1;
               }
               k = 0;
           } else {
               j += k + 1;
               k = 0;
           }
        }
        return s.substring(i); 
    }
}
```

### **...**

```

```

<!-- tabs:end -->
