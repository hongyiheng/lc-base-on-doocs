# [699. 掉落的方块](https://leetcode-cn.com/problems/falling-squares)



## 题目描述

<!-- 这里写题目描述 -->

<p>在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。</p>

<p>第 <code>i</code> 个掉落的方块（<code>positions[i] = (left, side_length)</code>）是正方形，其中&nbsp;<code>left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。</code></p>

<p>每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。</p>

<p>方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，<code>因为只有底边才具有粘性。</code></p>

<p>&nbsp;</p>

<p>返回一个堆叠高度列表&nbsp;<code>ans</code> 。每一个堆叠高度&nbsp;<code>ans[i]</code>&nbsp;表示在通过&nbsp;<code>positions[0], positions[1], ..., positions[i]</code>&nbsp;表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [[1, 2], [2, 3], [6, 1]]
<strong>输出:</strong> [2, 5, 5]
<strong>解释:

</strong>第一个方块 <code>positions[0] = [1, 2] </code>掉落：
<code>_aa
_aa
-------
</code>方块最大高度为 2 。

第二个方块 <code>positions[1] = [2, 3] </code>掉落：
<code>__aaa
__aaa
__aaa
_aa__
_aa__
--------------
</code>方块最大高度为5。
大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。

第三个方块 <code>positions[1] = [6, 1] </code>掉落：
<code>__aaa
__aaa
__aaa
_aa
_aa___a
-------------- 
</code>方块最大高度为5。

因此，我们返回结果<code>[2, 5, 5]。</code>
</pre>

<p>&nbsp;</p>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [[100, 100], [200, 100]]
<strong>输出:</strong> [100, 100]
<strong>解释:</strong> 相邻的方块不会过早地卡住，只有它们的底部边缘才能粘在表面上。
</pre>

<p>&nbsp;</p>

<p><strong>注意:</strong></p>

<ul>
	<li><code>1 &lt;= positions.length &lt;= 1000</code>.</li>
	<li><code>1 &lt;= positions[i][0] &lt;= 10^8</code>.</li>
	<li><code>1 &lt;= positions[i][1] &lt;= 10^6</code>.</li>
</ul>

<p>&nbsp;</p>


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
        self.v = 0
        self.add = 0

class Segment_Tree:
    def __init__(self):
        self.root = Node(1, int(1e9))
    
    def query(self, l, r):
        return self.query_range(l, r, self.root)
    
    def query_range(self, l, r, node):
        if l > r:
            return 0
        if l <= node.l and node.r <= r:
            return node.v
        self.push_down(node)
        ans = 0
        if l <= node.mid:
            ans = max(ans, self.query_range(l, r, node.left))
        if node.mid < r:
            ans = max(ans, self.query_range(l, r, node.right))
        return ans

    def modify(self, l, r, v):
        self.modify_range(l, r, v, self.root)

    def modify_range(self, l, r, v, node):
        if l > r:
            return
        if l <= node.l and node.r <= r:
            node.v = v
            node.add = v
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
        if node.add:
            node.left.add = node.add
            node.right.add = node.add
            node.left.v = node.v
            node.right.v = node.v
            node.add = 0

class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        ans = []
        cur = 0
        st = Segment_Tree()
        for l, w in positions:
            h = st.query(l, l + w - 1)
            st.modify(l, l + w - 1, h + w)
            cur = max(cur, h + w)
            ans.append(cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        SegmentTree st = new SegmentTree();
        List<Integer> ans = new ArrayList<>();
        int cur = 0;
        for (int[] item : positions) {
            int h = st.query(item[0], item[0] + item[1] - 1);
            st.modify(item[0], item[0] + item[1] - 1, h + item[1]);
            cur = Math.max(cur, h + item[1]);
            ans.add(cur);
        }
        return ans;
    }
}

class SegmentTree {
    private Node root = new Node(1, (int)1e9);

    public SegmentTree() {
    }

    public int query(int l, int r) {
        return query(l, r, root);
    }

    public int query(int l, int r, Node node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.v;
        }
        pushDown(node);
        int v = 0;
        if (l <= node.mid) {
            v = Math.max(v, query(l, r, node.left));
        }
        if (r > node.mid) {
            v = Math.max(v, query(l, r, node.right));
        }
        return v;
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            node.v = v;
            node.add = v;
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

    public void pushUp(Node node) {
        node.v = Math.max(node.left.v, node.right.v);
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node left = node.left, right = node.right;
            left.add = node.add;
            right.add = node.add;
            left.v = node.v;
            right.v = node.v;
            node.add = 0;
        }
    }
}

class Node {
    Node left;
    Node right;
    int l;
    int r;
    int mid;
    int v;
    int add;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
