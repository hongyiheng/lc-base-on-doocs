# [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非空且只包含非负数的整数数组 <code>nums</code>，数组的度的定义是指数组里任一元素出现频数的最大值。</p>

<p>你的任务是在 <code>nums</code> 中找到与 <code>nums</code> 拥有相同大小的度的最短连续子数组，返回其长度。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[1, 2, 2, 3, 1]
<strong>输出：</strong>2
<strong>解释：</strong>
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[1,2,2,3,1,4,2]
<strong>输出：</strong>6
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums.length</code> 在1到 50,000 区间范围内。</li>
	<li><code>nums[i]</code> 是一个在 0 到 49,999 范围内的整数。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        mp = defaultdict(int)
        for v in nums:
            mp[v] += 1
        mx = 0
        s = set()
        for k in mp.keys():
            if mp[k] > mx:
                s.clear()
                mx = mp[k]
            if mp[k] == mx:
                s.add(k)
        mp = dict()
        for i, v in enumerate(nums):
            if v in s:
                l, r = mp.get(v, [0x3f3f3f, 0])
                l = min(l, i)
                r = max(r, i)
                mp[v] = [l, r]
        ans = float('inf')
        for l, r in mp.values():
            ans = min(r - l + 1, ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int mx = 0;
        Set<Integer> s = new HashSet<>();
        for (var e : mp.entrySet()) {
            if (e.getValue() > mx) {
                mx = e.getValue();
                s.clear();
            }
            if (e.getValue() == mx) {
                s.add(e.getKey());
            }
        }
        Map<Integer, int[]> idxs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                int[] idx = idxs.getOrDefault(nums[i], new int[]{0x3f3f3f, 0});
                idx[0] = Math.min(idx[0], i);
                idx[1] = Math.max(idx[1], i);
                idxs.put(nums[i], idx);
            }
        }
        int ans = 0x3f3f3f;
        for (int[] idx : idxs.values()) {
            ans = Math.min(ans, idx[1] - idx[0] + 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
