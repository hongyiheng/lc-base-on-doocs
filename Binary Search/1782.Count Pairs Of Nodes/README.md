# [1782. 统计点对的数目](https://leetcode-cn.com/problems/count-pairs-of-nodes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个无向图，无向图由整数 <code>n</code>  ，表示图中节点的数目，和 <code>edges</code> 组成，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code><sub> </sub>之间有一条无向边。同时给你一个代表查询的整数数组 <code>queries</code> 。</p>

<p>第 <code>j</code> 个查询的答案是满足如下条件的点对 <code>(a, b)</code> 的数目：</p>

<ul>
	<li><code>a < b</code></li>
	<li><code>cnt</code> 是与 <code>a</code> <strong>或者 </strong><code>b</code> 相连的边的数目，且 <code>cnt</code> <strong>严格大于 </strong><code>queries[j]</code> 。</li>
</ul>

<p>请你返回一个数组 <code>answers</code> ，其中 <code>answers.length == queries.length</code> 且 <code>answers[j]</code> 是第 <code>j</code> 个查询的答案。</p>

<p>请注意，图中可能会有 <strong>重复边</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://pic.leetcode-cn.com/1614828447-GMnLVg-image.png" style="width: 310px; height: 278px;" />
<pre>
<b>输入：</b>n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
<b>输出：</b>[6,5]
<b>解释：</b>每个点对中，与至少一个点相连的边的数目如上图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
<b>输出：</b>[10,10,9,8,6]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= n <= 2 * 10<sup>4</sup></code></li>
	<li><code>1 <= edges.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
	<li><code>u<sub>i </sub>!= v<sub>i</sub></code></li>
	<li><code>1 <= queries.length <= 20</code></li>
	<li><code>0 <= queries[j] < edges.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        M = 20010
        cnt = [0] * (n + 1)
        g = defaultdict(int)
        for u, v in edges:
            cnt[u] += 1
            cnt[v] += 1
            g[(min(u, v) * M + max(u, v))] += 1
        s = sorted(cnt)
        ans = [0] * len(queries)
        for i, t in enumerate(queries):
            for j in range(1, len(s)):
                l, r = j + 1, len(s)
                while l < r:
                    mid = (l + r) >> 1
                    if s[j] + s[mid] <= t:
                        l = mid + 1
                    else:
                        r = mid
                ans[i] += n - l + 1
            for k, v in g.items():
                a, b = k // M, k % M
                if cnt[a] + cnt[b] > t and cnt[a] + cnt[b] - v <= t:
                    ans[i] -= 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int M = 20010;
        int[] cnt = new int[n + 1];
        Map<Integer, Integer> g = new HashMap<>();
        for (int[] e : edges) {
            int u = Math.min(e[0], e[1]);
            int v = Math.max(e[0], e[1]);
            cnt[u]++;
            cnt[v]++;
            int k = u * M + v;
            g.put(k, g.getOrDefault(k, 0) + 1);
        }
        int[] s = cnt.clone();
        Arrays.sort(s);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int t = queries[i];
            for (int j = 1; j < n + 1; j++) {
                int l = j + 1, r = n + 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (s[j] + s[mid] <= t) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans[i] += n - l + 1;
            }
            for (Map.Entry<Integer, Integer> entry : g.entrySet()) {
                int a = entry.getKey() / M, b = entry.getKey() % M;
                int v = entry.getValue();
                if (cnt[a] + cnt[b] > t && cnt[a] + cnt[b] - v <= t) {
                    ans[i]--;
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
