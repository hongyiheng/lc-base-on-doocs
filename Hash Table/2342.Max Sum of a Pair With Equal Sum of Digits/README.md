# [2342. 数位和相等数对的最大和](https://leetcode-cn.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，数组中的元素都是 <strong>正</strong> 整数。请你选出两个下标 <code>i</code> 和 <code>j</code>（<code>i != j</code>），且 <code>nums[i]</code> 的数位和 与&nbsp; <code>nums[j]</code> 的数位和相等。</p>

<p>请你找出所有满足条件的下标 <code>i</code> 和 <code>j</code> ，找出并返回<em> </em><code>nums[i] + nums[j]</code><em> </em>可以得到的 <strong>最大值</strong> <em>。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [18,43,36,13,7]
<strong>输出：</strong>54
<strong>解释：</strong>满足条件的数对 (i, j) 为：
- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
所以可以获得的最大和是 54 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,12,19,14]
<strong>输出：</strong>-1
<strong>解释：</strong>不存在满足条件的数对，返回 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        g = dict()
        ans = -1
        for v in nums:
            k = 0
            t = v
            while t:
                k += t % 10
                t //= 10
            nv = g.get(k, 0)
            if nv:
                ans = max(ans, g[k] + v)
            g[k] = max(nv, v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> g = new HashMap<>();
        int ans = -1;
        for (int v : nums) {
            int t = v, k = 0;
            while (t > 0) {
                k += t % 10;
                t /= 10;
            }
            int nv = g.getOrDefault(k, 0);
            if (nv > 0) {
                ans = Math.max(ans, nv + v);
            }
            g.put(k, Math.max(nv, v));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
