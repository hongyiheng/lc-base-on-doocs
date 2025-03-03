# [3402. 使每一列严格递增的最少操作次数](https://leetcode.cn/problems/minimum-operations-to-make-columns-strictly-increasing)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由&nbsp;<b>非负&nbsp;</b>整数组成的 <code>m x n</code> 矩阵 <code>grid</code>。</p>

<p>在一次操作中，你可以将任意元素 <code>grid[i][j]</code> 的值增加 1。</p>

<p>返回使 <code>grid</code> 的所有列&nbsp;<strong>严格递增&nbsp;</strong>所需的&nbsp;<strong>最少&nbsp;</strong>操作次数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">grid = [[3,2],[1,3],[3,4],[0,1]]</span></p>

<p><strong>输出:</strong> <span class="example-io">15</span></p>

<p><strong>解释:</strong></p>

<ul>
	<li>为了让第 <code>0</code>&nbsp;列严格递增，可以对 <code>grid[1][0]</code> 执行 3 次操作，对 <code>grid[2][0]</code> 执行 2 次操作，对 <code>grid[3][0]</code> 执行 6 次操作。</li>
	<li>为了让第 <code>1</code>&nbsp;列严格递增，可以对 <code>grid[3][1]</code> 执行 4 次操作。</li>
</ul>
<img alt="" src="https://assets.leetcode.com/uploads/2024/11/10/firstexample.png" style="width: 200px; height: 347px;" /></div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">grid = [[3,2,1],[2,1,0],[1,2,3]]</span></p>

<p><strong>输出:</strong> <span class="example-io">12</span></p>

<p><strong>解释:</strong></p>

<ul>
	<li>为了让第 <code>0</code>&nbsp;列严格递增，可以对 <code>grid[1][0]</code> 执行 2 次操作，对 <code>grid[2][0]</code> 执行 4 次操作。</li>
	<li>为了让第 <code>1</code>&nbsp;列严格递增，可以对 <code>grid[1][1]</code> 执行 2 次操作，对 <code>grid[2][1]</code> 执行 2 次操作。</li>
	<li>为了让第 <code>2</code>&nbsp;列严格递增，可以对 <code>grid[1][2]</code> 执行 2 次操作。</li>
</ul>
<img alt="" src="https://assets.leetcode.com/uploads/2024/11/10/secondexample.png" style="width: 300px; height: 257px;" /></div>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt; 2500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        ans = 0
        for j in range(len(grid[0])):
            for i in range(1, len(grid)):
                pre, v = grid[i - 1][j], grid[i][j]
                if v <= pre:
                    ans += pre - v + 1
                    grid[i][j] = pre + 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length; i++) {
                int pre = grid[i - 1][j], v = grid[i][j];
                if (pre >= v) {
                    ans += pre - v + 1;
                    grid[i][j] = pre + 1;
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
