# [688. “马”在棋盘上的概率](https://leetcode-cn.com/problems/knight-probability-in-chessboard)



## 题目描述

<!-- 这里写题目描述 -->

<p>已知一个&nbsp;<code>N</code>x<code>N</code>&nbsp;的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为&nbsp;<code>(0, 0)</code>，最右下角的记为&nbsp;<code>(N-1, N-1)</code>。&nbsp;</p>

<p>现有一个 &ldquo;马&rdquo;（也译作 &ldquo;骑士&rdquo;）位于&nbsp;<code>(r, c)</code>&nbsp;，并打算进行&nbsp;<code>K</code> 次移动。&nbsp;</p>

<p>如下图所示，国际象棋的 &ldquo;马&rdquo; 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。</p>

<p>&nbsp;</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/knight.png" style="height: 200px; width: 200px;"></p>

<p>&nbsp;</p>

<p>现在 &ldquo;马&rdquo; 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了&nbsp;<code>K</code>&nbsp;次或跳到了棋盘外面。</p>

<p>求移动结束后，&ldquo;马&rdquo; 仍留在棋盘上的概率。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> 3, 2, 0, 0
<strong>输出:</strong> 0.0625
<strong>解释:</strong> 
输入的数据依次为 N, K, r, c
第 1 步时，有且只有 2 种走法令 &ldquo;马&rdquo; 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 &ldquo;马&rdquo; 仍然留在棋盘上。
所以 &ldquo;马&rdquo; 在结束后仍在棋盘上的概率为 0.0625。
</pre>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul>
	<li><code>N</code> 的取值范围为 [1, 25]</li>
	<li><code>K</code>&nbsp;的取值范围为 [0, 100]</li>
	<li>开始时，&ldquo;马&rdquo; 总是位于棋盘上</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        mem = [[[-1] * (k + 1) for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                mem[i][j][0] = 1
        dirs = [[1, 2], [2, 1], [-2, 1], [1, -2], [-1, 2], [2, -1], [-1, -2], [-2, -1]]

        def dfs(x, y, k):
            if x < 0 or x >= n or y < 0 or y >=n:
                return 0
            if mem[x][y][k] != -1:
                return mem[x][y][k]
            ans = 0
            for d in dirs:
                ans += dfs(x + d[0], y + d[1], k - 1)
            mem[x][y][k] = ans / 8
            return mem[x][y][k] 

        return dfs(row, column, k)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    double[][][] mem;
    public double knightProbability(int n, int k, int row, int column) {
        mem = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < k + 1; m++) {
                    mem[i][j][m] = -1;
                    if (m == 0) {
                        mem[i][j][m] = 1;
                    }
                }
            }
        }
        return dfs(row, column, k, n);
    }

    public double dfs(int x, int y, int k, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }
        if (mem[x][y][k] != -1) {
            return mem[x][y][k];
        }
        int[][] dirs = new int[][]{{2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};
        double ans = 0;
        for (int[] dir : dirs) {
            ans += dfs(x + dir[0], y + dir[1], k - 1, n);
        }
        mem[x][y][k] = ans / 8.0;
        return mem[x][y][k];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
