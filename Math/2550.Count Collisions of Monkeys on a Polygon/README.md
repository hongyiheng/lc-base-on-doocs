# [2550. 猴子碰撞的方法数](https://leetcode-cn.com/problems/count-collisions-of-monkeys-on-a-polygon)



## 题目描述

<!-- 这里写题目描述 -->

<p>现在有一个正凸多边形，其上共有 <code>n</code> 个顶点。顶点按顺时针方向从 <code>0</code> 到 <code>n - 1</code> 依次编号。每个顶点上 <strong>正好有一只猴子</strong> 。下图中是一个 6 个顶点的凸多边形。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/22/hexagon.jpg" style="width: 300px; height: 293px;"></p>

<p>每个猴子同时移动到相邻的顶点。顶点 <code>i</code> 的相邻顶点可以是：</p>

<ul>
	<li>顺时针方向的顶点 <code>(i + 1) % n</code> ，或</li>
	<li>逆时针方向的顶点 <code>(i - 1 + n) % n</code> 。</li>
</ul>

<p>如果移动后至少有两个猴子位于同一顶点，则会发生 <strong>碰撞</strong> 。</p>

<p>返回猴子至少发生 <strong>一次碰撞 </strong>的移动方法数。由于答案可能非常大，请返回对 <code>10<sup>9</sup>+7</code> 取余后的结果。</p>

<p><strong>注意</strong>，每只猴子只能移动一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 3
<strong>输出：</strong>6
<strong>解释：</strong>共计 8 种移动方式。
下面列出两种会发生碰撞的方式：
- 猴子 1 顺时针移动；猴子 2 逆时针移动；猴子 3 顺时针移动。猴子 1 和猴子 2 碰撞。
- 猴子 1 逆时针移动；猴子 2 逆时针移动；猴子 3 顺时针移动。猴子 1 和猴子 3 碰撞。
可以证明，有 6 种让猴子碰撞的方法。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 4
<strong>输出：</strong>14
<strong>解释：</strong>可以证明，有 14 种让猴子碰撞的方法。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def monkeyMove(self, n: int) -> int:
        mod = int(1e9 + 7)
        ans, base = 1, 2
        while n:
            if n & 1:
                ans = ans * base % mod
            base = base * base % mod
            n >>= 1
        return (ans - 2 + mod) % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int monkeyMove(int n) {
        long ans = 1, base = 2;
        int mod = (int)1e9 + 7;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans * base % mod;
            }
            base = base * base % mod;
            n >>= 1;
        }
        return ((int)ans - 2 + mod) % mod;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
