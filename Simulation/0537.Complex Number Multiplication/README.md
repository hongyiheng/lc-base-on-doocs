# [537. 复数乘法](https://leetcode-cn.com/problems/complex-number-multiplication)



## 题目描述

<!-- 这里写题目描述 -->

<p><a href="https://baike.baidu.com/item/%E5%A4%8D%E6%95%B0/254365?fr=aladdin" target="_blank">复数</a> 可以用字符串表示，遵循 <code>"<strong>实部</strong>+<strong>虚部</strong>i"</code> 的形式，并满足下述条件：</p>

<ul>
	<li><code>实部</code> 是一个整数，取值范围是 <code>[-100, 100]</code></li>
	<li><code>虚部</code> 也是一个整数，取值范围是 <code>[-100, 100]</code></li>
	<li><code>i<sup>2</sup> == -1</code></li>
</ul>

<p>给你两个字符串表示的复数 <code>num1</code> 和 <code>num2</code> ，请你遵循复数表示形式，返回表示它们乘积的字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num1 = "1+1i", num2 = "1+1i"
<strong>输出：</strong>"0+2i"
<strong>解释：</strong>(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num1 = "1+-1i", num2 = "1+-1i"
<strong>输出：</strong>"0+-2i"
<strong>解释：</strong>(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>num1</code> 和 <code>num2</code> 都是有效的复数表示。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        a1 = int(num1.split("+")[0])
        a2 = int(num1.split("+")[1][:-1])
        b1 = int(num2.split("+")[0])
        b2 = int(num2.split("+")[1][:-1])
        return str(a1 * b1 - a2 * b2) + "+" + str(a1 * b2 + a2 * b1) + "i"
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.split("\\+")[0]);
        int n1 = num1.split("\\+")[1].length();
        int a2 = Integer.parseInt(num1.split("\\+")[1].substring(0, n1 - 1));
        int b1 = Integer.parseInt(num2.split("\\+")[0]);
        int n2 = num2.split("\\+")[1].length();
        int b2 = Integer.parseInt(num2.split("\\+")[1].substring(0, n2 - 1));
        int first = a1 * b1 - a2 * b2;
        int second = a1 * b2 + b1 * a2;
        return first + "+" + second + "i";
    }
}
```

### **...**

```

```

<!-- tabs:end -->
