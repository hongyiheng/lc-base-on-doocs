# [1092. 最短公共超序列](https://leetcode-cn.com/problems/shortest-common-supersequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出两个字符串&nbsp;<code>str1</code> 和&nbsp;<code>str2</code>，返回同时以&nbsp;<code>str1</code>&nbsp;和&nbsp;<code>str2</code>&nbsp;作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。</p>

<p>（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的&nbsp;<strong>任意位置</strong>），可以得到字符串 S，那么&nbsp;S 就是&nbsp;T 的子序列）</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>str1 = &quot;abac&quot;, str2 = &quot;cab&quot;
<strong>输出：</strong>&quot;cabac&quot;
<strong>解释：</strong>
str1 = &quot;abac&quot; 是 &quot;cabac&quot; 的一个子串，因为我们可以删去 &quot;cabac&quot; 的第一个 &quot;c&quot;得到 &quot;abac&quot;。 
str2 = &quot;cab&quot; 是 &quot;cabac&quot; 的一个子串，因为我们可以删去 &quot;cabac&quot; 末尾的 &quot;ac&quot; 得到 &quot;cab&quot;。
最终我们给出的答案是满足上述属性的最短字符串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= str1.length, str2.length &lt;= 1000</code></li>
	<li><code>str1</code> 和&nbsp;<code>str2</code>&nbsp;都由小写英文字母组成。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestCommonSupersequence(self, s: str, t: str) -> str:
        m, n = len(s), len(t)
        f = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s[i - 1] == t[j - 1]:
                    f[i][j] = f[i - 1][j - 1] + 1
                else:
                    f[i][j] = max(f[i - 1][j], f[i][j - 1])
        ans = ""
        i, j = m, n
        while i > 0 and j > 0:
            if s[i - 1] == t[j - 1]:
                ans += s[i - 1]
                i -= 1
                j -= 1
            elif f[i - 1][j] > f[i][j - 1]:
                ans += s[i - 1]
                i -= 1
            else:
                ans += t[j - 1]
                j -= 1
        while i > 0:
            ans += s[i - 1]
            i -= 1
        while j > 0:
            ans += t[j - 1]
            j -= 1
        return ans[::-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (f[i - 1][j] > f[i][j - 1]) {
                ans.append(s.charAt(i - 1));
                i--;
            } else {
                ans.append(t.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(s.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(t.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
