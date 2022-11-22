# [878. 第 N 个神奇数字](https://leetcode-cn.com/problems/nth-magical-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果正整数可以被 A 或 B 整除，那么它是神奇的。</p>

<p>返回第 N 个神奇数字。由于答案可能非常大，<strong>返回它模&nbsp;</strong><code>10^9 + 7</code>&nbsp;<strong>的结果</strong>。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>N = 1, A = 2, B = 3
<strong>输出：</strong>2
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre><strong>输入：</strong>N = 4, A = 2, B = 3
<strong>输出：</strong>6
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>N = 5, A = 2, B = 4
<strong>输出：</strong>10
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>N = 3, A = 6, B = 4
<strong>输出：</strong>8
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= N&nbsp;&lt;= 10^9</code></li>
	<li><code>2 &lt;= A&nbsp;&lt;= 40000</code></li>
	<li><code>2 &lt;= B&nbsp;&lt;= 40000</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        
        mod = int(1e9 + 7)
        if a > b:
            return self.nthMagicalNumber(n, b, a)
        c = a * b // gcd(a, b)
        left, right = 0, a * n
        while left < right:
            mid = (left + right) >> 1
            if mid // a + mid // b - mid // c < n:
                left = mid + 1
            else:
                right = mid
        return left % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = (int)1e9 + 7;
        if (b > a) {
            return nthMagicalNumber(n, b, a);
        }
        long c = 1L * a * b / gcd(a, b);
        long left = 0, right = 1L * a * n;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (mid / a + mid / b - mid / c < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)(left % mod);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
