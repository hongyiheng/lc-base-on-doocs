# [850. 矩形面积 II](https://leetcode-cn.com/problems/rectangle-area-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们给出了一个（轴对齐的）矩形列表&nbsp;<code>rectangles</code>&nbsp;。 对于&nbsp;<code>rectangle[i] = [x1, y1, x2, y2]</code>，其中（x1，y1）是矩形&nbsp;<code>i</code>&nbsp;左下角的坐标，（x2，y2）是该矩形右上角的坐标。</p>

<p>找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，<strong>请返回它对 10 ^ 9 + 7 取模的结果</strong>。</p>

<p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/06/rectangle_area_ii_pic.png" style="height: 360px; width: 480px;"></p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
<strong>输出：</strong>6
<strong>解释：</strong>如图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[0,0,1000000000,1000000000]]
<strong>输出：</strong>49
<strong>解释：</strong>答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 &rarr; (-7)^2 = 49 。
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= rectangles.length &lt;= 200</code></li>
	<li><code>rectanges[i].length = 4</code></li>
	<li><code>0 &lt;= rectangles[i][j] &lt;= 10^9</code></li>
	<li>矩形叠加覆盖后的总面积不会超越&nbsp;<code>2^63 - 1</code>&nbsp;，这意味着可以用一个&nbsp;64 位有符号整数来保存面积结果。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rectangleArea(self, rectangles: List[List[int]]) -> int:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return a[1] - b[1]

        xs = []
        for v in rectangles:
            xs.append(v[0])
            xs.append(v[2])
        xs.sort()
        ans = 0
        for i in range(1, len(xs)):
            left, right = xs[i - 1], xs[i]
            if right == left:
                continue
            ys = []
            for v in rectangles:
                if v[0] <= left and right <= v[2]:
                    ys.append([v[1], v[3]])
            ys.sort(key=cmp_to_key(cmp))
            h, d, t = 0, -1, -1
            for y in ys:
                if y[0] > t:
                    h += t - d    
                    d, t = y[0], y[1]
                elif y[1] > t:
                    t = y[1]
            h += t - d
            ans += (right - left) * h
        return ans % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int mod = (int)1e9 + 7;
        List<Integer> xs = new ArrayList<>();
        for (int[] v : rectangles) {
            xs.add(v[0]);
            xs.add(v[2]);
        }
        Collections.sort(xs);
        long ans = 0;
        for (int i = 1; i < xs.size(); i++) {
            int left = xs.get(i - 1), right = xs.get(i);
            if (right == left) {
                continue;
            }
            List<int[]> ys = new ArrayList<>();
            for (int[] v : rectangles) {
                if (v[0] <= left && right <= v[2]) {
                    ys.add(new int[]{v[1], v[3]});
                }
            }
            Collections.sort(ys, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            int h = 0, d = -1, t = -1;
            for (int[] y : ys) {
                if (t < y[0]) {
                    h += t - d;
                    d = y[0];
                    t = y[1];
                } else if (t < y[1]) {
                    t = y[1];
                }
            }
            h += t - d;
            ans = (ans + (right - left) * 1L * h % mod) % mod;
        }
        return (int)ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
