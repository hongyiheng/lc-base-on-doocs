# [2569. 更新数组后处理求和查询](https://leetcode-cn.com/problems/handling-sum-queries-after-update)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong>&nbsp;开始的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;，和一个二维数组&nbsp;<code>queries</code>&nbsp;表示一些操作。总共有 3 种类型的操作：</p>

<ol>
	<li>操作类型 1 为&nbsp;<code>queries[i]&nbsp;= [1, l, r]</code>&nbsp;。你需要将 <code>nums1</code>&nbsp;从下标&nbsp;<code>l</code>&nbsp;到下标 <code>r</code>&nbsp;的所有 <code>0</code>&nbsp;反转成 <code>1</code>&nbsp;或将 <code>1</code>&nbsp;反转成 <code>0</code>&nbsp;。<code>l</code>&nbsp;和 <code>r</code>&nbsp;下标都从 <strong>0</strong>&nbsp;开始。</li>
	<li>操作类型 2 为&nbsp;<code>queries[i]&nbsp;= [2, p, 0]</code>&nbsp;。对于&nbsp;<code>0 &lt;= i &lt; n</code>&nbsp;中的所有下标，令&nbsp;<code>nums2[i] =&nbsp;nums2[i]&nbsp;+ nums1[i]&nbsp;* p</code>&nbsp;。</li>
	<li>操作类型 3 为&nbsp;<code>queries[i]&nbsp;= [3, 0, 0]</code>&nbsp;。求&nbsp;<code>nums2</code>&nbsp;中所有元素的和。</li>
</ol>

<p>请你返回一个数组，包含所有第三种操作类型的答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
<b>输出：</b>[3]
<strong>解释：</strong>第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
<b>输出：</b>[5]
<b>解释：</b>第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length,nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums1.length = nums2.length</code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length = 3</code></li>
	<li><code>0 &lt;= l &lt;= r &lt;= nums1.length - 1</code></li>
	<li><code>0 &lt;= p &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= nums1[i] &lt;= 1</code></li>
	<li><code>0 &lt;= nums2[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Node:
    def __init__(self, l, r):
        self.l = l
        self.r = r
        self.v = 0
        self.lazy = 0
        self.mid = (l + r) >> 1
        self.left = None
        self.right = None


class SegmentTree:
    def __init__(self):
        self.root = Node(0, int(1e6))

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l > r:
            return 0
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if node.mid < r:
            ans += self.query(l, r, node.right)
        return ans

    def modify(self, l, r, node=None):
        if not node:
            node = self.root
        if l > r:
            return
        if l <= node.l and node.r <= r:
            node.lazy ^= 1
            node.v = node.r - node.l + 1 - node.v
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, node.left)
        if node.mid < r:
            self.modify(l, r, node.right)
        self.pushUp(node)

    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.left.r - node.left.l + 1 - node.left.v
            node.left.lazy ^= 1
            node.right.v = node.right.r - node.right.l + 1 - node.right.v
            node.right.lazy ^= 1
        node.lazy = 0

class Solution:
    def handleQuery(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        st = SegmentTree()
        for i, v in enumerate(nums1):
            if v:
                st.modify(i, i)
        s = sum(nums2)
        ans = []
        for q in queries:
            if q[0] == 1:
                st.modify(q[1], q[2])
            elif q[0] == 2:
                s += st.query(0, int(1e9)) * q[1]
            else:
                ans.append(s)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    int l;
    int r;
    int mid;
    int v;
    int lazy;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
        this.v = 0;
        this.lazy = 0;
    }
}

class SegmentTree {

    Node root;

    public SegmentTree() {
        root = new Node(0, (int)1e6);
    }
    
    public void modify(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l > r) {
            return;
        }
        if (l <= node.l && node.r <= r) {
            node.v = node.r - node.l + 1 - node.v;
            node.lazy ^= 1;
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modify(l, r, node.left);
        }
        if (r > node.mid) {
            modify(l, r, node.right);
        }
        pushUp(node);
    }

    public int query(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l > r) {
            return 0;
        }
        if (l <= node.l && node.r <= r) {
            return node.v;
        }
        pushDown(node);
        int ans = 0;
        if (l <= node.mid) {
            ans += query(l, r, node.left);
        }
        if (node.mid < r) {
            ans += query(l, r, node.right);
        }
        return ans;
    }
    
    public void pushUp(Node node) {
        node.v = node.left.v + node.right.v;
    }
    
    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy != 0) {
            node.left.v = node.left.r - node.left.l + 1 - node.left.v;
            node.left.lazy ^= 1;
            node.right.v = node.right.r - node.right.l + 1 - node.right.v;
            node.right.lazy ^= 1;
            node.lazy = 0;
        }
    }
}

class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        SegmentTree st = new SegmentTree();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 1) {
                st.modify(i, i, null);
            }
        }
        long s = 0;
        for (int v : nums2) {
            s += v;
        }
        List<Long> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                st.modify(q[1], q[2], null);
            } else if (q[0] == 2) {
                s += (long) q[1] * st.query(0, (int) 1e6, null);
            } else {
                ans.add(s);
            }
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
