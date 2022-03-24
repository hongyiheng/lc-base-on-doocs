# [661. 图片平滑器](https://leetcode-cn.com/problems/image-smoother)



## 题目描述

<!-- 这里写题目描述 -->

<p>包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度&nbsp;(向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong>
[[1,1,1],
 [1,0,1],
 [1,1,1]]
<strong>输出:</strong>
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
<strong>解释:</strong>
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>给定矩阵中的整数范围为 [0, 255]。</li>
	<li>矩阵的长和宽的范围均为&nbsp;[1, 150]。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m, n = len(img), len(img[0])
        pre = [[0] * (n + 2) for _ in range(m + 2)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + img[i - 1][j - 1]
        ans = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                top = max(0, i - 1)
                bottom = min(m - 1, i + 1)
                left = max(0, j - 1)
                right = min(n - 1, j + 1)
                cnt = (bottom - top + 1) * (right - left + 1)
                val = pre[bottom + 1][right + 1] - pre[top][right + 1] - pre[bottom + 1][left] + pre[top][left]
                ans[i][j] = val // cnt
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] pre = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = Math.max(0, i - 1);
                int bottom = Math.min(m - 1, i + 1);
                int left = Math.max(0, j - 1);
                int right = Math.min(n - 1, j + 1);
                int cnt = (bottom - top + 1) * (right - left + 1);
                int val = pre[bottom + 1][right + 1] - pre[top][right + 1] - pre[bottom + 1][left] + pre[top][left];
                ans[i][j] = val / cnt;
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
