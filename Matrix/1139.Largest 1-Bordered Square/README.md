# [1139. 最大的以 1 为边界的正方形](https://leetcode-cn.com/problems/largest-1-bordered-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由若干 <code>0</code> 和 <code>1</code> 组成的二维网格&nbsp;<code>grid</code>，请你找出边界全部由 <code>1</code> 组成的最大 <strong>正方形</strong> 子网格，并返回该子网格中的元素数量。如果不存在，则返回 <code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,1],[1,0,1],[1,1,1]]
<strong>输出：</strong>9
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,0,0]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= grid.length &lt;= 100</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 100</code></li>
	<li><code>grid[i][j]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row = [[0] * n for _ in range(m)]
        col = [[0] * n for _ in range(m)]
        for i in range(m - 1, -1, -1):
            for j in range(n -1, -1, -1):
                if grid[i][j]:
                    row[i][j] = 1 if j == n - 1 else row[i][j + 1] + 1
                    col[i][j] = 1 if i == m - 1 else col[i + 1][j] + 1
        ans = 0
        for i in range(m):
            for j in range(n):
                for k in range(ans, min(m - i, n - j)):
                    if i + k >= m or j + k >= n:
                        continue
                    if row[i][j] > k and col[i][j] > k and row[i + k][j] > k and col[i][j + k] > k:
                        ans = max(ans, k + 1)
        return ans * ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m][n], col = new int[m][n];
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (grid[i][j] == 0) {
                    continue;
                }
                row[i][j] = j == n - 1 ? 1 : row[i][j + 1] + 1;
                col[i][j] = i == m - 1 ? 1 : col[i + 1][j] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } 
                for (int k = ans; k < Math.min(m, n); k++) {
                    if (i + k >= m || j + k >= n) {
                        continue;
                    }
                    if (row[i][j] > k && row[i + k][j] > k && col[i][j] > k && col[i][j + k] > k) {
                        ans = Math.max(ans, k + 1);
                    }
                }
            }
        }
        return ans * ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
