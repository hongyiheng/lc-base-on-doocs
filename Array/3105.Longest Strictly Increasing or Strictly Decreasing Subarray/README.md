# [3105. 最长的严格递增或递减子数组](https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 。</p>

<p>返回数组 <code>nums</code> 中 <strong><span data-keyword="strictly-increasing-array">严格递增</span></strong> 或 <strong><span data-keyword="strictly-decreasing-array">严格递减</span> </strong>的最长非空子数组的长度。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [1,4,3,3,2]</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 中严格递增的子数组有<code>[1]</code>、<code>[2]</code>、<code>[3]</code>、<code>[3]</code>、<code>[4]</code> 以及 <code>[1,4]</code> 。</p>

<p><code>nums</code> 中严格递减的子数组有<code>[1]</code>、<code>[2]</code>、<code>[3]</code>、<code>[3]</code>、<code>[4]</code>、<code>[3,2]</code> 以及 <code>[4,3]</code> 。</p>

<p>因此，返回 <code>2</code> 。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [3,3,3,3]</span></p>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 中严格递增的子数组有 <code>[3]</code>、<code>[3]</code>、<code>[3]</code> 以及 <code>[3]</code> 。</p>

<p><code>nums</code> 中严格递减的子数组有 <code>[3]</code>、<code>[3]</code>、<code>[3]</code> 以及 <code>[3]</code> 。</p>

<p>因此，返回 <code>1</code> 。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [3,2,1]</span></p>

<p><strong>输出：</strong><span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 中严格递增的子数组有 <code>[3]</code>、<code>[2]</code> 以及 <code>[1]</code> 。</p>

<p><code>nums</code> 中严格递减的子数组有 <code>[3]</code>、<code>[2]</code>、<code>[1]</code>、<code>[3,2]</code>、<code>[2,1]</code> 以及 <code>[3,2,1]</code> 。</p>

<p>因此，返回 <code>3</code> 。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        up, down = list(), list()
        ans = 0
        for v in nums:
            if up and up[-1] >= v:
                up.clear()
            if down and down[-1] <= v:
                down.clear()
            up.append(v)
            down.append(v)
            ans = max(ans, len(up), len(down))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        List<Integer> up = new ArrayList<>(), down = new ArrayList<>();
        int ans = 0;
        for (int v : nums) {
            if (!up.isEmpty() && up.get(up.size() - 1) >= v) {
                up.clear();
            }
            if (!down.isEmpty() && down.get(down.size() - 1) <= v) {
                down.clear();
            }
            up.add(v);
            down.add(v);
            ans = Math.max(ans, Math.max(up.size(), down.size()));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
