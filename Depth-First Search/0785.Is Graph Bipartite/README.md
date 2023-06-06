# [785. 判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite)



## 题目描述

<!-- 这里写题目描述 -->

存在一个 <strong>无向图</strong> ，图中有 <code>n</code> 个节点。其中每个节点都有一个介于 <code>0</code> 到 <code>n - 1</code> 之间的唯一编号。给你一个二维数组 <code>graph</code> ，其中 <code>graph[u]</code> 是一个节点数组，由节点 <code>u</code> 的邻接节点组成。形式上，对于 <code>graph[u]</code> 中的每个 <code>v</code> ，都存在一条位于节点 <code>u</code> 和节点 <code>v</code> 之间的无向边。该无向图同时具有以下属性：
<ul>
	<li>不存在自环（<code>graph[u]</code> 不包含 <code>u</code>）。</li>
	<li>不存在平行边（<code>graph[u]</code> 不包含重复值）。</li>
	<li>如果 <code>v</code> 在 <code>graph[u]</code> 内，那么 <code>u</code> 也应该在 <code>graph[v]</code> 内（该图是无向图）</li>
	<li>这个图可能不是连通图，也就是说两个节点 <code>u</code> 和 <code>v</code> 之间可能不存在一条连通彼此的路径。</li>
</ul>

<p><strong>二分图</strong> 定义：如果能将一个图的节点集合分割成两个独立的子集 <code>A</code> 和 <code>B</code> ，并使图中的每一条边的两个节点一个来自 <code>A</code> 集合，一个来自 <code>B</code> 集合，就将这个图称为 <strong>二分图</strong> 。</p>

<p>如果图是二分图，返回 <code>true</code><em> </em>；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg" style="width: 222px; height: 222px;" />
<pre>
<strong>输入：</strong>graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
<strong>输出：</strong>false
<strong>解释：</strong><code>不能将节点分割成两个独立的子集，</code>以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg" style="width: 222px; height: 222px;" />
<pre>
<strong>输入：</strong>graph = [[1,3],[0,2],[1,3],[0,2]]
<strong>输出：</strong>true
<strong>解释：</strong><code>可以将节点分成两组: {0, 2} 和 {1, 3} 。</code></pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>graph.length == n</code></li>
	<li><code>1 <= n <= 100</code></li>
	<li><code>0 <= graph[u].length < n</code></li>
	<li><code>0 <= graph[u][i] <= n - 1</code></li>
	<li><code>graph[u]</code> 不会包含 <code>u</code></li>
	<li><code>graph[u]</code> 的所有值 <strong>互不相同</strong></li>
	<li>如果 <code>graph[u]</code> 包含 <code>v</code>，那么 <code>graph[v]</code> 也会包含 <code>u</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        def dfs(u):
            nonlocal a, b
            if u in vis:
                return True
            vis.add(u)
            p[u] = p[u] if p[u] else a
            for v in g[u]:
                p[v] = p[v] if p[v] else a + b - p[u]
                if p[u] == p[v] or not dfs(v):
                    return False
            return True

        g = defaultdict(list)
        for u, vs in enumerate(graph):
            for v in vs:
                g[u].append(v)
                g[v].append(u)

        a, b, n = 1, 2, len(graph)
        p = [0] * n
        vis = set()
        for i in range(n):
            if not dfs(i):
                return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int a = 1, b = 2, n;
    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] p;
    boolean[] vis;

    public boolean dfs(int u) {
        if (vis[u]) {
            return true;
        }
        vis[u] = true;
        p[u] = p[u] == 0 ? a : p[u];
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            p[v] = p[v] == 0 ? a + b - p[u] : p[v];
            if (p[u] == p[v] || !dfs(v)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        p = new int[n];
        vis = new boolean[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
