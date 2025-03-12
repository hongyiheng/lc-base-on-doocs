# [3305. 元音辅音字符串计数 I](https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>word</code> 和一个 <strong>非负 </strong>整数 <code>k</code>。</p>

<p>返回 <code>word</code> 的 <span data-keyword="substring-nonempty">子字符串</span> 中，每个元音字母（<code>'a'</code>、<code>'e'</code>、<code>'i'</code>、<code>'o'</code>、<code>'u'</code>）<strong>至少</strong> 出现一次，并且 <strong>恰好 </strong>包含 <code>k</code> 个辅音字母的子字符串的总数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "aeioqq", k = 1</span></p>

<p><strong>输出：</strong><span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p>不存在包含所有元音字母的子字符串。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "aeiou", k = 0</span></p>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p>唯一一个包含所有元音字母且不含辅音字母的子字符串是 <code>word[0..4]</code>，即 <code>"aeiou"</code>。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "ieaouqqieaouqq", k = 1</span></p>

<p><strong>输出：</strong>3</p>

<p><strong>解释：</strong></p>

<p>包含所有元音字母并且恰好含有一个辅音字母的子字符串有：</p>

<ul>
	<li><code>word[0..5]</code>，即 <code>"ieaouq"</code>。</li>
	<li><code>word[6..11]</code>，即 <code>"qieaou"</code>。</li>
	<li><code>word[7..12]</code>，即 <code>"ieaouq"</code>。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>5 &lt;= word.length &lt;= 250</code></li>
	<li><code>word</code> 仅由小写英文字母组成。</li>
	<li><code>0 &lt;= k &lt;= word.length - 5</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        n = len(word)
        ans = 0
        for i in range(n):
            g = defaultdict(int)
            t = 0
            for j in range(i, n):
                c = word[j]
                if c in {'a', 'e', 'i', 'o', 'u'}:
                    g[c] += 1
                else:
                    t += 1
                if len(g.keys()) == 5 and t == k:
                    ans += 1
                if t > k:
                    break
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> s = new HashSet<>();
            int t = 0;
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (vowel.contains(c)) {
                    s.add(c);
                } else {
                    t++;
                }
                if (s.size() == 5 && t == k) {
                    ans++;
                }
                if (t > k) {
                    break;
                }
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
