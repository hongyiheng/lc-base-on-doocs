# [1464. 数组中两元素的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>，请你选择数组的两个不同下标 <code>i</code> 和 <code>j</code><em>，</em>使 <code>(nums[i]-1)*(nums[j]-1)</code> 取得最大值。</p>

<p>请你计算并返回该式的最大值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [3,4,5,2]
<strong>输出：</strong>12 
<strong>解释：</strong>如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [1,5,4,5]
<strong>输出：</strong>16
<strong>解释：</strong>选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums = [3,7]
<strong>输出：</strong>12
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^3</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        f = s = 0
        for v in nums:
            if v >= f:
                s = f
                f = v
            elif v > s:
                s = v
        return (f - 1) * (s - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxProduct(int[] nums) {
        int f = 0, s = 0;
        for (int v : nums) {
            if (v >= f) {
                s = f;
                f = v;
            } else if (v > s) {
                s = v;
            }
        }
        return (f - 1) * (s - 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
