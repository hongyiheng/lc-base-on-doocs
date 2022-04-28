# [1292. 元素和小于等于阈值的正方形的最大边长](https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个大小为 <code>m x n</code> 的矩阵 <code>mat</code> 和一个整数阈值 <code>threshold</code>。</p>

<p>请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 <strong>0 </strong>。<br />
 </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/15/e1.png" style="height: 186px; width: 335px;" /></p>

<pre>
<strong>输入：</strong>mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
<strong>输出：</strong>2
<strong>解释：</strong>总和小于或等于 4 的正方形的最大边长为 2，如图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
<strong>输出：</strong>3
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
<strong>输出：</strong>2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= m, n <= 300</code></li>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>0 <= mat[i][j] <= 10000</code></li>
	<li><code>0 <= threshold <= 10^5</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])
        pre = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + mat[i - 1][j - 1]
        
        def check(k):
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if i < k or j < k:
                        continue
                    s = pre[i][j] - pre[i][j - k] - pre[i - k][j] + pre[i - k][j - k]
                    if s <= threshold:
                        return True
            return False

        left, right = 0, min(m, n)
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[][] pre;
    int m, n;
    int threshold;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        pre = new int[m + 1][n + 1];
        this.threshold = threshold;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + mat[i - 1][j - 1] - pre[i - 1][j - 1];
            }
        }
        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int mid) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < mid || j < mid) {
                    continue;
                }
                int s = pre[i][j] - pre[i][j - mid] - pre[i - mid][j] + pre[i - mid][j - mid];
                if (s <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
