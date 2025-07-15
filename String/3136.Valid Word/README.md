# [3136. 有效单词](https://leetcode.cn/problems/valid-word)



## 题目描述

<!-- 这里写题目描述 -->

<p><strong>有效单词</strong> 需要满足以下几个条件：</p>

<ul>
	<li><strong>至少 </strong>包含 3 个字符。</li>
	<li>由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）</li>
	<li><strong>至少</strong> 包含一个 <strong>元音字母 </strong>。</li>
	<li><strong>至少</strong> 包含一个 <strong>辅音字母 </strong>。</li>
</ul>

<p>给你一个字符串 <code>word</code> 。如果 <code>word</code> 是一个有效单词，则返回 <code>true</code> ，否则返回 <code>false</code> 。</p>

<p><strong>注意：</strong></p>

<ul>
	<li><code>'a'</code>、<code>'e'</code>、<code>'i'</code>、<code>'o'</code>、<code>'u'</code> 及其大写形式都属于<strong> 元音字母 </strong>。</li>
	<li>英文中的 <strong>辅音字母 </strong>是指那些除元音字母之外的字母。</li>
</ul>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "234Adas"</span></p>

<p><strong>输出：</strong><span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<p>这个单词满足所有条件。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "b3"</span></p>

<p><strong>输出：</strong><span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<p>这个单词的长度少于 3 且没有包含元音字母。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "a3$e"</span></p>

<p><strong>输出：</strong><span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<p>这个单词包含了 <code>'$'</code> 字符且没有包含辅音字母。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 20</code></li>
	<li><code>word</code> 由英文大写和小写字母、数字、<code>'@'</code>、<code>'#'</code> 和 <code>'$'</code> 组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False
        vs = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}
        v = c = False
        for x in word:
            if '0' <= x <= '9':
                continue
            elif x in vs:
                v = True
            elif 'a' <= x <= 'z' or 'A' <= x <= 'Z':
                c = True
            else:
                return False
        return v and c
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> vs = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        boolean v = false, c = false;
        for (char x : word.toCharArray()) {
            if ('0' <= x && x <= '9') {
                continue;
            } else if (vs.contains(x)) {
                v = true;  
            } else if (('a' <= x && x <= 'z') || ('A' <= x && x <= 'Z')) {
                c = true;
            } else {
                return false;
            }
        }
        return v && c;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
