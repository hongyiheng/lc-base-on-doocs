# [1617. 统计子树中城市之间最大距离](https://leetcode-cn.com/problems/count-subtrees-with-max-distance-between-cities)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你 <code>n</code> 个城市，编号为从 <code>1</code> 到 <code>n</code> 。同时给你一个大小为 <code>n-1</code> 的数组 <code>edges</code> ，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示城市 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code><sub> </sub>之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 <strong>树</strong> 。</p>

<p>一棵 <strong>子树</strong> 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。</p>

<p>对于 <code>d</code> 从 <code>1</code> 到 <code>n-1</code> ，请你找到城市间 <strong>最大距离</strong> 恰好为 <code>d</code> 的所有子树数目。</p>

<p>请你返回一个大小为 <code>n-1</code> 的数组，其中第<em> </em><code>d</code><em> </em>个元素（<strong>下标从 1 开始</strong>）是城市间 <strong>最大距离</strong> 恰好等于 <code>d</code> 的子树数目。</p>

<p><strong>请注意</strong>，两个城市间距离定义为它们之间需要经过的边的数目。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/11/p1.png" style="width: 161px; height: 181px;" /></strong></p>

<pre>
<b>输入：</b>n = 4, edges = [[1,2],[2,3],[2,4]]
<b>输出：</b>[3,4,0]
<strong>解释：
</strong>子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
不存在城市间最大距离为 3 的子树。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>n = 2, edges = [[1,2]]
<b>输出：</b>[1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>n = 3, edges = [[1,2],[2,3]]
<b>输出：</b>[2,1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= n <= 15</code></li>
	<li><code>edges.length == n-1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
	<li>题目保证 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 所表示的边互不相同。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countSubgraphsForEachDiameter(self, n: int, edges: List[List[int]]) -> List[int]:
        def dfs(u):
            nonlocal vis, mask, d
            vis |= 1 << u
            ans = 0
            for v in g[u]:
                if (vis >> v & 1) == 0 and mask >> v & 1:
                    nx = dfs(v) + 1
                    d = max(d, ans + nx)
                    ans = max(ans, nx)
            return ans

        g = defaultdict(list)
        for u, v in edges:
            u -= 1
            v -= 1
            g[u].append(v)
            g[v].append(u)
        ans = [0] * (n - 1)
        for mask in range(1, 1 << n):
            if mask & (mask - 1) == 0:
                continue
            vis = d = 0
            dfs(mask.bit_length() - 1)
            if vis == mask:
                ans[d - 1] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int d, vis;
    List<Integer>[] g;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0] - 1].add(e[1] - 1);
            g[e[1] - 1].add(e[0] - 1);
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < 1 << n; mask++) {
            if ((mask & (mask - 1)) == 0) {
                continue;
            }
            vis = 0;
            d = 0;
            dfs(Integer.numberOfTrailingZeros(mask), mask);
            if (vis == mask) {
                ans[d - 1]++;
            }
        }
        return ans;
    }

    public int dfs(int u, int mask) {
        vis |= 1 << u;
        int ans = 0;
        for (int v : g[u]) {
            if ((vis >> v & 1) == 0 && (mask >> v & 1) == 1) {
                int nx = dfs(v, mask) + 1;
                d = Math.max(d, ans + nx);
                ans = Math.max(ans, nx);
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
