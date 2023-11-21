# [2799. 统计完全子数组的数目](https://leetcode-cn.com/problems/count-complete-subarrays-in-an-array)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <strong>正</strong> 整数组成的数组 <code>nums</code> 。</p>

<p>如果数组中的某个子数组满足下述条件，则称之为 <strong>完全子数组</strong> ：</p>

<ul>
	<li>子数组中 <strong>不同</strong> 元素的数目等于整个数组不同元素的数目。</li>
</ul>

<p>返回数组中 <strong>完全子数组</strong> 的数目。</p>

<p><strong>子数组</strong> 是数组中的一个连续非空序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,3,1,2,2]
<strong>输出：</strong>4
<strong>解释：</strong>完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [5,5,5,5]
<strong>输出：</strong>10
<strong>解释：</strong>数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        l = r = ans = 0
        t = len(set(nums))
        g = dict()
        while r < n:
            g[nums[r]] = g.get(nums[r], 0) + 1       
            while len(g.keys()) == t:
                ans += n - r
                v = g[nums[l]]
                if v == 1:
                    g.pop(nums[l])
                else:
                    g[nums[l]] = v - 1
                l += 1
            r += 1
        return ans
            
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, ans = 0;
        int t = (int) Arrays.stream(nums).distinct().count();
        Map<Integer, Integer> g = new HashMap<>();
        while (r < n) {
            g.put(nums[r], g.getOrDefault(nums[r], 0) + 1);
            while (g.keySet().size() == t) {
                ans += n - r;
                int v = g.get(nums[l]);
                if (v == 1) {
                    g.remove(nums[l]);
                } else {
                    g.put(nums[l], v - 1);
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
