# [2644. 找出可整除性得分最大的整数](https://leetcode-cn.com/problems/find-the-maximum-divisibility-score)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和 <code>divisors</code> 。</p>

<p><code>divisors[i]</code> 的 <strong>可整除性得分</strong> 等于满足 <code>nums[j]</code> 能被 <code>divisors[i]</code> 整除的下标 <code>j</code> 的数量。</p>

<p>返回 <strong>可整除性得分</strong> 最大的整数 <code>divisors[i]</code> 。如果有多个整数具有最大得分，则返回数值最小的一个。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,7,9,3,9], divisors = [5,2,3]
<strong>输出：</strong>3
<strong>解释：</strong>divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 5 整除。
divisors[1] 的可整除性得分为 1 ，因为 nums[0] 能被 2 整除。 
divisors[2] 的可整除性得分为 3 ，因为 nums[2]、nums[3] 和 nums[4] 都能被 3 整除。 
因此，返回 divisors[2] ，它的可整除性得分最大。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [20,14,21,10], divisors = [5,7,5]
<strong>输出：</strong>5
<strong>解释：</strong>divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被 5 整除。
divisors[1] 的可整除性得分为 2 ，因为 nums[1] 和 nums[2] 都能被 7 整除。
divisors[2] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被5整除。 
由于 divisors[0]、divisors[1] 和 divisors[2] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[2] 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [12], divisors = [10,16]
<strong>输出：</strong>10
<strong>解释：</strong>divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 10 整除。
divisors[1] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 16 整除。 
由于 divisors[0] 和 divisors[1] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[0] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length, divisors.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i], divisors[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        mx, ans = 0, divisors[0]
        for d in divisors:
            cnt = 0
            for v in nums:
                if not v % d:
                    cnt += 1
            if cnt > mx or (cnt == mx and ans > d):
                ans = d
                mx = cnt
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int mx = 0, ans = divisors[0];
        for (int d : divisors) {
            int cnt = 0;
            for (int v : nums) {
                if (v % d == 0) {
                    cnt++;
                }
            }
            if (cnt > mx || (cnt == mx && ans > d)) {
                ans = d;
                mx = cnt;
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
