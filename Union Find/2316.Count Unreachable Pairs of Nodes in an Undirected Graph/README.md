# [2316. 统计无向图中无法互相到达点对数](https://leetcode-cn.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数&nbsp;<code>n</code>&nbsp;，表示一张<strong>&nbsp;无向图</strong>&nbsp;中有 <code>n</code>&nbsp;个节点，编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;。同时给你一个二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;表示节点&nbsp;<code>a<sub>i</sub></code> 和&nbsp;<code>b<sub>i</sub></code>&nbsp;之间有一条&nbsp;<strong>无向</strong>&nbsp;边。</p>

<p>请你返回 <strong>无法互相到达</strong>&nbsp;的不同 <strong>点对数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-3.png" style="width: 267px; height: 169px;"></p>

<pre><b>输入：</b>n = 3, edges = [[0,1],[0,2],[1,2]]
<b>输出：</b>0
<b>解释：</b>所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-2.png" style="width: 295px; height: 269px;"></p>

<pre><b>输入：</b>n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
<b>输出：</b>14
<b>解释：</b>总共有 14 个点对互相无法到达：
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
所以我们返回 14 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>不会有重复边。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                cnt[r2] += cnt[r1]
                cnt[r1] = 0
                p[find(a)] = find(b)
           

        p = [i for i in range(n)]
        cnt = [1] * n
        for u, v in edges:
            union(u, v)
        ans = pre = 0
        for i in range(n):
            if p[i] != i:
                continue
            ans += pre * cnt[i]
            pre += cnt[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int[] p;
    int[] cnt;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    } 

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 != r2) {
            cnt[r2] += cnt[r1];
            cnt[r1] = 0;
            p[r1] = r2;
        }
    } 

    public long countPairs(int n, int[][] edges) {
        p = new int[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        long ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != i) {
                continue;
            }
            ans += pre * cnt[i];
            pre += cnt[i];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
