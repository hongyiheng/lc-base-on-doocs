# [357. 计算各个位数不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个<strong>非负</strong>整数 n，计算各位数字都不同的数字 x 的个数，其中 0 &le; x &lt; 10<sup>n&nbsp;</sup>。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入: </strong>2
<strong>输出: </strong>91 
<strong>解释: </strong>答案应为除去 <code>11,22,33,44,55,66,77,88,99 </code>外，在 [0,100) 区间内的所有数字。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        dp = [0] * 10
        dp[0] = 1
        dp[1] = 9
        cur, num = 9, 9
        for i in range(2, n + 1):
            cur *= num
            dp[i] = cur
            num -= 1
        ans = 0
        for i in range(n + 1):
            ans += dp[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[10];
        dp[0] = 1;
        dp[1] = 9;
        int cur = 9, num = 9;
        for (int i = 2; i <= n; i++) {
            cur *= num--;
            dp[i] = cur;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
