# [1995. 统计特殊四元组](https://leetcode-cn.com/problems/count-special-quadruplets)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>下标从 0 开始</strong> 的整数数组 <code>nums</code> ，返回满足下述条件的 <strong>不同</strong> 四元组 <code>(a, b, c, d)</code> 的 <strong>数目</strong> ：</p>

<ul>
	<li><code>nums[a] + nums[b] + nums[c] == nums[d]</code> ，且</li>
	<li><code>a &lt; b &lt; c &lt; d</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,2,3,6]
<strong>输出：</strong>1
<strong>解释：</strong>满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [3,3,6,4,5]
<strong>输出：</strong>0
<strong>解释：</strong>[3,3,6,4,5] 中不存在满足要求的四元组。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums = [1,1,1,3,5]
<strong>输出：</strong>4
<strong>解释：</strong>满足要求的 4 个四元组如下：
- (0, 1, 2, 3): 1 + 1 + 1 == 3
- (0, 1, 3, 4): 1 + 1 + 3 == 5
- (0, 2, 3, 4): 1 + 1 + 3 == 5
- (1, 2, 3, 4): 1 + 1 + 3 == 5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>4 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[[0] * (4) for _ in range(101)] for _ in range(n + 1)]
        dp[0][0][0] = 1
        for i in range(1, n + 1):
            c = nums[i - 1]
            for j in range(101):
                for k in range(4):
                    dp[i][j][k] = dp[i - 1][j][k]
                    if j >= c and k >= 1:
                        dp[i][j][k] += dp[i - 1][j - c][k - 1]
        ans = 0
        for i in range(3, n):
            ans += dp[i][nums[i]][3]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][101][4];
        dp[0][0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int c = nums[i - 1];
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] += dp[i - 1][j][k];
                    if (k >= 1 && j >= c) {
                        dp[i][j][k] += dp[i - 1][j - c][k - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 3; i < n; i++) {
            ans += dp[i][nums[i]][3];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
