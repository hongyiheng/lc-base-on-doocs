# [1081. 不同字符的最小子序列](https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>返回 <code>s</code> 字典序最小的子序列，该子序列包含 <code>s</code> 的所有不同字符，且只包含一次。</p>

<p><strong>注意：</strong>该题与 316 <a href="https://leetcode.com/problems/remove-duplicate-letters/">https://leetcode.com/problems/remove-duplicate-letters/</a> 相同</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong><code>s = "bcabc"</code>
<strong>输出<code>：</code></strong><code>"abc"</code>
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong><code>s = "cbacdcbc"</code>
<strong>输出：</strong><code>"acdb"</code></pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestSubsequence(self, s: str) -> str:
        cnt = Counter(list(s))
        q = []
        used = set()
        for c in s:
            if c not in used:
                while q and q[-1] > c and cnt[q[-1]] > 0:
                    used.remove(q.pop())
                q.append(c)
                used.add(c)
            cnt[c] -= 1
        return "".join(q)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        Deque<Character> q = new ArrayDeque<>();
        Set<Character> used = new HashSet<>();
        for (char c : cs) {
            if (!used.contains(c)) {
                while (!q.isEmpty() && q.peekLast() > c && cnt.get(q.peekLast()) > 0) {
                    used.remove(q.pollLast());
                }
                q.addLast(c);
                used.add(c);
            }
            cnt.put(c, cnt.get(c) - 1);          
        }
        String ans = "";
        for (char c : q) {
            ans += String.valueOf(c);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
