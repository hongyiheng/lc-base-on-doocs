# [2997. 使数组异或和等于 K 的最少操作次数](https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code>&nbsp;和一个正整数&nbsp;<code>k</code>&nbsp;。</p>

<p>你可以对数组执行以下操作 <strong>任意次</strong>&nbsp;：</p>

<ul>
	<li>选择数组里的 <strong>任意</strong>&nbsp;一个元素，并将它的&nbsp;<strong>二进制</strong>&nbsp;表示&nbsp;<strong>翻转</strong>&nbsp;一个数位，翻转数位表示将&nbsp;<code>0</code> 变成&nbsp;<code>1</code>&nbsp;或者将 <code>1</code>&nbsp;变成 <code>0</code>&nbsp;。</li>
</ul>

<p>你的目标是让数组里 <strong>所有</strong>&nbsp;元素的按位异或和得到 <code>k</code>&nbsp;，请你返回达成这一目标的 <strong>最少&nbsp;</strong>操作次数。</p>

<p><strong>注意</strong>，你也可以将一个数的前导 0 翻转。比方说，数字&nbsp;<code>(101)<sub>2</sub></code>&nbsp;翻转第四个数位，得到&nbsp;<code>(1101)<sub>2</sub></code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [2,1,3,4], k = 1
<b>输出：</b>2
<b>解释：</b>我们可以执行以下操作：
- 选择下标为 2 的元素，也就是 3 == (011)<sub>2</sub>&nbsp;，我们翻转第一个数位得到 (010)<sub>2</sub> == 2 。数组变为 [2,1,2,4] 。
- 选择下标为 0 的元素，也就是 2 == (010)<sub>2</sub> ，我们翻转第三个数位得到 (110)<sub>2</sub> == 6 。数组变为 [6,1,2,4] 。
最终数组的所有元素异或和为 (6 XOR 1 XOR 2 XOR 4) == 1 == k 。
无法用少于 2 次操作得到异或和等于 k 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,0,2,0], k = 0
<b>输出：</b>0
<strong>解释：</strong>数组所有元素的异或和为 (2 XOR 0 XOR 2 XOR 0) == 0 == k 。所以不需要进行任何操作。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        cnt = [0] * 32
        for v in nums:
            for i in range(32):
                if v >> i & 1:
                    cnt[i] ^= 1
        ans = 0
        for i in range(32):
            if k >> i & 1 and not cnt[i] or (not k >> i & 1 and cnt[i]):
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minOperations(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int v : nums) {
            for (int i = 0; i < 32; i++) {
                if ((v >> i & 1) == 1) {
                    cnt[i] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((k >> i & 1) == 1 && cnt[i] == 0) || ((k >> i & 1) == 0 && cnt[i] == 1)) {
                ans++;
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
