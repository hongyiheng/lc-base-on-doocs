# [1035. 不相交的线](https://leetcode-cn.com/problems/uncrossed-lines)



## 题目描述

<!-- 这里写题目描述 -->

<p>在两条独立的水平线上按给定的顺序写下 <code>nums1</code> 和 <code>nums2</code> 中的整数。</p>

<p>现在，可以绘制一些连接两个数字 <code>nums1[i]</code> 和 <code>nums2[j]</code> 的直线，这些直线需要同时满足满足：</p>

<ul>
	<li> <code>nums1[i] == nums2[j]</code></li>
	<li>且绘制的直线不与任何其他连线（非水平线）相交。</li>
</ul>

<p>请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。</p>

<p>以这种方法绘制线条，并返回可以绘制的最大连线数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/28/142.png" style="height: 72px; width: 100px;" /></strong>

<pre>
<strong>输入：</strong>nums1 = <span id="example-input-1-1">[1,4,2]</span>, nums2 = <span id="example-input-1-2">[1,2,4]</span>
<strong>输出：</strong><span id="example-output-1">2</span>
<strong>解释：</strong>可以画出两条不交叉的线，如上图所示。 
但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
</pre>

<div>
<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = <span id="example-input-2-1">[2,5,1,2,5]</span>, nums2 = <span id="example-input-2-2">[10,5,2,1,5,2]</span>
<strong>输出：</strong><span id="example-output-2">3</span>
</pre>

<div>
<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums1 = <span id="example-input-3-1">[1,3,7,1,7,5]</span>, nums2 = <span id="example-input-3-2">[1,9,2,5,1]</span>
<strong>输出：</strong><span id="example-output-3">2</span></pre>

<p> </p>
</div>
</div>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums1.length <= 500</code></li>
	<li><code>1 <= nums2.length <= 500</code></li>
	<li><code><font face="monospace">1 <= nums1[i], nums2[i] <= 2000</font></code></li>
</ul>

<p> </p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        f = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                f[i][j] = max(f[i][j - 1], f[i - 1][j])
                if nums1[i - 1] == nums2[j - 1]:
                    f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1)
        return f[n][m]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][m];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
