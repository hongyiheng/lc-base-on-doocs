# [1027. 最长等差数列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组&nbsp;<code>A</code>，返回 <code>A</code>&nbsp;中最长等差子序列的<strong>长度</strong>。</p>

<p>回想一下，<code>A</code>&nbsp;的子序列是列表&nbsp;<code>A[i_1], A[i_2], ..., A[i_k]</code> 其中&nbsp;<code>0 &lt;= i_1 &lt; i_2 &lt; ... &lt; i_k &lt;= A.length - 1</code>。并且如果&nbsp;<code>B[i+1] - B[i]</code>(&nbsp;<code>0 &lt;= i &lt; B.length - 1</code>) 的值都相同，那么序列&nbsp;<code>B</code>&nbsp;是等差的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[3,6,9,12]
<strong>输出：</strong>4
<strong>解释： </strong>
整个数组是公差为 3 的等差数列。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[9,4,7,2,10]
<strong>输出：</strong>3
<strong>解释：</strong>
最长的等差子序列是 [4,7,10]。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[20,1,15,3,10,5,8]
<strong>输出：</strong>4
<strong>解释：</strong>
最长的等差子序列是 [20,15,10,5]。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>2 &lt;= A.length &lt;= 2000</code></li>
	<li><code>0 &lt;= A[i] &lt;= 10000</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        ans, n = 0, len(nums)
        f = [[1] * 1010 for _ in range(n + 1)]
        for i in range(1, n):
            for j in range(i):
                k = nums[i] - nums[j] + 500
                f[i][k] = max(f[i][k], f[j][k] + 1)
                ans = max(f[i][k], ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] f = new int[n + 1][1010];
        for (int[] r : f) {
            Arrays.fill(r, 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = nums[i] - nums[j] + 500;
                f[i][k] = Math.max(f[i][k], f[j][k] + 1);
                ans = Math.max(f[i][k], ans);
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
