# [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个<strong>非空</strong>整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。</p>

<p><strong>说明：</strong></p>

<p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [2,2,1]
<strong>输出:</strong> 1
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [4,1,2,1,2]
<strong>输出:</strong> 4</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans ^= num
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
