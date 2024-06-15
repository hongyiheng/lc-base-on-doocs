# [3151. 特殊数组 I](https://leetcode.cn/problems/special-array-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 <strong>特殊数组</strong> 。</p>

<p>Aging 有一个整数数组 <code>nums</code>。如果 <code>nums</code> 是一个 <strong>特殊数组</strong> ，返回 <code>true</code>，否则返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [1]</span></p>

<p><strong>输出：</strong><span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<p>只有一个元素，所以答案为 <code>true</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [2,1,4]</span></p>

<p><strong>输出：</strong><span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<p>只有两对相邻元素： <code>(2,1)</code> 和 <code>(1,4)</code>，它们都包含了奇偶性不同的数字，因此答案为 <code>true</code>。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [4,3,1,6]</span></p>

<p><strong>输出：</strong><span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<p><code>nums[1]</code> 和 <code>nums[2]</code> 都是奇数。因此答案为 <code>false</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        for i in range(1, len(nums)):
            if nums[i - 1] % 2 == nums[i] % 2:
                return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
