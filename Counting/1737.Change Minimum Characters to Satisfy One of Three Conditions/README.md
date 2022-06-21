# [1737. 满足三条件之一需改变的最少字符数](https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串 <code>a</code> 和 <code>b</code> ，二者均由小写字母组成。一步操作中，你可以将 <code>a</code> 或 <code>b</code> 中的 <strong>任一字符</strong> 改变为 <strong>任一小写字母</strong> 。</p>

<p>操作的最终目标是满足下列三个条件 <strong>之一</strong> ：</p>

<ul>
	<li><code>a</code> 中的 <strong>每个字母</strong> 在字母表中 <strong>严格小于</strong> <code>b</code> 中的 <strong>每个字母</strong> 。</li>
	<li><code>b</code> 中的 <strong>每个字母</strong> 在字母表中 <strong>严格小于</strong> <code>a</code> 中的 <strong>每个字母</strong> 。</li>
	<li><code>a</code> 和 <code>b</code> <strong>都</strong> 由 <strong>同一个</strong> 字母组成。</li>
</ul>

<p>返回达成目标所需的 <strong>最少</strong> 操作数<em>。</em></p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>a = "aba", b = "caa"
<strong>输出：</strong>2
<strong>解释：</strong>满足每个条件的最佳方案分别是：
1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>a = "dabadd", b = "cda"
<strong>输出：</strong>3
<strong>解释：</strong>满足条件 1 的最佳方案是将 b 变为 "eee" 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>5</sup></code></li>
	<li><code>a</code> 和 <code>b</code> 只由小写字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        m, n = len(a), len(b)
        cnt1, cnt2 = [0] * 26, [0] * 26
        for c in a:
            cnt1[ord(c) - ord('a')] += 1
        for c in b:
            cnt2[ord(c) - ord('a')] += 1
        ans = m - cnt1[0] + n - cnt2[0]
        for i in range(1, 26):
            first = second = third = 0
            for j in range(i, 26):
                first += cnt1[j]
                second += cnt2[j]
            for j in range(0, i):
                first += cnt2[j]
                second += cnt1[j]
            ans = min(ans, min(first, second))
            third = m - cnt1[i] + n - cnt2[i]
            ans = min(ans, third)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length(), n = b.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < m; i++) {
            cnt1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            cnt2[b.charAt(i) - 'a']++;
        }
        int ans = m - cnt1[0] + n - cnt2[0];
        for (int i = 1; i < 26; i++) {
            int first = 0, second = 0, third = 0;
            for (int j = i; j < 26; j++) {
                first += cnt1[j];
                second += cnt2[j];
            }
            for (int j = 0; j < i; j++) {
                first += cnt2[j];
                second += cnt1[j];
            }
            ans = Math.min(ans, Math.min(first, second));
            third = m - cnt1[i] + n - cnt2[i];
            ans = Math.min(ans, third);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
