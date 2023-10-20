# [2537. 统计好子数组的数目](https://leetcode-cn.com/problems/count-the-number-of-good-subarrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>&nbsp;和一个整数 <code>k</code>&nbsp;，请你返回 <code>nums</code>&nbsp;中 <strong>好</strong>&nbsp;子数组的数目。</p>

<p>一个子数组 <code>arr</code>&nbsp;如果有 <strong>至少</strong>&nbsp;<code>k</code>&nbsp;对下标 <code>(i, j)</code>&nbsp;满足 <code>i &lt; j</code>&nbsp;且 <code>arr[i] == arr[j]</code>&nbsp;，那么称它是一个 <strong>好</strong>&nbsp;子数组。</p>

<p><strong>子数组</strong>&nbsp;是原数组中一段连续 <strong>非空</strong>&nbsp;的元素序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,1,1,1,1], k = 10
<b>输出：</b>1
<b>解释：</b>唯一的好子数组是这个数组本身。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [3,1,4,3,2,2,4], k = 2
<b>输出：</b>4
<b>解释：</b>总共有 4 个不同的好子数组：
- [3,1,4,3,2,2] 有 2 对。
- [3,1,4,3,2,2,4] 有 3 对。
- [1,4,3,2,2,4] 有 2 对。
- [4,3,2,2,4] 有 2 对。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i], k &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        g = defaultdict(int)
        ans = cur = 0
        l, r, n = 0, 0, len(nums)
        while r < n:
            cur += g[nums[r]]
            g[nums[r]] += 1
            while cur >= k:
                ans += (n - r)
                cur -= (g[nums[l]] - 1)
                g[nums[l]] -= 1
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> g = new HashMap<>();
        long ans = 0, cur = 0;
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            cur += g.getOrDefault(nums[r], 0);
            g.put(nums[r], g.getOrDefault(nums[r], 0) + 1);
            while (cur >= k) {
                ans += n - r;
                cur -= (g.get(nums[l]) - 1);
                g.put(nums[l], g.get(nums[l]) - 1);
                l++;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
