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
    def __init__(self):
        self.l = 0
        self.r = 0
        self.v = 0

class SegmentTree:
    def __init__(self, nums):
        self.nums = nums
        n = len(nums)
        self.tr = [Node() for _ in range(4 * n)]
        self.idx = 0
        self.build(1, 1, n)

    def build(self, u, l, r):
        self.tr[u].l = l
        self.tr[u].r = r
        if l == r:
            self.tr[u].v = self.nums[self.idx]
            self.idx += 1
            return
        mid = (l + r) >> 1
        self.build(u << 1, l, mid)
        self.build(u << 1 | 1, mid + 1, r)
        self.pushup(u)

    def pushup(self, u):
        self.tr[u].v = self.tr[u << 1].v + self.tr[u << 1 | 1].v

    def query(self, u, l, r):
        if self.tr[u].l >= l and self.tr[u].r <= r:
            return self.tr[u].v
        mid = (self.tr[u].l + self.tr[u].r) >> 1
        v = 0
        if l <= mid:
            v += self.query(u << 1, l, r)
        if r > mid:
            v += self.query(u << 1 | 1, l, r)
        return v

    def modify(self, u, x, incr):
        if self.tr[u].l == x and self.tr[u].r == x:
            self.tr[u].v += incr
            return
        mid = (self.tr[u].l + self.tr[u].r) >> 1
        if x <= mid:
            self.modify(u << 1, x, incr)
        else:
            self.modify(u << 1 | 1, x, incr)
        self.pushup(u)

class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.tree = SegmentTree(nums)


    def update(self, index: int, val: int) -> None:
        self.tree.modify(1, index + 1, val - self.tree.query(1, index + 1, index + 1))


    def sumRange(self, left: int, right: int) -> int:
        return self.tree.query(1, left + 1, right + 1)



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
    int v;
}

class Segment {
    Node[] tr;
    int idx;
    int[] nums;

    public Segment(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        tr = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tr[i] = new Node();
        }
        idx = 0;
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].v = nums[idx++];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushUp(u);
    }

    public void pushUp(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int ans = 0;
        if (l <= mid) {
            ans += query(u << 1, l, r);
        }
        if (r > mid) {
            ans += query(u << 1 | 1, l, r);
        }
        return ans;
    }

    public void modify(int u, int x, int incr) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v += incr;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, incr);
        } else {
            modify(u << 1 | 1, x, incr);
        }
        pushUp(u);
    }
}


class NumArray {
    Segment tree;
    int[] nums;

    public NumArray(int[] nums) {
        tree = new Segment(nums);
        this.nums = nums;
    }
    
    public void update(int index, int val) {
        tree.modify(1, index + 1, val - tree.query(1, index + 1, index + 1));
    }
    
    public int sumRange(int left, int right) {
        return tree.query(1, left + 1, right + 1);
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
