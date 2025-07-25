# [1353. 最多可以参加的会议数目](https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组&nbsp;<code>events</code>，其中&nbsp;<code>events[i] = [startDay<sub>i</sub>, endDay<sub>i</sub>]</code>&nbsp;，表示会议&nbsp;<code>i</code>&nbsp;开始于&nbsp;<code>startDay<sub>i</sub></code>&nbsp;，结束于&nbsp;<code>endDay<sub>i</sub></code>&nbsp;。</p>

<p>你可以在满足&nbsp;<code>startDay<sub>i</sub>&nbsp;&lt;= d &lt;= endDay<sub>i</sub></code><sub>&nbsp;</sub>中的任意一天&nbsp;<code>d</code>&nbsp;参加会议&nbsp;<code>i</code>&nbsp;。注意，一天只能参加一个会议。</p>

<p>请你返回你可以参加的&nbsp;<strong>最大&nbsp;</strong>会议数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/16/e1.png" style="height: 400px; width: 600px;"></p>

<pre><strong>输入：</strong>events = [[1,2],[2,3],[3,4]]
<strong>输出：</strong>3
<strong>解释：</strong>你可以参加所有的三个会议。
安排会议的一种方案如上图。
第 1 天参加第一个会议。
第 2 天参加第二个会议。
第 3 天参加第三个会议。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>events= [[1,2],[2,3],[3,4],[1,2]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>events = [[1,100000]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
<strong>输出：</strong>7
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= events.length &lt;= 10^5</code></li>
	<li><code>events[i].length == 2</code></li>
	<li><code>1 &lt;= events[i][0] &lt;= events[i][1] &lt;= 10^5</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        mp = defaultdict(list)
        n = 0
        for a, b in events:
            mp[a].append(b)
            n = max(n, b)
        q = []
        ans = 0
        for i in range(n + 1):
            if i in mp:
                for v in mp[i]:
                    heapq.heappush(q, (v, i))
            while q and q[0][0] < i:
                heapq.heappop(q)
            if q and q[0][1] <= i:
                ans += 1
                heapq.heappop(q)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxEvents(int[][] events) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = 0;
        for (int[] v : events) {
            mp.computeIfAbsent(v[0], k -> new ArrayList<>()).add(v[1]);
            n = Math.max(n, v[1]);
        }
        int ans = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(n, (a, b) -> a[0] - b[0]);
        for (int i = 1; i <= n; i++) {
            if (mp.containsKey(i)) {
                for (int v : mp.get(i)) {
                    q.offer(new int[]{v, i});
                }
            }
            while (!q.isEmpty() && q.peek()[0] < i) {
                q.poll();
            }
            if (!q.isEmpty() && q.peek()[1] <= i) {
                ans++;
                q.poll();
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
