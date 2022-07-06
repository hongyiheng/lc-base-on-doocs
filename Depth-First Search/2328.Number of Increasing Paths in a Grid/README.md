# [2328. 网格图中递增路径的数目](https://leetcode-cn.com/problems/number-of-increasing-paths-in-a-grid)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>m x n</code>&nbsp;的整数网格图&nbsp;<code>grid</code>&nbsp;，你可以从一个格子移动到&nbsp;<code>4</code>&nbsp;个方向相邻的任意一个格子。</p>

<p>请你返回在网格图中从 <strong>任意</strong>&nbsp;格子出发，达到 <strong>任意</strong>&nbsp;格子，且路径中的数字是 <strong>严格递增</strong>&nbsp;的路径数目。由于答案可能会很大，请将结果对&nbsp;<code>10<sup>9</sup> + 7</code>&nbsp;<strong>取余</strong>&nbsp;后返回。</p>

<p>如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/05/10/griddrawio-4.png" style="width: 181px; height: 121px;"></p>

<pre><b>输入：</b>grid = [[1,1],[3,4]]
<b>输出：</b>8
<b>解释：</b>严格递增路径包括：
- 长度为 1 的路径：[1]，[1]，[3]，[4] 。
- 长度为 2 的路径：[1 -&gt; 3]，[1 -&gt; 4]，[3 -&gt; 4] 。
- 长度为 3 的路径：[1 -&gt; 3 -&gt; 4] 。
路径数目为 4 + 3 + 1 = 8 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>grid = [[1],[2]]
<b>输出：</b>3
<b>解释：</b>严格递增路径包括：
- 长度为 1 的路径：[1]，[2] 。
- 长度为 2 的路径：[1 -&gt; 2] 。
路径数目为 2 + 1 = 3 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        mod = int(1e9 + 7)
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(x, y):
            cnt = 1
            for d in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] > grid[x][y]:
                    cnt += dfs(nx, ny)          
            return cnt

        ans = 0
        for i in range(m):
            for j in range(n):
                ans += dfs(i, j)
        return ans % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] grid;
    Map<Integer, Long> mp;
    int m, n;
    int mod = (int)1e9 + 7;

    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mp.containsKey(i * n + j)) {
                    ans = (ans + mp.get(i * n + j)) % mod;
                } else {
                    ans = (ans + dfs(i, j)) % mod;
                }  
            }
        }
        return (int)(ans % mod);
    }

    public long dfs(int x, int y) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        long ans = 1;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] <= grid[x][y]) {
                continue;
            }
            if (!mp.containsKey(nx * n + ny)) {
                mp.put(nx * n + ny, dfs(nx, ny));
            } 
            ans += mp.get(nx * n + ny);
        }
        ans %= mod;
        mp.put(x * n + y, ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
