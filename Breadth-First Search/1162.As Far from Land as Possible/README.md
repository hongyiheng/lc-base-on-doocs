# [1162. 地图分析](https://leetcode-cn.com/problems/as-far-from-land-as-possible)

## 题目描述

<!-- 这里写题目描述 -->

<p>你现在手里有一份大小为&nbsp;N x N 的 网格 <code>grid</code>，上面的每个 单元格 都用&nbsp;<code>0</code>&nbsp;和&nbsp;<code>1</code>&nbsp;标记好了。其中&nbsp;<code>0</code>&nbsp;代表海洋，<code>1</code>&nbsp;代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。</p>

<p>我们这里说的距离是「曼哈顿距离」（&nbsp;Manhattan Distance）：<code>(x0, y0)</code> 和&nbsp;<code>(x1, y1)</code>&nbsp;这两个单元格之间的距离是&nbsp;<code>|x0 - x1| + |y0 - y1|</code>&nbsp;。</p>

<p>如果网格上只有陆地或者海洋，请返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/1336_ex1.jpeg" style="height: 87px; width: 185px;"></strong></p>

<pre><strong>输入：</strong>[[1,0,1],[0,0,0],[1,0,1]]
<strong>输出：</strong>2
<strong>解释： </strong>
海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/1336_ex2.jpeg" style="height: 87px; width: 184px;"></strong></p>

<pre><strong>输入：</strong>[[1,0,0],[0,0,0],[0,0,0]]
<strong>输出：</strong>4
<strong>解释： </strong>
海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= grid.length == grid[0].length&nbsp;&lt;= 100</code></li>
	<li><code>grid[i][j]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        q = deque()
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    q.append([i, j])
        ans = -1
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            k = len(q)
            for i in range(k):
                cur = q.popleft()
                x, y = cur[0], cur[1]
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n or grid[nx][ny] != 0:
                        continue
                    grid[nx][ny] = grid[x][y] + 1
                    ans = max(grid[nx][ny] - 1, ans)
                    q.append([nx, ny])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] g;
    Deque<int[]> q;
    int ans = -1;
    public int maxDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        q = new ArrayDeque<>(); 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.addLast(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] != 0) {
                        continue;
                    }
                    g[nx][ny] = g[x][y] + 1;
                    q.addLast(new int[]{nx, ny});
                    ans = Math.max(ans, g[nx][ny] - 1);
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
