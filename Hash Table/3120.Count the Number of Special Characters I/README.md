# [3120. 统计特殊字母的数量 I](https://leetcode.cn/problems/count-the-number-of-special-characters-i)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>word</code>。如果 <code>word</code> 中同时存在某个字母的小写形式和大写形式，则称这个字母为 <strong>特殊字母</strong> 。</p>

<p>返回 <code>word</code> 中<strong> </strong><strong>特殊字母 </strong>的数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "aaAbcBC"</span></p>

<p><strong>输出：</strong><span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p><code>word</code> 中的特殊字母是 <code>'a'</code>、<code>'b'</code> 和 <code>'c'</code>。</p>
</div>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "abc"</span></p>

<p><strong>输出：</strong><span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p><code>word</code> 中不存在大小写形式同时出现的字母。</p>
</div>

<p><strong class="example">示例 3:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">word = "abBCab"</span></p>

<p><strong>输出：</strong>1</p>

<p><strong>解释：</strong></p>

<p><code>word</code> 中唯一的特殊字母是 <code>'b'</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 50</code></li>
	<li><code>word</code> 仅由小写和大写英文字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        cnt = [[False] * 2 for _ in range(26)]
        for c in word:
            v = ord(c)
            if 'a' <= c <= 'z':
                v -= ord('a')
                cnt[v][0] = True
            else:
                v -= ord('A')
                cnt[v][1] = True
        return sum(1 if a and b else 0 for a, b in cnt)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[][] cnt = new boolean[26][2];
        for (char c : word.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                int v = c - 'a';
                cnt[v][0] = true;
            } else {
                int v = c - 'A';
                cnt[v][1] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i][0] && cnt[i][1]) {
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
