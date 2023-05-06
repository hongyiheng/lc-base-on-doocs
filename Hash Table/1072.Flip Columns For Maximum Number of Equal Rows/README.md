# [1072. 按列翻转得到最大值等行数](https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定由若干 0 和 1 组成的矩阵 <code>matrix</code>，从中选出任意数量的列并翻转其上的 <strong>每个 </strong>单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。</p>

<p>回经过一些翻转后，行与行之间所有值都相等的最大行数。</p>

<p> </p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[[0,1],[1,1]]
<strong>输出：</strong>1
<strong>解释：</strong>不进行翻转，有 1 行所有值都相等。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[[0,1],[1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>翻转第一列的值之后，这两行都由相等的值组成。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>[[0,0,0],[0,0,1],[1,1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>翻转前两列的值之后，后两行由相等的值组成。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 <= matrix.length <= 300</code></li>
	<li><code>1 <= matrix[i].length <= 300</code></li>
	<li>所有 <code>matrix[i].length</code> 都相等</li>
	<li><code>matrix[i][j]</code> 为 <code>0</code> 或 <code>1</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        mp = defaultdict(int)
        for i in range(m):
            q1, q2 = [], []
            for j in range(n):
                q1.append(str(matrix[i][j]))
                q2.append(str(matrix[i][j] ^ 1))
            mp["".join(q1)] += 1
            mp["".join(q2)] += 1
        return max(mp.values())
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s1.append(matrix[i][j]);
                s2.append(matrix[i][j] ^ 1);
            }
            mp.put(s1.toString(), mp.getOrDefault(s1.toString(), 0) + 1);
            mp.put(s2.toString(), mp.getOrDefault(s2.toString(), 0) + 1);
        }
        int ans = 0;
        for (int v : mp.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
