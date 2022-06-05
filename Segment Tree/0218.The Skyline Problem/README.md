# [218. 天际线问题](https://leetcode-cn.com/problems/the-skyline-problem)



## 题目描述

<!-- 这里写题目描述 -->

<p>城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的<strong> 天际线</strong> 。</p>

<p>每个建筑物的几何信息由数组 <code>buildings</code> 表示，其中三元组 <code>buildings[i] = [lefti, righti, heighti]</code> 表示：</p>

<ul>
	<li><code>left<sub>i</sub></code> 是第 <code>i</code> 座建筑物左边缘的 <code>x</code> 坐标。</li>
	<li><code>right<sub>i</sub></code> 是第 <code>i</code> 座建筑物右边缘的 <code>x</code> 坐标。</li>
	<li><code>height<sub>i</sub></code> 是第 <code>i</code> 座建筑物的高度。</li>
</ul>

<p><strong>天际线</strong> 应该表示为由 “关键点” 组成的列表，格式 <code>[[x<sub>1</sub>,y<sub>1</sub>],[x<sub>2</sub>,y<sub>2</sub>],...]</code> ，并按 <strong>x 坐标 </strong>进行 <strong>排序</strong> 。<strong>关键点是水平线段的左端点</strong>。列表中最后一个点是最右侧建筑物的终点，<code>y</code> 坐标始终为 <code>0</code> ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。</p>

<p><strong>注意：</strong>输出天际线中不得有连续的相同高度的水平线。例如 <code>[...[2 3], [4 5], [7 5], [11 5], [12 7]...]</code> 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：<code>[...[2 3], [4 5], [12 7], ...]</code></p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/merged.jpg" style="width: 800px; height: 331px;" />
<pre>
<strong>输入：</strong>buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
<strong>输出：</strong>[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
<strong>解释：</strong>
图 A<strong> </strong>显示输入的所有建筑物的位置和高度，
图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>buildings = [[0,2,3],[2,5,3]]
<strong>输出：</strong>[[0,3],[5,0]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= buildings.length <= 10<sup>4</sup></code></li>
	<li><code>0 <= left<sub>i</sub> < right<sub>i</sub> <= 2<sup>31</sup> - 1</code></li>
	<li><code>1 <= height<sub>i</sub> <= 2<sup>31</sup> - 1</code></li>
	<li><code>buildings</code> 按 <code>left<sub>i</sub></code> 非递减排序</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
from sortedcontainers import SortedList

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
        self.root = Node(0, 2 ** 31 - 1)
    
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
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        buildings.sort(key=lambda x: x[2])
        st = Segment_Tree()
        q = SortedList()
        for item in buildings:
            st.modify(item[0], item[1] - 1, item[2])
            q.add(item[0])
            q.add(item[1])
        ans = []
        last = 0
        for cur in q:
            w = st.query(cur, cur)
            if w != last:
                ans.append([cur, w])
                last = w
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
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
        this.mid = (l + r) >>> 1;
    }
}

class SegmentTree {
    private Node root = new Node(0, Integer.MAX_VALUE);

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

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        SegmentTree st = new SegmentTree();
        Arrays.sort(buildings, (a, b) -> a[2] - b[2]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int[] item : buildings) {
            st.modify(item[0], item[1] - 1, item[2]);
            q.add(item[0]);
            q.add(item[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int last = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int w = st.query(cur, cur);
            if (w != last) {
                List<Integer> item = new ArrayList<>();
                item.add(cur);
                item.add(w);
                ans.add(item);   
                last = w;
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
