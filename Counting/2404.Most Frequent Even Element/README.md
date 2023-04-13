# [2404. 出现最频繁的偶数元素](https://leetcode-cn.com/problems/most-frequent-even-element)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，返回出现最频繁的偶数元素。</p>

<p>如果存在多个满足条件的元素，只需要返回 <strong>最小</strong> 的一个。如果不存在这样的元素，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [0,1,2,2,4,4,1]
<strong>输出：</strong>2
<strong>解释：</strong>
数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
返回最小的那个，即返回 2 。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [4,4,4,9,2,4]
<strong>输出：</strong>4
<strong>解释：</strong>4 是出现最频繁的偶数元素。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums = [29,47,21,41,13,37,25,7]
<strong>输出：</strong>-1
<strong>解释：</strong>不存在偶数元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2000</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        cnt = [0] * 100001
        for v in nums:
            cnt[v] += 1
        ans, mx = -1, 0
        for i, v in enumerate(cnt):
            if v > mx and i % 2 == 0:
                ans = i
                mx = v         
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] cnt = new int[100001];
        for (int v : nums) {
            cnt[v]++;
        }
        int ans = -1, mx = 0;
        for (int i = 0; i < 100001; i++) {
            if (cnt[i] > mx && i % 2 == 0) {
                mx = cnt[i];
                ans = i;
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
