# [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 <strong>围成一圈</strong> ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong> 。</p>

<p>给定一个代表每个房屋存放金额的非负整数数组，计算你 <strong>在不触动警报装置的情况下</strong> ，今晚能够偷窃到的最高金额。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,2]
<strong>输出：</strong>3
<strong>解释：</strong>你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1]
<strong>输出：</strong>4
<strong>解释：</strong>你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 100</code></li>
	<li><code>0 <= nums[i] <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        dp1 = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n):
            dp1[i][0] = max(dp1[i - 1][0], dp1[i - 1][1])
            dp1[i][1] = dp1[i - 1][0] + nums[i - 1]
        dp2 = [[0] * 2 for _ in range(n + 1)]
        for i in range(2, n + 1):
            dp2[i][0] = max(dp2[i - 1][0], dp2[i - 1][1])
            dp2[i][1] = dp2[i - 1][0] + nums[i - 1]
        return max(max(dp1[n - 1][0], dp1[n - 1][1]), max(dp2[n][0], dp2[n][1]))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp1 = new int[n + 1][2];  
        for (int i = 1; i < n; i++) {
            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
            dp1[i][1] = dp1[i - 1][0] + nums[i - 1];
        }
        int[][] dp2 = new int[n + 1][2];
        for (int i = 2; i < n + 1; i++) {
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] = dp2[i - 1][0] + nums[i - 1];
        }
        return Math.max(Math.max(dp1[n - 1][0], dp1[n - 1][1]), Math.max(dp2[n][0], dp2[n][1]));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
