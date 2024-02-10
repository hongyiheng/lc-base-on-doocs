# [2967. 使数组成为等数数组的最小代价](https://leetcode-cn.com/problems/minimum-cost-to-make-array-equalindromic)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;。</p>

<p>你可以对 <code>nums</code>&nbsp;执行特殊操作 <strong>任意次</strong>&nbsp;（也可以 <strong>0</strong>&nbsp;次）。每一次特殊操作中，你需要 <strong>按顺序</strong>&nbsp;执行以下步骤：</p>

<ul>
	<li>从范围&nbsp;<code>[0, n - 1]</code>&nbsp;里选择一个下标 <code>i</code>&nbsp;和一个 <strong>正</strong>&nbsp;整数&nbsp;<code>x</code>&nbsp;。</li>
	<li>将&nbsp;<code>|nums[i] - x|</code>&nbsp;添加到总代价里。</li>
	<li>将 <code>nums[i]</code>&nbsp;变为&nbsp;<code>x</code>&nbsp;。</li>
</ul>

<p>如果一个正整数正着读和反着读都相同，那么我们称这个数是<strong>&nbsp;回文数</strong>&nbsp;。比方说，<code>121</code>&nbsp;，<code>2552</code> 和&nbsp;<code>65756</code>&nbsp;都是回文数，但是&nbsp;<code>24</code>&nbsp;，<code>46</code>&nbsp;，<code>235</code>&nbsp;都不是回文数。</p>

<p>如果一个数组中的所有元素都等于一个整数&nbsp;<code>y</code>&nbsp;，且&nbsp;<code>y</code>&nbsp;是一个小于&nbsp;<code>10<sup>9</sup></code>&nbsp;的&nbsp;<strong>回文数</strong>&nbsp;，那么我们称这个数组是一个 <strong>等数数组&nbsp;</strong>。</p>

<p>请你返回一个整数，表示执行任意次特殊操作后使 <code>nums</code>&nbsp;成为 <strong>等数数组</strong>&nbsp;的 <strong>最小</strong>&nbsp;总代价。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,2,3,4,5]
<b>输出：</b>6
<b>解释：</b>我们可以将数组中所有元素变为回文数 3 得到等数数组，数组变成 [3,3,3,3,3] 需要执行 4 次特殊操作，代价为 |1 - 3| + |2 - 3| + |4 - 3| + |5 - 3| = 6 。
将所有元素变为其他回文数的总代价都大于 6 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [10,12,13,14,15]
<b>输出：</b>11
<b>解释：</b>我们可以将数组中所有元素变为回文数 11 得到等数数组，数组变成 [11,11,11,11,11] 需要执行 5 次特殊操作，代价为 |10 - 11| + |12 - 11| + |13 - 11| + |14 - 11| + |15 - 11| = 11 。
将所有元素变为其他回文数的总代价都大于 11 。
</pre>

<p><strong class="example">示例 3 ：</strong></p>

<pre>
<b>输入：</b>nums = [22,33,22,33,22]
<b>输出：</b>22
<b>解释：</b>我们可以将数组中所有元素变为回文数 22 得到等数数组，数组变为 [22,22,22,22,22] 需要执行 2 次特殊操作，代价为 |33 - 22| + |33 - 22| = 22 。
将所有元素变为其他回文数的总代价都大于 22 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        def f(x):
            v, t = x, 0
            while v:
                t = t * 10 + v % 10
                v //= 10
            if t != x:
                return -1
            ans = 0
            for v in nums:
                ans += abs(v - x)
            return ans

        nums.sort()
        n = len(nums)
        mid = nums[n // 2] if n % 2 else (nums[n // 2] + nums[n // 2 - 1]) // 2
        ans = inf
        for v in range(mid, -1, -1):
            if f(v) != -1:
                ans = f(v)
                break
        while True:
            if f(mid) != -1:
                return min(ans, f(mid))
            mid += 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public long f(int[] nums, int x) {
        int cur = x, t = 0;
        while (cur != 0) {
            t = t * 10 + cur % 10;
            cur /= 10;
        }
        if (t != x) {
            return -1;
        }
        long ans = 0;
        for (int v : nums) {
            ans += Math.abs(x - v);
        }
        return ans;
    }

    public long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2 != 0 || n == 1 ? nums[n / 2] : (nums[n / 2] + nums[n / 2 + 1]) / 2;
        long ans = Long.MAX_VALUE;
        for (int i = mid; i > -1; i--) {
            if (f(nums, i) != -1) {
                ans = f(nums, i);
                break;
            }
        }
        while (true) {
            if (f(nums, mid) != -1) {
                return Math.min(ans, f(nums, mid));
            }
            mid++;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
