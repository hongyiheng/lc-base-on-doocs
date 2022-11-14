# [2457. 美丽整数的最小增量](https://leetcode-cn.com/problems/minimum-addition-to-make-integer-beautiful)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个正整数 <code>n</code> 和 <code>target</code> 。</p>

<p>如果某个整数每一位上的数字相加小于或等于 <code>target</code> ，则认为这个整数是一个 <strong>美丽整数</strong> 。</p>

<p>找出并返回满足 <code>n + x</code> 是 <strong>美丽整数</strong> 的最小非负整数 <code>x</code> 。生成的输入保证总可以使 <code>n</code> 变成一个美丽整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 16, target = 6
<strong>输出：</strong>4
<strong>解释：</strong>最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 467, target = 6
<strong>输出：</strong>33
<strong>解释：</strong>最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 + 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 1, target = 1
<strong>输出：</strong>0
<strong>解释：</strong>最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>12</sup></code></li>
	<li><code>1 &lt;= target &lt;= 150</code></li>
	<li>生成的输入保证总可以使 <code>n</code> 变成一个美丽整数。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def makeIntegerBeautiful(self, n: int, target: int) -> int:
        s = ['0'] + list(str(n))
        cnt, n = 0, len(s)
        for c in s:
            cnt += int(c)
        ans = 0
        for i in range(n - 1, 0, -1):
            if cnt <= target:
                break
            if s[i] != 0:
                idx = 1 if n - i - 1 == 0 else 10 ** (n - i - 1)
                ans += (10 - int(s[i])) * idx
                cnt -= (int(s[i]) - 1)
                s[i] = '0'
                s[i - 1] = str(int(s[i - 1]) + 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        char[] cs = ("0" + n).toCharArray();
        long ans = 0, cnt = 0;
        for (char c : cs) {
            cnt += c - '0';
        }
        int m = cs.length;
        for (int i = m - 1; i > 0; i--) {
            if (cnt <= target) {
                break;
            }
            if (cs[i] != '0') {
                long idx = (long) Math.pow(10, m - i - 1);
                ans += idx * (10 - (cs[i] - '0'));
                cnt -= (cs[i] - '0' - 1);
                cs[i] = '0';
                cs[i - 1] += 1;
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
