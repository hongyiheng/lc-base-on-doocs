# [673. 最长递增子序列的个数](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个未排序的整数数组，找到最长递增子序列的个数。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [1,3,5,4,7]
<strong>输出:</strong> 2
<strong>解释:</strong> 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> [2,2,2,2,2]
<strong>输出:</strong> 5
<strong>解释:</strong> 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
</pre>

<p><strong>注意:</strong>&nbsp;给定的数组长度不超过 2000 并且结果一定是32位有符号整数。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp, cnt = [1] * n, [1] * n
        mx = 1
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]
                    elif dp[i] == dp[j] + 1:
                        cnt[i] += cnt[j]
            mx = max(mx, dp[i])
        ans = 0
        for i in range(n):
            if dp[i] == mx:
                ans += cnt[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int mx = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            mx = Math.max(mx, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == mx) {
                ans += count[i];
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
