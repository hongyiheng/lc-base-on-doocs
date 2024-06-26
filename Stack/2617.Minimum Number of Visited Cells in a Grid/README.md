# [2617. 网格图中最少访问的格子数](https://leetcode-cn.com/problems/minimum-number-of-visited-cells-in-a-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的&nbsp;<code>m x n</code>&nbsp;整数矩阵&nbsp;<code>grid</code>&nbsp;。你一开始的位置在&nbsp;<strong>左上角</strong>&nbsp;格子&nbsp;<code>(0, 0)</code>&nbsp;。</p>

<p>当你在格子&nbsp;<code>(i, j)</code>&nbsp;的时候，你可以移动到以下格子之一：</p>

<ul>
	<li>满足 <code>j &lt; k &lt;= grid[i][j] + j</code>&nbsp;的格子&nbsp;<code>(i, k)</code>&nbsp;（向右移动），或者</li>
	<li>满足 <code>i &lt; k &lt;= grid[i][j] + i</code>&nbsp;的格子&nbsp;<code>(k, j)</code>&nbsp;（向下移动）。</li>
</ul>

<p>请你返回到达 <strong>右下角</strong>&nbsp;格子&nbsp;<code>(m - 1, n - 1)</code>&nbsp;需要经过的最少移动格子数，如果无法到达右下角格子，请你返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/25/ex1.png" style="width: 271px; height: 171px;"></p>

<pre><b>输入：</b>grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
<b>输出：</b>4
<b>解释：</b>上图展示了到达右下角格子经过的 4 个格子。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/25/ex2.png" style="width: 271px; height: 171px;"></p>

<pre><b>输入：</b>grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
<b>输出：</b>3
<strong>解释：</strong>上图展示了到达右下角格子经过的 3 个格子。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/26/ex3.png" style="width: 181px; height: 81px;"></p>

<pre><b>输入：</b>grid = [[2,1,0],[1,0,0]]
<b>输出：</b>-1
<b>解释：</b>无法到达右下角格子。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= grid[i][j] &lt; m * n</code></li>
	<li><code>grid[m - 1][n - 1] == 0</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumVisitedCells(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dist = [[inf] * n for _ in range(m)]
        rows = [[] for _ in range(m)]
        cols = [[] for _ in range(n)]
        dist[0][0] = 1
        for i in range(m):
            for j in range(n):
                row, col = rows[i], cols[j]
                while row and j > grid[i][row[0][1]] + row[0][1]:
                    heapq.heappop(row)
                while col and i > grid[col[0][1]][j] + col[0][1]:
                    heapq.heappop(col)
                if row:
                    dist[i][j] = min(dist[i][j], dist[i][row[0][1]] + 1)
                if col:
                    dist[i][j] = min(dist[i][j], dist[col[0][1]][j] + 1)
                heapq.heappush(row, [dist[i][j], j])
                heapq.heappush(col, [dist[i][j], i])
        return -1 if dist[-1][-1] == inf else dist[-1][-1]

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int inf = 0x3f3f3f3f;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, inf);
        }
        dist[0][0] = 1;
        List<PriorityQueue<int[]>> rows = new ArrayList<>();
        List<PriorityQueue<int[]>> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rows.add(new PriorityQueue<>((a, b) -> a[0] - b[0]));
        }
        for (int j = 0; j < n; j++) {
            cols.add(new PriorityQueue<>((a, b) -> a[0] - b[0]));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                PriorityQueue<int[]> row = rows.get(i), col = cols.get(j);
                while (!row.isEmpty() && j > grid[i][row.peek()[1]] + row.peek()[1]) {
                    row.poll();
                }
                while (!col.isEmpty() && i > grid[col.peek()[1]][j] + col.peek()[1]) {
                    col.poll();
                }
                if (!row.isEmpty()) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][row.peek()[1]] + 1);
                }
                if (!col.isEmpty()) {
                    dist[i][j] = Math.min(dist[i][j], dist[col.peek()[1]][j] + 1);
                }
                row.add(new int[]{dist[i][j], j});
                col.add(new int[]{dist[i][j], i});
            }
        }
        return dist[m - 1][n - 1] >= inf ? -1 : dist[m - 1][n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
