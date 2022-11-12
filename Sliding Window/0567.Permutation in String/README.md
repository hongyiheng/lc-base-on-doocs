# [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串 <code>s1</code> 和 <code>s2</code>，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong> </strong>的排列。</p>

<p>换句话说，第一个字符串的排列之一是第二个字符串的 <strong>子串</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>s1 = "ab" s2 = "eidbaooo"
<strong>输出: </strong>True
<strong>解释:</strong> s2 包含 s1 的排列之一 ("ba").
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>s1= "ab" s2 = "eidboaoo"
<strong>输出:</strong> False
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s1.length, s2.length <= 10<sup>4</sup></code></li>
	<li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        cnt = [0] * 26
        for c in s1:
            cnt[ord(c) - ord('a')] += 1
        l, r, n = 0, 0, len(s2)
        while r < n:
            while l < r and cnt[ord(s2[r]) - ord('a')] == 0:
                cnt[ord(s2[l]) - ord('a')] += 1
                l += 1
            if cnt[ord(s2[r]) - ord('a')] == 0:
                l += 1
            else:
                cnt[ord(s2[r]) - ord('a')] -= 1
                if r - l + 1 == len(s1):
                    return True
            r += 1
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int l = 0, r = 0, n = s2.length();
        while (r < n) {
            char c = s2.charAt(r);
            while (l < r && cnt[c - 'a'] == 0) {
                cnt[s2.charAt(l) - 'a']++;
                l++;
            }
            if (cnt[c - 'a'] == 0) {
                l++;
            } else {
                cnt[c - 'a']--;
                if (r - l + 1 == s1.length()) {
                    return true;
                }
            }
            r++;
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
