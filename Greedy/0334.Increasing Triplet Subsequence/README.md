# [334. 递增的三元子序列](https://leetcode-cn.com/problems/increasing-triplet-subsequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，判断这个数组中是否存在长度为 <code>3</code> 的递增子序列。</p>

<p>如果存在这样的三元组下标 <code>(i, j, k)</code> 且满足 <code>i < j < k</code> ，使得 <code>nums[i] < nums[j] < nums[k]</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4,5]
<strong>输出：</strong>true
<strong>解释：</strong>任何 i < j < k 的三元组都满足题意
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,3,2,1]
<strong>输出：</strong>false
<strong>解释：</strong>不存在满足题意的三元组</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,1,5,0,4,6]
<strong>输出：</strong>true
<strong>解释：</strong>三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你能实现时间复杂度为 <code>O(n)</code> ，空间复杂度为 <code>O(1)</code> 的解决方案吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        n, ans = len(nums), 1
        dp = [float('inf')] * (n + 1)
        for i in range(n):
            cur = nums[i]
            l, r = 1, i + 1
            while l < r:
                mid = (l + r) >> 1
                if dp[mid] >= cur:
                    r = mid
                else:
                    l = mid + 1
            dp[r] = cur
            ans = max(ans, r)
        return ans >= 3
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (dp[mid] >= cur) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            dp[r] = cur;
            ans = Math.max(ans, r);
        }
        return ans >= 3;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
