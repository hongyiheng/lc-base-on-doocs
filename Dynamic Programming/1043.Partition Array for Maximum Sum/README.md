# [1043. 分隔数组以得到最大和](https://leetcode-cn.com/problems/partition-array-for-maximum-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>arr</code>，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。</p>

<p>返回将数组分隔变换后能够得到的元素最大和。</p>

<p> </p>

<p><strong>注意，</strong>原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,15,7,9,2,5,10], k = 3
<strong>输出：</strong>84
<strong>解释：</strong>
因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。 </pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
<strong>输出：</strong>83
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [1], k = 1
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr.length <= 500</code></li>
	<li><code>0 <= arr[i] <= 10<sup>9</sup></code></li>
	<li><code>1 <= k <= arr.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        f = [0] * n
        for i in range(k):
            f[i] = max(arr[:i + 1]) * (i + 1)
        for i in range(k, n):
            for j in range(k):
                f[i] = max(f[i], f[i - j - 1] + max(arr[i - j:i + 1]) * (j + 1))
        return f[-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n];
        int mx = 0;
        for (int i = 0; i < k; i++) {
            mx = Math.max(mx, arr[i]);
            f[i] = mx * (i + 1);
        }
        for (int i = k; i < n; i++) {
            mx = 0;
            for (int j = 0; j < k; j++) {
                mx = Math.max(mx, arr[i - j]);
                f[i] = Math.max(f[i], f[i - j - 1] + mx * (j + 1));
            }
        }
        return f[n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
