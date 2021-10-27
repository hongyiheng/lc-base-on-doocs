# [1631. 最小体力消耗路径](https://leetcode-cn.com/problems/path-with-minimum-effort)

[English Version](/solution/1600-1699/1631.Path%20With%20Minimum%20Effort/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>你准备参加一场远足活动。给你一个二维 <code>rows x columns</code> 的地图 <code>heights</code> ，其中 <code>heights[row][col]</code> 表示格子 <code>(row, col)</code> 的高度。一开始你在最左上角的格子 <code>(0, 0)</code> ，且你希望去最右下角的格子 <code>(rows-1, columns-1)</code> （注意下标从 <strong>0</strong> 开始编号）。你每次可以往 <strong>上</strong>，<strong>下</strong>，<strong>左</strong>，<strong>右</strong> 四个方向之一移动，你想要找到耗费 <strong>体力</strong> 最小的一条路径。</p>

<p>一条路径耗费的 <strong>体力值</strong> 是路径上相邻格子之间 <strong>高度差绝对值</strong> 的 <strong>最大值</strong> 决定的。</p>

<p>请你返回从左上角走到右下角的最小<strong> 体力消耗值</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex1.png" style="width: 300px; height: 300px;" /></p>

<pre>
<b>输入：</b>heights = [[1,2,2],[3,8,2],[5,3,5]]
<b>输出：</b>2
<b>解释：</b>路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex2.png" style="width: 300px; height: 300px;" /></p>

<pre>
<b>输入：</b>heights = [[1,2,3],[3,8,4],[5,3,5]]
<b>输出：</b>1
<b>解释：</b>路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex3.png" style="width: 300px; height: 300px;" />
<pre>
<b>输入：</b>heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
<b>输出：</b>0
<b>解释：</b>上图所示路径不需要消耗任何体力。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == heights.length</code></li>
	<li><code>columns == heights[i].length</code></li>
	<li><code>1 <= rows, columns <= 100</code></li>
	<li><code>1 <= heights[i][j] <= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        p = [i for i in range(m * n)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if r1 != r2:
                p[r1] = r2
        
        dic_list = list()
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if i < m - 1:
                    w = abs(heights[i][j] - heights[i + 1][j])
                    dic_list.append([index, index + n, w])
                if j < n - 1:
                    w = abs(heights[i][j] - heights[i][j + 1])
                    dic_list.append([index, index + 1, w])
        dic_list.sort(key=lambda elem: elem[2])
        start, end = 0, m * n - 1
        for item in dic_list:
            union(item[0], item[1])
            if find(start) == find(end):
                return item[2]
        return 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    List<int[]> list = new ArrayList<>();
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (i < m - 1) {
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    list.add(new int[]{index, index + n, w});
                }
                if (j < n - 1) {
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    list.add(new int[]{index, index + 1, w});
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o[2]));
        int start = 0; int end = m * n - 1;
        for (int[] edge : list) {
            union(edge[0], edge[1]);
            if (find(start) == find(end)) {
                return edge[2];
            }
        }
        return 0;
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
