# [1329. 将矩阵按对角线排序](https://leetcode-cn.com/problems/sort-the-matrix-diagonally)



## 题目描述

<!-- 这里写题目描述 -->

<p><strong>矩阵对角线</strong> 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 <code>mat</code> 有 <code>6</code> 行 <code>3</code> 列，从 <code>mat[2][0]</code> 开始的 <strong>矩阵对角线</strong> 将会经过 <code>mat[2][0]</code>、<code>mat[3][1]</code> 和 <code>mat[4][2]</code> 。</p>

<p>给你一个 <code>m * n</code> 的整数矩阵 <code>mat</code> ，请你将同一条 <strong>矩阵对角线 </strong>上的元素按升序排序后，返回排好序的矩阵。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/25/1482_example_1_2.png" style="height: 198px; width: 500px;" /></p>

<pre>
<strong>输入：</strong>mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
<strong>输出：</strong>[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
<strong>输出：</strong>[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 <= m, n <= 100</code></li>
	<li><code>1 <= mat[i][j] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        def reset(i, j):
            nonlocal m, n
            q = []
            x, y = i, j
            while x < m and y < n:
                q.append(mat[x][y])
                x += 1
                y += 1
            q.sort(reverse=True)
            x, y = i, j
            while x < m and y < n:
                mat[x][y] = q.pop()
                x += 1
                y += 1

        m, n = len(mat), len(mat[0])
        for i in range(1, m):
            reset(i, 0)
        for j in range(n):
            reset(0, j)
        return mat
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int m, n;

    public void reset(int[][] mat, int i, int j) {
        List<Integer> q = new ArrayList<>();
        int x = i, y = j;
        while (x < m && y < n) {
            q.add(mat[x++][y++]);
        }
        Collections.sort(q, (a, b) -> a - b);
        x = i;
        y = j;
        int idx = 0;
        while (x < m && y < n) {
            mat[x++][y++] = q.get(idx++); 
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 1; i < m; i++) {
            reset(mat, i, 0);
        }
        for (int j = 0; j < n; j++) {
            reset(mat, 0, j);
        }
        return mat;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
