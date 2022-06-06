# [732. 我的日程安排表 III](https://leetcode-cn.com/problems/my-calendar-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>当 <code>k</code> 个日程安排有一些时间上的交叉时（例如 <code>k</code> 个日程安排都在同一时间内），就会产生 <code>k</code> 次预订。</p>

<p>给你一些日程安排 <code>[start, end)</code> ，请你在每个日程安排添加后，返回一个整数 <code>k</code> ，表示所有先前日程安排会产生的最大 <code>k</code> 次预订。</p>

<p>实现一个 <code>MyCalendarThree</code> 类来存放你的日程安排，你可以一直添加新的日程安排。</p>

<ul>
	<li><code>MyCalendarThree()</code> 初始化对象。</li>
	<li><code>int book(int start, int end)</code> 返回一个整数 <code>k</code> ，表示日历中存在的 <code>k</code> 次预订的最大值。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
<strong>输出：</strong>
[null, 1, 1, 2, 3, 3, 3]

<strong>解释：</strong>
MyCalendarThree myCalendarThree = new MyCalendarThree();
myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
myCalendarThree.book(5, 10); // 返回 3
myCalendarThree.book(25, 55); // 返回 3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= start < end <= 10<sup>9</sup></code></li>
	<li>每个测试用例，调用 <code>book</code> 函数最多不超过 <code>400</code>次</li>
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
        self.v = 0
        self.add = 0

class Segment_Tree:
    def __init__(self):
        self.root = Node(0, int(1e9))
    
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
            node.v += v
            node.add += v
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
            node.left.add += node.add
            node.right.add += node.add
            node.left.v += node.add
            node.right.v += node.add
            node.add = 0

class MyCalendarThree:

    def __init__(self):
        self.st = Segment_Tree()

    def book(self, start: int, end: int) -> int:
        self.st.modify(start, end - 1, 1)
        return self.st.query(0, int(1e9))



# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(start,end)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyCalendarThree {
    SegmentTree st;

    public MyCalendarThree() {
        st = new SegmentTree();
    }
    
    public int book(int start, int end) {
        st.modify(start, end - 1, 1);
        return st.query(0, (int)1e9);
    }
}

class SegmentTree {
    private Node root = new Node(0, (int)1e9);

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
            node.v += v;
            node.add += v;
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
            left.add += node.add;
            right.add += node.add;
            left.v += node.add;
            right.v += node.add;
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

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
```

### **...**

```

```

<!-- tabs:end -->
