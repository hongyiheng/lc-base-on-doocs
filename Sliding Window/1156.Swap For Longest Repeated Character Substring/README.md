# [1156. 单字符重复子串的最大长度](https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。</p>

<p>给你一个字符串&nbsp;<code>text</code>，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>text = &quot;ababa&quot;
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>text = &quot;aaabaaa&quot;
<strong>输出：</strong>6
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>text = &quot;aaabbaaa&quot;
<strong>输出：</strong>4
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>text = &quot;aaaaa&quot;
<strong>输出：</strong>5
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>text = &quot;abcdef&quot;
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= text.length &lt;= 20000</code></li>
	<li><code>text</code> 仅由小写英文字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxRepOpt1(self, text: str) -> int:
        cnt = Counter(text)
        ans = 0
        i, n = 0, len(text)
        while i < n:
            j = i + 1
            while j < n and text[j] == text[i]:
                j += 1
            k = j + 1
            while k < n and text[k] == text[i]:
                k += 1
            ans = max(ans, min(j - i + k - j, cnt[text[i]]))
            i = j
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0, i = 0, n = text.length();
        while (i < n) {
            int j = i + 1;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            ans = Math.max(ans, Math.min(j - i + k - j, cnt[text.charAt(i) - 'a']));
            i = j;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
