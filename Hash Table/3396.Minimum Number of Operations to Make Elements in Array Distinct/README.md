# [3396. 使数组元素互不相同所需的最少操作次数](https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>，你需要确保数组中的元素&nbsp;<strong>互不相同&nbsp;</strong>。为此，你可以执行以下操作任意次：</p>

<ul>
	<li>从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。</li>
</ul>

<p><strong>注意：</strong>空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的&nbsp;<strong>最少操作次数&nbsp;</strong>。<!-- notionvc: 210ee4f2-90af-4cdf-8dbc-96d1fa8f67c7 --></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [1,2,3,4,2,3,3,5,7]</span></p>

<p><strong>输出：</strong> <span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>第一次操作：移除前 3 个元素，数组变为 <code>[4, 2, 3, 3, 5, 7]</code>。</li>
	<li>第二次操作：再次移除前 3 个元素，数组变为 <code>[3, 5, 7]</code>，此时数组中的元素互不相同。</li>
</ul>

<p>因此，答案是 2。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [4,5,6,4,4]</span></p>

<p><strong>输出：</strong> <span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>第一次操作：移除前 3 个元素，数组变为 <code>[4, 4]</code>。</li>
	<li>第二次操作：移除所有剩余元素，数组变为空。</li>
</ul>

<p>因此，答案是 2。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">nums = [6,7,8,9]</span></p>

<p><strong>输出：</strong> <span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p>数组中的元素已经互不相同，因此不需要进行任何操作，答案是 0。</p>
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
    def minimumOperations(self, nums: List[int]) -> int:
        n = len(nums)
        s = set()
        for i in range(n - 1, -1, -1):
            if nums[i] in s:
                return i // 3 + 1
            s.add(nums[i])
        return 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for (int i = n - 1; i > -1; i--) {
            if (s.contains(nums[i])) {
                return i / 3 + 1;
            }
            s.add(nums[i]);
        }
        return 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
