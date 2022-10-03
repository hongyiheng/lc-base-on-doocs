# [1784. 检查二进制字符串字段](https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制字符串 <code>s</code> ，该字符串 <strong>不含前导零</strong> 。</p>

<p>如果 <code>s</code> 最多包含 <strong>一个由连续的 <code>'1'</code> 组成的字段</strong> ，返回 <code>true</code>​​​ 。否则，返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "1001"
<strong>输出：</strong>false
<strong>解释：</strong>字符串中的 1 没有形成一个连续字段。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "110"
<strong>输出：</strong>true</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 100</code></li>
	<li><code>s[i]</code>​​​​ 为 <code>'0'</code> 或 <code>'1'</code></li>
	<li><code>s[0]</code> 为 <code>'1'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        ans = idx = 0
        n = len(s)
        while idx < n:
            if s[idx] == '1':
                ans += 1
                while idx < n and s[idx] == '1':
                    idx += 1
            else:
                idx += 1
        return ans <= 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkOnesSegment(String s) {
        int ans = 0, n = s.length(), idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == '1') {
                ans++;
                while (idx < n && s.charAt(idx) == '1') {
                    idx++;
                }
            } else {
                idx++;
            }
        }
        return ans <= 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
