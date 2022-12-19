# [1971. Find if Path Exists in Graph](https://leetcode-cn.com/problems/find-if-path-exists-in-graph)



## 题目描述

<!-- 这里写题目描述 -->

<p>There is a <strong>bi-directional</strong> graph with <code>n</code> vertices, where each vertex is labeled from <code>0</code> to <code>n - 1</code> (<strong>inclusive</strong>). The edges in the graph are represented as a 2D integer array <code>edges</code>, where each <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> denotes a bi-directional edge between vertex <code>u<sub>i</sub></code> and vertex <code>v<sub>i</sub></code>. Every vertex pair is connected by <strong>at most one</strong> edge, and no vertex has an edge to itself.</p>

<p>You want to determine if there is a <strong>valid path</strong> that exists from vertex <code>start</code> to vertex <code>end</code>.</p>

<p>Given <code>edges</code> and the integers <code>n</code>, <code>start</code>, and <code>end</code>, return <code>true</code><em> if there is a <strong>valid path</strong> from </em><code>start</code><em> to </em><code>end</code><em>, or </em><code>false</code><em> otherwise</em><em>.</em></p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/14/validpath-ex1.png" style="width: 141px; height: 121px;" />
<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
<strong>Output:</strong> true
<strong>Explanation:</strong> There are two paths from vertex 0 to vertex 2:
- 0 &rarr; 1 &rarr; 2
- 0 &rarr; 2
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/14/validpath-ex2.png" style="width: 281px; height: 141px;" />
<pre>
<strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no path from vertex 0 to vertex 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>0 &lt;= start, end &lt;= n - 1</code></li>
	<li>There are no duplicate edges.</li>
	<li>There are no self edges.</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        mp = defaultdict(list)
        for u, v in edges:
            mp[u].append(v)
            mp[v].append(u)
        vis = [False] * n
        q = deque([source])
        vis[source] = True
        while q:
            cur = q.popleft()
            if cur == destination:
                return True
            for nxt in mp[cur]:
                if not vis[nxt]:
                    vis[nxt] = True
                    q.append(nxt)
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] e : edges) {
            mp.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            mp.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(source);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            if (u == destination) {
                return true;
            }
            if (vis.contains(u)) {
                continue;
            }
            vis.add(u);
            for (int v : mp.getOrDefault(u, new ArrayList<>())) {
                q.add(v);
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
