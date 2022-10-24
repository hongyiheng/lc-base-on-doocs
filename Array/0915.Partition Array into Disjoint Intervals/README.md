# [915. 分割数组](https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组 <code>A</code>，将其划分为两个连续子数组 <code>left</code> 和 <code>right</code>， 使得：</p>

<ul>
	<li><code>left</code> 中的每个元素都小于或等于 <code>right</code> 中的每个元素。</li>
	<li><code>left</code> 和 <code>right</code> 都是非空的。</li>
	<li><code>left</code> 的长度要尽可能小。</li>
</ul>

<p>在完成这样的分组后返回 <code>left</code> 的<strong>长度</strong>。可以保证存在这样的划分方法。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[5,0,3,8,6]
<strong>输出：</strong>3
<strong>解释：</strong>left = [5,0,3]，right = [8,6]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[1,1,1,0,6,12]
<strong>输出：</strong>4
<strong>解释：</strong>left = [1,1,1,0]，right = [6,12]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>2 <= A.length <= 30000</code></li>
	<li><code>0 <= A[i] <= 10^6</code></li>
	<li>可以保证至少有一种方法能够按题目所描述的那样对 <code>A</code> 进行划分。</li>
</ol>

<p> </p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        n = len(nums)
        min_val, min_idx = nums[0], 0
        for i, v in enumerate(nums):
            if v < min_val:
                min_val = v
                min_idx = i
        max_val = max(nums[:min_idx + 1])
        next_max = max_val
        ans = min_idx + 1
        for i in range(min_idx + 1, n):
            if nums[i] < max_val:
                max_val = next_max
                ans = i + 1
            next_max = max(nums[i], next_max)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int minVal = nums[0], minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIdx = i;
            }
        }
        int maxVal = 0;
        for (int i = 0; i < minIdx + 1; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int ans = minIdx + 1, nextMax = maxVal;
        for (int i = minIdx + 1; i < n; i++) {
            if (nums[i] < maxVal) {
                ans = i + 1;
                maxVal = nextMax;
            }
            nextMax = Math.max(nextMax, nums[i]);
        } 
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
