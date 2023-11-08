# [2609. 最长平衡子字符串](https://leetcode-cn.com/problems/find-the-longest-balanced-substring-of-a-binary-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个仅由 <code>0</code> 和 <code>1</code> 组成的二进制字符串 <code>s</code> 。<span style="">&nbsp;</span><span style="">&nbsp;</span></p>

<p>如果子字符串中 <strong>所有的<span style=""> </span></strong><code><span style="">0</span></code><strong><span style=""> </span>都在 </strong><code>1</code><strong> 之前</strong> 且其中 <code>0</code> 的数量等于 <code>1</code> 的数量，则认为 <code>s</code> 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。<span style="">&nbsp;</span></p>

<p>返回&nbsp;<span style=""> </span><code>s</code> 中最长的平衡子字符串长度。</p>

<p>子字符串是字符串中的一个连续字符序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "01000111"
<strong>输出：</strong>6
<strong>解释：</strong>最长的平衡子字符串是 "000111" ，长度为 6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "00111"
<strong>输出：</strong>4
<strong>解释：</strong>最长的平衡子字符串是 "0011" ，长度为 <span style="">&nbsp;</span>4 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "111"
<strong>输出：</strong>0
<strong>解释：</strong>除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>'0' &lt;= s[i] &lt;= '1'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:     
        a = b = ans = 0
        for c in s:
            if c == '0':
                if b:
                    a = b = 0
                a += 1
            else:
                b += 1
                ans = max(ans, 2 * min(a, b))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int a = 0, b = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (b > 0) {
                    a = 0;
                    b = 0;
                }
                a++;
            } else {
                b++;
                ans = Math.max(ans, 2 * Math.min(a, b));
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
