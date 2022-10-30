# [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定 <em>n</em> 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>

<p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg" /></p>

<pre>
<strong>输入：</strong>heights = [2,1,5,6,2,3]
<strong>输出：</strong>10
<strong>解释：</strong>最大的矩形为图中红色区域，面积为 10
</pre>

<p><strong>示例 2：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg" /></p>

<pre>
<strong>输入：</strong> heights = [2,4]
<b>输出：</b> 4</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= heights.length <=10<sup>5</sup></code></li>
	<li><code>0 <= heights[i] <= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        ans = 0
        q = deque()
        for v in heights:
            if q and q[-1] > v:
                n = 1
                while q and q[-1] > v:
                    cur = q.pop()
                    ans = max(ans, cur * n)
                    n += 1
                for i in range(n - 1):
                    q.append(v)
            q.append(v)
        while q:
            ans = max(ans, q.popleft() * (len(q) + 1))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = heights.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int v = heights[i];
            if (!q.isEmpty() && q.peekLast() > v) {
                int m = 1;
                while (!q.isEmpty() && q.peekLast() > v) {
                    int cur = q.pollLast();
                    ans = Math.max(ans, cur * m++);
                }
                for (int j = 0; j < m - 1; j++) {
                    q.addLast(v);
                }
            }
            q.addLast(v);
        }
        while (!q.isEmpty()) {
            ans = Math.max(ans, q.pollFirst() * (q.size() + 1));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
