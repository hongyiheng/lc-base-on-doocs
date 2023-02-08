# [2540. 最小公共值](https://leetcode-cn.com/problems/minimum-common-value)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;，它们已经按非降序排序，请你返回两个数组的 <strong>最小公共整数</strong>&nbsp;。如果两个数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;没有公共整数，请你返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>如果一个整数在两个数组中都 <strong>至少出现一次</strong>&nbsp;，那么这个整数是数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;<strong>公共</strong>&nbsp;的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [1,2,3], nums2 = [2,4]
<b>输出：</b>2
<b>解释：</b>两个数组的最小公共元素是 2 ，所以我们返回 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [1,2,3,6], nums2 = [2,3,4,5]
<b>输出：</b>2
<b>解释：</b>两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
	<li><code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;都是 <strong>非降序</strong>&nbsp;的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        i = j = 0
        m, n = len(nums1), len(nums2)
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                return nums1[i]
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                return nums1[i];
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
