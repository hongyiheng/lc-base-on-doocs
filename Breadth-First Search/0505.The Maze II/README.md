# [505. 迷宫 II](https://leetcode-cn.com/problems/the-maze-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>由空地和墙组成的迷宫中有一个<strong>球</strong>。球可以向<strong>上下左右</strong>四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。</p>

<p>给定球的<strong>起始位置，目的地</strong>和<strong>迷宫，</strong>找出让球停在目的地的最短距离。距离的定义是球从起始位置（不包括）到目的地（包括）经过的<strong>空地</strong>个数。如果球无法停在目的地，返回&nbsp;-1。</p>

<p>迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入 1:</strong> 迷宫由以下二维数组表示

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

<strong>输入 2:</strong> 起始位置坐标 (rowStart, colStart) = (0, 4)
<strong>输入 3:</strong> 目的地坐标 (rowDest, colDest) = (4, 4)

<strong>输出:</strong> 12

<strong>解析:</strong> 一条最短路径 : left -&gt; down -&gt; left -&gt; down -&gt; right -&gt; down -&gt; right。
             总距离为 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12。
<img src="https://assets.leetcode.com/uploads/2018/10/12/maze_1_example_1.png" style="width: 100%;">
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入 1:</strong> 迷宫由以下二维数组表示

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

<strong>输入 2:</strong> 起始位置坐标 (rowStart, colStart) = (0, 4)
<strong>输入 3:</strong> 目的地坐标 (rowDest, colDest) = (3, 2)

<strong>输出:</strong> -1

<strong>解析:</strong> 没有能够使球停在目的地的路径。
<img src="https://assets.leetcode.com/uploads/2018/10/13/maze_1_example_2.png" style="width: 100%;">
</pre>

<p>&nbsp;</p>

<p><strong>注意:</strong></p>

<ol>
	<li>迷宫中只有一个球和一个目的地。</li>
	<li>球和目的地都在空地上，且初始时它们不在同一位置。</li>
	<li>给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。</li>
	<li>迷宫至少包括2块空地，行数和列数均不超过100。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestDistance(self, maze: List[List[int]], start: List[int], destination: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        dis = [[float('inf')] * n for _ in range(m)]
        q = deque()
        q.append(start)
        dis[start[0]][start[1]] = 0
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            cur = q.popleft()
            for d in dirs:     
                nx, ny = cur[0] + d[0], cur[1] + d[1]
                step = 0
                while 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == 0:
                    nx += d[0]
                    ny += d[1]
                    step += 1
                nx -= d[0]
                ny -= d[1]
                if dis[cur[0]][cur[1]] + step < dis[nx][ny]:
                    dis[nx][ny] = dis[cur[0]][cur[1]] + step
                    q.append([nx, ny])
        return dis[destination[0]][destination[1]] if dis[destination[0]][destination[1]] != float('inf') else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        } 
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        dis[start[0]][start[1]] = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int step = 0;
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += d[0];
                    ny += d[1];
                    step++;
                }
                nx -= d[0];
                ny -= d[1];
                if (dis[nx][ny] > dis[x][y] + step) {
                    dis[nx][ny] = dis[x][y] + step;
                    q.offerLast(new int[]{nx, ny});
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
