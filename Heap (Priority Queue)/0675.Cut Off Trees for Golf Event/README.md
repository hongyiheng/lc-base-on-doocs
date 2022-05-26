# [675. 为高尔夫比赛砍树](https://leetcode-cn.com/problems/cut-off-trees-for-golf-event)



## 题目描述

<!-- 这里写题目描述 -->

<p>你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 <code>m x n</code> 的矩阵表示， 在这个矩阵中：</p>

<ul>
	<li><code>0</code> 表示障碍，无法触碰</li>
	<li><code>1</code> 表示地面，可以行走</li>
	<li><code>比 1 大的数</code> 表示有树的单元格，可以行走，数值表示树的高度</li>
</ul>

<p>每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。</p>

<p>你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 <code>1</code>（即变为地面）。</p>

<p>你将从 <code>(0, 0)</code> 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 <code>-1</code> 。</p>

<p>可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/trees1.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>forest = [[1,2,3],[0,0,4],[7,6,5]]
<strong>输出：</strong>6
<strong>解释：</strong>沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/trees2.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>forest = [[1,2,3],[0,0,0],[7,6,5]]
<strong>输出：</strong>-1
<strong>解释：</strong>由于中间一行被障碍阻塞，无法访问最下面一行中的树。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>forest = [[2,3,4],[0,0,5],[8,7,6]]
<strong>输出：</strong>6
<strong>解释：</strong>可以按与示例 1 相同的路径来砍掉所有的树。
(0,0) 位置的树，可以直接砍去，不用算步数。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == forest.length</code></li>
	<li><code>n == forest[i].length</code></li>
	<li><code>1 <= m, n <= 50</code></li>
	<li><code>0 <= forest[i][j] <= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:    
        def get_f(a, b, c, d, g):
            return abs(a - c) + abs(c - d) + g

        def astar_search(a, b, c, d):
            q = []
            heapq.heappush(q, [get_f(a, b, c, d, 0), a, b])
            dis = [[float('inf')] * n for _ in range(m)]
            dis[a][b] = 0
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            while q:
                _, x, y = heapq.heappop(q)
                g = dis[x][y]
                if x == c and y == d:
                    return g
                for dir in dirs:
                    nx, ny = x + dir[0], y + dir[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n or forest[nx][ny] == 0:
                        continue
                    if dis[nx][ny] <= g + 1:
                        continue
                    dis[nx][ny] = g + 1
                    heapq.heappush(q, [get_f(nx, ny, c, d, dis[nx][ny]), nx, ny])
            return -1

        m, n = len(forest), len(forest[0])
        q = []
        for i in range(m):
            for j in range(n):
                if forest[i][j] > 1:
                    heapq.heappush(q, [forest[i][j], i, j])
        x, y = 0, 0
        ans = 0
        while q:
            _, nx, ny = heapq.heappop(q)
            dis = astar_search(x, y, nx, ny)
            if dis == -1:
                return -1
            x, y = nx, ny
            ans += dis
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] grid;
    int m, n;

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        m = forest.size();
        n = forest.get(0).size();
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = forest.get(i).get(j);
                if (forest.get(i).get(j) > 1) {
                    q.offer(new int[]{grid[i][j], i, j});
                }
            }
        }
        int x = 0, y = 0, ans = 0;
        while (!q.isEmpty()) {
            int[] ne = q.poll();
            int dis = astarSearch(x, y, ne[1], ne[2]);
            if (dis == -1) {
                return -1;
            }
            x = ne[1];
            y = ne[2];
            ans += dis;
        }
        return ans;
    }

    public int astarSearch(int a, int b, int c, int d) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        q.offer(new int[]{getF(a, b, c, d, 0), a, b});
        dis[a][b] = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[1], y = cur[2];
            int g = dis[x][y];
            if (x == c && y == d) {
                return g;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                    continue;
                }
                if (dis[nx][ny] <= g + 1) {
                    continue;
                }
                dis[nx][ny] = g + 1;
                q.offer(new int[]{getF(nx, ny, c, d, dis[nx][ny]), nx, ny});
            }
        } 
        return -1;
    }

    public int getF(int a, int b, int c, int d, int dis) {
        return Math.abs(a - c) + Math.abs(b - d) + dis;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
