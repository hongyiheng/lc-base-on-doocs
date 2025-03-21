# [3287. 求出数组中最大序列值](https://leetcode.cn/problems/find-the-maximum-sequence-value-of-array)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>nums</code>&nbsp;和一个 <strong>正</strong>&nbsp;整数&nbsp;<code>k</code>&nbsp;。</p>

<p>定义长度为 <code>2 * x</code>&nbsp;的序列 <code>seq</code>&nbsp;的 <strong>值</strong>&nbsp;为：</p>

<ul>
	<li><code>(seq[0] OR seq[1] OR ... OR seq[x - 1]) XOR (seq[x] OR seq[x + 1] OR ... OR seq[2 * x - 1])</code>.</li>
</ul>

<p>请你求出 <code>nums</code>&nbsp;中所有长度为 <code>2 * k</code>&nbsp;的 <span data-keyword="subsequence-array">子序列</span> 的 <strong>最大值</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [2,6,7], k = 1</span></p>

<p><span class="example-io"><b>输出：</b>5</span></p>

<p><strong>解释：</strong></p>

<p>子序列&nbsp;<code>[2, 7]</code>&nbsp;的值最大，为&nbsp;<code>2 XOR 7 = 5</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [4,2,5,6,7], k = 2</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p>子序列&nbsp;<code>[4, 5, 6, 7]</code>&nbsp;的值最大，为&nbsp;<code>(4 OR 5) XOR (6 OR 7) = 2</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 400</code></li>
	<li><code>1 &lt;= nums[i] &lt; 2<sup>7</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length / 2</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxValue(self, nums: List[int], k: int) -> int:
        m = 1 << 7
        n = len(nums)
        f = [[[False] * m for _ in range(k + 2)] for _ in range(n + 1)]
        f[0][0][0] = True
        for i in range(n):
            for j in range(k + 1):
                for x in range(m):
                    f[i + 1][j][x] |= f[i][j][x]
                    f[i + 1][j + 1][x | nums[i]] |= f[i][j][x]

        g = [[[False] * m for _ in range(k + 2)] for _ in range(n + 1)]
        g[n][0][0] = True
        for i in range(n, 0, -1):
            for j in range(k + 1):
                for x in range(m):
                    g[i - 1][j][x] |= g[i][j][x]
                    g[i - 1][j + 1][x | nums[i - 1]] |= g[i][j][x]
        
        ans = 0
        for i in range(k, n - k + 1):
            for x in range(m):
                if f[i][k][x]:
                    for y in range(m):
                        if g[i][k][y]:
                            ans = max(ans, x ^ y)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxValue(int[] nums, int k) {
        int m = 1 << 7;
        int n = nums.length;
        boolean[][][] f = new boolean[n + 1][k + 2][m];
        f[0][0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x < m; x++) {
                    if (f[i][j][x]) {
                        f[i + 1][j][x] = true;
                        f[i + 1][j + 1][x | nums[i]] = true;
                    }
                }
            }
        }

        boolean[][][] g = new boolean[n + 1][k + 2][m];
        g[n][0][0] = true;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < k + 1; j++) {
                for (int x = 0; x < m; x++) {
                    if (g[i][j][x]) {
                        g[i - 1][j][x] = true;
                        g[i - 1][j + 1][x | nums[i - 1]] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = k; i < n - k + 1; i++) {
            for (int x = 0; x < m; x++) {
                if (f[i][k][x]) {
                    for (int y = 0; y < m; y++) {
                        if (g[i][k][y]) {
                            ans = Math.max(ans, x ^ y);
                        }
                    }
                }
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
