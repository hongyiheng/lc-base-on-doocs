# [2455. 可被三整除的偶数的平均值](https://leetcode-cn.com/problems/average-value-of-even-numbers-that-are-divisible-by-three)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由正整数组成的整数数组 <code>nums</code> ，返回其中可被 <code>3</code> 整除的所有偶数的平均值。</p>

<p>注意：<code>n</code> 个元素的平均值等于 <code>n</code> 个元素 <strong>求和</strong> 再除以 <code>n</code> ，结果 <strong>向下取整</strong> 到最接近的整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,6,10,12,15]
<strong>输出：</strong>9
<strong>解释：</strong>6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,4,7,10]
<strong>输出：</strong>0
<strong>解释：</strong>不存在满足题目要求的整数，所以返回 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def averageValue(self, nums: List[int]) -> int:
        val = cnt = 0
        for v in nums:
            if v % 2 == 0 and v % 3 == 0:
                val += v
                cnt += 1
        return 0 if cnt == 0 else val // cnt
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int averageValue(int[] nums) {
        int val = 0, cnt = 0;
        for (int v : nums) {
            if (v % 2 == 0 && v % 3 == 0) {
                val += v;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : val / cnt;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
