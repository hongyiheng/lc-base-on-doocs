# [214. 最短回文串](https://leetcode-cn.com/problems/shortest-palindrome)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串 <em><strong>s</strong></em>，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aacecaaa"
<strong>输出：</strong>"aaacecaaa"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "abcd"
<strong>输出：</strong>"dcbabcd"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        def getNxt(s):
            nxt = [0]
            i, j = 1, 0
            while i < len(s):
                if s[i] == s[j]:
                    i += 1
                    j += 1
                    nxt.append(j)
                elif j:
                    j = nxt[j - 1]
                else:
                    nxt.append(0)
                    i += 1
            return nxt

        nxt = getNxt(s + '#' + s[::-1])
        return s[::-1][:len(s) - nxt[-1]] + s
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int[] getNxt(String s) {
        int n = s.length();
        int[] nxt = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                nxt[i++] = ++j;
            } else if (j != 0) {
                j = nxt[j - 1];
            } else {
                i++;
            }
        }
        return nxt;
    }

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int[] nxt = getNxt(s + "#" + rev);
        return rev.substring(0, s.length() - nxt[nxt.length - 1]) + s;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
