# [908. 最小差值 I](https://leetcode-cn.com/problems/smallest-range-i)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>，请你给数组中的每个元素 <code>nums[i]</code> 都加上一个任意数字 <code>x</code> （<code>-k <= x <= k</code>），从而得到一个新数组 <code>result</code> 。</p>

<p>返回数组 <code>result</code> 的最大值和最小值之间可能存在的最小差值。</p>

<p> </p>

<ol>
</ol>

<ol>
</ol>

<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = <span id="example-input-1-1">[1]</span>, k = <span id="example-input-1-2">0</span>
<strong>输出：</strong><span id="example-output-1">0
<strong>解释：</strong>result = [1]</span>
</pre>

<div>
<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = <span id="example-input-2-1">[0,10]</span>, k = <span id="example-input-2-2">2</span>
<strong>输出：</strong><span id="example-output-2">6
</span><span id="example-output-1"><strong>解释：</strong></span><span>result = [2,8]</span>
</pre>

<div>
<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = <span id="example-input-3-1">[1,3,6]</span>, k = <span id="example-input-3-2">3</span>
<strong>输出：</strong><span id="example-output-3">0
</span><span id="example-output-1"><strong>解释：</strong></span><span>result = [3,3,3] or result = [4,4,4]</span>
</pre>
</div>
</div>
</div>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10000</code></li>
	<li><code>0 <= nums[i] <= 10000</code></li>
	<li><code>0 <= k <= 10000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        diff = max(nums) - min(nums) - 2 * k
        return max(diff, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int num : A) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        int diff = maxVal - minVal - 2 * K;
        return Math.max(diff, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
