# [2080. 区间内查询数字的频率](https://leetcode-cn.com/problems/range-frequency-queries)

## 题目描述

<!-- 这里写题目描述 -->

<p>请你设计一个数据结构，它能求出给定子数组内一个给定值的 <strong>频率</strong>&nbsp;。</p>

<p>子数组中一个值的 <strong>频率</strong>&nbsp;指的是这个子数组中这个值的出现次数。</p>

<p>请你实现&nbsp;<code>RangeFreqQuery</code>&nbsp;类：</p>

<ul>
	<li><code>RangeFreqQuery(int[] arr)</code>&nbsp;用下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>arr</code>&nbsp;构造一个类的实例。</li>
	<li><code>int query(int left, int right, int value)</code>&nbsp;返回子数组&nbsp;<code>arr[left...right]</code>&nbsp;中&nbsp;<code>value</code>&nbsp;的&nbsp;<strong>频率</strong>&nbsp;。</li>
</ul>

<p>一个 <strong>子数组</strong> 指的是数组中一段连续的元素。<code>arr[left...right]</code>&nbsp;指的是 <code>nums</code>&nbsp;中包含下标 <code>left</code>&nbsp;和 <code>right</code>&nbsp;<strong>在内</strong>&nbsp;的中间一段连续元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
["RangeFreqQuery", "query", "query"]
[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
<strong>输出：</strong>
[null, 1, 2]

<strong>解释：</strong>
RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i], value &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= left &lt;= right &lt; arr.length</code></li>
	<li>调用&nbsp;<code>query</code>&nbsp;不超过&nbsp;<code>10<sup>5</sup></code>&nbsp;次。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.g = defaultdict(list)
        for i, v in enumerate(arr):
            self.g[v].append(i)

    def query(self, left: int, right: int, value: int) -> int:
        idxs = self.g[value]
        l = bisect_left(idxs, left)
        r = bisect_left(idxs, right + 1)
        return r - l
        
# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class RangeFreqQuery {

    Map<Integer, List<Integer>> g = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            g.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int search(List<Integer> q, int t) {
        int l = 0, r = q.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    
    public int query(int left, int right, int value) {
        List<Integer> q = g.get(value);
        if (q == null) {
            return 0;
        }
        int l = search(q, left);
        int r = search(q, right + 1);
        return r - l;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
```

### **...**

```

```

<!-- tabs:end -->
