# [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个仅包含 <code>0</code> 和 <code>1</code> 、大小为 <code>rows x cols</code> 的二维二进制矩阵，找出只包含 <code>1</code> 的最大矩形，并返回其面积。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;" />
<pre>
<strong>输入：</strong>matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
<strong>输出：</strong>6
<strong>解释：</strong>最大矩形如上图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = []
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["0"]]
<strong>输出：</strong>0
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["1"]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>matrix = [["0","0"]]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[0].length</code></li>
	<li><code>0 <= row, cols <= 200</code></li>
	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        def max_area(hs):
            hs.append(-1)
            ans = 0
            q = []
            for i, v in enumerate(hs):
                while q and hs[q[-1]] > v:
                    h = hs[q.pop()]
                    l = q[-1] if q else -1
                    ans = max(ans, (i - 1 - l) * h)
                q.append(i)
            return ans

        n, m = len(matrix), len(matrix[0])
        g = [[0] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '1':
                    last = g[i - 1][j] if i > 0 else 0
                    g[i][j] = last + 1
        ans = 0
        for i in range(n):
            ans = max(ans, max_area(g[i]))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] g = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    g[i][j] = i > 0 ? g[i - 1][j] + 1 : 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxArea(g[i]));
        }
        return ans;
    }

    public int maxArea(int[] hs) {
        int ans = 0;
        hs[hs.length - 1] = -1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < hs.length; i++) {
            while (!q.isEmpty() && hs[q.peekLast()] > hs[i]) {
                int h = hs[q.pollLast()];
                int l = q.isEmpty() ? -1 : q.peekLast();
                ans = Math.max(ans, (i - 1 - l) * h);
            }
            q.addLast(i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
