# [2014. 重复 K 次的最长子序列](https://leetcode-cn.com/problems/longest-subsequence-repeated-k-times)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code> 的字符串 <code>s</code> ，和一个整数 <code>k</code> 。请你找出字符串 <code>s</code> 中 <strong>重复</strong> <code>k</code> 次的 <strong>最长子序列</strong> 。</p>

<p><strong>子序列</strong> 是由其他字符串删除某些（或不删除）字符派生而来的一个字符串。</p>

<p>如果&nbsp;<code>seq * k</code> 是 <code>s</code> 的一个子序列，其中 <code>seq * k</code> 表示一个由 <code>seq</code> 串联 <code>k</code>&nbsp;次构造的字符串，那么就称 <code>seq</code><strong> </strong>是字符串 <code>s</code> 中一个 <strong>重复 <code>k</code> 次</strong> 的子序列。</p>

<ul>
	<li>举个例子，<code>"bba"</code> 是字符串 <code>"bababcba"</code> 中的一个重复 <code>2</code> 次的子序列，因为字符串 <code>"bbabba"</code> 是由 <code>"bba"</code> 串联 <code>2</code> 次构造的，而&nbsp;<code>"bbabba"</code> 是字符串 <code>"<em><strong>b</strong></em>a<em><strong>bab</strong></em>c<em><strong>ba</strong></em>"</code> 的一个子序列。</li>
</ul>

<p>返回字符串 <code>s</code> 中 <strong>重复 k 次的最长子序列</strong>&nbsp; 。如果存在多个满足的子序列，则返回 <strong>字典序最大</strong> 的那个。如果不存在这样的子序列，返回一个 <strong>空</strong> 字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="example 1" src="https://assets.leetcode.com/uploads/2021/08/30/longest-subsequence-repeat-k-times.png" style="width: 457px; height: 99px;" /></p>

<pre>
<strong>输入：</strong>s = "letsleetcode", k = 2
<strong>输出：</strong>"let"
<strong>解释：</strong>存在两个最长子序列重复 2 次：let" 和 "ete" 。
"let" 是其中字典序最大的一个。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "bb", k = 2
<strong>输出：</strong>"b"
<strong>解释：</strong>重复 2 次的最长子序列是 "b" 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "ab", k = 2
<strong>输出：</strong>""
<strong>解释：</strong>不存在重复 2 次的最长子序列。返回空字符串。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "bbabbabbbbabaababab", k = 3
<strong>输出：</strong>"bbbb"
<strong>解释：</strong>在 "<strong><em>bb</em></strong>a<em><strong>bb</strong></em>a<em><strong>bbbb</strong></em>a<em><strong>b</strong></em>aa<em><strong>b</strong></em>a<em><strong>b</strong></em>a<em><strong>b</strong></em>" 中重复 3 次的最长子序列是 "bbbb" 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == s.length</code></li>
	<li><code>2 &lt;= k &lt;= 2000</code></li>
	<li><code>2 &lt;= n &lt; k * 8</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str: 
        def check(x):
            i = cnt = 0
            for c in s:
                if c == x[i]:
                    i += 1
                if i == len(x):
                    cnt += 1
                    i = 0
                if cnt >= k:
                    return True
            return False

        cnt = Counter(s)
        cs = [c for c in sorted(cnt.keys()) if cnt[c] >= k]
        q = deque([""])
        ans = ""
        while q:
            x = q.popleft()
            for c in cs:
                nx = x + c
                if check(nx):
                    ans = nx
                    q.append(nx)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    private boolean check(String x, String s, int k) {
        int i = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == x.charAt(i)) {
                i++;
            }
            if (i == x.length()) {
                cnt++;
                i = 0;
                if (cnt >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        List<Character> cs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (cnt.getOrDefault(c, 0) >= k) {
                cs.add(c);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.add("");
        String ans = "";
        while (!q.isEmpty()) {
            String x = q.poll();
            for (char c : cs) {
                String nx = x + c;
                if (check(nx, s, k)) {
                    ans = nx;
                    q.add(nx);
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
