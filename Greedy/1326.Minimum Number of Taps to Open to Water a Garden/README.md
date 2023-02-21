# [1326. 灌溉花园的最少水龙头数目](https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden)



## 题目描述

<!-- 这里写题目描述 -->

<p>在 x 轴上有一个一维的花园。花园长度为&nbsp;<code>n</code>，从点&nbsp;<code>0</code>&nbsp;开始，到点&nbsp;<code>n</code>&nbsp;结束。</p>

<p>花园里总共有&nbsp;<code>n + 1</code> 个水龙头，分别位于&nbsp;<code>[0, 1, ..., n]</code> 。</p>

<p>给你一个整数&nbsp;<code>n</code>&nbsp;和一个长度为&nbsp;<code>n + 1</code> 的整数数组&nbsp;<code>ranges</code>&nbsp;，其中&nbsp;<code>ranges[i]</code> （下标从 0 开始）表示：如果打开点&nbsp;<code>i</code>&nbsp;处的水龙头，可以灌溉的区域为&nbsp;<code>[i -&nbsp; ranges[i], i + ranges[i]]</code>&nbsp;。</p>

<p>请你返回可以灌溉整个花园的&nbsp;<strong>最少水龙头数目</strong>&nbsp;。如果花园始终存在无法灌溉到的地方，请你返回&nbsp;<strong>-1</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/19/1685_example_1.png" style="width: 530px;"></p>

<pre><strong>输入：</strong>n = 5, ranges = [3,4,1,1,0,0]
<strong>输出：</strong>1
<strong>解释：
</strong>点 0 处的水龙头可以灌溉区间 [-3,3]
点 1 处的水龙头可以灌溉区间 [-3,5]
点 2 处的水龙头可以灌溉区间 [1,3]
点 3 处的水龙头可以灌溉区间 [2,4]
点 4 处的水龙头可以灌溉区间 [4,4]
点 5 处的水龙头可以灌溉区间 [5,5]
只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 3, ranges = [0,0,0,0]
<strong>输出：</strong>-1
<strong>解释：</strong>即使打开所有水龙头，你也无法灌溉整个花园。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 7, ranges = [1,2,1,0,2,1,0,1]
<strong>输出：</strong>3
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>n = 8, ranges = [4,0,0,0,0,0,0,0,4]
<strong>输出：</strong>2
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>n = 8, ranges = [4,0,0,0,4,0,0,0,4]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10^4</code></li>
	<li><code>ranges.length == n + 1</code></li>
	<li><code>0 &lt;= ranges[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        M = n + 10
        rs = [0] * M
        for i, v in enumerate(ranges):
            l, r = max(0, i - v), i + v
            rs[l] = max(rs[l], r)
        ans = l = r = 0
        while l < M and r < n:
            if r < l:
                return -1
            mx = r
            for i in range(l, min(r + 1, M)):
                mx = max(mx, rs[i])
            l, r = r + 1, mx
            ans += 1
        return ans if r >= n else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minTaps(int n, int[] ranges) {
        int M = n + 10;
        int[] rs = new int[M];
        for (int i = 0; i < ranges.length; i++) {
            int l = Math.max(0, i - ranges[i]), r = Math.min(n, i + ranges[i]);
            rs[l] = Math.max(rs[l], r);
        }
        int ans = 0, l = 0, r = 0;
        while (l < M && r < n) {
            if (r < l) {
                return -1;
            }
            int mx = r;
            for (int i = l; i <= r; i++) {
                mx = Math.max(mx, rs[i]);
            }
            l = r + 1;
            r = mx;
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
