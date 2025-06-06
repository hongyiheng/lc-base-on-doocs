# [2359. 找到离给定两个节点最近的节点](https://leetcode-cn.com/problems/find-closest-node-to-given-two-nodes)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n</code>&nbsp;个节点的 <strong>有向图</strong>&nbsp;，节点编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;，每个节点 <strong>至多</strong>&nbsp;有一条出边。</p>

<p>有向图用大小为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的数组&nbsp;<code>edges</code>&nbsp;表示，表示节点&nbsp;<code>i</code>&nbsp;有一条有向边指向&nbsp;<code>edges[i]</code>&nbsp;。如果节点&nbsp;<code>i</code>&nbsp;没有出边，那么&nbsp;<code>edges[i] == -1</code>&nbsp;。</p>

<p>同时给你两个节点&nbsp;<code>node1</code> 和&nbsp;<code>node2</code>&nbsp;。</p>

<p>请你返回一个从 <code>node1</code>&nbsp;和 <code>node2</code>&nbsp;都能到达节点的编号，使节点 <code>node1</code>&nbsp;和节点 <code>node2</code>&nbsp;到这个节点的距离 <b>较大值最小化</b>。如果有多个答案，请返回 <strong>最小</strong>&nbsp;的节点编号。如果答案不存在，返回 <code>-1</code>&nbsp;。</p>

<p>注意&nbsp;<code>edges</code>&nbsp;可能包含环。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/06/07/graph4drawio-2.png" style="width: 321px; height: 161px;"></p>

<pre><b>输入：</b>edges = [2,2,3,-1], node1 = 0, node2 = 1
<b>输出：</b>2
<b>解释：</b>从节点 0 到节点 2 的距离为 1 ，从节点 1 到节点 2 的距离为 1 。
两个距离的较大值为 1 。我们无法得到一个比 1 更小的较大值，所以我们返回节点 2 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/06/07/graph4drawio-4.png" style="width: 195px; height: 161px;"></p>

<pre><b>输入：</b>edges = [1,2,-1], node1 = 0, node2 = 2
<b>输出：</b>2
<b>解释：</b>节点 0 到节点 2 的距离为 2 ，节点 2 到它自己的距离为 0 。
两个距离的较大值为 2 。我们无法得到一个比 2 更小的较大值，所以我们返回节点 2 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == edges.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-1 &lt;= edges[i] &lt; n</code></li>
	<li><code>edges[i] != i</code></li>
	<li><code>0 &lt;= node1, node2 &lt; n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        def bfs(u):
            n = len(edges)
            dis = [inf] * n
            d = 0
            while u != -1 and dis[u] > d:
                dis[u] = d
                d += 1
                u = edges[u]
            return dis

        dis1, dis2 = bfs(node1), bfs(node2)
        ans, mi = -1, inf
        for i in range(len(dis1)):
            d = max(dis1[i], dis2[i])
            if d < mi:
                mi = d
                ans = i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    final int inf = 0x3f3f3f3f;

    public int[] bfs(int[] edges, int u) {
        int n = edges.length;
        int[] dis = new int[n];
        Arrays.fill(dis, inf);
        int d = 0;
        while (u != -1 && dis[u] > d) {
            dis[u] = d++;
            u = edges[u];
        }
        return dis;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = bfs(edges, node1), dis2 = bfs(edges, node2);
        int mi = inf, ans = -1;
        for (int i = 0; i < dis1.length; i++) {
            int d = Math.max(dis1[i], dis2[i]);
            if (mi > d) {
                mi = d;
                ans = i;
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
