# [378. 有序矩阵中第 K 小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <code>n x n</code><em> </em>矩阵 <code>matrix</code> ，其中每行和每列元素均按升序排序，找到矩阵中第 <code>k</code> 小的元素。<br />
请注意，它是 <strong>排序后</strong> 的第 <code>k</code> 小元素，而不是第 <code>k</code> 个 <strong>不同</strong> 的元素。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
<strong>输出：</strong>13
<strong>解释：</strong>矩阵中的元素为 [1,5,9,10,11,12,13,<strong>13</strong>,15]，第 8 小元素是 13
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[-5]], k = 1
<strong>输出：</strong>-5
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 <= n <= 300</code></li>
	<li><code>-10<sup>9</sup> <= matrix[i][j] <= 10<sup>9</sup></code></li>
	<li>题目数据 <strong>保证</strong> <code>matrix</code> 中的所有行和列都按 <strong>非递减顺序</strong> 排列</li>
	<li><code>1 <= k <= n<sup>2</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        p = list()
        for i in range(m):
            for j in range(n):
                p.append(matrix[i][j])
        list.sort(p)
        return p[k - 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p.add(matrix[i][j]);
            }
        }
        Collections.sort(p);
        return p.get(k - 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
