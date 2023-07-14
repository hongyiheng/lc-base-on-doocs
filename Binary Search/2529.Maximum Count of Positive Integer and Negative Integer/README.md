# [2529. 正整数和负整数的最大计数](https://leetcode-cn.com/problems/maximum-count-of-positive-integer-and-negative-integer)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个按 <strong>非递减顺序</strong> 排列的数组 <code>nums</code> ，返回正整数数目和负整数数目中的最大值。</p>

<ul>
	<li>换句话讲，如果 <code>nums</code> 中正整数的数目是 <code>pos</code> ，而负整数的数目是 <code>neg</code> ，返回 <code>pos</code> 和 <code>neg</code>二者中的最大值。</li>
</ul>

<p><strong>注意：</strong><code>0</code> 既不是正整数也不是负整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-2,-1,-1,1,2,3]
<strong>输出：</strong>3
<strong>解释：</strong>共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [-3,-2,-1,0,0,1,2]
<strong>输出：</strong>3
<strong>解释：</strong>共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,20,66,1314]
<strong>输出：</strong>4
<strong>解释：</strong>共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2000</code></li>
	<li><code>-2000 &lt;= nums[i] &lt;= 2000</code></li>
	<li><code>nums</code> 按 <strong>非递减顺序</strong> 排列。</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以设计并实现时间复杂度为 <code>O(log(n))</code> 的算法解决此问题吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] < 0:
                l = mid + 1
            else:
                r = mid
        if nums[r] < 0:
            return n
        while r < n and nums[r] == 0:
            r += 1
        return max(l, n - r)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[r] < 0) {
            return n;
        }
        while (r < n && nums[r] == 0) {
            r++;
        }
        return Math.max(l, n - r);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
