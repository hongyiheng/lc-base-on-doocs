# [307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组 <code>nums</code> ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。</p>

<p>实现 <code>NumArray</code> 类：</p>

<div class="original__bRMd">
<div>
<ul>
	<li><code>NumArray(int[] nums)</code> 用整数数组 <code>nums</code> 初始化对象</li>
	<li><code>void update(int index, int val)</code> 将 <code>nums[index]</code> 的值更新为 <code>val</code></li>
	<li><code>int sumRange(int left, int right)</code> 返回子数组 <code>nums[left, right]</code> 的总和（即，<code>nums[left] + nums[left + 1], ..., nums[right]</code>）</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>：
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
<strong>输出</strong>：
[null, 9, null, 8]

<strong>解释</strong>：
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
numArray.update(1, 2);   // nums = [1,2,5]
numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>-100 <= nums[i] <= 100</code></li>
	<li><code>0 <= index < nums.length</code></li>
	<li><code>-100 <= val <= 100</code></li>
	<li><code>0 <= left <= right < nums.length</code></li>
	<li>最多调用 <code>3 * 10<sup>4</sup></code> 次 <code>update</code> 和 <code>sumRange</code> 方法</li>
</ul>
</div>
</div>


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
        self.left = None
        self.right = None
        self.v = 0

class SegmentTree():

    def __init__(self, l, r):
        self.root = Node(l, r)
    
    def modify(self, l, r, v, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.v = v
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, v, node.left)
        if r > node.mid:
            self.modify(l, r, v, node.right)
        self.pushUp(node)

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        
    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if r > node.mid:
            ans += self.query(l, r, node.right)
        return ans
        
class NumArray:

    def __init__(self, nums: List[int]):
        self.st = SegmentTree(0, 30010)
        for i, v in enumerate(nums):
            self.st.modify(i, i, v)

    def update(self, index: int, val: int) -> None:
        self.st.modify(index, index, val)

    def sumRange(self, left: int, right: int) -> int:
        return self.st.query(left, right)



# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    int l;
    int r;
    int mid;
    int v;
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

    public void modify(int l, int r, int v, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = v;
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
        node.v = node.left.v + node.right.v;
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
        if (r > node.mid) {
            ans += query(l, r, node.right);
        }
        return ans;
    }
}


class NumArray {

    SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(0, 30010);
        for (int i = 0; i < nums.length; i++) {
            st.modify(i, i, nums[i], null);
        }
    }

    public void update(int index, int val) {
        st.modify(index, index, val, null);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right, null);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
```

### **...**

```

```

<!-- tabs:end -->
