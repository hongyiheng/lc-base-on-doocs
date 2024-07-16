# [2956. 找到两个数组中的公共元素](https://leetcode-cn.com/problems/find-common-elements-between-two-arrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;，它们分别含有 <code>n</code>&nbsp;和 <code>m</code>&nbsp;个元素。</p>

<p>请你计算以下两个数值：</p>

<ul>
	<li>统计&nbsp;<code>0 &lt;= i &lt; n</code>&nbsp;中的下标&nbsp;<code>i</code>&nbsp;，满足&nbsp;<code>nums1[i]</code>&nbsp;在 <code>nums2</code>&nbsp;中 <strong>至少</strong>&nbsp;出现了一次。</li>
	<li>统计&nbsp;<code>0 &lt;= i &lt; m</code>&nbsp;中的下标&nbsp;<code>i</code>&nbsp;，满足&nbsp;<code>nums2[i]</code>&nbsp;在 <code>nums1</code>&nbsp;中 <strong>至少</strong>&nbsp;出现了一次。</li>
</ul>

<p>请你返回一个长度为 <code>2</code>&nbsp;的整数数组<em>&nbsp;</em><code>answer</code>&nbsp;，<strong>按顺序</strong>&nbsp;分别为以上两个数值。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
<b>输出：</b>[3,4]
<b>解释：</b>分别计算两个数值：
- nums1 中下标为 1 ，2 和 3 的元素在 nums2 中至少出现了一次，所以第一个值为 3 。
- nums2 中下标为 0 ，1 ，3 和 4 的元素在 nums1 中至少出现了一次，所以第二个值为 4 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums1 = [3,4,2,3], nums2 = [1,5]
<b>输出：</b>[0,0]
<b>解释：</b>两个数组中没有公共元素，所以两个值都为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums1.length</code></li>
	<li><code>m == nums2.length</code></li>
	<li><code>1 &lt;= n, m &lt;= 100</code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1, s2 = set(nums1), set(nums2)
        ans = [0, 0]
        for v in nums1:
            if v in s2:
                ans[0] += 1
        for v in nums2:
            if v in s1:
                ans[1] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int[] ans = new int[]{0, 0};
        for (int v : nums1) {
            if (s2.contains(v)) {
                ans[0]++;
            }
        }
        for (int v : nums2) {
            if (s1.contains(v)) {
                ans[1]++;
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
