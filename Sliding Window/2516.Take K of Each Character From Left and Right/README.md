# [2516. 每种字符至少取 K 个](https://leetcode-cn.com/problems/take-k-of-each-character-from-left-and-right)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由字符 <code>'a'</code>、<code>'b'</code>、<code>'c'</code> 组成的字符串 <code>s</code> 和一个非负整数 <code>k</code> 。每分钟，你可以选择取走 <code>s</code> <strong>最左侧</strong> 还是 <strong>最右侧</strong> 的那个字符。</p>

<p>你必须取走每种字符 <strong>至少</strong> <code>k</code> 个，返回需要的 <strong>最少</strong> 分钟数；如果无法取到，则返回<em> </em><code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aabaaaacaabc", k = 2
<strong>输出：</strong>8
<strong>解释：</strong>
从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
共需要 3 + 5 = 8 分钟。
可以证明需要的最少分钟数是 8 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", k = 1
<strong>输出：</strong>-1
<strong>解释：</strong>无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 仅由字母 <code>'a'</code>、<code>'b'</code>、<code>'c'</code> 组成</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        def check(l, r):
            a, b, c = cnt[r][0] - cnt[l][0], cnt[r][1] - cnt[l][1], cnt[r][2] - cnt[l][2]
            return min(ma - a, mb - b, mc - c) >= k

        n = len(s)
        cnt = [[0] * 3 for _ in range(n + 1)]
        for i in range(n):
            cnt[i + 1] = cnt[i][::]
            cnt[i + 1][ord(s[i]) - ord('a')] += 1
        ma, mb, mc = cnt[n]
        if min(ma, mb, mc) < k:
            return -1
        ans = inf
        l = r = 0
        while r < n + 1:
            while r < n + 1 and check(l, r):
                ans = min(ans, n - (r - l))
                r += 1
            while l < r < n + 1 and not check(l, r):
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int[][] cnt;
    int n;

    public boolean check(int l, int r, int k) {
        for (int i = 0; i < 3; i++) {
            if (cnt[n][i] - (cnt[r][i] - cnt[l][i]) < k) {
                return false;
            }
        }
        return true;
    }

    public int takeCharacters(String s, int k) {
        n = s.length();
        cnt = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i].clone();
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (cnt[n][i] < k) {
                return -1;
            }
        }
        int ans = n + 1;
        int l = 0, r = 0;
        while (r < n + 1) {
            while (r < n + 1 && check(l, r, k)) {
                ans = Math.min(ans, n - (r - l));
                r++;
            }
            while (l < r && r < n + 1 && !check(l, r, k)) {
                l++;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
