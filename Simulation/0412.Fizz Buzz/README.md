# [412. Fizz Buzz](https://leetcode-cn.com/problems/fizz-buzz)



## 题目描述

<!-- 这里写题目描述 -->

<p>写一个程序，输出从 1 到 <em>n</em> 数字的字符串表示。</p>

<p>1. 如果&nbsp;<em>n&nbsp;</em>是3的倍数，输出&ldquo;Fizz&rdquo;；</p>

<p>2. 如果&nbsp;<em>n&nbsp;</em>是5的倍数，输出&ldquo;Buzz&rdquo;；</p>

<p>3.如果&nbsp;<em>n&nbsp;</em>同时是3和5的倍数，输出 &ldquo;FizzBuzz&rdquo;。</p>

<p><strong>示例：</strong></p>

<pre>n = 15,

返回:
[
    &quot;1&quot;,
    &quot;2&quot;,
    &quot;Fizz&quot;,
    &quot;4&quot;,
    &quot;Buzz&quot;,
    &quot;Fizz&quot;,
    &quot;7&quot;,
    &quot;8&quot;,
    &quot;Fizz&quot;,
    &quot;Buzz&quot;,
    &quot;11&quot;,
    &quot;Fizz&quot;,
    &quot;13&quot;,
    &quot;14&quot;,
    &quot;FizzBuzz&quot;
]
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        ans = []
        for i in range(1, n + 1):
            if i % 3 == 0 and i % 5 == 0:
                ans.append("FizzBuzz")
            elif i % 3 == 0:
                ans.append("Fizz")
            elif i % 5 == 0:
                ans.append("Buzz")
            else:
                ans.append(str(i))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
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
