# [1832. 判断句子是否为全字母句](https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram)



## 题目描述

<!-- 这里写题目描述 -->

<p><strong>全字母句</strong> 指包含英语字母表中每个字母至少一次的句子。</p>

<p>给你一个仅由小写英文字母组成的字符串 <code>sentence</code> ，请你判断 <code>sentence</code> 是否为 <strong>全字母句</strong> 。</p>

<p>如果是，返回<em> </em><code>true</code> ；否则，返回<em> </em><code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>sentence = "thequickbrownfoxjumpsoverthelazydog"
<strong>输出：</strong>true
<strong>解释：</strong><code>sentence</code> 包含英语字母表中每个字母至少一次。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>sentence = "leetcode"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= sentence.length <= 1000</code></li>
	<li><code>sentence</code> 由小写英语字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        cnt = [False] * 26
        for c in sentence:
            cnt[ord(c) - ord('a')] = True
        ans = True
        for v in cnt:
            ans = ans and v
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] cnt = new boolean[26];
        for (char c : sentence.toCharArray()) {
            cnt[c - 'a'] = true;
        }
        boolean ans = true;
        for (boolean v : cnt) {
            ans &= v;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
