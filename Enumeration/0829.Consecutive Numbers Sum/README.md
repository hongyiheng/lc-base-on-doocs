# [829. 连续整数求和](https://leetcode-cn.com/problems/consecutive-numbers-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个正整数 <code>N</code>，试求有多少组连续正整数满足所有数字之和为 <code>N</code>?</p>

<p><strong>示</strong><strong>例 1:</strong></p>

<pre>
<strong>输入: </strong>5
<strong>输出: </strong>2
<strong>解释: </strong>5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>9
<strong>输出: </strong>3
<strong>解释: </strong>9 = 9 = 4 + 5 = 2 + 3 + 4</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>15
<strong>输出: </strong>4
<strong>解释: </strong>15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5</pre>

<p><strong>说明:&nbsp;</strong><code>1 &lt;= N &lt;= 10 ^ 9</code></p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        ans = 1
        for k in range(2, n):
            a = (2 * n // k - k + 1) // 2
            if a < 1:
                break
            elif n == (2 * a + k - 1) * k // 2:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 1;
        for (int k = 2; k < n; k++) {
            int a = (2 * n / k - k + 1) / 2;
            if (a < 1) {
                break;
            } else if (n == (2 * a + k - 1) * k / 2) {
                ans++;
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
