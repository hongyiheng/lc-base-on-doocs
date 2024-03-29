# [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 <strong>返回结果的字典序最小</strong>（要求不能打乱其他字符的相对位置）。</p>

<p><strong>注意：</strong>该题与 1081 <a href="https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters">https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters</a> 相同</p>

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
	<li><code>1 <= s.length <= 10<sup>4</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        cnt = collections.Counter(s)
        q, used = [], set()
        for c in s:
            if c not in used:
                while q and q[-1] > c and cnt[q[-1]] > 0:
                    used.remove(q.pop())
                q.append(c)
                used.add(c)
            cnt[c] -= 1
        return ''.join(q)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        Set<Character> used = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!used.contains(c)) {     
                while (ans.length() > 0 && ans.charAt(ans.length() - 1) > c && cnt[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    used.remove(ans.charAt(ans.length() - 1));
                    ans.deleteCharAt(ans.length() - 1);
                }
                used.add(c);
                ans.append(c);
            }
            cnt[c - 'a']--;
        }
        return ans.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
