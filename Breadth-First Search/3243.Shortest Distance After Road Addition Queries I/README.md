# [3243. 新增道路查询后的最短距离 I](https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数 <code>n</code> 和一个二维整数数组 <code>queries</code>。</p>

<p>有 <code>n</code> 个城市，编号从 <code>0</code> 到 <code>n - 1</code>。初始时，每个城市 <code>i</code> 都有一条<strong>单向</strong>道路通往城市 <code>i + 1</code>（ <code>0 &lt;= i &lt; n - 1</code>）。</p>

<p><code>queries[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示新建一条从城市 <code>u<sub>i</sub></code> 到城市 <code>v<sub>i</sub></code> 的<strong>单向</strong>道路。每次查询后，你需要找到从城市 <code>0</code> 到城市 <code>n - 1</code> 的<strong>最短路径</strong>的<strong>长度</strong>。</p>

<p>返回一个数组 <code>answer</code>，对于范围 <code>[0, queries.length - 1]</code> 中的每个 <code>i</code>，<code>answer[i]</code> 是处理完<strong>前</strong> <code>i + 1</code> 个查询后，从城市 <code>0</code> 到城市 <code>n - 1</code> 的最短路径的<em>长度</em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 5, queries = [[2, 4], [0, 2], [0, 4]]</span></p>

<p><strong>输出：</strong> <span class="example-io">[3, 2, 1]</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image8.jpg" style="width: 350px; height: 60px;" /></p>

<p>新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image9.jpg" style="width: 350px; height: 60px;" /></p>

<p>新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image10.jpg" style="width: 350px; height: 96px;" /></p>

<p>新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 4, queries = [[0, 3], [0, 2]]</span></p>

<p><strong>输出：</strong> <span class="example-io">[1, 1]</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image11.jpg" style="width: 300px; height: 70px;" /></p>

<p>新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image12.jpg" style="width: 300px; height: 70px;" /></p>

<p>新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 500</code></li>
	<li><code>1 &lt;= queries.length &lt;= 500</code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 &lt;= queries[i][0] &lt; queries[i][1] &lt; n</code></li>
	<li><code>1 &lt; queries[i][1] - queries[i][0]</code></li>
	<li>查询中没有重复的道路。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        def bfs():
            q = deque([0])
            vis = [False] * n
            vis[0] = True
            d = 0
            while q:
                for _ in range(len(q)):
                    u = q.popleft()
                    if u == n - 1:
                        return d
                    for v in g[u]:
                        if not vis[v]:
                            vis[v] = True
                            q.append(v)
                d += 1
        
        g = [[i + 1] for i in range(n - 1)]
        ans = []
        for u, v in queries:
            g[u].append(v)
            ans.append(bfs())
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int bfs(Map<Integer, List<Integer>> g, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int u = q.pollFirst();
                if (u == n - 1) {
                    return d;
                }
                for (int v : g.get(u)) {
                    if (vis[v]) {
                        continue;
                    }
                    vis[v] = true;
                    q.add(v);
                }
            }
            d++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> vs = new ArrayList<>();
            vs.add(i + 1);
            g.put(i, vs);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            g.get(u).add(v);
            ans[i] = bfs(g, n);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
