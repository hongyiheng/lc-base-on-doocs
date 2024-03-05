# [1976. 到达目的地的方案数](https://leetcode-cn.com/problems/number-of-ways-to-arrive-at-destination)



## 题目描述

<!-- 这里写题目描述 -->

<p>你在一个城市里，城市由 <code>n</code>&nbsp;个路口组成，路口编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;，某些路口之间有 <strong>双向</strong>&nbsp;道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。</p>

<p>给你一个整数&nbsp;<code>n</code>&nbsp;和二维整数数组&nbsp;<code>roads</code>&nbsp;，其中&nbsp;<code>roads[i] = [u<sub>i</sub>, v<sub>i</sub>, time<sub>i</sub>]</code>&nbsp;表示在路口&nbsp;<code>u<sub>i</sub></code>&nbsp;和&nbsp;<code>v<sub>i</sub></code>&nbsp;之间有一条需要花费&nbsp;<code>time<sub>i</sub></code>&nbsp;时间才能通过的道路。你想知道花费 <strong>最少时间</strong>&nbsp;从路口&nbsp;<code>0</code>&nbsp;出发到达路口&nbsp;<code>n - 1</code>&nbsp;的方案数。</p>

<p>请返回花费 <strong>最少时间</strong>&nbsp;到达目的地的 <strong>路径数目</strong>&nbsp;。由于答案可能很大，将结果对&nbsp;<code>10<sup>9</sup> + 7</code>&nbsp;<strong>取余</strong>&nbsp;后返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/17/graph2.png" style="width: 235px; height: 381px;">
<pre><b>输入：</b>n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
<b>输出：</b>4
<b>解释：</b>从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
四条花费 7 分钟的路径分别为：
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>n = 2, roads = [[1,0,10]]
<b>输出：</b>1
<b>解释：</b>只有一条从路口 0 到路口 1 的路，花费 10 分钟。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>n - 1 &lt;= roads.length &lt;= n * (n - 1) / 2</code></li>
	<li><code>roads[i].length == 3</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>1 &lt;= time<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>u<sub>i </sub>!= v<sub>i</sub></code></li>
	<li>任意两个路口之间至多有一条路。</li>
	<li>从任意路口出发，你能够到达其他任意路口。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        MOD = int(1e9) + 7
        g = [[inf] * n for _ in range(n)]
        for u, v, w in roads:
            g[u][v] = g[v][u] = w
        dist = [inf] * n
        dist[0] = 0
        f = [0] * n
        f[0] = 1
        q = [(0, 0)]
        while q:
            w, u = heapq.heappop(q)
            if u == n - 1:
                return f[-1]
            if w > dist[u]:
                continue
            for v, d in enumerate(g[u]):
                nw = w + d
                if nw < dist[v]:
                    dist[v] = nw
                    f[v] = f[u]
                    heapq.heappush(q, (nw, v))
                elif nw == dist[v]:
                    f[v] = (f[u] + f[v]) % MOD
        return f[-1]

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9 + 7;
        long INF = Long.MAX_VALUE / 2;
        long[][] g = new long[n][n];
        for (long[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] e : roads) {
            int u = e[0], v = e[1], w = e[2];
            g[u][v] = w;
            g[v][u] = w;
        }
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        long[] f = new long[n];
        f[0] = 1;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0] > 0 ? 1 : -1);
        q.add(new long[]{0, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long w = cur[0];
            int u = (int)cur[1];
            if (u == n - 1) {
                return (int)f[n - 1];
            }
            if (dist[u] < w) {
                continue;
            }
            for (int v = 0; v < n; v++) {
                long nw = g[u][v] + w;
                if (nw < dist[v]) {
                    dist[v] = nw;
                    f[v] = f[u];
                    q.add(new long[]{nw, v});
                } else if (nw == dist[v]) {
                    f[v] = (f[u] + f[v]) % MOD;
                }
            }
        }
        return (int)f[n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
