# [67. 二进制求和](https://leetcode-cn.com/problems/add-binary)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个二进制字符串，返回它们的和（用二进制表示）。</p>

<p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
<strong>输出:</strong> &quot;100&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
<strong>输出:</strong> &quot;10101&quot;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
	<li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
	<li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n, m = len(a) - 1, len(b) - 1
        e = False
        ans = ""
        while n >= 0 or m >= 0:
            cur = 1 if e else 0
            e = False
            if n >= 0 and a[n] == "1":
                cur += 1
            if m >= 0 and b[m] == "1":
                cur += 1
            if cur >= 2:
                cur -= 2
                e = True
            ans = str(cur) + ans
            n -= 1
            m -= 1
        return "1" + ans if e else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length() - 1, m = b.length() - 1;
        String ans = "";
        boolean e = false;
        while (n >= 0 || m >= 0) {
            int cur = e ? 1 : 0;
            e = false;
            if (n >= 0 && a.charAt(n) == '1') {
                cur++;
            }
            if (m >= 0 && b.charAt(m) == '1') {
                cur++;
            }
            if (cur >= 2) {
                cur -= 2;
                e = true;
            }
            ans = String.valueOf(cur) + ans;
            m--;
            n--;
        }
        return e ? "1" + ans : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
