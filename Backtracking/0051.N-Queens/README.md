# [51. N 皇后](https://leetcode-cn.com/problems/n-queens)



## 题目描述

<!-- 这里写题目描述 -->

<p><strong>n 皇后问题</strong> 研究的是如何将 <code>n</code> 个皇后放置在 <code>n×n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>

<p>给你一个整数 <code>n</code> ，返回所有不同的 <strong>n<em> </em>皇后问题</strong> 的解决方案。</p>

<div class="original__bRMd">
<div>
<p>每一种解法包含一个不同的 <strong>n 皇后问题</strong> 的棋子放置方案，该方案中 <code>'Q'</code> 和 <code>'.'</code> 分别代表了皇后和空位。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>[["Q"]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 9</code></li>
	<li>皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。</li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def check(g, x, y):
            for d in [[-1, 0], [-1, -1], [-1, 1]]:
                nx, ny = x + d[0], y + d[1]
                while 0 <= nx < n and 0 <= ny < n:
                    if g[nx][ny]:
                        return False
                    nx += d[0]
                    ny += d[1]
            return True
        
        def dfs(g, x):
            if x == n:
                ans.append(["".join(["Q" if v else "." for v in r]) for r in g])
                return
            for y in range(n):
                if not check(g, x, y):
                    continue
                g[x][y] = True
                dfs(g, x + 1)
                g[x][y] = False


        g = [[False] * n for _ in range(n)]
        ans = []
        dfs(g, 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<List<String>> ans;
    int n;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        this.n = n;
        boolean[][] g = new boolean[n][n];
        dfs(g, 0);
        return ans;
    }

    public void dfs(boolean[][] g, int x) {
        if (x == n) {
            List<String> item = new ArrayList<>();
            for (boolean[] row : g) {
                StringBuilder sb = new StringBuilder();
                for (boolean b : row) {
                    sb.append(b ? "Q" : ".");
                }
                item.add(sb.toString());
            }
            ans.add(item);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(g, x, j)) {
                g[x][j] = true;
                dfs(g, x + 1);
                g[x][j] = false;
            }
        }
    }

    public boolean isValid(boolean[][] g, int x, int y) {
        int[][] dir = new int[][]{{-1, 1}, {-1, -1}, {-1, 0}};
        for (int [] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (g[nx][ny]) {
                    return false;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
