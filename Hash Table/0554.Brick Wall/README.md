# [554. 砖墙](https://leetcode-cn.com/problems/brick-wall)



## 题目描述

<!-- 这里写题目描述 -->

<p>你的面前有一堵矩形的、由 <code>n</code> 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。</p>

<p>你现在要画一条 <strong>自顶向下 </strong>的、穿过 <strong>最少 </strong>砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。<strong>你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。</strong></p>

<p>给你一个二维数组 <code>wall</code> ，该数组包含这堵墙的相关信息。其中，<code>wall[i]</code> 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 <strong>穿过的砖块数量最少</strong> ，并且返回 <strong>穿过的砖块数量</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/cutwall-grid.jpg" style="width: 493px; height: 577px;" />
<pre>
<strong>输入：</strong>wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>wall = [[1],[1],[1]]
<strong>输出：</strong>3
</pre>
 

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == wall.length</code></li>
	<li><code>1 <= n <= 10<sup>4</sup></code></li>
	<li><code>1 <= wall[i].length <= 10<sup>4</sup></code></li>
	<li><code>1 <= sum(wall[i].length) <= 2 * 10<sup>4</sup></code></li>
	<li>对于每一行 <code>i</code> ，<code>sum(wall[i])</code> 是相同的</li>
	<li><code>1 <= wall[i][j] <= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        m, n = len(wall), sum(wall[0])
        interval = defaultdict(int)
        for i, row in enumerate(wall):
            s = 0
            for v in row:
                s += v
                if s == n:
                    continue
                interval[s] += 1
        return m - max(interval.values()) if interval.values() else m
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size(), n = wall.get(0).stream().mapToInt(e->e).sum();
        Map<Integer, Integer> interval = new HashMap<>();
        for (List<Integer> row : wall) {
            int s = 0;
            for (int v : row) {
                s += v;
                if (s == n) {
                    continue;
                }
                interval.put(s, interval.getOrDefault(s, 0) + 1);
            }
        }
        int ans = m;
        for (int v : interval.values()) {
            ans = Math.min(ans, m - v);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
