# [720. 词典中最长的单词](https://leetcode-cn.com/problems/longest-word-in-dictionary)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个字符串数组<code>words</code>组成的一本英语词典。从中找出最长的一个单词，该单词是由<code>words</code>词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。</p>

<p>若无答案，则返回空字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
words = [&quot;w&quot;,&quot;wo&quot;,&quot;wor&quot;,&quot;worl&quot;, &quot;world&quot;]
<strong>输出：</strong>&quot;world&quot;
<strong>解释：</strong> 
单词&quot;world&quot;可由&quot;w&quot;, &quot;wo&quot;, &quot;wor&quot;, 和 &quot;worl&quot;添加一个字母组成。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
words = [&quot;a&quot;, &quot;banana&quot;, &quot;app&quot;, &quot;appl&quot;, &quot;ap&quot;, &quot;apply&quot;, &quot;apple&quot;]
<strong>输出：</strong>&quot;apple&quot;
<strong>解释：</strong>
&quot;apply&quot;和&quot;apple&quot;都能由词典中的单词组成。但是&quot;apple&quot;的字典序小于&quot;apply&quot;。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>所有输入的字符串都只包含小写字母。</li>
	<li><code>words</code>数组长度范围为<code>[1,1000]</code>。</li>
	<li><code>words[i]</code>的长度范围为<code>[1,30]</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestWord(self, words: List[str]) -> str:
        ans = ""
        w_set = set(words)
        for s in w_set:
            n, m = len(s), len(ans)
            if n < m:
                continue
            if n == m and s > ans:
                continue
            flag = True
            for i in range(1, n + 1):
                sub = s[:i]
                if sub not in w_set:
                    flag = False
                    break
            if flag:
                ans = s
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) {
                continue;
            }
            if (n == m && s.compareTo(ans) > 0) {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = s;
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
