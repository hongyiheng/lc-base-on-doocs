# [1157. 子数组中占绝大多数的元素](https://leetcode-cn.com/problems/online-majority-element-in-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>实现一个&nbsp;<code>MajorityChecker</code>&nbsp;的类，它应该具有下述几个 API：</p>

<ul>
	<li><code>MajorityChecker(int[] arr)</code>&nbsp;会用给定的数组 <code>arr</code>&nbsp;来构造一个 <code>MajorityChecker</code> 的实例。</li>
	<li><code>int query(int left, int right, int threshold)</code>&nbsp;有这么几个参数：
	<ul>
		<li><code>0 &lt;= left&nbsp;&lt;= right&nbsp;&lt; arr.length</code> 表示数组&nbsp;<code>arr</code>&nbsp;的子数组的长度。</li>
		<li><code>2 * threshold &gt; right - left + 1</code>，也就是说阈值 <code>threshold</code>&nbsp;始终比子序列长度的一半还要大。</li>
	</ul>
	</li>
</ul>

<p>每次查询&nbsp;<code>query(...)</code>&nbsp;会返回在&nbsp;<code>arr[left], arr[left+1], ..., arr[right]</code>&nbsp;中至少出现阈值次数&nbsp;<code>threshold</code>&nbsp;的元素，如果不存在这样的元素，就返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
majorityChecker.query(0,5,4); // 返回 1
majorityChecker.query(0,3,3); // 返回 -1
majorityChecker.query(2,3,2); // 返回 2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;=&nbsp;20000</code></li>
	<li><code>1 &lt;= arr[i]&nbsp;&lt;=&nbsp;20000</code></li>
	<li>对于每次查询，<code>0 &lt;= left &lt;= right &lt; len(arr)</code></li>
	<li>对于每次查询，<code>2 * threshold &gt; right - left + 1</code></li>
	<li>查询次数最多为 <code>10000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class MajorityChecker:

    def __init__(self, arr: List[int]):
        self.g = defaultdict(list)
        self.arr = arr
        for i, v in enumerate(arr):
            self.g[v].append(i)

    def query(self, left: int, right: int, threshold: int) -> int:
        for _ in range((right - left + 1) // threshold + 10):
            i = random.randint(left, right)
            v = self.arr[i]
            if len(self.g[v]) < threshold:
                continue
            ids = self.g[v]
            l, r = self.query_left(ids, left), self.query_right(ids, right)
            if r - l + 1 >= threshold:
                return v
        return -1
    
    def query_left(self, ids, x):
        l, r = 0, len(ids) - 1
        while l < r:
            mid = (l + r) >> 1
            if ids[mid] < x:
                l = mid + 1
            else:
                r = mid
        return l
    
    def query_right(self, ids, x):
        l, r = 0, len(ids) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if ids[mid] <= x:
                l = mid
            else:
                r = mid - 1
        return r if ids[r] <= x else -1

# Your MajorityChecker object will be instantiated and called as such:
# obj = MajorityChecker(arr)
# param_1 = obj.query(left,right,threshold)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MajorityChecker {

    int[] arr;
    Map<Integer, List<Integer>> g;
    Random random;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        g = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            g.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        random = new Random();
    }

    public int query(int left, int right, int threshold) {
        for (int i = 0; i < (right - left + 1) / threshold + 10; i++) {
            int v = arr[random.nextInt(right - left + 1) + left];
            List<Integer> ids = g.get(v);
            if (ids.size() < threshold) {
                continue;
            }
            int l = queryLeft(ids, left), r = queryRight(ids, right);
            if (r - l + 1 >= threshold) {
                return v;
            }
        }
        return -1;
    }

    public int queryLeft(List<Integer> ids, int left) {
        int l = 0, r = ids.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (ids.get(mid) < left) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int queryRight(List<Integer> ids, int right) {
        int l = 0, r = ids.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (ids.get(mid) <= right) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return ids.get(r) <= right ? r : -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
```

### **...**

```

```

<!-- tabs:end -->
