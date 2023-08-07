# [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 <code>char[]</code> 的形式给出。</p>

<p>不要给另外的数组分配额外的空间，你必须<strong><a href="https://baike.baidu.com/item/原地算法" target="_blank">原地</a>修改输入数组</strong>、使用 O(1) 的额外空间解决这一问题。</p>

<p>你可以假设数组中的所有字符都是 <a href="https://baike.baidu.com/item/ASCII" target="_blank">ASCII</a> 码表中的可打印字符。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[&quot;h&quot;,&quot;e&quot;,&quot;l&quot;,&quot;l&quot;,&quot;o&quot;]
<strong>输出：</strong>[&quot;o&quot;,&quot;l&quot;,&quot;l&quot;,&quot;e&quot;,&quot;h&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[&quot;H&quot;,&quot;a&quot;,&quot;n&quot;,&quot;n&quot;,&quot;a&quot;,&quot;h&quot;]
<strong>输出：</strong>[&quot;h&quot;,&quot;a&quot;,&quot;n&quot;,&quot;n&quot;,&quot;a&quot;,&quot;H&quot;]</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l, r = 0, len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
