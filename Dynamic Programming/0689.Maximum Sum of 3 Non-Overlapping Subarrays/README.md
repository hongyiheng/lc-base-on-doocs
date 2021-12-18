# [689. 三个无重叠子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定数组&nbsp;<code>nums</code>&nbsp;由正整数组成，找到三个互不重叠的子数组的最大和。</p>

<p>每个子数组的长度为<code>k</code>，我们要使这<code>3*k</code>个项的和最大化。</p>

<p>返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> [1,2,1,2,6,7,5,1], 2
<strong>输出:</strong> [0, 3, 5]
<strong>解释:</strong> 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
</pre>

<p><strong>注意:</strong></p>

<ul>
	<li><code>nums.length</code>的范围在<code>[1, 20000]</code>之间。</li>
	<li><code>nums[i]</code>的范围在<code>[1, 65535]</code>之间。</li>
	<li><code>k</code>的范围在<code>[1, floor(nums.length / 3)]</code>之间。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + nums[i - 1]
        dp = [[0 for _ in range(4)] for _ in range(n + 1)]
        for i in range(k, n + 1):
            s = pre[i] - pre[i - k]
            for j in range(1, 4):
                dp[i][j] = max(dp[i - 1][j], dp[i - k][j - 1] + s)
        index, ans = n, [0] * 3
        for i in range(2, -1, -1):
            while dp[index - 1][i + 1] >= dp[index][i + 1]:
                index -= 1
            ans[i] = index - k
            index -= k
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n + 1][4];
        for (int i = k; i < n + 1; i++) {
            int s = pre[i] - pre[i - k];
            for (int j = 1; j < 4; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + s);
            }
        }
        int[] ans = new int[3];
        int index = n;
        for (int i = 2; i >= 0; i--) {
            while (dp[index - 1][i + 1] >= dp[index][i + 1]) {
                index--;
            }
            ans[i] = index - k;
            index -= k;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
