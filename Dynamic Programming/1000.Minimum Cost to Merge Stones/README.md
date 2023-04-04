# [1000. 合并石头的最低成本](https://leetcode-cn.com/problems/minimum-cost-to-merge-stones)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>N</code> 堆石头排成一排，第 <code>i</code> 堆中有&nbsp;<code>stones[i]</code>&nbsp;块石头。</p>

<p>每次<em>移动（move）</em>需要将<strong>连续的</strong>&nbsp;<code>K</code>&nbsp;堆石头合并为一堆，而这个移动的成本为这&nbsp;<code>K</code>&nbsp;堆石头的总数。</p>

<p>找出把所有石头合并成一堆的最低成本。如果不可能，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>stones = [3,2,4,1], K = 2
<strong>输出：</strong>20
<strong>解释：</strong>
从 [3, 2, 4, 1] 开始。
合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
合并 [4, 1]，成本为 5，剩下 [5, 5]。
合并 [5, 5]，成本为 10，剩下 [10]。
总成本 20，这是可能的最小值。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>stones = [3,2,4,1], K = 3
<strong>输出：</strong>-1
<strong>解释：</strong>任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>stones = [3,5,1,2,6], K = 3
<strong>输出：</strong>25
<strong>解释：</strong>
从 [3, 5, 1, 2, 6] 开始。
合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
合并 [3, 8, 6]，成本为 17，剩下 [17]。
总成本 25，这是可能的最小值。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= stones.length &lt;= 30</code></li>
	<li><code>2 &lt;= K &lt;= 30</code></li>
	<li><code>1 &lt;= stones[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n - 1) % (k - 1):
            return -1
        s = [0] * (n + 1)
        for i in range(n):
            s[i + 1] = s[i] + stones[i]
        f = [[0x3f3f3f3f] * n for _ in range(n)]
        for i in range(n):
            f[i][i] = 0
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                for o in range(i, j, k - 1):
                    f[i][j] = min(f[i][j], f[i][o] + f[o + 1][j])
                if (j - i) % (k - 1) == 0:
                    f[i][j] += s[j + 1] - s[i]
        return f[0][-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
            f[i][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int o = i; o < j; o += k - 1) {
                    f[i][j] = Math.min(f[i][j], f[i][o] + f[o + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    f[i][j] += s[j + 1] - s[i];
                }
            }
        }
        return f[0][n - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
