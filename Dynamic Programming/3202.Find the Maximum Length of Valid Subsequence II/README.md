# [3202. 找出有效子序列的最大长度 II](https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-ii)

## 题目描述

<!-- 这里写题目描述 -->

给你一个整数数组&nbsp;<code>nums</code>&nbsp;和一个 <strong>正</strong>&nbsp;整数&nbsp;<code>k</code>&nbsp;。
<p><code>nums</code>&nbsp;的一个&nbsp;<span data-keyword="subsequence-array">子序列</span> <code>sub</code>&nbsp;的长度为 <code>x</code>&nbsp;，如果其满足以下条件，则称其为 <strong>有效子序列</strong>&nbsp;：</p>

<ul>
	<li><code>(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k</code></li>
</ul>
返回 <code>nums</code>&nbsp;的 <strong>最长</strong><strong>有效子序列</strong>&nbsp;的长度。

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,2,3,4,5], k = 2</span></p>

<p><span class="example-io"><b>输出：</b>5</span></p>

<p><b>解释：</b></p>

<p>最长有效子序列是&nbsp;<code>[1, 2, 3, 4, 5]</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,4,2,3,1,4], k = 3</span></p>

<p><span class="example-io"><b>输出：</b>4</span></p>

<p><strong>解释：</strong></p>

<p>最长有效子序列是&nbsp;<code>[1, 4, 1, 4]</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>3</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        f = [[0] * k for _ in range(k)]
        for i, v in enumerate(nums):
            x = v % k
            for j in range(k):
                f[j][x] = max(f[j][x], f[x][j] + 1)
        ans = 0
        for r in f:
            ans = max(ans, max(r))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] f = new int[k][k];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] % k;
            for (int j = 0; j < k; j++) {
                f[j][x] = Math.max(f[j][x], f[x][j] + 1);
                ans = Math.max(ans, f[j][x]);
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
