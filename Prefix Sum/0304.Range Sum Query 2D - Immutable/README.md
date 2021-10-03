# [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable)

[English Version](/solution/0300-0399/0304.Range%20Sum%20Query%202D%20-%20Immutable/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p><big><small>给定一个二维矩阵 <code>matrix</code>，</small></big>以下类型的多个请求：</p>

<ul>
	<li><big><small>计算其子矩形范围内元素的总和，该子矩阵的左上角为 <code>(row1, col1)</code> ，右下角为 <code>(row2, col2)</code> 。</small></big></li>
</ul>

<p>实现 <code>NumMatrix</code> 类：</p>

<ul>
	<li><code>NumMatrix(int[][] matrix)</code> 给定整数矩阵 <code>matrix</code> 进行初始化</li>
	<li><code>int sumRegion(int row1, int col1, int row2, int col2)</code> 返回<big><small>左上角</small></big><big><small> <code>(row1, col1)</code> 、右下角 <code>(row2, col2)</code></small></big> 的子矩阵的元素总和。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img src="https://pic.leetcode-cn.com/1626332422-wUpUHT-image.png" style="width: 200px;" /></p>

<pre>
<strong>输入:</strong> 
["NumMatrix","sumRegion","sumRegion","sumRegion"]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
<strong>输出:</strong> 
[null, 8, 11, 12]

<strong>解释:</strong>
NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 <= m, n <= 200</code><meta charset="UTF-8" /></li>
	<li><code>-10<sup>5</sup> <= matrix[i][j] <= 10<sup>5</sup></code></li>
	<li><code>0 <= row1 <= row2 < m</code></li>
	<li><code>0 <= col1 <= col2 < n</code></li>
	<li><meta charset="UTF-8" />最多调用 <code>10<sup>4</sup></code> 次 <code>sumRegion</code> 方法</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        m = len(matrix)
        n = len(matrix[0])
        self.dp = [[0 for _ in range(n)] for _ in range(m)]
        _dp = self.dp
        print(_dp)
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    _dp[i][j] = matrix[i][j]
                elif i == 0:
                    _dp[i][j] = _dp[i][j - 1] + matrix[i][j]
                elif j == 0:
                    _dp[i][j] = _dp[i - 1][j] + matrix[i][j]
                else:
                    _dp[i][j] = _dp[i][j - 1] + _dp[i - 1][j] - _dp[i - 1][j - 1] + matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        _dp = self.dp
        print()
        if row1 == 0 and col1 == 0:
            return _dp[row2][col2]
        elif row1 == 0:
            return _dp[row2][col2] - _dp[row2][col1 - 1]
        elif col1 == 0:
            return _dp[row2][col2] - _dp[row1 - 1][col2]    
        return _dp[row2][col2] - _dp[row1 - 1][col2] - _dp[row2][col1 - 1] + _dp[row1 - 1][col1 - 1]



# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i][j] - dp[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return dp[row2][col2];
        } else if (row1 == 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        } else if (col1 == 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        }
        return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
```

### **...**

```

```

<!-- tabs:end -->
