# [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数 <code>n</code> ，请你找出并返回第 <code>n</code> 个 <strong>丑数</strong> 。</p>

<p><strong>丑数 </strong>就是只包含质因数 <code>2</code>、<code>3</code> 和/或 <code>5</code> 的正整数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 10
<strong>输出：</strong>12
<strong>解释：</strong>[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
<strong>解释：</strong>1 通常被视为丑数。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 1690</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [0] * 1691
        dp[1] = 1
        i2, i3, i5 = 1, 1, 1
        for i in range(2, n + 1):
            num2, num3, num5 = dp[i2] * 2, dp[i3] * 3, dp[i5] * 5
            dp[i] = min(min(num2, num3), num5)
            if dp[i] == num2:
                i2 += 1
            if dp[i] == num3:
                i3 += 1
            if dp[i] == num5:
                i5 += 1
        return dp[n]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[1691];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[i2] * 2;
            int num3 = dp[i3] * 3;
            int num5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                i2++;
            }
            if (dp[i] == num3) {
                i3++;
            } 
            if (dp[i] == num5) {
                i5++;
            }
        }
        return dp[n];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
