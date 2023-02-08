# [2541. 使数组中所有元素相等的最小操作数 II](https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;，两个数组长度都是&nbsp;<code>n</code>&nbsp;，再给你一个整数&nbsp;<code>k</code>&nbsp;。你可以对数组&nbsp;<code>nums1</code>&nbsp;进行以下操作：</p>

<ul>
	<li>选择两个下标&nbsp;<code>i</code> 和&nbsp;<code>j</code>&nbsp;，将&nbsp;<code>nums1[i]</code>&nbsp;增加&nbsp;<code>k</code>&nbsp;，将&nbsp;<code>nums1[j]</code>&nbsp;减少&nbsp;<code>k</code>&nbsp;。换言之，<code>nums1[i] = nums1[i] + k</code> 且&nbsp;<code>nums1[j] = nums1[j] - k</code>&nbsp;。</li>
</ul>

<p>如果对于所有满足&nbsp;<code>0 &lt;= i &lt; n</code>&nbsp;都有&nbsp;<code>num1[i] == nums2[i]</code>&nbsp;，那么我们称&nbsp;<code>nums1</code> <strong>等于</strong>&nbsp;<code>nums2</code>&nbsp;。</p>

<p>请你返回使<em>&nbsp;</em><code>nums1</code><em> </em>等于<em>&nbsp;</em><code>nums2</code>&nbsp;的&nbsp;<strong>最少</strong>&nbsp;操作数。如果没办法让它们相等，请你返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [4,3,1,4], nums2 = [1,3,7,1], k = 3
<b>输出：</b>2
<b>解释：</b>我们可以通过 2 个操作将 nums1 变成 nums2 。
第 1 个操作：i = 2 ，j = 0 。操作后得到 nums1 = [1,3,4,4] 。
第 2 个操作：i = 2 ，j = 3 。操作后得到 nums1 = [1,3,7,1] 。
无法用更少操作使两个数组相等。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [3,8,5,2], nums2 = [2,4,1,6], k = 1
<b>输出：</b>-1
<b>解释：</b>无法使两个数组相等。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums1.length == nums2.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int], k: int) -> int:
        if k == 0:
            return 0 if nums1 == nums2 else -1
        diff = ans = 0
        for a, b in zip(nums1, nums2):
            if abs(a - b) % k:
                return -1
            if a - b > 0:
                ans += (a - b) // k
            diff += a - b
        return ans if diff == 0 else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        long ans = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums1[i] - nums2[i]) % k != 0) {
                return -1;
            }
            if (nums1[i] - nums2[i] > 0) {
                ans += (nums1[i] - nums2[i]) / k;
            }
            diff += nums1[i] - nums2[i];
        }
        return diff == 0 ? ans : -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
