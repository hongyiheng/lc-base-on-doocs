# [1541. 平衡括号字符串的最少插入次数](https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个括号字符串&nbsp;<code>s</code>&nbsp;，它只包含字符&nbsp;<code>&#39;(&#39;</code> 和&nbsp;<code>&#39;)&#39;</code>&nbsp;。一个括号字符串被称为平衡的当它满足：</p>

<ul>
	<li>任何左括号&nbsp;<code>&#39;(&#39;</code>&nbsp;必须对应两个连续的右括号&nbsp;<code>&#39;))&#39;</code>&nbsp;。</li>
	<li>左括号&nbsp;<code>&#39;(&#39;</code>&nbsp;必须在对应的连续两个右括号&nbsp;<code>&#39;))&#39;</code>&nbsp;之前。</li>
</ul>

<p>比方说&nbsp;<code>&quot;())&quot;</code>，&nbsp;<code>&quot;())(())))&quot;</code> 和&nbsp;<code>&quot;(())())))&quot;</code>&nbsp;都是平衡的，&nbsp;<code>&quot;)()&quot;</code>，&nbsp;<code>&quot;()))&quot;</code> 和&nbsp;<code>&quot;(()))&quot;</code>&nbsp;都是不平衡的。</p>

<p>你可以在任意位置插入字符 &#39;(&#39; 和 &#39;)&#39; 使字符串平衡。</p>

<p>请你返回让 <code>s</code>&nbsp;平衡的最少插入次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;(()))&quot;
<strong>输出：</strong>1
<strong>解释：</strong>第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 &#39;)&#39; 使字符串变成平衡字符串 &quot;(())))&quot; 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;())&quot;
<strong>输出：</strong>0
<strong>解释：</strong>字符串已经平衡了。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;))())(&quot;
<strong>输出：</strong>3
<strong>解释：</strong>添加 &#39;(&#39; 去匹配最开头的 &#39;))&#39; ，然后添加 &#39;))&#39; 去匹配最后一个 &#39;(&#39; 。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;((((((&quot;
<strong>输出：</strong>12
<strong>解释：</strong>添加 12 个 &#39;)&#39; 得到平衡字符串。
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = &quot;)))))))&quot;
<strong>输出：</strong>5
<strong>解释：</strong>在字符串开头添加 4 个 &#39;(&#39; 并在结尾添加 1 个 &#39;)&#39; ，字符串变成平衡字符串 &quot;(((())))))))&quot; 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10^5</code></li>
	<li><code>s</code>&nbsp;只包含&nbsp;<code>&#39;(&#39;</code> 和&nbsp;<code>&#39;)&#39;</code>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minInsertions(self, s: str) -> int:
        ans = l = i = 0
        n = len(s)
        while i < n:
            if s[i] == '(':
                l += 1
            else:
                cnt = 1
                while i + 1 < n and s[i + 1] == ')':
                    cnt += 1
                    i += 1
                if cnt % 2 != 0:
                    ans += 1
                    cnt += 1
                l -= cnt // 2
                if l < 0:
                    ans += abs(l)
                    l = 0
            i += 1
        if l:
            ans += 2 * l  
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minInsertions(String s) {
        int ans = 0, l = 0, i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                int cnt = 1;
                while (i + 1 < n && s.charAt(i + 1) == ')') {
                    cnt++;
                    i++;
                }
                if (cnt % 2 != 0) {
                    cnt++;
                    ans++;
                }
                l -= cnt / 2;
                if (l < 0) {
                    ans += -l;
                    l = 0;
                }
            }
            i++;
        }
        if (l > 0) {
            ans += 2 * l;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
