# [980. 不同路径 III](https://leetcode-cn.com/problems/unique-paths-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>在二维网格 <code>grid</code> 上，有 4 种类型的方格：</p>

<ul>
	<li><code>1</code> 表示起始方格。且只有一个起始方格。</li>
	<li><code>2</code> 表示结束方格，且只有一个结束方格。</li>
	<li><code>0</code> 表示我们可以走过的空方格。</li>
	<li><code>-1</code> 表示我们无法跨越的障碍。</li>
</ul>

<p>返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目<strong>。</strong></p>

<p><strong>每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
<strong>输出：</strong>2
<strong>解释：</strong>我们有以下两条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
<strong>输出：</strong>4
<strong>解释：</strong>我们有以下四条路径： 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[[0,1],[2,0]]
<strong>输出：</strong>0
<strong>解释：</strong>
没有一条路能完全穿过每一个空的方格一次。
请注意，起始和结束方格可以位于网格中的任意位置。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= grid.length * grid[0].length &lt;= 20</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        def dfs(x, y, vis):
            nonlocal m, n, cnt, ans
            if grid[x][y] == 2:
                if vis.bit_count() == cnt:
                    ans += 1
                return

            for d in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] == -1 or vis >> (nx * n + ny) & 1:
                    continue
                dfs(nx, ny, vis | 1 << (nx * n + ny))

        m, n = len(grid), len(grid[0])
        x = y = 0
        ans = cnt = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    x, y = i, j
                if grid[i][j] != -1:
                    cnt += 1
        dfs(x, y, 1 << (x * n + y))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    int[][] grid;
    int m, n, cnt, ans;
    
    public void dfs(int x, int y, int vis) {
        if (grid[x][y] == 2) {
            if (Integer.bitCount(vis) == cnt) {
                ans++;
            }
            return;
        }
        for (int[] d : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
               continue;
            }
            if (grid[nx][ny] == -1 || (vis >> (nx * n + ny) & 1) == 1) {
                continue;
            }
            dfs(nx, ny, vis | (1 << (nx * n + ny)));
        }
    }

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        cnt = 0;
        ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] != -1) {
                    cnt++;
                }
            }
        }
        dfs(x, y, 1 << (x * n + y));
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
