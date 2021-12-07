# [1034. 边框着色](https://leetcode-cn.com/problems/coloring-a-border)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个二维整数网格&nbsp;<code>grid</code>，网格中的每个值表示该位置处的网格块的颜色。</p>

<p>只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一<strong>连通分量</strong>。</p>

<p>连通分量的<strong>边界</strong>是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。</p>

<p>给出位于&nbsp;<code>(r0, c0)</code>&nbsp;的网格块和颜色&nbsp;<code>color</code>，使用指定颜色&nbsp;<code>color</code>&nbsp;为所给网格块的连通分量的边界进行着色，并返回最终的网格&nbsp;<code>grid</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
<strong>输出：</strong>[[3, 3], [3, 2]]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
<strong>输出：</strong>[[1, 3, 3], [2, 3, 3]]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
<strong>输出：</strong>[[2, 2, 2], [2, 1, 2], [2, 2, 2]]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= grid.length &lt;= 50</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 1000</code></li>
	<li><code>0 &lt;= r0 &lt; grid.length</code></li>
	<li><code>0 &lt;= c0 &lt; grid[0].length</code></li>
	<li><code>1 &lt;= color &lt;= 1000</code></li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def colorBorder(self, grid: List[List[int]], row: int, col: int, color: int) -> List[List[int]]:
        m, n, cur = len(grid), len(grid[0]), grid[row][col]
        visit = [[False for _ in range(n)] for _ in range(m)]

        def dfs(x, y, ox, oy):
            if x >= 0 and x < m and y >= 0 and y < n:
                if not visit[x][y]:
                    if grid[x][y] == cur:
                        visit[x][y] = True
                        dfs(x + 1, y, x, y)
                        dfs(x - 1, y, x, y)
                        dfs(x, y + 1, x, y)
                        dfs(x, y - 1, x, y)
                    else:
                        grid[ox][oy] = color
            else:
                grid[ox][oy] = color 
        
        dfs(row, col, row, col)
        return grid
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    boolean[][] visit;
    int[][] grid;
    int cur, color, m, n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        this.grid = grid;
        cur = grid[row][col];
        this.color = color;
        dfs(row, col, row, col);
        return grid;
    }

    private void dfs(int x, int y, int ox, int oy) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            if (!visit[x][y]) {
                if (grid[x][y] == cur) {
                    visit[x][y] = true;
                    dfs(x + 1, y, x, y);
                    dfs(x - 1, y, x, y);
                    dfs(x, y - 1, x, y);
                    dfs(x, y + 1, x, y);
                } else {
                    grid[ox][oy] = color;
                }
            } 
        } else {
            grid[ox][oy] = color;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
