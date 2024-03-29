# [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p> </p>

<p><strong>注意：</strong></p>

<ul>
	<li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li>
	<li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length, t.length <= 10<sup>5</sup></code></li>
	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
</ul>

<p> </p>
<strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        cnt = Counter(t)
        n, k = len(s), len(cnt)
        l = r = 0
        ans = ""
        while r < n:
            if r < n and s[r] in cnt:
                cnt[s[r]] -= 1
                if cnt[s[r]] == 0:
                    k -= 1
            while k == 0:
                if not ans or r - l + 1 < len(ans):
                    ans = s[l:r + 1]
                if s[l] in cnt:
                    cnt[s[l]] += 1
                    if cnt[s[l]] == 1:
                        k += 1
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        int n = s.length(), k = cnt.size();
        int l = 0, r = 0;
        String ans = "";
        while (r < n) {
            if (cnt.containsKey(s.charAt(r))) {
                int v = cnt.get(s.charAt(r));
                cnt.put(s.charAt(r), --v);
                if (v == 0) {
                    k--;
                }
            }
            while (k == 0) {
                if (ans.equals("") || r - l + 1 < ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                if (cnt.containsKey(s.charAt(l))) {
                    int v = cnt.get(s.charAt(l));
                    cnt.put(s.charAt(l), ++v);
                    if (v == 1) {
                        k++;
                    }
                }
                l++;
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
