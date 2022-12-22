# [1799. N 次操作后的最大分数和](https://leetcode-cn.com/problems/maximize-score-after-n-operations)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你 <code>nums</code> ，它是一个大小为 <code>2 * n</code> 的正整数数组。你必须对这个数组执行 <code>n</code> 次操作。</p>

<p>在第 <code>i</code> 次操作时（操作编号从 <strong>1</strong> 开始），你需要：</p>

<ul>
	<li>选择两个元素 <code>x</code> 和 <code>y</code> 。</li>
	<li>获得分数 <code>i * gcd(x, y)</code> 。</li>
	<li>将 <code>x</code> 和 <code>y</code> 从 <code>nums</code> 中删除。</li>
</ul>

<p>请你返回 <code>n</code> 次操作后你能获得的分数和最大为多少。</p>

<p>函数 <code>gcd(x, y)</code> 是 <code>x</code> 和 <code>y</code> 的最大公约数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,2]
<b>输出：</b>1
<b>解释：</b>最优操作是：
(1 * gcd(1, 2)) = 1
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [3,4,6,8]
<b>输出：</b>11
<b>解释：</b>最优操作是：
(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [1,2,3,4,5,6]
<b>输出：</b>14
<b>解释：</b>最优操作是：
(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 7</code></li>
	<li><code>nums.length == 2 * n</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxScore(self, nums: List[int]) -> int:
        @cache
        def gcd(a, b):
            if b != 0:
                return gcd(b, a % b)
            return a
        
        def get_cnt(x):
            ans = 0
            while x:
                x -= x & -x
                ans += 1
            return ans
        
        n = len(nums)
        f = [0] * (1 << n)
        ans = 0
        for k in range(1 << n):
            cnt = get_cnt(k)
            if cnt % 2 != 0:
                continue
            for i in range(n):
                if k & (1 << i) == 0:
                    continue
                for j in range(i + 1, n):
                    if k & (1 << j) == 0:
                        continue
                    f[k] = max(f[k], f[k ^ (1 << i) ^ (1 << j)] + cnt // 2 * gcd(nums[i], nums[j]))
                    ans = max(f[k], ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] f = new int[1 << n];
        int ans = 0;
        for (int k = 0; k < (1 << n); k++) {
            int cnt = getCnt(k);
            if (cnt % 2 != 0) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((k & (1 << i)) == 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if ((k & (1 << j)) == 0) {
                        continue;
                    }
                    f[k] = Math.max(f[k], f[(k ^ (1 << i) ^ (1 << j))] + cnt / 2 * gcd(nums[i], nums[j]));
                    ans = Math.max(ans, f[k]);
                }
            }
        }
        return ans;
    }

    public int getCnt(int x) {
        int ans = 0;
        while (x != 0) {
            x -= x & -x;
            ans++;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        return a;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
