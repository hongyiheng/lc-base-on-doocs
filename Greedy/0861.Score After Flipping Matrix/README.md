# [861. 翻转矩阵后的得分](https://leetcode-cn.com/problems/score-after-flipping-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个二维矩阵&nbsp;<code>A</code> 其中每个元素的值为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code>&nbsp;。</p>

<p>移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 <code>0</code> 都更改为 <code>1</code>，将所有 <code>1</code> 都更改为 <code>0</code>。</p>

<p>在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。</p>

<p>返回尽可能高的分数。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
<strong>输出：</strong>39
<strong>解释：
</strong>转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 20</code></li>
	<li><code>1 &lt;= A[0].length &lt;= 20</code></li>
	<li><code>A[i][j]</code>&nbsp;是&nbsp;<code>0</code> 或&nbsp;<code>1</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        def reverse_row(i):
            for j in range(n):
                grid[i][j] ^= 1

        def reverse_col(j):
            for i in range(m):
                grid[i][j] ^= 1

        m, n = len(grid), len(grid[0])
        for i in range(m):
            if not grid[i][0]:
                reverse_row(i)
        for j in range(n):
            cnt = 0
            for i in range(m):
                cnt += grid[i][j]
            if cnt < m / 2:
                reverse_col(j)
        ans = 0
        for i in range(m):
            for j in range(n):
                if not grid[i][j]:
                    continue
                ans += 1 << (n - j - 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                grid[i][j] ^= 1;
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt * 2 >= m) {
               continue;
            }
            for (int i = 0; i < m; i++) {
                grid[i][j] ^= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += 1 << (n - j - 1);
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
