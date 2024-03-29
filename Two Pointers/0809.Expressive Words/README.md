# [809. 情感丰富的文字](https://leetcode-cn.com/problems/expressive-words)



## 题目描述

<!-- 这里写题目描述 -->

<p>有时候人们会用重复写一些字母来表示额外的感受，比如 <code>"hello" -> "heeellooo"</code>, <code>"hi" -> "hiii"</code>。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。</p>

<p>对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 <code>c</code> ），然后往其中添加相同的字母 <code>c</code> 使其长度达到 3 或以上。</p>

<p>例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 <code>S = "helllllooo"</code>，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 <code>query = "hello" -> "hellooo" -> "helllllooo" = S</code>。</p>

<p>输入一组查询单词，输出其中可扩张的单词数量。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong> 
S = "heeellooo"
words = ["hello", "hi", "helo"]
<strong>输出：</strong>1
<strong>解释</strong>：
我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= len(S) <= 100</code>。</li>
	<li><code>0 <= len(words) <= 100</code>。</li>
	<li><code>0 <= len(words[i]) <= 100</code>。</li>
	<li><code>S</code> 和所有在 <code>words</code> 中的单词都只由小写字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        def check(s, t):
            n, m = len(s), len(t)
            if m > n:
                return False
            l1 = l2 = r1 = r2 = 0
            while r1 < n and r2 < m:
                if s[l1] != t[l2]:
                    return False
                c = s[l1]
                while r1 < n and s[r1] == c:
                    r1 += 1
                while r2 < m and t[r2] == c:
                    r2 += 1
                len1, len2 = r1 - l1, r2 - l2
                if len1 < len2 or (len1 > len2 and len1 < 3):
                    return False
                l1, l2 = r1, r2
            return r1 == n and r2 == m
        
        return sum(check(s, t) for t in words)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (check(s, word)) {
                ans++;
            }
        }
        return ans;
    }

     public boolean check(String s, String w) {
        int n = s.length(), m = w.length();
        if (m > n) {
            return false;
        }
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while (r1 < n && r2 < m) {
            if (s.charAt(l1) != w.charAt(l2)) {
                return false;
            }
            char c = s.charAt(l1);
            while (r1 < n && s.charAt(r1) == c) {
                r1++;
            }
            while (r2 < m && w.charAt(r2) == c) {
                r2++;
            }
            int len1 = r1 - l1, len2 = r2 - l2;
            if (len1 < len2 || (len1 > len2 && len1 < 3)) {
                return false;
            }
            l1 = r1;
            l2 = r2;
        }
        return l1 == n && l2 == m;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
