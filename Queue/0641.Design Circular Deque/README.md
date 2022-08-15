# [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque)



## 题目描述

<!-- 这里写题目描述 -->

<p>设计实现双端队列。<br>
你的实现需要支持以下操作：</p>

<ul>
	<li>MyCircularDeque(k)：构造函数,双端队列的大小为k。</li>
	<li>insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。</li>
	<li>insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。</li>
	<li>deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。</li>
	<li>deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。</li>
	<li>getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。</li>
	<li>getRear()：获得双端队列的最后一个元素。&nbsp;如果双端队列为空，返回 -1。</li>
	<li>isEmpty()：检查双端队列是否为空。</li>
	<li>isFull()：检查双端队列是否满了。</li>
</ul>

<p><strong>示例：</strong></p>

<pre>MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
&nbsp;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>所有值的范围为 [1, 1000]</li>
	<li>操作次数的范围为 [1, 1000]</li>
	<li>请不要使用内置的双端队列库。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class MyCircularDeque:

    def __init__(self, k: int):
        self.q = deque()
        self.k = k


    def insertFront(self, value: int) -> bool:
        if len(self.q) >= self.k:
            return False
        self.q.appendleft(value)
        return True


    def insertLast(self, value: int) -> bool:
        if len(self.q) >= self.k:
            return False
        self.q.append(value)
        return True


    def deleteFront(self) -> bool:
        if not self.q:
            return False
        self.q.popleft()
        return True


    def deleteLast(self) -> bool:
        if not self.q:
            return False
        self.q.pop()
        return True


    def getFront(self) -> int:
        if not self.q:
            return -1
        return self.q[0]


    def getRear(self) -> int:
        if not self.q:
            return -1
        return self.q[-1]


    def isEmpty(self) -> bool:
        return not self.q


    def isFull(self) -> bool:
        return len(self.q) >= self.k



# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyCircularDeque {
    Deque<Integer> q;
    int k;

    public MyCircularDeque(int k) {
        q = new ArrayDeque<>();
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if (q.size() >= k) {
            return false;
        }
        q.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (q.size() >= k) {
            return false;
        }
        q.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (q.isEmpty()) {
            return false;
        }
        q.pollFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if (q.isEmpty()) {
            return false;
        }
        q.pollLast();
        return true;
    }
    
    public int getFront() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekFirst();
    }
    
    public int getRear() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekLast();
    }
    
    public boolean isEmpty() {
        return q.isEmpty();
    }
    
    public boolean isFull() {
        return q.size() >= k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
```

### **...**

```

```

<!-- tabs:end -->
