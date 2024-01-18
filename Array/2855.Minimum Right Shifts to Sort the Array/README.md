# [2855. 使数组成为递增数组的最少右移次数](https://leetcode-cn.com/problems/minimum-right-shifts-to-sort-the-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的数组&nbsp;<code>nums</code>&nbsp;，数组中的元素为&nbsp;<strong>互不相同</strong>&nbsp;的正整数。请你返回让 <code>nums</code>&nbsp;成为递增数组的 <strong>最少右移</strong>&nbsp;次数，如果无法得到递增数组，返回 <code>-1</code>&nbsp;。</p>

<p>一次 <strong>右移</strong>&nbsp;指的是同时对所有下标进行操作，将下标为 <code>i</code>&nbsp;的元素移动到下标&nbsp;<code>(i + 1) % n</code>&nbsp;处。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [3,4,5,1,2]
<b>输出：</b>2
<b>解释：</b>
第一次右移后，nums = [2,3,4,5,1] 。
第二次右移后，nums = [1,2,3,4,5] 。
现在 nums 是递增数组了，所以答案为 2 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1,3,5]
<b>输出：</b>0
<b>解释：</b>nums 已经是递增数组了，所以答案为 0 。</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<b>输入：</b>nums = [2,1,4]
<b>输出：</b>-1
<b>解释：</b>无法将数组变为递增数组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>nums</code>&nbsp;中的整数互不相同。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumRightShifts(self, nums: List[int]) -> int:
        i, n = 1, len(nums)
        while i < n:
            if nums[i] < nums[i - 1]:
                break
            i += 1
        for j in range(1, n):
            if nums[(i + j) % n] < nums[(i + j - 1) % n]:
                return -1
        return n - i
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int i = 1, n = nums.size();
        while (i < n) {
            if (nums.get(i) < nums.get(i - 1)) {
                break;
            }
            i++;
        }
        for (int j = 1; j < n; j++) {
            if (nums.get((i + j) % n) < nums.get((i + j - 1) % n)) {
                return -1;
            }
        }
        return n - i;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
