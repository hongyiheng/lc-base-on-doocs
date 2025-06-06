# [3335. 字符串转换后的长度 I](https://leetcode.cn/problems/total-characters-in-string-after-transformations-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 和一个整数 <code>t</code>，表示要执行的<strong> 转换 </strong>次数。每次 <strong>转换 </strong>需要根据以下规则替换字符串 <code>s</code> 中的每个字符：</p>

<ul>
	<li>如果字符是 <code>'z'</code>，则将其替换为字符串 <code>"ab"</code>。</li>
	<li>否则，将其替换为字母表中的<strong>下一个</strong>字符。例如，<code>'a'</code> 替换为 <code>'b'</code>，<code>'b'</code> 替换为 <code>'c'</code>，依此类推。</li>
</ul>

<p>返回<strong> 恰好 </strong>执行 <code>t</code> 次转换后得到的字符串的 <strong>长度</strong>。</p>

<p>由于答案可能非常大，返回其对 <code>10<sup>9</sup> + 7</code> 取余的结果。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "abcyy", t = 2</span></p>

<p><strong>输出：</strong> <span class="example-io">7</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li><strong>第一次转换 (t = 1)</strong>

	<ul>
		<li><code>'a'</code> 变为 <code>'b'</code></li>
		<li><code>'b'</code> 变为 <code>'c'</code></li>
		<li><code>'c'</code> 变为 <code>'d'</code></li>
		<li><code>'y'</code> 变为 <code>'z'</code></li>
		<li><code>'y'</code> 变为 <code>'z'</code></li>
		<li>第一次转换后的字符串为：<code>"bcdzz"</code></li>
	</ul>
	</li>
	<li><strong>第二次转换 (t = 2)</strong>
	<ul>
		<li><code>'b'</code> 变为 <code>'c'</code></li>
		<li><code>'c'</code> 变为 <code>'d'</code></li>
		<li><code>'d'</code> 变为 <code>'e'</code></li>
		<li><code>'z'</code> 变为 <code>"ab"</code></li>
		<li><code>'z'</code> 变为 <code>"ab"</code></li>
		<li>第二次转换后的字符串为：<code>"cdeabab"</code></li>
	</ul>
	</li>
	<li><strong>最终字符串长度</strong>：字符串为 <code>"cdeabab"</code>，长度为 7 个字符。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "azbk", t = 1</span></p>

<p><strong>输出：</strong> <span class="example-io">5</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li><strong>第一次转换 (t = 1)</strong>

	<ul>
		<li><code>'a'</code> 变为 <code>'b'</code></li>
		<li><code>'z'</code> 变为 <code>"ab"</code></li>
		<li><code>'b'</code> 变为 <code>'c'</code></li>
		<li><code>'k'</code> 变为 <code>'l'</code></li>
		<li>第一次转换后的字符串为：<code>"babcl"</code></li>
	</ul>
	</li>
	<li><strong>最终字符串长度</strong>：字符串为 <code>"babcl"</code>，长度为 5 个字符。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成。</li>
	<li><code>1 &lt;= t &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        f = [[0] * 26 for _ in range(t + 1)]
        for c in s:
            f[0][ord(c) - ord('a')] += 1
        for i in range(t):
            f[i + 1][0] = f[i][25]
            f[i + 1][1] = f[i][25] + f[i][0]
            for j in range(2, 26):
                f[i + 1][j] = f[i][j - 1]
        return sum(f[t]) % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = (int)1e9 + 7;
        long[][] f = new long[t + 1][26];
        for (char c : s.toCharArray()) {
            f[0][c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            f[i + 1][0] = f[i][25];
            f[i + 1][1] = (f[i][25] + f[i][0]) % mod;
            for (int j = 2; j < 26; j++) {
                f[i + 1][j] = f[i][j - 1];
            }
        }
        return (int)(Arrays.stream(f[t]).sum() % mod);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
