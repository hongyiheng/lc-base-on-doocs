# [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>只包含正整数 </strong>的 <strong>非空 </strong>数组 <code>nums</code> 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,11,5]
<strong>输出：</strong>true
<strong>解释：</strong>数组可以分割成 [1, 5, 5] 和 [11] 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,5]
<strong>输出：</strong>false
<strong>解释：</strong>数组不能分割成两个元素和相等的子集。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 200</code></li>
	<li><code>1 <= nums[i] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n, total = len(nums), sum(nums)
        if total % 2 != 0:
            return False
        mid = total >> 1
        dp = [[0] * (mid + 1) for _ in range(n)]
        for i in range(mid + 1):
            dp[0][i] = nums[0] if i >= nums[0] else 0
        for i in range(1, n):
            t = nums[i]
            for j in range(mid + 1):
                a = dp[i - 1][j]
                b = dp[i - 1][j - t] + t if j >= t else 0
                dp[i][j] = max(a, b)
        return dp[n - 1][mid] == mid
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int mid = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][mid + 1];
        for (int i = 0; i < mid + 1; i++) {
            dp[0][i] = i > nums[0] ? nums[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j < mid + 1; j++) {
                int a = dp[i - 1][j];
                int b = j >= t ? dp[i - 1][j - t] + t : 0;
                dp[i][j] = Math.max(a, b);
            }
        }
        return dp[n - 1][mid] == mid;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
