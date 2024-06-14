# [2786. 访问数组中的位置使分数最大](https://leetcode-cn.com/problems/visit-array-positions-to-maximize-score)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;和一个正整数&nbsp;<code>x</code>&nbsp;。</p>

<p>你 <strong>一开始</strong>&nbsp;在数组的位置 <code>0</code>&nbsp;处，你可以按照下述规则访问数组中的其他位置：</p>

<ul>
	<li>如果你当前在位置&nbsp;<code>i</code>&nbsp;，那么你可以移动到满足&nbsp;<code>i &lt; j</code>&nbsp;的&nbsp;<strong>任意</strong>&nbsp;位置&nbsp;<code>j</code>&nbsp;。</li>
	<li>对于你访问的位置 <code>i</code>&nbsp;，你可以获得分数&nbsp;<code>nums[i]</code>&nbsp;。</li>
	<li>如果你从位置 <code>i</code>&nbsp;移动到位置 <code>j</code>&nbsp;且&nbsp;<code>nums[i]</code> 和&nbsp;<code>nums[j]</code>&nbsp;的 <strong>奇偶性</strong>&nbsp;不同，那么你将失去分数&nbsp;<code>x</code>&nbsp;。</li>
</ul>

<p>请你返回你能得到的 <strong>最大</strong>&nbsp;得分之和。</p>

<p><strong>注意</strong>&nbsp;，你一开始的分数为&nbsp;<code>nums[0]</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [2,3,6,1,9,2], x = 5
<b>输出：</b>13
<b>解释：</b>我们可以按顺序访问数组中的位置：0 -&gt; 2 -&gt; 3 -&gt; 4 。
对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -&gt; 3 让你失去 x = 5 分。
总得分为：2 + 6 + 1 + 9 - 5 = 13 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [2,4,6,8], x = 3
<b>输出：</b>20
<b>解释：</b>数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
总得分为：2 + 4 + 6 + 8 = 20 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i], x &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n = len(nums)
        f = [[0] * 2 for _ in range(n + 1)]
        f[0][nums[0] & 1 ^ 1] -= x
        for i in range(1, n + 1):
            v = nums[i - 1]
            f[i] = f[i - 1]
            f[i][v & 1] = max(f[i - 1][v & 1] + v, f[i - 1][v & 1 ^ 1] - x + v)
        return max(f[n])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        f[0][nums[0] & 1 ^ 1] = -x;
        for (int i = 1; i < n + 1; i++) {
            int v = nums[i - 1];
            f[i][0] = f[i - 1][0];
            f[i][1] = f[i - 1][1];  
            f[i][v & 1] = Math.max(f[i - 1][v & 1] + v, f[i - 1][v & 1 ^ 1] - x + v);
        }
        return Math.max(f[n][0], f[n][1]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
