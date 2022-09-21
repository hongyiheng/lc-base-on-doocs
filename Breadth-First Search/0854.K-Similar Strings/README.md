# [854. 相似度为 K 的字符串](https://leetcode-cn.com/problems/k-similar-strings)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果可以通过将 <code>A</code> 中的两个小写字母精确地交换位置 <code>K</code> 次得到与 <code>B</code> 相等的字符串，我们称字符串&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;的相似度为 <code>K</code>（<code>K</code>&nbsp;为非负整数）。</p>

<p>给定两个字母异位词&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;，返回 <code>A</code> 和 <code>B</code>&nbsp;的相似度 <code>K</code> 的最小值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = &quot;ab&quot;, B = &quot;ba&quot;
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = &quot;abc&quot;, B = &quot;bca&quot;
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>A = &quot;abac&quot;, B = &quot;baca&quot;
<strong>输出：</strong>2
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>A = &quot;aabc&quot;, B = &quot;abca&quot;
<strong>输出：</strong>2</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length == B.length &lt;= 20</code></li>
	<li><code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;只包含集合&nbsp;<code>{&#39;a&#39;, &#39;b&#39;, &#39;c&#39;, &#39;d&#39;, &#39;e&#39;, &#39;f&#39;}</code>&nbsp;中的小写字母。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kSimilarity(self, s1: str, s2: str) -> int:
        def next(s):
            idx = 0
            while idx < n and s[idx] == s2[idx]:
                idx += 1
            ans = []
            for i in range(idx + 1, n):
                if s[i] == s2[idx] and s[i] != s2[i]:
                    cs = list(s)
                    cs[i], cs[idx] = cs[idx], cs[i]
                    ans.append("".join(cs))
            return ans

        ans, n = 0, len(s1)
        q = deque()
        q.append(s1)
        vis = {s1}
        while True:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                if cur == s2:
                    return ans
                for ns in next(cur):
                    if ns in vis:
                        continue
                    vis.add(ns)
                    q.append(ns)
            ans += 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int n;
    char[] t;

    public int kSimilarity(String s1, String s2) {
        n = s1.length();
        t = s2.toCharArray();
        Deque<String> q = new ArrayDeque<>();
        q.addLast(s1);
        int ans = 0;
        Set<String> vis = new HashSet<>();
        while (true) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                String cur = q.pollFirst();
                if (cur.equals(s2)) {
                    return ans;
                }
                if (vis.contains(cur)) {
                    continue;
                }
                for (String ns : next(cur)) {
                    q.addLast(ns);
                }
            }
            ans++;
        }
    }

    public List<String> next(String s) {
        int idx = 0;
        while (s.charAt(idx) == t[idx]) {
            idx++;
        }
        List<String> ans = new ArrayList<>();
        for (int i = idx + 1; i < n; i++) {
            if (s.charAt(i) == t[idx] && s.charAt(i) != t[i]) {
                char[] cs = s.toCharArray();
                char tmp = cs[i];
                cs[i] = cs[idx];
                cs[idx] = tmp;
                ans.add(new String(cs));
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
