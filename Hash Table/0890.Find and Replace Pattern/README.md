# [890. 查找和替换模式](https://leetcode-cn.com/problems/find-and-replace-pattern)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有一个单词列表&nbsp;<code>words</code>&nbsp;和一个模式&nbsp;&nbsp;<code>pattern</code>，你想知道 <code>words</code> 中的哪些单词与模式匹配。</p>

<p>如果存在字母的排列 <code>p</code>&nbsp;，使得将模式中的每个字母 <code>x</code> 替换为 <code>p(x)</code> 之后，我们就得到了所需的单词，那么单词与模式是匹配的。</p>

<p><em>（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）</em></p>

<p>返回 <code>words</code> 中与给定模式匹配的单词列表。</p>

<p>你可以按任何顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>words = [&quot;abc&quot;,&quot;deq&quot;,&quot;mee&quot;,&quot;aqq&quot;,&quot;dkd&quot;,&quot;ccc&quot;], pattern = &quot;abb&quot;
<strong>输出：</strong>[&quot;mee&quot;,&quot;aqq&quot;]
<strong>解释：
</strong>&quot;mee&quot; 与模式匹配，因为存在排列 {a -&gt; m, b -&gt; e, ...}。
&quot;ccc&quot; 与模式不匹配，因为 {a -&gt; c, b -&gt; c, ...} 不是排列。
因为 a 和 b 映射到同一个字母。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 50</code></li>
	<li><code>1 &lt;= pattern.length = words[i].length&nbsp;&lt;= 20</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        ans = []
        for w in words:
            if len(pattern) != len(w):
                continue
            a, b = dict(), dict()
            same = True
            for i in range(len(w)):
                if w[i] not in a:
                    a[w[i]] = pattern[i]
                elif a[w[i]] != pattern[i]: 
                    same = False
                    break
                if pattern[i] not in b:
                    b[pattern[i]] = w[i]
                elif b[pattern[i]] != w[i]:
                    same = False
                    break
            if same:
                ans.append(w)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (w.length() != pattern.length()) {
                continue;
            }
            Map<Character, Character> a = new HashMap<>();
            Map<Character, Character> b = new HashMap<>();
            boolean same = true;
            for (int i = 0; i < w.length(); i++) {
                if (!a.containsKey(w.charAt(i))) {
                    a.put(w.charAt(i), pattern.charAt(i));
                } else if (a.get(w.charAt(i)) != pattern.charAt(i)){
                    same = false;
                    break;
                }
                if (!b.containsKey(pattern.charAt(i))) {
                    b.put(pattern.charAt(i), w.charAt(i));
                } else if (b.get(pattern.charAt(i)) != w.charAt(i)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                ans.add(w);
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
