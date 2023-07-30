# [415. 字符串相加](https://leetcode-cn.com/problems/add-strings)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串形式的非负整数&nbsp;<code>num1</code> 和<code>num2</code>&nbsp;，计算它们的和。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>num1</code> 和<code>num2</code>&nbsp;的长度都小于 5100</li>
	<li><code>num1</code> 和<code>num2</code> 都只包含数字&nbsp;<code>0-9</code></li>
	<li><code>num1</code> 和<code>num2</code> 都不包含任何前导零</li>
	<li><strong>你不能使用任何內建 BigInteger 库，&nbsp;也不能直接将输入的字符串转换为整数形式</strong></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        m, n = len(num1) - 1, len(num2) - 1
        carry = False
        ans = []
        while m >= 0 or n >= 0:
            v = 1 if carry else 0
            if m >= 0:
                v += int(num1[m])
            if n >= 0:
                v += int(num2[n])
            carry = v >= 10
            ans.append(str(v % 10))
            m -= 1
            n -= 1
        if carry:
            ans.append("1")
        return "".join(ans[::-1])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        while (m >= 0 || n >= 0) {
            int v = carry ? 1 : 0;
            if (m >= 0) {
                v += num1.charAt(m) - '0';
            }
            if (n >= 0) {
                v += num2.charAt(n) - '0';
            }
            ans.append(v % 10);
            carry = v >= 10;
            m--;
            n--;
        }
        if (carry) {
            ans.append("1");
        }
        return ans.reverse().toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
