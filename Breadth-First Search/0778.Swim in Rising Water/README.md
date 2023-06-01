# [778. 水位上升的泳池中游泳](https://leetcode-cn.com/problems/swim-in-rising-water)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个 N x N 的坐标方格 <code>grid</code> 中，每一个方格的值 <code>grid[i][j]</code> 表示在位置 <code>(i,j)</code> 的平台高度。</p>

<p>现在开始下雨了。当时间为 <code>t</code> 时，此时雨水导致水池中任意位置的水位为 <code>t</code> 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。</p>

<p>你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 <code>(N-1, N-1)</code>？</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [[0,2],[1,3]]
<strong>输出:</strong> 3
<strong>解释:</strong>
时间为0时，你位于坐标方格的位置为 <code>(0, 0)。</code>
此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。

等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
</pre>

<p><strong>示例2:</strong></p>

<pre>
<strong>输入:</strong> [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
<strong>输出:</strong> 16
<strong>解释:</strong>
<strong> 0  1  2  3  4</strong>
24 23 22 21  <strong>5</strong>
<strong>12 13 14 15 16</strong>
<strong>11</strong> 17 18 19 20
<strong>10  9  8  7  6</strong>

最终的路线用加粗进行了标记。
我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ol>
	<li><code>2 <= N <= 50</code>.</li>
	<li><code>grid[i][j]</code> 是 <code>[0, ..., N*N - 1]</code> 的排列。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        n = len(grid)
        ans = [[0] * n for _ in range(n)]
        vis = [[False] * n for _ in range(n)]
        q = deque([[0, 0]])
        vis[0][0] = True
        ans[0][0] = grid[0][0]
        while q:
            x, y = q.pop()
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                w = max(ans[x][y], grid[nx][ny])
                if vis[nx][ny] and ans[nx][ny] <= w:
                    continue
                vis[nx][ny] = True
                ans[nx][ny] = w
                q.append([nx, ny])
        return ans[n - 1][n - 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];
        int[][] ans = new int[n][n];
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        ans[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            int[] cur = q.pop();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                int w = Math.max(ans[x][y], grid[nx][ny]);
                if (vis[nx][ny] && ans[nx][ny] <= w) {
                    continue;
                }
                vis[nx][ny] = true;
                ans[nx][ny] = w;
                q.addLast(new int[]{nx, ny});
            }
        }
        return ans[n - 1][n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
