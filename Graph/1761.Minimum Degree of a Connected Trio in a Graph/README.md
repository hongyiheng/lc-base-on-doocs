# [1761. 一个图中连通三元组的最小度数](https://leetcode-cn.com/problems/minimum-degree-of-a-connected-trio-in-a-graph)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个无向图，整数 <code>n</code> 表示图中节点的数目，<code>edges</code> 数组表示图中的边，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> ，表示 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code><sub> </sub>之间有一条无向边。</p>

<p>一个 <strong>连通三元组</strong> 指的是 <strong>三个</strong> 节点组成的集合且这三个点之间 <strong>两两</strong> 有边。</p>

<p><strong>连通三元组的度数</strong> 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。</p>

<p>请你返回所有连通三元组中度数的 <strong>最小值</strong> ，如果图中没有连通三元组，那么返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/02/14/trios1.png" style="width: 388px; height: 164px;" />
<pre>
<b>输入：</b>n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
<b>输出：</b>3
<b>解释：</b>只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/02/14/trios2.png" style="width: 388px; height: 164px;" />
<pre>
<b>输入：</b>n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
<b>输出：</b>0
<b>解释：</b>有 3 个三元组：
1) [1,4,3]，度数为 0 。
2) [2,5,6]，度数为 2 。
3) [5,6,7]，度数为 2 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= n <= 400</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 <= edges.length <= n * (n-1) / 2</code></li>
	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
	<li><code>u<sub>i </sub>!= v<sub>i</sub></code></li>
	<li>图中没有重复的边。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minTrioDegree(self, n: int, edges: List[List[int]]) -> int:
        g = defaultdict(set)
        for u, v in edges:
            g[u].add(v)
            g[v].add(u)
        ans = inf
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                if j not in g[i]:
                    continue
                for k in range(j + 1, n + 1):
                    if k not in g[j] or i not in g[k]:
                        continue
                    ans = min(ans, len(g[i]) + len(g[j]) + len(g[k]) - 6)
        return -1 if ans == inf else ans 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int inf = 0x3f3f3f3f;

    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            g.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int ans = inf;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (!g.get(i).contains(j)) {
                    continue;
                }
                for (int k = j + 1; k < n + 1; k++) {
                    if (!g.get(j).contains(k) || !g.get(k).contains(i)) {
                        continue;
                    }
                    ans = Math.min(ans, g.get(i).size() + g.get(j).size() + g.get(k).size() - 6);
                }
            }
        }
        return ans == inf ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
