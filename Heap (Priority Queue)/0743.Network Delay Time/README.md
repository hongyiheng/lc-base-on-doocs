# [743. 网络延迟时间](https://leetcode-cn.com/problems/network-delay-time)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>n</code> 个网络节点，标记为 <code>1</code> 到 <code>n</code>。</p>

<p>给你一个列表 <code>times</code>，表示信号经过 <strong>有向</strong> 边的传递时间。 <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>，其中 <code>u<sub>i</sub></code> 是源节点，<code>v<sub>i</sub></code> 是目标节点， <code>w<sub>i</sub></code> 是一个信号从源节点传递到目标节点的时间。</p>

<p>现在，从某个节点 <code>K</code> 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="height: 220px; width: 200px;" /></p>

<pre>
<strong>输入：</strong>times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 2
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= k <= n <= 100</code></li>
	<li><code>1 <= times.length <= 6000</code></li>
	<li><code>times[i].length == 3</code></li>
	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>0 <= w<sub>i</sub> <= 100</code></li>
	<li>所有 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 对都 <strong>互不相同</strong>（即，不含重复边）</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        g = [[inf] * (n + 1) for _ in range(n + 1)]
        for u, v, w in times:
            g[u][v] = w
        dist = [inf] * (n + 1)
        dist[k] = 0
        q = [[0, k]]
        while q:
            w, u = heapq.heappop(q)
            for v in range(len(g[u])):
                if g[u][v] == inf:
                    continue
                if w + g[u][v] >= dist[v]:
                    continue
                dist[v] = w + g[u][v]
                heapq.heappush(q, [dist[v], v])
        ans = max(dist[1:])
        return -1 if ans == inf else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    final int inf = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        for (int[] f : g) {
            Arrays.fill(f, inf);
        }
        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            g[u][v] = w;
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, inf);
        dist[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], w = cur[1];
            for (int v = 1; v < n + 1; v++) {
                if (g[u][v] >= inf) {
                    continue;
                }
                if (g[u][v] + w >= dist[v]) {
                    continue;
                }
                dist[v] = g[u][v] + w;
                q.add(new int[]{v, dist[v]});
            }
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans >= inf ? -1 : ans; 
    }
}
```

### **...**

```

```

<!-- tabs:end -->
