# [1289. 下降路径最小和  II](https://leetcode-cn.com/problems/minimum-falling-path-sum-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数方阵&nbsp;<code>arr</code>&nbsp;，定义「非零偏移下降路径」为：从&nbsp;<code>arr</code> 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。</p>

<p>请你返回非零偏移下降路径数字和的最小值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>13
<strong>解释：</strong>
所有非零偏移下降路径包括：
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
下降路径中数字和最小的是&nbsp;[1,5,7] ，所以答案是&nbsp;13 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length == arr[i].length &lt;= 200</code></li>
	<li><code>-99 &lt;= arr[i][j] &lt;= 99</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(i, j):
            nonlocal n
            if i == n:
                return 0
            a = b = a_id = b_id = inf
            for k, v in enumerate(grid[i]):
                if k == j:
                    continue
                if v < a:
                    a, b = v, a
                    a_id, b_id = k, a_id
                elif v < b:
                    b_id, b = k, v
            return min(dfs(i + 1, a_id) + a, dfs(i + 1, b_id) + b)

        n = len(grid)
        if n == 1:
            return grid[0][0]
        return dfs(0, -1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, Integer> f = new HashMap<>();
    int n;
    int[][] g;
    int inf = 0x3f3f3f3f;

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        g = grid;
        return dfs(0, -1);
    }

    public int dfs(int i, int j) {
        if (i == n) {
            return 0;
        }
        String key = i + ":" + j;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int a = inf, b = inf, aId = inf, bId = inf;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            if (g[i][k] < a) {
                int t = a, tId = aId;
                a = g[i][k];
                aId = k;
                b = t;
                bId = tId;
            } else if (g[i][k] < b) {
                b = g[i][k];
                bId = k;
            }
        }
        int ans = Math.min(dfs(i + 1, aId) + a, dfs(i + 1, bId) + b);
        f.put(key, ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
