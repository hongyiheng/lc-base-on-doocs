# [395. 至少有 K 个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 和一个整数 <code>k</code> ，请你找出 <code>s</code> 中的最长子串， 要求该子串中的每一字符出现次数都不少于 <code>k</code> 。返回这一子串的长度。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aaabb", k = 3
<strong>输出：</strong>3
<strong>解释：</strong>最长子串为 "aaa" ，其中 'a' 重复了 3 次。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "ababbc", k = 2
<strong>输出：</strong>5
<strong>解释：</strong>最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 10<sup>4</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
	<li><code>1 <= k <= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        cnt = Counter(s)
        for c in cnt.keys():
            if cnt[c] < k:
                ans = 0
                for ss in s.split(c):
                    ans = max(ans, self.longestSubstring(ss, k))
                return ans
        return len(s)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] < k) {
                char c = (char)('a' + i);
                int ans = 0;
                for (String ss : s.split(String.valueOf(c))) {
                    ans = Math.max(ans, longestSubstring(ss, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
