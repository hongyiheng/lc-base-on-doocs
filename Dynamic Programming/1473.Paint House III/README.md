# [1473. 粉刷房子 III](https://leetcode-cn.com/problems/paint-house-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个小城市里，有 <code>m</code> 个房子排成一排，你需要给每个房子涂上 <code>n</code> 种颜色之一（颜色编号为 <code>1</code> 到 <code>n</code> ）。有的房子去年夏天已经涂过颜色了，所以这些房子不可以被重新涂色。</p>

<p>我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 <code>houses = [1,2,2,3,3,2,1,1]</code> ，它包含 5 个街区 <code> [{1}, {2,2}, {3,3}, {2}, {1,1}]</code> 。）</p>

<p>给你一个数组 <code>houses</code> ，一个 <code>m * n</code> 的矩阵 <code>cost</code> 和一个整数 <code>target</code> ，其中：</p>

<ul>
	<li><code>houses[i]</code>：是第 <code>i</code> 个房子的颜色，<strong>0</strong> 表示这个房子还没有被涂色。</li>
	<li><code>cost[i][j]</code>：是将第 <code>i</code> 个房子涂成颜色 <code>j+1</code> 的花费。</li>
</ul>

<p>请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 <code>target</code> 个街区。如果没有可用的涂色方案，请返回 <strong>-1</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
<strong>输出：</strong>9
<strong>解释：</strong>房子涂色方案为 [1,2,2,1,1]
此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
<strong>输出：</strong>11
<strong>解释：</strong>有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
<strong>输出：</strong>5
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
<strong>输出：</strong>-1
<strong>解释：</strong>房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == houses.length == cost.length</code></li>
	<li><code>n == cost[i].length</code></li>
	<li><code>1 <= m <= 100</code></li>
	<li><code>1 <= n <= 20</code></li>
	<li><code>1 <= target <= m</code></li>
	<li><code>0 <= houses[i] <= n</code></li>
	<li><code>1 <= cost[i][j] <= 10^4</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, t: int) -> int:
        INF = 0x3f3f3f3f
        f = [[[0] * (t + 1) for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                f[i][j][0] = INF
        for i in range(1, m + 1):
            color = houses[i - 1]
            for j in range(1, n + 1):
                for k in range(1, t + 1):
                    if k > i:
                        f[i][j][k] = INF
                        continue
                    if color:
                        if j == color:
                            tmp = INF
                            for p in range(1, n + 1):
                                if j != p:
                                    tmp = min(tmp, f[i - 1][p][k - 1])
                            f[i][j][k] = min(tmp, f[i - 1][j][k])
                        else:
                            f[i][j][k] = INF
                    else:
                        u = cost[i - 1][j - 1]
                        tmp = INF
                        for p in range(1, n + 1):
                            if j != p:
                                tmp = min(tmp, f[i - 1][p][k - 1])
                        f[i][j][k] = min(tmp, f[i - 1][j][k]) + u
        ans = INF
        for i in range(1, n + 1):
            ans = min(ans, f[m][i][t])
        return -1 if ans == INF else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int INF = 0x3f3f3f3f;
    public int minCost(int[] houses, int[][] cost, int m, int n, int t) {
        int[][][] f = new int[m + 1][n + 1][t + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }
        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= t; k++) {
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }
                    if (color != 0) {
                        if (j == color) {
                            int tmp = INF;
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);
                        } else {
                            f[i][j][k] = INF;
                        }
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][t]);
        }
        return ans == INF ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
