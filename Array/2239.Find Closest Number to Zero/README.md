# [2239. 找到最接近 0 的数字](https://leetcode-cn.com/problems/find-closest-number-to-zero)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;，请你返回 <code>nums</code>&nbsp;中最 <strong>接近</strong>&nbsp;<code>0</code>&nbsp;的数字。如果有多个答案，请你返回它们中的 <strong>最大值</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [-4,-2,1,4,8]
<b>输出：</b>1
<strong>解释：</strong>
-4 到 0 的距离为 |-4| = 4 。
-2 到 0 的距离为 |-2| = 2 。
1 到 0 的距离为 |1| = 1 。
4 到 0 的距离为 |4| = 4 。
8 到 0 的距离为 |8| = 8 。
所以，数组中距离 0 最近的数字为 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [2,-1,1]
<b>输出：</b>1
<b>解释：</b>1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        ans, gap = nums[0], abs(nums[0])
        for v in nums:
            if abs(v) < gap:
                gap = abs(v)
                ans = v
            elif abs(v) == gap and v > ans:
                ans = v
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0], gap = Math.abs(nums[0]);
        for (int v : nums) {
            if (Math.abs(v) < gap) {
                gap = Math.abs(v);
                ans = v;
            } else if (Math.abs(v) == gap && v > ans) {
                ans = v;
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
