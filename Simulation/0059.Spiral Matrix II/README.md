# [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code> ，生成一个包含 <code>1</code> 到 <code>n<sup>2</sup></code> 所有元素，且元素按顺时针顺序螺旋排列的 <code>n x n</code> 正方形矩阵 <code>matrix</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>[[1,2,3],[8,9,4],[7,6,5]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>[[1]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 20</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        ans = [[0] * n for _ in range(n)]
        ds = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        x, y, v = 0, -1, 1
        while v <= n * n:
            for d in ds:
                nx, ny = x + d[0], y + d[1]
                f = False
                while 0 <= nx < n and 0 <= ny < n and ans[nx][ny] == 0:
                    f = True
                    ans[nx][ny] = v
                    v += 1
                    nx += d[0]
                    ny += d[1]
                if f:
                    x, y = nx - d[0], ny - d[1]
                    break
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] ds = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, - 1}};
        int x = 0, y = -1, v = 1;
        while (v <= n * n) {
            for (int[] d : ds) {
                int nx = x + d[0], ny = y + d[1];
                boolean f = false;
                while (0 <= nx && nx < n && 0 <= ny && ny < n && ans[nx][ny] == 0) {
                    f = true;
                    ans[nx][ny] = v++;
                    nx += d[0];
                    ny += d[1];
                }
                if (f) {
                    x = nx - d[0];
                    y = ny - d[1];
                    break;
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
