# [377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <strong>不同</strong> 整数组成的数组 <code>nums</code> ，和一个目标整数 <code>target</code> 。请你从 <code>nums</code> 中找出并返回总和为 <code>target</code> 的元素组合的个数。</p>

<p>题目数据保证答案符合 32 位整数范围。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], target = 4
<strong>输出：</strong>7
<strong>解释：</strong>
所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
请注意，顺序不同的序列被视作不同的组合。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [9], target = 3
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 200</code></li>
	<li><code>1 <= nums[i] <= 1000</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
	<li><code>1 <= target <= 1000</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        memo = [-1] * 1001
        
        def dfs(t):
            if t == 0:
                return 1
            if t < 0:
                return 0
            if memo[t] != -1:
                return memo[t]
            ans = 0
            for num in nums:
                ans += dfs(t - num)
            memo[t] = ans
            return ans
        
        return dfs(target)

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] memo = new int[1001];

    public int combinationSum4(int[] nums, int target) {
        Arrays.fill(memo, -1);
        return dfs(nums, target);
    }
    
    public int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int num : nums) {
            ans += dfs(nums, target - num);
        }
        memo[target] = ans;
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
