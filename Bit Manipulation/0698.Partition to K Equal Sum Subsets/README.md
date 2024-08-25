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
        @cache
        def dfs(msk, s):
            nonlocal t
            if msk == (1 << len(nums)) - 1:
                return True
            for i, v in enumerate(nums):
                if msk >> i & 1:
                    continue
                if s + v > t:
                    break
                if dfs(msk | 1 << i, (s + v) % t):
                    return True
            return False
                

        s = sum(nums)
        if s % k != 0:
            return False
        t = s // k
        nums.sort()
        return dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n, t;
    int[] f;

    public boolean dfs(int[] nums, int msk, int s) {
        if (msk == (1 << n) - 1) {
            return true;
        }
        if (f[msk] != 0) {
            return f[msk] == 1;
        }
        for (int i = 0; i < n; i++) {
            if ((msk >> i & 1) != 0) {
                continue;
            }
            if (s + nums[i] > t) {
                break;
            }
            if (dfs(nums, msk | 1 << i, (s + nums[i]) % t)) {
                f[msk] = 1;
                return true;
            }
        }
        f[msk] = -1;
        return false;
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int s = 0;
        for (int v : nums) {
            s += v;
        }
        if (s % k != 0) {
            return false;
        }
        t = s / k;
        f = new int[1 << n];
        Arrays.sort(nums);
        return dfs(nums, 0, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
