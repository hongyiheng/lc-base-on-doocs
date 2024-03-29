# [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 <em>k </em>次。在执行上述操作后，找到包含重复字母的最长子串的长度。</p>

<p><strong>注意：</strong>字符串长度 和 <em>k </em>不会超过 10<sup>4</sup>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ABAB", k = 2
<strong>输出：</strong>4
<strong>解释：</strong>用两个'A'替换为两个'B',反之亦然。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "AABABBA", k = 1
<strong>输出：</strong>4
<strong>解释：</strong>
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        cnt = [0] * 26
        l = r = mx = 0
        n = len(s)
        while r < n:
            idx = ord(s[r]) - ord('A')
            cnt[idx] += 1
            mx = max(mx, cnt[idx])
            if r - l + 1 > mx + k:
                cnt[ord(s[l]) - ord('A')] -= 1
                l += 1
            r += 1
        return r - l
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        int l = 0, r = 0, mx = 0;
        while (r < n) {
            mx = Math.max(mx, ++cnt[s.charAt(r) - 'A']);
            if (r - l + 1 > mx + k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
