# [1695. 删除子数组的最大得分](https://leetcode-cn.com/problems/maximum-erasure-value)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数数组 <code>nums</code> ，请你从中删除一个含有 <strong>若干不同元素</strong> 的子数组<strong>。</strong>删除子数组的 <strong>得分</strong> 就是子数组各元素之 <strong>和</strong> 。</p>

<p>返回 <strong>只删除一个</strong> 子数组可获得的 <strong>最大得分</strong><em> 。</em></p>

<p>如果数组 <code>b</code> 是数组 <code>a</code> 的一个连续子序列，即如果它等于 <code>a[l],a[l+1],...,a[r]</code> ，那么它就是 <code>a</code> 的一个子数组。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,2,4,5,6]
<strong>输出：</strong>17
<strong>解释：</strong>最优子数组是 [2,4,5,6]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,2,1,2,5,2,1,2,5]
<strong>输出：</strong>8
<strong>解释：</strong>最优子数组是 [5,2,1] 或 [1,2,5]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        pos = dict()
        ans = last = 0
        for i, v in enumerate(nums):
            pre[i + 1] = pre[i] + v
            if v in pos and pos[v] > last:
                last = pos[v]
            ans = max(ans, pre[i + 1] - pre[last])
            pos[v] = i + 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        Map<Integer, Integer> pos = new HashMap<>();
        int ans = 0, last = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            pre[i + 1] = pre[i] + v;
            if (pos.getOrDefault(v, 0) > last) {
                last = pos.get(v);
            }
            ans = Math.max(ans, pre[i + 1] - pre[last]);
            pos.put(v, i + 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
