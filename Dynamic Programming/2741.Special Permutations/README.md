# [2741. 特别的排列](https://leetcode-cn.com/problems/special-permutations)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;，它包含 <code>n</code>&nbsp;个 <strong>互不相同</strong>&nbsp;的正整数。如果&nbsp;<code>nums</code>&nbsp;的一个排列满足以下条件，我们称它是一个特别的排列：</p>

<ul>
	<li>对于&nbsp;<code>0 &lt;= i &lt; n - 1</code>&nbsp;的下标 <code>i</code>&nbsp;，要么&nbsp;<code>nums[i] % nums[i+1] == 0</code>&nbsp;，要么&nbsp;<code>nums[i+1] % nums[i] == 0</code>&nbsp;。</li>
</ul>

<p>请你返回特别排列的总数目，由于答案可能很大，请将它对<strong>&nbsp;</strong><code>10<sup>9&nbsp;</sup>+ 7</code>&nbsp;<strong>取余</strong>&nbsp;后返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [2,3,6]
<b>输出：</b>2
<b>解释：</b>[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [1,4,3]
<b>输出：</b>2
<b>解释：</b>[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 14</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        @cache
        def dfs(use, pre):
            nonlocal n, mod
            if use == (1 << n) - 1:
                return 1
            ans = 0
            for i, v in enumerate(nums):
                if use >> i & 1 == 0 and (pre % v == 0 or v % pre == 0):
                    ans += dfs(use | 1 << i, v)
            return ans % mod
        
        n = len(nums)
        mod = int(1e9 + 7)
        return sum(dfs(1 << i, v) for i, v in enumerate(nums)) % mod
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int mod = (int) 1e9 + 7;
    int n;
    int[] nums;
    Map<String, Integer> f = new HashMap<>();

    public int dfs(int use, int pre) {
        String key = use + ":" + pre;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (use == (1 << n) - 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((use >> i & 1) == 0 && (pre % nums[i] == 0 || nums[i] % pre == 0)) {
                ans = (ans + dfs(use | (1 << i), nums[i])) % mod;
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int specialPerm(int[] nums) {
        n = nums.length;
        this.nums = nums;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(1 << i, nums[i])) % mod;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
