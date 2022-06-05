# [478. 在圆内随机生成点](https://leetcode-cn.com/problems/generate-random-point-in-a-circle)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数&nbsp;<code>randPoint</code>&nbsp;。</p>

<p>说明:</p>

<ol>
	<li>输入值和输出值都将是<a href="https://baike.baidu.com/item/%E6%B5%AE%E7%82%B9%E6%95%B0/6162520">浮点数</a>。</li>
	<li>圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。</li>
	<li>圆周上的点也认为是在圆中。</li>
	<li><code>randPoint</code>&nbsp;返回一个包含随机点的x坐标和y坐标的大小为2的数组。</li>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: 
</strong>[&quot;Solution&quot;,&quot;randPoint&quot;,&quot;randPoint&quot;,&quot;randPoint&quot;]
[[1,0,0],[],[],[]]
<strong>输出: </strong>[null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: 
</strong>[&quot;Solution&quot;,&quot;randPoint&quot;,&quot;randPoint&quot;,&quot;randPoint&quot;]
[[10,5,-7.5],[],[],[]]
<strong>输出: </strong>[null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]</pre>

<p><strong>输入语法说明：</strong></p>

<p>输入是两个列表：调用成员函数名和调用的参数。<code>Solution</code>&nbsp;的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。<code>randPoint</code>&nbsp;没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.r = radius
        self.x = x_center
        self.y = y_center

    def randPoint(self) -> List[float]:
        while True:
            nx = random.random() * 2 * self.r - self.r
            ny = random.random() * 2 * self.r - self.r
            if math.sqrt(nx * nx + ny * ny) <= self.r:
                return [nx + self.x, ny + self.y]



# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    private double r;
    private double x;
    private double y;
    Random random;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        random = new Random();
    }
    
    public double[] randPoint() {
        while (true) {
            double nx = random.nextDouble() * 2 * r - r;
            double ny = random.nextDouble() * 2 * r - r;
            if (Math.sqrt(nx * nx + ny * ny) < r) {
                return new double[]{nx + x, ny + y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
```

### **...**

```

```

<!-- tabs:end -->
