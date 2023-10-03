# [1386. 安排电影院座位](https://leetcode-cn.com/problems/cinema-seat-allocation)



## 题目描述

<!-- 这里写题目描述 -->

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/21/cinema_seats_1.png" style="height: 149px; width: 400px;"></p>

<p>如上图所示，电影院的观影厅中有 <code>n</code>&nbsp;行座位，行编号从 1&nbsp;到 <code>n</code>&nbsp;，且每一行内总共有 10 个座位，列编号从 1 到 10 。</p>

<p>给你数组&nbsp;<code>reservedSeats</code>&nbsp;，包含所有已经被预约了的座位。比如说，<code>researvedSeats[i]=[3,8]</code>&nbsp;，它表示第&nbsp;<strong>3</strong>&nbsp;行第&nbsp;<strong>8</strong>&nbsp;个座位被预约了。</p>

<p>请你返回&nbsp;<strong>最多能安排多少个 4 人家庭</strong>&nbsp;。4 人家庭要占据&nbsp;<strong>同一行内连续&nbsp;</strong>的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/21/cinema_seats_3.png" style="height: 96px; width: 400px;"></p>

<pre><strong>输入：</strong>n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
<strong>输出：</strong>4
<strong>解释：</strong>上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10^9</code></li>
	<li><code>1 &lt;=&nbsp;reservedSeats.length &lt;= min(10*n, 10^4)</code></li>
	<li><code>reservedSeats[i].length == 2</code></li>
	<li><code>1&nbsp;&lt;=&nbsp;reservedSeats[i][0] &lt;= n</code></li>
	<li><code>1 &lt;=&nbsp;reservedSeats[i][1] &lt;= 10</code></li>
	<li>所有&nbsp;<code>reservedSeats[i]</code> 都是互不相同的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
      M = (1 << 11) - 1
      L = MID = R = 0
      for i in range(2, 6):
          L |= 1 << i
          MID |= 1 << (i + 2)
          R |= 1 << (i + 4)

      g = dict()
      for i, j in reservedSeats:
          g[i] = g.get(i, M) ^ (1 << j)
      ans = 2 * n
      for v in g.values():
          l = v & L == L
          r = v & R == R
          mid = v & MID == MID
          if l and r:
              continue
          if l or r or mid:
              ans -= 1
          else:
              ans -= 2
      return ans
              

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
      int M = (1 << 11) - 1;
      int L = 0, MID = 0, R = 0;
      for (int i = 2; i < 6; i++) {
          L |= 1 << i;
          MID |= 1 << (i + 2);
          R |= 1 << (i + 4);
      }
      Map<Integer, Integer> g = new HashMap<>();
      for (int[] e : reservedSeats) {
          g.put(e[0], g.getOrDefault(e[0], M) ^ (1 << e[1]));
      }
      int ans = 2 * n;
      for (int v : g.values()) {
          boolean l = (v & L) == L, mid = (v & MID) == MID, r = (v & R) == R;
          if (l && r) {
              continue;
          }
          if (l || mid || r) {
              ans--;
          } else {
              ans -= 2;
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
