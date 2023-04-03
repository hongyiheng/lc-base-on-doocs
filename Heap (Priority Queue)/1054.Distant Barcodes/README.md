# [1054. 距离相等的条形码](https://leetcode-cn.com/problems/distant-barcodes)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个仓库里，有一排条形码，其中第 <code>i</code> 个条形码为&nbsp;<code>barcodes[i]</code>。</p>

<p>请你重新排列这些条形码，使其中两个相邻的条形码 <strong>不能</strong> 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[1,1,1,2,2,2]
<strong>输出：</strong>[2,1,2,1,2,1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[1,1,1,1,2,2,3,3]
<strong>输出：</strong>[1,3,1,3,2,1,2,1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= barcodes.length &lt;= 10000</code></li>
	<li><code>1 &lt;= barcodes[i] &lt;= 10000</code></li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        m = 100010
        cnt = [0] * m
        for v in barcodes:
            cnt[v] += 1
        q = []
        for i, v in enumerate(cnt):
            if v:
                heapq.heappush(q, [-v, i])
        i = 0
        while q:
            v, x = heapq.heappop(q)
            barcodes[i] = x
            i += 1
            if q:
                nv, nx = heapq.heappop(q)
                barcodes[i] = nx
                i += 1
                if nv + 1 != 0:
                    heapq.heappush(q, [nv + 1, nx])
            if v + 1 != 0:
                heapq.heappush(q, [v + 1, x])
        return barcodes
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int m = 100010;
        int[] cnt = new int[m];
        for (int v : barcodes) {
            cnt[v] += 1;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < m; i++) {
            if (cnt[i] != 0) {
                q.add(new int[]{cnt[i], i});
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int[] mx = q.poll();
            barcodes[i++] = mx[1];
            if (!q.isEmpty()) {
                int[] nmx = q.poll();
                barcodes[i++] = nmx[1];
                if (nmx[0] - 1 != 0) {
                    q.add(new int[]{nmx[0] - 1, nmx[1]});
                }
            }
            if (mx[0] - 1 != 0) {
                q.add(new int[]{mx[0] - 1, mx[1]});
            }
        }
        return barcodes;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
