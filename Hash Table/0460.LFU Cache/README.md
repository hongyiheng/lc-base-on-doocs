# [460. LFU 缓存](https://leetcode-cn.com/problems/lfu-cache)



## 题目描述

<!-- 这里写题目描述 -->

<p>请你为 <a href="https://baike.baidu.com/item/%E7%BC%93%E5%AD%98%E7%AE%97%E6%B3%95">最不经常使用（LFU）</a>缓存算法设计并实现数据结构。</p>

<p>实现 <code>LFUCache</code> 类：</p>

<ul>
	<li><code>LFUCache(int capacity)</code> - 用数据结构的容量 <code>capacity</code> 初始化对象</li>
	<li><code>int get(int key)</code> - 如果键存在于缓存中，则获取键的值，否则返回 -1。</li>
	<li><code>void put(int key, int value)</code> - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 <strong>最近最久未使用</strong> 的键。</li>
</ul>

<p><strong>注意</strong>「项的使用次数」就是自插入该项以来对其调用 <code>get</code> 和 <code>put</code> 函数的次数之和。使用次数会在对应项被移除后置为 0 。</p>

<p>为了确定最不常使用的键，可以为缓存中的每个键维护一个 <strong>使用计数器</strong> 。使用计数最小的键是最久未使用的键。</p>

<p>当一个键首次插入到缓存中时，它的使用计数器被设置为 <code>1</code> (由于 put 操作)。对缓存中的键执行 <code>get</code> 或 <code>put</code> 操作，使用计数器的值将会递增。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
<strong>输出：</strong>
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

<strong>解释：</strong>
// cnt(x) = 键 x 的使用计数
// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
LFUCache lFUCache = new LFUCache(2);
lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lFUCache.get(1);      // 返回 1
                      // cache=[1,2], cnt(2)=1, cnt(1)=2
lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
                      // cache=[3,1], cnt(3)=1, cnt(1)=2
lFUCache.get(2);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
                      // cache=[3,1], cnt(3)=2, cnt(1)=2
lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
                      // cache=[4,3], cnt(4)=1, cnt(3)=2
lFUCache.get(1);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
                      // cache=[3,4], cnt(4)=1, cnt(3)=3
lFUCache.get(4);      // 返回 4
                      // cache=[3,4], cnt(4)=2, cnt(3)=3</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= capacity, key, value <= 10<sup>4</sup></code></li>
	<li>最多调用 <code>10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code> 方法</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以为这两种操作设计时间复杂度为 <code>O(1)</code> 的实现吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.minFreq = 0
        self.kv = dict()
        self.keyFreq = dict()
        self.freqKeys = defaultdict(deque)

    def get(self, key: int) -> int:
        if key not in self.kv:
            return -1
        self.incrFreq(key)
        return self.kv[key]

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key in self.kv:
            self.incrFreq(key)
        else:
            if len(self.kv) >= self.capacity:
                delKey = self.freqKeys[self.minFreq].popleft()
                if not self.freqKeys[self.minFreq]:
                    self.freqKeys.pop(self.minFreq)
                self.kv.pop(delKey)
                self.keyFreq.pop(delKey)
            self.keyFreq[key] = 1
            self.freqKeys[1].append(key)
            self.minFreq = 1
        self.kv[key] = value

    def incrFreq(self, key):
        f = self.keyFreq.get(key)
        self.freqKeys.get(f).remove(key)
        if not self.freqKeys.get(f):
            self.freqKeys.pop(f)
            if f == self.minFreq:
                self.minFreq += 1
        self.keyFreq[key] = f + 1
        self.freqKeys[f + 1].append(key)




# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
    class LFUCache {

        Map<Integer, Integer> kv, keyFreq;
        Map<Integer, Deque<Integer>> freqKeys;
        int minFreq, capacity;

        public LFUCache(int capacity) {
            kv = new HashMap<>();
            keyFreq = new HashMap<>();
            freqKeys = new HashMap<>();
            minFreq = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!kv.containsKey(key)) {
                return -1;
            }
            incrFreq(key);
            return kv.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (kv.containsKey(key)) {
                incrFreq(key);
            } else {
                if (kv.size() >= capacity) { 
                    int delKey = freqKeys.get(minFreq).pollFirst();
                    if (freqKeys.get(minFreq).isEmpty()) {
                        freqKeys.remove(minFreq);
                    }
                    kv.remove(delKey);
                    keyFreq.remove(delKey);
                }
                keyFreq.put(key, 1);
                freqKeys.computeIfAbsent(1, k -> new ArrayDeque<>()).addLast(key);
                minFreq = 1;
            }
            kv.put(key, value);
        }

        public void incrFreq(int key) {
            int f = keyFreq.get(key);
            freqKeys.get(f).remove(key);
            if (freqKeys.get(f).isEmpty()) {
                freqKeys.remove(f);
                if (f == minFreq) {
                    minFreq++;
                }  
            }
            keyFreq.put(key, f + 1);
            freqKeys.computeIfAbsent(f + 1, k -> new ArrayDeque<>()).addLast(key);
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

### **...**

```

```

<!-- tabs:end -->
