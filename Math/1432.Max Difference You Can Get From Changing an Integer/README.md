# [1432. 改变一个整数能得到的最大差值](https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数&nbsp;<code>num</code>&nbsp;。你可以对它进行如下步骤恰好 <strong>两次</strong>&nbsp;：</p>

<ul>
	<li>选择一个数字&nbsp;<code>x (0&nbsp;&lt;= x &lt;= 9)</code>.</li>
	<li>选择另一个数字&nbsp;<code>y (0&nbsp;&lt;= y &lt;= 9)</code>&nbsp;。数字&nbsp;<code>y</code>&nbsp;可以等于&nbsp;<code>x</code>&nbsp;。</li>
	<li>将 <code>num</code>&nbsp;中所有出现 <code>x</code>&nbsp;的数位都用 <code>y</code>&nbsp;替换。</li>
	<li>得到的新的整数 <strong>不能</strong>&nbsp;有前导 0 ，得到的新整数也 <strong>不能</strong>&nbsp;是 0&nbsp;。</li>
</ul>

<p>令两次对 <code>num</code>&nbsp;的操作得到的结果分别为&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>&nbsp;。</p>

<p>请你返回&nbsp;<code>a</code> 和&nbsp;<code>b</code>&nbsp;的 <strong>最大差值</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>num = 555
<strong>输出：</strong>888
<strong>解释：</strong>第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
现在，我们有 a = 999 和 b = 111 ，最大差值为 888
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>num = 9
<strong>输出：</strong>8
<strong>解释：</strong>第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
现在，我们有 a = 9 和 b = 1 ，最大差值为 8
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>num = 123456
<strong>输出：</strong>820000
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>num = 10000
<strong>输出：</strong>80000
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>num = 9288
<strong>输出：</strong>8700
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10^8</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxDiff(self, num: int) -> int:
        a = b = av = bv = -1
        mx = mi = 0
        s = str(num)
        for i, c in enumerate(s):
            v = int(c)
            if i == 0 and v != 1 and b == -1:
                b = v
                bv = 1
            if i and v and c != s[0] and b == -1:
                b = v
                bv = 0
            if v != 9 and a == -1:
                a = v
                av = 9
            mx = mx * 10 + (av if v == a else v)
            mi = mi * 10 + (bv if v == b else v)
        return mx - mi
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxDiff(int num) {
        int a = -1, b = -1, av = -1, bv = -1;
        int mx = 0, mi = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            if (i == 0 && v != 1 && b == -1) {
                b = v;
                bv = 1;
            }
            if (i > 0 && v > 0 && s.charAt(i) != s.charAt(0) && b == -1) {
                b = v;
                bv = 0;
            }
            if (v != 9 && a == -1) {
                a = v;
                av = 9;
            }
            mx = mx * 10 + (v == a ? av : v);
            mi = mi * 10 + (v == b ? bv : v);
        }
        return mx - mi;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
