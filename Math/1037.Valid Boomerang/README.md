# [1037. 有效的回旋镖](https://leetcode-cn.com/problems/valid-boomerang)



## 题目描述

<!-- 这里写题目描述 -->

<p>回旋镖定义为一组三个点，这些点各不相同且<strong>不</strong>在一条直线上。</p>

<p>给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[[1,1],[2,3],[3,2]]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[[1,1],[2,2],[3,3]]
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>points.length == 3</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>0 &lt;= points[i][j] &lt;= 100</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        x1, y1 = points[0]
        x2, y2 = points[1]
        x3, y3 = points[2]
        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
