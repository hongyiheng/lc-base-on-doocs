# [1223. 掷骰子模拟](https://leetcode-cn.com/problems/dice-roll-simulation)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。</p>

<p>不过我们在使用它时有个约束，就是使得投掷骰子时，<strong>连续</strong> 掷出数字&nbsp;<code>i</code>&nbsp;的次数不能超过&nbsp;<code>rollMax[i]</code>（<code>i</code>&nbsp;从 1 开始编号）。</p>

<p>现在，给你一个整数数组&nbsp;<code>rollMax</code>&nbsp;和一个整数&nbsp;<code>n</code>，请你来计算掷&nbsp;<code>n</code>&nbsp;次骰子可得到的不同点数序列的数量。</p>

<p>假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 <strong>模&nbsp;<code>10^9 + 7</code></strong>&nbsp;之后的结果。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 2, rollMax = [1,1,2,2,2,3]
<strong>输出：</strong>34
<strong>解释：</strong>我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 2, rollMax = [1,1,1,1,1,1]
<strong>输出：</strong>30
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 3, rollMax = [1,1,1,2,2,3]
<strong>输出：</strong>181
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 5000</code></li>
	<li><code>rollMax.length == 6</code></li>
	<li><code>1 &lt;= rollMax[i] &lt;= 15</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def dieSimulator(self, n: int, rollMax: List[int]) -> int:
        mod = int(1e9 + 7)

        @cache
        def dfs(i, last, cnt):
            if i == n:
                return 1
            res = 0
            for j, rm in enumerate(rollMax):
                if j == last and cnt >= rm:
                    continue
                res += dfs(i + 1, j, cnt + 1 if last == j else 1)
            return res % mod

        ans = 0
        for i, rm in enumerate(rollMax):
            ans += dfs(1, i, 1)
        return ans % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int[][][] f;
    int mod = (int)1e9 + 7;
    int n;
    int[] rollMax;

    public int dieSimulator(int n, int[] rollMax) {
        this.n = n;
        this.rollMax = rollMax;
        f = new int[n + 1][6][16];
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = (ans + dfs(1, i, 1)) % mod;
        }
        return ans;
    }

    public int dfs(int i, int last, int cnt) {
        if (i == n) {
            return 1;
        }
        if (f[i][last][cnt] != 0) {
            return f[i][last][cnt];
        }
        int ans = 0;
        for (int j = 0; j < 6; j++) {
            int mx = rollMax[j];
            if (last == j && cnt >= mx) {
                continue;
            }
            int s = dfs(i + 1, j, last == j ? cnt + 1 : 1);
            ans = (s + ans) % mod;
        }
         f[i][last][cnt] = ans;
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
