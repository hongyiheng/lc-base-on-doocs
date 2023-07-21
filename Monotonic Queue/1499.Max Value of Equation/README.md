# [1499. 满足不等式的最大值](https://leetcode-cn.com/problems/max-value-of-equation)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组 <code>points</code> 和一个整数 <code>k</code> 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> ，并且在 <code>1 &lt;= i &lt; j &lt;= points.length</code> 的前提下， <code>x<sub>i</sub> &lt; x<sub>j</sub></code> 总成立。</p>

<p>请你找出<em> </em><code>y<sub>i</sub>&nbsp;+ y<sub>j</sub>&nbsp;+ |x<sub>i</sub>&nbsp;- x<sub>j</sub>|</code> 的 <strong>最大值</strong>，其中 <code>|x<sub>i</sub>&nbsp;- x<sub>j</sub>|&nbsp;&lt;= k</code> 且 <code>1 &lt;= i &lt; j &lt;= points.length</code>。</p>

<p>题目测试数据保证至少存在一对能够满足 <code>|x<sub>i</sub>&nbsp;- x<sub>j</sub>|&nbsp;&lt;= k</code> 的点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
<strong>输出：</strong>4
<strong>解释：</strong>前两个点满足 |x<sub>i</sub>&nbsp;- x<sub>j</sub>| &lt;= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 10 + -10 + |5 - 6| = 1 。
没有其他满足条件的点，所以返回 4 和 1 中最大的那个。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>points = [[0,0],[3,0],[9,2]], k = 3
<strong>输出：</strong>3
<strong>解释：</strong>只有前两个点满足 |x<sub>i</sub>&nbsp;- x<sub>j</sub>| &lt;= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= points.length &lt;= 10^5</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10^8&nbsp;&lt;= points[i][0], points[i][1] &lt;= 10^8</code></li>
	<li><code>0 &lt;= k &lt;= 2 * 10^8</code></li>
	<li>对于所有的<code>1 &lt;= i &lt; j &lt;= points.length</code> ，<code>points[i][0] &lt; points[j][0]</code> 都成立。也就是说，<code>x<sub>i</sub></code> 是严格递增的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        n = len(points)
        q = deque()
        ans = -inf
        idx = 0
        for i, v in enumerate(points):
            x, y = v
            idx = max(idx, i + 1)
            while q and q[0][0] <= x:
                q.popleft()
            while idx < n and points[idx][0] - x <= k:
                while q and q[-1][0] + q[-1][1] < points[idx][0] + points[idx][1]:
                    q.pop()
                q.append(points[idx])
                idx += 1
            if q:
                ans = max(ans, q[0][0] - x + q[0][1] + y)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        Deque<int[]> q = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = Math.max(i + 1, idx);
            int x = points[i][0], y = points[i][1];
            while (!q.isEmpty() && q.peekFirst()[0] <= x) {
                q.pollFirst();
            }
            while (idx < n && points[idx][0] - x <= k) {
                while (!q.isEmpty() && q.peekLast()[0] + q.peekLast()[1] < points[idx][0] + points[idx][1]) {
                    q.pollLast();
                }
                q.addLast(new int[]{points[idx][0], points[idx][1]});
                idx++;
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, q.peekFirst()[0] - x + q.peekFirst()[1] + y);
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
