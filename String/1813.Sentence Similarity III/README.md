# [1813. 句子相似性 III](https://leetcode-cn.com/problems/sentence-similarity-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，<code>"Hello World"</code> ，<code>"HELLO"</code> ，<code>"hello world hello world"</code> 都是句子。每个单词都 <strong>只</strong> 包含大写和小写英文字母。</p>

<p>如果两个句子 <code>sentence1</code> 和 <code>sentence2</code> ，可以通过往其中一个句子插入一个任意的句子（<strong>可以是空句子</strong>）而得到另一个句子，那么我们称这两个句子是 <strong>相似的</strong> 。比方说，<code>sentence1 = "Hello my name is Jane"</code> 且 <code>sentence2 = "Hello Jane"</code> ，我们可以往 <code>sentence2</code> 中 <code>"Hello"</code> 和 <code>"Jane"</code> 之间插入 <code>"my name is"</code> 得到 <code>sentence1</code> 。</p>

<p>给你两个句子 <code>sentence1</code> 和 <code>sentence2</code> ，如果<em> </em><code>sentence1</code> 和<em> </em><code>sentence2</code> 是相似的，请你返回 <code>true</code> ，否则返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>sentence1 = "My name is Haley", sentence2 = "My Haley"
<b>输出：</b>true
<b>解释：</b>可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>sentence1 = "of", sentence2 = "A lot of words"
<b>输出：</b>false
<strong>解释：</strong>没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>sentence1 = "Eating right now", sentence2 = "Eating"
<b>输出：</b>true
<b>解释：</b>可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
</pre>

<p><strong>示例 4：</strong></p>

<pre><b>输入：</b>sentence1 = "Luky", sentence2 = "Lucccky"
<b>输出：</b>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= sentence1.length, sentence2.length &lt;= 100</code></li>
	<li><code>sentence1</code> 和 <code>sentence2</code> 都只包含大小写英文字母和空格。</li>
	<li><code>sentence1</code> 和 <code>sentence2</code> 中的单词都只由单个空格隔开。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        if len(sentence1) < len(sentence2):
            sentence1, sentence2 = sentence2, sentence1
        if sentence1 == sentence2 or sentence1.startswith(sentence2 + " ") or sentence1.endswith(" " + sentence2):
            return True
        for i in range(len(sentence2)):
            if sentence2[i] != ' ':
                continue
            if sentence1.startswith(sentence2[:i] + ' ') and sentence1.endswith(sentence2[i:]):
                return True
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        if (sentence1.equals(sentence2)) {
            return true;
        }
        if (sentence1.startsWith(sentence2 + " ")) {
            return true;
        }
        if (sentence1.endsWith(" " + sentence2)) {
            return true;
        }
        for (int i = 0; i < sentence2.length(); i++) {
            if (sentence2.charAt(i) != ' ') {
                continue;
            }
            if (sentence1.startsWith(sentence2.substring(0, i) + " ") && sentence1.endsWith(sentence2.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
