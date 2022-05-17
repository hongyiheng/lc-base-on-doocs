# [953. 验证外星语词典](https://leetcode-cn.com/problems/verifying-an-alien-dictionary)



## 题目描述

<!-- 这里写题目描述 -->

<p>某种外星语也使用英文小写字母，但可能顺序 <code>order</code> 不同。字母表的顺序（<code>order</code>）是一些小写字母的排列。</p>

<p>给定一组用外星语书写的单词 <code>words</code>，以及其字母表的顺序 <code>order</code>，只有当给定的单词在这种外星语中按字典序排列时，返回 <code>true</code>；否则，返回 <code>false</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
<strong>输出：</strong>true
<strong>解释：</strong>在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
<strong>输出：</strong>false
<strong>解释：</strong>在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
<strong>输出：</strong>false
<strong>解释：</strong>当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（<a href="https://baike.baidu.com/item/%E5%AD%97%E5%85%B8%E5%BA%8F" target="_blank">更多信息</a>）。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 100</code></li>
	<li><code>1 <= words[i].length <= 20</code></li>
	<li><code>order.length == 26</code></li>
	<li>在 <code>words[i]</code> 和 <code>order</code> 中的所有字符都是英文小写字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        mp = [0] * 26
        for i in range(26):
            idx = ord(order[i]) - ord('a')
            mp[idx] = i
        pre = ""
        for w in words:
            eq = True
            for a, b in zip(pre, w):
                idx1 = ord(a) - ord('a')
                idx2 = ord(b) - ord('a')
                if mp[idx1] < mp[idx2]:
                    eq = False
                    break
                elif mp[idx1] > mp[idx2]:
                    return False
            if eq and len(pre) > len(w):
                return False
            pre = w
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mp = new int[26];
        for (int i = 0; i < 26; i++) {
            mp[order.charAt(i) - 'a'] = i;
        }
        String pre = "";
        for (String w : words) {
            boolean eq = true;
            for (int i = 0; i < Math.min(pre.length(), w.length()); i++) {
                int idx1 = pre.charAt(i) - 'a', idx2 = w.charAt(i) - 'a';
                if (mp[idx1] > mp[idx2]) {
                    return false;
                } else if (mp[idx1] < mp[idx2]) {
                    eq = false;
                    break;
                }
            }
            if (eq && pre.length() > w.length()) {
                return false;
            }
            pre = w;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
