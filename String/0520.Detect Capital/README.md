# [520. 检测大写字母](https://leetcode-cn.com/problems/detect-capital)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个单词，你需要判断单词的大写使用是否正确。</p>

<p>我们定义，在以下情况时，单词的大写用法是正确的：</p>

<ol>
	<li>全部字母都是大写，比如&quot;USA&quot;。</li>
	<li>单词中所有字母都不是大写，比如&quot;leetcode&quot;。</li>
	<li>如果单词不只含有一个字母，只有首字母大写，&nbsp;比如&nbsp;&quot;Google&quot;。</li>
</ol>

<p>否则，我们定义这个单词没有正确使用大写字母。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> &quot;USA&quot;
<strong>输出:</strong> True
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> &quot;FlaG&quot;
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong> 输入是由大写和小写拉丁字母组成的非空单词。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        n = len(word)
        if n == 1:
            return True
        if "a" <= word[0] <= "z":
            for c in word:
                if "a" <= c <= "z":
                    continue
                return False
        elif "a" <= word[1] <= "z":
            for i in range(1, n):
                if "a" <= word[i] <= "z":
                    continue
                return False
        else:
            for c in word:
                if "A" <= c <= "Z":
                    continue
                return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        char[] cs = word.toCharArray();
        if ('a' <= cs[0] && cs[0] <= 'z') {
            for (char c : cs) {
                if ('a' <= c && c <= 'z') {
                    continue;
                }
                return false;
            }
        } else if ('a' <= cs[1] && cs[1] <= 'z') {
            for (int i = 1; i < n; i++) {
                if ('a' <= cs[i] && cs[i] <= 'z') {
                    continue;
                }
                return false;
            }
        } else {
            for (char c : cs) {
                if ('A' <= c && c <= 'Z') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
