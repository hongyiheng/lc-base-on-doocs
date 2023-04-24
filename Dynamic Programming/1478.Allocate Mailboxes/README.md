# [1478. 安排邮筒](https://leetcode-cn.com/problems/allocate-mailboxes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个房屋数组<code>houses</code>&nbsp;和一个整数&nbsp;<code>k</code>&nbsp;，其中&nbsp;<code>houses[i]</code>&nbsp;是第 <code>i</code>&nbsp;栋房子在一条街上的位置，现需要在这条街上安排 <code>k</code>&nbsp;个邮筒。</p>

<p>请你返回每栋房子与离它最近的邮筒之间的距离的 <strong>最小 </strong>总和。</p>

<p>答案保证在 32 位有符号整数范围以内。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/06/13/sample_11_1816.png" style="height: 154px; width: 454px;"></p>

<pre><strong>输入：</strong>houses = [1,4,8,10,20], k = 3
<strong>输出：</strong>5
<strong>解释：</strong>将邮筒分别安放在位置 3， 9 和 20 处。
每个房子到最近邮筒的距离和为 |3-1| + |4-3| + |9-8| + |10-9| + |20-20| = 5 。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/06/13/sample_2_1816.png" style="height: 154px; width: 433px;"></strong></p>

<pre><strong>输入：</strong>houses = [2,3,5,12,18], k = 2
<strong>输出：</strong>9
<strong>解释：</strong>将邮筒分别安放在位置 3 和 14 处。
每个房子到最近邮筒距离和为 |2-3| + |3-3| + |5-3| + |12-14| + |18-14| = 9 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>houses = [7,4,6,1], k = 1
<strong>输出：</strong>8
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>houses = [3,6,14,10], k = 4
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == houses.length</code></li>
	<li><code>1 &lt;= n&nbsp;&lt;= 100</code></li>
	<li><code>1 &lt;= houses[i] &lt;= 10^4</code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
	<li>数组&nbsp;<code>houses</code>&nbsp;中的整数互不相同。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minDistance(self, houses: List[int], k: int) -> int:
        n = len(houses)
        cost = [[0] * n for _ in range(n)]
        houses.sort()
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                if j - i <= 2:
                    cost[i][j] = houses[j] - houses[i]
                else:
                    cost[i][j] = cost[i + 1][j - 1] + houses[j] - houses[i]
        f = [[0] * (k + 1) for _ in range(n)]
        for i in range(n):
            f[i][1] = cost[0][i]
        for i in range(n):
            for j in range(2, min(k + 1, i + 1)):
                f[i][j] = f[i][j - 1]
                for p in range(1, i + 1):
                    f[i][j] = min(f[i][j], f[i - p][j - 1] + cost[i - p + 1][i])
        return f[n - 1][k]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] cost = new int[n][n];
        for (int i = n - 2; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i <= 2) {
                    cost[i][j] = houses[j] - houses[i];
                } else {
                    cost[i][j] = cost[i + 1][j - 1] + houses[j] - houses[i];
                }
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            f[i][1] = cost[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                f[i][j] = f[i][j - 1];
                for (int p = 1; p <= i; p++) {
                    f[i][j] = Math.min(f[i][j], f[i - p][j - 1] + cost[i - p + 1][i]);
                }
            }
        }
        return f[n - 1][k];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
