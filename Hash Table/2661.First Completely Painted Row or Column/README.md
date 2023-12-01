# [2661. 找出叠涂元素](https://leetcode-cn.com/problems/first-completely-painted-row-or-column)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>arr</code> 和一个 <code>m x n</code> 的整数 <strong>矩阵</strong> <code>mat</code> 。<code>arr</code> 和 <code>mat</code> 都包含范围 <code>[1，m * n]</code> 内的 <strong>所有</strong> 整数。</p>

<p>从下标 <code>0</code> 开始遍历 <code>arr</code> 中的每个下标 <code>i</code> ，并将包含整数 <code>arr[i]</code> 的 <code>mat</code> 单元格涂色。</p>

<p>请你找出 <code>arr</code> 中在 <code>mat</code> 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 <code>i</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="image explanation for example 1" src="https://assets.leetcode.com/uploads/2023/01/18/grid1.jpg" style="width: 321px; height: 81px;" />
<pre>
<strong>输入：</strong>arr = [1,3,4,2], mat = [[1,4],[2,3]]
<strong>输出：</strong>2
<strong>解释：</strong>遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="image explanation for example 2" src="https://assets.leetcode.com/uploads/2023/01/18/grid2.jpg" style="width: 601px; height: 121px;" />
<pre>
<strong>输入：</strong>arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
<strong>输出：</strong>3
<strong>解释：</strong>遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n = mat[i].length</code></li>
	<li><code>arr.length == m * n</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i], mat[r][c] &lt;= m * n</code></li>
	<li><code>arr</code> 中的所有整数 <strong>互不相同</strong></li>
	<li><code>mat</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        g = dict()
        for i in range(m):
            for j in range(n):
                g[mat[i][j]] = (i, j)
        row, col = [0] * m, [0] * n
        for i, v in enumerate(arr):
            x, y = g[v]
            row[x] += 1
            col[y] += 1
            if row[x] == n or col[y] == m:
                return i
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Integer> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.put(mat[i][j], i * n + j);
            }
        }
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m * n; i++) {
            int v = g.get(arr[i]);
            int x = v / n, y = v % n;
            if (++row[x] == n || ++col[y] == m) {
                return i;
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
