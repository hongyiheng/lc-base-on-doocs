# [1463. 摘樱桃 II](https://leetcode-cn.com/problems/cherry-pickup-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>rows x cols</code> 的矩阵&nbsp;<code>grid</code>&nbsp;来表示一块樱桃地。 <code>grid</code>&nbsp;中每个格子的数字表示你能获得的樱桃数目。</p>

<p>你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 <code>(0,0)</code> 出发，机器人 2 从右上角格子 <code>(0, cols-1)</code> 出发。</p>

<p>请你按照如下规则，返回两个机器人能收集的最多樱桃数目：</p>

<ul>
	<li>从格子&nbsp;<code>(i,j)</code> 出发，机器人可以移动到格子&nbsp;<code>(i+1, j-1)</code>，<code>(i+1, j)</code> 或者&nbsp;<code>(i+1, j+1)</code>&nbsp;。</li>
	<li>当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。</li>
	<li>当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。</li>
	<li>两个机器人在任意时刻都不能移动到 <code>grid</code>&nbsp;外面。</li>
	<li>两个机器人最后都要到达&nbsp;<code>grid</code>&nbsp;最底下一行。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/sample_1_1802.png" style="height: 182px; width: 139px;"></strong></p>

<pre><strong>输入：</strong>grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
<strong>输出：</strong>24
<strong>解释：</strong>机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
机器人 1 摘的樱桃数目为 (3 + 2 + 5 + 2) = 12 。
机器人 2 摘的樱桃数目为 (1 + 5 + 5 + 1) = 12 。
樱桃总数为： 12 + 12 = 24 。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/sample_2_1802.png" style="height: 257px; width: 284px;"></strong></p>

<pre><strong>输入：</strong>grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
<strong>输出：</strong>28
<strong>解释：</strong>机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
机器人 1 摘的樱桃数目为 (1 + 9 + 5 + 2) = 17 。
机器人 2 摘的樱桃数目为 (1 + 3 + 4 + 3) = 11 。
樱桃总数为： 17 + 11 = 28 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
<strong>输出：</strong>22
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1],[1,1]]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == grid.length</code></li>
	<li><code>cols == grid[i].length</code></li>
	<li><code>2 &lt;= rows, cols &lt;= 70</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 100&nbsp;</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(x, j1, j2):
            nonlocal m, n
            if j1 < 0 or j1 >= n or j2 < 0 or j2 >= n:
                return 0
            ans = grid[x][j1] + (grid[x][j2] if j1 != j2 else 0)
            if x == m - 1:
                return ans
            v = 0
            for i in range(-1, 2):
                for j in range(-1, 2):
                    v = max(v, dfs(x + 1, j1 - i, j2 - j))
            return ans + v
        
        m, n = len(grid), len(grid[0])
        return dfs(0, 0, n - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int m, n;
    int[][][] f;

    public int dfs(int x, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return 0;
        }
        if (f[x][j1][j2] != -1) {
            return f[x][j1][j2];
        }
        int ans = grid[x][j1] + (j1 != j2 ? grid[x][j2] : 0);
        if (x == m - 1) {
            return ans;
        }
        int v = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                v = Math.max(v, dfs(x + 1, j1 + i, j2 + j, grid));
            }
        }
        f[x][j1][j2] = ans + v;
        return ans + v;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        f = new int[m][n][n];
        for (int[][] g : f) {
            for (int[] row : g) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, 0, n - 1, grid);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
