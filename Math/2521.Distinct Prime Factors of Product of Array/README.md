# [2521. 数组乘积中的不同质因数数目](https://leetcode-cn.com/problems/distinct-prime-factors-of-product-of-array)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数数组 <code>nums</code> ，对 <code>nums</code> 所有元素求积之后，找出并返回乘积中 <strong>不同质因数</strong> 的数目。</p>

<p><strong>注意：</strong></p>

<ul>
	<li><strong>质数</strong> 是指大于 <code>1</code> 且仅能被 <code>1</code> 及自身整除的数字。</li>
	<li>如果 <code>val2 / val1</code> 是一个整数，则整数 <code>val1</code> 是另一个整数 <code>val2</code> 的一个因数。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [2,4,3,7,10,6]
<strong>输出：</strong>4
<strong>解释：</strong>
nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 2<sup>5</sup> * 3<sup>2</sup> * 5 * 7 。
共有 4 个不同的质因数，所以返回 4 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [2,4,8,16]
<strong>输出：</strong>1
<strong>解释：</strong>
nums 中所有元素的乘积是：2 * 4 * 8 * 16 = 1024 = 2<sup>10</sup> 。
共有 1 个不同的质因数，所以返回 1 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>2 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        M = 1010
        primes = [False] * M
        for i in range(2, M):
            if not primes[i]:
                for j in range(i * i, M, i):
                    primes[j] = True
        ans = set()
        for v in nums:
            for i in range(2, M):
                if i > v:
                    break
                if not primes[i] and v % i == 0:
                    ans.add(i)
                    while v % i == 0:
                        v //= i
            if v > 1:
                ans.add(v)
        return len(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int M = 1010;
        boolean[] primes = new boolean[M];
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < M; j += i) {
                    primes[j] = true;
                }
            }
        }
        Set<Integer> ans = new HashSet<>();
        for (int v : nums) {
            for (int i = 2; i < M; i++) {
                if (i > v) {
                    break;
                }
                if (!primes[i] && v % i == 0) {
                    ans.add(i);
                    while (v % i == 0) {
                        v /= i;
                    }
                }
            }
            if (v > 1) {
                ans.add(v);
            }
        }
        return ans.size();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
