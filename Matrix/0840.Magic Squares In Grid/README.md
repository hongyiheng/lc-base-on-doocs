# [840. 矩阵中的幻方](https://leetcode-cn.com/problems/magic-squares-in-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>3 x 3 的幻方是一个填充有<strong>从 1 到 9</strong> 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。</p>

<p>给定一个由整数组成的 <code>grid</code>，其中有多少个 3 &times; 3 的 &ldquo;幻方&rdquo; 子矩阵？（每个子矩阵都是连续的）。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入: </strong>[[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
<strong>输出: </strong>1
<strong>解释: </strong>
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276

而这一个不是：
384
519
762

总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
</pre>

<p><strong>提示:</strong></p>

<ol>
	<li><code>1 &lt;= grid.length&nbsp;&lt;= 10</code></li>
	<li><code>1 &lt;= grid[0].length&nbsp;&lt;= 10</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 15</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        def check(x, y):
            nonlocal m, n
            if x == 0 or x == m - 1 or y == 0 or y == n - 1:
                return False 
            msk = 0
            t = grid[x - 1][y - 1] + grid[x][y] + grid[x + 1][y + 1]
            for i in range(-1, 2):
                for j in range(-1, 2):
                    msk |= 1 << grid[x + i][y + j]
                if grid[x - 1][y + i] + grid[x][y + i] + grid[x + 1][y + i] != t:
                    return False
                if grid[x + i][y - 1] + grid[x + i][y] + grid[x + i][y + 1] != t:
                    return False
            return msk == (1 << 10) - 2 and grid[x - 1][y + 1] + grid[x][y] + grid[x + 1][y - 1] == t

        m, n = len(grid), len(grid[0])
        ans = 0
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                ans += (1 if check(i, j) else 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**

```

```

<!-- tabs:end -->
