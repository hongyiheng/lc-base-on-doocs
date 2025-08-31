# [36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku)



## 题目描述

<!-- 这里写题目描述 -->

<p>请你判断一个 <code>9x9</code> 的数独是否有效。只需要<strong> 根据以下规则</strong> ，验证已经填入的数字是否有效即可。</p>

<ol>
	<li>数字 <code>1-9</code> 在每一行只能出现一次。</li>
	<li>数字 <code>1-9</code> 在每一列只能出现一次。</li>
	<li>数字 <code>1-9</code> 在每一个以粗实线分隔的 <code>3x3</code> 宫内只能出现一次。（请参考示例图）</li>
</ol>

<p>数独部分空格内已填入了数字，空白格用 <code>'.'</code> 表示。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>一个有效的数独（部分已被填充）不一定是可解的。</li>
	<li>只需要根据以上规则，验证已经填入的数字是否有效即可。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>
<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/04/12/250px-sudoku-by-l2g-20050714svg.png" style="height:250px; width:250px" />
<pre>
<strong>输入：</strong>board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
<strong>输出：</strong>false
<strong>解释：</strong>除了第一行的第一个数字从<strong> 5</strong> 改为 <strong>8 </strong>以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>board.length == 9</code></li>
	<li><code>board[i].length == 9</code></li>
	<li><code>board[i][j]</code> 是一位数字或者 <code>'.'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row, col, box = defaultdict(set), defaultdict(set), defaultdict(set)
        for i, r in enumerate(board):
            for j, v in enumerate(r):
                if v == '.':
                    continue
                if v in row[i]:
                    return False
                if v in col[j]:
                    return False
                if v in box[i // 3 * 3 + j // 3]:
                    return False
                row[i].add(v)
                col[j].add(v)
                box[i // 3 * 3 + j // 3].add(v)
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>(), col = new HashMap<>(), box = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char v = board[i][j];
                if (v == '.') {
                    continue;
                }
                Set<Character> r = row.getOrDefault(i, new HashSet<>());
                Set<Character> c = col.getOrDefault(j, new HashSet<>());
                Set<Character> b = box.getOrDefault(i / 3 * 3 + j / 3, new HashSet<>());
                if (r.contains(v) || c.contains(v) || b.contains(v)) {
                    return false;
                }
                r.add(v);
                c.add(v);
                b.add(v);
                row.put(i, r);
                col.put(j, c);
                box.put(i / 3 * 3 + j / 3, b);
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
