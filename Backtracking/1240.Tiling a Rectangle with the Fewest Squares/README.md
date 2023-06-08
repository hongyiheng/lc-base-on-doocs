# [1240. 铺瓷砖](https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares)



## 题目描述

<!-- 这里写题目描述 -->

<p>你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。</p>

<p>房子的客厅大小为&nbsp;<code>n</code>&nbsp;x <code>m</code>，为保持极简的风格，需要使用尽可能少的 <strong>正方形</strong> 瓷砖来铺盖地面。</p>

<p>假设正方形瓷砖的规格不限，边长都是整数。</p>

<p>请你帮设计师计算一下，最少需要用到多少块方形瓷砖？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/25/sample_11_1592.png" style="height: 106px; width: 154px;"></p>

<pre><strong>输入：</strong>n = 2, m = 3
<strong>输出：</strong>3
<code><strong>解释：</strong>3</code> 块地砖就可以铺满卧室。
<code>     2</code> 块 <code>1x1 地砖</code>
<code>     1</code> 块 <code>2x2 地砖</code></pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/25/sample_22_1592.png" style="height: 126px; width: 224px;"></p>

<pre><strong>输入：</strong>n = 5, m = 8
<strong>输出：</strong>5
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/25/sample_33_1592.png" style="height: 189px; width: 224px;"></p>

<pre><strong>输入：</strong>n = 11, m = 13
<strong>输出：</strong>6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 13</code></li>
	<li><code>1 &lt;= m&nbsp;&lt;=&nbsp;13</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def tilingRectangle(self, n: int, m: int) -> int:
        def dfs(x, y, cur):
            nonlocal ans
            if cur >= ans:
                return
            if x + 1 == m and y + 1 == n:
                ans = min(ans, cur + (0 if g[x][y] else 1))
            nx, ny = x, y + 1
            if ny == n:
                nx += 1
                ny = 0
            if g[x][y]:
                dfs(nx, ny, cur)
            else:
                for k in range(min(m - x, n - y), 0, - 1):
                    blank = True
                    for i in range(x, x + k):
                        if not blank:
                            break
                        for j in range(y, y + k):
                            if g[i][j]:
                                blank = False
                                break
                    if not blank:
                        continue
                    for i in range(x, x + k):
                        for j in range(y, y + k):
                            g[i][j] = True
                    dfs(nx, ny, cur + 1)
                    for i in range(x, x + k):
                        for j in range(y, y + k):
                            g[i][j] = False


        g = [[False] * n for _ in range(m)]
        ans = n * m
        dfs(0, 0, 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    boolean[][] g;
    int ans, n, m;

    public int tilingRectangle(int n, int m) {
        g = new boolean[m][n];
        ans = n * m;
        this.n = n;
        this.m = m;
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int x, int y, int cur) {
        if (cur >= ans) {
            return;
        }
        if (x + 1 == m && y + 1 == n) {
            ans = Math.min(ans, cur + (g[x][y] ? 0 : 1));
            return;
        }
        int nx = x, ny = y + 1;
        if (ny == n) {
            nx++;
            ny = 0;
        }
        if (g[x][y]) {
            dfs(nx, ny, cur);
        } else {
            for (int k = Math.min(m - x, n - y); k >= 1; k--) {
                boolean blank = true;
                for (int i = x; i < x + k && blank; i++) {
                    for (int j = y; j < y + k && blank; j++) {
                        blank = !g[i][j];
                    }
                }
                if (!blank) {
                    continue;
                }
                for (int i = x; i < x + k; i++) {
                    for (int j = y; j < y + k; j++) {
                        g[i][j] = true;
                    }
                }
                dfs(nx, ny, cur + 1);
                for (int i = x; i < x + k; i++) {
                    for (int j = y; j < y + k; j++) {
                        g[i][j] = false;
                    }
                }               
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
