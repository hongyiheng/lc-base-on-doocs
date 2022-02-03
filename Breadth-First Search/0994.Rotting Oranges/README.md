# [994. 腐烂的橘子](https://leetcode-cn.com/problems/rotting-oranges)



## 题目描述

<!-- 这里写题目描述 -->

<p>在给定的网格中，每个单元格可以有以下三个值之一：</p>

<ul>
	<li>值&nbsp;<code>0</code>&nbsp;代表空单元格；</li>
	<li>值&nbsp;<code>1</code>&nbsp;代表新鲜橘子；</li>
	<li>值&nbsp;<code>2</code>&nbsp;代表腐烂的橘子。</li>
</ul>

<p>每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。</p>

<p>返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/oranges.png" style="height: 150px; width: 712px;"></strong></p>

<pre><strong>输入：</strong>[[2,1,1],[1,1,0],[0,1,1]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[2,1,1],[0,1,1],[1,0,1]]
<strong>输出：</strong>-1
<strong>解释：</strong>左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[[0,2]]
<strong>输出：</strong>0
<strong>解释：</strong>因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= grid.length &lt;= 10</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 10</code></li>
	<li><code>grid[i][j]</code> 仅为&nbsp;<code>0</code>、<code>1</code>&nbsp;或&nbsp;<code>2</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        List<int[]> temp = new ArrayList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty() || !temp.isEmpty()) {
            if (q.isEmpty()) {
                q.addAll(temp);
                temp.clear();
                ans++;
            }
            int[] cur = q.pollFirst();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    temp.add(new int[]{nx, ny});
                    count--;
                }
            }
        }
        return count == 0 ? ans : -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
