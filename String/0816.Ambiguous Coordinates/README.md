# [816. 模糊坐标](https://leetcode-cn.com/problems/ambiguous-coordinates)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们有一些二维坐标，如&nbsp;<code>&quot;(1, 3)&quot;</code>&nbsp;或&nbsp;<code>&quot;(2, 0.5)&quot;</code>，然后我们移除所有逗号，小数点和空格，得到一个字符串<code>S</code>。返回所有可能的原始字符串到一个列表中。</p>

<p>原始的坐标表示法不会存在多余的零，所以不会出现类似于&quot;00&quot;, &quot;0.0&quot;, &quot;0.00&quot;, &quot;1.0&quot;, &quot;001&quot;, &quot;00.01&quot;或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现&ldquo;.1&rdquo;形式的数字。</p>

<p>最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。</p>

<p>&nbsp;</p>

<pre>
<strong>示例 1:</strong>
<strong>输入:</strong> &quot;(123)&quot;
<strong>输出:</strong> [&quot;(1, 23)&quot;, &quot;(12, 3)&quot;, &quot;(1.2, 3)&quot;, &quot;(1, 2.3)&quot;]
</pre>

<pre>
<strong>示例 2:</strong>
<strong>输入:</strong> &quot;(00011)&quot;
<strong>输出:</strong> &nbsp;[&quot;(0.001, 1)&quot;, &quot;(0, 0.011)&quot;]
<strong>解释:</strong> 
0.0, 00, 0001 或 00.01 是不被允许的。
</pre>

<pre>
<strong>示例 3:</strong>
<strong>输入:</strong> &quot;(0123)&quot;
<strong>输出:</strong> [&quot;(0, 123)&quot;, &quot;(0, 12.3)&quot;, &quot;(0, 1.23)&quot;, &quot;(0.1, 23)&quot;, &quot;(0.1, 2.3)&quot;, &quot;(0.12, 3)&quot;]
</pre>

<pre>
<strong>示例 4:</strong>
<strong>输入:</strong> &quot;(100)&quot;
<strong>输出:</strong> [(10, 0)]
<strong>解释:</strong> 
1.0 是不被允许的。
</pre>

<p>&nbsp;</p>

<p><strong>提示: </strong></p>

<ul>
	<li><code>4 &lt;= S.length &lt;= 12</code>.</li>
	<li><code>S[0]</code> = &quot;(&quot;, <code>S[S.length - 1]</code> = &quot;)&quot;, 且字符串&nbsp;<code>S</code>&nbsp;中的其他元素都是数字。</li>
</ul>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        s = s[1:-1]
        n = len(s)
        ans = set()
        for i in range(n):
            ls, rs = list(), list()
            left = s[:i + 1]
            right = s[i + 1:]
            if not left or not right:
                continue
            if len(left) == 1:
                ls.append(left)
            else:
                if left[0] == '0':
                    ls.append("0." + left[1:])
                else:
                    ls.append(left)
                    num = left[-1] != '0'
                    for j in range(len(left) - 2, -1, -1):
                        if not num:
                            if left[j] != '0':
                                num = True
                            continue
                        ls.append(left[:j + 1] + "." + left[j + 1:])
            if len(right) == 1:
                rs.append(right)
            else:
                if right[0] == '0':
                    rs.append("0." + right[1:])
                else:
                    rs.append(right)
                    num = right[-1] != '0'
                    for j in range(len(right) - 2, -1, -1):
                        if not num:
                            if right[j] != '0':
                                num = True
                            continue
                        rs.append(right[:j + 1] + "." + right[j + 1:])
            for l in ls:
                if '.' in l and l[-1] == '0':
                    continue     
                for r in rs:
                    if '.' in r and r[-1] == '0':
                        continue
                    ans.add("(" + l + ", " + r + ")")
        return list(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i), right = s.substring(i);
            if ("".equals(left) || "".equals(right)) {
                continue;
            }
            List<String> ls = new ArrayList<>(), rs = new ArrayList<>();
            if (left.length() == 1) {
                ls.add(left);
            } else {
                int n = left.length();
                boolean num = left.charAt(n - 1) != '0';
                if (left.charAt(0) == '0') {
                    if (num) {
                        ls.add("0." + left.substring(1));
                    }
                } else {
                    ls.add(left);
                    for (int j = n - 2; j > -1; j--) {
                        if (!num) {
                            if (left.charAt(j) != '0') {
                                num = true;
                            }
                            continue;
                        }
                        ls.add(left.substring(0, j + 1) + "." + left.substring(j + 1));
                    }
                }
            }
            if (right.length() == 1) {
                rs.add(right);
            } else {
                int n = right.length();
                boolean num = right.charAt(n - 1) != '0';
                if (right.charAt(0) == '0') {
                    if (num) {
                        rs.add("0." + right.substring(1));
                    }
                } else {
                    rs.add(right);
                    for (int j = n - 2; j > -1; j--) {
                        if (!num) {
                            if (right.charAt(j) != '0') {
                                num = true;
                            }
                            continue;
                        }
                        rs.add(right.substring(0, j + 1) + "." + right.substring(j + 1));
                    }
                }
            }
            for (String l : ls) {
                if (l.contains(".") && l.charAt(l.length() - 1) == '0') {
                    continue;
                }
                for (String r : rs) {
                    if (r.contains(".") && r.charAt(r.length() - 1) == '0') {
                        continue;
                    }
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }
}
```

### **...**

```

```

<!-- tabs:end -->
