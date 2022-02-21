# [79. 单词搜索](https://leetcode-cn.com/problems/word-search)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个 <code>m x n</code> 二维字符网格 <code>board</code> 和一个字符串单词 <code>word</code> 。如果 <code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 <= m, n <= 6</code></li>
	<li><code>1 <= word.length <= 15</code></li>
	<li><code>board</code> 和 <code>word</code> 仅由大小写英文字母组成</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以使用搜索剪枝的技术来优化解决方案，使其在 <code>board</code> 更大的情况下可以更快解决问题？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        vis = [[False] * n for _ in range(m)]
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        def dfs(x, y, ne):
            nonlocal word, board, dirs, vis
            c = word[ne]
            if board[x][y] != c:
                return False
            if ne == len(word) - 1:
                return True
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if vis[nx][ny]:
                    continue
                vis[nx][ny] = True
                if dfs(nx, ny, ne + 1):
                    return True
                vis[nx][ny] = False
            return False


        root = word[0]
        for i in range(m):
            for j in range(n):
                if board[i][j] == root:
                    vis[i][j] = True
                    if dfs(i, j, 0):
                        return True
                    vis[i][j] = False
        return False
        
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    String word;
    char[][] board;
    boolean[][] vis;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        vis = new boolean[board.length][board[0].length];
        char root = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == root) {
                    vis[i][j] = true;
                    if (dfs(new int[]{i, j}, 0)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int[] cur, int nextIndex) {
        char c = word.charAt(nextIndex);
        if (board[cur[0]][cur[1]] != c) {
            return false;
        }
        if (nextIndex == word.length() - 1) {
            return true;
        }
        for (int[] d : dirs) {
            int nx = cur[0] + d[0], ny = cur[1] + d[1];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            if (vis[nx][ny]) {
                continue;
            }
            vis[nx][ny] = true;
            if (dfs(new int[]{nx, ny}, nextIndex + 1)) {
                return true;
            }
            vis[nx][ny] = false;
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
