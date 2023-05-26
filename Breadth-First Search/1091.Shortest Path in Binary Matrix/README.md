# [1091. 二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n x n</code> 的二进制矩阵 <code>grid</code> 中，返回矩阵中最短 <strong>畅通路径</strong> 的长度。如果不存在这样的路径，返回 <code>-1</code> 。</p>

<p>二进制矩阵中的 畅通路径 是一条从 <strong>左上角</strong> 单元格（即，<code>(0, 0)</code>）到 右下角 单元格（即，<code>(n - 1, n - 1)</code>）的路径，该路径同时满足下述要求：</p>

<ul>
	<li>路径途经的所有单元格都的值都是 <code>0</code> 。</li>
	<li>路径中所有相邻的单元格应当在 <strong>8 个方向之一</strong> 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。</li>
</ul>

<p><strong>畅通路径的长度</strong> 是该路径途经的单元格总数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example1_1.png" style="width: 500px; height: 234px;" />
<pre>
<strong>输入：</strong>grid = [[0,1],[1,0]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example2_1.png" style="height: 216px; width: 500px;" />
<pre>
<strong>输入：</strong>grid = [[0,0,0],[1,1,0],[1,1,0]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>grid = [[1,0,0],[1,1,0],[1,1,0]]
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 <= n <= 100</code></li>
	<li><code>grid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0]:
            return -1
        m, n = len(grid), len(grid[0])
        q = deque([[0, 0]])
        vis = [[False] * n for _ in range(m)]
        vis[0][0] = True
        dirs = [[0, 1], [0, -1], [-1, -1], [-1, 0], [-1, 1], [1, -1], [1, 0], [1, 1]]
        ans = 1
        while q:
            for _ in range(len(q)):
                x, y = q.popleft()
                if x == m - 1 and y == n - 1:
                    return ans
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] or vis[nx][ny]:
                        continue
                    q.append([nx, ny])
                    vis[nx][ny] = True
            ans += 1
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        vis[0][0] = true;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int ans = 1;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return ans;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] != 0 || vis[nx][ny]) {
                        continue;
                    }
                    q.addLast(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
