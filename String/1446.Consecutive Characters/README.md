# [1446. 连续字符](https://leetcode-cn.com/problems/consecutive-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。</p>

<p>请你返回字符串的能量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;leetcode&quot;
<strong>输出：</strong>2
<strong>解释：</strong>子字符串 &quot;ee&quot; 长度为 2 ，只包含字符 &#39;e&#39; 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;abbcccddddeeeeedcba&quot;
<strong>输出：</strong>5
<strong>解释：</strong>子字符串 &quot;eeeee&quot; 长度为 5 ，只包含字符 &#39;e&#39; 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;triplepillooooow&quot;
<strong>输出：</strong>5
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;hooraaaaaaaaaaay&quot;
<strong>输出：</strong>11
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = &quot;tourist&quot;
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code>&nbsp;只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxPower(self, s: str) -> int:
        res, cur_count, cur = 1, 1, s[0]
        for i in range(1, len(s)):
            if cur == s[i]:
                cur_count += 1
            else:
                cur = s[i]
                cur_count = 1
            res = max(cur_count, res)
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxPower(String s) {
        int res = 1, curCount = 1;
        char[] chars = s.toCharArray();
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                curCount++;
            } else {
                cur = chars[i];
                curCount = 1;
            }
            res = Math.max(res, curCount);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
