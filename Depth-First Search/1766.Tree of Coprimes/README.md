# [1766. 互质树](https://leetcode-cn.com/problems/tree-of-coprimes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n</code> 个节点的树（也就是一个无环连通无向图），节点编号从 <code>0</code> 到 <code>n - 1</code> ，且恰好有 <code>n - 1</code> 条边，每个节点有一个值。树的 <strong>根节点</strong> 为 0 号点。</p>

<p>给你一个整数数组 <code>nums</code> 和一个二维数组 <code>edges</code> 来表示这棵树。<code>nums[i]</code> 表示第 <code>i</code> 个点的值，<code>edges[j] = [u<sub>j</sub>, v<sub>j</sub>]</code> 表示节点 <code>u<sub>j</sub></code> 和节点 <code>v<sub>j</sub></code> 在树中有一条边。</p>

<p>当 <code>gcd(x, y) == 1</code> ，我们称两个数 <code>x</code> 和 <code>y</code> 是 <strong>互质的</strong> ，其中 <code>gcd(x, y)</code> 是 <code>x</code> 和 <code>y</code> 的 <strong>最大公约数</strong> 。</p>

<p>从节点 <code>i</code> 到 <strong>根</strong> 最短路径上的点都是节点 <code>i</code> 的祖先节点。一个节点 <strong>不是</strong> 它自己的祖先节点。</p>

<p>请你返回一个大小为 <code>n</code> 的数组 <code>ans</code> ，其中<em> </em><code>ans[i]</code>是离节点 <code>i</code> 最近的祖先节点且满足<em> </em><code>nums[i]</code> 和<em> </em><code>nums[ans[i]]</code> 是 <strong>互质的</strong> ，如果不存在这样的祖先节点，<code>ans[i]</code> 为 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/02/20/untitled-diagram.png" style="width: 191px; height: 281px;" /></strong></p>

<pre>
<b>输入：</b>nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
<b>输出：</b>[-1,0,0,1]
<b>解释：</b>上图中，每个节点的值在括号中表示。
- 节点 0 没有互质祖先。
- 节点 1 只有一个祖先节点 0 。它们的值是互质的（gcd(2,3) == 1）。
- 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(2,3) == 1)，所以节点 0 是最近的符合要求的祖先节点。
- 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/02/20/untitled-diagram1.png" style="width: 441px; height: 291px;" /></p>

<pre>
<strong>输入：</strong>nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
<b>输出：</b>[-1,0,-1,0,0,0,-1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums.length == n</code></li>
	<li><code>1 <= nums[i] <= 50</code></li>
	<li><code>1 <= n <= 10<sup>5</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[j].length == 2</code></li>
	<li><code>0 <= u<sub>j</sub>, v<sub>j</sub> < n</code></li>
	<li><code>u<sub>j</sub> != v<sub>j</sub></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getCoprimes(self, nums: List[int], edges: List[List[int]]) -> List[int]:
        def dfs(i, fa, depth):
            t = k = -1
            for v in f[nums[i]]:
                stk = stks[v]
                if stk and stk[-1][1] > k:
                    t, k = stk[-1]
            ans[i] = t
            for j in g[i]:
                if j != fa:
                    stks[nums[i]].append((i, depth))
                    dfs(j, i, depth + 1)
                    stks[nums[i]].pop()

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        f = defaultdict(list)
        for i in range(1, 51):
            for j in range(1, 51):
                if gcd(i, j) == 1:
                    f[i].append(j)
        stks = defaultdict(list)
        ans = [-1] * len(nums)
        dfs(0, -1, 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>(), f = new HashMap<>();
    Map<Integer, Deque<int[]>> stks = new HashMap<>();
    int[] ans;
    int[] nums;

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void dfs(int u, int p, int d) {
        int t = -1, dd = -1;
        for (int v : f.getOrDefault(nums[u], new ArrayList<>())) {
            Deque<int[]> stk = stks.getOrDefault(v, new ArrayDeque<>());
            if (!stk.isEmpty() && stk.peekLast()[1] > dd) {
                t = stk.peekLast()[0];
                dd = stk.peekLast()[1];
            }
        }
        ans[u] = t;
        stks.computeIfAbsent(nums[u], k -> new ArrayDeque<>()).add(new int[]{u, d});
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            dfs(v, u, d + 1);
        }
        stks.get(nums[u]).pollLast();
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 51; i++) {
            for (int j = i; j < 51; j++) {
                if (gcd(i, j) != 1) {
                    continue;
                }
                f.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                f.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        dfs(0, -1, 0);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
