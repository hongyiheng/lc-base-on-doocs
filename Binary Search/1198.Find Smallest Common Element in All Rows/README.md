# [1198. 找出所有行中最小公共元素](https://leetcode-cn.com/problems/find-smallest-common-element-in-all-rows)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个矩阵 <code>mat</code>，其中每一行的元素都已经按 <strong>严格递增</strong> 顺序排好了。请你帮忙找出在所有这些行中 <strong>最小的公共元素</strong>。</p>

<p>如果矩阵中没有这样的公共元素，就请返回 <code>-1</code>。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
<strong>输出：</strong>5
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= mat.length, mat[i].length <= 500</code></li>
	<li><code>1 <= mat[i][j] <= 10^4</code></li>
	<li><code>mat[i]</code> 已按严格递增顺序排列。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])

        def exist_num(target):
            for i in range(1, m):
                left, right = 0, n - 1
                while left < right:
                    mid = (left + right) >> 1
                    if mat[i][mid] < target:
                        left = mid + 1
                    else:
                        right = mid
                if mat[i][left] != target:
                    return False
            return True
        
        for v in mat[0]:
            if exist_num(v):
                return v
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int m, n;
    int[][] mat;

    public int smallestCommonElement(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        this.mat = mat;
        for (int v : mat[0]) {
            if (existNum(v)) {
                return v;
            }
        }
        return -1;
    }

    public boolean existNum(int target) {
        for (int i = 1; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (mat[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (mat[i][left] != target) {
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
