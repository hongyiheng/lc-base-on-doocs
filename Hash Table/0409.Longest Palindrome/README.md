# [409. 最长回文串](https://leetcode-cn.com/problems/longest-palindrome)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。</p>

<p>在构造过程中，请注意区分大小写。比如&nbsp;<code>&quot;Aa&quot;</code>&nbsp;不能当做一个回文字符串。</p>

<p><strong>注意:</strong><br />
假设字符串的长度不会超过 1010。</p>

<p><strong>示例 1: </strong></p>

<pre>
输入:
&quot;abccccdd&quot;

输出:
7

解释:
我们可以构造的最长的回文串是&quot;dccaccd&quot;, 它的长度是 7。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestPalindrome(self, s: str) -> int:
        n = ord('z') - ord('A') + 1
        cnt = [0] * n
        for c in s:
            cnt[ord(c) - ord('A')] += 1
        ans = 0
        extra = False
        for v in cnt:
            ans += v // 2 * 2
            if v % 2 != 0:
                extra = True
        return ans + 1 if extra else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestPalindrome(String s) {
        int n = 'z' - 'A' + 1;
        int[] cnt = new int[n];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int ans = 0;
        boolean extra = false;
        for (int v : cnt) {
            if (v % 2 != 0) {
                extra = true;
            }
            ans += v / 2 * 2;
        }
        return extra ? ans + 1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
