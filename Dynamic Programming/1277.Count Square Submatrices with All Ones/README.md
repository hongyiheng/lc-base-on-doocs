# [1277. 统计全为 1 的正方形子矩阵](https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>m * n</code>&nbsp;的矩阵，矩阵中的元素不是 <code>0</code> 就是 <code>1</code>，请你统计并返回其中完全由 <code>1</code> 组成的 <strong>正方形</strong> 子矩阵的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>matrix =
[
&nbsp; [0,1,1,1],
&nbsp; [1,1,1,1],
&nbsp; [0,1,1,1]
]
<strong>输出：</strong>15
<strong>解释：</strong> 
边长为 1 的正方形有 <strong>10</strong> 个。
边长为 2 的正方形有 <strong>4</strong> 个。
边长为 3 的正方形有 <strong>1</strong> 个。
正方形的总数 = 10 + 4 + 1 = <strong>15</strong>.
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
<strong>输出：</strong>7
<strong>解释：</strong>
边长为 1 的正方形有 <strong>6</strong> 个。 
边长为 2 的正方形有 <strong>1</strong> 个。
正方形的总数 = 6 + 1 = <strong>7</strong>.
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length&nbsp;&lt;= 300</code></li>
	<li><code>1 &lt;= arr[0].length&nbsp;&lt;= 300</code></li>
	<li><code>0 &lt;= arr[i][j] &lt;= 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        f = [[0] * (n + 1) for _ in range(m + 1)]
        ans = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1]:
                    f[i][j] = min(f[i - 1][j - 1], f[i - 1][j], f[i][j - 1]) + 1
                    ans += f[i][j]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] f = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    ans += f[i][j];
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
