# [718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给两个整数数组&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;，返回两个数组中公共的、长度最长的子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>
A: [1,2,3,2,1]
B: [3,2,1,4,7]
<strong>输出：</strong>3
<strong>解释：</strong>
长度最长的公共子数组是 [3, 2, 1] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= len(A), len(B) &lt;= 1000</code></li>
	<li><code>0 &lt;= A[i], B[i] &lt; 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(dp[i][j], ans);
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
