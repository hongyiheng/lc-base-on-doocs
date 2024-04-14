# [705. 设计哈希集合](https://leetcode-cn.com/problems/design-hashset)



## 题目描述

<!-- 这里写题目描述 -->

<p>不使用任何内建的哈希表库设计一个哈希集合（HashSet）。</p>

<p>实现 <code>MyHashSet</code> 类：</p>

<ul>
	<li><code>void add(key)</code> 向哈希集合中插入值 <code>key</code> 。</li>
	<li><code>bool contains(key)</code> 返回哈希集合中是否存在这个值 <code>key</code> 。</li>
	<li><code>void remove(key)</code> 将给定值 <code>key</code> 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。</li>
</ul>
 

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
<strong>输出：</strong>
[null, null, null, true, false, null, true, null, false]

<strong>解释：</strong>
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // 返回 True
myHashSet.contains(3); // 返回 False ，（未找到）
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // 返回 True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // 返回 False ，（已移除）</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= key <= 10<sup>6</sup></code></li>
	<li>最多调用 <code>10<sup>4</sup></code> 次 <code>add</code>、<code>remove</code> 和 <code>contains</code> 。</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以不使用内建的哈希集合库解决此问题吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class MyHashSet:

    def __init__(self):
        self.s = [False] * 1000010

    def add(self, key: int) -> None:
        self.s[key] = True

    def remove(self, key: int) -> None:
        self.s[key] = False

    def contains(self, key: int) -> bool:
        return self.s[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyHashSet {

    boolean[] s;

    public MyHashSet() {
        s = new boolean[1000010];
    }
    
    public void add(int key) {
        s[key] = true;
    }
    
    public void remove(int key) {
        s[key] = false;
    }
    
    public boolean contains(int key) {
        return s[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```

### **...**

```

```

<!-- tabs:end -->
