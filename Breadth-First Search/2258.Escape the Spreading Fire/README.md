# [2258. 逃离火灾](https://leetcode-cn.com/problems/escape-the-spreading-fire)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始大小为 <code>m x n</code>&nbsp;的二维整数数组&nbsp;<code>grid</code>&nbsp;，它表示一个网格图。每个格子为下面 3 个值之一：</p>

<ul>
	<li><code>0</code> 表示草地。</li>
	<li><code>1</code> 表示着火的格子。</li>
	<li><code>2</code>&nbsp;表示一座墙，你跟火都不能通过这个格子。</li>
</ul>

<p>一开始你在最左上角的格子&nbsp;<code>(0, 0)</code>&nbsp;，你想要到达最右下角的安全屋格子&nbsp;<code>(m - 1, n - 1)</code>&nbsp;。每一分钟，你可以移动到&nbsp;<strong>相邻</strong>&nbsp;的草地格子。每次你移动 <strong>之后</strong>&nbsp;，着火的格子会扩散到所有不是墙的 <strong>相邻</strong>&nbsp;格子。</p>

<p>请你返回你在初始位置可以停留的 <strong>最多 </strong>分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 <code>-1</code>&nbsp;。如果不管你在初始位置停留多久，你 <strong>总是</strong>&nbsp;能到达安全屋，请你返回&nbsp;<code>10<sup>9</sup></code>&nbsp;。</p>

<p>注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。</p>

<p>如果两个格子有共同边，那么它们为 <strong>相邻</strong>&nbsp;格子。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex1new.jpg" style="width: 650px; height: 404px;"></p>

<pre><b>输入：</b>grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
<b>输出：</b>3
<b>解释：</b>上图展示了你在初始位置停留 3 分钟后的情形。
你仍然可以安全到达安全屋。
停留超过 3 分钟会让你无法安全到达安全屋。</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex2new2.jpg" style="width: 515px; height: 150px;"></p>

<pre><b>输入：</b>grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
<b>输出：</b>-1
<b>解释：</b>上图展示了你马上开始朝安全屋移动的情形。
火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
所以返回 -1 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex3new.jpg" style="width: 174px; height: 150px;"></p>

<pre><b>输入：</b>grid = [[0,0,0],[2,2,0],[1,2,0]]
<b>输出：</b>1000000000
<b>解释：</b>上图展示了初始网格图。
注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
所以返回 10<sup>9</sup> 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 300</code></li>
	<li><code>4 &lt;= m * n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>grid[i][j]</code>&nbsp;是&nbsp;<code>0</code>&nbsp;，<code>1</code>&nbsp;或者&nbsp;<code>2</code>&nbsp;。</li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 0</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    f.append([i, j])
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def infect(g, q):
            nonlocal grid, m, n, dirs
            ans = []
            while q:
                x, y = q.pop()
                g[x][y] = True
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if g[nx][ny] or grid[nx][ny] == 2:
                        continue
                    g[nx][ny] = True
                    ans.append([nx, ny])
            return ans

        def check(x):
            nonlocal f, grid, dirs, m, n
            cur_fire = f[:]
            fire = [[False] * n for _ in range(m)]
            while x > 0:
                cur_fire = infect(fire, cur_fire)
                x -= 1
            if fire[0][0]:
                return False
            vis = [[False] * n for _ in range(m)]
            vis[0][0] = True
            q = deque()
            q.append([0, 0])
            while q:
                if fire[m - 1][n - 1]:
                    return False
                k = len(q)
                for _ in range(k):
                    x, y = q.popleft()
                    if fire[x][y]:
                        continue
                    for d in dirs:
                        nx, ny = x + d[0], y + d[1]
                        if nx < 0 or nx >= m or ny < 0 or ny >= n:
                            continue
                        if vis[nx][ny] or fire[nx][ny] or grid[nx][ny] == 2:
                            continue
                        if nx == m - 1 and ny == n - 1:
                            return True
                        vis[nx][ny] = True
                        q.append([nx, ny])
                cur_fire = infect(fire, cur_fire)
            return False
            
        left, right = 0, m * n
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        if left == m * n:
            return int(1e9)
        return left if check(left) else -1



```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int m, n;
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left == m * n) {
            return (int)1e9;
        }
        return check(left) ? left : -1;
    }

    public boolean check(int t) {
        boolean[][] fire = new boolean[m][n];
        List<int[]> curFire = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fire[i][j] = true;
                    curFire.add(new int[]{i, j});
                }
            }
        }
        while (t-- > 0) {
            curFire = infect(fire, curFire);
        }
        if (fire[0][0]) {
            return false;
        }
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            if (fire[m - 1][n - 1]) {
                return false;
            }
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (fire[x][y]) {
                    continue;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (vis[nx][ny] || fire[nx][ny] || grid[nx][ny] == 2) {
                        continue;
                    }
                    if (nx == m - 1 && ny == n - 1) {
                        return true;
                    }
                    vis[nx][ny] = true;
                    q.addLast(new int[]{nx, ny});
                }
            }
            curFire = infect(fire, curFire);
        }
        return false;
    }

    public List<int[]> infect(boolean[][] fire, List<int[]> f) {
        List<int[]> next = new ArrayList<>();
        for (int[] v : f) {
            int x = v[0], y = v[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (fire[nx][ny] || grid[nx][ny] == 2) {
                    continue;
                }
                fire[nx][ny] = true;
                next.add(new int[]{nx, ny});
            }
        }
        return next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
