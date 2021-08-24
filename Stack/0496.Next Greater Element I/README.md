# [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i)

[English Version](/solution/0400-0499/0496.Next%20Greater%20Element%20I/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个<strong> 没有重复元素</strong> 的数组 <code>nums1</code> 和 <code>nums2</code> ，其中<code>nums1</code> 是 <code>nums2</code> 的子集。</p>

<p>请你找出 <code>nums1</code> 中每个元素在 <code>nums2</code> 中的下一个比其大的值。</p>

<p><code>nums1</code> 中数字 <code>x</code> 的下一个更大元素是指 <code>x</code> 在 <code>nums2</code> 中对应位置的右边的第一个比 <code>x</code><strong> </strong>大的元素。如果不存在，对应位置输出 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2].
<strong>输出:</strong> [-1,3,-1]
<strong>解释:</strong>
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [2,4], nums2 = [1,2,3,4].
<strong>输出:</strong> [3,-1]
<strong>解释:</strong>
    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums1.length <= nums2.length <= 1000</code></li>
	<li><code>0 <= nums1[i], nums2[i] <= 10<sup>4</sup></code></li>
	<li><code>nums1</code>和<code>nums2</code>中所有整数 <strong>互不相同</strong></li>
	<li><code>nums1</code> 中的所有整数同样出现在 <code>nums2</code> 中</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(nums1.length + nums2.length)</code> 的解决方案吗？</p>


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
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stk.isEmpty() && nums2[stk.peekLast()] < nums2[i]) {
                mp.put(nums2[stk.pollLast()], nums2[i]);
            }
            stk.addLast(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = mp.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
