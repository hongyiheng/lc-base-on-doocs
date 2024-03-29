# [779. 第K个语法符号](https://leetcode-cn.com/problems/k-th-symbol-in-grammar)



## 题目描述

<!-- 这里写题目描述 -->

<p>在第一行我们写上一个 <code>0</code>。接下来的每一行，将前一行中的<code>0</code>替换为<code>01</code>，<code>1</code>替换为<code>10</code>。</p>

<p>给定行数&nbsp;<code>N</code>&nbsp;和序数 <code>K</code>，返回第 <code>N</code> 行中第 <code>K</code>个字符。（<code>K</code>从1开始）</p>

<p><br>
<strong>例子:</strong></p>

<pre><strong>输入:</strong> N = 1, K = 1
<strong>输出:</strong> 0

<strong>输入:</strong> N = 2, K = 1
<strong>输出:</strong> 0

<strong>输入:</strong> N = 2, K = 2
<strong>输出:</strong> 1

<strong>输入:</strong> N = 4, K = 5
<strong>输出:</strong> 1

<strong>解释:</strong>
第一行: 0
第二行: 01
第三行: 0110
第四行: 01101001
</pre>

<p><br>
<strong>注意：</strong></p>

<ol>
	<li><code>N</code>&nbsp;的范围&nbsp;<code>[1, 30]</code>.</li>
	<li><code>K</code>&nbsp;的范围&nbsp;<code>[1, 2^(N-1)]</code>.</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n == 1:
            return 0
        if n == 2:
            return 0 if k == 1 else 1
        if k <= (1 << (n - 1)) / 2:
            return self.kthGrammar(n - 1, k)
        return self.kthGrammar(n - 1, k - (1 << (n - 2))) ^ 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return k == 1 ? 0 : 1;
        }
        if (k <= (1 << n - 1) / 2) {
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - (1 << n - 1) / 2) ^ 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
