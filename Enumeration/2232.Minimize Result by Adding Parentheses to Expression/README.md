# [2232. 向表达式添加括号后的最小结果](https://leetcode-cn.com/problems/minimize-result-by-adding-parentheses-to-expression)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的字符串 <code>expression</code> ，格式为 <code>"&lt;num1&gt;+&lt;num2&gt;"</code> ，其中 <code>&lt;num1&gt;</code> 和 <code>&lt;num2&gt;</code> 表示正整数。</p>

<p>请你向 <code>expression</code> 中添加一对括号，使得在添加之后， <code>expression</code> 仍然是一个有效的数学表达式，并且计算后可以得到 <strong>最小</strong> 可能值。左括号 <strong>必须</strong> 添加在 <code>'+'</code> 的左侧，而右括号必须添加在 <code>'+'</code> 的右侧。</p>

<p>返回添加一对括号后形成的表达式&nbsp;<code>expression</code> ，且满足<em> </em><code>expression</code><em> </em>计算得到 <strong>最小</strong> 可能值<em>。</em>如果存在多个答案都能产生相同结果，返回任意一个答案。</p>

<p>生成的输入满足：<code>expression</code> 的原始值和添加满足要求的任一对括号之后 <code>expression</code> 的值，都符合 32-bit 带符号整数范围。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>expression = "247+38"
<strong>输出：</strong>"2(47+38)"
<strong>解释：</strong>表达式计算得到 2 * (47 + 38) = 2 * 85 = 170 。
注意 "2(4)7+38" 不是有效的结果，因为右括号必须添加在 <code>'+' 的右侧。</code>
可以证明 170 是最小可能值。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>expression = "12+34"
<strong>输出：</strong>"1(2+3)4"
<strong>解释：</strong>表达式计算得到 1 * (2 + 3) * 4 = 1 * 5 * 4 = 20 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>expression = "999+999"
<strong>输出：</strong>"(999+999)"
<strong>解释：</strong>表达式计算得到 999 + 999 = 1998 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= expression.length &lt;= 10</code></li>
	<li><code>expression</code> 仅由数字 <code>'1'</code> 到 <code>'9'</code> 和 <code>'+'</code> 组成</li>
	<li><code>expression</code> 由数字开始和结束</li>
	<li><code>expression</code> 恰好仅含有一个 <code>'+'</code>.</li>
	<li><code>expression</code> 的原始值和添加满足要求的任一对括号之后 <code>expression</code> 的值，都符合 32-bit 带符号整数范围</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimizeResult(self, expression: str) -> str:
        l, r = expression.split("+")
        ans, mi = "(" + expression + ")", int(l) + int(r)
        for i in range(len(l)):
            for j in range(1, len(r) + 1):
                la, lb = int(l[:i]) if l[:i] else 1, int(l[i:]) if l[i:] else 1
                ra, rb = int(r[:j]) if r[:j] else 1, int(r[j:]) if r[j:] else 1
                v = la * (lb + ra) * rb
                if v < mi:
                    mi = v
                    ans = l[:i] + "(" + l[i:] + '+' + r[:j] + ')' + r[j:]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String minimizeResult(String expression) {
        String[] s = expression.split("\\+");
        String ans = "(" + expression + ")";
        int mi = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
        for (int i = 0; i < s[0].length(); i++) {
            for (int j = 1; j < s[1].length() + 1; j++) {
                String la = s[0].substring(0, i), lb = s[0].substring(i);
                String ra = s[1].substring(0, j), rb = s[1].substring(j);
                int a = i == 0 ? 1 : Integer.parseInt(la), b = Integer.parseInt(lb);
                int c = Integer.parseInt(ra), d = j == s[1].length() ? 1 : Integer.parseInt(rb);
                int v = a * (b + c) * d;
                if (v < mi) {
                    mi = v;
                    ans = la + "(" + lb + "+" + ra + ")" + rb;
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
