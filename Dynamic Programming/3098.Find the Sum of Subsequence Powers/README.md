# [3098. 求出所有子序列的能量和](https://leetcode.cn/problems/find-the-sum-of-subsequence-powers)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;和一个 <strong>正</strong>&nbsp;整数&nbsp;<code>k</code>&nbsp;。</p>

<p>一个子序列的 <strong>能量</strong>&nbsp;定义为子序列中&nbsp;<strong>任意</strong>&nbsp;两个元素的差值绝对值的 <strong>最小值</strong>&nbsp;。</p>

<p>请你返回 <code>nums</code>&nbsp;中长度 <strong>等于</strong>&nbsp;<code>k</code>&nbsp;的 <strong>所有</strong>&nbsp;子序列的 <strong>能量和</strong>&nbsp;。</p>

<p>由于答案可能会很大，将答案对&nbsp;<code>10<sup>9 </sup>+ 7</code>&nbsp;<strong>取余</strong>&nbsp;后返回。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,2,3,4], k = 3</span></p>

<p><span class="example-io"><b>输出：</b>4</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code>&nbsp;中总共有 4 个长度为 3 的子序列：<code>[1,2,3]</code>&nbsp;，<code>[1,3,4]</code>&nbsp;，<code>[1,2,4]</code>&nbsp;和&nbsp;<code>[2,3,4]</code>&nbsp;。能量和为 <code>|2 - 3| + |3 - 4| + |2 - 1| + |3 - 4| = 4</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [2,2], k = 2</span></p>

<p><span class="example-io"><b>输出：</b>0</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code>&nbsp;中唯一一个长度为 2 的子序列是&nbsp;<code>[2,2]</code>&nbsp;。能量和为&nbsp;<code>|2 - 2| = 0</code>&nbsp;。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [4,3,-1], k = 2</span></p>

<p><span class="example-io"><b>输出：</b>10</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code>&nbsp;总共有 3 个长度为 2 的子序列：<code>[4,3]</code>&nbsp;，<code>[4,-1]</code>&nbsp;和&nbsp;<code>[3,-1]</code>&nbsp;。能量和为&nbsp;<code>|4 - 3| + |4 - (-1)| + |3 - (-1)| = 10</code>&nbsp;。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n == nums.length &lt;= 50</code></li>
	<li><code>-10<sup>8</sup> &lt;= nums[i] &lt;= 10<sup>8</sup> </code></li>
	<li><code>2 &lt;= k &lt;= n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        @cache
        def dfs(i, j, k, mi) -> int:
            if i >= n:
                return mi if k == 0 else 0
            if n - i < k:
                return 0
            ans = dfs(i + 1, j, k, mi)
            if j == n:
                ans += dfs(i + 1, i, k - 1, mi)
            else:
                ans += dfs(i + 1, i, k - 1, min(mi, nums[i] - nums[j]))
            return ans % mod

        mod = int(1e9 + 7)
        n = len(nums)
        nums.sort()
        return dfs(0, n, k, inf)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int n;
    int mod = (int)1e9 + 7;
    int[] nums;
    Map<String, Integer> f = new HashMap<>();

    public int dfs(int i, int j, int t, int mi) {
        if (i == n || t == 0) {
            return t == 0 ? mi : 0;
        }
        if (n - i < t) {
            return 0;
        }
        String key = i + ":" + j + ":" + t + ":" + mi;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = dfs(i + 1, j, t, mi) % mod;
        if (j == -1) {
            ans = (ans + dfs(i + 1, i, t - 1, mi)) % mod;
        } else {
            ans = (ans + dfs(i + 1, i, t - 1, Math.min(mi, Math.abs(nums[i] - nums[j])))) % mod;
        }
        f.put(key, ans);
        return ans;
    }

    public int sumOfPowers(int[] nums, int k) {
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(0, -1, k, Integer.MAX_VALUE);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
