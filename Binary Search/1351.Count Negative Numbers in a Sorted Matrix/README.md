# [1351. 统计有序矩阵中的负数](https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>m * n</code> 的矩阵 <code>grid</code>，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 </p>

<p>请你统计并返回 <code>grid</code> 中 <strong>负数</strong> 的数目。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
<strong>输出：</strong>8
<strong>解释：</strong>矩阵中共有 8 个负数。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [[3,2],[1,0]]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>grid = [[1,-1],[-1,-1]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>grid = [[-1]]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 <= m, n <= 100</code></li>
	<li><code>-100 <= grid[i][j] <= 100</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(n + m)</code> 的解决方案吗？</p>

<p> </p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        ans, n = 0, len(grid[0])
        for row in grid:
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if row[mid] >= 0:
                    left = mid + 1
                else:
                    right = mid
            if row[left] < 0:
                ans += n - left
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int n = grid[0].length;
        for (int[] row : grid) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (row[left] < 0) {
                ans += n - left;
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
