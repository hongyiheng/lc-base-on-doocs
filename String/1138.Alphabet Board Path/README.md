# [1138. 字母板上的路径](https://leetcode-cn.com/problems/alphabet-board-path)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们从一块字母板上的位置&nbsp;<code>(0, 0)</code>&nbsp;出发，该坐标对应的字符为&nbsp;<code>board[0][0]</code>。</p>

<p>在本题里，字母板为<code>board = [&quot;abcde&quot;, &quot;fghij&quot;, &quot;klmno&quot;, &quot;pqrst&quot;, &quot;uvwxy&quot;, &quot;z&quot;]</code>，如下所示。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/07/28/azboard.png" style="width: 300px;"></p>

<p>我们可以按下面的指令规则行动：</p>

<ul>
	<li>如果方格存在，<code>&#39;U&#39;</code>&nbsp;意味着将我们的位置上移一行；</li>
	<li>如果方格存在，<code>&#39;D&#39;</code>&nbsp;意味着将我们的位置下移一行；</li>
	<li>如果方格存在，<code>&#39;L&#39;</code>&nbsp;意味着将我们的位置左移一列；</li>
	<li>如果方格存在，<code>&#39;R&#39;</code>&nbsp;意味着将我们的位置右移一列；</li>
	<li><code>&#39;!&#39;</code>&nbsp;会把在我们当前位置 <code>(r, c)</code> 的字符&nbsp;<code>board[r][c]</code>&nbsp;添加到答案中。</li>
</ul>

<p>（注意，字母板上只存在有字母的位置。）</p>

<p>返回指令序列，用最小的行动次数让答案和目标&nbsp;<code>target</code>&nbsp;相同。你可以返回任何达成目标的路径。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>target = &quot;leet&quot;
<strong>输出：</strong>&quot;DDR!UURRR!!DDD!&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>target = &quot;code&quot;
<strong>输出：</strong>&quot;RR!DDRR!UUL!R!&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= target.length &lt;= 100</code></li>
	<li><code>target</code>&nbsp;仅含有小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        x, y, m = 0, 0, 5
        ans = list()
        for c in target:
            v = ord(c) - ord('a')
            nx, ny = v // m, v % m
            if y > ny:
                ans.append((y - ny) * 'L')
            if x < nx:
                ans.append((nx - x) * 'D')
            if x > nx:
                ans.append((x - nx) * 'U')
            if y < ny:
                ans.append((ny - y) * 'R')
            ans.append('!')
            x, y = nx, ny
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String alphabetBoardPath(String target) {
        int m = 5, x = 0, y = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : target.toCharArray()) {
            int v = c - 'a';
            int nx = v / m, ny = v % m;
            if (x > nx) {
                for (int i = 0; i < x - nx; i++) {
                    ans.append('U');
                }
            }
            if (y > ny) {
                for (int i = 0; i < y - ny; i++) {
                    ans.append('L');
                }
            }
            if (x < nx) {
                for (int i = 0; i < nx - x; i++) {
                    ans.append('D');
                }
            }
            if (y < ny) {
                for (int i = 0; i < ny - y; i++) {
                    ans.append('R');
                }
            }
            ans.append('!');
            x = nx;
            y = ny;
        }
        return ans.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
