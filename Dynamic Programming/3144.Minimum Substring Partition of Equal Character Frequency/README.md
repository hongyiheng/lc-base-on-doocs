# [3144. 分割字符频率相等的最少子字符串](https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;，你需要将它分割成一个或者更多的&nbsp;<strong>平衡</strong>&nbsp;子字符串。比方说，<code>s == "ababcc"</code>&nbsp;那么&nbsp;<code>("abab", "c", "c")</code>&nbsp;，<code>("ab", "abc", "c")</code>&nbsp;和&nbsp;<code>("ababcc")</code>&nbsp;都是合法分割，但是&nbsp;<code>("a", <strong>"bab"</strong>, "cc")</code>&nbsp;，<code>(<strong>"aba"</strong>, "bc", "c")</code>&nbsp;和&nbsp;<code>("ab", <strong>"abcc"</strong>)</code>&nbsp;不是，不平衡的子字符串用粗体表示。</p>

<p>请你返回 <code>s</code>&nbsp;<strong>最少</strong> 能分割成多少个平衡子字符串。</p>

<p><b>注意：</b>一个 <strong>平衡</strong>&nbsp;字符串指的是字符串中所有字符出现的次数都相同。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "fabccddg"</span></p>

<p><span class="example-io"><b>输出：</b>3</span></p>

<p><strong>解释：</strong></p>

<p>我们可以将 <code>s</code>&nbsp;分割成 3 个子字符串：<code>("fab, "ccdd", "g")</code>&nbsp;或者&nbsp;<code>("fabc", "cd", "dg")</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "abababaccddb"</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p>我们可以将&nbsp;<code>s</code>&nbsp;分割成 2 个子字符串：<code>("abab", "abaccddb")</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def dfs(i):
            nonlocal n
            if i >= n:
                return 0
            ans = inf
            cnt = defaultdict(int)
            mx = 0
            for j in range(i, n):
                cnt[s[j]] += 1
                mx = max(mx, cnt[s[j]])
                if j - i + 1 == mx * len(cnt):
                    ans = min(ans, dfs(j + 1) + 1)
            return ans

        n = len(s)
        return dfs(0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int n;
    int[] f;

     private int dfs(String s, int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        int ans = Integer.MAX_VALUE;
        Map<Character, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int j = i; j < n; j++) {
            cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j), 0) + 1);
            mx = Math.max(mx, cnt.get(s.charAt(j)));
            if (j - i + 1 == mx * cnt.size()) {
                ans = Math.min(ans, dfs(s, j + 1) + 1);
            }
        }
        f[i] = ans;
        return ans;
    }

    public int minimumSubstringsInPartition(String s) {
        n = s.length();
        f = new int[n];
        Arrays.fill(f, -1);
        return dfs(s, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
