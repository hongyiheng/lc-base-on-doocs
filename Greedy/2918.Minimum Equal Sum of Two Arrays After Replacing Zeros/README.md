# [2918. 数组的最小相等和](https://leetcode-cn.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个由正整数和 <code>0</code> 组成的数组 <code>nums1</code> 和 <code>nums2</code> 。</p>

<p>你必须将两个数组中的<strong> 所有</strong> <code>0</code> 替换为 <strong>严格</strong> 正整数，并且满足两个数组中所有元素的和 <strong>相等</strong> 。</p>

<p>返回 <strong>最小</strong> 相等和 ，如果无法使两数组相等，则返回 <code>-1</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [3,2,0,1,0], nums2 = [6,5,0]
<strong>输出：</strong>12
<strong>解释：</strong>可以按下述方式替换数组中的 0 ：
- 用 2 和 4 替换 nums1 中的两个 0 。得到 nums1 = [3,2,2,1,4] 。
- 用 1 替换 nums2 中的一个 0 。得到 nums2 = [6,5,1] 。
两个数组的元素和相等，都等于 12 。可以证明这是可以获得的最小相等和。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,0,2,0], nums2 = [1,4]
<strong>输出：</strong>-1
<strong>解释：</strong>无法使两个数组的和相等。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        s1 = s2 = 0
        cnt1 = cnt2 = 0
        for v in nums1:
            s1 += v
            if v == 0:
                cnt1 += 1
        for v in nums2:
            s2 += v
            if v == 0:
                cnt2 += 1
        if (cnt1 == 0 and s1 < s2 + cnt2) or (cnt2 == 0 and s1 + cnt1 > s2):
            return -1
        return max(s1 + cnt1, s2 + cnt2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int v : nums1) {
            s1 += v;
            if (v == 0) {
                cnt1++;
            }
        }
        for (int v : nums2) {
            s2 += v;
            if (v == 0) {
                cnt2++;
            }
        }
        if ((cnt1 == 0 && s1 < s2 + cnt2) || (cnt2 == 0 && s1 + cnt1 > s2)) {
            return -1;
        } 
        return Math.max(s1 + cnt1, s2 + cnt2); 
    }
}
```

### **...**

```

```

<!-- tabs:end -->
