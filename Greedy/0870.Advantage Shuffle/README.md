# [870. 优势洗牌](https://leetcode-cn.com/problems/advantage-shuffle)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个大小相等的数组&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>，A 相对于 B 的<em>优势</em>可以用满足&nbsp;<code>A[i] &gt; B[i]</code>&nbsp;的索引 <code>i</code>&nbsp;的数目来描述。</p>

<p>返回&nbsp;<code>A</code>&nbsp;的<strong>任意</strong>排列，使其相对于 <code>B</code>&nbsp;的优势最大化。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = [2,7,11,15], B = [1,10,4,11]
<strong>输出：</strong>[2,11,7,15]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = [12,24,8,32], B = [13,25,32,11]
<strong>输出：</strong>[24,32,8,12]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length = B.length &lt;= 10000</code></li>
	<li><code>0 &lt;= A[i] &lt;= 10^9</code></li>
	<li><code>0 &lt;= B[i] &lt;= 10^9</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        arr = [[v, i] for i, v in enumerate(nums2)]
        arr.sort(key=lambda x: -x[0])
        n = len(nums1)
        ans = [0] * n
        l, r = 0, n - 1
        for v, i in arr:
            if v < nums1[r]:
                ans[i] = nums1[r]
                r -= 1
            else:
                ans[i] = nums1[l]
                l += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        for (int[] v : arr) {
            if (v[0] < nums1[r]) {
                ans[v[1]] = nums1[r--];
            } else {
                ans[v[1]] = nums1[l++];
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
