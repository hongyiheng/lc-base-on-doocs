# [3115. 质数的最大距离](https://leetcode.cn/problems/maximum-prime-difference)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>。</p>

<p>返回两个（不一定不同的）质数在 <code>nums</code> 中&nbsp;<strong>下标</strong> 的 <strong>最大距离</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [4,2,9,5,3]</span></p>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong> <code>nums[1]</code>、<code>nums[3]</code> 和 <code>nums[4]</code> 是质数。因此答案是 <code>|4 - 1| = 3</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [4,8,2,8]</span></p>

<p><strong>输出：</strong> <span class="example-io">0</span></p>

<p><strong>解释：</strong> <code>nums[2]</code> 是质数。因为只有一个质数，所以答案是 <code>|2 - 2| = 0</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li>输入保证 <code>nums</code> 中至少有一个质数。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        def get_primes(n):
            primes = [False] * n
            for i in range(2, n):
                if primes[i]:
                    continue
                for j in range(i * i, n, i):
                    primes[j] = True
            primes[0] = primes[1] = True
            return primes

        primes = get_primes(110)
        n = len(nums)
        l, r = 0, n - 1
        while l < n:
            if not primes[nums[l]]:
                break
            l += 1
        while r > 0:
            if not primes[nums[r]]:
                break
            r -= 1
        return r - l
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
public int maximumPrimeDifference(int[] nums) {
        boolean[] primes = getPrimes(110);
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < n && primes[nums[l]]) {
            l++;
        }
        while (r >= 0 && primes[nums[r]]) {
            r--;
        }
        return r - l;
    }
    
    private boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, false);
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        primes[0] = primes[1] = true; 
        return primes;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
