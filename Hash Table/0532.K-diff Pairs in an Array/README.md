# [532. 数组中的 k-diff 数对](https://leetcode-cn.com/problems/k-diff-pairs-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组和一个整数 <code><strong>k</strong></code>，你需要在数组里找到<strong> 不同的 </strong>k-diff 数对，并返回不同的 <strong>k-diff 数对</strong> 的数目。</p>

<p>这里将 <strong>k-diff</strong> 数对定义为一个整数对 <code>(nums[i], nums[j])</code>，并满足下述全部条件：</p>

<ul>
	<li><code>0 <= i < j < nums.length</code></li>
	<li><code>|nums[i] - nums[j]| == k</code></li>
</ul>

<p><strong>注意</strong>，<code>|val|</code> 表示 <code>val</code> 的绝对值。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3, 1, 4, 1, 5], k = 2
<strong>输出：</strong>2
<strong>解释：</strong>数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
尽管数组中有两个1，但我们只应返回不同的数对的数量。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1, 2, 3, 4, 5], k = 1
<strong>输出：</strong>4
<strong>解释：</strong>数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1, 3, 1, 5, 4], k = 0
<strong>输出：</strong>1
<strong>解释：</strong>数组中只有一个 0-diff 数对，(1, 1)。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,4,4,3,3,0,9,2,3], k = 3
<strong>输出：</strong>2
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,-2,-3], k = 1
<strong>输出：</strong>2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
	<li><code>-10<sup>7</sup> <= nums[i] <= 10<sup>7</sup></code></li>
	<li><code>0 <= k <= 10<sup>7</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        s = dict()
        for v in nums:
            s[v] = s.get(v, 0) + 1
        ans = 0
        for v in s:
            if k != 0 and v + k in nums:
                ans += 1
            if k == 0 and s[v] > 1:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int v : mp.keySet()) {
            if (k == 0) {
                if (mp.get(v) > 1) {
                    ans++;
                }  
            } else if (mp.containsKey(v + k)) {
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
