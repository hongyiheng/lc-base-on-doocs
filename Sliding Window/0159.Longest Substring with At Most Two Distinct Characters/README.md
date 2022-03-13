# [159. 至多包含两个不同字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串<strong><em> s</em></strong> ，找出&nbsp;<strong>至多&nbsp;</strong>包含两个不同字符的最长子串 <strong><em>t</em> </strong>，并返回该子串的长度。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;eceba&quot;
<strong>输出: </strong>3
<strong>解释: <em>t</em></strong> 是 &quot;ece&quot;，长度为3。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot;ccaabbb&quot;
<strong>输出: </strong>5
<strong>解释: <em>t</em></strong><em> </em>是 &quot;aabbb&quot;，长度为5。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        n = len(s)
        if n <= 2:
            return n
        mp = dict()
        left = right = 0
        win = 2
        while right < n:
            mp[s[right]] = right
            if len(mp) >= 3:
                del_val = min(mp.values())
                mp.pop(s[del_val])
                win = max(win, right - left)
                left = del_val + 1
            right += 1
        win = max(win, right - left)
        return win
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n <= 2) {
            return n;
        }
        HashMap<Character, Integer> mp = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0, right = 0, win = 2;
        while (right < n) {
            mp.put(chars[right], right);
            if (mp.size() >= 3) {
                int delVal = Integer.MAX_VALUE;
                for (Integer val : mp.values()) {
                    if (val < delVal) {
                        delVal = val;
                    }
                }
                win = Math.max(win, right - left);
                left = delVal + 1;
                mp.remove(s.charAt(delVal));
            }
            right++;
        }
        win = Math.max(win, right - left);
        return win;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
