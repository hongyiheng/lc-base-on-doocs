# [164. 最大间距](https://leetcode-cn.com/problems/maximum-gap)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。</p>

<p>如果数组元素个数小于 2，则返回 0。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [3,6,9,1]
<strong>输出:</strong> 3
<strong>解释:</strong> 排序后的数组是 [1,3,6,9]<strong><em>, </em></strong>其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [10]
<strong>输出:</strong> 0
<strong>解释:</strong> 数组元素个数小于 2，因此返回 0。</pre>

<p><strong>说明:</strong></p>

<ul>
	<li>你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。</li>
	<li>请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return 0
        max_, min_ = max(nums), min(nums)
        bucket_len = max(1, (max_ - min_) // (n - 1))
        bucket = [None] * ((max_ - min_) // bucket_len + 1)
        for v in nums:
            idx = (v - min_) // bucket_len
            if bucket[idx] is None:
                bucket[idx] = []
            bucket[idx].append(v)
        ans, last = 0, float('inf')
        for b in bucket:
            if b:
                b_max = max(b)
                b_min = min(b)
                ans = max(ans, b_max - b_min)
                if last != float('inf'):
                    ans = max(ans, b_min - last)
                last = b_max
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int v : nums) {
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        int bucketLen = Math.max(1, (max - min) / (n - 1));
        List<Integer>[] bucket = new ArrayList[(max - min) / bucketLen + 1];
        for (int v : nums) {
            if (bucket[(v - min) / bucketLen] == null) {
                bucket[(v - min) / bucketLen] = new ArrayList<>();
            }
            bucket[(v - min) / bucketLen].add(v);
        }
        int ans = 0, last = Integer.MAX_VALUE;
        for (List<Integer> b : bucket) {
            if (b == null) {
                continue;
            }
            int bMax = Integer.MIN_VALUE, bMin = Integer.MAX_VALUE;
            for (int v : b) {
                bMax = Math.max(bMax, v);
                bMin = Math.min(bMin, v);
            }
            ans = Math.max(ans, bMax - bMin);
            if (last != Integer.MAX_VALUE) {
                ans = Math.max(ans, bMin - last);
            }
            last = bMax;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
