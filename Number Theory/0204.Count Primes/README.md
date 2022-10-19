# [204. 计数质数](https://leetcode-cn.com/problems/count-primes)



## 题目描述

<!-- 这里写题目描述 -->

<p>统计所有小于非负整数&nbsp;<em><code>n</code>&nbsp;</em>的质数的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 10
<strong>输出：</strong>4
<strong>解释：</strong>小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 0
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 1
<strong>输出</strong>：0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPrimes(self, n: int) -> int:
        nums = [False] * n
        for i in range(2, n):
            if not nums[i]:
                x = i * i
                while x < n:
                    nums[x] = True
                    x += i
        ans = 0
        for i in range(2, n):
            if not nums[i]:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                long x = 1L * i * i;
                while (x < n) {
                    nums[(int)x] = true;
                    x += i;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
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
