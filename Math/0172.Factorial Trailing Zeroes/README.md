# [172. 阶乘后的零](https://leetcode-cn.com/problems/factorial-trailing-zeroes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数 <em>n</em>，返回 <em>n</em>! 结果尾数中零的数量。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 3
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;3! = 6, 尾数中没有零。</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> 5
<strong>输出:</strong> 1
<strong>解释:</strong>&nbsp;5! = 120, 尾数中有 1 个零.</pre>

<p><strong>说明: </strong>你算法的时间复杂度应为&nbsp;<em>O</em>(log&nbsp;<em>n</em>)<em>&nbsp;</em>。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def trailingZeroes(self, n: int) -> int:
        ans = 0
        while n >= 5:
            ans += n // 5
            n //= 5
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
