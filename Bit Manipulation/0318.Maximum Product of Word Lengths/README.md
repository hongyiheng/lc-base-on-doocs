# [318. 最大单词长度乘积](https://leetcode-cn.com/problems/maximum-product-of-word-lengths)

[English Version](/solution/0300-0399/0318.Maximum%20Product%20of%20Word%20Lengths/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串数组 <code>words</code>，找到 <code>length(word[i]) * length(word[j])</code> 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>["abcw","baz","foo","bar","xtfn","abcdef"]</code>
<strong>输出: </strong><code>16 
<strong>解释:</strong> 这两个单词为<strong> </strong></code><code>"abcw", "xtfn"</code>。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> <code>["a","ab","abc","d","cd","bcd","abcd"]</code>
<strong>输出: </strong><code>4 
<strong>解释: </strong></code>这两个单词为 <code>"ab", "cd"</code>。</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> <code>["a","aa","aaa","aaaa"]</code>
<strong>输出: </strong><code>0 
<strong>解释: </strong>不存在这样的两个单词。</code>
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= words.length <= 1000</code></li>
	<li><code>1 <= words[i].length <= 1000</code></li>
	<li><code>words[i]</code> 仅包含小写字母</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxProduct(self, words: List[str]) -> int:
        n, index = len(words), 0
        sim = [0] * n
        for w in words:
            t = 0
            for i in range(len(w)):
                u = ord(w[i]) - ord('a')
                t |= (1 << u)
            sim[index] = t
            index += 1
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                if sim[i] & sim[j] == 0:
                    ans = max(ans, len(words[i]) * len(words[j]))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] sim = new int[n];
        int index = 0;
        for (String w : words) {
            int t = 0;
            char[] chars = w.toCharArray();
            for (char c : chars) {
                int u = c - 'a';
                t |= (1 << u);
            }
            sim[index++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((sim[i] & sim[j]) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
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
