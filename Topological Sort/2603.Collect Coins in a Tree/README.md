# [2603. 收集树中金币](https://leetcode-cn.com/problems/collect-coins-in-a-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n</code>&nbsp;个节点的无向无根树，节点编号从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;。给你整数&nbsp;<code>n</code>&nbsp;和一个长度为 <code>n - 1</code>&nbsp;的二维整数数组 <code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;表示树中节点&nbsp;<code>a<sub>i</sub></code> 和&nbsp;<code>b<sub>i</sub></code>&nbsp;之间有一条边。再给你一个长度为 <code>n</code>&nbsp;的数组&nbsp;<code>coins</code>&nbsp;，其中&nbsp;<code>coins[i]</code> 可能为&nbsp;<code>0</code>&nbsp;也可能为&nbsp;<code>1</code>&nbsp;，<code>1</code>&nbsp;表示节点 <code>i</code>&nbsp;处有一个金币。</p>

<p>一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：</p>

<ul>
	<li>收集距离当前节点距离为 <code>2</code>&nbsp;以内的所有金币，或者</li>
	<li>移动到树中一个相邻节点。</li>
</ul>

<p>你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。</p>

<p>如果你多次经过一条边，每一次经过都会给答案加一。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/03/01/graph-2.png" style="width: 522px; height: 522px;"></p>

<pre><b>输入：</b>coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
<b>输出：</b>2
<b>解释：</b>从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/03/02/graph-4.png" style="width: 522px; height: 522px;"></p>

<pre><b>输入：</b>coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]
<b>输出：</b>2
<b>解释：</b>从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == coins.length</code></li>
	<li><code>1 &lt;= n &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= coins[i] &lt;= 1</code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>edges</code>&nbsp;表示一棵合法的树。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        n = len(coins)
        to = [0] * n
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
            to[u] += 1
            to[v] += 1
        cnt = len(edges)
        q = []
        for i, v in enumerate(to):
            if v == 1 and not coins[i]:
                q.append(i)
        while q:
            v = q.pop()
            cnt -= 1
            for u in g[v]:
                to[u] -= 1
                if to[u] == 1 and not coins[u]:
                    q.append(u)
        for i, v in enumerate(to):
            if v == 1 and coins[i]:
                q.append(i)
        for v in q:
            cnt -= 1
            for u in g[v]:
                to[u] -= 1
                if to[u] == 1:
                    cnt -= 1
        return max(cnt * 2, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int[] to = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            to[u]++;
            to[v]++;
        }
        int cnt = edges.length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (to[i] == 1 && coins[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer v = q.poll();
            cnt--;
            for (int u : g.getOrDefault(v, new ArrayList<>())) {
                if (--to[u] == 1 && coins[u] == 0) {
                    q.add(u);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (to[i] == 1 && coins[i] == 1) {
                q.add(i);
            }
        }
        for (int v : q) {
            cnt--;
            for (int u : g.getOrDefault(v, new ArrayList<>())) {
                if (--to[u] == 1) {
                    cnt--;
                }
            }
        }
        return Math.max(cnt * 2, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
