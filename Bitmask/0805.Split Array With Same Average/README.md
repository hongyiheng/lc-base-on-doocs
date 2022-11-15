# [805. 数组的均值分割](https://leetcode-cn.com/problems/split-array-with-same-average)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）</p>

<p>返回<code>true</code> ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。</p>

<pre>
<strong>示例:</strong>
<strong>输入:</strong> 
[1,2,3,4,5,6,7,8]
<strong>输出:</strong> true
<strong>解释: </strong>我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
</pre>

<p><strong>注意:</strong></p>

<ul>
	<li><code>A</code> 数组的长度范围为 <code>[1, 30]</code>.</li>
	<li><code>A[i]</code> 的数据范围为 <code>[0, 10000]</code>.</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def splitArraySameAverage(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return False
        m, s = n // 2, sum(nums)
        for i in range(n):
            nums[i] = nums[i] * n - s
        vis = set()
        for i in range(1, 1 << m):
            ss = 0
            for j in range(m):
                if (1 << j) & i:
                    ss += nums[j]
            if ss == 0:
                return True
            vis.add(ss)
        for i in range(1, 1 << (n - m)):
            ss = 0
            for j in range(n - m):
                if (1 << j) & i:
                    ss += nums[j + m]
            if ss == 0 or (i != (1 << n - m) - 1 and -ss in vis):
                return True
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, m = n / 2, s = 0;
        if (n == 1) {
            return false;
        }
        for (int v : nums) {
            s += v;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - s;
        }
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int ss = 0;
            for (int j = 0; j < m; j++) {
                if (((1 << j) & i) != 0) {
                    ss += nums[j];
                }
            }
            if (ss == 0) {
                return true;
            }
            vis.add(ss);
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int ss = 0;
            for (int j = 0; j < (n - m); j++) {
                if (((1 << j) & i) != 0) {
                    ss += nums[j + m];
                }
            }
            if (ss == 0 || (i != (1 << (n - m)) - 1 && vis.contains(-ss))) {
                return true;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
