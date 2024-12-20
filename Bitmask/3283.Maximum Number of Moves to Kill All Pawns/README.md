# [3283. 吃掉所有兵需要的最多移动次数](https://leetcode.cn/problems/maximum-number-of-moves-to-kill-all-pawns)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>50 x 50</code>&nbsp;的国际象棋棋盘，棋盘上有 <strong>一个</strong>&nbsp;马和一些兵。给你两个整数&nbsp;<code>kx</code> 和&nbsp;<code>ky</code>&nbsp;，其中&nbsp;<code>(kx, ky)</code>&nbsp;表示马所在的位置，同时还有一个二维数组&nbsp;<code>positions</code>&nbsp;，其中&nbsp;<code>positions[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>&nbsp;表示第 <code>i</code>&nbsp;个兵在棋盘上的位置。</p>

<p>Alice 和 Bob 玩一个回合制游戏，Alice 先手。玩家的一次操作中，可以执行以下操作：</p>

<ul>
	<li>玩家选择一个仍然在棋盘上的兵，然后移动马，通过 <strong>最少</strong>&nbsp;的 <strong>步数</strong> 吃掉这个兵。<strong>注意</strong>&nbsp;，玩家可以选择&nbsp;<strong>任意</strong>&nbsp;一个兵，<strong>不一定</strong>&nbsp;要选择从马的位置出发&nbsp;<strong>最少</strong>&nbsp;移动步数的兵。</li>
	<li><span>在马吃兵的过程中，马 <strong>可能</strong>&nbsp;会经过一些其他兵的位置，但这些兵 <strong>不会</strong>&nbsp;被吃掉。<strong>只有</strong>&nbsp;选中的兵在这个回合中被吃掉。</span></li>
</ul>

<p>Alice 的目标是 <strong>最大化</strong>&nbsp;两名玩家的 <strong>总</strong>&nbsp;移动次数，直到棋盘上不再存在兵，而 Bob 的目标是 <strong>最小化</strong>&nbsp;总移动次数。</p>

<p>假设两名玩家都采用 <strong>最优</strong>&nbsp;策略，请你返回可以达到的 <strong>最大</strong>&nbsp;总移动次数。</p>

<p>在一次&nbsp;<strong>移动</strong>&nbsp;中，如下图所示，马有 8 个可以移动到的位置，每个移动位置都是沿着坐标轴的一个方向前进 2 格，然后沿着垂直的方向前进 1 格。</p>

<p><img src="https://assets.leetcode.com/uploads/2024/08/01/chess_knight.jpg" style="width: 275px; height: 273px;" /></p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>kx = 1, ky = 1, positions = [[0,0]]</span></p>

<p><span class="example-io"><b>输出：</b>4</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/16/gif3.gif" style="width: 275px; height: 275px;" /></p>

<p>马需要移动 4 步吃掉&nbsp;<code>(0, 0)</code>&nbsp;处的兵。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>kx = 0, ky = 2, positions = [[1,1],[2,2],[3,3]]</span></p>

<p><span class="example-io"><b>输出：</b>8</span></p>

<p><strong>解释：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/08/16/gif4.gif" style="width: 320px; height: 320px;" /></strong></p>

<ul>
	<li>Alice 选择&nbsp;<code>(2, 2)</code>&nbsp;处的兵，移动马吃掉它需要 2 步：<code>(0, 2) -&gt; (1, 4) -&gt; (2, 2)</code>&nbsp;。</li>
	<li>Bob 选择&nbsp;<code>(3, 3)</code>&nbsp;处的兵，移动马吃掉它需要 2 步：<code>(2, 2) -&gt; (4, 1) -&gt; (3, 3)</code>&nbsp;。</li>
	<li>Alice 选择&nbsp;<code>(1, 1)</code>&nbsp;处的兵，移动马吃掉它需要 4 步：<code>(3, 3) -&gt; (4, 1) -&gt; (2, 2) -&gt; (0, 3) -&gt; (1, 1)</code>&nbsp;。</li>
</ul>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>kx = 0, ky = 0, positions = [[1,2],[2,4]]</span></p>

<p><span class="example-io"><b>输出：</b>3</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>Alice 选择&nbsp;<code>(2, 4)</code>&nbsp;处的兵，移动马吃掉它需要 2 步：<code>(0, 0) -&gt; (1, 2) -&gt; (2, 4)</code>&nbsp;。注意，<code>(1, 2)</code>&nbsp;处的兵不会被吃掉。</li>
	<li>Bob 选择&nbsp;<code>(1, 2)</code>&nbsp;处的兵，移动马吃掉它需要 1 步：<code>(2, 4) -&gt; (1, 2)</code>&nbsp;。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= kx, ky &lt;= 49</code></li>
	<li><code>1 &lt;= positions.length &lt;= 15</code></li>
	<li><code>positions[i].length == 2</code></li>
	<li><code>0 &lt;= positions[i][0], positions[i][1] &lt;= 49</code></li>
	<li><code>positions[i]</code>&nbsp;两两互不相同。</li>
	<li>输入保证对于所有&nbsp;<code>0 &lt;= i &lt; positions.length</code>&nbsp;，都有&nbsp;<code>positions[i] != [kx, ky]</code>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxMoves(self, kx: int, ky: int, positions: List[List[int]]) -> int:
        @cache
        def dfs(x, y, mask):
            nonlocal n
            if mask == (1 << n) - 1:
                return 0
            ans = 0
            if mask.bit_count() % 2 == 1:
                for i, pos in enumerate(positions):
                    if not mask >> i & 1:
                        ans = max(ans, dfs(pos[0], pos[1], mask | 1 << i) + dis[i][x][y])
            else:
                ans = inf
                for i, pos in enumerate(positions):
                    if not mask >> i & 1:
                        ans = min(ans, dfs(pos[0], pos[1], mask | 1 << i) + dis[i][x][y])
            return ans

        positions = [[kx, ky]] + positions
        n = len(positions)
        dis = [[[-1] * 50 for _ in range(50)] for _ in range(n)]
        for i, pos in enumerate(positions):
            q = deque([pos])
            step = 0
            while q:
                step += 1
                for _ in range(len(q)):
                    x, y = q.popleft()
                    for d in [[1, 2], [1, -2], [2, 1], [2, -1], [-2, -1], [-2, 1], [-1, 2], [-1, -2]]:
                        nx, ny = x + d[0], y + d[1]
                        if nx < 0 or nx >= 50 or ny < 0 or ny >= 50:
                            continue
                        if dis[i][nx][ny] != -1:
                            continue
                        dis[i][nx][ny] = step
                        q.append([nx, ny])
        return dfs(kx, ky, 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, Integer> f = new HashMap<>();

    public int dfs(int x, int y, int mask, int n, List<int[]> poss, int[][][] dis) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        String key = x + "_" + y + "_" + mask;
        if (f.get(key) != null) {
            return f.get(key);
        }
        int ans = 0;
        if (Integer.bitCount(mask) % 2 == 1) {
            for (int i = 1; i < n; i++) {
                if ((mask >> i & 1) == 0) {
                    ans = Math.max(ans, dfs(poss.get(i)[0], poss.get(i)[1], mask | (1 << i), n, poss, dis) + dis[i][x][y]);
                }
            }
        } else {
            ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if ((mask >> i & 1) == 0) {
                    ans = Math.min(ans, dfs(poss.get(i)[0], poss.get(i)[1], mask | (1 << i), n, poss, dis) + dis[i][x][y]);
                }
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int maxMoves(int kx, int ky, int[][] positions) {
        List<int[]> poss = Arrays.stream(positions).collect(Collectors.toList());
        poss.add(0, new int[]{kx, ky});
        int n = poss.size();
        int[][][] dis = new int[n][50][50];
        for (int i = 0; i < n; i++) {
            int[][] d = dis[i];
            for (int[] r : d) {
                Arrays.fill(r, -1);
            }
            Deque<int[]> q = new ArrayDeque<>();
            q.add(poss.get(i));
            int step = 0;
            while (!q.isEmpty()) {
                step++;
                int m = q.size();
                for (int j = 0; j < m; j++) {
                    int[] pos = q.pollFirst();
                    int x = pos[0], y = pos[1];
                    for (int[] dir : new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}}) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || nx >= 50 || ny < 0 || ny >= 50) {
                            continue;
                        }
                        if (d[nx][ny] != -1) {
                            continue;
                        }
                        d[nx][ny] = step;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return dfs(kx, ky, 1, n, poss, dis);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
