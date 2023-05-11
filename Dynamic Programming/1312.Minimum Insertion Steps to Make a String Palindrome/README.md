# [1312. 让字符串成为回文串的最少插入次数](https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;，每一次操作你都可以在字符串的任意位置插入任意字符。</p>

<p>请你返回让&nbsp;<code>s</code>&nbsp;成为回文串的&nbsp;<strong>最少操作次数</strong>&nbsp;。</p>

<p>「回文串」是正读和反读都相同的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;zzazz&quot;
<strong>输出：</strong>0
<strong>解释：</strong>字符串 &quot;zzazz&quot; 已经是回文串了，所以不需要做任何插入操作。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;mbadm&quot;
<strong>输出：</strong>2
<strong>解释：</strong>字符串可变为 &quot;mbdadbm&quot; 或者 &quot;mdbabdm&quot; 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;leetcode&quot;
<strong>输出：</strong>5
<strong>解释：</strong>插入 5 个字符后字符串变为 &quot;leetcodocteel&quot; 。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;g&quot;
<strong>输出：</strong>0
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;no&quot;
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code>&nbsp;中所有字符都是小写字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minInsertions(self, s: str) -> int:
        n = len(s)
        f = [[0] * n for _ in range(n)]
        for i in range(1, n):
            f[i - 1][i] = 0 if s[i - 1] == s[i] else 1
        for L in range(3, n + 1):
            for l in range(0, n):
                r = l + L - 1
                if r >= n:
                    break
                if s[l] == s[r]:
                    f[l][r] = f[l + 1][r - 1]
                else:
                    f[l][r] = min(f[l + 1][r], f[l][r - 1]) + 1
        return f[0][n - 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] f = new int[n][n];
        for (int i = 1; i < n; i++) {
            f[i - 1][i] = cs[i - 1] == cs[i] ? 0 : 1;
        }
        for (int L = 3; L <= n; L++) {
            for (int l = 0; l < n; l++) {
                int r = l + L - 1;
                if (r >= n) {
                    break;
                }
                if (cs[l] == cs[r]) {
                    f[l][r] = f[l + 1][r - 1];
                } else {
                    f[l][r] = Math.min(f[l + 1][r], f[l][r - 1]) + 1;
                }
            }
        }
        return f[0][n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
