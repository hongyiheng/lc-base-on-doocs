# [2843. 统计对称整数的数目](https://leetcode-cn.com/problems/count-symmetric-integers)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个正整数 <code>low</code> 和 <code>high</code> 。</p>

<p>对于一个由 <code>2 * n</code> 位数字组成的整数 <code>x</code> ，如果其前 <code>n</code> 位数字之和与后 <code>n</code> 位数字之和相等，则认为这个数字是一个对称整数。</p>

<p>返回在 <code>[low, high]</code> 范围内的 <strong>对称整数的数目</strong> 。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>low = 1, high = 100
<strong>输出：</strong>9
<strong>解释：</strong>在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>low = 1200, high = 1230
<strong>输出：</strong>4
<strong>解释：</strong>在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= low &lt;= high &lt;= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        ans = 0
        for i in range(low, high + 1):
            s = str(i)
            n = len(s)
            if n % 2:
                continue
            a = b = 0
            for j in range(n // 2):
                a += int(s[j])
                b += int(s[j + n // 2])
            if a == b:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i < high + 1; i++) {
            char[] cs = String.valueOf(i).toCharArray();
            int n = cs.length;
            if (n % 2 != 0) {
                continue;
            }
            int a = 0, b = 0;
            for (int j = 0; j < n / 2; j++) {
                a += cs[j] - '0';
                b += cs[j + n / 2] - '0';
            }
            if (a == b) {
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
