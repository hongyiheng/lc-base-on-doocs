# [2375. 根据模式串构造最小数字](https://leetcode-cn.com/problems/construct-smallest-number-from-di-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你下标从 <strong>0</strong> 开始、长度为 <code>n</code>&nbsp;的字符串&nbsp;<code>pattern</code>&nbsp;，它包含两种字符，<code>'I'</code>&nbsp;表示 <strong>上升</strong>&nbsp;，<code>'D'</code>&nbsp;表示 <strong>下降</strong>&nbsp;。</p>

<p>你需要构造一个下标从 <strong>0</strong>&nbsp;开始长度为&nbsp;<code>n + 1</code>&nbsp;的字符串，且它要满足以下条件：</p>

<ul>
	<li><code>num</code>&nbsp;包含数字&nbsp;<code>'1'</code>&nbsp;到&nbsp;<code>'9'</code>&nbsp;，其中每个数字&nbsp;<strong>至多</strong>&nbsp;使用一次。</li>
	<li>如果&nbsp;<code>pattern[i] == 'I'</code>&nbsp;，那么&nbsp;<code>num[i] &lt; num[i + 1]</code>&nbsp;。</li>
	<li>如果&nbsp;<code>pattern[i] == 'D'</code>&nbsp;，那么&nbsp;<code>num[i] &gt; num[i + 1]</code>&nbsp;。</li>
</ul>

<p>请你返回满足上述条件字典序 <strong>最小</strong>&nbsp;的字符串<em>&nbsp;</em><code>num</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>pattern = "IIIDIDDD"
<b>输出：</b>"123549876"
<strong>解释：
</strong>下标 0 ，1 ，2 和 4 处，我们需要使 num[i] &lt; num[i+1] 。
下标 3 ，5 ，6 和 7 处，我们需要使 num[i] &gt; num[i+1] 。
一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
"123549876" 是满足条件最小的数字。
注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>pattern = "DDD"
<b>输出：</b>"4321"
<strong>解释：</strong>
一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
"4321" 是满足条件最小的数字。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length &lt;= 8</code></li>
	<li><code>pattern</code>&nbsp;只包含字符&nbsp;<code>'I'</code> 和&nbsp;<code>'D'</code> 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestNumber(self, pattern: str) -> str:
        n, idx = len(pattern), 0
        ans = [str(i) for i in range(1, n + 2)]
        while idx < n:
            if pattern[idx] == "I":
                idx += 1
                continue
            start = idx
            idx += 1
            while idx < n and pattern[idx] == "D":
                idx += 1
            ans[start:idx + 1] = ans[start:idx+1][::-1]
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length(), idx = 0;
        String[] ans = new String[n + 1];
        for (int i = 1; i < n + 2; i++) {
            ans[i - 1] = String.valueOf(i);
        }
        char[] cs = pattern.toCharArray();
        while (idx < n) {
            if (cs[idx] == 'I') {
                idx++;
                continue;
            }
            int l = idx;
            while (idx < n && cs[idx] == 'D') {
                idx++;
            }
            int r = idx;
            while (l < r) {
                String tmp = ans[l];
                ans[l] = ans[r];
                ans[r] = tmp;
                l++;
                r--;
            }
        }
        return String.join("", ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
