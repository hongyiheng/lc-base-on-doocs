# [2192. 有向无环图中一个节点的所有祖先](https://leetcode-cn.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数&nbsp;<code>n</code>&nbsp;，它表示一个 <strong>有向无环图</strong>&nbsp;中节点的数目，节点编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;（包括两者）。</p>

<p>给你一个二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [from<sub>i</sub>, to<sub>i</sub>]</code>&nbsp;表示图中一条从&nbsp;<code>from<sub>i</sub></code>&nbsp;到&nbsp;<code>to<sub>i</sub></code>&nbsp;的单向边。</p>

<p>请你返回一个数组&nbsp;<code>answer</code>，其中<em>&nbsp;</em><code>answer[i]</code>是第&nbsp;<code>i</code>&nbsp;个节点的所有&nbsp;<strong>祖先</strong>&nbsp;，这些祖先节点&nbsp;<strong>升序</strong>&nbsp;排序。</p>

<p>如果 <code>u</code>&nbsp;通过一系列边，能够到达 <code>v</code>&nbsp;，那么我们称节点 <code>u</code>&nbsp;是节点 <code>v</code>&nbsp;的 <strong>祖先</strong>&nbsp;节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/12/12/e1.png" style="width: 322px; height: 265px;"></p>

<pre><b>输入：</b>n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
<b>输出：</b>[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
<strong>解释：</strong>
上图为输入所对应的图。
- 节点 0 ，1 和 2 没有任何祖先。
- 节点 3 有 2 个祖先 0 和 1 。
- 节点 4 有 2 个祖先 0 和 2 。
- 节点 5 有 3 个祖先 0 ，1 和 3 。
- 节点 6 有 5 个祖先 0 ，1 ，2 ，3 和 4 。
- 节点 7 有 4 个祖先 0 ，1 ，2 和 3 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/12/12/e2.png" style="width: 343px; height: 299px;"></p>

<pre><b>输入：</b>n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
<b>输出：</b>[[],[0],[0,1],[0,1,2],[0,1,2,3]]
<strong>解释：</strong>
上图为输入所对应的图。
- 节点 0 没有任何祖先。
- 节点 1 有 1 个祖先 0 。
- 节点 2 有 2 个祖先 0 和 1 。
- 节点 3 有 3 个祖先 0 ，1 和 2 。
- 节点 4 有 4 个祖先 0 ，1 ，2 和 3 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= edges.length &lt;= min(2000, n * (n - 1) / 2)</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= from<sub>i</sub>, to<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>from<sub>i</sub> != to<sub>i</sub></code></li>
	<li>图中不会有重边。</li>
	<li>图是 <strong>有向</strong> 且 <strong>无环</strong> 的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        def bfs(x):
            q = deque([x])
            vis = {x}
            while q:
                u = q.popleft()
                for v in g[u]:
                    if v in vis:
                        continue
                    vis.add(v)
                    q.append(v)
                    ans[v].append(x)

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
        ans = [[] for _ in range(n)]
        for i in range(n):
            bfs(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> g = new HashMap<>();

    public void bfs(int x) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        Set<Integer> vis = new HashSet<>();
        vis.add(x);
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (vis.contains(v)) {
                    continue;
                }
                vis.add(v);
                q.offer(v);
                ans.get(v).add(x);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
