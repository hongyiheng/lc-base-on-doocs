# [368. 最大整除子集](https://leetcode-cn.com/problems/largest-divisible-subset)



## 题目描述

<!-- 这里写题目描述 -->

给你一个由 <strong>无重复</strong> 正整数组成的集合 <code>nums</code> ，请你找出并返回其中最大的整除子集 <code>answer</code> ，子集中每一元素对 <code>(answer[i], answer[j])</code> 都应当满足：
<ul>
	<li><code>answer[i] % answer[j] == 0</code> ，或</li>
	<li><code>answer[j] % answer[i] == 0</code></li>
</ul>

<p>如果存在多个有效解子集，返回其中任何一个均可。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[1,2]
<strong>解释：</strong>[1,3] 也会被视为正确答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,4,8]
<strong>输出：</strong>[1,2,4,8]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 1000</code></li>
	<li><code>1 <= nums[i] <= 2 * 10<sup>9</sup></code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        f, p = [0] * n, [-1] * n
        mx_i = 0
        for i, v in enumerate(nums):
            for j in range(i):
                if v % nums[j] == 0 and f[j] > f[i]:
                    f[i] = f[j]
                    p[i] = j
            f[i] += 1
            if f[i] > f[mx_i]:
                mx_i = i

        ans = []
        i = mx_i
        while i >= 0:
            ans.append(nums[i])
            i = p[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n], p = new int[n];
        Arrays.fill(p, -1);
        int mxIdx = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            for (int j = 0; j < i; j++) {
                if (v % nums[j] == 0 && f[j] > f[i]) {
                    f[i] = f[j];
                    p[i] = j;
                }     
            }
            f[i]++;
            if (f[i] > f[mxIdx]) {
                mxIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (mxIdx >= 0) {
            ans.add(nums[mxIdx]);
            mxIdx = p[mxIdx];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
