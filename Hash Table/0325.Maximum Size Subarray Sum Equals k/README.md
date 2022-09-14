# [325. 和等于 k 的最长子数组长度](https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组 <code><em>nums</em></code> 和一个目标值 <code><em>k</em></code>，找到和等于<em> <code>k</code> </em>的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 <code>0</code>。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong><em>nums</em> = <code>[1,-1,5,-2,3]</code>, <em>k</em> = <code>3</code>
<strong>输出: </strong>4 
<strong>解释: </strong>子数组 <code>[1, -1, 5, -2]</code> 和等于 3，且长度最长。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong><em>nums</em> = <code>[-2,-1,2,1]</code>, <em>k</em> = <code>1</code>
<strong>输出: </strong>2 <strong>
解释: </strong>子数组<code> [-1, 2]</code> 和等于 1，且长度最长。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 2 * 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> <= k <= 10<sup>9</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶:</strong><br />
你能使时间复杂度在 O(<em>n</em>) 内完成此题吗?</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        mp = dict()
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
            if pre[i + 1] not in mp:
                mp[pre[i + 1]] = i
        ans = 0
        for i in range(n):
            cur = pre[i + 1]
            if cur == k:
                ans = max(ans, i + 1)
                continue
            j = mp.get(cur - k, -1)
            if j != -1 and j < i:
                ans = max(ans, i - j)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0, n = nums.length;
        long[] pre = new long[n + 1];
        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            if (!mp.containsKey(pre[i + 1])) {
                mp.put(pre[i + 1], i);
            }
        }
        for (int i = 0; i < n; i++) {
            long cur = pre[i + 1];
            if (cur == k) {
                ans = Math.max(ans, i + 1);
            }
            int j = mp.getOrDefault(cur - k, -1);
            if (j != -1 && j < i) {
                ans = Math.max(ans, i - j);  
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
