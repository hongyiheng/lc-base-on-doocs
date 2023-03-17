# [2397. 被列覆盖的最多行数](https://leetcode-cn.com/problems/maximum-rows-covered-by-columns)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的&nbsp;<code>m x n</code>&nbsp;二进制矩阵&nbsp;<code>mat</code>&nbsp;和一个整数&nbsp;<code>cols</code>&nbsp;，表示你需要选出的列数。</p>

<p>如果一行中，所有的 <code>1</code> 都被你选中的列所覆盖，那么我们称这一行 <strong>被覆盖</strong>&nbsp;了。</p>

<p>请你返回在选择 <code>cols</code>&nbsp;列的情况下，<strong>被覆盖</strong>&nbsp;的行数 <strong>最大</strong>&nbsp;为多少。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2022/07/14/rowscovered.png" style="width: 250px; height: 417px;"></strong></p>

<pre><b>输入：</b>mat = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], cols = 2
<b>输出：</b>3
<strong>解释：</strong>
如上图所示，覆盖 3 行的一种可行办法是选择第 0 和第 2 列。
可以看出，不存在大于 3 行被覆盖的方案，所以我们返回 3 。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2022/07/14/rowscovered2.png" style="width: 83px; height: 247px;"></strong></p>

<pre><b>输入：</b>mat = [[1],[0]], cols = 1
<b>输出：</b>2
<strong>解释：</strong>
选择唯一的一列，两行都被覆盖了，原因是整个矩阵都被覆盖了。
所以我们返回 2 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 12</code></li>
	<li><code>mat[i][j]</code>&nbsp;要么是&nbsp;<code>0</code>&nbsp;要么是&nbsp;<code>1</code>&nbsp;。</li>
	<li><code>1 &lt;= cols &lt;= n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        def bit_cnt(x):
            ans = 0
            while x:
                x -= x & - x
                ans += 1
            return ans

        m, n = len(matrix), len(matrix[0])
        row = [0] * m
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    row[i] |= (1 << j)
        ans = 0
        for i in range((1 << n) + 1):
            if bit_cnt(i) != numSelect:
                continue
            cnt = 0
            for r in row:
                if r | i == i:
                    cnt += 1
            ans = max(cnt, ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int bitCnt(int x) {
        int ans = 0;
        while (x > 0) {
            x -= x & -x;
            ans += 1;
        }
        return ans;
    }
    
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    row[i] |= (1 << j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n) + 1; i++) {
            if (bitCnt(i) != numSelect) {
                continue;
            }
            int cnt = 0;
            for (int r : row) {
                if ((r | i) == i) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
