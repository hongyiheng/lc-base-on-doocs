# [421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，返回<em> </em><code>nums[i] XOR nums[j]</code> 的最大运算结果，其中 <code>0 ≤ i ≤ j < n</code> 。</p>

<p><strong>进阶：</strong>你可以在 <code>O(n)</code> 的时间解决这个问题吗？</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,10,5,25,2,8]
<strong>输出：</strong>28
<strong>解释：</strong>最大运算结果是 5 XOR 25 = 28.</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,4]
<strong>输出：</strong>6
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>nums = [8,10,2]
<strong>输出：</strong>10
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>nums = [14,70,53,83,49,91,36,80,92,51,66,70]
<strong>输出：</strong>127
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>0 <= nums[i] <= 2<sup>31</sup> - 1</code></li>
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
    def findMaximumXOR(self, nums: List[int]) -> int:
        ans = mask = 0
        for i in range(30, -1, -1):
            mask |= 1 << i
            new_ans = ans | 1 << i
            vis = set()
            for v in nums:
                v &= mask
                if new_ans ^ v in vis:
                    ans = new_ans
                    break
                vis.add(v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0, mask = 0;
        for (int i = 30; i > -1; i--) {
            mask |= 1 << i;
            int newAns = ans | 1 << i;
            Set<Integer> vis = new HashSet<>();
            for (int v : nums) {
                v &= mask;
                if (vis.contains(newAns ^ v)) {
                    ans = newAns;
                    break;
                }
                vis.add(v);
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
