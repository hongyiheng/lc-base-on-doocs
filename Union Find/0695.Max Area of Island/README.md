# [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含了一些 <code>0</code> 和 <code>1</code> 的非空二维数组&nbsp;<code>grid</code> 。</p>

<p>一个&nbsp;<strong>岛屿</strong>&nbsp;是由一些相邻的&nbsp;<code>1</code>&nbsp;(代表土地) 构成的组合，这里的「相邻」要求两个 <code>1</code> 必须在水平或者竖直方向上相邻。你可以假设&nbsp;<code>grid</code> 的四个边缘都被 <code>0</code>（代表水）包围着。</p>

<p>找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 <code>0</code> 。)</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,<strong>1</strong>,0,<strong>1</strong>,0,0],
 [0,1,0,0,1,1,0,0,<strong>1</strong>,<strong>1</strong>,<strong>1</strong>,0,0],
 [0,0,0,0,0,0,0,0,0,0,<strong>1</strong>,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
</pre>

<p>对于上面这个给定矩阵应返回&nbsp;<code>6</code>。注意答案不应该是 <code>11</code> ，因为岛屿只能包含水平或垂直的四个方向的 <code>1</code> 。</p>

<p><strong>示例 2:</strong></p>

<pre>[[0,0,0,0,0,0,0,0]]</pre>

<p>对于上面这个给定的矩阵, 返回&nbsp;<code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>注意:&nbsp;</strong>给定的矩阵<code>grid</code>&nbsp;的长度和宽度都不超过 50。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        area = [1] * (m * n)
        
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
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 1 and p[index] == index:
                    ans = max(ans, area[index])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    int[] area;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
            area[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(index, index - n);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(index, index - 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && p[i * n + j] == i * n + j) {
                    ans = Math.max(ans, area[i * n + j]);
                }
            }
        }
        return ans;
    }

    private void union(int index1, int index2) {
        int r1 = find(index1);
        int r2 = find(index2);
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
