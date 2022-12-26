# [525. 连续数组](https://leetcode-cn.com/problems/contiguous-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1,0]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mp = dict()
        mp[0] = -1
        cur = ans = 0
        for i, v in enumerate(nums):
            if v == 1:
                cur += 1
            else:
                cur -= 1
            if cur in mp:
                ans = max(ans, i - mp[cur])
            else:
                mp[cur] = i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMaxLength(int[] nums) {
        int cur = 0, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                cur--;
            }
            if (mp.containsKey(cur)) {
                ans = Math.max(ans, i - mp.get(cur));
            } else {
                mp.put(cur, i);
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
