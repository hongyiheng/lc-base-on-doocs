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
        s = sum(nums)
        if s % 2:
            return False
        t = s // 2
        n = len(nums)
        f = [[False] * (t + 1) for _ in range(n + 1)]
        f[0][0] = True
        for i in range(n):
            for j in range(t + 1):
                f[i + 1][j] = f[i][j]
                if j >= nums[i]:
                    f[i + 1][j] |= f[i][j - nums[i]]
        return f[n][t]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0, n = nums.length;
        for (int v : nums) {
            s += v;
        }
        if (s % 2 != 0) {
            return false;
        }
        int t = s / 2;
        boolean[][] f = new boolean[n + 1][t + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= nums[i]) {
                    f[i + 1][j] |= f[i][j - nums[i]];
                }
            } 
        }
        return f[n][t];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
