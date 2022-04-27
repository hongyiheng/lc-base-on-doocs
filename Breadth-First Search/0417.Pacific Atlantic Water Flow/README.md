# [417. 太平洋大西洋水流问题](https://leetcode-cn.com/problems/pacific-atlantic-water-flow)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个 <code>m x n</code> 的非负整数矩阵来表示一片大陆上各个单元格的高度。&ldquo;太平洋&rdquo;处于大陆的左边界和上边界，而&ldquo;大西洋&rdquo;处于大陆的右边界和下边界。</p>

<p>规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。</p>

<p>请找出那些水流既可以流动到&ldquo;太平洋&rdquo;，又能流动到&ldquo;大西洋&rdquo;的陆地单元的坐标。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>输出坐标的顺序不重要</li>
	<li><em>m</em> 和 <em>n</em> 都小于150</li>
</ol>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<p>&nbsp;</p>

<pre>
给定下面的 5x5 矩阵:

  太平洋 ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋

返回:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
</pre>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]
        pacific_queue = []
        atlantic_queue = []
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    pacific[i][j] = True
                    pacific_queue.append([i, j])
                if i == m - 1 or j == n - 1:
                    atlantic[i][j] = True
                    atlantic_queue.append([i, j])

        def bfs(res, q):
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            while q:
                x, y = q.pop()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if res[nx][ny] or heights[nx][ny] < heights[x][y]:
                        continue
                    res[nx][ny] = True
                    q.append([nx, ny])

        bfs(pacific, pacific_queue)
        bfs(atlantic, atlantic_queue)
        ans = []
        for i in range(m):
            for j in range(n):
                if pacific[i][j] and atlantic[i][j]:
                    ans.append([i, j])
        return ans
                
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int m, n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Deque<int[]> pacificQueue = new ArrayDeque<>();
        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = true;
                    pacificQueue.offer(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    atlantic[i][j] = true;
                    atlanticQueue.offer(new int[]{i, j});
                }
            }
        }
        bfs(pacific, pacificQueue);
        bfs(atlantic, atlanticQueue);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    ans.add(item);
                }
            }
        }
        return ans;
    }
    
    public void bfs(boolean[][] res, Deque<int[]> q) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (res[nx][ny] || heights[nx][ny] < heights[x][y]) {
                    continue;
                }
                res[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
