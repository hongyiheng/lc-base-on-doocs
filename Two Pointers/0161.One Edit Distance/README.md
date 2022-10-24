# [161. 相隔为 1 的编辑距离](https://leetcode-cn.com/problems/one-edit-distance)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串&nbsp;<strong><em>s </em></strong>和<strong><em> t</em></strong>，判断他们的编辑距离是否为 1。</p>

<p><strong>注意：</strong></p>

<p>满足编辑距离等于 1 有三种可能的情形：</p>

<ol>
	<li>往 <em><strong>s</strong></em>&nbsp;中插入一个字符得到 <em><strong>t</strong></em></li>
	<li>从<em><strong> s</strong></em>&nbsp;中删除一个字符得到 <em><strong>t</strong></em></li>
	<li>在 <em><strong>s</strong></em>&nbsp;中替换一个字符得到 <em><strong>t</strong></em></li>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入: </strong><strong><em>s</em></strong> = &quot;ab&quot;, <strong><em>t</em></strong> = &quot;acb&quot;
<strong>输出: </strong>true
<strong>解释: </strong>可以将 &#39;c&#39; 插入字符串 <strong><em>s</em></strong>&nbsp;来得到 <em><strong>t</strong></em>。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入: </strong><strong><em>s</em></strong> = &quot;cab&quot;, <strong><em>t</em></strong> = &quot;ad&quot;
<strong>输出: </strong>false
<strong>解释: </strong>无法通过 1 步操作使 <em><strong>s</strong></em> 变为 <em><strong>t</strong></em>。</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入: <em>s</em></strong> = &quot;1203&quot;, <strong><em>t</em></strong> = &quot;1213&quot;
<strong>输出: </strong>true
<strong>解释: </strong>可以将字符串 <strong><em>s</em></strong>&nbsp;中的 &#39;0&#39; 替换为 &#39;1&#39; 来得到 <em><strong>t</strong></em>。</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        n, m = len(s), len(t)
        if abs(n - m) > 1:
            return False
        i = j = diff = 0
        while i < n and j < m:
            if s[i] == t[j]:
                i += 1
                j += 1
            else:
                diff += 1
                if n > m:
                    i += 1
                elif m > n:
                    j += 1
                else:
                    i += 1
                    j += 1
        return diff == 1 or (diff == 0 and abs(m - n) == 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int i = 0, j = 0, diff = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (m == n) {
                    i++;
                    j++;
                } else if (n > m) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return diff == 1 || (diff == 0 && Math.abs(m - n) == 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
