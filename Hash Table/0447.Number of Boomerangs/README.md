# [447. 回旋镖的数量](https://leetcode-cn.com/problems/number-of-boomerangs)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定平面上<em> </em><code>n</code><em> </em>对 <strong>互不相同</strong> 的点 <code>points</code> ，其中 <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 。<strong>回旋镖</strong> 是由点 <code>(i, j, k)</code> 表示的元组 ，其中 <code>i</code> 和 <code>j</code> 之间的距离和 <code>i</code> 和 <code>k</code> 之间的距离相等（<strong>需要考虑元组的顺序</strong>）。</p>

<p>返回平面上所有回旋镖的数量。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>points = [[0,0],[1,0],[2,0]]
<strong>输出：</strong>2
<strong>解释：</strong>两个回旋镖为 <strong>[[1,0],[0,0],[2,0]]</strong> 和 <strong>[[1,0],[2,0],[0,0]]</strong>
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>points = [[1,1],[2,2],[3,3]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>points = [[1,1]]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == points.length</code></li>
	<li><code>1 <= n <= 500</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10<sup>4</sup> <= x<sub>i</sub>, y<sub>i</sub> <= 10<sup>4</sup></code></li>
	<li>所有点都 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        n, ans = len(points), 0
        for i in range(n):
            cnt = defaultdict(int)
            for j in range(n):
                if i == j:
                    continue
                x = points[j][0] - points[i][0]
                y = points[j][1] - points[i][1]
                d = x * x + y * y
                if d in cnt:
                    ans += cnt[d] * 2
                cnt[d] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int d = x * x + y * y;
                if (cnt.containsKey(d)) {
                    ans += cnt.get(d) * 2;
                }
                cnt.put(d, cnt.getOrDefault(d, 0) + 1);
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
