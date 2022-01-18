# [633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负整数&nbsp;<code>c</code>&nbsp;，你要判断是否存在两个整数 <code>a</code> 和 <code>b</code>，使得&nbsp;<code>a<sup>2</sup> + b<sup>2</sup> = c</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>c = 5
<strong>输出：</strong>true
<strong>解释：</strong>1 * 1 + 2 * 2 = 5
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>c = 3
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>c = 4
<strong>输出：</strong>true
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>c = 2
<strong>输出：</strong>true
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>c = 1
<strong>输出：</strong>true</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= c &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        i, j = 0, int(math.sqrt(c))
        while i <= j:
            cur = i * i + j * j
            if cur == c:
                return True
            if cur > c:
                j -= 1
            else:
                i += 1
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            long cur = (long) i * i + (long) j * j;
            if (cur == c) {
                return true;
            }
            if (cur > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
