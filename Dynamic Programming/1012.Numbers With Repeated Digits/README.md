# [1012. 至少有 1 位重复的数字](https://leetcode-cn.com/problems/numbers-with-repeated-digits)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定正整数&nbsp;<code>N</code>，返回小于等于 <code>N</code>&nbsp;且具有至少 1 位重复数字的正整数的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>20
<strong>输出：</strong>1
<strong>解释：</strong>具有至少 1 位重复数字的正数（&lt;= 20）只有 11 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>100
<strong>输出：</strong>10
<strong>解释：</strong>具有至少 1 位重复数字的正数（&lt;= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>1000
<strong>输出：</strong>262
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= N &lt;= 10^9</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        s = str(n)
        m = len(s)

        @cache
        def dfs(cur, mask, limit, num, valid):
            if cur == m:
                return 1 if valid else 0
            ans = 0
            if not num:
                ans = dfs(cur + 1, 0, False, False, False)
            bottom, up = 0 if num else 1, int(s[cur]) if limit else 9
            for i in range(bottom, up + 1):
                ans += dfs(cur + 1, mask | (1 << i), limit and i == up, True, valid or mask & (1 << i))
            return ans

        return dfs(0, 0, True, False, False)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    char[] cs;
    int[][] dp;
    int m;

    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        m = s.length();
        cs = s.toCharArray();
        dp = new int[m][4096];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true, false, false);
    }

    public int dfs(int cur, int mask, boolean limit, boolean num, boolean valid) {
        if (cur == m) {
            return valid ? 1 : 0;
        }
        if (!limit && num && valid && dp[cur][mask] != -1) {
            return dp[cur][mask];
        }
        int ans = 0;
        if (!num) {
            ans = dfs(cur + 1, 0, false, false, false);
        }
        int bottom = num ? 0 : 1, up = limit ? cs[cur] - '0' : 9;
        for (int i = bottom; i < up + 1; i++) {
            ans += dfs(cur + 1, mask | (1 << i), limit && i == up, true, valid || (mask & (1 << i)) != 0);
        }
        if (!limit && num && valid) {
            dp[cur][mask] = ans;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
