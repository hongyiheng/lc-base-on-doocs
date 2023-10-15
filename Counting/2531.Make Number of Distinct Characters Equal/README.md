# [2531. 使字符串总不同字符的数目相等](https://leetcode-cn.com/problems/make-number-of-distinct-characters-equal)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong> 开始的字符串 <code>word1</code> 和 <code>word2</code> 。</p>

<p>一次 <strong>移动</strong> 由以下两个步骤组成：</p>

<ul>
	<li>选中两个下标&nbsp;<code>i</code> 和 <code>j</code> ，分别满足 <code>0 &lt;= i &lt; word1.length</code> 和 <code>0 &lt;= j &lt; word2.length</code> ，</li>
	<li>交换 <code>word1[i]</code> 和 <code>word2[j]</code> 。</li>
</ul>

<p>如果可以通过 <strong>恰好一次</strong> 移动，使 <code>word1</code> 和 <code>word2</code> 中不同字符的数目相等，则返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>word1 = "ac", word2 = "b"
<strong>输出：</strong>false
<strong>解释：</strong>交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>word1 = "abcc", word2 = "aab"
<strong>输出：</strong>true
<strong>解释：</strong>交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>word1 = "abcde", word2 = "fghij"
<strong>输出：</strong>true
<strong>解释：</strong>无论交换哪一组下标，两个字符串中都会有 5 个不同字符。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>word1</code> 和 <code>word2</code> 仅由小写英文字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        cnt1, cnt2 =[0] * 26, [0] * 26
        for c in word1:
            cnt1[ord(c) - ord('a')] += 1
        for c in word2:
            cnt2[ord(c) - ord('a')] += 1
        f1 = f2 = 0
        for i in range(26):
            f1 += 1 if cnt1[i] else 0
            f2 += 1 if cnt2[i] else 0
        if abs(f1 - f2) > 2:
            return False
        for i in range(26):
            for j in range(26):
                if not cnt1[i] or  not cnt2[j]:
                    continue
                if i == j:
                    if f1 == f2:
                        return True
                    continue
                v1, v2 = f1, f2
                if cnt1[i] - 1 == 0:
                    v1 -= 1
                if not cnt1[j]:
                    v1 += 1
                if cnt2[j] - 1 == 0:
                    v2 -= 1
                if not cnt2[i]:
                    v2 += 1
                if v1 == v2:
                    return True
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int f1 = 0, f2 = 0;
        for (char c : word1.toCharArray()) {
            cnt1[c - 'a']++;
            if (cnt1[c - 'a'] == 1) {
                f1++;
            }
        }
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
            if (cnt2[c - 'a'] == 1) {
                f2++;
            }
        }
        if (Math.abs(f1 - f2) > 2) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j ++) {
                if (cnt1[i] == 0 || cnt2[j] == 0) {
                    continue;
                }
                if (i == j) {
                    if (f1 == f2) {
                        return true;
                    }
                    continue;
                }
                int v1 = f1, v2 = f2;
                if (cnt1[i] == 1) {
                    v1--;
                }
                if (cnt1[j] == 0) {
                    v1++;
                }
                if (cnt2[j] == 1) {
                    v2--;
                }
                if (cnt2[i] == 0) {
                    v2++;
                }
                if (v1 == v2) {
                    return true;
                }
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
