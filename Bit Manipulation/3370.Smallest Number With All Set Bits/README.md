# [3370. 仅含置位位的最小整数](https://leetcode.cn/problems/smallest-number-with-all-set-bits)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code>。</p>

<p>返回&nbsp;<strong>大于等于</strong> <code>n</code>&nbsp;且二进制表示仅包含&nbsp;<strong>置位&nbsp;</strong>位的&nbsp;<strong>最小&nbsp;</strong>整数 <code>x</code>&nbsp;。</p>

<p><strong>置位&nbsp;</strong>位指的是二进制表示中值为 <code>1</code> 的位。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 5</span></p>

<p><strong>输出：</strong> <span class="example-io">7</span></p>

<p><strong>解释：</strong></p>

<p>7 的二进制表示是 <code>"111"</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 10</span></p>

<p><strong>输出：</strong> <span class="example-io">15</span></p>

<p><strong>解释：</strong></p>

<p>15 的二进制表示是 <code>"1111"</code>。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 3</span></p>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p>3 的二进制表示是 <code>"11"</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestNumber(self, n: int) -> int:
        ans = 1
        while ans < n:
            ans = ans << 1 | 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int smallestNumber(int n) {
        int ans = 1;
        while (ans < n) {
            ans = ans << 1 | 1;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
