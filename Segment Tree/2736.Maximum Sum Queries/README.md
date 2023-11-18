# [2736. 最大和查询](https://leetcode-cn.com/problems/maximum-sum-queries)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个长度为 <code>n</code> 、下标从 <strong>0</strong> 开始的整数数组 <code>nums1</code> 和 <code>nums2</code> ，另给你一个下标从 <strong>1</strong> 开始的二维数组 <code>queries</code> ，其中 <code>queries[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 。</p>

<p>对于第 <code>i</code> 个查询，在所有满足 <code>nums1[j] &gt;= x<sub>i</sub></code> 且 <code>nums2[j] &gt;= y<sub>i</sub></code> 的下标 <code>j</code> <code>(0 &lt;= j &lt; n)</code> 中，找出 <code>nums1[j] + nums2[j]</code> 的 <strong>最大值</strong> ，如果不存在满足条件的 <code>j</code> 则返回 <strong>-1</strong> 。</p>

<p>返回数组<em> </em><code>answer</code><em> ，</em>其中<em> </em><code>answer[i]</code><em> </em>是第 <code>i</code> 个查询的答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
<strong>输出：</strong>[6,10,7]
<strong>解释：</strong>
对于第 1 个查询：<code>x<sub>i</sub> = 4</code>&nbsp;且&nbsp;<code>y<sub>i</sub> = 1</code> ，可以选择下标&nbsp;<code>j = 0</code>&nbsp;，此时 <code>nums1[j] &gt;= 4</code>&nbsp;且&nbsp;<code>nums2[j] &gt;= 1</code> 。<code>nums1[j] + nums2[j]</code>&nbsp;等于 6 ，可以证明 6 是可以获得的最大值。
对于第 2 个查询：<code>x<sub>i</sub> = 1</code>&nbsp;且&nbsp;<code>y<sub>i</sub> = 3</code> ，可以选择下标&nbsp;<code>j = 2</code>&nbsp;，此时 <code>nums1[j] &gt;= 1</code>&nbsp;且&nbsp;<code>nums2[j] &gt;= 3</code> 。<code>nums1[j] + nums2[j]</code>&nbsp;等于 10 ，可以证明 10 是可以获得的最大值。
对于第 3 个查询：<code>x<sub>i</sub> = 2</code>&nbsp;且&nbsp;<code>y<sub>i</sub> = 5</code> ，可以选择下标&nbsp;<code>j = 3</code>&nbsp;，此时 <code>nums1[j] &gt;= 2</code>&nbsp;且&nbsp;<code>nums2[j] &gt;= 5</code> 。<code>nums1[j] + nums2[j]</code>&nbsp;等于 7 ，可以证明 7 是可以获得的最大值。
因此，我们返回&nbsp;<code>[6,10,7]</code> 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
<strong>输出：</strong>[9,9,9]
<strong>解释：</strong>对于这个示例，我们可以选择下标&nbsp;<code>j = 2</code>&nbsp;，该下标可以满足每个查询的限制。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
<strong>输出：</strong>[-1]
<strong>解释：</strong>示例中的查询 <code>x<sub>i</sub></code> = 3 且 <code>y<sub>i</sub></code> = 3 。对于每个下标 j ，都只满足 nums1[j] &lt; <code>x<sub>i</sub></code> 或者 nums2[j] &lt; <code>y<sub>i</sub></code> 。因此，不存在答案。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums1.length == nums2.length</code>&nbsp;</li>
	<li><code>n ==&nbsp;nums1.length&nbsp;</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup>&nbsp;</code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length ==&nbsp;2</code></li>
	<li><code>x<sub>i</sub>&nbsp;== queries[i][1]</code></li>
	<li><code>y<sub>i</sub> == queries[i][2]</code></li>
	<li><code>1 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Node:
    def __init__(self, l, r):
        self.left = None
        self.right = None
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.v = -1


class Segment_Tree:
    def __init__(self):
        self.root = Node(1, int(1e9))

    def query_range(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.push_down(node)
        ans = -1
        if l <= node.mid:
            ans = max(ans, self.query_range(l, r, node.left))
        if node.mid < r:
            ans = max(ans, self.query_range(l, r, node.right))
        return ans

    def modify_range(self, l, r, v, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.v = max(node.v, v)
            return
        self.push_down(node)
        if l <= node.mid:
            self.modify_range(l, r, v, node.left)
        if node.mid < r:
            self.modify_range(l, r, v, node.right)
        self.push_up(node)

    def push_up(self, node):
        node.v = max(node.left.v, node.right.v)

    def push_down(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)

class Solution:
    def maximumSumQueries(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        nums = [(a, b) for a, b in zip(nums1, nums2)]
        nums.sort(key=lambda x: -x[0])
        q = [(v[0], v[1], i) for i, v in enumerate(queries)]
        q.sort(key=lambda x: -x[0])

        st = Segment_Tree()
        n, m = len(nums1), len(queries)
        ans = [-1] * m
        j = 0
        for x, y, i in q:
            while j < n and nums[j][0] >= x:
                st.modify_range(nums[j][1], nums[j][1], nums[j][0] + nums[j][1])
                j += 1
            ans[i] = st.query_range(y, inf)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    class Node {
        int l;
        int r;
        int mid;
        int v;
        Node left;
        Node right;

        public Node (int l, int r) {
            this.l = l;
            this.r = r;
            mid = (l + r) >> 1;
            v = -1;
        }
    }

    class SegmentTree {
        Node root;

        public SegmentTree(int l, int r) {
            root = new Node(l, r);
        }

        public void modify(int l, int r, int v, Node node) {
            if (node == null) {
                node = root;
            }
            if (l <= node.l && node.r <= r) {
                node.v = Math.max(node.v, v);
                return;
            }
            pushDown(node);
            if (l <= node.mid) {
                modify(l, r, v, node.left);
            }
            if (r > node.mid) {
                modify(l, r, v, node.right);
            }
            pushUp(node);
        }

        public void pushDown(Node node) {
            if (node.left == null) {
                node.left = new Node(node.l, node.mid);
            }
            if (node.right == null) {
                node.right = new Node(node.mid + 1, node.r);
            }
        }

        public void pushUp(Node node) {
            node.v = Math.max(node.left.v, node.right.v);
        }

        public int query(int l, int r, Node node) {
            if (node == null) {
                node = root;
            }
            if (l <= node.l && node.r <= r) {
                return node.v;
            }
            pushDown(node);
            int ans = -1;
            if (l <= node.mid) {
                ans = Math.max(ans, query(l, r, node.left));
            }
            if (r > node.mid) {
                ans = Math.max(ans, query(l, r, node.right));
            }
            return ans;
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        Arrays.sort(q, (a, b) -> b[0] - a[0]);

        int inf = (int)1e9;
        SegmentTree st = new SegmentTree(0, inf);
        int[] ans = new int[m];
        int j = 0;
        for (int[] qs : q) {
            int x = qs[0], y = qs[1], i = qs[2];
            while (j < n && nums[j][0] >= x) {
                st.modify(nums[j][1], nums[j][1], nums[j][0] + nums[j][1], null);
                j++;
            }
            ans[i] = st.query(y, inf, null);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
