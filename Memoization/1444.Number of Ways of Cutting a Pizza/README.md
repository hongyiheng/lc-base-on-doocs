# [1444. 切披萨的方案数](https://leetcode-cn.com/problems/number-of-ways-of-cutting-a-pizza)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>rows x cols</code>&nbsp;大小的矩形披萨和一个整数 <code>k</code>&nbsp;，矩形包含两种字符：&nbsp;<code>&#39;A&#39;</code> （表示苹果）和&nbsp;<code>&#39;.&#39;</code>&nbsp;（表示空白格子）。你需要切披萨 <code>k-1</code> 次，得到&nbsp;<code>k</code>&nbsp;块披萨并送给别人。</p>

<p>切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。</p>

<p>请你返回确保每一块披萨包含&nbsp;<strong>至少</strong>&nbsp;一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/10/ways_to_cut_apple_1.png" style="height: 378px; width: 500px;"></strong></p>

<pre><strong>输入：</strong>pizza = [&quot;A..&quot;,&quot;AAA&quot;,&quot;...&quot;], k = 3
<strong>输出：</strong>3 
<strong>解释：</strong>上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>pizza = [&quot;A..&quot;,&quot;AA.&quot;,&quot;...&quot;], k = 3
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>pizza = [&quot;A..&quot;,&quot;A..&quot;,&quot;...&quot;], k = 1
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= rows, cols &lt;= 50</code></li>
	<li><code>rows ==&nbsp;pizza.length</code></li>
	<li><code>cols ==&nbsp;pizza[i].length</code></li>
	<li><code>1 &lt;= k &lt;= 10</code></li>
	<li><code>pizza</code>&nbsp;只包含字符&nbsp;<code>&#39;A&#39;</code>&nbsp;和&nbsp;<code>&#39;.&#39;</code>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        @cache
        def dfs(x, y, k):
            cur = s[m][n] - s[x][n] - s[m][y] + s[x][y]
            if k == 0:
                return 1 if cur > 0 else 0
            ans = 0
            for i in range(x + 1, m + 1):
                v = s[m][n] - s[i][n] - s[m][y] + s[i][y]
                if cur > v:
                    ans += dfs(i, y, k - 1)
            for j in range(y + 1, n + 1):
                v = s[m][n] - s[x][n] - s[m][j] + s[x][j]
                if cur > v:
                    ans += dfs(x, j, k - 1)
            return ans % mod

        mod = int(1e9 + 7)
        m, n = len(pizza), len(pizza[0])
        s = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + (1 if pizza[i - 1][j - 1] == 'A' else 0)
        return dfs(0, 0, k - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int m, n, mod;
    int[][] s;
    Map<String, Integer> f;

    public int dfs(int x, int y, int k) {
        String key = x + "_" + y + "_" + k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int cur = s[m][n] - s[x][n] - s[m][y] + s[x][y];
        if (k == 0) {
            return cur > 0 ? 1 : 0;
        }
        int ans = 0;
        for (int i = x + 1; i < m + 1; i++) {
            int v = s[m][n] - s[i][n] - s[m][y] + s[i][y];
            if (cur > v) {
                ans = (ans + dfs(i, y, k - 1)) % mod;
            }
        }
        for (int j = y + 1; j < n + 1; j++) {
            int v = s[m][n] - s[x][n] - s[m][j] + s[x][j];
            if (cur > v) {
                ans = (ans + dfs(x, j, k - 1)) % mod;
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        mod = (int) 1e9 + 7;
        s = new int[m + 1][n + 1];
        f = new HashMap<>();
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        return dfs(0, 0, k - 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
