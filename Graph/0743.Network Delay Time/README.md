# [743. 网络延迟时间](https://leetcode-cn.com/problems/network-delay-time)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>n</code> 个网络节点，标记为 <code>1</code> 到 <code>n</code>。</p>

<p>给你一个列表 <code>times</code>，表示信号经过 <strong>有向</strong> 边的传递时间。 <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>，其中 <code>u<sub>i</sub></code> 是源节点，<code>v<sub>i</sub></code> 是目标节点， <code>w<sub>i</sub></code> 是一个信号从源节点传递到目标节点的时间。</p>

<p>现在，从某个节点 <code>K</code> 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="height: 220px; width: 200px;" /></p>

<pre>
<strong>输入：</strong>times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 2
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= k <= n <= 100</code></li>
	<li><code>1 <= times.length <= 6000</code></li>
	<li><code>times[i].length == 3</code></li>
	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>0 <= w<sub>i</sub> <= 100</code></li>
	<li>所有 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 对都 <strong>互不相同</strong>（即，不含重复边）</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        edge = [[float('inf')] * (n + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            edge[i][i] = 0
        for t in times:
            edge[t[0]][t[1]] = t[2]
        dist = [float('inf')] * (n + 1)

        def dijkstra():
            vis = [False] * (n + 1)
            dist[k] = 0
            for _ in range(1, n + 1):
                index = -1
                for i in range(1, n + 1):
                    if vis[i]:
                        continue
                    if index == -1 or dist[index] > dist[i]:
                        index = i
                vis[index] = True
                for j in range(1, n + 1):
                    dist[j] = min(dist[j], dist[index] + edge[index][j])
        
        dijkstra()
        ans = 0
        for i in range(1, n + 1):
            ans = max(ans, dist[i])
        return -1 if ans == float('inf') else ans


```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int N, T;
    int[] dist;
    int[][] edge;
    public int networkDelayTime(int[][] times, int n, int k) {
        N = n + 1;
        T = k;
        edge = new int[N][N];
        dist = new int[N];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                edge[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int[] t : times) {
            edge[t[0]][t[1]] = t[2];
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dijkstra() {
        boolean[] vis = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[T] = 0;
        for (int k = 1; k < N; k++) {
            int index = -1;
            for (int i = 1; i < N; i++) {
                if (vis[i]) {
                    continue;
                }
                if (index == - 1 || dist[index] > dist[i]) {
                    index = i;
                }
            }
            vis[index] = true;
            for (int j = 1; j < N; j++) {
                if (dist[index] == Integer.MAX_VALUE || edge[index][j] == Integer.MAX_VALUE) {
                    continue;
                }
                dist[j] = Math.min(dist[j], dist[index] + edge[index][j]);
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
