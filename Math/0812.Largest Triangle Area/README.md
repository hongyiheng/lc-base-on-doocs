# [812. 最大三角形面积](https://leetcode-cn.com/problems/largest-triangle-area)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。</p>

<pre>
<strong>示例:</strong>
<strong>输入:</strong> points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
<strong>输出:</strong> 2
<strong>解释:</strong> 
这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
</pre>

<p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/04/1027.png" style="height:328px; width:400px" /></p>

<p><strong>注意: </strong></p>

<ul>
	<li><code>3 &lt;= points.length &lt;= 50</code>.</li>
	<li>不存在重复的点。</li>
	<li>&nbsp;<code>-50 &lt;= points[i][j] &lt;= 50</code>.</li>
	<li>结果误差值在&nbsp;<code>10^-6</code>&nbsp;以内都认为是正确答案。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        def edge(u, v):
            a, b = u[0] - v[0], u[1] - v[1]
            return sqrt(a * a + b * b)

        def get_area(a, b, c):
            p = (a + b + c) * 0.5
            num = p * (p - a) * (p - b) * (p - c)
            if num <= 0:
                return 0
            return sqrt(num)

        n = len(points)
        ans = 0
        for i in range(n):
            for j in range(i, n):
                for k in range(j, n):
                    p1, p2, p3 = points[i], points[j], points[k]
                    a, b, c = edge(p1, p2), edge(p1, p3), edge(p2, p3)
                    ans = max(ans, get_area(a, b, c))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    double a = edge(points[i], points[j]);
                    double b = edge(points[j], points[k]);
                    double c = edge(points[i], points[k]);
                    ans = Math.max(ans, getArea(a, b, c));
                }
            }
        }
        return ans;
    }

    public double edge(int[] u, int[] v) {
        double a = u[0] - v[0], b = u[1] - v[1];
        return Math.sqrt(a * a + b * b);
    }

    public double getArea(double a, double b, double c) {
        double p = (a + b + c) * 0.5;
        double num = p * (p - a) * (p - b) * (p - c);
        if (num <= 0) {
            return 0;
        }
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
