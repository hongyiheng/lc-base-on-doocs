# [1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个二维数组&nbsp;<code>A</code>，每个单元格为 0（代表海）或 1（代表陆地）。</p>

<p>移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。</p>

<p>返回网格中<strong>无法</strong>在任意次数的移动中离开网格边界的陆地单元格的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
<strong>输出：</strong>3
<strong>解释： </strong>
有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
<strong>输出：</strong>0
<strong>解释：</strong>
所有 1 都在边界上或可以到达边界。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 500</code></li>
	<li><code>1 &lt;= A[i].length &lt;= 500</code></li>
	<li><code>0 &lt;= A[i][j] &lt;= 1</code></li>
	<li>所有行的大小都相同</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        p = [i for i in range(m * n)]
        area = [1] * (m * n)
        border = [False] * (m * n)
        
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if r1 != r2:
                area[r2] += area[r1]
                p[r1] = r2
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    continue
                index = i * n + j
                if i > 0 and grid[i - 1][j] == 1:
                    union(index, index - n)
                if j > 0 and grid[i][j - 1] == 1:
                    union(index, index - 1)
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    border[find(i * n + j)] = True
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and p[i * n + j] == i * n + j and not border[i * n + j]:
                    ans += area[i * n + j]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    int[] area;
    boolean[] border;

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            area[i] = 1;
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int index = i * n + j;
                if (i > 0 && grid[i - 1][j] == 1) {
                   union(index, index - n);
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                   union(index, index - 1);
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
                if (grid[i][j] == 1 && p[i * n + j] == i * n + j && !border[i * n + j]) {
                    ans += area[i * n + j];
                }
            } 
        }
        return ans;
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            area[r2] += area[r1];
            p[r1] = r2;
        }
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
