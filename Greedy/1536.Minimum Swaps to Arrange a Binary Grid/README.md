# [1536. 排布二进制网格的最少交换次数](https://leetcode-cn.com/problems/minimum-swaps-to-arrange-a-binary-grid)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>n&nbsp;x n</code>&nbsp;的二进制网格&nbsp;<code>grid</code>，每一次操作中，你可以选择网格的&nbsp;<strong>相邻两行</strong>&nbsp;进行交换。</p>

<p>一个符合要求的网格需要满足主对角线以上的格子全部都是 <strong>0</strong>&nbsp;。</p>

<p>请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 <strong>-1</strong>&nbsp;。</p>

<p>主对角线指的是从&nbsp;<code>(1, 1)</code>&nbsp;到&nbsp;<code>(n, n)</code>&nbsp;的这些格子。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/08/02/fw.jpg" style="height: 141px; width: 750px;"></p>

<pre><strong>输入：</strong>grid = [[0,0,1],[1,1,0],[1,0,0]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/08/02/e2.jpg" style="height: 270px; width: 270px;"></p>

<pre><strong>输入：</strong>grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
<strong>输出：</strong>-1
<strong>解释：</strong>所有行都是一样的，交换相邻行无法使网格符合要求。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/08/02/e3.jpg" style="height: 210px; width: 210px;"></p>

<pre><strong>输入：</strong>grid = [[1,0,0],[1,1,0],[1,1,1]]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= n&nbsp;&lt;= 200</code></li>
	<li><code>grid[i][j]</code>&nbsp;要么是&nbsp;<code>0</code>&nbsp;要么是&nbsp;<code>1</code>&nbsp;。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = []
        for i in range(m):
            cnt = 0
            for j in range(n - 1, -1, -1):
                if grid[i][j]:
                    break
                cnt += 1
            q.append(cnt)
        ans = 0
        for i in range(n):
            if q[i] >= n - i - 1:
                continue
            j = i + 1
            while j < n:
                if q[j] >= n - i - 1:
                    break
                j += 1
            if j == n:
                return -1
            for k in range(j, i, -1):
                q[k], q[k - 1] = q[k - 1], q[k]
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minSwaps(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] q = new int[n];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                cnt++;
            }
            q[i] = cnt;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (q[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            while (j < n) {
                if (q[j] >= n - i - 1) {
                    break;
                }
                j++;
            }
            if (j == n) {
                return -1;
            }
            for (int k = j; k > i; k--) {
                int tmp = q[k];
                q[k] = q[k - 1];
                q[k - 1] = tmp;
                ans++;
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
