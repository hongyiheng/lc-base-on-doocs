# [2101. 引爆最多的炸弹](https://leetcode-cn.com/problems/detonate-the-maximum-bombs)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个炸弹列表。一个炸弹的 <strong>爆炸范围</strong>&nbsp;定义为以炸弹为圆心的一个圆。</p>

<p>炸弹用一个下标从 <strong>0</strong>&nbsp;开始的二维整数数组&nbsp;<code>bombs</code>&nbsp;表示，其中&nbsp;<code>bombs[i] = [x<sub>i</sub>, y<sub>i</sub>, r<sub>i</sub>]</code>&nbsp;。<code>x<sub>i</sub></code> 和&nbsp;<code>y<sub>i</sub></code>&nbsp;表示第 <code>i</code>&nbsp;个炸弹的 X 和 Y 坐标，<code>r<sub>i</sub></code>&nbsp;表示爆炸范围的 <strong>半径</strong>&nbsp;。</p>

<p>你需要选择引爆 <strong>一个&nbsp;</strong>炸弹。当这个炸弹被引爆时，<strong>所有</strong> 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。</p>

<p>给你数组&nbsp;<code>bombs</code>&nbsp;，请你返回在引爆&nbsp;<strong>一个</strong>&nbsp;炸弹的前提下，<strong>最多</strong>&nbsp;能引爆的炸弹数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/11/06/desmos-eg-3.png" style="width: 300px; height: 300px;"></p>

<pre><b>输入：</b>bombs = [[2,1,3],[6,1,4]]
<b>输出：</b>2
<strong>解释：</strong>
上图展示了 2 个炸弹的位置和爆炸范围。
如果我们引爆左边的炸弹，右边的炸弹不会被影响。
但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/11/06/desmos-eg-2.png" style="width: 300px; height: 300px;"></p>

<pre><b>输入：</b>bombs = [[1,1,5],[10,10,5]]
<b>输出：</b>1
<strong>解释：
</strong>引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/11/07/desmos-eg1.png" style="width: 300px; height: 300px;"></p>

<pre><b>输入：</b>bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
<b>输出：</b>5
<strong>解释：</strong>
最佳引爆炸弹为炸弹 0 ，因为：
- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
所以总共有 5 个炸弹被引爆。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= bombs.length&nbsp;&lt;= 100</code></li>
	<li><code>bombs[i].length == 3</code></li>
	<li><code>1 &lt;= x<sub>i</sub>, y<sub>i</sub>, r<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        def dfs(u, r):
            nonlocal n
            ans = 1
            for v in range(n):
                if v in vis or r * r < g[u][v]:
                    continue
                vis.add(v)
                ans += dfs(v, bombs[v][2])
            return ans
            
        n = len(bombs)
        g = [[inf] * n for _ in range(n)]
        for i in range(n):
            for j in range(i + 1, n):
                x = bombs[i][0] - bombs[j][0]
                y = bombs[i][1] - bombs[j][1]
                g[i][j] = g[j][i] = x * x + y * y
        ans = 0
        for i in range(n):
            vis = {i}
            ans = max(ans, dfs(i, bombs[i][2]))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int n;
    long[][] g;
    int[][] bombs;

    public int dfs(int u, int r, Set<Integer> vis) {
        int ans = 1;
        for (int v = 0; v < n; v++) {
            if (g[u][v] > (long)r * r || vis.contains(v)) {
                continue;
            }
            vis.add(v);
            ans += dfs(v, bombs[v][2], vis);
        }
        return ans;
    }


    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        g = new long[n][n];
        this.bombs = bombs;
        for (long[] row : g) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = bombs[i][0] - bombs[j][0];
                int y = bombs[i][1] - bombs[j][1];
                g[i][j] = g[j][i] = (long)x * x + (long)y * y;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, bombs[i][2], new HashSet<>(Arrays.asList(i))));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
