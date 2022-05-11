# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的 <strong>最长子串 </strong>的长度。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>s = "abcabcbb"
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>"abc"，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "bbbbb"
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>"b"</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = "pwwkew"
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是 <code>"wke"</code>，所以其长度为 3。
     请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>"pwke"</code> 是一个<em>子序列，</em>不是子串。
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入: </strong>s = ""
<strong>输出: </strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> 由英文字母、数字、符号和空格组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = dict()
        left, n, ans = 0, len(s), 0
        for right in range(n):
            while cnt.get(s[right], 0) == 1:
                cnt[s[left]] = 0
                left += 1
            cnt[s[right]] = 1
            ans = max(ans, right - left + 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int left = 0, n = s.length(), ans = 0;
        for (int right = 0; right < n; right++) {
            while (cnt.getOrDefault(s.charAt(right), 0) == 1) {
                cnt.put(s.charAt(left++), 0);
            }
            cnt.put(s.charAt(right), 1);
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
