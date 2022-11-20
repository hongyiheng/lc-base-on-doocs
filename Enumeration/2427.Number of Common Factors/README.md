# [2427. 公因子的数目](https://leetcode-cn.com/problems/number-of-common-factors)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个正整数 <code>a</code> 和 <code>b</code> ，返回 <code>a</code> 和 <code>b</code> 的 <strong>公</strong> 因子的数目。</p>

<p>如果 <code>x</code> 可以同时整除 <code>a</code> 和 <code>b</code> ，则认为 <code>x</code> 是 <code>a</code> 和 <code>b</code> 的一个 <strong>公因子</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>a = 12, b = 6
<strong>输出：</strong>4
<strong>解释：</strong>12 和 6 的公因子是 1、2、3、6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>a = 25, b = 30
<strong>输出：</strong>2
<strong>解释：</strong>25 和 30 的公因子是 1、5 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= a, b &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def commonFactors(self, a: int, b: int) -> int:
        ans = 0
        for i in range(1, min(a, b) + 1):
            if a % i == 0 and b % i == 0:
                ans += 1
        return ans

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i < Math.min(a, b) + 1; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
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
