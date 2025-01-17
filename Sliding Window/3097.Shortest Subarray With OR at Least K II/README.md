# [3097. 或值至少为 K 的最短子数组 II](https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>非负</strong>&nbsp;整数数组&nbsp;<code>nums</code>&nbsp;和一个整数&nbsp;<code>k</code>&nbsp;。</p>

<p>如果一个数组中所有元素的按位或运算 <code>OR</code>&nbsp;的值 <strong>至少</strong>&nbsp;为 <code>k</code>&nbsp;，那么我们称这个数组是 <strong>特别的</strong>&nbsp;。</p>

<p>请你返回&nbsp;<code>nums</code>&nbsp;中&nbsp;<strong>最短特别非空</strong>&nbsp;<span data-keyword="subarray-nonempty">子数组</span>的长度，如果特别子数组不存在，那么返回 <code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,2,3], k = 2</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><strong>解释：</strong></p>

<p>子数组&nbsp;<code>[3]</code>&nbsp;的按位&nbsp;<code>OR</code> 值为&nbsp;<code>3</code>&nbsp;，所以我们返回 <code>1</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [2,1,8], k = 10</span></p>

<p><span class="example-io"><b>输出：</b>3</span></p>

<p><strong>解释：</strong></p>

<p>子数组&nbsp;<code>[2,1,8]</code> 的按位&nbsp;<code>OR</code>&nbsp;值为 <code>11</code>&nbsp;，所以我们返回 <code>3</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,2], k = 0</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><b>解释：</b></p>

<p>子数组&nbsp;<code>[1]</code>&nbsp;的按位&nbsp;<code>OR</code>&nbsp;值为&nbsp;<code>1</code>&nbsp;，所以我们返回&nbsp;<code>1</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup><font size="1">9</font></sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        def getVal():
            ans = 0
            for i in range(31):
                if s[i]:
                    ans |= 1 << i
            return ans

        if k == 0:
            return 1
        n = len(nums)
        l = r = 0
        s = [0] * 32
        ans = n + 1
        while r < n:
            for i in range(31):
                if nums[r] >> i & 1:
                    s[i] += 1
            while getVal() >= k:
                ans = min(ans, r - l + 1)
                for i in range(31):
                    if nums[l] >> i & 1:
                        s[i] -= 1
                l += 1
            r += 1
        return -1 if ans > n else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int getVal(int[] s) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (s[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int n = nums.length;
        int l = 0, r = 0, ans = n + 1;
        int[] s = new int[32];
        while (r < n) {
            for (int i = 0; i < 31; i++) {
                if ((nums[r] >> i & 1) == 1) {
                    s[i]++;
                }
            }
            while (getVal(s) >= k) {
                ans = Math.min(ans, r - l + 1);
                for (int i = 0; i < 31; i++) {
                    if ((nums[l] >> i & 1) == 1) {
                        s[i]--;
                    }
                }  
                l++;
            }
            r++;
        }
        return ans > n ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
