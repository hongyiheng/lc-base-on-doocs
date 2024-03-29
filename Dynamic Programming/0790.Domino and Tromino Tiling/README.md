# [790. 多米诺和托米诺平铺](https://leetcode-cn.com/problems/domino-and-tromino-tiling)



## 题目描述

<!-- 这里写题目描述 -->

<p>有两种形状的瓷砖：一种是&nbsp;2x1 的多米诺形，另一种是形如&nbsp;&quot;L&quot; 的托米诺形。两种形状都可以旋转。</p>

<pre>
XX  &lt;- 多米诺

XX  &lt;- &quot;L&quot; 托米诺
X
</pre>

<p>给定&nbsp;N 的值，有多少种方法可以平铺&nbsp;2 x N 的面板？<strong>返回值 mod 10^9 + 7</strong>。</p>

<p>（平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。）</p>

<pre>
<strong>示例:</strong>
<strong>输入:</strong> 3
<strong>输出:</strong> 5
<strong>解释:</strong> 
下面列出了五种不同的方法，不同字母代表不同瓷砖：
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY</pre>

<p><strong>提示：</strong></p>

<ul>
	<li>N&nbsp; 的范围是&nbsp;<code>[1, 1000]</code></li>
</ul>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numTilings(self, n: int) -> int:
        dp = [[0] * 4 for _ in range(n + 5)]
        dp[0][0] = dp[0][3] = 1
        for i in range(1, n):
            dp[i][0] = dp[i - 1][3]
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][3] = sum([dp[i - 1][j] for j in range(4)])
        return dp[n - 1][3] % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numTilings(int n) {
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n + 5][4];
        dp[0][0] = dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            for (int j = 0; j < 4; j++) {
                dp[i][3] += dp[i - 1][j];
                dp[i][3] %= mod;
            }
        }
        return (int)dp[n - 1][3];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
