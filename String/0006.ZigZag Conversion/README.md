# [6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion)



## 题目描述

<!-- 这里写题目描述 -->

<p>将一个给定字符串 <code>s</code> 根据给定的行数 <code>numRows</code> ，以从上往下、从左到右进行 Z 字形排列。</p>

<p>比如输入字符串为 <code>"PAYPALISHIRING"</code> 行数为 <code>3</code> 时，排列如下：</p>

<pre>
P   A   H   N
A P L S I I G
Y   I   R</pre>

<p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>"PAHNAPLSIIGYIR"</code>。</p>

<p>请你实现这个将字符串进行指定行数变换的函数：</p>

<pre>
string convert(string s, int numRows);</pre>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 3
<strong>输出：</strong>"PAHNAPLSIIGYIR"
</pre>
<strong>示例 2：</strong>

<pre>
<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 4
<strong>输出：</strong>"PINALSIGYAHRPI"
<strong>解释：</strong>
P     I    N
A   L S  I G
Y A   H R
P     I
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "A", numRows = 1
<strong>输出：</strong>"A"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>s</code> 由英文字母（小写和大写）、<code>','</code> 和 <code>'.'</code> 组成</li>
	<li><code>1 <= numRows <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        n = len(s)
        if n <= numRows or numRows == 1:
            return s
        t = (n + numRows - 1) // numRows
        c = (t - 1) * (numRows - 2) + t
        dic = [[""] * c for _ in range(numRows)]
        x = y = index = d = 0
        dirs = [[-1, 1], [1, 0]]
        while index < n:
            dic[x][y] = s[index]
            index += 1
            if x == numRows - 1 or x == 0:
                d = 0 if d == 1 else 1
            x += dirs[d][0]
            y += dirs[d][1]
        return ''.join(ch for row in dic for ch in row if ch)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }
        int t = (n + numRows - 1) / numRows;
        int c = (t - 1) * (numRows - 2) + t;
        String[][] ans = new String[numRows][c];
        int[][] dirs = new int[][]{{1, 0}, {-1, 1}};
        int x = 0, y = 0, d = 1, index = 0;
        while (index < n) {
            ans[x][y] = String.valueOf(s.charAt(index++));
            if (x == numRows - 1 || x == 0) {
                d = d == 1 ? 0 : 1;
            }
            x += dirs[d][0];
            y += dirs[d][1];
        }
        StringBuilder sb = new StringBuilder();
        for (String[] row : ans) {
            for (String ch : row) {
                if (!"".equals(ch) && ch != null) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
