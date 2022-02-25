# [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>m</code> 行 <code>n</code> 列的矩阵 <code>matrix</code> ，请按照 <strong>顺时针螺旋顺序</strong> ，返回矩阵中的所有元素。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
<strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 <= m, n <= 10</code></li>
	<li><code>-100 <= matrix[i][j] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        m, n = len(matrix), len(matrix[0])
        row, col = set(), set()
        ans = []
        x = y = d = 0
        while len(ans) < m * n:
            while x not in row and y not in col:
                ans.append(matrix[x][y])
                x += dirs[d][0]
                y += dirs[d][1]
                if x < 0 or x >= m or y < 0 or y >= n or x in row or y in col:
                    x -= dirs[d][0]
                    y -= dirs[d][1]
                    break
            if dirs[d][0] == 0:
                row.add(x)
            else:
                col.add(y)
            d = 0 if d == 3 else d + 1
            x += dirs[d][0]
            y += dirs[d][1]
        return ans       
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int dir = 0;
        int x = 0, y = 0;
        while (ans.size() < m * n) {
            while (!row.contains(x) && !col.contains(y)) {
                ans.add(matrix[x][y]);
                x += dirs[dir][0];
                y += dirs[dir][1];
                if (x < 0 || x >= m || y < 0 || y >= n || row.contains(x) || col.contains(y)) {
                    x -= dirs[dir][0];
                    y -= dirs[dir][1];
                    break;
                }
            }
            if (dirs[dir][0] == 0) {
                row.add(x);
            } else {
                col.add(y);
            }
            dir = dir == 3 ? 0 : dir + 1;
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
