# [2831. 找出最长等值子数组](https://leetcode-cn.com/problems/find-the-longest-equal-subarray)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和一个整数 <code>k</code> 。</p>

<p>如果子数组中所有元素都相等，则认为子数组是一个 <strong>等值子数组</strong> 。注意，空数组是 <strong>等值子数组</strong> 。</p>

<p>从 <code>nums</code> 中删除最多 <code>k</code> 个元素后，返回可能的最长等值子数组的长度。</p>

<p><strong>子数组</strong> 是数组中一个连续且可能为空的元素序列。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,2,3,1,3], k = 3
<strong>输出：</strong>3
<strong>解释：</strong>最优的方案是删除下标 2 和下标 4 的元素。
删除后，nums 等于 [1, 3, 3, 3] 。
最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
可以证明无法创建更长的等值子数组。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,2,2,1,1], k = 2
<strong>输出：</strong>4
<strong>解释：</strong>最优的方案是删除下标 2 和下标 3 的元素。 
删除后，nums 等于 [1, 1, 1, 1] 。 
数组自身就是等值子数组，长度等于 4 。 
可以证明无法创建更长的等值子数组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        def get_mx():
            while rk and -rk[0][0] != cnt[rk[0][1]]:
                heapq.heappop(rk)
            return -rk[0][0]

        rk = []
        cnt = defaultdict(int)
        l = -1
        ans = 0
        for i, v in enumerate(nums):
            cnt[v] += 1
            heapq.heappush(rk, (-cnt[v], v))
            while i - l - get_mx() > k:
                l += 1
                cnt[nums[l]] -= 1     
            ans = max(ans, get_mx())
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getMx(PriorityQueue<int[]> rk, Map<Integer, Integer> cnt) {
        while (!rk.isEmpty() && cnt.get(rk.peek()[1]) != rk.peek()[0]) {
            rk.poll();
        }
        return rk.peek()[0];
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        PriorityQueue<int[]> rk = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = -1, ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int v = nums.get(i);
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            rk.add(new int[]{cnt.get(v), v});
            while (i - l - getMx(rk, cnt) > k) {
                cnt.put(nums.get(++l), cnt.get(nums.get(l)) - 1);
            }
            ans = Math.max(ans, getMx(rk, cnt));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
