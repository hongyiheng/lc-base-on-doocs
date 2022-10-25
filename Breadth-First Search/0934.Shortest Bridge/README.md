# [934. 最短的桥](https://leetcode-cn.com/problems/shortest-bridge)



## 题目描述

<!-- 这里写题目描述 -->

<p>在给定的二维二进制数组 <code>A</code> 中，存在两座岛。（岛是由四面相连的 <code>1</code> 形成的一个最大组。）</p>

<p>现在，我们可以将 <code>0</code> 变为 <code>1</code>，以使两座岛连接起来，变成一座岛。</p>

<p>返回必须翻转的 <code>0</code> 的最小数目。（可以保证答案至少是 <code>1</code> 。）</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>A = [[0,1],[1,0]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>A = [[0,1,0],[0,0,0],[0,0,1]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
<strong>输出：</strong>1</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= A.length == A[0].length <= 100</code></li>
	<li><code>A[i][j] == 0</code> 或 <code>A[i][j] == 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        n = len(grid)
        q = deque()

        def dfs(x, y):
            if grid[x][y] != 1:
                return
            q.append((x, y))
            grid[x][y] = 2
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                dfs(nx, ny)

        for i in range(n):
            end = False
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j)
                    end = True
                    break
            if end:
                break
        ans = 0
        while q:
            m = len(q)
            for _ in range(m):
                x, y = q.popleft()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] == 1:
                        return ans
                    if grid[nx][ny] == 0:
                        grid[nx][ny] = 2
                        q.append((nx, ny))
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Deque<int[]> q = new ArrayDeque<>();
    int n;

    public void dfs(int[][] g, int x, int y) {
        if (g[x][y] != 1) {
            return;
        }
        q.addLast(new int[]{x, y});
        g[x][y] = 2;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            dfs(g, nx, ny);
        }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean end = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        return ans;
                    }
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2;
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
