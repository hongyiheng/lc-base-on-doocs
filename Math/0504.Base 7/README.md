# [504. 七进制数](https://leetcode-cn.com/problems/base-7)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数，将其转化为7进制，并以字符串形式输出。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> 100
<strong>输出:</strong> &quot;202&quot;
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> -7
<strong>输出:</strong> &quot;-10&quot;
</pre>

<p><strong>注意:</strong> 输入范围是&nbsp;[-1e7, 1e7] 。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
        flag = num > 0
        num = abs(num)
        ans = ""
        while num > 0:
            ans += str(num % 7)
            num //= 7
        return ans[::-1] if flag else "-" + ans[::-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = num > 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        String ans = sb.reverse().toString();
        return flag ? ans : "-" + ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
