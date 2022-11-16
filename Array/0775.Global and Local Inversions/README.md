# [775. 全局倒置与局部倒置](https://leetcode-cn.com/problems/global-and-local-inversions)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code> 的整数数组 <code>nums</code> ，表示由范围 <code>[0, n - 1]</code> 内所有整数组成的一个排列。</p>

<p><strong>全局倒置</strong> 的数目等于满足下述条件不同下标对 <code>(i, j)</code> 的数目：</p>

<ul>
	<li><code>0 <= i < j < n</code></li>
	<li><code>nums[i] > nums[j]</code></li>
</ul>

<p><strong>局部倒置</strong> 的数目等于满足下述条件的下标 <code>i</code> 的数目：</p>

<ul>
	<li><code>0 <= i < n - 1</code></li>
	<li><code>nums[i] > nums[i + 1]</code></li>
</ul>

<p>当数组 <code>nums</code> 中 <strong>全局倒置</strong> 的数量等于 <strong>局部倒置</strong> 的数量时，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,2]
<strong>输出：</strong>true
<strong>解释：</strong>有 1 个全局倒置，和 1 个局部倒置。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,0]
<strong>输出：</strong>false
<strong>解释：</strong>有 2 个全局倒置，和 1 个局部倒置。
</pre>
 

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 <= n <= 5000</code></li>
	<li><code>0 <= nums[i] < n</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
	<li><code>nums</code> 是范围 <code>[0, n - 1]</code> 内所有数字组成的一个排列</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isIdealPermutation(self, nums: List[int]) -> bool:
        i, n = 0, len(nums)
        mx = float('-inf')
        while i < n:
            if i < n - 1 and nums[i] > nums[i + 1]:
                if mx > nums[i + 1]:
                    return False
                mx = nums[i]
                i += 1
            else:
                if mx > nums[i]:
                    return False
                mx = nums[i]
            i += 1
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, i = 0;
        int mx = -1;
        while (i < n) {
            if (i < n - 1 && nums[i] > nums[i + 1]) {
                if (mx > nums[i + 1]) {
                    return false;
                }
                mx = nums[i];
                i++;
            } else {
                if (mx > nums[i]) {
                    return false;
                }
                mx = nums[i];
            }
            i++;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
