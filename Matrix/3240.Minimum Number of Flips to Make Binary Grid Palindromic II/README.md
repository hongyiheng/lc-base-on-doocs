# [3240. 最少翻转次数使二进制矩阵回文 II](https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-ii)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>m x n</code>&nbsp;的二进制矩阵&nbsp;<code>grid</code>&nbsp;。</p>

<p>如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 <strong>回文</strong>&nbsp;的。</p>

<p>你可以将 <code>grid</code>&nbsp;中任意格子的值 <strong>翻转</strong>&nbsp;，也就是将格子里的值从 <code>0</code>&nbsp;变成 <code>1</code>&nbsp;，或者从 <code>1</code>&nbsp;变成 <code>0</code>&nbsp;。</p>

<p>请你返回 <strong>最少</strong>&nbsp;翻转次数，使得矩阵中 <strong>所有</strong>&nbsp;行和列都是 <strong>回文的</strong>&nbsp;，且矩阵中 <code>1</code>&nbsp;的数目可以被 <code>4</code>&nbsp;<strong>整除</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = [[1,0,0],[0,1,0],[0,0,1]]</span></p>

<p><span class="example-io"><b>输出：</b>3</span></p>

<p><strong>解释：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2024/08/01/image.png" style="width: 400px; height: 105px;" /></p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = [[0,1],[0,1],[0,0]]</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/07/08/screenshot-from-2024-07-09-01-37-48.png" style="width: 300px; height: 104px;" /></p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>grid = [[1],[1]]</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/01/screenshot-from-2024-08-01-23-05-26.png" style="width: 200px; height: 70px;" /></p>
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
        ans = 0
        for i in range(m // 2):
            for j in range(n // 2):
                v = grid[i][j] + grid[m - 1 - i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][n - 1 - j]
                ans += min(v, 4 - v)

        if m % 2 and n % 2:
            ans += grid[m // 2][n // 2]

        diff = cnt = 0
        if m % 2:
            for j in range(n // 2):
                if grid[m // 2][j] != grid[m // 2][n - 1 - j]:
                    diff += 1
                else:
                    cnt += grid[m // 2][j] * 2
        if n % 2:
            for i in range(m // 2):
                if grid[i][n // 2] != grid[m - 1 - i][n // 2]:
                    diff += 1
                else:
                    cnt += grid[i][n // 2] * 2
        
        return ans + (diff if diff else cnt % 4)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int v = grid[i][j] + grid[m - 1 - i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][n - 1 - j];
                ans += Math.min(v, 4 - v);
            }
        }
        if (m % 2 == 1 && n % 2 == 1) {
            ans += grid[m / 2][n / 2];
        }
        int diff = 0, cnt = 0;
        if (m % 2 == 1) {
            for (int j = 0; j < n / 2; j++) {
                if (grid[m / 2][j] != grid[m / 2][n - 1 - j]) {
                    diff++;
                } else {
                    cnt += grid[m / 2][j] * 2;
                }
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][n / 2] != grid[m - 1 - i][n / 2]) {
                    diff++;
                } else {
                    cnt += grid[i][n / 2] * 2;
                }
            }
        }
        return ans + (diff > 0 ? diff : cnt % 4);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
