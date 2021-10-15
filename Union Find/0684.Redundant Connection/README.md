# [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection)

[English Version](/solution/0600-0699/0684.Redundant%20Connection/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>树可以看成是一个连通且 <strong>无环 </strong>的 <strong>无向 </strong>图。</p>

<p>给定往一棵 <code>n</code> 个节点 (节点值 <code>1～n</code>) 的树中添加一条边后的图。添加的边的两个顶点包含在 <code>1</code> 到 <code>n</code> 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 <code>n</code> 的二维数组 <code>edges</code> ，<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> 表示图中在 <code>ai</code> 和 <code>bi</code> 之间存在一条边。</p>

<p>请找出一条可以删去的边，删除后可使得剩余部分是一个有着 <code>n</code> 个节点的树。如果有多个答案，则返回数组 <code>edges</code> 中最后出现的边。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626676174-hOEVUL-image.png" style="width: 152px; " /></p>

<pre>
<strong>输入:</strong> edges = [[1,2], [1,3], [2,3]]
<strong>输出:</strong> [2,3]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626676179-kGxcmu-image.png" style="width: 250px; " /></p>

<pre>
<strong>输入:</strong> edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
<strong>输出:</strong> [1,4]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>n == edges.length</code></li>
	<li><code>3 <= n <= 1000</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 <= ai < bi <= edges.length</code></li>
	<li><code>ai != bi</code></li>
	<li><code>edges</code> 中无重复元素</li>
	<li>给定的图是连通的 </li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        m = len(edges)
        p = [i for i in range(m + 1)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if (r1 != r2):
                p[r1] = r2

        for i in range(m):
            if find(edges[i][0]) != find(edges[i][1]):
                union(edges[i][0], edges[i][1])
            else:
                return edges[i]
                
        return edges[m - 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        p = new int[m + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return edges[m - 1];
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
