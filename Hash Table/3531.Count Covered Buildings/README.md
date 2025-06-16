# [3531. 统计被覆盖的建筑](https://leetcode.cn/problems/count-covered-buildings)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code>，表示一个 <code>n x n</code> 的城市，同时给定一个二维数组 <code>buildings</code>，其中 <code>buildings[i] = [x, y]</code> 表示位于坐标 <code>[x, y]</code> 的一个&nbsp;<strong>唯一&nbsp;</strong>建筑。</p>

<p>如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑&nbsp;<strong>被覆盖&nbsp;</strong>。</p>

<p>返回&nbsp;<strong>被覆盖&nbsp;</strong>的建筑数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img src="https://pic.leetcode.cn/1745660407-qtNUjI-telegram-cloud-photo-size-5-6212982906394101085-m.jpg" style="width: 200px; height: 204px;" /></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]</span></p>

<p><strong>输出:</strong> <span class="example-io">1</span></p>

<p><strong>解释:</strong></p>

<ul>
	<li>只有建筑 <code>[2,2]</code> 被覆盖，因为它在每个方向上都至少存在一个建筑：

	<ul>
		<li>上方 (<code>[1,2]</code>)</li>
		<li>下方 (<code>[3,2]</code>)</li>
		<li>左方 (<code>[2,1]</code>)</li>
		<li>右方 (<code>[2,3]</code>)</li>
	</ul>
	</li>
	<li>因此，被覆盖的建筑数量是 1。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<p><img src="https://pic.leetcode.cn/1745660407-tUMUKl-telegram-cloud-photo-size-5-6212982906394101086-m.jpg" style="width: 200px; height: 204px;" /></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]</span></p>

<p><strong>输出:</strong> <span class="example-io">0</span></p>

<p><strong>解释:</strong></p>

<ul>
	<li>没有任何一个建筑在每个方向上都有至少一个建筑。</li>
</ul>
</div>

<p><strong class="example">示例 3：</strong></p>

<p><img src="https://pic.leetcode.cn/1745660407-bQIwBX-telegram-cloud-photo-size-5-6248862251436067566-x.jpg" style="width: 202px; height: 205px;" /></p>

<div class="example-block">
<p><strong>输入:</strong> <span class="example-io">n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]</span></p>

<p><strong>输出:</strong> <span class="example-io">1</span></p>

<p><strong>解释:</strong></p>

<ul>
	<li>只有建筑 <code>[3,3]</code> 被覆盖，因为它在每个方向上至少存在一个建筑：

	<ul>
		<li>上方 (<code>[1,3]</code>)</li>
		<li>下方 (<code>[5,3]</code>)</li>
		<li>左方 (<code>[3,2]</code>)</li>
		<li>右方 (<code>[3,5]</code>)</li>
	</ul>
	</li>
	<li>因此，被覆盖的建筑数量是 1。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= buildings.length &lt;= 10<sup>5</sup></code></li>
	<li><code>buildings[i] = [x, y]</code></li>
	<li><code>1 &lt;= x, y &lt;= n</code></li>
	<li><code>buildings</code> 中所有坐标均&nbsp;<strong>唯一&nbsp;</strong>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        ans = 0
        row, col = defaultdict(int), defaultdict(int)
        rowPos = [[0] * 2 for _ in range(n + 1)]
        colPos = [[0] * 2 for _ in range(n + 1)]
        for x, y in buildings:
            row[x] += 1
            col[y] += 1
            rowPos[x][0] = min((n if rowPos[x][0] == 0 else rowPos[x][0]), y)
            rowPos[x][1] = max(rowPos[x][1], y)
            colPos[y][0] = min((n if colPos[y][0] == 0 else colPos[y][0]), x)
            colPos[y][1] = max(colPos[y][1], x)
        for x, y in buildings:
            if y == rowPos[x][0] or y == rowPos[x][1]:
                continue
            if x == colPos[y][0] or x == colPos[y][1]:
                continue
            if row[x] >= 3 and col[y] >= 3:
                ans += 1
        return ans    
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        int[][] rowPos = new int[n + 1][2];
        int[][] colPos = new int[n + 1][2];
        for (int[] pos : buildings) {
            int x = pos[0], y = pos[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);

            rowPos[x][0] = Math.min(rowPos[x][0] == 0 ? n : rowPos[x][0], y);
            rowPos[x][1] = Math.max(rowPos[x][1], y);

            colPos[y][0] = Math.min(colPos[y][0] == 0 ? n : colPos[y][0], x);
            colPos[y][1] = Math.max(colPos[y][1], x);
        }
        for (int[] pos : buildings) {
            int x = pos[0], y = pos[1];
            if (y == rowPos[x][0] || y == rowPos[x][1]) {
                continue;
            }
            if (x == colPos[y][0] || x == colPos[y][1]) {
                continue;
            }
            if (row.get(x) >= 3 && col.get(y) >= 3) {
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
