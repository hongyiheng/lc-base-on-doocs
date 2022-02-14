# [784. 字母大小写全排列](https://leetcode-cn.com/problems/letter-case-permutation)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串<code>S</code>，通过将字符串<code>S</code>中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。</p>

<p>&nbsp;</p>

<pre><strong>示例：</strong>
<strong>输入：</strong>S = &quot;a1b2&quot;
<strong>输出：</strong>[&quot;a1b2&quot;, &quot;a1B2&quot;, &quot;A1b2&quot;, &quot;A1B2&quot;]

<strong>输入：</strong>S = &quot;3z4&quot;
<strong>输出：</strong>[&quot;3z4&quot;, &quot;3Z4&quot;]

<strong>输入：</strong>S = &quot;12345&quot;
<strong>输出：</strong>[&quot;12345&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>S</code>&nbsp;的长度不超过<code>12</code>。</li>
	<li><code>S</code>&nbsp;仅由数字和字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        n = len(s)
        ans = []

        def backTracking(path, cur):
            nonlocal s
            if len(path) == n:
                ans.append(path)
                return
            path += s[cur]
            backTracking(path, cur + 1)
            path = path[:-1]
            if not s[cur].isdigit():
                c = chr(ord(s[cur]) - 32) if ord(s[cur]) - ord('a') >= 0 else chr(ord(s[cur]) + 32)
                path += c
                backTracking(path, cur + 1)

        backTracking("", 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<String> ans;
    int n;
    String s;

    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        n = s.length();
        this.s = s;
        backTracking(new StringBuilder(), 0);
        return ans;
    }

    public void backTracking(StringBuilder path, int cur) {
        if (path.length() == n) {
            ans.add(path.toString());
            return;
        }
        path.append(s.charAt(cur));
        backTracking(path, cur + 1);
        path.deleteCharAt(path.length() - 1);
        if (!Character.isDigit(s.charAt(cur))) {
            char c = s.charAt(cur) - 'a' >= 0 ? (char)(s.charAt(cur) - 32) : (char)(s.charAt(cur) + 32);
            path.append(c);
            backTracking(path, cur + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
