# [2867. 统计树中的合法路径数目](https://leetcode-cn.com/problems/count-valid-paths-in-a-tree)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵 <code>n</code>&nbsp;个节点的无向树，节点编号为&nbsp;<code>1</code>&nbsp;到&nbsp;<code>n</code>&nbsp;。给你一个整数&nbsp;<code>n</code>&nbsp;和一个长度为 <code>n - 1</code>&nbsp;的二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code>&nbsp;表示节点&nbsp;<code>u<sub>i</sub></code> 和&nbsp;<code>v<sub>i</sub></code>&nbsp;在树中有一条边。</p>

<p>请你返回树中的 <strong>合法路径数目</strong>&nbsp;。</p>

<p>如果在节点 <code>a</code>&nbsp;到节点 <code>b</code>&nbsp;之间 <strong>恰好有一个</strong>&nbsp;节点的编号是质数，那么我们称路径&nbsp;<code>(a, b)</code>&nbsp;是 <strong>合法的</strong>&nbsp;。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>路径&nbsp;<code>(a, b)</code>&nbsp;指的是一条从节点 <code>a</code>&nbsp;开始到节点 <code>b</code>&nbsp;结束的一个节点序列，序列中的节点 <strong>互不相同</strong>&nbsp;，且相邻节点之间在树上有一条边。</li>
	<li>路径&nbsp;<code>(a, b)</code>&nbsp;和路径&nbsp;<code>(b, a)</code>&nbsp;视为 <strong>同一条</strong>&nbsp;路径，且只计入答案 <strong>一次</strong>&nbsp;。</li>
</ul>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/08/27/example1.png" style="width: 440px; height: 357px;" /></p>

<pre>
<b>输入：</b>n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
<b>输出：</b>4
<b>解释：</b>恰好有一个质数编号的节点路径有：
- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
只有 4 条合法路径。
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/08/27/example2.png" style="width: 488px; height: 384px;" /></p>

<pre>
<b>输入：</b>n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
<b>输出：</b>6
<b>解释：</b>恰好有一个质数编号的节点路径有：
- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
- (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
- (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
只有 6 条合法路径。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
	<li>输入保证&nbsp;<code>edges</code>&nbsp;形成一棵合法的树。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPaths(self, n: int, edges: List[List[int]]) -> int:
        def getPrime(n):
            primes = [False] * n
            for i in range(2, n):
                if not primes[i]:
                    for j in range(i * i, n, i):
                        primes[j] = True
            primes[1] = True
            return primes
        
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                size[r2] += size[r1]
                p[r1] = r2
           
        primes = getPrime(n + 1)
        p = [i for i in range(n + 1)]
        size = [1] * (n + 1)

        g = defaultdict(list)
        for u, v in edges:
            if primes[u] and primes[v]:
                union(u, v)
            g[u].append(v)
            g[v].append(u)
        ans = 0
        for u in range(1, n + 1):
            s = 0
            if primes[u]:
                continue
            for v in g[u]:
                if not primes[v]:
                    continue
                cnt = size[find(v)]
                ans += cnt
                ans += s * cnt
                s += cnt
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (long j = (long)i * i; j < n; j += i) {
                    primes[(int)j] = true;
                }
            }
        }
        primes[1] = true;
        return primes;
    }

    int[] p;
    int[] size;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 != r2) {
            size[r2] += size[r1];
            p[r1] = r2;
        }
    }

    public long countPaths(int n, int[][] edges) {
        boolean[] primes = getPrimes(n + 1);
        p = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (primes[u] && primes[v]) {
                union(u, v);
            }
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        long ans = 0;
        for (int u = 1; u <= n; u++) {
            if (primes[u]) {
                continue;
            }
            long s = 0;
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (!primes[v]) {
                    continue;
                }
                int cnt = size[find(v)];
                System.out.println(u + "," + v + "," + cnt);
                ans += cnt;
                ans += s * cnt;
                s += cnt;
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
