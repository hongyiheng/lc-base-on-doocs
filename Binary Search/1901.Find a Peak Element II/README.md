# [1901. 找出顶峰元素 II](https://leetcode-cn.com/problems/find-a-peak-element-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个 2D 网格中的 <strong>顶峰元素 </strong>是指那些 <strong>严格大于 </strong>其相邻格子(上、下、左、右)的元素。</p>

<p>给你一个<strong> 从 0 开始编号 </strong>的 <code>m x n</code> 矩阵 <code>mat</code> ，其中任意两个相邻格子的值都<strong> 不相同</strong> 。找出 <strong>任意一个 </strong>顶峰元素 <code>mat[i][j]</code> 并 <strong>返回其位置 </strong><code>[i,j]</code> 。</p>

<p>你可以假设整个矩阵周边环绕着一圈值为 <code>-1</code> 的格子。</p>

<p>要求必须写出时间复杂度为 <code>O(m log(n))</code> 或 <code>O(n log(m))</code> 的算法</p>

<p> </p>

<p> </p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/1.png" style="width: 206px; height: 209px;" /></p>

<pre>
<strong>输入:</strong> mat = [[1,4],[3,2]]
<strong>输出:</strong> [0,1]
<strong>解释:</strong> 3和4都是顶峰元素，所以[1,0]和[0,1]都是可接受的答案。
</pre>

<p><strong>示例 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/07/3.png" style="width: 254px; height: 257px;" /></strong></p>

<pre>
<strong>输入:</strong> mat = [[10,20,15],[21,30,14],[7,16,32]]
<strong>输出:</strong> [1,1]
<strong>解释:</strong> 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 <= m, n <= 500</code></li>
	<li><code>1 <= mat[i][j] <= 10<sup>5</sup></code></li>
	<li>任意两个相邻元素均不相等.</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        m, n = len(mat), len(mat[0])
        l, r = 0, m - 1
        while l < r:
            mid = (l + r) >> 1
            mx = max(mat[mid])
            j = mat[mid].index(mx)
            if mid < m - 1 and mat[mid][j] <= mat[mid + 1][j]:
                l = mid + 1
            else:
                r = mid
        return [l, mat[l].index(max(mat[l]))]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getMaxCol(int[][] mat, int i) {
        int mx = 0, idx = 0;
        for (int j = 0; j < mat[i].length; j++) {
            if (mx < mat[i][j]) {
                mx = mat[i][j];
                idx = j;
            }
        }
        return idx;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int j = getMaxCol(mat, mid);
            if (mid < m - 1 && mat[mid][j] <= mat[mid + 1][j]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return new int[]{l, getMaxCol(mat, l)};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
