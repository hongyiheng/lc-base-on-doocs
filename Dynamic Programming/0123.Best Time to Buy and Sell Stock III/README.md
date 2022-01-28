# [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组，它的第<em> </em><code>i</code> 个元素是一支给定的股票在第 <code>i</code><em> </em>天的价格。</p>

<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 <strong>两笔 </strong>交易。</p>

<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入：</strong>prices = [3,3,5,0,0,3,1,4]
<strong>输出：</strong>6
<strong>解释：</strong>在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,2,3,4,5]
<strong>输出：</strong>4
<strong>解释：</strong>在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1] 
<strong>输出：</strong>0 
<strong>解释：</strong>在这个情况下, 没有交易完成, 所以最大利润为 0。</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>prices = [1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= prices.length <= 10<sup>5</sup></code></li>
	<li><code>0 <= prices[i] <= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 4 for _ in range(n + 1)]
        dp[0][0] = -prices[0]
        dp[0][2] = -prices[0]
        for i in range(1, n + 1):
            dp[i][0] = max(dp[i - 1][0], -prices[i - 1])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1])
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1])
            dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1])
        ans = 0
        for i in range(4):
            ans = max(max(max(dp[n][0], dp[n][1]), dp[n][2]), dp[n][3])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][4];
        int ans = 0;
        dp[0][0] = prices[0] * -1;
        dp[0][2] = prices[0] * -1;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i - 1] * -1);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1]);
        }
        for (int i = 0; i < 4; i++) {
            ans = ans = Math.max(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]), dp[n][3]);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
