# [1104. 二叉树寻路](https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 <strong>逐行</strong> 依次按&nbsp;&ldquo;之&rdquo; 字形进行标记。</p>

<p>如下图所示，在奇数行（即，第一行、第三行、第五行&hellip;&hellip;）中，按从左到右的顺序进行标记；</p>

<p>而偶数行（即，第二行、第四行、第六行&hellip;&hellip;）中，按从右到左的顺序进行标记。</p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/tree.png" style="height: 138px; width: 300px;"></p>

<p>给你树上某一个节点的标号 <code>label</code>，请你返回从根节点到该标号为 <code>label</code> 节点的路径，该路径是由途经的节点标号所组成的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>label = 14
<strong>输出：</strong>[1,3,4,14]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>label = 26
<strong>输出：</strong>[1,2,6,10,26]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= label &lt;= 10^6</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        def get_p(cur, row):
            cur_min, cur_max = 1 << row, (1 << row + 1) - 1
            p_min, p_max = 1 << row - 1, (1 << row) - 1
            if row % 2 == 0:
                idx = cur_max - cur
                return p_min + idx // 2
            else:
                idx = cur - cur_min
                return p_max - idx // 2

        row = 0
        while label >= 1 << row:
            row += 1
        ans = [label]
        while label != 1:
            label = get_p(label, row - 1)
            ans.append(label)
            row -= 1
        return ans[::-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getParent(int cur, int row) {
        int curMin = 1 << row, curMax = (1 << row + 1) - 1;
        int pMin = 1 << row - 1, pMax = (1 << row) - 1;
        if (row % 2 == 0) {
            int idx = curMax - cur;
            return pMin + idx / 2;
        } else {
            int idx = cur - curMin;
            return pMax - idx / 2;
        }
    }

    public List<Integer> pathInZigZagTree(int label) {
        int row = 0;
        while (label >= (1 << row)) {
            row++;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        while (label != 1) {
            label = getParent(label, --row);
            ans.add(label);
        }
        Collections.reverse(ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
