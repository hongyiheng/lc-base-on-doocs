# [419. 甲板上的战舰](https://leetcode-cn.com/problems/battleships-in-a-board)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二维的甲板， 请计算其中有多少艘战舰。&nbsp;战舰用&nbsp;<code>&#39;X&#39;</code>表示，空位用&nbsp;<code>&#39;.&#39;</code>表示。&nbsp;你需要遵守以下规则：</p>

<ul>
	<li>给你一个有效的甲板，仅由战舰或者空位组成。</li>
	<li>战舰只能水平或者垂直放置。换句话说,战舰只能由&nbsp;<code>1xN</code> (1 行, N 列)组成，或者&nbsp;<code>Nx1</code> (N 行, 1 列)组成，其中N可以是任意大小。</li>
	<li>两艘战舰之间至少有一个水平或垂直的空位分隔&nbsp;- 即没有相邻的战舰。</li>
</ul>

<p><strong>示例 :</strong></p>

<pre>
X..X
...X
...X
</pre>

<p>在上面的甲板中有2艘战舰。</p>

<p><strong>无效样例 :</strong></p>

<pre>
...X
XXXX
...X
</pre>

<p>你不会收到这样的无效甲板&nbsp;- 因为战舰之间至少会有一个空位将它们分开。</p>

<p><strong>进阶:</strong></p>

<p>你可以用<strong>一次扫描算法</strong>，只使用<strong>O(1)额外空间，</strong>并且<strong>不修改</strong>甲板的值来解决这个问题吗？</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        def find(x):
            if p[x] != x:
                p[x] = find(x)
            return p[x]
        
        def union(a, b):
            p[find(b)] = find(a)
        
        m, n = len(board), len(board[0])
        p = [i for i in range(m * n)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == '.':
                    continue
                if i and board[i - 1][j] == 'X':
                    union(i * n + j, (i - 1) * n + j)
                if j and board[i][j - 1] == 'X':
                    union(i * n + j, i * n + j - 1)
        ans = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'X' and p[i * n + j] == i * n + j:
                    ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    } 
    
    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        p = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    union(i * n + j, (i - 1) * n + j);
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    union(i * n + j, i * n + j - 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && p[i * n + j] == i * n + j) {
                    ans++;
                }
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
