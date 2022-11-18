# [891. 子序列宽度之和](https://leetcode-cn.com/problems/sum-of-subsequence-widths)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组 <code>A</code> ，考虑 <code>A</code> 的所有非空子序列。</p>

<p>对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。</p>

<p>返回 A 的所有子序列的宽度之和。</p>

<p>由于答案可能非常大，请<strong>返回答案模 10^9+7</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[2,1,3]
<strong>输出：</strong>6
<strong>解释：
</strong>子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
相应的宽度是 0，0，0，1，1，2，2 。
这些宽度之和是 6 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
	<li><code>1 &lt;= A[i] &lt;= 20000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        mod = int(1e9 + 7)
        n = len(nums)
        p = [1] * n
        for i in range(1, n):
            p[i] = p[i - 1] * 2 % mod
        nums.sort()
        ans = 0
        for i in range(n):
            ans += (p[i] - p[n - i - 1]) * nums[i]
            ans %= mod
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int sumSubseqWidths(int[] nums) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        long[] p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * 2L % mod;
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (p[i] - p[n - i - 1]) * nums[i] % mod) % mod;
        }
        return (int)ans % mod;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
