# [2131. 连接两字母单词得到的最长回文串](https://leetcode-cn.com/problems/longest-palindrome-by-concatenating-two-letter-words)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串数组&nbsp;<code>words</code>&nbsp;。<code>words</code>&nbsp;中每个元素都是一个包含 <strong>两个</strong>&nbsp;小写英文字母的单词。</p>

<p>请你从 <code>words</code>&nbsp;中选择一些元素并按 <b>任意顺序</b>&nbsp;连接它们，并得到一个 <strong>尽可能长的回文串</strong>&nbsp;。每个元素 <strong>至多</strong>&nbsp;只能使用一次。</p>

<p>请你返回你能得到的最长回文串的 <strong>长度</strong>&nbsp;。如果没办法得到任何一个回文串，请你返回 <code>0</code>&nbsp;。</p>

<p><strong>回文串</strong>&nbsp;指的是从前往后和从后往前读一样的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>words = ["lc","cl","gg"]
<b>输出：</b>6
<b>解释：</b>一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
"clgglc" 是另一个可以得到的最长回文串。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>words = ["ab","ty","yt","lc","cl","ab"]
<b>输出：</b>8
<strong>解释：</strong>最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
"lcyttycl" 是另一个可以得到的最长回文串。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>words = ["cc","ll","xx"]
<b>输出：</b>2
<b>解释：</b>最长回文串是 "cc" ，长度为 2 。
"ll" 是另一个可以得到的最长回文串。"xx" 也是。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 10<sup>5</sup></code></li>
	<li><code>words[i].length == 2</code></li>
	<li><code>words[i]</code>&nbsp;仅包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        g = [[0] * 26 for _ in range(26)]
        ans = 0
        for w in words:
            i, j = ord(w[0]) - ord('a'), ord(w[1]) - ord('a')
            if g[j][i]:
                ans += 4
                g[j][i] -= 1
            else:
                g[i][j] += 1
        for i in range(26):
            if g[i][i]:
                return ans + 2
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestPalindrome(String[] words) {
        int[][] g = new int[26][26];
        int ans = 0;
        for (String w : words) {
            int i = w.charAt(0) - 'a', j = w.charAt(1) - 'a';
            if (g[j][i] > 0) {
                g[j][i]--;
                ans += 4;
            } else {
                g[i][j]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (g[i][i] > 0) {
                return ans + 2;
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
