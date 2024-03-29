# [698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组&nbsp;&nbsp;<code>nums</code> 和一个正整数 <code>k</code>，找出是否有可能把这个数组分成 <code>k</code> 个非空子集，其总和都相等。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong> nums = [4, 3, 2, 3, 5, 2, 1], k = 4
<strong>输出：</strong> True
<strong>说明：</strong> 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= len(nums) &lt;= 16</code></li>
	<li><code>0 &lt; nums[i] &lt; 10000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        n, t = len(nums), 0
        nums.sort()
        for v in nums:
            t += v
        if t % k != 0:
            return False
        t //= k

        @cache
        def dfs(state, cur):
            if state == (1 << n) - 1:
                return True
            for i in range(n):
                if (1 << i) & state != 0:
                    continue
                if cur + nums[i] > t:
                    break
                if dfs(state | (1 << i), (cur + nums[i]) % t):
                    return True
            return False
        
        return dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] nums;
    int n, t;
    boolean[] used;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;
        Arrays.sort(nums);
        for (int v : nums) {
            t += v;
        }
        if (t % k != 0) {
            return false;
        }
        t /= k;
        used = new boolean[1 << n];
        return dfs(0, 0);
    }

    private boolean dfs(int state, int cur) {
        if (state == (1 << n) - 1) {
            return true;
        }
        if (used[state]) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if ((1 << i & state) != 0) {
                continue;
            }
            if (cur + nums[i] > t) {
                break;
            }
            if (dfs(state | 1 << i, (cur + nums[i]) % t)) {
                return true;
            }
        }
        used[state] = true;
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
