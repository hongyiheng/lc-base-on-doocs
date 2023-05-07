# [1358. 包含所有三种字符的子字符串数目](https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>&nbsp;，它只包含三种字符 a, b 和 c 。</p>

<p>请你返回 a，b 和 c 都&nbsp;<strong>至少&nbsp;</strong>出现过一次的子字符串数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;abcabc&quot;
<strong>输出：</strong>10
<strong>解释：</strong>包含 a，b 和 c 各至少一次的子字符串为<em> &quot;</em>abc<em>&quot;, &quot;</em>abca<em>&quot;, &quot;</em>abcab<em>&quot;, &quot;</em>abcabc<em>&quot;, &quot;</em>bca<em>&quot;, &quot;</em>bcab<em>&quot;, &quot;</em>bcabc<em>&quot;, &quot;</em>cab<em>&quot;, &quot;</em>cabc<em>&quot; </em>和<em> &quot;</em>abc<em>&quot; </em>(<strong>相同</strong><strong>字符串算多次</strong>)<em>。</em>
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;aaacb&quot;
<strong>输出：</strong>3
<strong>解释：</strong>包含 a，b 和 c 各至少一次的子字符串为<em> &quot;</em>aaacb<em>&quot;, &quot;</em>aacb<em>&quot; </em>和<em> &quot;</em>acb<em>&quot; 。</em>
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;abc&quot;
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 5 x 10^4</code></li>
	<li><code>s</code>&nbsp;只包含字符 a，b 和 c 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        cnt = [0] * 3
        n = len(s)
        ans = l = r = 0
        while r < n:
            cnt[ord(s[r]) - ord('a')] += 1
            while cnt[0] and cnt[1] and cnt[2]:
                ans += n - r
                cnt[ord(s[l]) - ord('a')] -= 1
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int n = s.length(), ans = 0, l = 0, r = 0;
        while (r < n) {
            cnt[s.charAt(r) - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += n - r;
                cnt[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
