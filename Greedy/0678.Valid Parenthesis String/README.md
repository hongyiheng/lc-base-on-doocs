# [678. 有效的括号字符串](https://leetcode-cn.com/problems/valid-parenthesis-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个只包含三种字符的字符串：<code>（&nbsp;</code>，<code>）</code>&nbsp;和 <code>*</code>，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：</p>

<ol>
	<li>任何左括号 <code>(</code>&nbsp;必须有相应的右括号 <code>)</code>。</li>
	<li>任何右括号 <code>)</code>&nbsp;必须有相应的左括号 <code>(</code>&nbsp;。</li>
	<li>左括号 <code>(</code> 必须在对应的右括号之前 <code>)</code>。</li>
	<li><code>*</code>&nbsp;可以被视为单个右括号 <code>)</code>&nbsp;，或单个左括号 <code>(</code>&nbsp;，或一个空字符串。</li>
	<li>一个空字符串也被视为有效字符串。</li>
</ol>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> &quot;()&quot;
<strong>输出:</strong> True
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> &quot;(*)&quot;
<strong>输出:</strong> True
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> &quot;(*))&quot;
<strong>输出:</strong> True
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>字符串大小将在 [1，100] 范围内。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkValidString(self, s: str) -> bool:
        min_ = max_ = 0
        for c in s:
            if c == "(":
                min_ += 1
                max_ += 1
            elif c == ")":
                min_ -= 1
                max_ -= 1
            else:
                min_ -= 1
                max_ += 1
            min_ = max(0, min_)
            if min_ > max_:
                return False
        return min_ == 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        int min = 0, max = 0;
        for (char c : cs) {
            if (c == '(') {
                min++; 
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            min = Math.max(0, min);
            if (min > max) {
                return false;
            }
        }
        return min == 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
