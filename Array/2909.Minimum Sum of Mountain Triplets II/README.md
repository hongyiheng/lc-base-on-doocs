# [2909. 元素和最小的山形三元组 II](https://leetcode-cn.com/problems/minimum-sum-of-mountain-triplets-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 。</p>

<p>如果下标三元组 <code>(i, j, k)</code> 满足下述全部条件，则认为它是一个 <strong>山形三元组</strong> ：</p>

<ul>
	<li><code>i &lt; j &lt; k</code></li>
	<li><code>nums[i] &lt; nums[j]</code> 且 <code>nums[k] &lt; nums[j]</code></li>
</ul>

<p>请你找出 <code>nums</code> 中 <strong>元素和最小</strong> 的山形三元组，并返回其 <strong>元素和</strong> 。如果不存在满足条件的三元组，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [8,6,1,5,3]
<strong>输出：</strong>9
<strong>解释：</strong>三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为： 
- 2 &lt; 3 &lt; 4
- nums[2] &lt; nums[3] 且 nums[4] &lt; nums[3]
这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,8,7,10,2]
<strong>输出：</strong>13
<strong>解释：</strong>三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为： 
- 1 &lt; 3 &lt; 5 
- nums[1] &lt; nums[3] 且 nums[5] &lt; nums[3]
这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [6,5,4,3,4,5]
<strong>输出：</strong>-1
<strong>解释：</strong>可以证明 nums 中不存在山形三元组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>8</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        n = len(nums)
        q = [inf] * n
        for i in range(1, n):
            q[i] = min(q[i - 1], nums[i - 1])
        ans = mi = inf
        for i in range(n - 2, -1, -1):
            mi = min(mi, nums[i + 1])
            if q[i] < nums[i] > mi:
                ans = min(ans, q[i] + nums[i] + mi)
        return -1 if ans == inf else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumSum(int[] nums) {
        int inf = Integer.MAX_VALUE;
        int n = nums.length;
        int[] q = new int[n];
        Arrays.fill(q, inf);
        for (int i = 1; i < n; i++) {
            q[i] = Math.min(q[i - 1], nums[i - 1]);
        }
        int ans = inf, mi = inf;
        for (int i = n - 2; i > -1; i--) {
            mi = Math.min(mi, nums[i + 1]);
            if (q[i] < nums[i] && nums[i] > mi) {
                ans = Math.min(ans, q[i] + nums[i] + mi);
            }
        }
        return ans == inf ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
