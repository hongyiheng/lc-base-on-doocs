# [329. 矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个 <code>m x n</code> 整数矩阵 <code>matrix</code> ，找出其中 <strong>最长递增路径</strong> 的长度。</p>

<p>对于每个单元格，你可以往上，下，左，右四个方向移动。 你 <strong>不能</strong> 在 <strong>对角线</strong> 方向上移动或移动到 <strong>边界外</strong>（即不允许环绕）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/05/grid1.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>matrix = [[9,9,4],[6,6,8],[2,1,1]]
<strong>输出：</strong>4 
<strong>解释：</strong>最长递增路径为 <code>[1, 2, 6, 9]</code>。</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/27/tmp-grid.jpg" style="width: 253px; height: 253px;" />
<pre>
<strong>输入：</strong>matrix = [[3,4,5],[3,2,6],[2,2,1]]
<strong>输出：</strong>4 
<strong>解释：</strong>最长递增路径是 <code>[3, 4, 5, 6]</code>。注意不允许在对角线方向上移动。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1]]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 <= m, n <= 200</code></li>
	<li><code>0 <= matrix[i][j] <= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dis = [[float('inf')] * n for _ in range(m)]
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        def search(a, b):
            nonlocal m, n, matrix, dis
            dis[a][b] = 1 if dis[a][b] == float('inf') else dis[a][b]
            q = deque()
            q.append([a, b])
            ans = 1
            while q:
                x, y = q.popleft()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if matrix[nx][ny] <= matrix[x][y]:
                        continue
                    if dis[nx][ny] == float('inf') or dis[nx][ny] < dis[x][y] + 1:
                        dis[nx][ny] = dis[x][y] + 1
                        ans = max(ans, dis[nx][ny])
                        q.append([nx, ny])
            return ans
        
        ans = 0
        for i in range(m):
            for j in range(n):
                ans = max(ans, search(i, j))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] matrix;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dis;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, search(i, j));
            }
        }
        return ans;
    }
    
    public int search(int a, int b) {
        dis[a][b] = dis[a][b] == Integer.MAX_VALUE ? 1 : dis[a][b];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a, b});
        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (matrix[nx][ny] <= matrix[x][y]) {
                    continue;
                }
                if (dis[nx][ny] == Integer.MAX_VALUE || dis[nx][ny] < dis[x][y] + 1) {
                    dis[nx][ny] = dis[x][y] + 1;
                    ans = Math.max(ans, dis[nx][ny]);
                    q.offer(new int[]{nx, ny});
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
