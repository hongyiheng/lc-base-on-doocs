# [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个未排序的整数数组 <code>nums</code> ，请你找出其中没有出现的最小的正整数。</p>
请你实现时间复杂度为 <code>O(n)</code> 并且只使用常数级别额外空间的解决方案。

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,0]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,4,-1,1]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [7,8,9,11,12]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 5 * 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index > nums.length) {
                index -= (nums.length + 1);
            }
            if (index == 0 || nums[index - 1] > nums.length) {
                continue;
            }
            nums[index - 1] += nums.length + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
