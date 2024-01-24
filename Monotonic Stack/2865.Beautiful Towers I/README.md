# [2865. 美丽塔 I](https://leetcode-cn.com/problems/beautiful-towers-i)

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
	<li><code>1 &lt;= n == maxHeights &lt;= 10<sup>3</sup></code></li>
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
        pre, suf = [0] * n, [0] * n
        q = deque()
        for i, v in enumerate(maxHeights):
            while q and q[-1][0] > v:
                q.pop()
            s, last = 0, -1
            for h, j in q:
                s += (j - last) * h
                last = j
            q.append([v, i])
            pre[i] = s + (i - last) * v
        q.clear()
        for i in range(n - 1, -1, -1):
            v = maxHeights[i]
            while q and q[-1][0] > v:
                q.pop()
            s, last = 0, n
            for h, j in q:
                s += (last - j) * h
                last = j
            q.append([v, i])
            suf[i] = s + (last - i) * v
        ans = max(suf[0], pre[-1])
        for i in range(n - 1):
            ans = max(ans, pre[i] + suf[i + 1])
        return ans 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] pre = new long[n], suf = new long[n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[0] > v) {
                q.pollLast();
            }
            long s = 0, last = -1;
            for (int[] e : q) {
                s += (e[1] - last) * e[0];
                last = e[1];
            }
            q.add(new int[]{v, i});
            pre[i] = s + (i - last) * v;
        }
        q.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[0] > v) {
                q.pollLast();
            }
            long s = 0, last = n;
            for (int[] e : q) {
                s += (last - e[1]) * e[0];
                last = e[1];
            }
            q.add(new int[]{v, i});
            suf[i] = s + (last - i) * v;
        }
        long ans = Math.max(pre[n - 1], suf[0]);
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, pre[i] + suf[i + 1]);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
