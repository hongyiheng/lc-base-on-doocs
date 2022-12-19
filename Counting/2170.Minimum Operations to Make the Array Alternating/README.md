# [2170. 使数组变成交替数组的最少操作数](https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-alternating)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，该数组由 <code>n</code> 个正整数组成。</p>

<p>如果满足下述条件，则数组 <code>nums</code> 是一个 <strong>交替数组</strong> ：</p>

<ul>
	<li><code>nums[i - 2] == nums[i]</code> ，其中 <code>2 &lt;= i &lt;= n - 1</code> 。</li>
	<li><code>nums[i - 1] != nums[i]</code> ，其中 <code>1 &lt;= i &lt;= n - 1</code> 。</li>
</ul>

<p>在一步 <strong>操作</strong> 中，你可以选择下标 <code>i</code> 并将 <code>nums[i]</code> <strong>更改</strong> 为 <strong>任一</strong> 正整数。</p>

<p>返回使数组变成交替数组的 <strong>最少操作数</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,1,3,2,4,3]
<strong>输出：</strong>3
<strong>解释：</strong>
使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,<em><strong>1</strong></em>,<em><strong>3</strong></em>,<em><strong>1</strong></em>] 。
在这种情况下，操作数为 3 。
可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,2,2,2]
<strong>输出：</strong>2
<strong>解释：</strong>
使数组变成交替数组的方法之一是将该数组转换为 [1,2,<em><strong>1</strong></em>,2,<em><strong>1</strong></em>].
在这种情况下，操作数为 2 。
注意，数组不能转换成 [<em><strong>2</strong></em>,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        def get_mx_cnt(id, x):
            nonlocal n
            mp = defaultdict(int)
            for i in range(id, n, 2):
                mp[nums[i]] += 1
            mx = cnt = 0
            for k in mp.keys():
                if k != x and mp[k] > cnt:
                    mx = k
                    cnt = mp[k]
            return [mx, cnt]
        
        n = len(nums)
        a, a_cnt = get_mx_cnt(0, -1)
        b, b_cnt = get_mx_cnt(1, a)
        c, c_cnt = get_mx_cnt(1, -1)
        d, d_cnt = get_mx_cnt(0, c)
        return n - max(a_cnt + b_cnt, c_cnt + d_cnt)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int[] a = getMaxCnt(nums, 0, -1);
        int[] b = getMaxCnt(nums, 1, a[0]);
        int[] c = getMaxCnt(nums, 1, -1);
        int[] d = getMaxCnt(nums, 0, c[0]);
        return nums.length - Math.max(a[1] + b[1], c[1] + d[1]);
    }

    public int[] getMaxCnt(int[] nums, int idx, int x) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        for (int i = idx; i < nums.length; i += 2) {
            if (nums[i] == x) {
                continue;
            }
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if (mp.get(nums[i]) > ans[1]) {
                ans[1] = mp.get(nums[i]);
                ans[0] = nums[i];
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
