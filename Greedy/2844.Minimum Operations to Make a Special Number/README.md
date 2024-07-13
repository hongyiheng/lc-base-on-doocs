# [2844. 生成特殊数字的最少操作](https://leetcode-cn.com/problems/minimum-operations-to-make-a-special-number)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的字符串 <code>num</code> ，表示一个非负整数。</p>

<p>在一次操作中，您可以选择 <code>num</code> 的任意一位数字并将其删除。请注意，如果你删除 <code>num</code> 中的所有数字，则 <code>num</code> 变为 <code>0</code>。</p>

<p>返回最少需要多少次操作可以使 <code>num</code> 变成特殊数字。</p>

<p>如果整数 <code>x</code> 能被 <code>25</code> 整除，则该整数 <code>x</code> 被认为是特殊数字。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num = "2245047"
<strong>输出：</strong>2
<strong>解释：</strong>删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 2 位数字。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num = "2908305"
<strong>输出：</strong>3
<strong>解释：</strong>删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 3 位数字。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>num = "10"
<strong>输出：</strong>1
<strong>解释：</strong>删除 num[0] ，得到数字 "0" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
</pre>

<p>&nbsp;</p>

<p><strong>提示</strong></p>

<ul>
	<li><code>1 &lt;= num.length &lt;= 100</code></li>
	<li><code>num</code> 仅由数字 <code>'0'</code> 到 <code>'9'</code> 组成</li>
	<li><code>num</code> 不含任何前导零</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumOperations(self, num: str) -> int:
        n = len(num)
        t = a1 = False
        ans1 = ans2 = n
        for i in range(n - 1, -1, -1):
            if not t and num[i] == '5':
                t = True
                continue
            if t and num[i] in {'2', '7'}:
                a1 = True
                break
            ans1 -= 1

        t = False
        for i in range(n - 1, -1, -1):
            if t and num[i] in {'0', '5'}:
                break
            if num[i] == '0':
                t = True
                continue
            ans2 -= 1
        return n - max(ans1, ans2) if a1 else n - ans2
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean t = false, a1 = false;;
        int ans1 = n, ans2 = n;
        for (int i = n - 1; i >= 0; i--) {
            if (!t && num.charAt(i) == '5') {
                t = true;
                continue;
            }
            if (t && (num.charAt(i) == '2' || num.charAt(i) == '7')) {
                a1 = true;
                break;
            }
            ans1--;
        }

        t = false;
        for (int i = n - 1; i >= 0; i--) {
            if (t && (num.charAt(i) == '0' || num.charAt(i) == '5')) {
                break;
            }
            if (num.charAt(i) == '0') {
                t = true;
                continue;
            }
            ans2--;
        }
        return a1 ? n - Math.max(ans1, ans2) : n - ans2;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
