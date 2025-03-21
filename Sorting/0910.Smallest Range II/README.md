# [910. 最小差值 II](https://leetcode-cn.com/problems/smallest-range-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>A</code>，对于每个整数 <code>A[i]</code>，可以选择<strong> <code>x = -K</code> 或是 <code>x = K</code></strong> （<code><strong>K</strong></code> 总是非负整数），并将 <code>x</code> 加到 <code>A[i]</code> 中。</p>

<p>在此过程之后，得到数组 <code>B</code>。</p>

<p>返回 <code>B</code> 的最大值和 <code>B</code> 的最小值之间可能存在的最小差值。</p>

<p> </p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>A = [1], K = 0
<strong>输出：</strong>0
<strong>解释：</strong>B = [1]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>A = [0,10], K = 2
<strong>输出：</strong>6
<strong>解释：</strong>B = [2,8]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>A = [1,3,6], K = 3
<strong>输出：</strong>3
<strong>解释：</strong>B = [4,6,3]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= A.length <= 10000</code></li>
	<li><code>0 <= A[i] <= 10000</code></li>
	<li><code>0 <= K <= 10000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestRangeII(self, nums: List[int], k: int) -> int:
        nums.sort()
        mi, mx = nums[0], nums[-1]
        ans = mx - mi
        for i in range(len(nums) - 1):
            a, b = nums[i], nums[i + 1]
            ans = min(ans, max(mx - k, a + k) - min(mi + k, b - k))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mi = nums[0], mx = nums[n - 1];
        int ans = mx - mi;
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            ans = Math.min(ans, Math.max(mx - k, a + k) - Math.min(mi + k, b - k));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
