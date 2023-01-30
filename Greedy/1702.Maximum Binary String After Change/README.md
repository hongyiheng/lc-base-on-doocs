# [1702. 修改后的最大二进制字符串](https://leetcode-cn.com/problems/maximum-binary-string-after-change)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制字符串 <code>binary</code> ，它仅有 <code>0</code> 或者 <code>1</code> 组成。你可以使用下面的操作任意次对它进行修改：</p>

<ul>
	<li>操作 1 ：如果二进制串包含子字符串 <code>"00"</code> ，你可以用 <code>"10"</code> 将其替换。

	<ul>
		<li>比方说， <code>"<strong>00</strong>010" -> "<strong>10</strong>010"</code></li>
	</ul>
	</li>
	<li>操作 2 ：如果二进制串包含子字符串 <code>"10"</code> ，你可以用 <code>"01"</code> 将其替换。
	<ul>
		<li>比方说， <code>"000<strong>10</strong>" -> "000<strong>01</strong>"</code></li>
	</ul>
	</li>
</ul>

<p>请你返回执行上述操作任意次以后能得到的 <strong>最大二进制字符串</strong> 。如果二进制字符串 <code>x</code> 对应的十进制数字大于二进制字符串 <code>y</code> 对应的十进制数字，那么我们称二进制字符串<em> </em><code>x</code><em> </em>大于二进制字符串<em> </em><code>y</code><em> </em>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>binary = "000110"
<b>输出：</b>"111011"
<b>解释：</b>一个可行的转换为：
"0001<strong>10</strong>" -> "0001<strong>01</strong>" 
"<strong>00</strong>0101" -> "<strong>10</strong>0101" 
"1<strong>00</strong>101" -> "1<strong>10</strong>101" 
"110<strong>10</strong>1" -> "110<strong>01</strong>1" 
"11<strong>00</strong>11" -> "11<strong>10</strong>11"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>binary = "01"
<b>输出：</b>"01"
<b>解释：</b>"01" 没办法进行任何转换。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= binary.length <= 10<sup>5</sup></code></li>
	<li><code>binary</code> 仅包含 <code>'0'</code> 和 <code>'1'</code> 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        cnt, begin = 0, 0x3f3f3f
        for i, c in enumerate(binary):
            if c == '0':
                cnt += 1
                begin = min(i, begin)
        if cnt <= 1:
            return binary
        ans = ['1'] * len(binary)
        ans[begin + cnt - 1] = '0'
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String maximumBinaryString(String binary) {
        int cnt = 0, begin = 0x3f3f3f, n = binary.length();
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                begin = Math.min(i, begin);
                cnt++;
            }
        }
        if (cnt <= 1) {
            return binary;
        }
        char[] ans = new char[n];
        Arrays.fill(ans, '1');
        ans[begin + cnt - 1] = '0';
        return new String(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
