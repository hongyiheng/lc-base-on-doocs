# [2392. 给定条件下构造矩阵](https://leetcode-cn.com/problems/build-a-matrix-with-conditions)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>正</strong>&nbsp;整数&nbsp;<code>k</code>&nbsp;，同时给你：</p>

<ul>
	<li>一个大小为 <code>n</code>&nbsp;的二维整数数组&nbsp;<code>rowConditions</code>&nbsp;，其中&nbsp;<code>rowConditions[i] = [above<sub>i</sub>, below<sub>i</sub>]</code>&nbsp;和</li>
	<li>一个大小为 <code>m</code>&nbsp;的二维整数数组&nbsp;<code>colConditions</code>&nbsp;，其中&nbsp;<code>colConditions[i] = [left<sub>i</sub>, right<sub>i</sub>]</code>&nbsp;。</li>
</ul>

<p>两个数组里的整数都是&nbsp;<code>1</code>&nbsp;到&nbsp;<code>k</code>&nbsp;之间的数字。</p>

<p>你需要构造一个&nbsp;<code>k x k</code>&nbsp;的矩阵，<code>1</code>&nbsp;到&nbsp;<code>k</code>&nbsp;每个数字需要&nbsp;<strong>恰好出现一次</strong>&nbsp;。剩余的数字都是<b>&nbsp;</b><code>0</code>&nbsp;。</p>

<p>矩阵还需要满足以下条件：</p>

<ul>
	<li>对于所有 <code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;之间的下标&nbsp;<code>i</code>&nbsp;，数字&nbsp;<code>above<sub>i</sub></code>&nbsp;所在的 <strong>行</strong>&nbsp;必须在数字&nbsp;<code>below<sub>i</sub></code>&nbsp;所在行的上面。</li>
	<li>对于所有 <code>0</code>&nbsp;到 <code>m - 1</code>&nbsp;之间的下标&nbsp;<code>i</code>&nbsp;，数字&nbsp;<code>left<sub>i</sub></code>&nbsp;所在的 <b>列</b>&nbsp;必须在数字&nbsp;<code>right<sub>i</sub></code>&nbsp;所在列的左边。</li>
</ul>

<p>返回满足上述要求的 <strong>任意</strong>&nbsp;矩阵。如果不存在答案，返回一个空的矩阵。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/07/06/gridosdrawio.png" style="width: 211px; height: 211px;"></p>

<pre><b>输入：</b>k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
<b>输出：</b>[[3,0,0],[0,0,1],[0,2,0]]
<b>解释：</b>上图为一个符合所有条件的矩阵。
行要求如下：
- 数字 1 在第 <strong>1</strong> 行，数字 2 在第 <strong>2</strong>&nbsp;行，1 在 2 的上面。
- 数字 3 在第 <strong>0</strong>&nbsp;行，数字 2 在第 <strong>2</strong>&nbsp;行，3 在 2 的上面。
列要求如下：
- 数字 2 在第 <strong>1</strong>&nbsp;列，数字 1 在第 <strong>2</strong>&nbsp;列，2 在 1 的左边。
- 数字 3 在第 <strong>0</strong>&nbsp;列，数字 2 在第 <strong>1</strong>&nbsp;列，3 在 2 的左边。
注意，可能有多种正确的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
<b>输出：</b>[]
<b>解释：</b>由前两个条件可以得到 3 在 1 的下面，但第三个条件是 3 在 1 的上面。
没有符合条件的矩阵存在，所以我们返回空矩阵。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= k &lt;= 400</code></li>
	<li><code>1 &lt;= rowConditions.length, colConditions.length &lt;= 10<sup>4</sup></code></li>
	<li><code>rowConditions[i].length == colConditions[i].length == 2</code></li>
	<li><code>1 &lt;= above<sub>i</sub>, below<sub>i</sub>, left<sub>i</sub>, right<sub>i</sub> &lt;= k</code></li>
	<li><code>above<sub>i</sub> != below<sub>i</sub></code></li>
	<li><code>left<sub>i</sub> != right<sub>i</sub></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        def topo_sort(k, arr):
            ind = [0] * k
            g = defaultdict(list)
            for u, v in arr:
                u, v = u - 1, v - 1
                g[u].append(v)
                ind[v] += 1
            q = deque()
            for i, v in enumerate(ind):
                if v == 0:
                    q.append(i)
            ans = []
            while q:
                u = q.popleft()
                ans.append(u)
                for v in g[u]:
                    ind[v] -= 1
                    if ind[v] == 0:
                        q.append(v)
            return ans

        row = topo_sort(k, rowConditions)
        col = topo_sort(k, colConditions)
        if len(row) < k or len(col) < k:
            return []
        pos = [0] * k
        for i in range(k):
            pos[col[i]] = i
        ans = [[0] * k for _ in range(k)]
        for i in range(k):
            ans[i][pos[row[i]]] = row[i] + 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> topoSort(int k, int[][] arr) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] ind = new int[k];
        for (int[] e : arr) {
            int u = e[0] - 1, v = e[1] - 1;
            g.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            ind[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            ans.add(u);
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (--ind[v] == 0) {
                    q.add(v);
                }
            }
        }
        return ans;
    }
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row = topoSort(k, rowConditions);
        List<Integer> col = topoSort(k, colConditions);
        if (row.size() != k || col.size() != k) {
            return new int[][]{};
        }
        int[] pos = new int[k];
        for (int i = 0; i < k; i++) {
            pos[col.get(i)] = i;
        }
        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            ans[i][pos[row.get(i)]] = row.get(i) + 1;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
