# [802. 找到最终的安全状态](https://leetcode-cn.com/problems/find-eventual-safe-states)



## 题目描述

<!-- 这里写题目描述 -->

<p>在有向图中，从某个节点和每个转向处开始出发，沿着图的有向边走。如果到达的节点是终点（即它没有连出的有向边），则停止。</p>

<p>如果从起始节点出发，最后必然能走到终点，就认为起始节点是 <strong>最终安全</strong> 的。更具体地说，对于最终安全的起始节点而言，存在一个自然数 <code>k</code> ，<strong>无论选择沿哪条有向边行走</strong> ，走了不到 <code>k</code> 步后必能停止在一个终点上。</p>

<p>返回一个由图中所有最终安全的起始节点组成的数组作为答案。答案数组中的元素应当按 <strong>升序</strong> 排列。</p>

<p>该有向图有 <code>n</code> 个节点，按 <code>0</code> 到 <code>n - 1</code> 编号，其中 <code>n</code> 是 <code>graph</code> 的节点数。图以下述形式给出：<code>graph[i]</code> 是编号 <code>j</code> 节点的一个列表，满足 <code>(i, j)</code> 是图的一条有向边。</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>
<img alt="Illustration of graph" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/17/picture1.png" style="height: 171px; width: 600px;" />
<pre>
<strong>输入：</strong>graph = [[1,2],[2,3],[5],[0],[5],[],[]]
<strong>输出：</strong>[2,4,5,6]
<strong>解释：</strong>示意图如上。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
<strong>输出：</strong>[4]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == graph.length</code></li>
	<li><code>1 <= n <= 10<sup>4</sup></code></li>
	<li><code>0 <= graph[i].length <= n</code></li>
	<li><code>graph[i]</code> 按严格递增顺序排列。</li>
	<li>图中可能包含自环。</li>
	<li>图中边的数目在范围 <code>[1, 4 * 10<sup>4</sup>]</code> 内。</li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        cnt = [0] * n
        g = defaultdict(list)
        for u in range(n):
            for v in graph[u]:
                g[v].append(u)
                cnt[u] += 1
        q = deque()
        for i in range(n):
            if cnt[i] == 0:
                q.append(i)
        while q:
            u = q.popleft()
            for v in g[u]:
                cnt[v] -= 1
                if cnt[v] == 0:
                    q.append(v)
        ans = []
        for i in range(n):
            if cnt[i] == 0:
                ans.append(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] cnt = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
                cnt[u]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            for (int v : g.getOrDefault(u, Collections.emptyList())) {
                cnt[v]--;
                if (cnt[v] == 0) {
                    q.addLast(v);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
