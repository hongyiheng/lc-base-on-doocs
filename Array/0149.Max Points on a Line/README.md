# [149. 直线上最多的点数](https://leetcode-cn.com/problems/max-points-on-a-line)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组 <code>points</code> ，其中 <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 表示 <strong>X-Y</strong> 平面上的一个点。求最多有多少个点在同一条直线上。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/plane1.jpg" style="width: 300px; height: 294px;" />
<pre>
<strong>输入：</strong>points = [[1,1],[2,2],[3,3]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/plane2.jpg" style="width: 300px; height: 294px;" />
<pre>
<strong>输入：</strong>points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
<strong>输出：</strong>4
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= points.length <= 300</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10<sup>4</sup> <= x<sub>i</sub>, y<sub>i</sub> <= 10<sup>4</sup></code></li>
	<li><code>points</code> 中的所有点 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def get_rate(p1, p2):
            return 0x3f3f3f3f if p2[0] - p1[0] == 0 else (p2[1] - p1[1]) / (p2[0] - p1[0])

        ans, n = 1, len(points)
        for i in range(n):
            for j in range(i + 1, n):
                rate = get_rate(points[i], points[j])
                cnt = 2
                for k in range(n):
                    if k == i or k == j:
                        continue
                    if get_rate(points[i], points[k]) == rate:
                        cnt += 1
                ans = max(ans, cnt)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxPoints(int[][] points) {
        int ans = 1, n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double rate = getRate(points[i], points[j]);
                int cnt = 2;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (getRate(points[i], points[k]) == rate) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    public double getRate(int[] p1, int[] p2) {
        return p2[0] - p1[0] == 0 ? 0x3f3f3f3f : (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
