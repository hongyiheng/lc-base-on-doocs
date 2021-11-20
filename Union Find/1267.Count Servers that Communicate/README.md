# [1267. 统计参与通信的服务器](https://leetcode-cn.com/problems/count-servers-that-communicate)



## 题目描述

<!-- 这里写题目描述 -->

<p>这里有一幅服务器分布图，服务器的位置标识在&nbsp;<code>m * n</code>&nbsp;的整数矩阵网格&nbsp;<code>grid</code>&nbsp;中，1 表示单元格上有服务器，0 表示没有。</p>

<p>如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。</p>

<p>请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/24/untitled-diagram-6.jpg" style="height: 203px; width: 202px;"></p>

<pre><strong>输入：</strong>grid = [[1,0],[0,1]]
<strong>输出：</strong>0
<strong>解释：</strong>没有一台服务器能与其他服务器进行通信。</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/24/untitled-diagram-4-1.jpg" style="height: 203px; width: 203px;"></strong></p>

<pre><strong>输入：</strong>grid = [[1,0],[1,1]]
<strong>输出：</strong>3
<strong>解释：</strong>所有这些服务器都至少可以与一台别的服务器进行通信。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/24/untitled-diagram-1-3.jpg" style="height: 443px; width: 443px;"></p>

<pre><strong>输入：</strong>grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
<strong>输出：</strong>4
<strong>解释：</strong>第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 250</code></li>
	<li><code>1 &lt;= n &lt;= 250</code></li>
	<li><code>grid[i][j] == 0 or 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        area = [1] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                area[r2] += area[r1]
                p[r1] = r2

        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    continue
                index = i * n + j
                row = i + 1
                while row < m:
                    if grid[row][j] == 1:
                        union(index, row * n + j)
                    row += 1
                col = j + 1
                while col < n:
                    if grid[i][col] == 1:
                        union(index, i * n + col)
                    col += 1
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 1 and p[index] == index and area[index] > 1:
                    ans += area[index]
        return ans

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    int[] area;

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            area[i] = 1;
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int index = i * n + j;
                int row = i;
                while (++row < m) {
                    if (grid[row][j] == 1) {
                        union(index, row * n + j);
                    }
                }
                int col = j;
                while (++col < n) {
                    if (grid[i][col] == 1) {
                        union(index, i * n + col);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 1 && p[index] == index && area[index] > 1) {
                    ans += area[index];
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
