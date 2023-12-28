# [2973. 树中每个节点放置的金币数目](https://leetcode-cn.com/problems/find-number-of-coins-to-place-in-tree-nodes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵&nbsp;<code>n</code>&nbsp;个节点的&nbsp;<strong>无向</strong>&nbsp;树，节点编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;，树的根节点在节点&nbsp;<code>0</code>&nbsp;处。同时给你一个长度为 <code>n - 1</code>&nbsp;的二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;表示树中节点&nbsp;<code>a<sub>i</sub></code> 和&nbsp;<code>b<sub>i</sub></code>&nbsp;之间有一条边。</p>

<p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>cost</code>&nbsp;，其中&nbsp;<code>cost[i]</code>&nbsp;是第 <code>i</code>&nbsp;个节点的 <b>开销</b>&nbsp;。</p>

<p>你需要在树中每个节点都放置金币，在节点 <code>i</code>&nbsp;处的金币数目计算方法如下：</p>

<ul>
	<li>如果节点 <code>i</code>&nbsp;对应的子树中的节点数目小于&nbsp;<code>3</code>&nbsp;，那么放&nbsp;<code>1</code>&nbsp;个金币。</li>
	<li>否则，计算节点 <code>i</code> 对应的子树内 <code>3</code> 个不同节点的开销乘积的 <strong>最大值</strong> ，并在节点 <code>i</code> 处放置对应数目的金币。如果最大乘积是 <b>负数</b>&nbsp;，那么放置 <code>0</code>&nbsp;个金币。</li>
</ul>

<p>请你返回一个长度为 <code>n</code>&nbsp;的数组<em>&nbsp;</em><code>coin</code>&nbsp;，<code>coin[i]</code>是节点&nbsp;<code>i</code>&nbsp;处的金币数目。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/09/screenshot-2023-11-10-012641.png" style="width: 600px; height: 233px;" /></p>

<pre>
<b>输入：</b>edges = [[0,1],[0,2],[0,3],[0,4],[0,5]], cost = [1,2,3,4,5,6]
<b>输出：</b>[120,1,1,1,1,1]
<b>解释：</b>在节点 0 处放置 6 * 5 * 4 = 120 个金币。所有其他节点都是叶子节点，子树中只有 1 个节点，所以其他每个节点都放 1 个金币。
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/09/screenshot-2023-11-10-012614.png" style="width: 800px; height: 374px;" /></p>

<pre>
<b>输入：</b>edges = [[0,1],[0,2],[1,3],[1,4],[1,5],[2,6],[2,7],[2,8]], cost = [1,4,2,3,5,7,8,-4,2]
<b>输出：</b>[280,140,32,1,1,1,1,1,1]
<b>解释：</b>每个节点放置的金币数分别为：
- 节点 0 处放置 8 * 7 * 5 = 280 个金币。
- 节点 1 处放置 7 * 5 * 4 = 140 个金币。
- 节点 2 处放置 8 * 2 * 2 = 32 个金币。
- 其他节点都是叶子节点，子树内节点数目为 1 ，所以其他每个节点都放 1 个金币。
</pre>

<p><strong class="example">示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/09/screenshot-2023-11-10-012513.png" style="width: 300px; height: 277px;" /></p>

<pre>
<b>输入：</b>edges = [[0,1],[0,2]], cost = [1,2,-2]
<b>输出：</b>[0,1,1]
<b>解释：</b>节点 1 和 2 都是叶子节点，子树内节点数目为 1 ，各放置 1 个金币。节点 0 处唯一的开销乘积是 2 * 1 * -2 = -4 。所以在节点 0 处放置 0 个金币。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>cost.length == n</code></li>
	<li><code>1 &lt;= |cost[i]| &lt;= 10<sup>4</sup></code></li>
	<li><code>edges</code>&nbsp;一定是一棵合法的树。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def placedCoins(self, edges: List[List[int]], cost: List[int]) -> List[int]:
        def dfs(u, p) -> List[List[int]]:
            pos, neg = [], []
            if cost[u] >= 0:
                pos.append(cost[u])
            else:
                neg.append(cost[u])
            for v in g[u]:
                if v == p:
                    continue
                ps, ng = dfs(v, u)
                pos.extend(ps)
                neg.extend(ng)
            if len(pos) + len(neg) >= 3:
                pos.sort(reverse=True)
                neg.sort()
                if len(pos) >= 3:
                    ans[u] = pos[0] * pos[1] * pos[2]
                if len(pos) >= 1 and len(neg) >= 2:
                    ans[u] = max(ans[u], pos[0] * neg[0] * neg[1])
                pos = pos[:3]
                neg = neg[:2]
            else:
                ans[u] = 1
            return [pos, neg]

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = [0] * len(cost)
        dfs(0, -1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<Integer, List<Integer>> g;
    int[] cost;
    long[] ans;

    public List<List<Integer>> dfs(int u, int p) {
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        if (cost[u] >= 0) {
            pos.add(cost[u]);
        } else {
            neg.add(cost[u]);
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            List<List<Integer>> res = dfs(v, u);
            pos.addAll(res.get(0));
            neg.addAll(res.get(1));
        }
        if (pos.size() + neg.size() >= 3) {
            pos.sort((a, b) -> b - a);
            neg.sort((a, b) -> a - b);
            if (pos.size() >= 3) {
                ans[u] = 1L * pos.get(0) * pos.get(1) * pos.get(2);
            }
            if (pos.size() >= 1 && neg.size() >= 2) {
                ans[u] = Math.max(ans[u], 1L * pos.get(0) * neg.get(0) * neg.get(1));
            }
            pos = pos.subList(0, Math.min(pos.size(), 3));
            neg = neg.subList(0, Math.min(neg.size(), 2));
        } else {
            ans[u] = 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(pos);
        res.add(neg);
        return res;
    }

    public long[] placedCoins(int[][] edges, int[] cost) {
        g = new HashMap<>();
        this.cost = cost;
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        ans = new long[cost.length];
        dfs(0, -1);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
