# [3340. 检查平衡字符串](https://leetcode.cn/problems/check-balanced-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个仅由数字 0 - 9 组成的字符串 <code>num</code>。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 <b>平衡字符串</b>。</p>

<p>如果 <code>num</code> 是一个 <strong>平衡字符串</strong>，则返回 <code>true</code>；否则，返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong>num<span class="example-io"> = "1234"</span></p>

<p><strong>输出：</strong><span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>偶数下标处的数字之和为 <code>1 + 3 = 4</code>，奇数下标处的数字之和为 <code>2 + 4 = 6</code>。</li>
	<li>由于 4 不等于 6，<code>num</code> 不是平衡字符串。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong>num<span class="example-io"> = "24123"</span></p>

<p><strong>输出：</strong>true</p>

<p><strong>解释：</strong></p>

<ul>
	<li>偶数下标处的数字之和为 <code>2 + 1 + 3 = 6</code>，奇数下标处的数字之和为 <code>4 + 2 = 6</code>。</li>
	<li>由于两者相等，<code>num</code> 是平衡字符串。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= num.length &lt;= 100</code></li>
	<li><code>num</code> 仅由数字 0 - 9 组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isBalanced(self, num: str) -> bool:
        ans = 0
        for i, v in enumerate(list(num)):
            if i % 2:
                ans += int(v)
            else:
                ans -= int(v)
        return ans == 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isBalanced(String num) {
        char[] cs = num.toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                ans += cs[i] - '0';
            } else {
                ans -= (cs[i] - '0');
            }
        }
        return ans == 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
