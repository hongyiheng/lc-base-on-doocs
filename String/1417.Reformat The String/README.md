# [1417. 重新格式化字符串](https://leetcode-cn.com/problems/reformat-the-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个混合了数字和字母的字符串 <code>s</code>，其中的字母均为小写英文字母。</p>

<p>请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。</p>

<p>请你返回 <strong>重新格式化后</strong> 的字符串；如果无法按要求重新格式化，则返回一个 <strong>空字符串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;a0b1c2&quot;
<strong>输出：</strong>&quot;0a1b2c&quot;
<strong>解释：</strong>&quot;0a1b2c&quot; 中任意两个相邻字符的类型都不同。 &quot;a0b1c2&quot;, &quot;0a1b2c&quot;, &quot;0c2a1b&quot; 也是满足题目要求的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;leetcode&quot;
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>&quot;leetcode&quot; 中只有字母，所以无法满足重新格式化的条件。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;1229857369&quot;
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>&quot;1229857369&quot; 中只有数字，所以无法满足重新格式化的条件。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;covid2019&quot;
<strong>输出：</strong>&quot;c2o0v1i9d&quot;
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = &quot;ab123&quot;
<strong>输出：</strong>&quot;1a2b3&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code> 仅由小写英文字母和/或数字组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def reformat(self, s: str) -> str:
        q1, q2 = [], []
        for c in s:
            if '0' <= c <= '9':
                q1.append(c)
            else:
                q2.append(c)
        if abs(len(q1) - len(q2)) > 1:
            return ""
        ans = [q1.pop() if len(q1) >= len(q2) else q2.pop()]
        while q1 or q2:
            if '0' <= ans[-1] <= '9':
                ans.append(q2.pop())
            else:
                ans.append(q1.pop())
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String reformat(String s) {
        Deque<Character> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                q1.addLast(c);
            } else {
                q2.addLast(c);
            }
        }
        if (Math.abs(q1.size() - q2.size()) > 1) {
            return "";
        }
        int n = s.length();
        char[] ans = new char[n];
        ans[0] = q1.size() > q2.size() ? q1.poll() : q2.poll();
        for (int i = 1; i < n; i++) {
            if ('0' <= ans[i - 1] && ans[i - 1] <= '9') {
                ans[i] = q2.poll();
            } else {
                ans[i] = q1.poll();
            }
        }
        return new String(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
