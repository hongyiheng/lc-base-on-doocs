# [2311. 小于等于 K 的最长二进制子序列](https://leetcode-cn.com/problems/longest-binary-subsequence-less-than-or-equal-to-k)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制字符串&nbsp;<code>s</code>&nbsp;和一个正整数&nbsp;<code>k</code>&nbsp;。</p>

<p>请你返回 <code>s</code>&nbsp;的 <strong>最长</strong>&nbsp;子序列，且该子序列对应的 <strong>二进制</strong>&nbsp;数字小于等于 <code>k</code>&nbsp;。</p>

<p>注意：</p>

<ul>
	<li>子序列可以有 <strong>前导 0</strong>&nbsp;。</li>
	<li>空字符串视为&nbsp;<code>0</code>&nbsp;。</li>
	<li><strong>子序列</strong>&nbsp;是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>s = "1001010", k = 5
<b>输出：</b>5
<b>解释：</b>s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
最长子序列的长度为 5 ，所以返回 5 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>s = "00101001", k = 1
<b>输出：</b>6
<b>解释：</b>"000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
最长子序列的长度为 6 ，所以返回 6 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s[i]</code> 要么是&nbsp;<code>'0'</code>&nbsp;，要么是&nbsp;<code>'1'</code> 。</li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        for i in range(n - 1, -1, -1):
            v = l = 0
            for j in range(i, -1, -1):
                if s[j] == '1' and v + (1 << l) > k:
                    continue
                elif s[j] == '1':
                    v += 1 << l
                l += 1
            ans = max(ans, l)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), ans = 0;
        for (int i = n - 1; i > -1; i--) {
            long v = 0, l = 0;
            for (int j = i; j > -1; j--) {
                if (l > 32 && s.charAt(j) == '1') {
                    continue;
                }
                if (s.charAt(j) == '1' && v + (1L << l) > k) {
                    continue;
                } else if (s.charAt(j) == '1') {
                    v += (1L << l);
                }
                l++;
            }
            ans = Math.max(ans, (int) l);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
