# [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions)

[English Version](/solution/0100-0199/0130.Surrounded%20Regions/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

给你一个 <code>m x n</code> 的矩阵 <code>board</code> ，由若干字符 <code>'X'</code> 和 <code>'O'</code> ，找到所有被 <code>'X'</code> 围绕的区域，并将这些区域里所有的 <code>'O'</code> 用 <code>'X'</code> 填充。
<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/xogrid.jpg" style="width: 550px; height: 237px;" />
<pre>
<strong>输入：</strong>board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
<strong>输出：</strong>[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
<strong>解释：</strong>被围绕的区间不会存在于边界上，换句话说，任何边界上的 <code>'O'</code> 都不会被填充为 <code>'X'</code>。 任何不在边界上，或不与边界上的 <code>'O'</code> 相连的 <code>'O'</code> 最终都会被填充为 <code>'X'</code>。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>board = [["X"]]
<strong>输出：</strong>[["X"]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 <= m, n <= 200</code></li>
	<li><code>board[i][j]</code> 为 <code>'X'</code> 或 <code>'O'</code></li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m, n = len(board), len(board[0])
        p = [i for i in range(m * n)]
        border = [False] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                p[r1] = r2

        for i in range(m):
            for j in range(n):
                if board[i][j] != 'O':
                    continue
                index = i * n + j
                if i < m - 1 and board[i + 1][j] == 'O':
                    union(index, index + n)
                if j < n - 1 and board[i][j + 1] == 'O':
                    union(index, index + 1)
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    border[find(i * n + j)] = True
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and not border[find(i * n + j)]:
                    board[i][j] = 'X'
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    boolean[] border;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        p = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int index = i * n + j;
                if (i < m - 1 && board[i + 1][j] == 'O') {
                    union(index, index + n);
                }
                if (j < n - 1 && board[i][j + 1] == 'O') {
                    union(index, index + 1);
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && border[find(i * n + j)] == false) {
                   board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
