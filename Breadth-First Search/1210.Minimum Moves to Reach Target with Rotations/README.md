# [1210. 穿过迷宫的最少移动次数](https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations)



## 题目描述

<!-- 这里写题目描述 -->

<p>你还记得那条风靡全球的贪吃蛇吗？</p>

<p>我们在一个&nbsp;<code>n*n</code>&nbsp;的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（<code>(0, 0)</code>&nbsp;和&nbsp;<code>(0, 1)</code>）开始移动。我们用 <code>0</code> 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（<code>(n-1, n-2)</code>&nbsp;和&nbsp;<code>(n-1, n-1)</code>）。</p>

<p>每次移动，蛇可以这样走：</p>

<ul>
	<li>如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。</li>
	<li>如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。</li>
	<li>如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（<code>(r, c)</code>、<code>(r, c+1)</code>）移动到 （<code>(r, c)</code>、<code>(r+1, c)</code>）。<br>
	<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/28/image-2.png" style="height: 134px; width: 300px;"></li>
	<li>如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（<code>(r, c)</code>、<code>(r+1, c)</code>）移动到（<code>(r, c)</code>、<code>(r, c+1)</code>）。<br>
	<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/28/image-1.png" style="height: 121px; width: 300px;"></li>
</ul>

<p>返回蛇抵达目的地所需的最少移动次数。</p>

<p>如果无法到达目的地，请返回&nbsp;<code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/28/image.png" style="height: 439px; width: 400px;"></strong></p>

<pre><strong>输入：</strong>grid = [[0,0,0,0,0,1],
               [1,1,0,0,1,0],
&nbsp;              [0,0,0,0,1,1],
&nbsp;              [0,0,1,0,1,0],
&nbsp;              [0,1,1,0,0,0],
&nbsp;              [0,1,1,0,0,0]]
<strong>输出：</strong>11
<strong>解释：
</strong>一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>grid = [[0,0,1,1,1,1],
&nbsp;              [0,0,0,0,1,1],
&nbsp;              [1,1,0,0,0,1],
&nbsp;              [1,1,1,0,0,1],
&nbsp;              [1,1,1,0,0,1],
&nbsp;              [1,1,1,0,0,0]]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 100</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 1</code></li>
	<li>蛇保证从空单元格开始出发。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = deque()
        q.append((0, 1, 0))
        vis = set()
        vis.add((0, 1, 0))
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y, s = q.popleft()
                if x == m - 1 and y == n - 1 and s == 0:
                    return ans
                # 水平
                if s == 0:
                    # 右
                    if y + 1 < n and grid[x][y + 1] == 0:
                        if (x, y + 1, 0) not in vis:
                            q.append((x, y + 1, 0))
                            vis.add((x, y + 1, 0))
                    # 下
                    if x + 1 < m and grid[x + 1][y] == 0 and grid[x + 1][y - 1] == 0:
                        if (x + 1, y, 0) not in vis:
                            q.append((x + 1, y, 0))
                            vis.add((x + 1, y, 0))
                        # 顺 90
                        if (x + 1, y - 1, 1) not in vis:
                            q.append((x + 1, y - 1, 1))
                            vis.add((x + 1, y - 1, 1))
                # 垂直
                else:
                    # 右
                    if y + 1 < n and grid[x][y + 1] == 0 and grid[x - 1][y + 1] == 0:
                        if (x, y + 1, 1) not in vis:
                            q.append((x, y + 1, 1))
                            vis.add((x, y + 1, 1)) 
                        # 逆 90
                        if (x - 1, y + 1, 0) not in vis:
                            q.append((x - 1, y + 1, 0))
                            vis.add((x - 1, y + 1, 0))
                    # 下
                    if x + 1 < m and grid[x + 1][y] == 0:
                        if (x + 1, y, 1) not in vis:
                            q.append((x + 1, y, 1))
                            vis.add((x + 1, y, 1))
            ans += 1
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 1, 0});
        Set<String> vis = new HashSet<>();
        vis.add("0,1,0");
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1], s = cur[2];
                if (x == m - 1 && y == n - 1 && s == 0) {
                    return ans;
                }
                // 水平
                if (s == 0) {
                    // 右
                    if (y + 1 < n && grid[x][y + 1] == 0) {
                        if (!vis.contains(x + "," + (y + 1) + ",0")) {
                            q.addLast(new int[]{x, y + 1, 0});
                            vis.add(x + "," + (y + 1) + ",0");
                        }
                    }
                    // 下
                    if (x + 1 < m && grid[x + 1][y] == 0 && grid[x + 1][y - 1] == 0) {
                        if (!vis.contains((x + 1) + "," + y + ",0")) {
                            q.addLast(new int[]{x + 1, y, 0});
                            vis.add((x + 1) + "," + y + ",0");
                        }
                        // 顺 90
                        if (!vis.contains((x + 1) + "," + (y - 1) + ",1")) {
                            q.addLast(new int[]{x + 1, y - 1, 1});
                            vis.add((x + 1) + "," + (y - 1) + ",1");
                        }
                    }
                } else {
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x - 1][y + 1] == 0) {
                        if (!vis.contains(x + "," + (y + 1) + ",1")) {
                            q.add(new int[]{x, y + 1, 1});
                            vis.add(x + "," + (y + 1) + ",1");
                        }
                        // 逆 90
                        if (!vis.contains((x - 1) + "," + (y + 1) + ",0")) {
                            q.addLast(new int[]{x - 1, y + 1, 0});
                            vis.add((x - 1) + "," + (y + 1) + ",0");
                        }
                    }

                    // 下
                    if (x + 1 < m && grid[x + 1][y] == 0) {
                        if (!vis.contains((x + 1) + "," + y + ",1")) {
                            q.addLast(new int[]{x + 1, y, 1});
                            vis.add((x + 1) + "," + y + ",1");
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
