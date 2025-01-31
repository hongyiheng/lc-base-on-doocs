# [541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串 <code>s</code> 和一个整数 <code>k</code>，你需要对从字符串开头算起的每隔&nbsp;<code>2k</code> 个字符的前 <code>k</code> 个字符进行反转。</p>

<ul>
	<li>如果剩余字符少于 <code>k</code> 个，则将剩余字符全部反转。</li>
	<li>如果剩余字符小于 <code>2k</code> 但大于或等于 <code>k</code> 个，则反转前 <code>k</code> 个字符，其余字符保持原样。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
<strong>输出:</strong> &quot;bacdfeg&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>该字符串只包含小写英文字母。</li>
	<li>给定字符串的长度和 <code>k</code> 在 <code>[1, 10000]</code> 范围内。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        n = len(s)
        ans = []
        for i in range(0, n, k):
            t = s[i:min(i + k, n)]
            if not i // k % 2:
                ans.append(t[::-1])
            else:
                ans.append(t)
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int i = 0; i < n; i+= k) {
            if (i / k % 2 == 0) {
                int l = i, r = Math.min(n - 1, i + k - 1);
                while (l < r) {
                    char t = ans[l];
                    ans[l] = ans[r];
                    ans[r] = t;
                    l++;
                    r--;
                }
            }
        }
        return new String(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
