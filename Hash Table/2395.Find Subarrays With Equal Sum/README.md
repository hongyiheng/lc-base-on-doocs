# [2395. 和相等的子数组](https://leetcode-cn.com/problems/find-subarrays-with-equal-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;，判断是否存在&nbsp;<strong>两个</strong>&nbsp;长度为&nbsp;<code>2</code>&nbsp;的子数组且它们的&nbsp;<strong>和</strong>&nbsp;相等。注意，这两个子数组起始位置的下标必须&nbsp;<strong>不相同</strong>&nbsp;。</p>

<p>如果这样的子数组存在，请返回&nbsp;<code>true</code>，否则返回&nbsp;<code>false</code><em>&nbsp;</em>。</p>

<p><strong>子数组</strong> 是一个数组中一段连续非空的元素组成的序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [4,2,4]
<b>输出：</b>true
<b>解释：</b>元素为 [4,2] 和 [2,4] 的子数组有相同的和 6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [1,2,3,4,5]
<b>输出：</b>false
<b>解释：</b>没有长度为 2 的两个子数组和相等。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [0,0,0]
<b>输出：</b>true
<b>解释：</b>子数组 [nums[0],nums[1]] 和 [nums[1],nums[2]] 的和相等，都为 0 。
注意即使子数组的元素相同，这两个子数组也视为不相同的子数组，因为它们在原数组中的起始位置不同。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        vis = set()
        i, n = 0, len(nums)
        while i + 1 < n:
            s = nums[i] + nums[i + 1]
            if s in vis:
                return True
            vis.add(s)
            i += 1
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> vis = new HashSet<>();
        int i = 0;
        while (i < n - 1) {
            int s = nums[i] + nums[i + 1];
            if (vis.contains(s)) {
                return true;
            }
            vis.add(s);
            i++;
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
