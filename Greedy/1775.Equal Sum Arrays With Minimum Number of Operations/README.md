# [1775. 通过最少操作次数使数组的和相等](https://leetcode-cn.com/problems/equal-sum-arrays-with-minimum-number-of-operations)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个长度可能不等的整数数组 <code>nums1</code> 和 <code>nums2</code> 。两个数组中的所有值都在 <code>1</code> 到 <code>6</code> 之间（包含 <code>1</code> 和 <code>6</code>）。</p>

<p>每次操作中，你可以选择 <strong>任意</strong> 数组中的任意一个整数，将它变成 <code>1</code> 到 <code>6</code> 之间 <strong>任意</strong> 的值（包含 <code>1</code> 和 <code><span style="">6</span></code>）。</p>

<p>请你返回使 <code>nums1</code> 中所有数的和与 <code>nums2</code> 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
<b>输出：</b>3
<b>解释：</b>你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [<strong>6</strong>,1,2,2,2,2] 。
- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,<strong>1</strong>], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[2] 变为 2 。 nums1 = [1,2,<strong>2</strong>,4,5,1], nums2 = [6,1,2,2,2,2] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [1,1,1,1,1,1,1], nums2 = [6]
<b>输出：</b>-1
<b>解释：</b>没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums1 = [6,6], nums2 = [1]
<b>输出：</b>3
<b>解释：</b>你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums1[0] 变为 2 。 nums1 = [<strong>2</strong>,6], nums2 = [1] 。
- 将 nums1[1] 变为 2 。 nums1 = [2,<strong>2</strong>], nums2 = [1] 。
- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [<strong>4</strong>] 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 6</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        if n > m * 6 or n * 6 < m:
            return -1
        s1, s2 = sum(nums1), sum(nums2)
        if s1 < s2:
            return self.minOperations(nums2, nums1)
    
        mp = dict()
        for v in nums1:
            mp[v - 1] = mp.get(v - 1, 0) + 1
        for v in nums2:
            mp[6 - v] = mp.get(6 - v, 0) + 1
        ans, t = 0, s1 - s2
        for i in range(5, 0, -1):
            if t <= 0:
                break
            num = mp.get(i, 0)
            if num * i >= t:
                ans += (t + i - 1) // i
            else:
                ans += num
            t -= num * i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m * 6 || n * 6 < m) {
            return -1;
        }
        int t = 0;
        for (int v : nums1) {
            t += v;
        }
        for (int v : nums2) {
            t -= v;
        }
        if (t < 0) {
            t = -t;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums1) {
            mp.put(v - 1, mp.getOrDefault(v - 1, 0) + 1);
        }
        for (int v : nums2) {
            mp.put(6 - v, mp.getOrDefault(6 - v, 0) + 1);
        }
        int ans = 0;
        for (int i = 5; i >= 1; i--) {
            if (t <= 0) {
                break;
            }
            int num = mp.getOrDefault(i, 0);
            if (num * i >= t) {
                ans += (t + i - 1) / i;
            } else {
                ans += num;
            }
            t -= num * i;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
