# [1931. 用三种不同颜色为网格涂色](https://leetcode-cn.com/problems/painting-a-grid-with-three-different-colors)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数 <code>m</code> 和 <code>n</code> 。构造一个 <code>m x n</code> 的网格，其中每个单元格最开始是白色。请你用 <strong>红、绿、蓝</strong> 三种颜色为每个单元格涂色。所有单元格都需要被涂色。</p>

<p>涂色方案需要满足：<strong>不存在相邻两个单元格颜色相同的情况</strong> 。返回网格涂色的方法数。因为答案可能非常大， 返回 <strong>对 </strong><code>10<sup>9</sup> + 7</code><strong> 取余</strong> 的结果。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/colorthegrid.png" style="width: 200px; height: 50px;" />
<pre>
<strong>输入：</strong>m = 1, n = 1
<strong>输出：</strong>3
<strong>解释：</strong>如上图所示，存在三种可能的涂色方案。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/copy-of-colorthegrid.png" style="width: 321px; height: 121px;" />
<pre>
<strong>输入：</strong>m = 1, n = 2
<strong>输出：</strong>6
<strong>解释：</strong>如上图所示，存在六种可能的涂色方案。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>m = 5, n = 5
<strong>输出：</strong>580986
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= m <= 5</code></li>
	<li><code>1 <= n <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        def dfs(path):
            if len(path) == m:
                masks.append(tuple(path))
                return
            for k in range(3):
                if path and path[-1] == k:
                    continue
                path.append(k)
                dfs(path)
                path.pop()

        masks = []
        dfs([])
        g = defaultdict(set)
        for i, m1 in enumerate(masks):
            for j, m2 in enumerate(masks):
                if any(m1[k] == m2[k] for k in range(m)):
                    continue
                g[i].add(j)
                g[j].add(i)

        f = [[0] * len(masks) for _ in range(n)]
        for i in range(len(masks)):
            f[0][i] = 1
        for i in range(n - 1):
            for j in range(len(masks)):
                for k in g[j]:
                    f[i + 1][k] += f[i][j]
        return sum(f[-1]) % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<String> masks;

    public void dfs(List<String> path, int m) {
        if (path.size() == m) {
            masks.add(String.join("", path));
            return;
        }
        for (String k : new String[]{"0", "1", "2"}) {
            if (!path.isEmpty() && path.get(path.size() - 1).equals(k)) {
                continue;
            }
            path.add(k);
            dfs(path, m);
            path.remove(path.size() - 1);
        }
    }

    public int colorTheGrid(int m, int n) {
        masks = new ArrayList<>();
        dfs(new ArrayList<>(), m);
        
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < masks.size(); i++) {
            for (int j = i + 1; j < masks.size(); j++) {
                boolean diff = true;
                for (int k = 0; k < m; k++) {
                    if (masks.get(i).charAt(k) == masks.get(j).charAt(k)) {
                        diff = false;
                        break;
                    }
                }
                if (diff) {
                    g.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    g.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }
        
        int[][] f = new int[n][masks.size()];
        Arrays.fill(f[0], 1);
        int M = (int) (1e9 + 7);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < masks.size(); j++) {
                for (int k : g.get(j)) {
                    f[i + 1][k] = (f[i + 1][k] + f[i][j]) % M;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < masks.size(); i++) {
            ans = (ans + f[n - 1][i]) % M;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
