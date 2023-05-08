# [1461. 检查一个字符串是否包含所有长度为 K 的二进制子串](https://leetcode-cn.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制字符串 <code>s</code> 和一个整数 <code>k</code> 。</p>

<p>如果所有长度为 <code>k</code> 的二进制字符串都是 <code>s</code> 的子串，请返回 <code>true</code> ，否则请返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "00110110", k = 2
<strong>输出：</strong>true
<strong>解释：</strong>长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "00110", k = 2
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "0110", k = 1
<strong>输出：</strong>true
<strong>解释：</strong>长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "0110", k = 2
<strong>输出：</strong>false
<strong>解释：</strong>长度为 2 的二进制串 "00" 没有出现在 s 中。
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>s = "0000000001011100", k = 4
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 5 * 10<sup>5</sup></code></li>
	<li><code>s[i]</code> 不是<code>'0'</code> 就是 <code>'1'</code></li>
	<li><code>1 <= k <= 20</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        cnt = set()
        cur = w = 0
        for i in range(len(s)):
            cur = (cur << 1) + int(s[i])
            w += 1
            if w >= k:
                cnt.add(cur)
                cur -= int(s[i - k + 1]) << (k - 1)
                w -= 1
        return len(cnt) == (1 << k) 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> cnt = new HashSet<>();
        int cur = 0, w = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = (cur << 1) + s.charAt(i) - '0';
            if (++w >= k) {
                cnt.add(cur);
                cur -= (s.charAt(i - k + 1) - '0') << (k - 1);
                w--;
            }
        }
        return cnt.size() == (1 << k);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
