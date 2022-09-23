# [707. 设计链表](https://leetcode-cn.com/problems/design-linked-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：<code>val</code>&nbsp;和&nbsp;<code>next</code>。<code>val</code>&nbsp;是当前节点的值，<code>next</code>&nbsp;是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性&nbsp;<code>prev</code>&nbsp;以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。</p>

<p>在链表类中实现这些功能：</p>

<ul>
	<li>get(index)：获取链表中第&nbsp;<code>index</code>&nbsp;个节点的值。如果索引无效，则返回<code>-1</code>。</li>
	<li>addAtHead(val)：在链表的第一个元素之前添加一个值为&nbsp;<code>val</code>&nbsp;的节点。插入后，新节点将成为链表的第一个节点。</li>
	<li>addAtTail(val)：将值为&nbsp;<code>val</code> 的节点追加到链表的最后一个元素。</li>
	<li>addAtIndex(index,val)：在链表中的第&nbsp;<code>index</code>&nbsp;个节点之前添加值为&nbsp;<code>val</code>&nbsp; 的节点。如果&nbsp;<code>index</code>&nbsp;等于链表的长度，则该节点将附加到链表的末尾。如果 <code>index</code> 大于链表长度，则不会插入节点。如果<code>index</code>小于0，则在头部插入节点。</li>
	<li>deleteAtIndex(index)：如果索引&nbsp;<code>index</code> 有效，则删除链表中的第&nbsp;<code>index</code> 个节点。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-&gt; 2-&gt; 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-&gt; 3
linkedList.get(1);            //返回3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>所有<code>val</code>值都在&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
	<li>操作次数将在&nbsp;&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
	<li>请不要使用内置的 LinkedList 库。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class MyLinkedList:

    def __init__(self):
        self.q = deque()

    def get(self, index: int) -> int:
        if index >= len(self.q):
            return -1
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        ans = self.q[0]
        while nums:
            self.q.appendleft(nums.pop())
        return ans

    def addAtHead(self, val: int) -> None:
        self.q.appendleft(val)

    def addAtTail(self, val: int) -> None:
        self.q.append(val)


    def addAtIndex(self, index: int, val: int) -> None:
        if index <= 0:
            self.q.appendleft(val)
            return
        if index > len(self.q):
            return
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        self.q.appendleft(val)
        while nums:
            self.q.appendleft(nums.pop())

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= len(self.q):
            return
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        self.q.popleft()
        while nums:
            self.q.appendleft(nums.pop())

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyLinkedList {
    Deque<Integer> q;

    public MyLinkedList() {
        q = new ArrayDeque<>();
    }
    
    public int get(int index) {
        if (index < 0 || index >= q.size()) {
            return -1;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (tmp.size() < index) {
            tmp.addLast(q.pollFirst());
        }
        int ans = q.peekFirst();
        while (!tmp.isEmpty()) {
            q.addFirst(tmp.pollLast());
        }
        return ans;
    }
    
    public void addAtHead(int val) {
        q.addFirst(val);
    }
    
    public void addAtTail(int val) {
        q.addLast(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > q.size()) {
            return;
        }
        if (index == q.size()) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            Deque<Integer> tmp = new ArrayDeque<>();
            while (tmp.size() < index) {
                tmp.addLast(q.pollFirst());
            }
            q.addFirst(val);
            while (!tmp.isEmpty()) {
                q.addFirst(tmp.pollLast());
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= q.size()) {
            return;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (tmp.size() < index) {
            tmp.addLast(q.pollFirst());
        }
        q.pollFirst();
        while (!tmp.isEmpty()) {
            q.addFirst(tmp.pollLast());
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

### **...**

```

```

<!-- tabs:end -->
