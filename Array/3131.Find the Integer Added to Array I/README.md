# [3131. 找出与数组相加的整数 I](https://leetcode.cn/problems/find-the-integer-added-to-array-i)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个长度相等的数组 <code>nums1</code> 和 <code>nums2</code>。</p>

<p>数组 <code>nums1</code> 中的每个元素都与变量 <code>x</code> 所表示的整数相加。如果 <code>x</code> 为负数，则表现为元素值的减少。</p>

<p>在与 <code>x</code> 相加后，<code>nums1</code> 和 <code>nums2</code> <strong>相等</strong> 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 <strong>相等</strong> 。</p>

<p>返回整数 <code>x</code> 。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">nums1 = [2,6,4], nums2 = [9,7,5]</span></p>

<p><strong>输出：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">3</span></p>

<p><strong>解释：</strong></p>

<p>与 3 相加后，<code>nums1</code> 和 <code>nums2</code> 相等。</p>
</div>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">nums1 = [10], nums2 = [5]</span></p>

<p><strong>输出：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">-5</span></p>

<p><strong>解释：</strong></p>

<p>与 <code>-5</code> 相加后，<code>nums1</code> 和 <code>nums2</code> 相等。</p>
</div>

<p><strong class="example">示例 3:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">nums1 = [1,1,1,1], nums2 = [1,1,1,1]</span></p>

<p><strong>输出：</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">0</span></p>

<p><strong>解释：</strong></p>

<p>与 0 相加后，<code>nums1</code> 和 <code>nums2</code> 相等。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length == nums2.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
	<li>测试用例以这样的方式生成：存在一个整数 <code>x</code>，使得 <code>nums1</code> 中的每个元素都与 <code>x</code> 相加后，<code>nums1</code> 与 <code>nums2</code> 相等。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def addedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        return min(nums2) - min(nums1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int m1 = nums1[0], m2 = nums2[0];
        for (int v : nums1) {
            m1 = Math.min(v, m1);
        }
        for (int v : nums2) {
            m2 = Math.min(v, m2);
        }
        return m2 - m1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
