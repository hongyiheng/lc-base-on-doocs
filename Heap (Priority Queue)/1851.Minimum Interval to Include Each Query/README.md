# [1851. 包含每个查询的最小区间](https://leetcode-cn.com/problems/minimum-interval-to-include-each-query)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二维整数数组 <code>intervals</code> ，其中 <code>intervals[i] = [left<sub>i</sub>, right<sub>i</sub>]</code> 表示第 <code>i</code> 个区间开始于 <code>left<sub>i</sub></code> 、结束于 <code>right<sub>i</sub></code>（包含两侧取值，<strong>闭区间</strong>）。区间的 <strong>长度</strong> 定义为区间中包含的整数数目，更正式地表达是 <code>right<sub>i</sub> - left<sub>i</sub> + 1</code> 。</p>

<p>再给你一个整数数组 <code>queries</code> 。第 <code>j</code> 个查询的答案是满足 <code>left<sub>i</sub> <= queries[j] <= right<sub>i</sub></code> 的 <strong>长度最小区间 <code>i</code> 的长度</strong> 。如果不存在这样的区间，那么答案是 <code>-1</code> 。</p>

<p>以数组形式返回对应查询的所有答案。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
<strong>输出：</strong>[3,3,1,4]
<strong>解释：</strong>查询处理如下：
- Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
- Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
- Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
- Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
<strong>输出：</strong>[2,-1,4,6]
<strong>解释：</strong>查询处理如下：
- Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
- Query = 19：不存在包含 19 的区间，答案为 -1 。
- Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
- Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= intervals.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= queries.length <= 10<sup>5</sup></code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>1 <= left<sub>i</sub> <= right<sub>i</sub> <= 10<sup>7</sup></code></li>
	<li><code>1 <= queries[j] <= 10<sup>7</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        qs = [[v, i] for i, v in enumerate(queries)]
        qs.sort()
        intervals.sort()
        idx, n = 0, len(intervals)
        ans = [-1] * len(queries)
        ins = []
        for v, i in qs:
            while idx < n and intervals[idx][0] <= v:
                l, r = intervals[idx]
                heapq.heappush(ins, [r - l + 1, r])
                idx += 1
            while ins and ins[0][1] < v:
                heapq.heappop(ins)
            if ins:
                ans[i] = ins[0][0]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> ins = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int idx = 0;
        for (int[] q : qs) {
            int v = q[0], i = q[1];
            while (idx < n && intervals[idx][0] <= v) {
                int l = intervals[idx][0], r = intervals[idx][1];
                ins.add(new int[]{r - l + 1, r});
                idx++;
            }
            while (!ins.isEmpty() && ins.peek()[1] < v) {
                ins.poll();
            }
            if (!ins.isEmpty()) {
                ans[i] = ins.peek()[0];
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
