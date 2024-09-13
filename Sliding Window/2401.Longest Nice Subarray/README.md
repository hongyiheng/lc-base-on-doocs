# [2401. 最长优雅子数组](https://leetcode-cn.com/problems/longest-nice-subarray)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <strong>正</strong> 整数组成的数组 <code>nums</code> 。</p>

<p>如果&nbsp;<code>nums</code> 的子数组中位于 <strong>不同</strong> 位置的每对元素按位 <strong>与（AND）</strong>运算的结果等于 <code>0</code> ，则称该子数组为 <strong>优雅</strong> 子数组。</p>

<p>返回 <strong>最长</strong> 的优雅子数组的长度。</p>

<p><strong>子数组</strong> 是数组中的一个 <strong>连续</strong> 部分。</p>

<p><strong>注意：</strong>长度为 <code>1</code> 的子数组始终视作优雅子数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,3,8,48,10]
<strong>输出：</strong>3
<strong>解释：</strong>最长的优雅子数组是 [3,8,48] 。子数组满足题目条件：
- 3 AND 8 = 0
- 3 AND 48 = 0
- 8 AND 48 = 0
可以证明不存在更长的优雅子数组，所以返回 3 。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [3,1,5,11,13]
<strong>输出：</strong>1
<strong>解释：</strong>最长的优雅子数组长度为 1 ，任何长度为 1 的子数组都满足题目条件。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        l = r = ans = msk = 0
        while r < len(nums):
            while msk & nums[r] != 0:
                msk ^= nums[l]
                l += 1
            msk |= nums[r]
            ans = max(ans, r - l + 1)
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0, ans = 0, msk = 0;
        while (r < nums.length) {
            while ((msk & nums[r]) != 0) {
                msk ^= nums[l++];
            }
            msk |= nums[r];
            ans = Math.max(ans, r - l + 1);
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
