# [1914. 循环轮转矩阵](https://leetcode-cn.com/problems/cyclically-rotating-a-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个大小为 <code>m x n</code> 的整数矩阵 <code>grid</code>​​​ ，其中 <code>m</code> 和 <code>n</code> 都是 <strong>偶数</strong> ；另给你一个整数 <code>k</code> 。</p>

<p>矩阵由若干层组成，如下图所示，每种颜色代表一层：</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid.png" style="width: 231px; height: 258px;"></p>

<p>矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 <strong>逆时针 </strong>方向的相邻元素。轮转示例如下：</p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/explanation_grid.jpg" style="width: 500px; height: 268px;">
<p>返回执行 <code>k</code> 次循环轮转操作后的矩阵。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/19/rod2.png" style="width: 421px; height: 191px;">
<pre><strong>输入：</strong>grid = [[40,10],[30,20]], k = 1
<strong>输出：</strong>[[10,20],[40,30]]
<strong>解释：</strong>上图展示了矩阵在执行循环轮转操作时每一步的状态。</pre>

<p><strong>示例 2：</strong></p>
<strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid5.png" style="width: 231px; height: 262px;"></strong> <strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid6.png" style="width: 231px; height: 262px;"></strong> <strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid7.png" style="width: 231px; height: 262px;"></strong>

<pre><strong>输入：</strong>grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
<strong>输出：</strong>[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
<strong>解释：</strong>上图展示了矩阵在执行循环轮转操作时每一步的状态。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 50</code></li>
	<li><code>m</code> 和 <code>n</code> 都是 <strong>偶数</strong></li>
	<li><code>1 &lt;= grid[i][j] &lt;=<sup> </sup>5000</code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        def rotate(x1, y1, x2, y2):
            nonlocal k
            q = []
            for j in range(y1, y2 + 1):
                q.append(grid[x1][j])
            for i in range(x1 + 1, x2):
                q.append(grid[i][y2])
            for j in range(y2, y1 - 1, -1):
                q.append(grid[x2][j])
            for i in range(x2 - 1, x1, -1):
                q.append(grid[i][y1])
            n = len(q)
            idx = k % n
            for j in range(y1, y2 + 1):
                grid[x1][j] = q[idx % n]
                idx += 1
            for i in range(x1 + 1, x2):
                grid[i][y2] = q[idx % n]
                idx += 1
            for j in range(y2, y1 - 1, -1):
                grid[x2][j] = q[idx % n]
                idx += 1
            for i in range(x2 - 1, x1, -1):
                grid[i][y1] = q[idx % n]
                idx += 1

        m, n = len(grid), len(grid[0])
        x1, y1, x2, y2 = 0, 0, m - 1, n - 1
        while x1 < x2 and y1 < y2:
            rotate(x1, y1, x2, y2)
            x1 += 1
            y1 += 1
            x2 -= 1
            y2 -= 1
        return grid
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    int[][] grid;
    int k;

    public void rotate(int x1, int y1, int x2, int y2) {
        List<Integer> q = new ArrayList<>();
        for (int j = y1; j <= y2; j++) {
            q.add(grid[x1][j]);
        }
        for (int i = x1 + 1; i < x2; i++) {
            q.add(grid[i][y2]);
        }
        for (int j = y2; j >= y1; j--) {
            q.add(grid[x2][j]);
        }
        for (int i = x2 - 1; i > x1; i--) {
            q.add(grid[i][y1]);
        }
        int n = q.size();
        int idx = k % n;
        for (int j = y1; j <= y2; j++) {
            grid[x1][j] = q.get(idx++ % n);
        }
        for (int i = x1 + 1; i < x2; i++) {
            grid[i][y2] = q.get(idx++ % n);
        }
        for (int j = y2; j >= y1; j--) {
            grid[x2][j] = q.get(idx++ % n);
        }
        for (int i = x2 - 1; i > x1; i--) {
            grid[i][y1] = q.get(idx++ % n);
        }
    }


    public int[][] rotateGrid(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        int x1 = 0, y1 = 0, x2 = grid.length - 1, y2 = grid[0].length - 1;
        while (x1 < x2 && y1 < y2) {
            rotate(x1, y1, x2, y2);
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return grid;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
