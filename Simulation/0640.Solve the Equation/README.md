# [640. 求解方程](https://leetcode-cn.com/problems/solve-the-equation)



## 题目描述

<!-- 这里写题目描述 -->

<p>求解一个给定的方程，将<code>x</code>以字符串&quot;x=#value&quot;的形式返回。该方程仅包含&#39;+&#39;，&#39; - &#39;操作，变量&nbsp;<code>x</code>&nbsp;和其对应系数。</p>

<p>如果方程没有解，请返回&ldquo;No solution&rdquo;。</p>

<p>如果方程有无限解，则返回&ldquo;Infinite solutions&rdquo;。</p>

<p>如果方程中只有一个解，要保证返回值&nbsp;<code>x</code>&nbsp;是一个整数。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> &quot;x+5-3+x=6+x-2&quot;
<strong>输出:</strong> &quot;x=2&quot;
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot;x=x&quot;
<strong>输出:</strong> &quot;Infinite solutions&quot;
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> &quot;2x=x&quot;
<strong>输出:</strong> &quot;x=0&quot;
</pre>

<p><strong>示例 4:</strong></p>

<pre><strong>输入:</strong> &quot;2x+3x-6x=x+2&quot;
<strong>输出:</strong> &quot;x=-1&quot;
</pre>

<p><strong>示例 5:</strong></p>

<pre><strong>输入:</strong> &quot;x=x+2&quot;
<strong>输出:</strong> &quot;No solution&quot;
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def solveEquation(self, equation: str) -> str:
        idx, n = 0, len(equation)
        left_x = right_x = 0
        left = right = 0
        cur, left_part = "", True
        while idx < n:
            if "0" <= equation[idx] <= "9":
                cur += equation[idx]
            elif equation[idx] == "x":
                if cur == "-":
                    cur = "-1"
                if left_part:
                    left_x += 1 if cur == "" else int(cur)
                else:
                    right_x += 1 if cur == "" else int(cur)
                cur = ""
            else:
                if left_part:
                    left += 0 if cur == "" else int(cur)
                else:
                    right += 0 if cur == "" else int(cur)
                cur = ""
                if equation[idx] == "=":
                    left_part = False
                if equation[idx] == "-":
                    cur = "-"
            idx += 1
        if cur:
            right += 0 if cur == "" else int(cur)
        if left_x == right_x and left == right:
            return "Infinite solutions"
        if left_part or left_x == right_x:
            return "No solution"
        return "x=" + str(int((right - left) / (left_x - right_x)))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String solveEquation(String equation) {
        char[] cs = equation.toCharArray();
        int idx = 0, n = cs.length;
        int leftX = 0, rightX = 0, left = 0, right = 0;
        String cur = "";
        boolean leftPart = true;
        while (idx < n) {
            if ('0' <= cs[idx] && cs[idx] <= '9') {
                cur += cs[idx];
            } else if (cs[idx] == 'x') {
                if ("-".equals(cur)) {
                    cur = "-1";
                }
                if (leftPart) {
                    leftX += "".equals(cur) ? 1 : Integer.parseInt(cur);
                } else {
                    rightX += "".equals(cur) ? 1 : Integer.parseInt(cur);
                }
                cur = "";
            } else {
                if (leftPart) {
                    left += "".equals(cur) ? 0 : Integer.parseInt(cur);
                } else {
                    right += "".equals(cur) ? 0 : Integer.parseInt(cur);
                }
                cur = "";
                if (cs[idx] == '=') {
                    leftPart = false;
                }
                if (cs[idx] == '-') {
                    cur = "-";
                }
            }
            idx++;
        }
        if (!"".equals(cur)) {
            right += Integer.parseInt(cur);
        }
        if (leftX == rightX && left == right) {
            return "Infinite solutions";
        }
        if (leftPart || leftX == rightX) {
            return "No solution";
        }
        return "x=" + (right - left) / (leftX - rightX);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
