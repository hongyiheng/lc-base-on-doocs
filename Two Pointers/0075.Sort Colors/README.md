# [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含红色、白色和蓝色，一共 <code>n</code><em> </em>个元素的数组，<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>

<p>此题中，我们使用整数 <code>0</code>、 <code>1</code> 和 <code>2</code> 分别表示红色、白色和蓝色。</p>

<ul>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,0,2,1,1,0]
<strong>输出：</strong>[0,0,1,1,2,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,0,1]
<strong>输出：</strong>[0,1,2]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 <= n <= 300</code></li>
	<li><code>nums[i]</code> 为 <code>0</code>、<code>1</code> 或 <code>2</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong></p>

<ul>
	<li>你可以不使用代码库中的排序函数来解决这道题吗？</li>
	<li>你能想出一个仅使用常数空间的一趟扫描算法吗？</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = 0, len(nums) - 1
        for i, v in enumerate(nums):
            if v == 0:
                l += 1
            elif v == 2:
                r -= 1
        for i in range(len(nums)):
            nums[i] = 0 if i < l else (2 if i > r else 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                l++;
            } else if (nums[i] == 2) {
                r--;
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = i < l ? 0 : (i > r ? 2 : 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
