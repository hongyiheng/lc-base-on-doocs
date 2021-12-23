# [1044. 最长重复子串](https://leetcode-cn.com/problems/longest-duplicate-substring)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个字符串&nbsp;<code>S</code>，考虑其所有<strong>重复子串</strong>（<code>S</code> 的连续子串，出现两次或多次，可能会有重叠）。</p>

<p>返回<strong>任何</strong>具有最长可能长度的重复子串。（如果 <code>S</code>&nbsp;不含重复子串，那么答案为&nbsp;<code>&quot;&quot;</code>。）</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;banana&quot;
<strong>输出：</strong>&quot;ana&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>&quot;abcd&quot;
<strong>输出：</strong>&quot;&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>2 &lt;= S.length &lt;= 10^5</code></li>
	<li><code>S</code> 由小写英文字母组成。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestDupSubstring(self, s: str) -> str:
        n = len(s)

        def check(l):
            seen = set()
            for i in range(n - l + 1):
                t = s[i: i + l]
                if t in seen:
                    return t
                seen.add(t)
            return ''
            
        left, right = 0, n
        ans = ''
        while left < right:
            mid = (left + right + 1) >> 1
            t = check(mid)
            ans = t or ans
            if len(t) > 0:
                left = mid
            else:
                right = mid - 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    long[] h;
    long[] p;
    int P = 131;
    public String longestDupSubstring(String s) {
        int n = s.length();
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }
        int left = 0, right = n;
        String ans = "";
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            String t = check(s, mid);
            ans = t.length() > ans.length() ? t : ans;
            if ("".equals(t)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return ans;
    }

    public String check(String s, int len) {
        Set<Long> seen = new HashSet<>();
        for (int i = 1; i <= s.length() - len + 1; i++) {
            int j = i + len - 1;
            long hash = h[j] - h[i - 1] * p[j - i + 1];
            if (seen.contains(hash)) {
                return s.substring(i - 1, j);
            }
            seen.add(hash);
        }
        return "";
    }
}
```

### **...**

```

```

<!-- tabs:end -->
