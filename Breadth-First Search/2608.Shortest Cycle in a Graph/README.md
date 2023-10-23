# [2608. 图中的最短环](https://leetcode-cn.com/problems/shortest-cycle-in-a-graph)



## 题目描述

<!-- 这里写题目描述 -->

<p>现有一个含 <code>n</code> 个顶点的 <strong>双向</strong> 图，每个顶点按从 <code>0</code> 到 <code>n - 1</code> 标记。图中的边由二维整数数组 <code>edges</code> 表示，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示顶点 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code> 之间存在一条边。每对顶点最多通过一条边连接，并且不存在与自身相连的顶点。</p>

<p>返回图中 <strong>最短</strong> 环的长度。如果不存在环，则返回 <code>-1</code> 。</p>

<p><strong>环</strong> 是指以同一节点开始和结束，并且路径中的每条边仅使用一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/01/04/cropped.png" style="width: 387px; height: 331px;">
<pre><strong>输入：</strong>n = 7, edges = [[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]
<strong>输出：</strong>3
<strong>解释：</strong>长度最小的循环是：0 -&gt; 1 -&gt; 2 -&gt; 0 
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/01/04/croppedagin.png" style="width: 307px; height: 307px;">
<pre><strong>输入：</strong>n = 4, edges = [[0,1],[0,2]]
<strong>输出：</strong>-1
<strong>解释：</strong>图中不存在循环
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= edges.length &lt;= 1000</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt; n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li>不存在重复的边</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = n + 1
        for i in range(n):
            dis = [-1] * n
            dis[i] = 0
            q = deque([(i, -1)])
            while q:
                u, p = q.popleft()
                for v in g[u]:
                    if dis[v] < 0:
                        dis[v] = dis[u] + 1
                        q.append((v, u))
                    elif v != p:
                        ans = min(ans, dis[u] + dis[v] + 1)
        return ans if ans <= n else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            dis[i] = 0;
            Deque<int[]> q = new ArrayDeque<>();
            q.addLast(new int[]{i, -1});
            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();
                int u = cur[0], p = cur[1];
                for (int v : g.getOrDefault(u, new ArrayList<>())) {
                    if (dis[v] < 0) {
                        dis[v] = dis[u] + 1;
                        q.addLast(new int[]{v, u});
                    } else if (v != p) {
                        ans = Math.min(ans, dis[u] + dis[v] + 1);
                    }
                }
            }
        }
        return ans > n ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
