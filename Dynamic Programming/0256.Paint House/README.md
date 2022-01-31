# [256. 粉刷房子](https://leetcode-cn.com/problems/paint-house)



## 题目描述

<!-- 这里写题目描述 -->

<p>假如有一排房子，共 <code>n</code> 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。</p>

<p>当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 <code>n x 3</code><em> </em>的正整数矩阵 <code>costs</code> 来表示的。</p>

<p>例如，<code>costs[0][0]</code> 表示第 0 号房子粉刷成红色的成本花费；<code>costs[1][2]</code> 表示第 1 号房子粉刷成绿色的花费，以此类推。</p>

<p>请计算出粉刷完所有房子最少的花费成本。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>costs = [[17,2,17],[16,16,5],[14,3,19]]
<strong>输出: </strong>10
<strong>解释: </strong>将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色<strong>。</strong>
     最少花费: 2 + 5 + 3 = 10。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>costs = [[7,6,2]]
<strong>输出: 2</strong>
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>costs.length == n</code></li>
	<li><code>costs[i].length == 3</code></li>
	<li><code>1 <= n <= 100</code></li>
	<li><code>1 <= costs[i][j] <= 20</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [[0] * 3 for _ in range(n + 1)]
        for i in range(1, n + 1):
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0]
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1]
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2] 
        return min(dp[n][0], min(dp[n][1], dp[n][2]))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
