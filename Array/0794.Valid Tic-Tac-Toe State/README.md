# [794. 有效的井字游戏](https://leetcode-cn.com/problems/valid-tic-tac-toe-state)



## 题目描述

<!-- 这里写题目描述 -->

<p>用字符串数组作为井字游戏的游戏板&nbsp;<code>board</code>。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。</p>

<p>该游戏板是一个 3 x 3 数组，由字符&nbsp;<code>&quot; &quot;</code>，<code>&quot;X&quot;</code>&nbsp;和&nbsp;<code>&quot;O&quot;</code>&nbsp;组成。字符&nbsp;<code>&quot; &quot;</code>&nbsp;代表一个空位。</p>

<p>以下是井字游戏的规则：</p>

<ul>
	<li>玩家轮流将字符放入空位（&quot; &quot;）中。</li>
	<li>第一个玩家总是放字符 &ldquo;X&rdquo;，且第二个玩家总是放字符 &ldquo;O&rdquo;。</li>
	<li>&ldquo;X&rdquo; 和 &ldquo;O&rdquo; 只允许放置在空位中，不允许对已放有字符的位置进行填充。</li>
	<li>当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。</li>
	<li>当所有位置非空时，也算为游戏结束。</li>
	<li>如果游戏结束，玩家不允许再放置字符。</li>
</ul>

<pre>
<strong>示例 1:</strong>
<strong>输入:</strong> board = [&quot;O&nbsp; &quot;, &quot;&nbsp; &nbsp;&quot;, &quot;&nbsp; &nbsp;&quot;]
<strong>输出:</strong> false
<strong>解释:</strong> 第一个玩家总是放置&ldquo;X&rdquo;。

<strong>示例 2:</strong>
<strong>输入:</strong> board = [&quot;XOX&quot;, &quot; X &quot;, &quot;   &quot;]
<strong>输出:</strong> false
<strong>解释:</strong> 玩家应该是轮流放置的。

<strong>示例 3:</strong>
<strong>输入:</strong> board = [&quot;XXX&quot;, &quot;   &quot;, &quot;OOO&quot;]
<strong>输出:</strong> false

<strong>示例 4:</strong>
<strong>输入:</strong> board = [&quot;XOX&quot;, &quot;O O&quot;, &quot;XOX&quot;]
<strong>输出:</strong> true
</pre>

<p><strong>说明:</strong></p>

<ul>
	<li>游戏板&nbsp;<code>board</code>&nbsp;是长度为 3 的字符串数组，其中每个字符串&nbsp;<code>board[i]</code>&nbsp;的长度为&nbsp;3。</li>
	<li>&nbsp;<code>board[i][j]</code>&nbsp;是集合&nbsp;<code>{&quot; &quot;, &quot;X&quot;, &quot;O&quot;}</code>&nbsp;中的一个字符。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        x_count, o_count = 0, 0
        matrix = [[0 for _ in range(3)] for _ in range(3)]
        for i, v in enumerate(board):
            for j in range(len(v)):
                if v[j] == 'X':
                    x_count += 1
                    matrix[i][j] = 1
                elif v[j] == 'O':
                    o_count += 1
                    matrix[i][j] = 2
        if o_count > x_count:
            return False
        win = set()
        for i in range(3):
            if matrix[i][0] == matrix[i][1] and matrix[i][0] == matrix[i][2]:
                if matrix[i][0] != 0:
                    win.add(matrix[i][0])
            if matrix[0][i] == matrix[1][i] and matrix[0][i] == matrix[2][i]:
                if matrix[0][i] != 0:
                    win.add(matrix[0][i])
        if matrix[0][0] == matrix[1][1] and matrix[0][0] == matrix[2][2]:
            if matrix[0][0] != 0:
                win.add(matrix[0][0])
        if matrix[0][2] == matrix[1][1] and matrix[0][2] == matrix[2][0]:
            if matrix[0][2] != 0:
                win.add(matrix[0][2])
        if 1 in win and 2 in win:
            return False
        elif 1 in win:
            return x_count - o_count == 1
        elif 2 in win:
            return x_count == o_count
        return x_count - o_count <= 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        int[][] matrix = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    xCount++;
                    matrix[i][j] = 1;
                } else if (c == 'O') {
                    oCount++;
                    matrix[i][j] = 2;
                }
            }
        }
        if (oCount > xCount) {
            return false;
        }
        Set<Integer> win = getWin(matrix);
        if (win.contains(1) && win.contains(2)) {
            return false;
        } else if (win.contains(2)) {
            return xCount == oCount;
        } else if (win.contains(1)) {
            return xCount - oCount == 1;
        }
        return xCount - oCount <= 1;
    }

    public Set<Integer> getWin(int[][] matrix) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
                if (matrix[i][0] != 0) {
                    res.add(matrix[i][0]);
                }
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i]) {
                if (matrix[0][i] != 0) {
                    res.add(matrix[0][i]);
                }
            }
        }
        if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
            if (matrix[0][0] != 0) {
                res.add(matrix[0][0]);
            }
        }
        if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]) {
            if (matrix[0][2] != 0) {
                res.add(matrix[0][2]);
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
