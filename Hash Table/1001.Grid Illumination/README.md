# [1001. 网格照明](https://leetcode-cn.com/problems/grid-illumination)



## 题目描述

<!-- 这里写题目描述 -->

<p>在 <code>N x N</code> 的网格 <code>grid</code> 上，每个单元格都有一盏灯，最初灯都处于 <strong>关闭</strong> 状态。</p>

<p>数组 <code>lamps</code> 表示打开的灯的位置。<code>lamps[i] = [row<sub>i</sub>, col<sub>i</sub>]</code> 表示 <strong>打开</strong> 位于 <code>grid[row<sub>i</sub>][col<sub>i</sub>]</code> 的第 <code>i</code> 盏灯 。每盏灯都照亮自身单元格以及同一行、同一列和两条对角线上的所有其他单元格。</p>

<p>查询数组 <code>queries</code> 中，第 <code>i</code> 次查询 <code>queries[i] = [row<sub>i</sub>, col<sub>i</sub>]</code>，如果单元格 <code>[row<sub>i</sub>, col<sub>i</sub>]</code> 是被照亮的，则查询结果为 <code>1</code> ，否则为 <code>0</code> 。在第 <code>i</code> 次查询之后 [按照查询的顺序] ，<strong>关闭</strong> 位于单元格 <code>grid[row<sub>i</sub>][col<sub>i</sub>]</code> 上或其相邻 8 个方向上（与单元格 <code>grid[row<sub>i</sub>][col<sub>i</sub>]</code> 共享角或边）的任何灯。</p>

<p>返回答案数组 <code>ans</code> ， <code>answer[i]</code> 应等于第 <code>i</code> 次查询 <code>queries[i]</code> 的结果，<code>1</code> 表示照亮，<code>0</code> 表示未照亮。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/illu_1.jpg" style="width: 750px; height: 209px;" />
<pre>
<strong>输入：</strong>N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
<strong>输出：</strong>[1,0]
<strong>解释：</strong>最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/illu_step1.jpg" style="width: 500px; height: 218px;" />
第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/illu_step2.jpg" style="width: 500px; height: 219px;" />
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
<strong>输出：</strong>[1,1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>N = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
<strong>输出：</strong>[1,1,0]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= N <= 10<sup>9</sup></code></li>
	<li><code>0 <= lamps.length <= 20000</code></li>
	<li><code>lamps[i].length == 2</code></li>
	<li><code>0 <= lamps[i][j] < N</code></li>
	<li><code>0 <= queries.length <= 20000</code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 <= queries[i][j] < N</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def gridIllumination(self, n: int, lamps: List[List[int]], queries: List[List[int]]) -> List[int]:
        dirs = [[0, 0], [1, 0], [0, 1], [1, 1], [-1, -1], [1, -1], [-1, 1], [-1, 0], [0, -1]]
        row, col, left, right = dict(), dict(), dict(), dict()
        light = set()
        for lamp in lamps:
            x, y = lamp
            l, r = y - x, x + y
            if (x * n + y) in light:
                continue
            light.add(x * n + y)
            row[x] = row.get(x, 0) + 1
            col[y] = col.get(y, 0) + 1
            left[l] = left.get(l, 0) + 1
            right[r] = right.get(r, 0) + 1
        k = len(queries)
        ans = [0] * k
        for i in range(k):
            x, y = queries[i]
            if x in row or y in col or (y - x) in left or (x + y) in right:
                ans[i] = 1
            for dir in dirs:
                nx, ny = x + dir[0], y + dir[1]
                if (nx * n + ny) in light:
                    light.remove(nx * n + ny)
                    nl, nr = ny - nx, nx + ny
                    if row.get(nx, 0) > 1:
                        row[nx] -= 1
                    else:
                        row.pop(nx, "")
                    if col.get(ny, 0) > 1:
                        col[ny] -= 1
                    else:
                        col.pop(ny, "")
                    if left.get(nl, 0) > 1:
                        left[nl] -= 1
                    else:
                        left.pop(nl, "")
                    if right.get(nr, 0) > 1:
                        right[nr] -= 1
                    else:
                        right.pop(nr, "")
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {0, 0}, {-1, 1}, {1, -1}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> light = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            int l = y - x, r = x + y;
            if (light.contains(x * n + y)) {
                continue;
            }
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            left.put(l, left.getOrDefault(l, 0) + 1);
            right.put(r, right.getOrDefault(r, 0) + 1);
            light.add(x * n + y);
        }
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(y - x) || right.containsKey(x + y)) {
                ans[i] = 1;
            }
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (light.contains(nx * n + ny)) {
                    int nl = ny - nx, nr = nx + ny;
                    light.remove(nx * n + ny);
                    if (row.getOrDefault(nx, 0) > 1) {
                        row.put(nx, row.get(nx) - 1);
                    } else {
                        row.remove(nx);
                    }
                    if (col.getOrDefault(ny, 0) > 1) {
                        col.put(ny, col.get(ny) - 1);
                    } else {
                        col.remove(ny);
                    }
                    if (left.getOrDefault(nl, 0) > 1) {
                        left.put(nl, left.get(nl) - 1);
                    } else {
                        left.remove(nl);
                    }
                    if (right.getOrDefault(nr, 0) > 1) {
                        right.put(nr, right.get(nr) - 1);
                    } else {
                        right.remove(nr);
                    }
                }
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
