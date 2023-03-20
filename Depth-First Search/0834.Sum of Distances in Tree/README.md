# [834. 树中距离之和](https://leetcode-cn.com/problems/sum-of-distances-in-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个无向、连通的树。树中有 <code>N</code> 个标记为 <code>0...N-1</code> 的节点以及 <code>N-1</code>&nbsp;条边&nbsp;。</p>

<p>第 <code>i</code> 条边连接节点&nbsp;<code>edges[i][0]</code> 和 <code>edges[i][1]</code>&nbsp;。</p>

<p>返回一个表示节点 <code>i</code> 与其他所有节点距离之和的列表 <code>ans</code>。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
<strong>输出: </strong>[8,12,6,10,10,10]
<strong>解释: </strong>
如下为给定的树的示意图：
  0
 / \
1   2
   /|\
  3 4 5

我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
</pre>

<p><strong>说明:</strong>&nbsp;<code>1 &lt;= N &lt;= 10000</code></p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        cnt, depth = [0] * n, [0] * n

        def dfs(u, p):
            nonlocal g, cnt, depth
            cnt[u] = 1
            if not g[u]:
                return
            for v in g[u]:
                if v == p:
                    continue
                depth[v] = depth[u] + 1
                dfs(v, u)
                cnt[u] += cnt[v]

        dfs(0, -1)
        ans = [0] * n
        ans[0] = sum(depth)

        def dfs2(u, p):
            nonlocal g, cnt, ans, n
            for v in g[u]:
                if v == p:
                    continue
                ans[v] = ans[u] + (n - cnt[v]) - cnt[v]
                dfs2(v, u)

        dfs2(0, -1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] depth, cnt, ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        depth = new int[n];
        cnt = new int[n];
        ans = new int[n];
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
        }
        dfs(0, -1);
        for (int v : depth) {
            ans[0] += v;
        }
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int p) {
        cnt[u] = 1;
        if (!g.containsKey(u)) {
            return;
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            depth[v] = depth[u] + 1;
            dfs(v, u);
            cnt[u] += cnt[v];
        }
    }

    public void dfs2(int u, int p) {
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            ans[v] = ans[u] + (n - cnt[v]) - cnt[v];
            dfs2(v, u);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
