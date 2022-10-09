# [594. 最长和谐子序列](https://leetcode-cn.com/problems/longest-harmonious-subsequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>和谐数组是指一个数组里元素的最大值和最小值之间的差别 <strong>正好是 <code>1</code></strong> 。</p>

<p>现在，给你一个整数数组 <code>nums</code> ，请你在所有可能的子序列中找到最长的和谐子序列的长度。</p>

<p>数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,2,2,5,2,3,7]
<strong>输出：</strong>5
<strong>解释：</strong>最长的和谐子序列是 [3,2,2,2,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        mp = dict()
        for v in nums:
            mp[v] = mp.get(v, 0) + 1
        ans = 0
        for v in nums:
            if v + 1 in mp:
                ans = max(mp[v] + mp[v + 1], ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int k : mp.keySet()) {
            if (mp.containsKey(k + 1)) {
                ans = Math.max(ans, mp.get(k + 1) + mp.get(k));
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
