# [1411. 给 N x 3 网格图涂色的方案数](https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有一个 <code>n x 3</code>&nbsp;的网格图 <code>grid</code>&nbsp;，你需要用 <strong>红，黄，绿</strong>&nbsp;三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。</p>

<p>给你网格图的行数 <code>n</code>&nbsp;。</p>

<p>请你返回给&nbsp;<code>grid</code>&nbsp;涂色的方案数。由于答案可能会非常大，请你返回答案对&nbsp;<code>10^9 + 7</code>&nbsp;取余的结果。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 1
<strong>输出：</strong>12
<strong>解释：</strong>总共有 12 种可行的方法：
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/04/12/e1.png" style="height: 289px; width: 450px;">
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 2
<strong>输出：</strong>54
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 3
<strong>输出：</strong>246
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>n = 7
<strong>输出：</strong>106494
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>n = 5000
<strong>输出：</strong>30228214
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>grid[i].length == 3</code></li>
	<li><code>1 &lt;= n &lt;= 5000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numOfWays(self, n: int) -> int:
        M = int(1e9 + 7)
        # 三色 f1, 双色 f2
        f1 = f2 = 6
        for i in range(1, n):
            # 每个三色的下一行, 有 2 个三色, 2 个双色
            # 每个双色的下一行, 有 2 个三色, 3 个双色
            nf1 = f1 * 2 + f2 * 2
            nf2 = f1 * 2 + f2 * 3
            f1, f2 = nf1 % M, nf2 % M
        return (f1 + f2) % M


class Solution:
    def numOfWays(self, n: int) -> int:
        def dfs(path):
            if len(path) == 3:
                masks.append("".join(path))
                return
            for i in range(3):
                if path and str(i) == path[-1]:
                    continue
                path.append(str(i))
                dfs(path)
                path.pop()

        masks = []
        dfs([])

        g = defaultdict(set)
        for i, m1 in enumerate(masks):
            for j, m2 in enumerate(masks):
                if not any(m1[k] == m2[k] for k in range(3)):
                    g[i].add(j)
                    g[j].add(i)

        M = int(1e9 + 7)
        f = [[0] * len(masks) for _ in range(n)]
        for i in range(len(masks)):
            f[0][i] = 1
        for i in range(1, n):
            for j in range(len(masks)):
                for k in g[j]:
                    f[i][j] += f[i - 1][k]
                    f[i][j] %= M
        return sum(f[-1]) % M
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numOfWays(int n) {
        int M = (int)1e9 + 7;
        // 三色 f1, 双色 f2
        long f1 = 6L, f2 = 6L;
        for (int i = 1; i < n; i++) {
            // 每个三色的下一行, 有 2 个三色, 2 个双色
            // 每个双色的下一行, 有 2 个三色, 3 个双色
            long nf1 = f1 * 2 + f2 * 2;
            long nf2 = f1 * 2 + f2 * 3;
            f1 = nf1 % M;
            f2 = nf2 % M;
        }
        return (int)((f1 + f2) % M);
    }
}


class Solution {
    
    List<String> masks;

    public void dfs(List<String> path) {
        if (path.size() == 3) {
            masks.add(String.join("", path));
            return;
        }
        for (String s : new String[]{"0", "1", "2"}) {
            if (!path.isEmpty() && path.get(path.size() - 1).equals(s)) {
                continue;
            }
            path.add(s);
            dfs(path);
            path.remove(path.size() - 1);
        }
    }

    public int numOfWays(int n) {
        masks = new ArrayList<>();
        dfs(new ArrayList<>());

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < masks.size(); i++) {
            for (int j = 0; j < masks.size(); j++) {
                boolean diff = false;
                for (int k = 0; k < 3; k++) {
                    if (masks.get(i).charAt(k) == masks.get(j).charAt(k)) {
                        diff = true;
                        break;
                    }
                }
                if (!diff) {
                    g.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    g.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }

        int M = (int) (1e9 + 7);
        long[][] f = new long[n][masks.size()];
        Arrays.fill(f[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < masks.size(); j++) {
                for (int k : g.getOrDefault(j, new HashSet<>())) {
                    f[i][j] = (f[i][j] + f[i - 1][k]) % M;
                }
            }
        }
        return (int) (Arrays.stream(f[n - 1]).sum() % M);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
