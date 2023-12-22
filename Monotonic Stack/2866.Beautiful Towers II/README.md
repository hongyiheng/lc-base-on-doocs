# [2866. 美丽塔 II](https://leetcode-cn.com/problems/beautiful-towers-ii)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>maxHeights</code>&nbsp;。</p>

<p>你的任务是在坐标轴上建 <code>n</code>&nbsp;座塔。第&nbsp;<code>i</code>&nbsp;座塔的下标为 <code>i</code>&nbsp;，高度为&nbsp;<code>heights[i]</code>&nbsp;。</p>

<p>如果以下条件满足，我们称这些塔是 <strong>美丽</strong>&nbsp;的：</p>

<ol>
	<li><code>1 &lt;= heights[i] &lt;= maxHeights[i]</code></li>
	<li><code>heights</code>&nbsp;是一个 <strong>山状</strong>&nbsp;数组。</li>
</ol>

<p>如果存在下标 <code>i</code>&nbsp;满足以下条件，那么我们称数组&nbsp;<code>heights</code>&nbsp;是一个 <strong>山状</strong>&nbsp;数组：</p>

<ul>
	<li>对于所有&nbsp;<code>0 &lt; j &lt;= i</code>&nbsp;，都有&nbsp;<code>heights[j - 1] &lt;= heights[j]</code></li>
	<li>对于所有&nbsp;<code>i &lt;= k &lt; n - 1</code>&nbsp;，都有&nbsp;<code>heights[k + 1] &lt;= heights[k]</code></li>
</ul>

<p>请你返回满足 <b>美丽塔</b>&nbsp;要求的方案中，<strong>高度和的最大值</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>maxHeights = [5,3,4,1,1]
<b>输出：</b>13
<b>解释：</b>和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
- 1 &lt;= heights[i] &lt;= maxHeights[i]  
- heights 是个山状数组，峰值在 i = 0 处。
13 是所有美丽塔方案中的最大高度和。</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>maxHeights = [6,5,3,9,2,7]
<b>输出：</b>22
<strong>解释：</strong> 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
- 1 &lt;= heights[i] &lt;= maxHeights[i]
- heights 是个山状数组，峰值在 i = 3 处。
22 是所有美丽塔方案中的最大高度和。</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<b>输入：</b>maxHeights = [3,2,5,5,2,3]
<b>输出：</b>18
<strong>解释：</strong>和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
- 1 &lt;= heights[i] &lt;= maxHeights[i]
- heights 是个山状数组，最大值在 i = 2 处。
注意，在这个方案中，i = 3 也是一个峰值。
18 是所有美丽塔方案中的最大高度和。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n == maxHeights&nbsp;&lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= maxHeights[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n = len(maxHeights)
        q = deque()
        pre = [0] * (n + 1)
        for i, v in enumerate(maxHeights):
            l = r = i
            while q and q[-1][1] > v:
                l, lv = q.pop()
                pre[i + 1] -= lv * (r - l)
                r = l
            pre[i + 1] += pre[i] + (i - l + 1) * v
            q.append([l, v])

        q = deque()
        tail = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            v = maxHeights[i]
            l = r = i
            while q and q[0][1] > v:
                r, rv = q.popleft()
                tail[i] -= rv * (r - l)
                l = r
            tail[i] += tail[i + 1] + (r - i + 1) * v
            q.appendleft([r, v])

        ans = 0
        for i in range(n):
            ans = max(ans, pre[i] + tail[i])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Deque<int[]> q = new ArrayDeque<>();
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int l = i, r = i, v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[1] > v) {
                int[] t = q.pollLast();
                l = t[0];
                pre[i + 1] -= (long) (r - l) * t[1];
                r = l;
            }
            pre[i + 1] += pre[i] + (long) (i - l + 1) * v;
            q.offerLast(new int[]{l, v});
        }
        
        q.clear();
        long[] tail = new long[n + 1];
        for (int i = n - 1; i > -1; i--) {
            int l = i, r = i, v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekFirst()[1] > v) {
                int[] t = q.pollFirst();
                r = t[0];
                tail[i] -= (long) (r - l) * t[1];
                l = r;
            }
            tail[i] += tail[i + 1] + (long) (r - i + 1) * v;
            q.offerFirst(new int[]{r, v});
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre[i] + tail[i]);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
