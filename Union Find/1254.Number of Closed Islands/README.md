# [1254. 统计封闭岛屿的数目](https://leetcode-cn.com/problems/number-of-closed-islands)

[English Version](/solution/1200-1299/1254.Number%20of%20Closed%20Islands/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>有一个二维矩阵 <code>grid</code>&nbsp;，每个位置要么是陆地（记号为&nbsp;<code>0</code> ）要么是水域（记号为&nbsp;<code>1</code> ）。</p>

<p>我们从一块陆地出发，每次可以往上下左右&nbsp;4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「<strong>岛屿</strong>」。</p>

<p>如果一座岛屿&nbsp;<strong>完全</strong>&nbsp;由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「<strong>封闭岛屿</strong>」。</p>

<p>请返回封闭岛屿的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/07/sample_3_1610.png"></p>

<pre><strong>输入：</strong>grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>
灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。</pre>

<p><strong>示例 2：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/07/sample_4_1610.png"></p>

<pre><strong>输入：</strong>grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,1,1,1,1,1],
&nbsp;            [1,0,0,0,0,0,1],
&nbsp;            [1,0,1,1,1,0,1],
&nbsp;            [1,0,1,0,1,0,1],
&nbsp;            [1,0,1,1,1,0,1],
&nbsp;            [1,0,0,0,0,0,1],
             [1,1,1,1,1,1,1]]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;=1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        border = [False] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    continue
                index = i * n + j
                if i > 0 and grid[i - 1][j] == 0:
                    p[find(index)] = find(index - n)
                if j > 0 and grid[i][j - 1] == 0:
                    p[find(index)] = find(index - 1)
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    border[find(i * n + j)] = True
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 0 and p[index] == index and not border[index]:
                    ans += 1
        return ans



```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    boolean[] border;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int index = i * n + j;
                if (i > 0 && grid[i - 1][j] == 0) {
                    p[find(index)] = find(index - n);
                }
                if (j > 0 && grid[i][j - 1] == 0) {
                    p[find(index)] = find(index - 1);
                }
                
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    border[find(i * n + j)] = true;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && p[i * n + j] == i * n + j && !border[i * n + j]) {
                    ans++;
                }
            } 
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
