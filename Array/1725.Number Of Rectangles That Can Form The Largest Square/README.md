# [1725. 可以形成最大正方形的矩形数目](https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组 <code>rectangles</code> ，其中 <code>rectangles[i] = [l<sub>i</sub>, w<sub>i</sub>]</code> 表示第 <code>i</code> 个矩形的长度为 <code>l<sub>i</sub></code> 、宽度为 <code>w<sub>i</sub></code> 。</p>

<p>如果存在 <code>k</code> 同时满足 <code>k <= l<sub>i</sub></code> 和 <code>k <= w<sub>i</sub></code> ，就可以将第 <code>i</code> 个矩形切成边长为 <code>k</code> 的正方形。例如，矩形 <code>[4,6]</code> 可以切成边长最大为 <code>4</code> 的正方形。</p>

<p>设 <code>maxLen</code> 为可以从矩形数组 <code>rectangles</code> 切分得到的 <strong>最大正方形</strong> 的边长。</p>

<p>请你统计有多少个矩形能够切出边长为<em> </em><code>maxLen</code> 的正方形，并返回矩形 <strong>数目</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>rectangles = [[5,8],[3,9],[5,12],[16,5]]
<strong>输出：</strong>3
<strong>解释：</strong>能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>rectangles = [[2,3],[3,7],[4,3],[3,7]]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= rectangles.length <= 1000</code></li>
	<li><code>rectangles[i].length == 2</code></li>
	<li><code>1 <= l<sub>i</sub>, w<sub>i</sub> <= 10<sup>9</sup></code></li>
	<li><code>l<sub>i</sub> != w<sub>i</sub></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        max_len = 0
        for r in rectangles:
            max_len = max(max_len, min(r[0], r[1]))
        ans = 0
        for r in rectangles:
            if min(r[0], r[1]) == max_len:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        for (int[] r : rectangles) {
            maxLen = Math.max(maxLen, Math.min(r[0], r[1]));
        }
        int ans = 0;
        for (int[] r : rectangles) {
            if (Math.min(r[0], r[1]) == maxLen) {
                ans++;
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
