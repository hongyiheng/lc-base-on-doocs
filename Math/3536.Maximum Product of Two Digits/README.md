# [3536. 两个数字的最大乘积](https://leetcode.cn/problems/maximum-product-of-two-digits)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个正整数 <code>n</code>。</p>

<p>返回 <strong>任意两位数字&nbsp;</strong>相乘所得的&nbsp;<strong>最大&nbsp;</strong>乘积。</p>

<p><strong>注意：</strong>如果某个数字在 <code>n</code> 中出现多次，你可以多次使用该数字。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 31</span></p>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li><code>n</code> 的数字是 <code>[3, 1]</code>。</li>
	<li>任意两位数字相乘的结果为：<code>3 * 1 = 3</code>。</li>
	<li>最大乘积为 3。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 22</span></p>

<p><strong>输出：</strong> <span class="example-io">4</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li><code>n</code> 的数字是 <code>[2, 2]</code>。</li>
	<li>任意两位数字相乘的结果为：<code>2 * 2 = 4</code>。</li>
	<li>最大乘积为 4。</li>
</ul>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 124</span></p>

<p><strong>输出：</strong> <span class="example-io">8</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li><code>n</code> 的数字是 <code>[1, 2, 4]</code>。</li>
	<li>任意两位数字相乘的结果为：<code>1 * 2 = 2</code>, <code>1 * 4 = 4</code>, <code>2 * 4 = 8</code>。</li>
	<li>最大乘积为 8。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>10 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxProduct(self, n: int) -> int:
        mx = ans = 0
        while n:
            v = n % 10
            ans = max(ans, v * mx)
            mx = max(mx, v)
            n //= 10
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxProduct(int n) {
        int mx = 0, ans = 0;
        while (n > 0) {
            int v = n % 10;
            ans = Math.max(ans, mx * v);
            mx = Math.max(mx, v);
            n /= 10;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
