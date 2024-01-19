# [2809. 使数组和小于等于 x 的最少时间](https://leetcode-cn.com/problems/minimum-time-to-make-array-sum-at-most-x)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个长度相等下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;。每一秒，对于所有下标&nbsp;<code>0 &lt;= i &lt; nums1.length</code>&nbsp;，<code>nums1[i]</code>&nbsp;的值都增加&nbsp;<code>nums2[i]</code>&nbsp;。操作&nbsp;<strong>完成后</strong>&nbsp;，你可以进行如下操作：</p>

<ul>
	<li>选择任一满足&nbsp;<code>0 &lt;= i &lt; nums1.length</code>&nbsp;的下标 <code>i</code>&nbsp;，并使&nbsp;<code>nums1[i] = 0</code>&nbsp;。</li>
</ul>

<p>同时给你一个整数&nbsp;<code>x</code>&nbsp;。</p>

<p>请你返回使&nbsp;<code>nums1</code>&nbsp;中所有元素之和 <strong>小于等于</strong>&nbsp;<code>x</code>&nbsp;所需要的 <strong>最少</strong>&nbsp;时间，如果无法实现，那么返回 <code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums1 = [1,2,3], nums2 = [1,2,3], x = 4
<b>输出：</b>3
<b>解释：</b>
第 1 秒，我们对 i = 0 进行操作，得到 nums1 = [0,2+2,3+3] = [0,4,6] 。
第 2 秒，我们对 i = 1 进行操作，得到 nums1 = [0+1,0,6+3] = [1,0,9] 。
第 3 秒，我们对 i = 2 进行操作，得到 nums1 = [1+1,0+2,0] = [2,2,0] 。
现在 nums1 的和为 4 。不存在更少次数的操作，所以我们返回 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums1 = [1,2,3], nums2 = [3,3,3], x = 4
<b>输出：</b>-1
<b>解释：</b>不管如何操作，nums1 的和总是会超过 x 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= nums1[i] &lt;= 10<sup>3</sup></code></li>
	<li><code>0 &lt;= nums2[i] &lt;= 10<sup>3</sup></code></li>
	<li><code>nums1.length == nums2.length</code></li>
	<li><code>0 &lt;= x &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumTime(self, nums1: List[int], nums2: List[int], x: int) -> int:
        q = [(a, b) for a, b in zip(nums1, nums2)]
        q.sort(key=lambda x: x[1])
        n = len(nums1)
        f = [0] * (n + 1)
        for i in range(n):
            a, b = q[i]
            for j in range(i + 1, 0, -1):
                f[j] = max(f[j], f[j - 1] + a + b * j)
        s1, s2 = sum(nums1), sum(nums2)
        for i in range(n + 1):
            if s1 + s2 * i - f[i] <= x:
                return i
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] q = new int[n][2];
        int s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            q[i][0] = a;
            q[i][1] = b;
            s1 += a;
            s2 += b;
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = q[i][0], b = q[i][1];
            for (int j = i + 1; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (s1 + s2 * i - f[i] <= x) {
                return i;
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
