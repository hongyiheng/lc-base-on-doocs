# [1630. 等差子数组](https://leetcode-cn.com/problems/arithmetic-subarrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 <strong>等差数列</strong> 。更正式地，数列 <code>s</code> 是等差数列，只需要满足：对于每个有效的 <code>i</code> ， <code>s[i+1] - s[i] == s[1] - s[0]</code> 都成立。</p>

<p>例如，下面这些都是 <strong>等差数列</strong> ：</p>

<pre>1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9</pre>

<p>下面的数列 <strong>不是等差数列</strong> ：</p>

<pre>1, 1, 2, 5, 7</pre>

<p>给你一个由 <code>n</code> 个整数组成的数组 <code>nums</code>，和两个由 <code>m</code> 个整数组成的数组 <code>l</code> 和 <code>r</code>，后两个数组表示 <code>m</code> 组范围查询，其中第 <code>i</code> 个查询对应范围 <code>[l[i], r[i]]</code> 。所有数组的下标都是 <strong>从 0 开始</strong> 的。</p>

<p>返回<em> </em><code>boolean</code> 元素构成的答案列表 <code>answer</code> 。如果子数组 <code>nums[l[i]], nums[l[i]+1], ... , nums[r[i]]</code> 可以 <strong>重新排列</strong> 形成 <strong>等差数列</strong> ，<code>answer[i]</code> 的值就是 <code>true</code>；否则<code>answer[i]</code> 的值就是 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = <code>[4,6,5,9,3,7]</code>, l = <code>[0,0,2]</code>, r = <code>[2,3,5]</code>
<strong>输出：</strong><code>[true,false,true]</code>
<strong>解释：</strong>
第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
第 2 个查询，对应子数组 <code>[5,9,3,7] 。</code>可以重新排列为等差数列 <code>[3,5,7,9] 。</code></pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
<strong>输出：</strong>[false,true,false,false,true,true]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>m == l.length</code></li>
	<li><code>m == r.length</code></li>
	<li><code>2 &lt;= n &lt;= 500</code></li>
	<li><code>1 &lt;= m &lt;= 500</code></li>
	<li><code>0 &lt;= l[i] &lt; r[i] &lt; n</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        n, m = len(nums), len(l)
        ans = [True] * m
        for i in range(m):
            left, right = l[i], r[i]
            max_, min_ = float('-inf'), float('inf')
            s = set()
            for j in range(left, right + 1):
                s.add(nums[j])
                max_ = max(max_, nums[j])
                min_ = min(min_, nums[j])
            if (max_ - min_) % (right - left) != 0:
                ans[i] = False
                continue
            k = (max_ - min_) // (right - left)
            while min_ < max_:
                if min_ + k not in s:
                    ans[i] = False
                    break
                min_ += k
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length, m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left = l[i], right = r[i];
            Set<Integer> s = new HashSet();
            int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
            for (int j = left; j <= right; j++) {
                s.add(nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);
            }
            if ((maxVal - minVal) % (right - left) != 0) {
                ans.add(false);
                continue;
            }
            int k = (maxVal - minVal) / (right - left);
            boolean flag = true;
            while (minVal < maxVal) {
                if (!s.contains(minVal + k)) {
                    flag = false;
                    break;
                }
                minVal += k;
            }
            ans.add(flag);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
