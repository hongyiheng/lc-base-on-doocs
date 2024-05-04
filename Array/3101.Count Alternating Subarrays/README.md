# [3101. 交替子数组计数](https://leetcode.cn/problems/count-alternating-subarrays)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个<span data-keyword="binary-array">二进制数组 </span><code>nums</code> 。</p>

<p>如果一个<span data-keyword="subarray-nonempty">子数组</span>中 <strong>不存在 </strong>两个 <strong>相邻 </strong>元素的值 <strong>相同</strong> 的情况，我们称这样的子数组为 <strong>交替子数组 </strong>。</p>

<p>返回数组 <code>nums</code> 中交替子数组的数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [0,1,1,1]</span></p>

<p><strong>输出：</strong> <span class="example-io">5</span></p>

<p><strong>解释：</strong></p>
<!-- 解释示例1的交替子数组 -->

<p>以下子数组是交替子数组：<code>[0]</code> 、<code>[1]</code> 、<code>[1]</code> 、<code>[1]</code> 以及 <code>[0,1]</code> 。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [1,0,1,0]</span></p>

<p><strong>输出：</strong> <span class="example-io">10</span></p>

<p><strong>解释：</strong></p>
<!-- 解释示例2的交替子数组 -->

<p>数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code> 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        ans = cur = 1
        for i in range(1, len(nums)):
            if nums[i - 1] != nums[i]:
                cur += 1
            else:
                cur = 1
            ans += cur
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                cur++;
            } else {
                cur = 1;
            }
            ans += cur;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
