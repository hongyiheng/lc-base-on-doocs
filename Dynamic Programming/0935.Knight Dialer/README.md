# [935. 骑士拨号器](https://leetcode-cn.com/problems/knight-dialer)



## 题目描述

<!-- 这里写题目描述 -->

<p>国际象棋中的骑士可以按下图所示进行移动：</p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/11/03/knight.png" style="height: 150px; width: 150px;">&nbsp;.&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/11/03/keypad.png" style="height: 150px; width: 134px;"></p>

<p><br>
这一次，我们将&nbsp;&ldquo;骑士&rdquo; 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳&nbsp;N-1 步。每一步必须是从一个数字键跳到另一个数字键。</p>

<p>每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下&nbsp;<code>N</code> 位数字。</p>

<p>你能用这种方式拨出多少个不同的号码？</p>

<p>因为答案可能很大，<strong>所以输出答案模&nbsp;<code>10^9 + 7</code></strong>。</p>

<p>&nbsp;</p>

<ul>
</ul>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>1
<strong>输出：</strong>10
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>2
<strong>输出：</strong>20
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>3
<strong>输出：</strong>46
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= N &lt;= 5000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def knightDialer(self, n: int) -> int:
        f = [[0] * 10 for _ in range(n + 1)]
        f[1] = [1] * 10
        for i in range(2, n + 1):
            f[i][0] = f[i - 1][4] + f[i - 1][6]
            f[i][1] = f[i - 1][8] + f[i - 1][6]
            f[i][2] = f[i - 1][7] + f[i - 1][9]
            f[i][3] = f[i - 1][4] + f[i - 1][8]
            f[i][4] = f[i - 1][0] + f[i - 1][3] + f[i - 1][9]
            f[i][6] = f[i - 1][0] + f[i - 1][1] + f[i - 1][7]
            f[i][7] = f[i - 1][2] + f[i - 1][6]
            f[i][8] = f[i - 1][1] + f[i - 1][3]
            f[i][9] = f[i - 1][4] + f[i - 1][2]
        return sum(f[n]) % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int knightDialer(int n) {
        int mod = (int)1e9 + 7;
        long[][] f = new long[n + 1][10];
        Arrays.fill(f[1], 1);
        for (int i = 2; i < n + 1; i++) {
            f[i][0] = (f[i - 1][4] + f[i - 1][6]) % mod;
            f[i][1] = (f[i - 1][8] + f[i - 1][6]) % mod;
            f[i][2] = (f[i - 1][7] + f[i - 1][9]) % mod;
            f[i][3] = (f[i - 1][4] + f[i - 1][8]) % mod;
            f[i][4] = (f[i - 1][0] + f[i - 1][3] + f[i - 1][9]) % mod;
            f[i][6] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][7]) % mod;
            f[i][7] = (f[i - 1][2] + f[i - 1][6]) % mod;
            f[i][8] = (f[i - 1][1] + f[i - 1][3]) % mod;
            f[i][9] = (f[i - 1][4] + f[i - 1][2]) % mod;
        }
        long ans = 0;
        for (long v : f[n]) {
            ans = (ans + v) % mod;
        }
        return (int)(ans % mod);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
