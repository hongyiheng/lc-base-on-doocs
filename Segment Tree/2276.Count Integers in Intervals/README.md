# [2276. 统计区间中的整数数目](https://leetcode-cn.com/problems/count-integers-in-intervals)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你区间的 <strong>空</strong> 集，请你设计并实现满足要求的数据结构：</p>

<ul>
	<li><strong>新增：</strong>添加一个区间到这个区间集合中。</li>
	<li><strong>统计：</strong>计算出现在 <strong>至少一个</strong> 区间中的整数个数。</li>
</ul>

<p>实现 <code>CountIntervals</code> 类：</p>

<ul>
	<li><code>CountIntervals()</code> 使用区间的空集初始化对象</li>
	<li><code>void add(int left, int right)</code> 添加区间 <code>[left, right]</code> 到区间集合之中。</li>
	<li><code>int count()</code> 返回出现在 <strong>至少一个</strong> 区间中的整数个数。</li>
</ul>

<p><strong>注意：</strong>区间 <code>[left, right]</code> 表示满足 <code>left &lt;= x &lt;= right</code> 的所有整数 <code>x</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["CountIntervals", "add", "add", "count", "add", "count"]
[[], [2, 3], [7, 10], [], [5, 8], []]
<strong>输出</strong>
[null, null, null, 6, null, 8]

<strong>解释</strong>
CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
countIntervals.count();    // 返回 6
                           // 整数 2 和 3 出现在区间 [2, 3] 中
                           // 整数 7、8、9、10 出现在区间 [7, 10] 中
countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
countIntervals.count();    // 返回 8
                           // 整数 2 和 3 出现在区间 [2, 3] 中
                           // 整数 5 和 6 出现在区间 [5, 8] 中
                           // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
                           // 整数 9 和 10 出现在区间 [7, 10] 中</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= left &lt;= right &lt;= 10<sup>9</sup></code></li>
	<li>最多调用&nbsp; <code>add</code> 和 <code>count</code> 方法 <strong>总计</strong> <code>10<sup>5</sup></code> 次</li>
	<li>调用 <code>count</code> 方法至少一次</li>
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
        self.mid = (l + r) >> 1
        self.v = 0
        self.left = None
        self.right = None
        self.lazy = False


class Segment_Tree:
    def __init__(self, l, r):
        self.root = Node(l, r)

    def modify(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.v = node.r - node.l + 1
            node.lazy = True
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, node.left)
        if node.mid < r:
            self.modify(l, r, node.right)
        self.pushUp(node)

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if node.mid < r:
            ans += self.query(l, r, node.right)
        return ans

    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.left.r - node.left.l + 1
            node.left.lazy = True
            node.right.v = node.right.r - node.right.l + 1
            node.right.lazy = True
        node.lazy = False

class CountIntervals:

    def __init__(self):
        self.st = Segment_Tree(1, int(1e9))

    def add(self, left: int, right: int) -> None:
        self.st.modify(left, right)

    def count(self) -> int:
        return self.st.query(1, int(1e9))



# Your CountIntervals object will be instantiated and called as such:
# obj = CountIntervals()
# obj.add(left,right)
# param_2 = obj.count()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    int l;
    int r;
    int mid;
    int v;
    boolean lazy;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        mid = (l + r) >> 1;
    }
}

class SegmentTree {
    Node root;

    public SegmentTree(int l, int r) {
        root = new Node(l, r);
    }

    public void modify(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = node.r - node.l + 1;
            node.lazy = true;
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modify(l, r, node.left);
        }
        if (node.mid < r) {
            modify(l, r, node.right);
        }
        pushUp(node);
    }

    public int query(int l, int r, Node node) {
        if (node == null) {
            node = root;
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

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy) {
            node.left.v = node.left.r - node.left.l + 1;
            node.left.lazy = true;
            node.right.v = node.right.r - node.right.l + 1;
            node.right.lazy = true;
        }
        node.lazy = false;
    }

    public void pushUp(Node node) {
        node.v = node.left.v + node.right.v;
    }
}

class CountIntervals {
    int M = (int)1e9;
    SegmentTree st;

    public CountIntervals() {
        st = new SegmentTree(1, M);
    }
    
    public void add(int left, int right) {
        st.modify(left, right, null);
    }
    
    public int count() {
        return st.query(1, M, null);
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
```

### **...**

```

```

<!-- tabs:end -->
