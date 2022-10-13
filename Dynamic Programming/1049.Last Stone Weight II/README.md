# [1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一堆石头，用整数数组 <code>stones</code> 表示。其中 <code>stones[i]</code> 表示第 <code>i</code> 块石头的重量。</p>

<p>每一回合，从中选出<strong>任意两块石头</strong>，然后将它们一起粉碎。假设石头的重量分别为 <code>x</code> 和 <code>y</code>，且 <code>x <= y</code>。那么粉碎的可能结果如下：</p>

<ul>
	<li>如果 <code>x == y</code>，那么两块石头都会被完全粉碎；</li>
	<li>如果 <code>x != y</code>，那么重量为 <code>x</code> 的石头将会完全粉碎，而重量为 <code>y</code> 的石头新重量为 <code>y-x</code>。</li>
</ul>

<p>最后，<strong>最多只会剩下一块 </strong>石头。返回此石头 <strong>最小的可能重量 </strong>。如果没有石头剩下，就返回 <code>0</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>stones = [2,7,4,1,8,1]
<strong>输出：</strong>1
<strong>解释：</strong>
组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>stones = [31,26,33,21,40]
<strong>输出：</strong>5
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>stones = [1,2]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= stones.length <= 30</code></li>
	<li><code>1 <= stones[i] <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        s, n = sum(stones), len(stones)
        t = s // 2
        dp = [[0] * (t + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(t + 1):
                dp[i][j] = dp[i - 1][j]
                v = stones[i - 1]
                if j >= v:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - v] + v)
        return abs(s - dp[n][t] - dp[n][t])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, s = 0;
        for (int v : stones) {
            s += v;
        }
        int t = s / 2;
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < t + 1; j++) {
                int v = stones[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (j >= v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + v);
                }
            }
        }
        return Math.abs(s - dp[n][t] - dp[n][t]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
