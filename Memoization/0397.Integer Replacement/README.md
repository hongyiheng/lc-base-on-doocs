# [397. 整数替换](https://leetcode-cn.com/problems/integer-replacement)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个正整数 <code>n</code> ，你可以做如下操作：</p>

<ol>
	<li>如果 <code>n</code><em> </em>是偶数，则用 <code>n / 2</code>替换 <code>n</code><em> </em>。</li>
	<li>如果 <code>n</code><em> </em>是奇数，则可以用 <code>n + 1</code>或<code>n - 1</code>替换 <code>n</code> 。</li>
</ol>

<p><code>n</code><em> </em>变为 <code>1</code> 所需的最小替换次数是多少？</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 8
<strong>输出：</strong>3
<strong>解释：</strong>8 -> 4 -> 2 -> 1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 7
<strong>输出：</strong>4
<strong>解释：</strong>7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def integerReplacement(self, n: int) -> int:
        mp = dict()

        def dfs(n):
            if n == 1:
                return 0
            if n % 2 == 0:
                if n // 2 in mp:
                    ans = mp[n // 2]
                else:
                    ans = dfs(n // 2)
                    mp[n // 2] = ans
                return 1 + ans
            else:
                if n + 1 in mp:
                    ans1 = mp[n + 1]
                else:
                    ans1 = dfs(n + 1)
                    mp[n + 1] = ans1
                if n - 1 in mp:
                    ans2 = mp[n - 1]
                else:
                    ans2 = dfs(n - 1)
                    mp[n - 1] = ans2
                return 1 + min(ans1, ans2)

        return dfs(n)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Map<Long, Long> mp = new HashMap<>();

    public int integerReplacement(int n) {
        return (int) dfs((long) n);
    }

    public long dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            long ans = 0;
            if (!mp.containsKey(n / 2)) {
                ans = dfs(n / 2);
                mp.put(n / 2, ans);
            } else {
                ans = mp.get(n / 2);
            }
            return 1 + ans;
        } else {
            long ans1 = 0, ans2 = 0;
            if (!mp.containsKey(n + 1)) {
                ans1 = dfs(n + 1);
                mp.put(n + 1, ans1);
            } else {
                ans1 = mp.get(n + 1);
            }
            if (!mp.containsKey(n - 1)) {
                ans2 = dfs(n - 1);
                mp.put(n - 1, ans2);
            } else {
                ans2 = mp.get(n - 1);
            }
            return 1 + Math.min(ans1, ans2);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
