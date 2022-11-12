# [1197. 进击的骑士](https://leetcode-cn.com/problems/minimum-knight-moves)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个坐标可以从 <code>-infinity</code>&nbsp;延伸到&nbsp;<code>+infinity</code>&nbsp;的 <strong>无限大的</strong>&nbsp;棋盘上，你的 <strong>骑士&nbsp;</strong>驻扎在坐标为&nbsp;<code>[0, 0]</code>&nbsp;的方格里。</p>

<p>骑士的走法和中国象棋中的马相似，走 &ldquo;日&rdquo; 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格。</p>

<p>每次移动，他都可以按图示八个方向之一前进。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/21/knight.png" style="height: 200px; width: 200px;"></p>

<p>现在，骑士需要前去征服坐标为&nbsp;<code>[x, y]</code>&nbsp;的部落，请你为他规划路线。</p>

<p>最后返回所需的最小移动次数即可。本题确保答案是一定存在的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>x = 2, y = 1
<strong>输出：</strong>1
<strong>解释：</strong>[0, 0] &rarr; [2, 1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>x = 5, y = 5
<strong>输出：</strong>4
<strong>解释：</strong>[0, 0] &rarr; [2, 1] &rarr; [4, 2] &rarr; [3, 4] &rarr; [5, 5]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>|x| + |y| &lt;= 300</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minKnightMoves(self, i: int, j: int) -> int:
        M = 300
        dirs = [[2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]
        q = deque()
        q.append([0, 0])
        vis = set()
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y = q.popleft()
                if x == abs(i) and y == abs(j):
                    return ans
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < -2 or nx > M or ny < -2 or ny > M:
                        continue
                    if (nx, ny) in vis:
                        continue
                    vis.add((nx, ny))
                    q.append([nx, ny])
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minKnightMoves(int i, int j) {
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        i = Math.abs(i);
        j = Math.abs(j);
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        int ans = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (x == i && y == j) {
                    return ans;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < -2 || nx > 300 || ny < -2 || ny > 300) {
                        continue;
                    }
                    if (!vis.contains(nx + "," + ny)) {
                        vis.add(nx + "," + ny);
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
