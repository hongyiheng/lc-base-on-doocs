# [2502. 设计内存分配器](https://leetcode-cn.com/problems/design-memory-allocator)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数 <code>n</code> ，表示下标从 <strong>0</strong> 开始的内存数组的大小。所有内存单元开始都是空闲的。</p>

<p>请你设计一个具备以下功能的内存分配器：</p>

<ol>
	<li><strong>分配 </strong>一块大小为 <code>size</code> 的连续空闲内存单元并赋 id <code>mID</code> 。</li>
	<li><strong>释放</strong> 给定 id <code>mID</code> 对应的所有内存单元。</li>
</ol>

<p><strong>注意：</strong></p>

<ul>
	<li>多个块可以被分配到同一个 <code>mID</code> 。</li>
	<li>你必须释放 <code>mID</code> 对应的所有内存单元，即便这些内存单元被分配在不同的块中。</li>
</ul>

<p>实现 <code>Allocator</code> 类：</p>

<ul>
	<li><code>Allocator(int n)</code> 使用一个大小为 <code>n</code> 的内存数组初始化 <code>Allocator</code> 对象。</li>
	<li><code>int allocate(int size, int mID)</code> 找出大小为 <code>size</code> 个连续空闲内存单元且位于&nbsp; <strong>最左侧</strong> 的块，分配并赋 id <code>mID</code> 。返回块的第一个下标。如果不存在这样的块，返回 <code>-1</code> 。</li>
	<li><code>int free(int mID)</code> 释放 id <code>mID</code> 对应的所有内存单元。返回释放的内存单元数目。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入</strong>
["Allocator", "allocate", "allocate", "allocate", "free", "allocate", "allocate", "allocate", "free", "allocate", "free"]
[[10], [1, 1], [1, 2], [1, 3], [2], [3, 4], [1, 1], [1, 1], [1], [10, 2], [7]]
<strong>输出</strong>
[null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0]

<strong>解释</strong>
Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
loc.allocate(1, 1); // 最左侧的块的第一个下标是 0 。内存数组变为 [<strong>1</strong>, , , , , , , , , ]。返回 0 。
loc.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,<strong>2</strong>, , , , , , , , ]。返回 1 。
loc.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,<strong>3</strong>, , , , , , , ]。返回 2 。
loc.free(2); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,<strong>3</strong>, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
loc.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,<strong>4</strong>,<strong>4</strong>,<strong>4</strong>, , , , ]。返回 3 。
loc.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,<strong>1</strong>,3,4,4,4, , , , ]。返回 1 。
loc.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,<strong>1</strong>, , , ]。返回 6 。
loc.free(1); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4,<strong> </strong>, , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
loc.allocate(10, 2); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
loc.free(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n, size, mID &lt;= 1000</code></li>
	<li>最多调用 <code>allocate</code> 和 <code>free</code> 方法 <code>1000</code> 次</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Allocator:

    def __init__(self, n: int):
        self.m = [0] * n

    def allocate(self, size: int, mID: int) -> int:
        cnt = 0
        for i, v in enumerate(self.m):
            if v == 0:
                cnt += 1
            else:
                cnt = 0
            if cnt == size:
                for j in range(i - size + 1, i + 1):
                    self.m[j] = mID
                return i - size + 1
        return -1

    def freeMemory(self, mID: int) -> int:
        ans = 0
        for i, v in enumerate(self.m):
            if v == mID:
                self.m[i] = 0
                ans += 1
        return ans



# Your Allocator object will be instantiated and called as such:
# obj = Allocator(n)
# param_1 = obj.allocate(size,mID)
# param_2 = obj.free(mID)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Allocator {

    int[] q;

    public Allocator(int n) {
        q = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int cnt = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == size) {
                for (int j = i - size + 1; j <= i; j++) {
                    q[j] = mID;
                }
                return i - size + 1;
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int ans = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == mID) {
                q[i] = 0;
                ans++;
            }
        }
        return ans;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
```

### **...**

```

```

<!-- tabs:end -->
