# [2601. 质数减法运算](https://leetcode-cn.com/problems/prime-subtraction-operation)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> ，数组长度为 <code>n</code> 。</p>

<p>你可以执行无限次下述运算：</p>

<ul>
	<li>选择一个之前未选过的下标 <code>i</code> ，并选择一个 <strong>严格小于</strong> <code>nums[i]</code> 的质数 <code>p</code> ，从 <code>nums[i]</code> 中减去 <code>p</code> 。</li>
</ul>

<p>如果你能通过上述运算使得 <code>nums</code> 成为严格递增数组，则返回 <code>true</code> ；否则返回 <code>false</code> 。</p>

<p><strong>严格递增数组</strong> 中的每个元素都严格大于其前面的元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,9,6,10]
<strong>输出：</strong>true
<strong>解释：</strong>
在第一次运算中：选择 i = 0 和 p = 3 ，然后从 nums[0] 减去 3 ，nums 变为 [1,9,6,10] 。
在第二次运算中：选择 i = 1 和 p = 7 ，然后从 nums[1] 减去 7 ，nums 变为 [1,2,6,10] 。
第二次运算后，nums 按严格递增顺序排序，因此答案为 true 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [6,8,11,12]
<strong>输出：</strong>true
<strong>解释：</strong>nums 从一开始就按严格递增顺序排序，因此不需要执行任何运算。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,8,3]
<strong>输出：</strong>false
<strong>解释：</strong>可以证明，执行运算无法使 nums 按严格递增顺序排序，因此答案是 false 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>nums.length == n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        M = 1010
        primes = [False] * M
        for i in range(2, M):
            if not primes[i]:
                for j in range(i * i, M, i):
                    primes[j] = True
        q = []
        for i in range(2, M):
            if not primes[i]:
                q.append(i)

        n = len(nums)
        for i in range(n - 2, -1, -1):
            if nums[i] >= nums[i + 1]:
                t = nums[i] - nums[i + 1]
                l, r = 0, len(q) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if q[mid] <= t:
                        l = mid + 1
                    else:
                        r = mid
                if q[l] > t and q[l] < nums[i]:
                    nums[i] -= q[l]
                else:
                    return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int M = 1010;
        boolean[] primes = new boolean[M];
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < M; j += i) {
                    primes[j] = true;
                }
            }
        }
        List<Integer> q = new ArrayList<>();
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                q.add(i);
            }
        }
        int n = nums.length;
        for (int i = n - 2; i > -1; i--) {
            if (nums[i] >= nums[i + 1]) {
                int t = nums[i] - nums[i + 1];
                int l = 0, r = q.size();
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (q.get(mid) <= t) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (q.get(l) > t && q.get(l) < nums[i]) {
                    nums[i] -= q.get(l);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
