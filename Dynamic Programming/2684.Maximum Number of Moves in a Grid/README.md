# [2684. 矩阵中移动的最大次数](https://leetcode-cn.com/problems/maximum-number-of-moves-in-a-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始、大小为 <code>m x n</code> 的矩阵 <code>grid</code> ，矩阵由若干 <strong>正</strong> 整数组成。</p>

<p>你可以从矩阵第一列中的 <strong>任一</strong> 单元格出发，按以下方式遍历&nbsp;<code>grid</code> ：</p>

<ul>
	<li>从单元格 <code>(row, col)</code> 可以移动到&nbsp;<code>(row - 1, col + 1)</code>、<code>(row, col + 1)</code> 和 <code>(row + 1, col + 1)</code> 三个单元格中任一满足值 <strong>严格</strong> 大于当前单元格的单元格。</li>
</ul>

<p>返回你在矩阵中能够 <strong>移动</strong> 的 <strong>最大</strong> 次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/04/11/yetgriddrawio-10.png" style="width: 201px; height: 201px;">
<pre><strong>输入：</strong>grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
<strong>输出：</strong>3
<strong>解释：</strong>可以从单元格 (0, 0) 开始并且按下面的路径移动：
- (0, 0) -&gt; (0, 1).
- (0, 1) -&gt; (1, 2).
- (1, 2) -&gt; (2, 3).
可以证明这是能够移动的最大次数。</pre>

<p><strong>示例 2：</strong></p>

<pre><img alt="" src="https://assets.leetcode.com/uploads/2023/04/12/yetgrid4drawio.png">
<strong>输入：</strong>grid = [[3,2,4],[2,1,9],[1,1,7]]
<strong>输出：</strong>0
<strong>解释：</strong>从第一列的任一单元格开始都无法移动。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 1000</code></li>
	<li><code>4 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * n for _ in range(m)]
        for i in range(m):
            f[i][0] = grid[i][0]
        ans = 0
        for j in range(1, n):
            for i in range(m):
                v = f[i][j - 1]
                if i > 0:
                    v = min(v, f[i - 1][j - 1])
                if i < m - 1:
                    v = min(v, f[i + 1][j - 1])
                if grid[i][j] > v:
                    f[i][j] = grid[i][j]
                    ans = j
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int[] r : f) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = grid[i][0];
        }
        int ans = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int v = f[i][j - 1];
                if (i > 0) {
                    v = Math.min(v, f[i - 1][j - 1]);
                }
                if (i < m - 1) {
                    v = Math.min(v, f[i + 1][j - 1]);
                }
                if (grid[i][j] > v) {
                    f[i][j] =  grid[i][j];
                    ans = j;
                }
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
