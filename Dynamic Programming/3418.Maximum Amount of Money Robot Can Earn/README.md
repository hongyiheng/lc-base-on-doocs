# [3418. 机器人可以获得的最大金币数](https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>m x n</code> 的网格。一个机器人从网格的左上角 <code>(0, 0)</code> 出发，目标是到达网格的右下角 <code>(m - 1, n - 1)</code>。在任意时刻，机器人只能向右或向下移动。</p>

<p>网格中的每个单元格包含一个值 <code>coins[i][j]</code>：</p>

<ul>
	<li>如果 <code>coins[i][j] &gt;= 0</code>，机器人可以获得该单元格的金币。</li>
	<li>如果 <code>coins[i][j] &lt; 0</code>，机器人会遇到一个强盗，强盗会抢走该单元格数值的&nbsp;<strong>绝对值</strong> 的金币。</li>
</ul>

<p>机器人有一项特殊能力，可以在行程中&nbsp;<strong>最多感化&nbsp;</strong>2个单元格的强盗，从而防止这些单元格的金币被抢走。</p>

<p><strong>注意：</strong>机器人的总金币数可以是负数。</p>

<p>返回机器人在路径上可以获得的&nbsp;<strong>最大金币数&nbsp;</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">coins = [[0,1,-1],[1,-2,3],[2,-3,4]]</span></p>

<p><strong>输出：</strong> <span class="example-io">8</span></p>

<p><strong>解释：</strong></p>

<p>一个获得最多金币的最优路径如下：</p>

<ol>
	<li>从 <code>(0, 0)</code> 出发，初始金币为 <code>0</code>（总金币 = <code>0</code>）。</li>
	<li>移动到 <code>(0, 1)</code>，获得 <code>1</code> 枚金币（总金币 = <code>0 + 1 = 1</code>）。</li>
	<li>移动到 <code>(1, 1)</code>，遇到强盗抢走 <code>2</code> 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = <code>1</code>）。</li>
	<li>移动到 <code>(1, 2)</code>，获得 <code>3</code> 枚金币（总金币 = <code>1 + 3 = 4</code>）。</li>
	<li>移动到 <code>(2, 2)</code>，获得 <code>4</code> 枚金币（总金币 = <code>4 + 4 = 8</code>）。</li>
</ol>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">coins = [[10,10,10],[10,10,10]]</span></p>

<p><strong>输出：</strong> <span class="example-io">40</span></p>

<p><strong>解释：</strong></p>

<p>一个获得最多金币的最优路径如下：</p>

<ol>
	<li>从 <code>(0, 0)</code> 出发，初始金币为 <code>10</code>（总金币 = <code>10</code>）。</li>
	<li>移动到 <code>(0, 1)</code>，获得 <code>10</code> 枚金币（总金币 = <code>10 + 10 = 20</code>）。</li>
	<li>移动到 <code>(0, 2)</code>，再获得 <code>10</code> 枚金币（总金币 = <code>20 + 10 = 30</code>）。</li>
	<li>移动到 <code>(1, 2)</code>，获得 <code>10</code> 枚金币（总金币 = <code>30 + 10 = 40</code>）。</li>
</ol>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == coins.length</code></li>
	<li><code>n == coins[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>-1000 &lt;= coins[i][j] &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        m, n = len(coins), len(coins[0])
        f = [[[-inf] * 3 for _ in range(n + 1)] for _ in range(m + 1)]
        f[1][0] = [0] * 3
        for i, row in enumerate(coins):
            for j, x in enumerate(row):
                f[i + 1][j + 1][0] = max(f[i + 1][j][0], f[i][j + 1][0]) + x
                f[i + 1][j + 1][1] = max(f[i + 1][j][1] + x, f[i][j + 1][1] + x, f[i + 1][j][0], f[i][j + 1][0])
                f[i + 1][j + 1][2] = max(f[i + 1][j][2] + x, f[i][j + 1][2] + x, f[i + 1][j][1], f[i][j + 1][1])
        return f[m][n][2]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] f = new int[m + 1][n + 1][3];
        for (int[][] row : f) {
            for (int[] r : row) {
                Arrays.fill(r, -0x3f3f3f);
            }
        }
        f[1][0] = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = coins[i][j];
                f[i + 1][j + 1][0] = Math.max(f[i + 1][j][0], f[i][j + 1][0]) + x;
                f[i + 1][j + 1][1] = Math.max(Math.max(f[i + 1][j][0], f[i][j + 1][0]), Math.max(f[i + 1][j][1], f[i][j + 1][1]) + x);
                f[i + 1][j + 1][2] = Math.max(Math.max(f[i + 1][j][1], f[i][j + 1][1]), Math.max(f[i + 1][j][2], f[i][j + 1][2]) + x);
            }
        }
        return f[m][n][2];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
