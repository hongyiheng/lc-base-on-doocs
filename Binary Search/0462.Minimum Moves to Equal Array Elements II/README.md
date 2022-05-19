# [462. 最少移动次数使数组元素相等 II](https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。</p>

<p><strong>例如:</strong></p>

<pre>
<strong>输入:</strong>
[1,2,3]

<strong>输出:</strong>
2

<strong>说明：
</strong>只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 

[1,2,3]  =&gt;  [2,2,3]  =&gt;  [2,2,2]
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        def get_diff(x):
            nonlocal nums
            cnt = 0
            for v in nums:
                cnt += abs(v - x)
            return cnt
        
        left, right = min(nums), max(nums)
        while left < right:
            mid = (left + right) >> 1
            cnt1 = get_diff(mid)
            cnt2 = get_diff(mid + 1)
            if cnt2 < cnt1:
                left = mid + 1
            else:
                right = mid
        return get_diff(left)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] nums;

    public int minMoves2(int[] nums) {
        this.nums = nums;
        int left = Integer.MAX_VALUE, right= Integer.MIN_VALUE;
        for (int v : nums) {
            left = Math.min(left, v);
            right = Math.max(right, v);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            int cnt1 = getDiff(mid);
            int cnt2 = getDiff(mid + 1);
            if (cnt2 < cnt1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return getDiff(left);
    }

    public int getDiff(int x) {
        int cnt = 0;
        for (int v : nums) {
            cnt += Math.abs(v - x);
        }
        return cnt;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
