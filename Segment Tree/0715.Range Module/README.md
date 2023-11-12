# [715. Range 模块](https://leetcode-cn.com/problems/range-module)



## 题目描述

<!-- 这里写题目描述 -->

<p>Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。</p>

<ul>
	<li><code>addRange(int left, int right)</code> 添加半开区间&nbsp;<code>[left, right)</code>，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间&nbsp;<code>[left, right)</code>&nbsp;中尚未跟踪的任何数字到该区间中。</li>
	<li><code>queryRange(int left, int right)</code>&nbsp;只有在当前正在跟踪区间&nbsp;<code>[left, right)</code>&nbsp;中的每一个实数时，才返回 true。</li>
	<li><code>removeRange(int left, int right)</code>&nbsp;停止跟踪区间&nbsp;<code>[left, right)</code>&nbsp;中当前正在跟踪的每个实数。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>addRange(10, 20)</strong>: null
<strong>removeRange(14, 16)</strong>: null
<strong>queryRange(10, 14)</strong>: true （区间 [10, 14) 中的每个数都正在被跟踪）
<strong>queryRange(13, 15)</strong>: false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
<strong>queryRange(16, 17)</strong>: true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>半开区间&nbsp;<code>[left, right)</code>&nbsp;表示所有满足&nbsp;<code>left &lt;= x &lt; right</code>&nbsp;的实数。</li>
	<li>对&nbsp;<code>addRange, queryRange, removeRange</code>&nbsp;的所有调用中&nbsp;<code>0 &lt; left &lt; right &lt; 10^9</code>。</li>
	<li>在单个测试用例中，对&nbsp;<code>addRange</code>&nbsp;的调用总数不超过&nbsp;<code>1000</code>&nbsp;次。</li>
	<li>在单个测试用例中，对&nbsp; <code>queryRange</code> 的调用总数不超过 <code>5000</code> 次。</li>
	<li>在单个测试用例中，对 <code>removeRange</code> 的调用总数不超过&nbsp;<code>1000</code>&nbsp;次。</li>
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
        self.l = l
        self.r = r
        self.v = False
        self.lazy = 0
        self.mid = (l + r) >> 1
        self.left = None
        self.right = None


class SegmentTree:
    def __init__(self):
        self.root = Node(1, int(1e9))

    def modify(self, l, r, v, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.lazy = v 
            node.v = v == 1
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, v, node.left)
        if node.mid < r:
            self.modify(l, r, v, node.right)
        self.pushUp(node)

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = True
        if l <= node.mid:
            ans = ans and self.query(l, r, node.left)
        if node.mid < r:
            ans = ans and self.query(l, r, node.right)
        return ans


    def pushUp(self, node):
        node.v = node.left.v and node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.lazy == 1
            node.left.lazy = node.lazy
            node.right.v = node.lazy == 1
            node.right.lazy = node.lazy
        node.lazy = 0

class RangeModule:

    def __init__(self):
        self.st = SegmentTree()

    def addRange(self, left: int, right: int) -> None:
        self.st.modify(left, right - 1, 1)

    def queryRange(self, left: int, right: int) -> bool:
        return self.st.query(left, right - 1)

    def removeRange(self, left: int, right: int) -> None:
        self.st.modify(left, right - 1, -1)


# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    int l;
    int r;
    int mid;
    int lazy;
    boolean v;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        mid = (l + r) >> 1;
    }
}

class SegmentTree {
    private Node root = new Node(1, (int)1e9);

    public SegmentTree() {

    }

    public void modify(int l, int r, int v, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = v == 1;
            node.lazy = v;
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, v, node.left);
        }
        if (r > node.mid) {
            modify(l, r, v, node.right);
        }
        pushup(node);
    }

    public boolean query(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            return node.v;
        }
        pushdown(node);
        boolean ans = true;
        if (l <= node.mid) {
            ans = ans && query(l, r, node.left);
        }
        if (r > node.mid) {
            ans = ans && query(l, r, node.right);
        }
        return ans;
    }

    public void pushup(Node node) {
        node.v = node.left.v && node.right.v;
    }

    public void pushdown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy != 0) {
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.left.v = node.lazy == 1;
            node.right.v = node.lazy == 1;
        }
        node.lazy = 0;
    }
}

class RangeModule {
    SegmentTree tree;

    public RangeModule() {
        tree = new SegmentTree();
    }

    public void addRange(int left, int right) {
        tree.modify(left, right - 1, 1, null);
    }

    public boolean queryRange(int left, int right) {
        return tree.query(left, right - 1, null);
    }

    public void removeRange(int left, int right) {
        tree.modify(left, right - 1, -1, null);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */

```

### **...**

```

```

<!-- tabs:end -->
