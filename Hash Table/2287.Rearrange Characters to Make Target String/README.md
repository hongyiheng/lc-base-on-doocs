# [2287. 重排字符形成目标字符串](https://leetcode-cn.com/problems/rearrange-characters-to-make-target-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong> 开始的字符串 <code>s</code> 和 <code>target</code> 。你可以从 <code>s</code> 取出一些字符并将其重排，得到若干新的字符串。</p>

<p>从 <code>s</code> 中取出字符并重新排列，返回可以形成 <code>target</code> 的 <strong>最大</strong> 副本数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "ilovecodingonleetcode", target = "code"
<strong>输出：</strong>2
<strong>解释：</strong>
对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
可以形成最多 2 个 "code" 的副本，所以返回 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "abcba", target = "abc"
<strong>输出：</strong>1
<strong>解释：</strong>
选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。 
可以形成最多 1 个 "abc" 的副本，所以返回 1 。
注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "abbaccaddaeea", target = "aaaaa"
<strong>输出：</strong>1
<strong>解释：</strong>
选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>1 &lt;= target.length &lt;= 10</code></li>
	<li><code>s</code> 和 <code>target</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        t = [0] * 26
        for c in target:
            t[ord(c) - ord('a')] += 1
        ans = 100
        for i, v in enumerate(t):
            if not v:
                continue
            ans = min(ans, cnt[i] // v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt = new int[26], t = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            t[c - 'a']++;
        }
        int ans = 100;
        for (int i = 0; i < 26; i++) {
            if (t[i] == 0) {
                continue;
            }
            ans = Math.min(ans, cnt[i] / t[i]);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
