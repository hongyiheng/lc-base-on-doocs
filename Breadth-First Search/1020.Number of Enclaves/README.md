# [1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves)

[English Version](/solution/1000-1099/1020.Number%20of%20Enclaves/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个二维数组&nbsp;<code>A</code>，每个单元格为 0（代表海）或 1（代表陆地）。</p>

<p>移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。</p>

<p>返回网格中<strong>无法</strong>在任意次数的移动中离开网格边界的陆地单元格的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
<strong>输出：</strong>3
<strong>解释： </strong>
有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
<strong>输出：</strong>0
<strong>解释：</strong>
所有 1 都在边界上或可以到达边界。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 500</code></li>
	<li><code>1 &lt;= A[i].length &lt;= 500</code></li>
	<li><code>0 &lt;= A[i][j] &lt;= 1</code></li>
	<li>所有行的大小都相同</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(i, j):
            grid[i][j] = 0
            if i < m - 1 and grid[i + 1][j] == 1:
                dfs(i + 1, j)
            if i > 0 and grid[i - 1][j] == 1:
                dfs(i - 1, j)
            if j < n - 1 and grid[i][j + 1] == 1:
                 dfs(i, j + 1)
            if j > 0 and grid[i][j - 1] == 1:
                 dfs(i, j - 1)

        for i in range(m):
            if grid[i][0] == 1:
                dfs(i, 0)
            if grid[i][n - 1] == 1:
                dfs(i, n - 1)
        for j in range(n):
            if grid[0][j] == 1:
                dfs(0, j)
            if grid[m - 1][j] == 1:
                dfs(m - 1, j)
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res += 1
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int m;
    int n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }   
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            } 
        } 
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        if (i < m - 1 && grid[i + 1][j] == 1) {
            dfs(grid, i + 1, j);
        }
        if (j < n - 1 && grid[i][j + 1] == 1) {
            dfs(grid, i, j + 1);
        }
        if (i > 0 && grid[i - 1][j] == 1) {
            dfs(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            dfs(grid, i, j - 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
