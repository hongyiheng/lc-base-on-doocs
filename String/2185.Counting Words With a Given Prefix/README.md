# [2185. 统计包含给定前缀的字符串](https://leetcode-cn.com/problems/counting-words-with-a-given-prefix)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串数组 <code>words</code> 和一个字符串 <code>pref</code> 。</p>

<p>返回 <code>words</code><em> </em>中以 <code>pref</code> 作为 <strong>前缀</strong> 的字符串的数目。</p>

<p>字符串 <code>s</code> 的 <strong>前缀</strong> 就是&nbsp; <code>s</code> 的任一前导连续字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>words = ["pay","<em><strong>at</strong></em>tention","practice","<em><strong>at</strong></em>tend"], <code>pref </code>= "at"
<strong>输出：</strong>2
<strong>解释：</strong>以 "at" 作为前缀的字符串有两个，分别是："<em><strong>at</strong></em>tention" 和 "<em><strong>at</strong></em>tend" 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>words = ["leetcode","win","loops","success"], <code>pref </code>= "code"
<strong>输出：</strong>0
<strong>解释：</strong>不存在以 "code" 作为前缀的字符串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length, pref.length &lt;= 100</code></li>
	<li><code>words[i]</code> 和 <code>pref</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        ans = 0
        for w in words:
            if len(w) < len(pref):
                continue
            flag = True
            for a, b in zip(pref, w):
                if a != b:
                    flag = False
                    break
            if flag:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String w : words) {
            if (w.length() < pref.length()) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < pref.length(); i++) {
                if (pref.charAt(i) != w.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
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
