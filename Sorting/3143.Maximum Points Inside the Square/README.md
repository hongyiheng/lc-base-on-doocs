# [3143. 正方形中的最多点数](https://leetcode.cn/problems/maximum-points-inside-the-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二维数组&nbsp;<code>points</code>&nbsp;和一个字符串&nbsp;<code>s</code>&nbsp;，其中&nbsp;<code>points[i]</code>&nbsp;表示第 <code>i</code>&nbsp;个点的坐标，<code>s[i]</code>&nbsp;表示第 <code>i</code>&nbsp;个点的 <strong>标签</strong>&nbsp;。</p>

<p>如果一个正方形的中心在&nbsp;<code>(0, 0)</code>&nbsp;，所有边都平行于坐标轴，且正方形内&nbsp;<strong>不</strong>&nbsp;存在标签相同的两个点，那么我们称这个正方形是&nbsp;<strong>合法</strong>&nbsp;的。</p>

<p>请你返回 <strong>合法</strong>&nbsp;正方形中可以包含的 <strong>最多</strong>&nbsp;点数。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。</li>
	<li>正方形的边长可以为零。</li>
</ul>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/03/29/3708-tc1.png" style="width: 303px; height: 303px;" /></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca"</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p>边长为 4 的正方形包含两个点&nbsp;<code>points[0]</code> 和&nbsp;<code>points[1]</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/03/29/3708-tc2.png" style="width: 302px; height: 302px;" /></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>points = [[1,1],[-2,-2],[-2,2]], s = "abb"</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><strong>解释：</strong></p>

<p>边长为 2 的正方形包含 1 个点&nbsp;<code>points[0]</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>points = [[1,1],[-1,-1],[2,-2]], s = "ccd"</span></p>

<p><span class="example-io"><b>输出：</b>0</span></p>

<p><strong>解释：</strong></p>

<p>任何正方形都无法只包含&nbsp;<code>points[0]</code> 和&nbsp;<code>points[1]</code>&nbsp;中的一个点，所以合法正方形中都不包含任何点。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length, points.length &lt;= 10<sup>5</sup></code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10<sup>9</sup> &lt;= points[i][0], points[i][1] &lt;= 10<sup>9</sup></code></li>
	<li><code>s.length == points.length</code></li>
	<li><code>points</code>&nbsp;中的点坐标互不相同。</li>
	<li><code>s</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        def f(i, d):
            ans = 0
            while i < len(points):
                x, y, j = q[i]
                if abs(x) > d or abs(y) > d:
                    return ans
                if s[j] in vis:
                    return -1
                vis.add(s[j])
                ans += 1
                i += 1
            return ans

        q = [(v[0], v[1], i) for i, v in enumerate(points)]
        q.sort(key=lambda x: max(abs(x[0]), abs(x[1])))
        i = 0
        vis = set()
        while i < len(points):
            x, y, j = q[i]
            cnt = f(i, max(abs(x), abs(y)))
            if cnt == -1:
                return i
            i += cnt
        return i
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<int[]> q = new ArrayList<>();
    Set<Character> vis = new HashSet<>();

    public int f(int i, int d, String s) {
        int ans = 0;
        while (i < q.size()) {
            int x = q.get(i)[0], y = q.get(i)[1], j = q.get(i)[2];
            if (x > d || y > d) {
                break;
            }
            if (vis.contains(s.charAt(j))) {
                return -1;
            }
            vis.add(s.charAt(j));
            ans++;
            i++;
        }
        return ans;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            q.add(new int[]{Math.abs(p[0]), Math.abs(p[1]), i});
        }
        Collections.sort(q, Comparator.comparingInt(a -> Math.max(a[0], a[1])));
        int i = 0;
        while (i < q.size()) {
            int x = q.get(i)[0], y = q.get(i)[1];
            int cnt = f(i, Math.max(x, y), s);
            if (cnt == -1) {
                break;
            }
            i += cnt;
        }
        return i;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
