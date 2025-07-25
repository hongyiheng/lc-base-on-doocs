# [2200. 找出数组中的所有 K 近邻下标](https://leetcode-cn.com/problems/find-all-k-distant-indices-in-an-array)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和两个整数 <code>key</code> 和 <code>k</code> 。<strong>K 近邻下标</strong> 是 <code>nums</code> 中的一个下标 <code>i</code> ，并满足至少存在一个下标 <code>j</code> 使得 <code>|i - j| &lt;= k</code> 且 <code>nums[j] == key</code> 。</p>

<p>以列表形式返回按 <strong>递增顺序</strong> 排序的所有 K 近邻下标。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,4,9,1,3,9,5], key = 9, k = 1
<strong>输出：</strong>[1,2,3,4,5,6]
<strong>解释：</strong>因此，<code>nums[2] == key</code> 且 <code>nums[5] == key 。
- 对下标 0 ，|0 - 2| &gt; k 且 |0 - 5| &gt; k ，所以不存在 j</code> 使得 <code>|0 - j| &lt;= k</code> 且 <code>nums[j] == key 。所以 0 不是一个 K 近邻下标。
- 对下标 1 ，|1 - 2| &lt;= k 且 nums[2] == key ，所以 1 是一个 K 近邻下标。
- 对下标 2 ，|2 - 2| &lt;= k 且 nums[2] == key ，所以 2 是一个 K 近邻下标。
- 对下标 3 ，|3 - 2| &lt;= k 且 nums[2] == key ，所以 3 是一个 K 近邻下标。
- 对下标 4 ，|4 - 5| &lt;= k 且 nums[5] == key ，所以 4 是一个 K 近邻下标。
- 对下标 5 ，|5 - 5| &lt;= k 且 nums[5] == key ，所以 5 是一个 K 近邻下标。
- 对下标 6 ，|6 - 5| &lt;= k 且 nums[5] == key ，所以 6 是一个 K 近邻下标。
</code>因此，按递增顺序返回 [1,2,3,4,5,6] 。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2,2,2], key = 2, k = 2
<strong>输出：</strong>[0,1,2,3,4]
<strong>解释：</strong>对 nums 的所有下标 i ，总存在某个下标 j 使得 |i - j| &lt;= k 且 nums[j] == key ，所以每个下标都是一个 <code>K 近邻下标。</code> 
因此，返回 [0,1,2,3,4] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>key</code> 是数组 <code>nums</code> 中的一个整数</li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        ans = set()
        for i, v in enumerate(nums):
            if v != key:
                continue
            for j in range(max(0, i - k), min(len(nums), i + k + 1)):
                ans.add(j)
        return list(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != key) {
                continue;
            }
            for (int j = Math.max(0, i - k); j < Math.min(n, i + k + 1); j++) {
                s.add(j);
            }
        }
        List<Integer> ans = new ArrayList<>(s);
        Collections.sort(ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
