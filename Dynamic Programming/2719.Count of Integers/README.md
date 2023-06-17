# [2719. 统计整数数目](https://leetcode-cn.com/problems/count-of-integers)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个数字字符串&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;，以及两个整数&nbsp;<code>max_sum</code> 和&nbsp;<code>min_sum</code>&nbsp;。如果一个整数&nbsp;<code>x</code>&nbsp;满足以下条件，我们称它是一个好整数：</p>

<ul>
	<li><code>num1 &lt;= x &lt;= num2</code></li>
	<li><code>min_sum &lt;= digit_sum(x) &lt;= max_sum</code>.</li>
</ul>

<p>请你返回好整数的数目。答案可能很大，请返回答案对&nbsp;<code>10<sup>9</sup> + 7</code>&nbsp;取余后的结果。</p>

<p>注意，<code>digit_sum(x)</code>&nbsp;表示&nbsp;<code>x</code>&nbsp;各位数字之和。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>num1 = "1", num2 = "12", min_num = 1, max_num = 8
<b>输出：</b>11
<b>解释：</b>总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>num1 = "1", num2 = "5", min_num = 1, max_num = 5
<b>输出：</b>5
<b>解释：</b>数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num1 &lt;= num2 &lt;= 10<sup>22</sup></code></li>
	<li><code>1 &lt;= min_sum &lt;= max_sum &lt;= 400</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        @cache
        def dfs(s, i, cnt, is_limit):
            if cnt > max_sum:
                return 0
            if i == len(s):
                return int(cnt >= min_sum)
            res = 0
            up = int(s[i]) if is_limit else 9
            for d in range(up + 1):
                res += dfs(s, i + 1, cnt + d, is_limit and d == up)
            return res % MOD
        
        MOD = 10 ** 9 + 7
        ans = dfs(num2, 0, 0, True) - dfs(num1, 0, 0, True)
        s = 0
        for c in num1:
            s += ord(c) - ord('0')
        ans += 1 if min_sum <= s <= max_sum else 0
        return ans % MOD
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int mod = (int) 1e9 + 7;
    long[][] f = new long[24][401];
    int mi, mx;

    public long dfs(String s, int i, int cnt, boolean isLimit) {
        if (cnt > mx) {
            return 0;
        }
        if (i == s.length()) {
            return cnt >= mi ? 1 : 0;
        }
        if (!isLimit && f[i][cnt] != -1) {
            return f[i][cnt];
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        long res = 0;
        for (int k = 0; k < up + 1; k++) {
            res = (res + dfs(s, i + 1, cnt + k, isLimit && k == up)) % mod;
        }
        if (!isLimit) {
            f[i][cnt] = res;
        }
        return res;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        mi = min_sum;
        mx = max_sum;
        for (long[] r : f) {
            Arrays.fill(r, -1);
        }
        long cnt1 = dfs(num2, 0, 0, true);
        for (long[] r : f) {
            Arrays.fill(r, -1);
        }
        long cnt2 = dfs(num1, 0, 0, true);
        long ans = (cnt1 - cnt2 + mod) % mod;
        long s = 0;
        for (char c : num1.toCharArray()) {
            s += c - '0';
        }
        ans += mi <= s && s <= mx ? 1 : 0;
        return (int)(ans % mod);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
