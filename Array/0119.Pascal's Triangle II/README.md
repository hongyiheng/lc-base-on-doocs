# [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负索引 <code>rowIndex</code>，返回「杨辉三角」的第 <code>rowIndex</code><em> </em>行。</p>

<p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> rowIndex = 3
<strong>输出:</strong> [1,3,3,1]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> rowIndex = 0
<strong>输出:</strong> [1]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> rowIndex = 1
<strong>输出:</strong> [1,1]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>0 <= rowIndex <= 33</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong></p>

<p>你可以优化你的算法到 <code><em>O</em>(<i>rowIndex</i>)</code> 空间复杂度吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        q = [1] * 2
        while len(q) < rowIndex + 1:
            nq = [1] * (len(q) + 1)
            for i in range(1, len(q)):
                nq[i] = q[i - 1] + q[i]
            q = nq
        return q
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> q = Arrays.asList(1, 1);
        while (q.size() < rowIndex + 1) {
            List<Integer> nq = new ArrayList<>();
            nq.add(1);
            for (int i = 1; i < q.size(); i++) {
                nq.add(q.get(i - 1) + q.get(i));
            }
            nq.add(1);
            q = nq;
        }
        return q;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
