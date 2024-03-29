# [324. 摆动排序 II](https://leetcode-cn.com/problems/wiggle-sort-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>，将它重新排列成 <code>nums[0] < nums[1] > nums[2] < nums[3]...</code> 的顺序。</p>

<p>你可以假设所有输入数组都可以得到满足题目要求的结果。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,1,1,6,4]
<strong>输出：</strong>[1,6,1,5,1,4]
<strong>解释：</strong>[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,2,2,3,1]
<strong>输出：</strong>[2,3,1,3,1,2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>0 <= nums[i] <= 5000</code></li>
	<li>题目数据保证，对于给定的输入 <code>nums</code> ，总能产生满足题目要求的结果</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt = [0] * 5010
        for v in nums:
            cnt[v] += 1
        idx, n, j = 0, len(nums), 5000
        for i in range(1, n, 2):
            while cnt[j] == 0:
                j -= 1
            nums[i] = j
            cnt[j] -= 1
        for i in range(0, n, 2):
            while cnt[j] == 0:
                j -= 1
            nums[i] = j
            cnt[j] -= 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[5010];
        for (int v : nums) {
            cnt[v]++;
        }
        int j = 5000;
        for (int i = 1; i < n; i += 2) {
            while (cnt[j] == 0) {
                j--;
            }
            nums[i] = j;
            cnt[j]--;
        }
        for (int i = 0; i < n; i += 2) {
            while (cnt[j] == 0) {
                j--;
            }
            nums[i] = j;
            cnt[j]--;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
