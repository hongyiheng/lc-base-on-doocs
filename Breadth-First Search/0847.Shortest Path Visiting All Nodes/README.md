# [847. 访问所有节点的最短路径](https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出&nbsp;<code>graph</code>&nbsp;为有 N 个节点（编号为&nbsp;<code>0, 1, 2, ..., N-1</code>）的无向连通图。&nbsp;</p>

<p><code>graph.length = N</code>，且只有节点 <code>i</code>&nbsp;和 <code>j</code>&nbsp;连通时，<code>j != i</code>&nbsp;在列表&nbsp;<code>graph[i]</code>&nbsp;中恰好出现一次。</p>

<p>返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[1,2,3],[0],[0],[0]]
<strong>输出：</strong>4
<strong>解释：</strong>一个可能的路径为 [1,0,2,0,3]</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[1],[0,2,4],[1,3,4],[2],[1,2]]
<strong>输出：</strong>4
<strong>解释：</strong>一个可能的路径为 [0,1,4,2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= graph.length &lt;= 12</code></li>
	<li><code>0 &lt;= graph[i].length &lt;&nbsp;graph.length</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        n = len(graph)
        mask = 1 << n
        dis = [[float('inf')] * n for _ in range(mask)]
        q = deque()
        for i in range(n):
            dis[1 << i][i] = 0
            q.append([1 << i, i])
        while q:
            state, idx = q.popleft()
            step = dis[state][idx]
            for i in graph[idx]:
                next_state = 1 << i | state
                if dis[next_state][i] > step + 1:
                    dis[next_state][i] = step + 1
                    q.append([next_state, i])
        ans = float('inf')
        for i in range(n):
            ans = min(ans, dis[mask - 1][i])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        int[][] dis = new int[mask][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dis[1 << i][i] = 0;
            q.offer(new int[]{1 << i, i});
        }
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int state = cur[0], idx = cur[1];
            int step = dis[state][idx];
            for (int i : graph[idx]) {
                int nextState = state | (1 << i);
                if (dis[nextState][i] > step + 1) {
                    dis[nextState][i] = step + 1;
                    q.offer(new int[]{nextState, i});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dis[mask - 1][i]);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
