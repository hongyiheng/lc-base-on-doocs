# [1015. 可被 K 整除的最小整数](https://leetcode-cn.com/problems/smallest-integer-divisible-by-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定正整数&nbsp;<code>K</code>，你需要找出可以被 K 整除的、仅包含数字 <strong>1</strong> 的最小正整数 N。</p>

<p>返回&nbsp;<code>N</code>&nbsp;的长度。如果不存在这样的&nbsp;<code>N</code>，就返回 <code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>1
<strong>输出：</strong>1
<strong>解释：</strong>最小的答案是 N = 1，其长度为 1。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>2
<strong>输出：</strong>-1
<strong>解释：</strong>不存在可被 2 整除的正整数 N 。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>3
<strong>输出：</strong>3
<strong>解释：</strong>最小的答案是 N = 111，其长度为 3。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= K &lt;= 10^5</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        cur = 1
        for i in range(1, k + 1):
            if cur % k == 0:
                return i
            cur = (cur % k * 10 + 1) % k
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int smallestRepunitDivByK(int k) {
        int cur = 1;
        for (int i = 1; i <= k; i++) {
            if (cur % k == 0) {
                return i;
            }
            cur = (cur % k * 10 + 1) % k;
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
