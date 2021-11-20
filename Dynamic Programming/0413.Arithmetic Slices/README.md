# [413. 等差数列划分](https://leetcode-cn.com/problems/arithmetic-slices)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果一个数列 <strong>至少有三个元素</strong> ，并且任意两个相邻元素之差相同，则称该数列为等差数列。</p>

<ul>
	<li>例如，<code>[1,3,5,7,9]</code>、<code>[7,7,7,7]</code> 和 <code>[3,-1,-5,-9]</code> 都是等差数列。</li>
</ul>

<div class="original__bRMd">
<div>
<p>给你一个整数数组 <code>nums</code> ，返回数组 <code>nums</code> 中所有为等差数组的 <strong>子数组</strong> 个数。</p>

<p><strong>子数组</strong> 是数组中的一个连续序列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>3
<strong>解释：</strong>nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 5000</code></li>
	<li><code>-1000 <= nums[i] <= 1000</code></li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0
        mp = [0] * (n + 1)
        for i in range(1, n + 1):
            mp[i] = mp[i - 1] + i
        ans, diff, son_len = 0, nums[1] - nums[0], 1
        for i in range(2, n):
            if nums[i] - nums[i - 1] == diff:
                son_len += 1
            else:
                ans += mp[son_len - 1]
                diff = nums[i] - nums[i - 1]
                son_len = 1
        ans += mp[son_len - 1]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dict = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            dict[i] = dict[i - 1] + i;
        }

        int diff = nums[1] - nums[0];
        int sonLen = 1;
        int ans = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                ++sonLen;
            } else {
                ans += dict[sonLen - 1];
                diff = nums[i] - nums[i - 1];
                sonLen = 1;
            }
        }
        ans += dict[sonLen - 1];
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
