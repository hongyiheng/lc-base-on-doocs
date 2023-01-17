# [400. 第 N 位数字](https://leetcode-cn.com/problems/nth-digit)



## 题目描述

<!-- 这里写题目描述 -->

<p>在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 <code>n</code><em> </em>位数字。</p>

<p> </p>

<p><strong>注意：</strong><code>n</code><em> </em>是正数且在 32 位整数范围内（<code>n < 2<sup>31</sup></code>）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>3
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>11
<strong>输出：</strong>0
<strong>解释：</strong>第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 <strong>0 </strong>，它是 10 的一部分。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findNthDigit(self, n: int) -> int:
        if n < 10:
            return n
        n -= 9
        i = 1
        while True:
            if n <= (i + 1) * 9 * 10 ** i:
                break
            n -= (i + 1) * 9 * 10 ** i
            i += 1
        n -= 1
        num = 10 ** i + n // (i + 1)
        return int(str(num)[n % (i + 1)])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        n -= 9;
        int i = 1;
        while (true) {
            if (n <= 9 * (i + 1) * Math.pow(10, i)) {
                break;
            }
            n -= 9 * (i + 1) * Math.pow(10, i);
            i++;
        }
        n--;
        int num = (int) Math.pow(10, i) + n / (i + 1);
        return String.valueOf(num).charAt(n % (i + 1)) - '0';
    }
}
```

### **...**

```

```

<!-- tabs:end -->
