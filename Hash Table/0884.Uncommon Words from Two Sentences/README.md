# [884. 两句话中的不常见单词](https://leetcode-cn.com/problems/uncommon-words-from-two-sentences)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个句子&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;。&nbsp;（<em>句子</em>是一串由空格分隔的单词。每个<em>单词</em>仅由小写字母组成。）</p>

<p>如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是<em>不常见的</em>。</p>

<p>返回所有不常用单词的列表。</p>

<p>您可以按任何顺序返回列表。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = &quot;this apple is sweet&quot;, B = &quot;this apple is sour&quot;
<strong>输出：</strong>[&quot;sweet&quot;,&quot;sour&quot;]
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre><strong>输入：</strong>A = &quot;apple apple&quot;, B = &quot;banana&quot;
<strong>输出：</strong>[&quot;banana&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= A.length &lt;= 200</code></li>
	<li><code>0 &lt;= B.length &lt;= 200</code></li>
	<li><code>A</code> 和&nbsp;<code>B</code>&nbsp;都只包含空格和小写字母。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        mp = dict()
        for w in s1.split(" "):
            mp[w] = mp.get(w, 0) + 1
        for w in s2.split(" "):
            mp[w] = mp.get(w, 0) + 1
        ans = []
        for k in mp.keys():
            if mp[k] == 1:
                ans.append(k) 
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mp = new HashMap<>();
        for (String w : A.split(" ")) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        for (String w : B.split(" ")) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String k : mp.keySet()) {
            if (mp.get(k) == 1) {
                ans.add(k);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
