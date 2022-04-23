# [560. 和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组和一个整数&nbsp;<strong>k，</strong>你需要找到该数组中和为&nbsp;<strong>k&nbsp;</strong>的连续的子数组的个数。</p>

<p><strong>示例 1 :</strong></p>

<pre>
<strong>输入:</strong>nums = [1,1,1], k = 2
<strong>输出:</strong> 2 , [1,1] 与 [1,1] 为两种不同的情况。
</pre>

<p><strong>说明 :</strong></p>

<ol>
	<li>数组的长度为 [1, 20,000]。</li>
	<li>数组中元素的范围是 [-1000, 1000] ，且整数&nbsp;<strong>k&nbsp;</strong>的范围是&nbsp;[-1e7, 1e7]。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n, cur, ans = len(nums), 0, 0
        mp = dict()
        mp[0] = 1
        for v in nums:
            cur += v
            if (cur - k) in mp:
                ans += mp[cur - k]
            mp[cur] = mp.get(cur, 0) + 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cur = 0, n = nums.length, ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            if (mp.containsKey(cur - k)) {
                ans += mp.get(cur - k);
            }
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
