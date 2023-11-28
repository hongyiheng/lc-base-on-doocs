# [1316. 不同的循环子字符串](https://leetcode-cn.com/problems/distinct-echo-substrings)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>text</code> ，请你返回满足下述条件的&nbsp;<strong>不同</strong> 非空子字符串的数目：</p>

<ul>
	<li>可以写成某个字符串与其自身相连接的形式（即，可以写为 <code>a&nbsp;+ a</code>，其中 <code>a</code> 是某个字符串）。</li>
</ul>

<p>例如，<code>abcabc</code>&nbsp;就是&nbsp;<code>abc</code>&nbsp;和它自身连接形成的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>text = &quot;abcabcabc&quot;
<strong>输出：</strong>3
<strong>解释：</strong>3 个子字符串分别为 &quot;abcabc&quot;，&quot;bcabca&quot; 和 &quot;cabcab&quot; 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>text = &quot;leetcodeleetcode&quot;
<strong>输出：</strong>2
<strong>解释：</strong>2 个子字符串为 &quot;ee&quot; 和 &quot;leetcodeleetcode&quot; 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= text.length &lt;= 2000</code></li>
	<li><code>text</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distinctEchoSubstrings(self, text: str) -> int:
        def getNxt(s):
            nxt = [0] * len(s)
            i, j = 1, 0
            while i < len(s):
                if s[i] == s[j]:
                    j += 1
                    nxt[i] = j
                    i += 1
                elif j:
                    j = nxt[j - 1]
                else:
                    i += 1
            return nxt

        ans = set()
        for i in range(len(text)):
            nxt = getNxt(text[i:])
            for j, v in enumerate(nxt):
                if not v or (j + 1) % 2:
                    continue
                if (j + 1) % (j + 1 - v) == 0 and (j + 1) // (j + 1 - v) % 2 == 0:
                    ans.add(text[i:i + j + 1])
        return len(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int[] getNxt(String s) {
        int n = s.length();
        int[] nxt = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                nxt[i++] = ++j;
            } else if (j != 0) {
                j = nxt[j - 1];
            } else {
                i++;
            }
        }
        return nxt;
    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] nxt = getNxt(text.substring(i));
            for (int j = 0; j < nxt.length; j++) {
                if (nxt[j] == 0 || (j + 1) % 2 != 0) {
                    continue;
                }
                if ((j + 1) % (j + 1 - nxt[j]) == 0 && (j + 1) / (j + 1 - nxt[j]) % 2 == 0) {
                    ans.add(text.substring(i, i + j + 1));
                }
            }
        }
        return ans.size();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
