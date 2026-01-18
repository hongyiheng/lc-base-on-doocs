# [1895. 最大的幻方](https://leetcode-cn.com/problems/largest-magic-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个 <code>k x k</code> 的<strong> 幻方</strong> 指的是一个 <code>k x k</code> 填满整数的方格阵，且每一行、每一列以及两条对角线的和 <strong>全部</strong><strong>相等</strong> 。幻方中的整数 <strong>不需要互不相同</strong> 。显然，每个 <code>1 x 1</code> 的方格都是一个幻方。</p>

<p>给你一个 <code>m x n</code> 的整数矩阵 <code>grid</code> ，请你返回矩阵中 <strong>最大幻方</strong> 的 <strong>尺寸</strong> （即边长 <code>k</code>）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/magicsquare-grid.jpg" style="width: 413px; height: 335px;">
<pre><b>输入：</b>grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
<b>输出：</b>3
<b>解释：</b>最大幻方尺寸为 3 。
每一行，每一列以及两条对角线的和都等于 12 。
- 每一行的和：5+1+6 = 5+4+3 = 2+7+3 = 12
- 每一列的和：5+5+2 = 1+4+7 = 6+3+3 = 12
- 对角线的和：5+4+3 = 6+4+2 = 12
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/magicsquare2-grid.jpg" style="width: 333px; height: 255px;">
<pre><b>输入：</b>grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
<b>输出：</b>2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        def f(x, y, k):
            rows = [0] * k
            cols = [0] * k
            diagonal = [0] * 2
            for i in range(x, x + k):
                for j in range(y, y + k):
                    v = grid[i][j]
                    if i - x == j - y:
                        diagonal[0] += v
                    if i - x + j - y + 1 == k:
                        diagonal[1] += v
                    rows[i - x] += v
                    cols[j - y] += v
            t = rows[0]
            for i in range(k):
                if rows[i] != t or cols[i] != t:
                    return False
            return diagonal[0] == diagonal[1] == t



        m, n = len(grid), len(grid[0])
        for k in range(min(m, n), 1, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    if f(i, j, k):
                        return k
        return 1
```
### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**

```

```

<!-- tabs:end -->
