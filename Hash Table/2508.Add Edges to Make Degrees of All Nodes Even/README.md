# [2508. 添加边使所有节点度数都为偶数](https://leetcode-cn.com/problems/add-edges-to-make-degrees-of-all-nodes-even)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个有 <code>n</code>&nbsp;个节点的 <strong>无向</strong>&nbsp;图，节点编号为&nbsp;<code>1</code>&nbsp;到&nbsp;<code>n</code>&nbsp;。再给你整数&nbsp;<code>n</code>&nbsp;和一个二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;表示节点&nbsp;<code>a<sub>i</sub></code> 和&nbsp;<code>b<sub>i</sub></code>&nbsp;之间有一条边。图不一定连通。</p>

<p>你可以给图中添加 <strong>至多</strong>&nbsp;两条额外的边（也可以一条边都不添加），使得图中没有重边也没有自环。</p>

<p>如果添加额外的边后，可以使得图中所有点的度数都是偶数，返回&nbsp;<code>true</code>&nbsp;，否则返回&nbsp;<code>false</code>&nbsp;。</p>

<p>点的度数是连接一个点的边的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/10/26/agraphdrawio.png" style="width: 500px; height: 190px;" /></p>

<pre>
<b>输入：</b>n = 5, edges = [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]
<b>输出：</b>true
<b>解释：</b>上图展示了添加一条边的合法方案。
最终图中每个节点都连接偶数条边。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/10/26/aagraphdrawio.png" style="width: 400px; height: 120px;" /></p>

<pre>
<b>输入：</b>n = 4, edges = [[1,2],[3,4]]
<b>输出：</b>true
<b>解释：</b>上图展示了添加两条边的合法方案。</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/10/26/aaagraphdrawio.png" style="width: 150px; height: 158px;" /></p>

<pre>
<b>输入：</b>n = 4, edges = [[1,2],[1,3],[1,4]]
<b>输出：</b>false
<b>解释：</b>无法添加至多 2 条边得到一个符合要求的图。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>2 &lt;= edges.length &lt;= 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>图中不会有重边</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isPossible(self, n: int, edges: List[List[int]]) -> bool:
        mp = defaultdict(set)
        for u, v in edges:
            mp[u].add(v)
            mp[v].add(u)
        odd = [k for k in mp.keys() if len(mp[k]) % 2]
        m = len(odd)
        if m == 0:
            return True
        elif m == 2:
            a, b = odd
            if b not in mp[a] and a not in mp[b]:
                return True
            for c in range(1, n + 1):
                if c == a or c == b:
                    continue
                if a not in mp[c] and b not in mp[c]:
                    return True
        elif m == 4:
            a, b, c, d = odd
            if b not in mp[a] and a not in mp[b] and c not in mp[d] and d not in mp[c]:
                return True
            if c not in mp[a] and a not in mp[c] and b not in mp[d] and d not in mp[b]:
                return True
            if d not in mp[a] and a not in mp[d] and b not in mp[c] and c not in mp[b]:
                return True
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (List<Integer> e : edges) {
            mp.computeIfAbsent(e.get(0), k -> new HashSet<>()).add(e.get(1));
            mp.computeIfAbsent(e.get(1), k -> new HashSet<>()).add(e.get(0));
        }
        List<Integer> odd = new ArrayList<>();
        for (var entry : mp.entrySet()) {
            if (entry.getValue().size() % 2 != 0) {
                odd.add(entry.getKey());
            }
        }
        int m = odd.size();
        if (m == 0) {
            return true;
        } else if (m == 2) {
            int a = odd.get(0), b = odd.get(1);
            if (!mp.get(b).contains(a) && !mp.get(a).contains(b)) {
                return true;
            }
            for (int i = 1; i <= n; i++) {
                Set<Integer> s = mp.getOrDefault(i, new HashSet<>());
                if (!s.contains(a) && !s.contains(b)) {
                    return true;
                }
            }
        } else if (m == 4) {
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);
            if (!mp.get(b).contains(a) && !mp.get(a).contains(b) && !mp.get(c).contains(d) && !mp.get(d).contains(c)) {
                return true;
            }
            if (!mp.get(c).contains(a) && !mp.get(a).contains(c) && !mp.get(b).contains(d) && !mp.get(d).contains(b)) {
                return true;
            }
            if (!mp.get(d).contains(a) && !mp.get(a).contains(d) && !mp.get(b).contains(c) && !mp.get(c).contains(b)) {
                return true;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
