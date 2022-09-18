# [827. 最大人工岛](https://leetcode-cn.com/problems/making-a-large-island)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个大小为 <code>n x n</code> 二进制矩阵 <code>grid</code> 。<strong>最多</strong> 只能将一格 <code>0</code> 变成 <code>1</code> 。</p>

<p>返回执行此操作后，<code>grid</code> 中最大的岛屿面积是多少？</p>

<p><strong>岛屿</strong> 由一组上、下、左、右四个方向相连的 <code>1</code> 形成。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>grid = [[1, 0], [0, 1]]
<strong>输出:</strong> 3
<strong>解释:</strong> 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>grid =<strong> </strong>[[1, 1], [1, 0]]
<strong>输出:</strong> 4
<strong>解释:</strong> 将一格0变成1，岛屿的面积扩大为 4。</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>grid = [[1, 1], [1, 1]]
<strong>输出:</strong> 4
<strong>解释:</strong> 没有0可以让我们变成1，面积依然为 4。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 <= n <= 500</code></li>
	<li><code>grid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def dfs(x, y, v):
            if grid[x][y] != 1:
                return 0
            grid[x][y] = v
            ans = 1
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] == 1:
                    ans += dfs(nx, ny, v)
            return ans

        mp = dict()
        ans, group = 0, 2
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    mp[group] = dfs(i, j, group)
                    ans = max(ans, mp[group])
                    group += 1
        for i in range(n):
            for j in range(n):
                if grid[i][j] != 0:
                    continue
                cur = 1
                used = {0, 1}
                for d in dirs:
                    nx, ny = i + d[0], j + d[1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] in used:
                        continue
                    cur += mp[grid[nx][ny]]
                    used.add(grid[nx][ny])
                ans = max(ans, cur)          
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0, group = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mp.put(group, dfs(i, j, group));
                    ans = Math.max(ans, mp.get(group));
                    group++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                int cur = 1;
                Set<Integer> used = new HashSet<>();
                used.add(0); 
                used.add(1);
                for (int[] d : dirs) {
                    int nx = i + d[0], ny = j + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (used.contains(grid[nx][ny])) {
                        continue;
                    }
                    cur += mp.get(grid[nx][ny]);
                    used.add(grid[nx][ny]);
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int v) {
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = v;
        int ans = 1;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                ans += dfs(nx, ny, v);
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
