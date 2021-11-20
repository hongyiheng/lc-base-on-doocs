# [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，你需要找出一个 <strong>连续子数组</strong> ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。</p>

<p>请你找出符合题意的 <strong>最短</strong> 子数组，并输出它的长度。</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,6,4,8,10,9,15]
<strong>输出：</strong>5
<strong>解释：</strong>你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> <= nums[i] <= 10<sup>5</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(n)</code> 的解决方案吗？</p>
</div>
</div>


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
    public int findUnsortedSubarray(int[] nums) {
        int[] sortArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortArray);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] != sortArray[left]) {
                break;
            }
            left++;
        }
        while (left < right) {
            if (nums[right] != sortArray[right]) {
                break;
            }
            right--;
        }
        return left == right ? 0 : right - left + 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
