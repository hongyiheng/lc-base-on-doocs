# [3239. 最少翻转次数使二进制矩阵回文 I](https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>m x n</code>&nbsp;的二进制矩阵&nbsp;<code>grid</code>&nbsp;。</p>

<p>如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 <strong>回文</strong> 的。</p>

<p>你可以将 <code>grid</code>&nbsp;中任意格子的值 <strong>翻转</strong>&nbsp;，也就是将格子里的值从 <code>0</code>&nbsp;变成 <code>1</code>&nbsp;，或者从 <code>1</code>&nbsp;变成 <code>0</code>&nbsp;。</p>

<p>请你返回 <strong>最少</strong>&nbsp;翻转次数，使得矩阵 <strong>要么</strong>&nbsp;所有行是 <strong>回文的</strong>&nbsp;，要么所有列是 <strong>回文的</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = [[1,0,0],[0,0,0],[0,0,1]]</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><b>解释：</b></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/07/07/screenshot-from-2024-07-08-00-20-10.png" style="width: 420px; height: 108px;" /></p>

<p>将高亮的格子翻转，得到所有行都是回文的。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = </span>[[0,1],[0,1],[0,0]]</p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/07/07/screenshot-from-2024-07-08-00-31-23.png" style="width: 300px; height: 100px;" /></p>

<p>将高亮的格子翻转，得到所有列都是回文的。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = [[1],[0]]</span></p>

<p><span class="example-io"><b>输出：</b>0</span></p>

<p><strong>解释：</strong></p>

<p>所有行已经是回文的。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m * n &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans1 = 0
        for i in range(m):
            l, r = 0, n - 1
            while l < r:
                if grid[i][l] != grid[i][r]:
                    ans1 += 1
                l += 1
                r -= 1
        
        ans2 = 0
        for i in range(n):
            l, r = 0, m - 1
            while l < r:
                if grid[l][i] != grid[r][i]:
                    ans2 += 1
                l += 1
                r -= 1
        return min(ans1, ans2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans1 = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (grid[i][l++] != grid[i][r--]) {
                    ans1++;
                }
            }
        }
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l < r) {
                if (grid[l++][i] != grid[r--][i]) {
                    ans2++;
                }
            }
        }
        return Math.min(ans1, ans2);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
