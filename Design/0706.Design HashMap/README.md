# [706. 设计哈希映射](https://leetcode-cn.com/problems/design-hashmap)



## 题目描述

<!-- 这里写题目描述 -->

<p>不使用任何内建的哈希表库设计一个哈希映射（HashMap）。</p>

<p>实现 <code>MyHashMap</code> 类：</p>

<ul>
	<li><code>MyHashMap()</code> 用空映射初始化对象</li>
	<li><code>void put(int key, int value)</code> 向 HashMap 插入一个键值对 <code>(key, value)</code> 。如果 <code>key</code> 已经存在于映射中，则更新其对应的值 <code>value</code> 。</li>
	<li><code>int get(int key)</code> 返回特定的 <code>key</code> 所映射的 <code>value</code> ；如果映射中不包含 <code>key</code> 的映射，返回 <code>-1</code> 。</li>
	<li><code>void remove(key)</code> 如果映射中存在 <code>key</code> 的映射，则移除 <code>key</code> 和它所对应的 <code>value</code> 。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>：
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
<strong>输出</strong>：
[null, null, null, 1, -1, null, 1, null, -1]

<strong>解释</strong>：
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= key, value <= 10<sup>6</sup></code></li>
	<li>最多调用 <code>10<sup>4</sup></code> 次 <code>put</code>、<code>get</code> 和 <code>remove</code> 方法</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你能否不使用内置的 HashMap 库解决此问题？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class MyHashMap:

    def __init__(self):
        self.s = [-1] * 1000010

    def put(self, key: int, value: int) -> None:
        self.s[key] = value

    def get(self, key: int) -> int:
        return self.s[key]

    def remove(self, key: int) -> None:
        self.s[key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyHashMap {

    int[] s;

    public MyHashMap() {
        s = new int[1000010];
        Arrays.fill(s, -1);
    }
    
    public void put(int key, int value) {
        s[key] = value;
    }
    
    public int get(int key) {
        return s[key];
    }
    
    public void remove(int key) {
        s[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```

### **...**

```

```

<!-- tabs:end -->
