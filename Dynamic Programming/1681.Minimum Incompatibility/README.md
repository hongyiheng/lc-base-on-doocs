# [1681. 最小不兼容性](https://leetcode-cn.com/problems/minimum-incompatibility)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>​​​ 和一个整数 <code>k</code> 。你需要将这个数组划分到 <code>k</code> 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。</p>

<p>一个子集的 <strong>不兼容性</strong> 是该子集里面最大值和最小值的差。</p>

<p>请你返回将数组分成 <code>k</code> 个子集后，各子集 <strong>不兼容性 </strong>的<strong> 和</strong> 的 <strong>最小值</strong> ，如果无法分成分成 <code>k</code> 个子集，返回 <code>-1</code> 。</p>

<p>子集的定义是数组中一些数字的集合，对数字顺序没有要求。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,2,1,4], k = 2
<b>输出：</b>4
<b>解释：</b>最优的分配是 [1,2] 和 [1,4] 。
不兼容性和为 (2-1) + (4-1) = 4 。
注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [6,3,8,1,3,1,2,2], k = 4
<b>输出：</b>6
<b>解释：</b>最优的子集分配为 [1,2]，[2,3]，[6,8] 和 [1,3] 。
不兼容性和为 (2-1) + (3-2) + (8-6) + (3-1) = 6 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>nums = [5,3,3,6,3,3], k = 3
<b>输出：</b>-1
<b>解释：</b>没办法将这些数字分配到 3 个子集且满足每个子集里没有相同数字。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= k <= nums.length <= 16</code></li>
	<li><code>nums.length</code> 能被 <code>k</code> 整除。</li>
	<li><code>1 <= nums[i] <= nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumIncompatibility(self, nums: List[int], k: int) -> int:
        def get_next(mask):
            for i in range(n):
                if mask >> i & 1 == 0:
                    return i

        @cache
        def dfs(mask, idx):
            if mask == (1 << n) - 1:
                return 0
            if mask.bit_count() % t == 0:
                i = get_next(mask)
                return dfs(mask | 1 << i, i)
            ans = inf
            last = nums[idx]
            for i in range(idx + 1, n):
                if nums[i] == last or mask >> i & 1:
                    continue
                last = nums[i]
                ans = min(ans, last - nums[idx] + dfs(mask | 1 << i, i))
            return ans

        cnt = Counter(nums)
        if max(cnt.values()) > k:
            return -1
        n = len(nums)
        t = n // k
        nums.sort()
        return dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n;
    int t;
    int[] nums;
    int[][] f;

    public int getNext(int mask) {
        for (int i = 0; i < n; i++) {
            if ((mask >> i & 1) == 0) {
                return i;
            }
        }
        return 0;
    }

    public int dfs(int mask, int idx) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (f[mask][idx] != -1) {
            return f[mask][idx];
        }
        if (Integer.bitCount(mask) % t == 0) {
            int i = getNext(mask);
            return dfs(mask | 1 << i, i);
        }
        int ans = 0x3f3f3f3f;
        int last = nums[idx];
        for (int i = idx + 1; i < n; i++) {
            if ((mask >> i & 1) != 0 || nums[i] == last) {
                continue;
            }
            last = nums[i];
            ans = Math.min(ans, last - nums[idx] + dfs(mask | 1 << i, i));
        }
        f[mask][idx] = ans;
        return ans;
    }

    public int minimumIncompatibility(int[] nums, int k) {
        n = nums.length;
        int[] cnt = new int[n + 1];
        for (int v : nums) {
            if (++cnt[v] > k) {
                return -1;
            }
        }
        Arrays.sort(nums);
        this.nums = nums;
        t = n / k;
        f = new int[1 << n][n];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
