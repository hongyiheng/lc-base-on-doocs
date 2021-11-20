# [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>&nbsp;，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [2,3,-2,4]
<strong>输出:</strong> <code>6</code>
<strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [-2,0,-1]
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, lastMax = 1, lastMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = lastMax;
                lastMax = lastMin;
                lastMin = temp;
            }
            lastMax = Math.max(nums[i] * lastMax, nums[i]);
            lastMin = Math.min(nums[i] * lastMin, nums[i]);
            ans = Math.max(ans, lastMax);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
