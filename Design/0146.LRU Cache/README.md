# [146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache)



## 题目描述

<!-- 这里写题目描述 -->

<div class="title__3Vvk">运用你所掌握的数据结构，设计和实现一个  <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (最近最少使用) 缓存机制</a> 。</div>

<div class="original__bRMd">
<div>
<p>实现 <code>LRUCache</code> 类：</p>

<ul>
	<li><code>LRUCache(int capacity)</code> 以正整数作为容量 <code>capacity</code> 初始化 LRU 缓存</li>
	<li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li>
	<li><code>void put(int key, int value)</code> 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</li>
</ul>

<p> </p>
</div>
</div>

<p><strong>进阶</strong>：你是否可以在 <code>O(1)</code> 时间复杂度内完成这两种操作？</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>输出</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>解释</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= capacity <= 3000</code></li>
	<li><code>0 <= key <= 10000</code></li>
	<li><code>0 <= value <= 10<sup>5</sup></code></li>
	<li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class ListNode:
    def __init__(self, key = None, value = None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.mp = {}
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head


    def get(self, key: int) -> int:
        if key in self.mp:
            self.move_node_to_head(key)
        res = self.mp.get(key, -1)
        if res == -1:
            return res
        else:
            return res.value

    def put(self, key: int, value: int) -> None:
        if key not in self.mp and len(self.mp) == self.capacity:
            self.mp.pop(self.tail.prev.key)
            self.tail.prev.prev.next = self.tail.prev.next
            self.tail.prev.next.prev = self.tail.prev.prev

        if key in self.mp:
            node = self.mp[key]
            node.prev.next = node.next
            node.next.prev = node.prev

        new = ListNode(key, value)
        self.mp[key] = new
        new.next = self.head.next
        new.prev = self.head
        self.head.next.prev = new
        self.head.next = new
        
    
    def move_node_to_head(self, key):
        node = self.mp[key]
        node.prev.next = node.next
        node.next.prev = node.prev

        self.head.next.prev = node
        node.next = self.head.next
        node.prev = self.head
        self.head.next = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

### **...**

```

```

<!-- tabs:end -->
