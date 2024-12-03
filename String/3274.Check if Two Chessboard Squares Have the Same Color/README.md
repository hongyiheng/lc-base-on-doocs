# [3274. 检查棋盘方格颜色是否相同](https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串 <code>coordinate1</code> 和 <code>coordinate2</code>，代表 <code>8 x 8</code> 国际象棋棋盘上的两个方格的坐标。</p>

<p>以下是棋盘的参考图。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/07/17/screenshot-2021-02-20-at-22159-pm.png" style="width: 400px; height: 396px;" /></p>

<p>如果这两个方格颜色相同，返回 <code>true</code>，否则返回 <code>false</code>。</p>

<p>坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">coordinate1 = "a1", coordinate2 = "c3"</span></p>

<p><strong>输出：</strong> <span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<p>两个方格均为黑色。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">coordinate1 = "a1", coordinate2 = "h3"</span></p>

<p><strong>输出：</strong> <span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<p>方格 <code>"a1"</code> 是黑色，而 <code>"h3"</code> 是白色。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>coordinate1.length == coordinate2.length == 2</code></li>
	<li><code>'a' &lt;= coordinate1[0], coordinate2[0] &lt;= 'h'</code></li>
	<li><code>'1' &lt;= coordinate1[1], coordinate2[1] &lt;= '8'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def checkTwoChessboards(self, coordinate1: str, coordinate2: str) -> bool:
        x1, y1, x2, y2 = ord(coordinate1[0]) - ord('a'), int(coordinate1[1]), ord(coordinate2[0]) - ord('a'), int(coordinate2[1])
        if x1 % 2 == x2 % 2:
            return y1 % 2 == y2 % 2
        return y1 % 2 != y2 % 2
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0) - 'a', y1 = coordinate1.charAt(1) - '1';
        int x2 = coordinate2.charAt(0) - 'a', y2 = coordinate2.charAt(1) - '1';
        if (x1 % 2 == x2 % 2) {
            return y1 % 2 == y2 % 2;
        }
        return y1 % 2 != y2 % 2;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
