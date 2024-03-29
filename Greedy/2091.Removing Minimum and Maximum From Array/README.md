# [2091. 从数组中移除最大值和最小值](https://leetcode-cn.com/problems/removing-minimum-and-maximum-from-array)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，数组由若干 <strong>互不相同</strong> 的整数组成。</p>

<p><code>nums</code> 中有一个值最小的元素和一个值最大的元素。分别称为 <strong>最小值</strong> 和 <strong>最大值</strong> 。你的目标是从数组中移除这两个元素。</p>

<p>一次 <strong>删除</strong> 操作定义为从数组的 <strong>前面</strong> 移除一个元素或从数组的 <strong>后面</strong> 移除一个元素。</p>

<p>返回将数组中最小值和最大值 <strong>都</strong> 移除需要的最小删除次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,<em><strong>10</strong></em>,7,5,4,<em><strong>1</strong></em>,8,6]
<strong>输出：</strong>5
<strong>解释：</strong>
数组中的最小元素是 nums[5] ，值为 1 。
数组中的最大元素是 nums[1] ，值为 10 。
将最大值和最小值都移除需要从数组前面移除 2 个元素，从数组后面移除 3 个元素。
结果是 2 + 3 = 5 ，这是所有可能情况中的最小删除次数。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,<em><strong>-4</strong></em>,<em><strong>19</strong></em>,1,8,-2,-3,5]
<strong>输出：</strong>3
<strong>解释：</strong>
数组中的最小元素是 nums[1] ，值为 -4 。
数组中的最大元素是 nums[2] ，值为 19 。
将最大值和最小值都移除需要从数组前面移除 3 个元素。
结果是 3 ，这是所有可能情况中的最小删除次数。 
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [<em><strong>101</strong></em>]
<strong>输出：</strong>1
<strong>解释：</strong>
数组中只有这一个元素，那么它既是数组中的最小值又是数组中的最大值。
移除它只需要 1 次删除操作。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>nums</code> 中的整数 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 2:
            return n
        mx = mi = nums[0]
        mx_idx = mi_idx = 0
        for i, v in enumerate(nums):
            if v > mx:
                mx = v
                mx_idx = i
            if v < mi:
                mi = v
                mi_idx = i
        ans = max(mi_idx, mx_idx) + 1
        ans = min(ans, max(n - mi_idx, n - mx_idx))
        ans = min(ans, min(mi_idx, mx_idx) + 1 + n - max(mi_idx, mx_idx))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int mx = nums[0], mi = nums[0], mx_idx = 0, mi_idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > mx) {
                mx = nums[i];
                mx_idx = i;
            }
            if (nums[i] < mi) {
                mi = nums[i];
                mi_idx = i;
            }
        }
        int ans = Math.max(mi_idx, mx_idx) + 1;
        ans = Math.min(ans, Math.max(n - mi_idx, n - mx_idx));
        ans = Math.min(ans, Math.min(mi_idx, mx_idx) + 1 + n - Math.max(mi_idx, mx_idx));
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
