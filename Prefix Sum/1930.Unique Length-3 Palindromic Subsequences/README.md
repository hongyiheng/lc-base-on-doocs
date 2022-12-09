# [1930. 长度为 3 的不同回文子序列](https://leetcode-cn.com/problems/unique-length-3-palindromic-subsequences)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> ，返回 <code>s</code> 中 <strong>长度为 3 </strong>的<strong>不同回文子序列</strong> 的个数。</p>

<p>即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。</p>

<p><strong>回文</strong> 是正着读和反着读一样的字符串。</p>

<p><strong>子序列</strong> 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。</p>

<ul>
	<li>例如，<code>"ace"</code> 是 <code>"<strong><em>a</em></strong>b<strong><em>c</em></strong>d<strong><em>e</em></strong>"</code> 的一个子序列。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aabca"
<strong>输出：</strong>3
<strong>解释：</strong>长度为 3 的 3 个回文子序列分别是：
- "aba" ("<strong><em>a</em></strong>a<strong><em>b</em></strong>c<strong><em>a</em></strong>" 的子序列)
- "aaa" ("<strong><em>aa</em></strong>bc<strong><em>a</em></strong>" 的子序列)
- "aca" ("<strong><em>a</em></strong>ab<strong><em>ca</em></strong>" 的子序列)
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "adc"
<strong>输出：</strong>0
<strong>解释：</strong>"adc" 不存在长度为 3 的回文子序列。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "bbcbaba"
<strong>输出：</strong>4
<strong>解释：</strong>长度为 3 的 4 个回文子序列分别是：
- "bbb" ("<strong><em>bb</em></strong>c<strong><em>b</em></strong>aba" 的子序列)
- "bcb" ("<strong><em>b</em></strong>b<strong><em>cb</em></strong>aba" 的子序列)
- "bab" ("<strong><em>b</em></strong>bcb<strong><em>ab</em></strong>a" 的子序列)
- "aba" ("bbcb<strong><em>aba</em></strong>" 的子序列)
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 <= s.length <= 10<sup>5</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        pre, tail = [0] * 26, [0] * 26
        for c in s:
            pre[ord(c) - ord('a')] += 1
        vis = [[False] * 26 for _ in range(26)]
        ans = 0
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            pre[idx] -= 1
            for j in range(26):
                if pre[j] == 0 or tail[j] == 0:
                    continue
                if vis[idx][j]:
                    continue
                ans += 1
                vis[idx][j] = True
            tail[idx] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] pre = new int[26], tail = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            tail[c - 'a']++;
        }
        boolean[][] vis = new boolean[26][26];
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            int idx = cs[i] - 'a';
            tail[idx]--;
            for (int j = 0; j < 26; j++) {
                if (vis[idx][j]) {
                    continue;
                }
                if (pre[j] <= 0 || tail[j] <= 0) {
                    continue;
                }
                ans++;
                vis[idx][j] = true;
            }
            pre[idx]++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
