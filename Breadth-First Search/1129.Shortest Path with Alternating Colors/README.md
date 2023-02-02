# [1129. 颜色交替的最短路径](https://leetcode-cn.com/problems/shortest-path-with-alternating-colors)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个有向图中，节点分别标记为&nbsp;<code>0, 1, ..., n-1</code>。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。</p>

<p><code>red_edges</code>&nbsp;中的每一个&nbsp;<code>[i, j]</code>&nbsp;对表示从节点 <code>i</code> 到节点 <code>j</code> 的红色有向边。类似地，<code>blue_edges</code>&nbsp;中的每一个&nbsp;<code>[i, j]</code>&nbsp;对表示从节点 <code>i</code> 到节点 <code>j</code> 的蓝色有向边。</p>

<p>返回长度为 <code>n</code> 的数组&nbsp;<code>answer</code>，其中&nbsp;<code>answer[X]</code>&nbsp;是从节点&nbsp;<code>0</code>&nbsp;到节点&nbsp;<code>X</code>&nbsp;的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 <code>answer[x] = -1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
<strong>输出：</strong>[0,1,-1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
<strong>输出：</strong>[0,1,-1]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
<strong>输出：</strong>[0,-1,-1]
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
<strong>输出：</strong>[0,1,2]
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
<strong>输出：</strong>[0,1,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>red_edges.length &lt;= 400</code></li>
	<li><code>blue_edges.length &lt;= 400</code></li>
	<li><code>red_edges[i].length == blue_edges[i].length == 2</code></li>
	<li><code>0 &lt;= red_edges[i][j], blue_edges[i][j] &lt; n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        r, b = defaultdict(list), defaultdict(list)
        for u, v in redEdges:
            r[u].append(v)
        for u, v in blueEdges:
            b[u].append(v)
        dist = [[-1] * 2 for _ in range(n)]
        dist[0] = [0, 0]
        q = deque()
        q.append(0)
        while q:
            u = q.popleft()
            if dist[u][0] != -1:
                for v in r[u]:
                    if dist[v][1] == -1 or dist[v][1] > dist[u][0] + 1:
                        dist[v][1] = dist[u][0] + 1
                        q.append(v)
            if dist[u][1] != -1:
                for v in b[u]:
                    if dist[v][0] == -1 or dist[v][0] > dist[u][1] + 1:
                        dist[v][0] = dist[u][1] + 1
                        q.append(v)
        ans = list()
        for a, b in dist:
            if a != -1 and b != -1:
                ans.append(min(a, b))
            elif a != -1:
                ans.append(a)
            elif b != -1:
                ans.append(b)
            else:
                ans.append(-1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> r = new HashMap<>(), b = new HashMap<>();
        for (int[] e : redEdges) {
            r.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        for (int[] e : blueEdges) {
            b.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        int[][] dist = new int[n][2];
        for (int i = 1; i < n; i++) {
            dist[i][0] = dist[i][1] = -1;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            if (dist[u][0] != -1) {
                for (int v : r.getOrDefault(u, Collections.emptyList())) {
                    if (dist[v][1] == -1 || dist[v][1] > dist[u][0] + 1) {
                        dist[v][1] = dist[u][0] + 1;
                        q.addLast(v);
                    }
                }
            }
            if (dist[u][1] != -1) {
                for (int v : b.getOrDefault(u, Collections.emptyList())) {
                    if (dist[v][0] == -1 || dist[v][0] > dist[u][1] + 1) {
                        dist[v][0] = dist[u][1] + 1;
                        q.addLast(v);
                    }
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1) {
                ans[i] = dist[i][1];
            } else if (dist[i][1] == -1) {
                ans[i] = dist[i][0];
            } else {
                ans[i] = Math.min(dist[i][0], dist[i][1]);
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
