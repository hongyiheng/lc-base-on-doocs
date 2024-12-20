# [3138. 同位字符串连接的最小长度](https://leetcode.cn/problems/minimum-length-of-anagram-concatenation)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;，它由某个字符串&nbsp;<code>t</code>&nbsp;和若干&nbsp;<code>t</code>&nbsp; 的&nbsp;<strong>同位字符串</strong>&nbsp;连接而成。</p>

<p>请你返回字符串 <code>t</code>&nbsp;的 <strong>最小</strong>&nbsp;可能长度。</p>

<p><strong>同位字符串</strong>&nbsp;指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "abba"</span></p>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p>一个可能的字符串&nbsp;<code>t</code>&nbsp;为&nbsp;<code>"ba"</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "cdef"</span></p>

<p><span class="example-io"><b>输出：</b>4</span></p>

<p><strong>解释：</strong></p>

<p>一个可能的字符串&nbsp;<code>t</code>&nbsp;为&nbsp;<code>"cdef"</code>&nbsp;，注意&nbsp;<code>t</code>&nbsp;可能等于&nbsp;<code>s</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minAnagramLength(self, s: str) -> int:
        def check(x):
            t = pre[x]
            for i in range(2 * x, len(pre), x):
                for k in range(26):
                    if pre[i][k] - pre[i - x][k] != t[k]:
                        return False
            return True

        n = len(s)
        pre = [[0] * 26 for _ in range(n + 1)]
        for i, c in enumerate(s):
            pre[i + 1] = pre[i][::]
            pre[i + 1][ord(c) - ord('a')] += 1
        for i in range(1, n + 1):
            if n % i:
                continue
            if check(i):
                return i
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean check(int[][] pre, int x) {
        int[] t = pre[x];
        for (int i = x * 2; i < pre.length; i += x) {
            for (int j = 0; j < 26; j++) {
                if (pre[i][j] - pre[i - x][j] != t[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] pre = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            pre[i + 1] = pre[i].clone();
            pre[i + 1][idx]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (n % i != 0) {
                continue;
            }
            if (check(pre, i)) {
                return i;
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
