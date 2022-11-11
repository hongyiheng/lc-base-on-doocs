# [1704. 判断字符串的两半是否相似](https://leetcode-cn.com/problems/determine-if-string-halves-are-alike)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个偶数长度的字符串 <code>s</code> 。将其拆分成长度相同的两半，前一半为 <code>a</code> ，后一半为 <code>b</code> 。</p>

<p>两个字符串 <strong>相似</strong> 的前提是它们都含有相同数目的元音（<code>'a'</code>，<code>'e'</code>，<code>'i'</code>，<code>'o'</code>，<code>'u'</code>，<code>'A'</code>，<code>'E'</code>，<code>'I'</code>，<code>'O'</code>，<code>'U'</code>）。注意，<code>s</code> 可能同时含有大写和小写字母。</p>

<p>如果<em> </em><code>a</code><em> </em>和<em> </em><code>b</code> 相似，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "book"
<strong>输出：</strong>true
<strong>解释：</strong>a = "b<strong>o</strong>" 且 b = "<strong>o</strong>k" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "textbook"
<strong>输出：</strong>false
<strong>解释：</strong>a = "t<strong>e</strong>xt" 且 b = "b<strong>oo</strong>k" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
注意，元音 o 在 b 中出现两次，记为 2 个。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "MerryChristmas"
<strong>输出：</strong>false
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = "AbCdEfGh"
<strong>输出：</strong>true
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s.length</code> 是偶数</li>
	<li><code>s</code> 由 <strong>大写和小写</strong> 字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n = len(s)
        mid, ans = n // 2, 0
        for i in range(n): 
            if s[i] in {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}:
                ans += 1 if i + 1 <= mid else -1
        return ans == 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> ss = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            ss.add(c);
        }
        int n = s.length(), ans = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (ss.contains(s.charAt(i))) {
                ans += i + 1 <= mid ? 1 : -1;
            }
        }
        return ans == 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
