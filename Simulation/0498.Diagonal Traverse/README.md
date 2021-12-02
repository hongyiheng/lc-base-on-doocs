# [498. 对角线遍历](https://leetcode-cn.com/problems/diagonal-traverse)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

<strong>输出:</strong>  [1,2,4,7,5,3,6,8,9]

<strong>解释:</strong>
<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/diagonal_traverse.png" style="width: 220px;">
</pre>

<p>&nbsp;</p>

<p><strong>说明:</strong></p>

<ol>
	<li>给定矩阵中的元素总数不会超过 100000 。</li>
</ol>


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
    public int[] findDiagonalOrder(int[][] mat) {
        int[] up = new int[]{-1, 1};
        int[] down = new int[]{1, -1};
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, index = 0;
        boolean flag = true;
        while (true) {
            if (i < 0 || i > m - 1 || j < 0 || j > n -1) {
                flag = !flag;
            }
            if (i > m - 1) {
                j += 2;
            }
            if (j > n - 1) {
                i += 2;
            }
            i = Math.max(0, i);
            j = Math.max(0, j);
            i = Math.min(m - 1, i);
            j = Math.min(n - 1, j);
            res[index++] = mat[i][j];
            if (i == m - 1 && j == n - 1) {
                break;
            }
            if (flag) {
                i += up[0];
                j += up[1];
            } else {
                i += down[0];
                j += down[1];
            }
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
