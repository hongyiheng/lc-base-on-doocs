# [3297. 统计重新排列后包含另一个字符串的子字符串数目 I](https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串&nbsp;<code>word1</code> 和&nbsp;<code>word2</code>&nbsp;。</p>

<p>如果一个字符串 <code>x</code>&nbsp;重新排列后，<code>word2</code>&nbsp;是重排字符串的&nbsp;<span data-keyword="string-prefix">前缀</span>&nbsp;，那么我们称字符串&nbsp;<code>x</code>&nbsp;是&nbsp;<strong>合法的</strong>&nbsp;。</p>

<p>请你返回 <code>word1</code>&nbsp;中 <strong>合法</strong>&nbsp;<span data-keyword="substring-nonempty">子字符串</span>&nbsp;的数目。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>word1 = "bcca", word2 = "abc"</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><strong>解释：</strong></p>

<p>唯一合法的子字符串是&nbsp;<code>"bcca"</code>&nbsp;，可以重新排列得到&nbsp;<code>"abcc"</code>&nbsp;，<code>"abc"</code>&nbsp;是它的前缀。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>word1 = "abcabc", word2 = "abc"</span></p>

<p><span class="example-io"><b>输出：</b>10</span></p>

<p><strong>解释：</strong></p>

<p>除了长度为 1 和 2 的所有子字符串都是合法的。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>word1 = "abcabc", word2 = "aaabc"</span></p>

<p><span class="example-io"><b>输出：</b>0</span></p>
</div>

<p>&nbsp;</p>

<p><strong>解释：</strong></p>

<ul>
	<li><code>1 &lt;= word1.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= word2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>word1</code> 和&nbsp;<code>word2</code>&nbsp;都只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        def check():
            for a, b in zip(cnt, t):
                if a < b:
                    return False
            return True

        t, cnt = [0] * 26, [0] * 26
        for c in word2:
            t[ord(c) - ord('a')] += 1
            
        n = len(word1)
        l = r = ans = 0
        while r < n:
            v = ord(word1[r]) - ord('a')
            cnt[v] += 1
            while cnt[v] >= t[v] and check():
                ans += n - r
                cnt[ord(word1[l]) - ord('a')] -= 1
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] t = new int[26], cnt = new int[26];
        for (char c : word2.toCharArray()) {
            t[c - 'a']++;
        }
        int n = word1.length();
        int l = 0, r = 0;
        long ans = 0;
        while (r < n) {
            int v = word1.charAt(r) - 'a';
            cnt[v]++;
            while (cnt[v] >= t[v] && check(cnt, t)) {
                ans += n - r;
                cnt[word1.charAt(l++) - 'a']--;
            }
            r++;
        }
        return ans;
    }

    public boolean check(int[] cnt, int[] t) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] < t[i]) {
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
