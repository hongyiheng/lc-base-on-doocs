# [2429. 最小 XOR](https://leetcode-cn.com/problems/minimize-xor)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个正整数 <code>num1</code> 和 <code>num2</code> ，找出满足下述条件的整数 <code>x</code> ：</p>

<ul>
	<li><code>x</code> 的置位数和 <code>num2</code> 相同，且</li>
	<li><code>x XOR num1</code> 的值 <strong>最小</strong></li>
</ul>

<p>注意 <code>XOR</code> 是按位异或运算。</p>

<p>返回整数<em> </em><code>x</code> 。题目保证，对于生成的测试用例， <code>x</code> 是 <strong>唯一确定</strong> 的。</p>

<p>整数的 <strong>置位数</strong> 是其二进制表示中 <code>1</code> 的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>num1 = 3, num2 = 5
<strong>输出：</strong>3
<strong>解释：</strong>
num1 和 num2 的二进制表示分别是 0011 和 0101 。
整数 <strong>3</strong> 的置位数与 num2 相同，且 <code>3 XOR 3 = 0</code> 是最小的。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>num1 = 1, num2 = 12
<strong>输出：</strong>3
<strong>解释：</strong>
num1 和 num2 的二进制表示分别是 0001 和 1100 。
整数 <strong>3</strong> 的置位数与 num2 相同，且 <code>3 XOR 1 = 2</code> 是最小的。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num1, num2 &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        def lowbit(x):
            ans = 0
            while x > 0:
                x -= x & -x
                ans += 1
            return ans

        cnt = [0] * 32
        k = lowbit(num2)
        for i in range(31, -1, -1):
            if (1 << i) & num1:
                cnt[i] = 1
                k -= 1
                if k == 0:
                    break
        ans = 0
        for i in range(31):
            if cnt[i] == 0 and k > 0:
                cnt[i] = 1
                k -= 1
            if cnt[i] == 1:
                ans += (1 << i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimizeXor(int num1, int num2) {
        int k = lowbit(num2);
        int[] cnt = new int[32];
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & num1) != 0 && k > 0) {
                cnt[i] = 1;
                k--;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (k > 0 && cnt[i] == 0) {
                cnt[i] = 1;
                k--;
            }
            if (cnt[i] == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public int lowbit(int x) {
        int ans = 0;
        while (x > 0) {
            x -= x & -x;
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
