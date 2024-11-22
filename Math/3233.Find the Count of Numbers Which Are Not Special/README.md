# [3233. 统计不是特殊数字的数字数量](https://leetcode.cn/problems/find-the-count-of-numbers-which-are-not-special)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个<strong> 正整数 </strong><code>l</code> 和 <code>r</code>。对于任何数字 <code>x</code>，<code>x</code> 的所有正因数（除了 <code>x</code> 本身）被称为 <code>x</code> 的 <strong>真因数</strong>。</p>

<p><span class="text-only" data-eleid="13" style="white-space: pre;">如果一个数字恰好仅有两个</span> <strong>真因数</strong>，则称该数字为 <strong>特殊数字</strong>。例如：</p>

<ul>
	<li>数字 4 是<strong> 特殊数字</strong>，因为它的真因数为 1 和 2。</li>
	<li>数字 6 不是 <strong>特殊数字</strong>，因为它的真因数为 1、2 和 3。</li>
</ul>

<p>返回区间 <code>[l, r]</code> 内<strong> 不是 特殊数字 </strong>的数字数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">l = 5, r = 7</span></p>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p>区间 <code>[5, 7]</code> 内不存在特殊数字。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">l = 4, r = 16</span></p>

<p><strong>输出：</strong> <span class="reset-io">11</span></p>

<p><strong>解释：</strong></p>

<p>区间 <code>[4, 16]</code> 内的特殊数字为 4 和 9。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= l &lt;= r &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        def get_primes():
            n = 34000
            primes = [False] * n
            for i in range(2, n):
                if not primes[i]:
                    for j in range(i * i, n, i):
                        primes[j] = True
            primes[1] = True
            return primes
    
        primes = get_primes()
        ans = r - l + 1
        for i in range(int(math.sqrt(l)), int(math.sqrt(r)) + 1):
            if l <= i * i <= r and not primes[i]:
                print(i)
                ans -= 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    private boolean[] getPrimes() {
        int n = 34000;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        primes[1] = true;
        return primes;
    } 

    public int nonSpecialCount(int l, int r) {
        int ans = r - l + 1;
        boolean[] primes = getPrimes();
        for (int i = (int)Math.sqrt(l); i < (int)Math.sqrt(r) + 1; i++) {
            if (l <= i * i && i * i <= r && !primes[i]) {
                ans--;
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
