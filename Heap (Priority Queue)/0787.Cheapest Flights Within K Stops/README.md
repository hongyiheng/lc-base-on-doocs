# [787. K 站中转内最便宜的航班](https://leetcode-cn.com/problems/cheapest-flights-within-k-stops)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>n</code> 个城市通过 <code>m</code> 个航班连接。每个航班都从城市 <code>u</code> 开始，以价格 <code>w</code> 抵达 <code>v</code>。</p>

<p>现在给定所有的城市和航班，以及出发城市 <code>src</code> 和目的地 <code>dst</code>，你的任务是找到从 <code>src</code> 到 <code>dst</code> 最多经过 <code>k</code> 站中转的最便宜的价格。 如果没有这样的路线，则输出 <code>-1</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
<strong>输出:</strong> 200
<strong>解释:</strong> 
城市航班图如下
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/16/995.png" style="height: 180px; width: 246px;" />

从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
<strong>输出:</strong> 500
<strong>解释:</strong> 
城市航班图如下
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/16/995.png" style="height: 180px; width: 246px;" />

从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n</code> 范围是 <code>[1, 100]</code>，城市标签从 <code>0</code> 到 <code>n</code><code> - 1</code></li>
	<li>航班数量范围是 <code>[0, n * (n - 1) / 2]</code></li>
	<li>每个航班的格式 <code>(src, </code><code>dst</code><code>, price)</code></li>
	<li>每个航班的价格范围是 <code>[1, 10000]</code></li>
	<li><code>k</code> 范围是 <code>[0, n - 1]</code></li>
	<li>航班没有重复，且不存在自环</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
from sortedcontainers import SortedList

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        edges = [Edge(0, 0, 0)] * (n * n)
        head = [0] * n
        idx = 1

        def add_edge(a, b, w):
            nonlocal edges, head, idx
            edges[idx] = Edge(b, head[a], w)
            head[a] = idx
            idx += 1
        
        for e in flights:
            add_edge(e[0], e[1], e[2])
        dist = [float('inf')] * n
        ans = float('inf')
        q = SortedList(key=lambda x: x[1])
        q.add([src, 0])
        while k >= 0 and q:
            tmp = list()
            while q:
                p, w = q.pop()
                j = head[p]
                while j != 0:
                    if dist[edges[j].to] > w + edges[j].w:
                        dist[edges[j].to] = w + edges[j].w
                        tmp.append([edges[j].to, w + edges[j].w])
                    j = edges[j].next
            for v in tmp:
                q.add([v[0], v[1]])
            k -= 1
        return dist[dst] if dist[dst] != float('inf') else -1

class Edge:
    to = 0
    next = 0
    w = 0

    def __init__(self):
        return
        
    def __init__(self, to, next, w):
        self.to = to
        self.next = next
        self.w = w
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Edge[] edge;
    int[] head;
    int idx = 1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        edge = new Edge[n * n];
        head = new int[n];
        for (int[] e : flights) {
            addEdge(e[0], e[1], e[2]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{src, 0});
        while (k >= 0 && !q.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();
            k--;
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int[] cur = q.poll();
                for (int j = head[cur[0]]; j != 0; j = edge[j].next) {
                    if (dist[edge[j].to] <= edge[j].w + cur[1]) {
                        continue;
                    }
                    dist[edge[j].to] = edge[j].w + cur[1];
                    tmp.add(new int[]{edge[j].to, edge[j].w + cur[1]});
                }
            }
            for (int[] item : tmp) {
                q.add(item);
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public void addEdge(int a, int b, int w) {
        edge[idx] = new Edge(b, head[a], w);
        head[a] = idx++;
    }

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
}
```

### **...**

```

```

<!-- tabs:end -->
