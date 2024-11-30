# [3309. 连接二进制表示可形成的最大数值](https://leetcode.cn/problems/maximum-possible-number-by-binary-concatenation)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>3</code> 的整数数组 <code>nums</code>。</p>

<p>现以某种顺序<strong> 连接 </strong>数组 <code>nums</code> 中所有元素的 <strong>二进制表示</strong> ，请你返回可以由这种方法形成的 <strong>最大 </strong>数值。</p>

<p><strong>注意</strong> 任何数字的二进制表示<em> </em><strong>不含</strong><em> </em>前导零。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>输出:</strong> 30</p>

<p><strong>解释:</strong></p>

<p>按照顺序 <code>[3, 1, 2]</code> 连接数字的二进制表示，得到结果 <code>"11110"</code>，这是 30 的二进制表示。</p>
</div>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">nums = [2,8,16]</span></p>

<p><strong>输出:</strong> 1296</p>

<p><strong>解释:</strong></p>

<p>按照顺序 <code>[2, 8, 16]</code> 连接数字的二进制表述，得到结果 <code>"10100010000"</code>，这是 1296 的二进制表示。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>nums.length == 3</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 127</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxGoodNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(3):
            for j in range(3):
                for k in range(3):
                    if i != j and i != k and j != k:
                        v = (nums[i] << (nums[j].bit_length() + nums[k].bit_length())) + (nums[j] << nums[k].bit_length()) + nums[k]
                        ans = max(ans, v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxGoodNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && i != k && j != k) {
                        int jLen = 32 - Integer.numberOfLeadingZeros(nums[j]);
                        int kLen = 32 - Integer.numberOfLeadingZeros(nums[k]);
                        int v = (nums[i] << (jLen + kLen)) + (nums[j] << kLen) + nums[k];
                        ans = Math.max(ans, v);
                    }  
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
