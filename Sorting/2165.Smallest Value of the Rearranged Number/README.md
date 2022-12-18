# [2165. 重排数字的最小值](https://leetcode-cn.com/problems/smallest-value-of-the-rearranged-number)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数 <code>num</code> 。<strong>重排</strong> <code>num</code> 中的各位数字，使其值 <strong>最小化</strong> 且不含 <strong>任何</strong> 前导零。</p>

<p>返回不含前导零且值最小的重排数字。</p>

<p>注意，重排各位数字后，<code>num</code> 的符号不会改变。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>num = 310
<strong>输出：</strong>103
<strong>解释：</strong>310 中各位数字的可行排列有：013、031、103、130、301、310 。
不含任何前导零且值最小的重排数字是 103 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>num = -7605
<strong>输出：</strong>-7650
<strong>解释：</strong>-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
不含任何前导零且值最小的重排数字是 -7650 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-10<sup>15</sup> &lt;= num &lt;= 10<sup>15</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestNumber(self, num: int) -> int:
        s = str(num)
        ne = False
        if s[0] == '-':
            ne = True
            s = s[1:]
        cnt = [0] * 10
        for v in s:
            cnt[ord(v) - ord('0')] += 1
        ans = 0
        if ne:
            for i in range(9, -1, -1):
                while cnt[i]:
                    ans = ans * 10 + i
                    cnt[i] -= 1
        else:
            for i in range(1, 10):
                if cnt[i]:
                    ans = i
                    cnt[i] -= 1
                    break
            for i in range(10):
                while cnt[i]:
                    ans = ans * 10 + i
                    cnt[i] -= 1
        return -ans if ne else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long smallestNumber(long num) {
        String s = String.valueOf(num);
        boolean ne = false;
        if (num < 0) {
            ne = true;
            s = s.substring(1);
        }
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        long ans = 0;
        if (ne) {
            for (int i = 9; i >= 0; i--) {
                while (cnt[i]-- > 0) {
                    ans = ans * 10 + i;
                }         
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if (cnt[i]-- > 0) {
                    ans = i;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (cnt[i]-- > 0) {
                    ans = ans * 10 + i;
                }
            }
        }
        return ne ? -ans : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
