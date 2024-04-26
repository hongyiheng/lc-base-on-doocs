# [1146. 快照数组](https://leetcode-cn.com/problems/snapshot-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>实现支持下列接口的「快照数组」-&nbsp;SnapshotArray：</p>

<ul>
	<li><code>SnapshotArray(int length)</code>&nbsp;- 初始化一个与指定长度相等的 类数组 的数据结构。<strong>初始时，每个元素都等于</strong><strong>&nbsp;0</strong>。</li>
	<li><code>void set(index, val)</code>&nbsp;- 会将指定索引&nbsp;<code>index</code>&nbsp;处的元素设置为&nbsp;<code>val</code>。</li>
	<li><code>int snap()</code>&nbsp;- 获取该数组的快照，并返回快照的编号&nbsp;<code>snap_id</code>（快照号是调用&nbsp;<code>snap()</code>&nbsp;的总次数减去&nbsp;<code>1</code>）。</li>
	<li><code>int get(index, snap_id)</code>&nbsp;- 根据指定的&nbsp;<code>snap_id</code>&nbsp;选择快照，并返回该快照指定索引 <code>index</code>&nbsp;的值。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[&quot;SnapshotArray&quot;,&quot;set&quot;,&quot;snap&quot;,&quot;set&quot;,&quot;get&quot;]
     [[3],[0,5],[],[0,6],[0,0]]
<strong>输出：</strong>[null,null,0,null,5]
<strong>解释：
</strong>SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
snapshotArr.set(0,5);  // 令 array[0] = 5
snapshotArr.snap();  // 获取快照，返回 snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= length&nbsp;&lt;= 50000</code></li>
	<li>题目最多进行<code>50000</code> 次<code>set</code>，<code>snap</code>，和&nbsp;<code>get</code>的调用 。</li>
	<li><code>0 &lt;= index&nbsp;&lt;&nbsp;length</code></li>
	<li><code>0 &lt;=&nbsp;snap_id &lt;&nbsp;</code>我们调用&nbsp;<code>snap()</code>&nbsp;的总次数</li>
	<li><code>0 &lt;=&nbsp;val &lt;= 10^9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class SnapshotArray:

    def __init__(self, length: int):
        self.g = defaultdict(list)
        self.ver = 0

    def set(self, index: int, val: int) -> None:
        self.g[index].append((self.ver, val))

    def snap(self) -> int:
        ver = self.ver
        self.ver += 1
        return ver

    def get(self, index: int, snap_id: int) -> int:
        q = self.g.get(index, list())
        if not q:
            return 0
        l, r = 0, len(q) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if q[mid][0] > snap_id:
                r = mid - 1
            else:
                l = mid
        return 0 if q[r][0] > snap_id else q[r][1]


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class SnapshotArray {

    Map<Integer, List<int[]>> g;
    int ver;

    public SnapshotArray(int length) {
        g = new HashMap<>();
        ver = 0;
    }
    
    public void set(int index, int val) {
        g.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{ver, val});
    }
    
    public int snap() {
        return ver++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> q = g.getOrDefault(index, new ArrayList<>());
        if (q.isEmpty()) {
            return 0;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (q.get(mid)[0] > snap_id) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return q.get(r)[0] <= snap_id ? q.get(r)[1] : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
```

### **...**

```

```

<!-- tabs:end -->
