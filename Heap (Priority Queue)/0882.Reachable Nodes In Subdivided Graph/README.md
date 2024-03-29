# [882. 细分图中的可到达结点](https://leetcode-cn.com/problems/reachable-nodes-in-subdivided-graph)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个无向图（<strong>原始图</strong>），图中有 <code>n</code> 个节点，编号从 <code>0</code> 到 <code>n - 1</code> 。你决定将图中的每条边细分为一条节点链，每条边之间的新节点数各不相同。</p>

<p>图用由边组成的二维数组 <code>edges</code> 表示，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>, cnt<sub>i</sub>]</code> 表示原始图中节点 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code> 之间存在一条边，<code>cnt<sub>i</sub></code> 是将边细分后的新节点总数。注意，<code>cnt<sub>i</sub> == 0</code> 表示边不可细分。</p>

<p>要细分边 <code>[ui, vi]</code> ，需要将其替换为 <code>(cnt<sub>i</sub> + 1)</code> 条新边，和 <code>cnt<sub>i</sub></code> 个新节点。新节点为 <code>x<sub>1</sub></code>, <code>x<sub>2</sub></code>, ..., <code>x<sub>cnt<sub>i</sub></sub></code> ，新边为 <code>[u<sub>i</sub>, x<sub>1</sub>]</code>, <code>[x<sub>1</sub>, x<sub>2</sub>]</code>, <code>[x<sub>2</sub>, x<sub>3</sub>]</code>, ..., <code>[x<sub>cnt<sub>i</sub>+1</sub>, x<sub>cnt<sub>i</sub></sub>]</code>, <code>[x<sub>cnt<sub>i</sub></sub>, v<sub>i</sub>]</code> 。</p>

<p class="MachineTrans-lang-zh-CN">现在得到一个新的 <strong>细分图</strong> ，请你计算从节点 <code>0</code> 出发，可以到达多少个节点？节点 <strong>是否可以到达的判断条件</strong> 为：如果节点间距离是 <code>maxMoves</code> 或更少，则视为可以到达；否则，不可到达。</p>

<p class="MachineTrans-lang-zh-CN">给你原始图和 <code>maxMoves</code> ，返回新的细分图中从节点 <code>0</code> 出发<strong> 可到达的节点数 </strong>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/01/origfinal.png" style="width: 600px; height: 247px;" />
<pre>
<strong>输入：</strong>edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
<strong>输出：</strong>13
<strong>解释：</strong>边的细分情况如上图所示。
可以到达的节点已经用黄色标注出来。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
<strong>输出：</strong>23
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
<strong>输出：</strong>1
<strong>解释：</strong>节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= edges.length <= min(n * (n - 1) / 2, 10<sup>4</sup>)</code></li>
	<li><code>edges[i].length == 3</code></li>
	<li><code>0 <= u<sub>i</sub> < v<sub>i</sub> < n</code></li>
	<li>图中 <strong>不存在平行边</strong></li>
	<li><code>0 <= cnt<sub>i</sub> <= 10<sup>4</sup></code></li>
	<li><code>0 <= maxMoves <= 10<sup>9</sup></code></li>
	<li><code>1 <= n <= 3000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def reachableNodes(self, edges: List[List[int]], maxMoves: int, n: int) -> int:
        def dijkstra():
            dist[0] = 0
            q = [[0, 0]]
            while q:
                u = heapq.heappop(q)[1]
                for v, w in mp[u]:
                    if dist[v] > (t := dist[u] + w):
                        dist[v] = t
                        heapq.heappush(q, [t, v])

        dist = [0x3f3f3f3f] * n
        mp = defaultdict(list)
        for u, v, w in edges:
            mp[u].append((v, w + 1))
            mp[v].append((u, w + 1))
        dijkstra()
        ans = sum(v <= maxMoves for v in dist)
        for e in edges:
            l, r = max(maxMoves - dist[e[0]], 0), max(maxMoves - dist[e[1]], 0)
            ans += min(e[2], l + r)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Map<Integer, List<int[]>> mp;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        mp = new HashMap<>();
         for (int[] e : edges) {
            mp.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new int[]{e[1], e[2] + 1});
            mp.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new int[]{e[0], e[2] + 1});
        }
        int[] dist = dijkstra(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                ans++;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int l = Math.max(maxMoves - dist[u], 0), r = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(w, l + r);
        }
        return ans;
    }

    public int[] dijkstra(int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int u = q.poll()[1];
            for (int[] e : mp.getOrDefault(u, new ArrayList<>())) {
                int v = e[0], w = e[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
