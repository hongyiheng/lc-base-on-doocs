# [2250. 统计包含每个点的矩形数目](https://leetcode-cn.com/problems/count-number-of-rectangles-containing-each-point)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二维整数数组&nbsp;<code>rectangles</code>&nbsp;，其中&nbsp;<code>rectangles[i] = [l<sub>i</sub>, h<sub>i</sub>]</code>&nbsp;表示第&nbsp;<code>i</code>&nbsp;个矩形长为&nbsp;<code>l<sub>i</sub></code>&nbsp;高为&nbsp;<code>h<sub>i</sub></code>&nbsp;。给你一个二维整数数组&nbsp;<code>points</code>&nbsp;，其中&nbsp;<code>points[j] = [x<sub>j</sub>, y<sub>j</sub>]</code>&nbsp;是坐标为&nbsp;<code>(x<sub>j</sub>, y<sub>j</sub>)</code>&nbsp;的一个点。</p>

<p>第&nbsp;<code>i</code>&nbsp;个矩形的 <strong>左下角</strong>&nbsp;在&nbsp;<code>(0, 0)</code>&nbsp;处，<strong>右上角</strong>&nbsp;在&nbsp;<code>(l<sub>i</sub>, h<sub>i</sub>)</code>&nbsp;。</p>

<p>请你返回一个整数数组<em>&nbsp;</em><code>count</code>&nbsp;，长度为&nbsp;<code>points.length</code>，其中<em>&nbsp;</em><code>count[j]</code>是 <strong>包含</strong> 第<em>&nbsp;</em><code>j</code>&nbsp;个点的矩形数目。</p>

<p>如果&nbsp;<code>0 &lt;= x<sub>j</sub> &lt;= l<sub>i</sub></code> 且&nbsp;<code>0 &lt;= y<sub>j</sub> &lt;= h<sub>i</sub></code>&nbsp;，那么我们说第&nbsp;<code>i</code>&nbsp;个矩形包含第&nbsp;<code>j</code>&nbsp;个点。如果一个点刚好在矩形的 <strong>边上</strong>&nbsp;，这个点也被视为被矩形包含。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/example1.png" style="width: 300px; height: 509px;"></p>

<pre><b>输入：</b>rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
<b>输出：</b>[2,1]
<b>解释：</b>
第一个矩形不包含任何点。
第二个矩形只包含一个点 (2, 1) 。
第三个矩形包含点 (2, 1) 和 (1, 4) 。
包含点 (2, 1) 的矩形数目为 2 。
包含点 (1, 4) 的矩形数目为 1 。
所以，我们返回 [2, 1] 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/example2.png" style="width: 300px; height: 312px;"></p>

<pre><b>输入：</b>rectangles = [[1,1],[2,2],[3,3]], points = [[1,3],[1,1]]
<b>输出：</b>[1,3]
<strong>解释：
</strong>第一个矩形只包含点 (1, 1) 。
第二个矩形只包含点 (1, 1) 。
第三个矩形包含点 (1, 3) 和 (1, 1) 。
包含点 (1, 3) 的矩形数目为 1 。
包含点 (1, 1) 的矩形数目为 3 。
所以，我们返回 [1, 3] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= rectangles.length, points.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>rectangles[i].length == points[j].length == 2</code></li>
	<li><code>1 &lt;= l<sub>i</sub>, x<sub>j</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= h<sub>i</sub>, y<sub>j</sub> &lt;= 100</code></li>
	<li>所有&nbsp;<code>rectangles</code>&nbsp;<strong>互不相同</strong>&nbsp;。</li>
	<li>所有&nbsp;<code>points</code> <strong>互不相同</strong>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        H = 101
        h_group = [list() for _ in range(H)]
        for x, y in rectangles:
            h_group[y].append(x)
        # On(logn)
        for v in h_group:
            v.sort()
        ans = list()
        # On * On(logn)
        for x, y in points:
            s = 0
            for j in range(y, H):
                xs = h_group[j]
                if not xs:
                    continue
                l, r = 0, len(xs) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if xs[mid] < x:
                        l = mid + 1
                    else:
                        r = mid
                s += len(xs) - l if xs[l] >= x else 0
            ans.append(s)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] hGroup = new ArrayList[101];
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1];
            if (hGroup[y] == null) {
                hGroup[y] = new ArrayList<>();
            }
            hGroup[y].add(x);
        }
        for (var g : hGroup) {
            if (g != null) {
                Collections.sort(g);
            }
        }
        int n = points.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            for (int h = y; h < 101; h++) {
                if (hGroup[h] == null) {
                    continue;
                }
                int l = 0, r = hGroup[h].size() - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (hGroup[h].get(mid) < x) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (hGroup[h].get(l) >= x) {
                    ans[i] += hGroup[h].size() - l;
                }
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
