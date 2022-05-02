# [1099. 小于 K 的两数之和](https://leetcode-cn.com/problems/two-sum-less-than-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 和整数 <code>k</code> ，返回最大和 <code>sum</code> ，满足存在 <code>i < j</code> 使得 <code>nums[i] + nums[j] = sum</code> 且 <code>sum < k</code> 。如果没有满足此等式的 <code>i,j</code> 存在，则返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [34,23,1,24,75,33,54,8], k = 60
<strong>输出：</strong>58
<strong>解释：</strong>
34 和 24 相加得到 58，58 小于 60，满足题意。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,20,30], k = 15
<strong>输出：</strong>-1
<strong>解释：</strong>
我们无法找到和小于 15 的两个元素。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 100</code></li>
	<li><code>1 <= nums[i] <= 1000</code></li>
	<li><code>1 <= k <= 2000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        ans, n = -1, len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] < k:
                    ans = max(nums[i] + nums[j], ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] < k) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }
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
