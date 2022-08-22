# [233. 数字 1 的个数](https://leetcode-cn.com/problems/number-of-digit-one)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数 <code>n</code>，计算所有小于等于 <code>n</code> 的非负整数中数字 <code>1</code> 出现的个数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 13
<strong>输出：</strong>6
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 0
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= n <= 2 * 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countDigitOne(self, n: int) -> int:
        s = list(str(n))

        def dfs(cur, cnt, limit):
            if cur == m:
                return cnt
            if not limit and dp[cur][cnt] >= 0:
                return dp[cur][cnt]
            ans = 0
            up = int(s[cur]) if limit else 9
            for i in range(up + 1):
                next_cnt = cnt
                next_cnt += 1 if i == 1 else 0
                ans += dfs(cur + 1, next_cnt, limit and i == up)
            if not limit:
                dp[cur][cnt] = ans
            return ans

        m = len(s)
        dp = [[-1] * m for _ in range(m)]
        return dfs(0, 0, True)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    char[] cs;
    int[][] dp;
    int m;

    public int countDigitOne(int n) {
        cs = String.valueOf(n).toCharArray();
        m = cs.length;
        dp = new int[m][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true);
    }

    public int dfs(int cur, int cnt, boolean limit) {
        if (cur == m) {
            return cnt;
        }
        if (!limit && dp[cur][cnt] >= 0) {
            return dp[cur][cnt];
        }
        int ans = 0;
        int up = limit ? cs[cur] - '0' : 9;
        for (int i = 0; i < up + 1; i++) {
            int nextCnt = cnt;
            nextCnt += i == 1 ? 1 : 0;
            ans += dfs(cur + 1, nextCnt, limit && i == up);
        }
        if (!limit) {
            dp[cur][cnt] = ans;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
