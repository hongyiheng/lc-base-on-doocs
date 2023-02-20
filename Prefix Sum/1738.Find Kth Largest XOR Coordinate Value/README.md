# [1738. 找出第 K 大的异或坐标值](https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二维矩阵 <code>matrix</code> 和一个整数 <code>k</code> ，矩阵大小为 <code>m x n</code> 由非负整数组成。</p>

<p>矩阵中坐标 <code>(a, b)</code> 的 <strong>值</strong> 可由对所有满足 <code>0 &lt;= i &lt;= a &lt; m</code> 且 <code>0 &lt;= j &lt;= b &lt; n</code> 的元素 <code>matrix[i][j]</code>（<strong>下标从 0 开始计数</strong>）执行异或运算得到。</p>

<p>请你找出 <code>matrix</code> 的所有坐标中第 <code>k</code> 大的值（<strong><code>k</code> 的值从 1 开始计数</strong>）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>matrix = [[5,2],[1,6]], k = 1
<strong>输出：</strong>7
<strong>解释：</strong>坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>matrix = [[5,2],[1,6]], k = 2
<strong>输出：</strong>5
<strong>解释：</strong>坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>matrix = [[5,2],[1,6]], k = 3
<strong>输出：</strong>4
<strong>解释：</strong>坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>matrix = [[5,2],[1,6]], k = 4
<strong>输出：</strong>0
<strong>解释：</strong>坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>0 &lt;= matrix[i][j] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= m * n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        f = [[0] * n for _ in range(m)]
        q = []
        for i in range(m):
            for j in range(n):
                v = matrix[i][j]
                if i > 0:
                    v ^= f[i - 1][j]
                if j > 0:
                    v ^= f[i][j - 1]
                if i > 0 and j > 0:
                    v ^= f[i - 1][j - 1]
                f[i][j] = v
                q.append(v)
        q.sort(reverse=True)
        return q[k - 1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (i > 0) {
                    v ^= f[i - 1][j];
                }
                if (j > 0) {
                    v ^= f[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    v ^= f[i - 1][j - 1];
                }
                f[i][j] = v;
                q.add(v);
            }
        }
        Collections.sort(q, Comparator.reverseOrder());
        return q.get(k - 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
