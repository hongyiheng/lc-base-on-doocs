# [531. 孤独像素 I](https://leetcode-cn.com/problems/lonely-pixel-i)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一幅黑白像素组成的图像, 计算<strong>黑色</strong>孤独像素的数量。</p>

<p>图像由一个由&lsquo;B&rsquo;和&lsquo;W&rsquo;组成二维字符数组表示, &lsquo;B&rsquo;和&lsquo;W&rsquo;分别代表黑色像素和白色像素。</p>

<p>黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 
[[&#39;W&#39;, &#39;W&#39;, &#39;B&#39;],
 [&#39;W&#39;, &#39;B&#39;, &#39;W&#39;],
 [&#39;B&#39;, &#39;W&#39;, &#39;W&#39;]]

<strong>输出:</strong> 3
<strong>解析:</strong> 全部三个&#39;B&#39;都是黑色孤独像素。
</pre>

<p>&nbsp;</p>

<p><strong>注意:</strong></p>

<ol>
	<li>输入二维数组行和列的范围是 [1,500]。</li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        row, col = set(), set()
        ans = 0

        def check(x, y):
            nonlocal ans
            if x in row or y in col:
                return
            row.add(x)
            col.add(y)
            for i in range(len(picture)):
                if i == x:
                    continue
                if picture[i][y] == 'B':
                    return
            for j in range(len(picture[0])):
                if j == y:
                    continue
                if picture[x][j] == 'B':
                    return
            ans += 1
        
        for i in range(len(picture)):
            for j in range(len(picture[0])):
                if picture[i][j] == 'B':
                    check(i, j)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Set<Integer> row;
    Set<Integer> col;
    char[][] picture;
    int ans = 0;
    public int findLonelyPixel(char[][] picture) {
        this.picture = picture;
        row = new HashSet<>();
        col = new HashSet<>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    check(i, j);
                }
            }
        }
        return ans;
    }

    public void check(int x, int y) {
        if (row.contains(x) || col.contains(y)) {
            return; 
        } 
        row.add(x);
        col.add(y);
        for (int i = 0; i < picture.length; i++) {
            if (i == x) {
                continue;
            }
            if (picture[i][y] == 'B') {
                return;
            }
        }
        for (int j = 0; j < picture[0].length; j++) {
            if (j == y) {
                continue;
            }
            if (picture[x][j] == 'B') {
                return;
            }
        }
        ans++; 
    }
}
```

### **...**

```

```

<!-- tabs:end -->
