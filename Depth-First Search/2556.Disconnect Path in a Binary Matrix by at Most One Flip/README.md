# [2556. 二进制矩阵中翻转最多一次使路径不连通](https://leetcode-cn.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的&nbsp;<code>m x n</code>&nbsp;<strong>二进制</strong> 矩阵&nbsp;<code>grid</code>&nbsp;。你可以从一个格子&nbsp;<code>(row, col)</code>&nbsp;移动到格子&nbsp;<code>(row + 1, col)</code>&nbsp;或者&nbsp;<code>(row, col + 1)</code>&nbsp;，前提是前往的格子值为 <code>1</code>&nbsp;。如果从&nbsp;<code>(0, 0)</code>&nbsp;到&nbsp;<code>(m - 1, n - 1)</code>&nbsp;没有任何路径，我们称该矩阵是&nbsp;<strong>不连通</strong>&nbsp;的。</p>

<p>你可以翻转 <strong>最多一个</strong>&nbsp;格子的值（也可以不翻转）。你 <strong>不能翻转</strong>&nbsp;格子&nbsp;<code>(0, 0)</code> 和&nbsp;<code>(m - 1, n - 1)</code>&nbsp;。</p>

<p>如果可以使矩阵不连通，请你返回&nbsp;<code>true</code>&nbsp;，否则返回<em>&nbsp;</em><code>false</code><em>&nbsp;</em>。</p>

<p><strong>注意</strong>&nbsp;，翻转一个格子的值，可以使它的值从&nbsp;<code>0</code>&nbsp;变&nbsp;<code>1</code>&nbsp;，或从&nbsp;<code>1</code>&nbsp;变&nbsp;<code>0</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/12/07/yetgrid2drawio.png" style="width: 441px; height: 151px;" /></p>

<pre>
<b>输入：</b>grid = [[1,1,1],[1,0,0],[1,1,1]]
<strong>输出：</strong>true
<b>解释：</b>按照上图所示我们翻转蓝色格子里的值，翻转后从 (0, 0) 到 (2, 2) 没有路径。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/12/07/yetgrid3drawio.png" /></p>

<pre>
<b>输入：</b>grid = [[1,1,1],[1,0,1],[1,1,1]]
<b>输出：</b>false
<b>解释：</b>无法翻转至多一个格子，使 (0, 0) 到 (2, 2) 没有路径。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isPossibleToCutPath(self, grid: List[List[int]]) -> bool:
        def dfs(x, y):
            if x == m - 1 and y == n - 1:
                return True
            grid[x][y] = 0
            ans = False
            for d in [[0, 1], [1, 0]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if not grid[nx][ny]:
                    continue
                ans = ans or dfs(nx, ny)
            return ans

        m, n = len(grid), len(grid[0])
        if not grid[0][0] or not grid[m - 1][n - 1]:
            return True
        return not dfs(0, 0) or not dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int m, n;
    int[][] grid;

    public boolean dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        grid[x][y] = 0;
        boolean ans = false;
        for (int[] d : new int[][]{{0, 1}, {1, 0}}) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 0) {
                continue;
            }
            ans = ans || dfs(nx, ny);
        }
        return ans;
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] == 0 || grid[m - 1][n - 1] == 0) {
            return true;
        }
        return !dfs(0, 0) || !dfs(0, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
