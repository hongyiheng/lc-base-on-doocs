# [1263. 推箱子](https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location)



## 题目描述

<!-- 这里写题目描述 -->

<p>「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。</p>

<p>游戏地图用大小为 <code>n * m</code> 的网格 <code>grid</code> 表示，其中每个元素可以是墙、地板或者是箱子。</p>

<p>现在你将作为玩家参与游戏，按规则将箱子&nbsp;<code>&#39;B&#39;</code>&nbsp;移动到目标位置&nbsp;<code>&#39;T&#39;</code> ：</p>

<ul>
	<li>玩家用字符&nbsp;<code>&#39;S&#39;</code>&nbsp;表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。</li>
	<li>地板用字符&nbsp;<code>&#39;.&#39;</code>&nbsp;表示，意味着可以自由行走。</li>
	<li>墙用字符&nbsp;<code>&#39;#&#39;</code>&nbsp;表示，意味着障碍物，不能通行。&nbsp;</li>
	<li>箱子仅有一个，用字符&nbsp;<code>&#39;B&#39;</code>&nbsp;表示。相应地，网格上有一个目标位置&nbsp;<code>&#39;T&#39;</code>。</li>
	<li>玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。</li>
	<li>玩家无法越过箱子。</li>
</ul>

<p>返回将箱子推到目标位置的最小 <strong>推动</strong> 次数，如果无法做到，请返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/sample_1_1620.png" style="height: 349px; width: 520px;"></strong></p>

<pre><strong>输入：</strong>grid = [[&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
             [&quot;#&quot;,&quot;T&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;B&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;#&quot;,&quot;#&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;S&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;]]
<strong>输出：</strong>3
<strong>解释：</strong>我们只需要返回推箱子的次数。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>grid = [[&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
             [&quot;#&quot;,&quot;T&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;B&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;S&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;]]
<strong>输出：</strong>-1
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>grid = [[&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;T&quot;,&quot;.&quot;,&quot;.&quot;,&quot;#&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;#&quot;,&quot;B&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;S&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;]]
<strong>输出：</strong>5
<strong>解释：</strong>向下、向左、向左、向上再向上。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>grid = [[&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;S&quot;,&quot;#&quot;,&quot;.&quot;,&quot;B&quot;,&quot;T&quot;,&quot;#&quot;],
&nbsp;            [&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;]]
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= grid.length &lt;= 20</code></li>
	<li><code>1 &lt;= grid[i].length &lt;= 20</code></li>
	<li><code>grid</code> 仅包含字符&nbsp;<code>&#39;.&#39;</code>, <code>&#39;#&#39;</code>,&nbsp; <code>&#39;S&#39;</code> , <code>&#39;T&#39;</code>, 以及&nbsp;<code>&#39;B&#39;</code>。</li>
	<li><code>grid</code>&nbsp;中&nbsp;<code>&#39;S&#39;</code>, <code>&#39;B&#39;</code>&nbsp;和&nbsp;<code>&#39;T&#39;</code>&nbsp;各只能出现一个。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minPushBox(self, grid: List[List[str]]) -> int:
        def get_next(x, y, sx, sy):
            nonlocal m, n
            vis = {(sx, sy)}
            q = deque([[sx, sy]])
            while q:
                sx, sy = q.pop()
                for d in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                    nsx, nsy = sx + d[0], sy + d[1]
                    if nsx < 0 or nsx >= m or nsy < 0 or nsy >= n:
                        continue
                    if (nsx, nsy) in vis or grid[nsx][nsy] == "#":
                        continue
                    if nsx == x and nsy == y:
                        continue
                    vis.add((nsx, nsy))
                    q.append([nsx, nsy])

            pos = []
            if x - 1 >= 0 and x + 1 < m and grid[x - 1][y] != '#' and grid[x + 1][y] != '#':
                if (x - 1, y) in vis:
                    pos.append([x + 1, y, x, y])
                if (x + 1, y) in vis:
                    pos.append([x - 1, y, x, y])
            if y - 1 >= 0 and y + 1 < n and grid[x][y - 1] != '#' and grid[x][y + 1] != '#':
                if (x, y - 1) in vis:
                    pos.append([x, y + 1, x, y])
                if (x, y + 1) in vis:
                    pos.append([x, y - 1, x, y])
            return pos

        m, n = len(grid), len(grid[0])
        x = y = tx = ty = sx = sy = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'B':
                    x = i
                    y = j
                if grid[i][j] == 'T':
                    tx = i
                    ty = j
                if grid[i][j] == 'S':
                    sx = i
                    sy = j

        vis = {(x, y, sx, sy)}
        q = deque([[x, y, sx, sy]])
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y, sx, sy = q.popleft()
                if x == tx and y == ty:
                    return ans
                next_pos = get_next(x, y, sx, sy)
                for nx, ny, nsx, nsy in next_pos:
                    if (nx, ny, nsx, nsy) in vis:
                        continue
                    q.append([nx, ny, nsx, nsy])
                    vis.add((nx, ny, nsx, nsy))
            ans += 1
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x = 0, y = 0, tx = 0, ty = 0, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                } else if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    x = i;
                    y = j;
                }
            }
        }
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        vis.add(x + "," + y + "," + sx + "," + sy);
        q.addLast(new int[]{x, y, sx, sy});
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                x = cur[0];
                y = cur[1];
                sx = cur[2];
                sy = cur[3];
                if (x == tx && y == ty) {
                    return ans;
                }
                List<int[]> next = getNext(x, y, sx, sy, grid);
                for (int[] p : next) {
                    int nx = p[0], ny = p[1], nsx = p[2], nsy = p[3];
                    if (!vis.contains(nx + "," + ny + "," + nsx + "," + nsy)) {
                        vis.add(nx + "," + ny + "," + nsx + "," + nsy);
                        q.addLast(new int[]{nx, ny, nsx, nsy});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private List<int[]> getNext(int x, int y, int sx, int sy, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        vis.add(sx + "," + sy);
        q.addLast(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            sx = cur[0];
            sy = cur[1];
            for (int[] dir : dirs) {
                int nsx = sx + dir[0];
                int nsy = sy + dir[1];
                if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#') {
                    continue;
                }
                if (vis.contains(nsx + "," + nsy)) {
                    continue;
                }
                if (nsx == x && nsy == y) {
                    continue;
                }
                vis.add(nsx + "," + nsy);
                q.addLast(new int[]{nsx, nsy});
            }
        }
        List<int[]> ans = new ArrayList<>();
        if (x + 1 < m && x - 1 >= 0 && grid[x + 1][y] != '#' && grid[x - 1][y] != '#') {
            if (vis.contains(x + 1 + "," + y)) {
                ans.add(new int[]{x - 1, y, x, y});
            }
            if (vis.contains(x - 1 + "," + y)) {
                ans.add(new int[]{x + 1, y, x, y});
            }
        }
        if (y + 1 < n && y - 1 >= 0 && grid[x][y + 1] != '#' && grid[x][y - 1] != '#') {
            if (vis.contains(x + "," + (y + 1))) {
                ans.add(new int[]{x, y - 1, x, y});
            }
            if (vis.contains(x + "," + (y - 1))) {
                ans.add(new int[]{x, y + 1, x, y});
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
