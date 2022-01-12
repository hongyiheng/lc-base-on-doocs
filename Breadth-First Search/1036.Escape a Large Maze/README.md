# [1036. 逃离大迷宫](https://leetcode-cn.com/problems/escape-a-large-maze)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个 10<sup>6</sup> x 10<sup>6</sup> 的网格中，每个网格上方格的坐标为 <code>(x, y)</code> 。</p>

<p>现在从源方格 <code>source = [s<sub>x</sub>, s<sub>y</sub>]</code> 开始出发，意图赶往目标方格 <code>target = [t<sub>x</sub>, t<sub>y</sub>]</code> 。数组 <code>blocked</code> 是封锁的方格列表，其中每个 <code>blocked[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 表示坐标为 <code>(x<sub>i</sub>, y<sub>i</sub>)</code> 的方格是禁止通行的。</p>

<p>每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 <strong>不</strong> 在给出的封锁列表 <code>blocked</code> 上。同时，不允许走出网格。</p>

<p>只有在可以通过一系列的移动从源方格 <code>source</code> 到达目标方格 <code>target</code> 时才返回 <code>true</code>。否则，返回 <code>false</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
<strong>输出：</strong>false
<strong>解释：</strong>
从源方格无法到达目标方格，因为我们无法在网格中移动。
无法向北或者向东移动是因为方格禁止通行。
无法向南或者向西移动是因为不能走出网格。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>blocked = [], source = [0,0], target = [999999,999999]
<strong>输出：</strong>true
<strong>解释：</strong>
因为没有方格被封锁，所以一定可以到达目标方格。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= blocked.length <= 200</code></li>
	<li><code>blocked[i].length == 2</code></li>
	<li><code>0 <= x<sub>i</sub>, y<sub>i</sub> < 10<sup>6</sup></code></li>
	<li><code>source.length == target.length == 2</code></li>
	<li><code>0 <= s<sub>x</sub>, s<sub>y</sub>, t<sub>x</sub>, t<sub>y</sub> < 10<sup>6</sup></code></li>
	<li><code>source != target</code></li>
	<li>题目数据保证 <code>source</code> 和 <code>target</code> 不在封锁列表内</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        edge, P, n = 1e6, 131, len(blocked)
        blocked_set = set()
        dirs = [[1, 0], [0, 1], [0, -1], [-1, 0]]
        for v in blocked:
            blocked_set.add(v[0] * P + v[1])
        max_area = n * n

        def dfs(a, b):
            visited, stk = set(), []
            stk.append(a)
            visited.add(a[0] * P + a[1])
            while stk and len(visited) <= max_area:
                cur = stk.pop()
                if cur[0] == b[0] and cur[1] == b[1]:
                    return True
                for v in dirs:
                    x = cur[0] + v[0]
                    y = cur[1] + v[1]
                    if x < 0 or x >= edge or y < 0 or y >= edge:
                        continue
                    hash_val = x * P + y
                    if hash_val in blocked_set:
                        continue
                    if hash_val in visited:
                        continue
                    stk.append([x, y])
                    visited.add(hash_val)
            return len(visited) > max_area

        return dfs(source, target) and dfs(target, source)

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int edge = (int)1e6, maxArea = 0;
    Set<Long> blockedSet = new HashSet<>();
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    long P = 131L;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        maxArea = n * n;
        for (int[] item : blocked) {
            blockedSet.add(item[0] * P + item[1]);
        }
        return bfs(source, target) && bfs(target, source);
    }

    public boolean bfs(int[] a, int[] b) {
        Deque<int[]> stk = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        stk.addLast(a);
        visited.add(a[0] * P + a[1]);
        while (!stk.isEmpty() && visited.size() <= maxArea) {
            int[] cur = stk.pollLast();
            if (cur[0] == b[0] && cur[1] == b[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= edge || y < 0 || y >= edge) {
                    continue;
                }
                long hashV = x * P + y;
                if (blockedSet.contains(hashV)) {
                    continue;
                }
                if (visited.contains(hashV)) {
                    continue;
                }
                visited.add(hashV);
                stk.addLast(new int[]{x, y});
            }
        }
        return visited.size() > maxArea;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
