# [2959. 关闭分部的可行集合数目](https://leetcode-cn.com/problems/number-of-possible-sets-of-closing-branches)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个公司在全国有 <code>n</code>&nbsp;个分部，它们之间有的有道路连接。一开始，所有分部通过这些道路两两之间互相可以到达。</p>

<p>公司意识到在分部之间旅行花费了太多时间，所以它们决定关闭一些分部（<b>也可能不关闭任何分部</b>），同时保证剩下的分部之间两两互相可以到达且最远距离不超过&nbsp;<code>maxDistance</code>&nbsp;。</p>

<p>两个分部之间的 <strong>距离</strong> 是通过道路长度之和的 <strong>最小值</strong>&nbsp;。</p>

<p>给你整数&nbsp;<code>n</code>&nbsp;，<code>maxDistance</code>&nbsp;和下标从 <strong>0</strong>&nbsp;开始的二维整数数组&nbsp;<code>roads</code>&nbsp;，其中&nbsp;<code>roads[i] = [u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>]</code>&nbsp;表示一条从&nbsp;<code>u<sub>i</sub></code>&nbsp;到&nbsp;<code>v<sub>i</sub></code>&nbsp;长度为&nbsp;<code>w<sub>i</sub></code>的&nbsp;<strong>无向</strong>&nbsp;道路。</p>

<p>请你返回关闭分部的可行方案数目，满足每个方案里剩余分部之间的最远距离不超过<em>&nbsp;</em><code>maxDistance</code>。</p>

<p><strong>注意</strong>，关闭一个分部后，与之相连的所有道路不可通行。</p>

<p><b>注意</b>，两个分部之间可能会有多条道路。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/08/example11.png" style="width: 221px; height: 191px;" /></p>

<pre>
<b>输入：</b>n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]
<b>输出：</b>5
<b>解释：</b>可行的关闭分部方案有：
- 关闭分部集合 [2] ，剩余分部为 [0,1] ，它们之间的距离为 2 。
- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
总共有 5 种可行的关闭方案。
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/08/example22.png" style="width: 221px; height: 241px;" /></p>

<pre>
<b>输入：</b>n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]
<b>输出：</b>7
<b>解释：</b>可行的关闭分部方案有：
- 关闭分部集合 [] ，剩余分部为 [0,1,2] ，它们之间的最远距离为 4 。
- 关闭分部集合 [0] ，剩余分部为 [1,2] ，它们之间的距离为 2 。
- 关闭分部集合 [1] ，剩余分部为 [0,2] ，它们之间的距离为 2 。
- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
总共有 7 种可行的关闭方案。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<b>输入：</b>n = 1, maxDistance = 10, roads = []
<b>输出：</b>2
<b>解释：</b>可行的关闭分部方案有：
- 关闭分部集合 [] ，剩余分部为 [0] 。
- 关闭分部集合 [0] ，关闭后没有剩余分部。
总共有 2 种可行的关闭方案。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10</code></li>
	<li><code>1 &lt;= maxDistance &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= roads.length &lt;= 1000</code></li>
	<li><code>roads[i].length == 3</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>1 &lt;= w<sub>i</sub> &lt;= 1000</code></li>
	<li>一开始所有分部之间通过道路互相可以到达。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: List[List[int]]) -> int:
        def dfs(i, mask):
            if i == n:
                masks.add(mask)
                return
            dfs(i + 1, mask)
            dfs(i + 1, mask | 1 << i)

        def check(mask):
            f = [[inf] * n for _ in range(n)]
            for u, v, w in roads:
                if not mask >> u & 1 or not mask >> v & 1:
                    continue
                f[v][u] = f[u][v] = min(f[u][v], w)
            for k in range(n):
                for i in range(n):
                    for j in range(i + 1, n):
                        f[i][j] = f[j][i] = min(f[i][j], f[i][k] + f[k][j])
            for u in range(n):
                for v in range(u + 1, n):
                    if not mask >> u & 1 or not mask >> v & 1:
                        continue
                    if f[u][v] > maxDistance:
                        return False
            return True

        masks = set()
        dfs(0, 0)
        ans = 0
        for mask in masks:
            if check(mask):
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    public boolean check(int n, int[][] roads, int maxDistance, int mask) {
        int[][] f = new int[n][n];
        for (int[] row : f) {
            Arrays.fill(row, 0x3f3f3f3f);
        }
        for (int[] e : roads) {
            int u = e[0], v = e[1], w = e[2];
            if ((mask >> u & 1) == 0 || (mask >> v & 1) == 0) {
                continue;
            }
            f[u][v] = f[v][u] = Math.min(f[u][v], w);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    f[i][j] = f[j][i] = Math.min(f[i][j], f[i][k] + f[k][j]);
                }
            }
        }
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if ((mask >> u & 1) == 0 || (mask >> v & 1) == 0) {
                    continue;
                }
                if (f[u][v] > maxDistance) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (check(n, roads, maxDistance, mask)) {
                ans++;
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
