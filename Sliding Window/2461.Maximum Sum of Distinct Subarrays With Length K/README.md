# [2461. 长度为 K 子数组中的最大和](https://leetcode-cn.com/problems/maximum-sum-of-distinct-subarrays-with-length-k)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> 。请你从 <code>nums</code> 中满足下述条件的全部子数组中找出最大子数组和：</p>

<ul>
	<li>子数组的长度是 <code>k</code>，且</li>
	<li>子数组中的所有元素 <strong>各不相同 。</strong></li>
</ul>

<p>返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 <code>0</code> 。</p>

<p><strong>子数组</strong> 是数组中一段连续非空的元素序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,5,4,2,9,9,9], k = 3
<strong>输出：</strong>15
<strong>解释：</strong>nums 中长度为 3 的子数组是：
- [1,5,4] 满足全部条件，和为 10 。
- [5,4,2] 满足全部条件，和为 11 。
- [4,2,9] 满足全部条件，和为 15 。
- [2,9,9] 不满足全部条件，因为元素 9 出现重复。
- [9,9,9] 不满足全部条件，因为元素 9 出现重复。
因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [4,4,4], k = 3
<strong>输出：</strong>0
<strong>解释：</strong>nums 中长度为 3 的子数组是：
- [4,4,4] 不满足全部条件，因为元素 4 出现重复。
因为不存在满足全部条件的子数组，所以返回 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        l = r = ans = cur = 0
        mp = dict()
        while r < n:
            while mp.get(nums[r], 0) or r - l + 1 > k:
                mp[nums[l]] -= 1
                cur -= nums[l]
                l += 1
            mp[nums[r]] = 1
            cur += nums[r]
            if r - l + 1 == k:
                ans = max(cur, ans)
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        long ans = 0, cur = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (r < n) {
            while (r - l + 1 > k || mp.getOrDefault(nums[r], 0) > 0) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                cur -= nums[l];
                l++;
            }
            mp.put(nums[r], 1);
            cur += nums[r];
            if (r - l + 1 == k) {
                ans = Math.max(ans, cur);
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
