# [1184. 公交站间的距离](https://leetcode-cn.com/problems/distance-between-bus-stops)



## 题目描述

<!-- 这里写题目描述 -->

<p>环形公交路线上有&nbsp;<code>n</code>&nbsp;个站，按次序从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;进行编号。我们已知每一对相邻公交站之间的距离，<code>distance[i]</code>&nbsp;表示编号为&nbsp;<code>i</code>&nbsp;的车站和编号为&nbsp;<code>(i + 1) % n</code>&nbsp;的车站之间的距离。</p>

<p>环线上的公交车都可以按顺时针和逆时针的方向行驶。</p>

<p>返回乘客从出发点&nbsp;<code>start</code>&nbsp;到目的地&nbsp;<code>destination</code>&nbsp;之间的最短距离。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1.jpg" style="height: 240px; width: 388px;"></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 1
<strong>输出：</strong>1
<strong>解释：</strong>公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。</pre>

<p>&nbsp;</p>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1-1.jpg" style="height: 240px; width: 388px;"></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 2
<strong>输出：</strong>3
<strong>解释：</strong>公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
</pre>

<p>&nbsp;</p>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1-2.jpg" style="height: 240px; width: 388px;"></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 3
<strong>输出：</strong>4
<strong>解释：</strong>公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n&nbsp;&lt;= 10^4</code></li>
	<li><code>distance.length == n</code></li>
	<li><code>0 &lt;= start, destination &lt; n</code></li>
	<li><code>0 &lt;= distance[i] &lt;= 10^4</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Edge:
    def __init__(self, to, next, w):
        self.to = to
        self.next = next
        self.w = w

class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        n = len(distance)
        edges = [None] * (n * 2 + 1)
        head = [0] * n 
        idx = 1

        def add_edge(a, b, w):
            nonlocal idx, edges, head
            edges[idx] = Edge(b, head[a], w)
            head[a] = idx
            idx += 1
        
        for i, w in enumerate(distance):
            add_edge(i, (i + 1) % n, w)
            add_edge((i + 1) % n, i, w)
        q = [[0, start]]
        dist = [float('inf')] * n
        dist[start] = 0
        while q:
            cur = heapq.heappop(q)[1]
            i = head[cur]
            while i:
                e = edges[i].to
                if dist[e] > dist[cur] + edges[i].w:
                    dist[e] = dist[cur] + edges[i].w
                    heapq.heappush(q, [dist[e], e])
                i = edges[i].next
        return dist[destination]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Edge {
    int to;
    int next;
    int w;

    public Edge(int to, int next, int w) {
        this.to = to;
        this.next = next;
        this.w = w;
    }
}

class Solution {
    Edge[] edges;
    int[] head;
    int idx;

    public void addEdge(int a, int b, int w) {
        edges[idx] = new Edge(b, head[a], w);
        head[a] = idx++;
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        edges = new Edge[n * 2 + 1];
        head = new int[n + 1];
        idx = 1;
        for (int i = 0; i < n; i++) {
            addEdge(i, (i + 1) % n, distance[i]);
            addEdge((i + 1) % n, i, distance[i]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[start] = 0;
        q.add(new int[]{0, start});
        while (!q.isEmpty()) {
            int cur = q.poll()[1];
            for (int i = head[cur]; i != 0; i = edges[i].next) {
                int to = edges[i].to;
                if (dist[to] > dist[cur] + edges[i].w) {
                    dist[to] = dist[cur] + edges[i].w;
                    q.add(new int[] {dist[to], to});
                }
            }
        }
        return dist[destination];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
