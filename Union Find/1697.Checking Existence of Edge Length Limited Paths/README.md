# [1697. 检查边长度限制的路径是否存在](https://leetcode-cn.com/problems/checking-existence-of-edge-length-limited-paths)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n</code> 个点组成的无向图边集 <code>edgeList</code> ，其中 <code>edgeList[i] = [u<sub>i</sub>, v<sub>i</sub>, dis<sub>i</sub>]</code> 表示点 <code>u<sub>i</sub></code> 和点 <code>v<sub>i</sub></code> 之间有一条长度为 <code>dis<sub>i</sub></code> 的边。请注意，两个点之间可能有 <strong>超过一条边 </strong>。</p>

<p>给你一个查询数组<code>queries</code> ，其中 <code>queries[j] = [p<sub>j</sub>, q<sub>j</sub>, limit<sub>j</sub>]</code> ，你的任务是对于每个查询 <code>queries[j]</code> ，判断是否存在从 <code>p<sub>j</sub></code> 到 <code>q<sub>j</sub></code><sub> </sub>的路径，且这条路径上的每一条边都 <strong>严格小于</strong> <code>limit<sub>j</sub></code> 。</p>

<p>请你返回一个 <b>布尔数组</b><em> </em><code>answer</code><em> </em>，其中<em> </em><code>answer.length == queries.length</code> ，当 <code>queries[j]</code> 的查询结果为 <code>true</code> 时， <code>answer</code> 第<em> </em><code>j</code> 个值为<em> </em><code>true</code><em> </em>，否则为 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/12/19/h.png" style="width: 267px; height: 262px;" />
<pre>
<b>输入：</b>n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
<b>输出：</b>[false,true]
<b>解释：</b>上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/12/19/q.png" style="width: 390px; height: 358px;" />
<pre>
<b>输入：</b>n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
<b>输出：</b>[true,false]
<b>解释：</b>上图为给定数据。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= n <= 10<sup>5</sup></code></li>
	<li><code>1 <= edgeList.length, queries.length <= 10<sup>5</sup></code></li>
	<li><code>edgeList[i].length == 3</code></li>
	<li><code>queries[j].length == 3</code></li>
	<li><code>0 <= u<sub>i</sub>, v<sub>i</sub>, p<sub>j</sub>, q<sub>j</sub> <= n - 1</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>p<sub>j</sub> != q<sub>j</sub></code></li>
	<li><code>1 <= dis<sub>i</sub>, limit<sub>j</sub> <= 10<sup>9</sup></code></li>
	<li>两个点之间可能有 <strong>多条</strong> 边。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        edgeList.sort(key=lambda x: x[2])
        queries = [(i, q[0], q[1], q[2]) for i, q in enumerate(queries)]
        queries.sort(key=lambda x: x[3])
        ans = [False] * len(queries)
        p = list(range(n))
        i = 0
        for j, u, v, w in queries:
            while i < len(edgeList) and edgeList[i][2] < w:
                p[find(edgeList[i][0])] = find(edgeList[i][1])
                i += 1
            ans[j] = find(u) == find(v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] p;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        int[][] qs = new int[m][4];
        for (int i = 0; i < m; i++) {
            qs[i][0] = i;
            qs[i][1] = queries[i][0];
            qs[i][2] = queries[i][1];
            qs[i][3] = queries[i][2];
        }
        Arrays.sort(qs, (a, b) -> a[3] - b[3]);
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        boolean[] ans = new boolean[m];
        int i = 0;
        for (int[] q : qs) {
            int j = q[0], u = q[1], v = q[2], limit = q[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                p[find(edgeList[i][0])] = find(edgeList[i][1]);
                i++;
            }
            ans[j] = find(u) == find(v);
        }
        return ans;
    }

    int find(int x) {
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
