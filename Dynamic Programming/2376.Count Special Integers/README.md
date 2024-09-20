# [2376. 统计特殊整数](https://leetcode-cn.com/problems/count-special-integers)

## 题目描述

<!-- 这里写题目描述 -->

<p>如果一个正整数每一个数位都是 <strong>互不相同</strong>&nbsp;的，我们称它是 <strong>特殊整数</strong> 。</p>

<p>给你一个 <strong>正</strong>&nbsp;整数&nbsp;<code>n</code>&nbsp;，请你返回区间<em>&nbsp;</em><code>[1, n]</code>&nbsp;之间特殊整数的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>n = 20
<b>输出：</b>19
<b>解释：</b>1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>n = 5
<b>输出：</b>5
<b>解释：</b>1 到 5 所有整数都是特殊整数。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>n = 135
<b>输出：</b>110
<b>解释：</b>从 1 到 135 总共有 110 个整数是特殊整数。
不特殊的部分数字为：22 ，114 和 131 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        @cache
        def dfs(i, mask, is_limit, is_num):
            if i == len(s):
                return 1 if is_num else 0
            ans = 0
            if not is_num:
                ans = dfs(i + 1, mask, False, False)
            low = 0 if is_num else 1
            up = int(s[i]) if is_limit else 9
            for d in range(low, up + 1):
                if mask >> d & 1 == 0:
                    ans += dfs(i + 1, mask | 1 << d, is_limit and d == up, True)
            return ans
        
        s = str(n)
        return dfs(0, 0, True, False) 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    String s;
    int[][] f;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n);
        f = new int[s.length()][1 << 10];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true, false);
    }

    public int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (isNum && !isLimit && f[i][mask] != -1) {
            return f[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans = dfs(i + 1, mask, false, false);
        }
        int low = isNum ? 0 : 1;
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (int d = low; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                ans += dfs(i + 1, mask | 1 << d, isLimit && d == up, true);
            }
        }
        f[i][mask] = ans;
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
