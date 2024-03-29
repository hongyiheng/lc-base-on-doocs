# [1071. 字符串的最大公因子](https://leetcode-cn.com/problems/greatest-common-divisor-of-strings)



## 题目描述

<!-- 这里写题目描述 -->

<p>对于字符串 <code>S</code> 和 <code>T</code>，只有在 <code>S = T + ... + T</code>（<code>T</code> 自身连接 1 次或多次）时，我们才认定 “<code>T</code> 能除尽 <code>S</code>”。</p>

<p>返回最长字符串 <code>X</code>，要求满足 <code>X</code> 能除尽 <code>str1</code> 且 <code>X</code> 能除尽 <code>str2</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>str1 = "ABCABC", str2 = "ABC"
<strong>输出：</strong>"ABC"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>str1 = "ABABAB", str2 = "ABAB"
<strong>输出：</strong>"AB"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>str1 = "LEET", str2 = "CODE"
<strong>输出：</strong>""
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 <= str1.length <= 1000</code></li>
	<li><code>1 <= str2.length <= 1000</code></li>
	<li><code>str1[i]</code> 和 <code>str2[i]</code> 为大写英文字母</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        def gcd(a, b):
            return a if not b else gcd(b, a % b)
        
        if str1 + str2 != str2 + str1:
            return ""
        return str1[0:gcd(len(str1), len(str2))]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
