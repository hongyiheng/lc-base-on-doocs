# [498. 对角线遍历](https://leetcode-cn.com/problems/diagonal-traverse)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

<strong>输出:</strong>  [1,2,4,7,5,3,6,8,9]

<strong>解释:</strong>
<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/diagonal_traverse.png" style="width: 220px;">
</pre>

<p>&nbsp;</p>

<p><strong>说明:</strong></p>

<ol>
	<li>给定矩阵中的元素总数不会超过 100000 。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        ans = []
        m, n = len(mat), len(mat[0])
        x = y = 0
        up = True
        for _ in range(m * n):
            ans.append(mat[x][y])
            nx, ny = x, y
            nx += -1 if up else 1
            ny += 1 if up else -1
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                nx, ny = x, y
                if up:
                    if y == n - 1:
                        nx += 1
                    else:
                        ny += 1
                else:
                    if x == m - 1:
                        ny += 1
                    else:
                        nx += 1
                up = not up
            x, y = nx, ny
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int x = 0, y = 0, idx = 0;
        boolean up = true;
        for (int i = 0; i < m * n; i++) {
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            nx += up? -1 : 1;
            ny += up? 1 : -1;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                nx = x;
                ny = y;
                if (up) {
                    if (ny == n - 1) {
                        nx += 1;
                    } else {
                        ny += 1;
                    }
                } else {
                    if (nx == m - 1) {
                        ny += 1;
                    } else {
                        nx += 1;
                    }
                }
                up = !up;
            }
            x = nx;
            y = ny;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
