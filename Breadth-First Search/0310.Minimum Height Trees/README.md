# [310. 最小高度树](https://leetcode-cn.com/problems/minimum-height-trees)



## 题目描述

<!-- 这里写题目描述 -->

<p>树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。</p>

<p>给你一棵包含 <code>n</code> 个节点的树，标记为 <code>0</code> 到 <code>n - 1</code> 。给定数字 <code>n</code> 和一个有 <code>n - 1</code> 条无向边的 <code>edges</code> 列表（每一个边都是一对标签），其中 <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> 表示树中节点 <code>a<sub>i</sub></code> 和 <code>b<sub>i</sub></code> 之间存在一条无向边。</p>

<p>可选择树中任何一个节点作为根。当选择节点 <code>x</code> 作为根节点时，设结果树的高度为 <code>h</code> 。在所有可能的树中，具有最小高度的树（即，<code>min(h)</code>）被称为 <strong>最小高度树</strong> 。</p>

<p>请你找到所有的 <strong>最小高度树</strong> 并按 <strong>任意顺序</strong> 返回它们的根节点标签列表。</p>
树的 <strong>高度</strong> 是指根节点和叶子节点之间最长向下路径上边的数量。

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e1.jpg" style="width: 800px; height: 213px;" />
<pre>
<strong>输入：</strong>n = 4, edges = [[1,0],[1,2],[1,3]]
<strong>输出：</strong>[1]
<strong>解释：</strong>如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e2.jpg" style="width: 800px; height: 321px;" />
<pre>
<strong>输入：</strong>n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
<strong>输出：</strong>[3,4]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 1, edges = []
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>n = 2, edges = [[0,1]]
<strong>输出：</strong>[0,1]
</pre>

<p> </p>

<ul>
</ul>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 2 * 10<sup>4</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>0 <= a<sub>i</sub>, b<sub>i</sub> < n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>所有 <code>(a<sub>i</sub>, b<sub>i</sub>)</code> 互不相同</li>
	<li>给定的输入 <strong>保证</strong> 是一棵树，并且 <strong>不会有重复的边</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        ans = [0]
        if n == 1:
            return ans
        step = [0] * n
        mp = defaultdict(list)
        for e in edges:
            mp[e[0]].append(e[1])
            mp[e[1]].append(e[0])
            step[e[0]] += 1
            step[e[1]] += 1
        q = deque()
        for i, v in enumerate(step):
            if v == 1:
                q.append(i)
        while q:
            ans.clear()
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                ans.append(cur)
                ne = mp[cur]
                for v in ne:
                    step[v] -= 1
                    if step[v] == 1:
                        q.append(v)
        return ans


            
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] step = new int[n];
        Map<Integer, List<Integer>> head = new HashMap<>();
        for (int[] e : edges) {
            step[e[0]]++;
            step[e[1]]++;
            head.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            head.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (step[i] == 1) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            ans = new ArrayList<>();
            int m = q.size();
            while (m-- > 0) {
                int cur = q.pollFirst();
                ans.add(cur);
                List<Integer> next = head.get(cur);
                for (int node : next) {
                    step[node]--;
                    if (step[node] == 1) {
                        q.addLast(node);
                    }
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
