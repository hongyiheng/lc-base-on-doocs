# [761. 特殊的二进制序列](https://leetcode-cn.com/problems/special-binary-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>特殊的二进制序列是具有以下两个性质的二进制序列：</p>

<ul>
	<li>0 的数量与 1 的数量相等。</li>
	<li>二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。</li>
</ul>

<p>给定一个特殊的二进制序列&nbsp;<code>S</code>，以字符串形式表示。定义一个<em>操作 </em>为首先选择&nbsp;<code>S</code>&nbsp;的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)</p>

<p>在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> S = &quot;11011000&quot;
<strong>输出:</strong> &quot;11100100&quot;
<strong>解释:</strong>
将子串 &quot;10&quot; （在S[1]出现） 和 &quot;1100&quot; （在S[3]出现）进行交换。
这是在进行若干次操作后按字典序排列最大的结果。
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li><code>S</code>&nbsp;的长度不超过&nbsp;<code>50</code>。</li>
	<li><code>S</code>&nbsp;保证为一个满足上述定义的<em>特殊 </em>的二进制序列。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        n = len(s)
        if n <= 2:
            return s
        cnt, last = 0, 0
        q = []
        for i in range(n):
            cnt += 1 if s[i] == '1' else -1
            if cnt == 0:
                q.append('1' + self.makeLargestSpecial(s[last + 1: i]) + '0')
                last = i + 1
        q.sort(reverse=True)
        return "".join(q)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        int cnt = 0, last = 0;
        List<String> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt += s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                q.add('1' + makeLargestSpecial(s.substring(last + 1, i)) + '0');
                last = i + 1;
            }
        }
        q.sort((a, b) -> b.compareTo(a));
        return String.join("", q);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
