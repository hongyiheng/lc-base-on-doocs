# [1483. 树节点的第 K 个祖先](https://leetcode-cn.com/problems/kth-ancestor-of-a-tree-node)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵树，树上有 <code>n</code> 个节点，按从 <code>0</code> 到 <code>n-1</code> 编号。树以父节点数组的形式给出，其中 <code>parent[i]</code> 是节点 <code>i</code> 的父节点。树的根节点是编号为 <code>0</code> 的节点。</p>

<p>请你设计并实现 <code>getKthAncestor</code><code>(int node, int k)</code> 函数，函数返回节点 <code>node</code> 的第 <code>k</code> 个祖先节点。如果不存在这样的祖先节点，返回 <code>-1</code> 。</p>

<p>树节点的第 <em><code>k</code> </em>个祖先节点是从该节点到根节点路径上的第 <code>k</code> 个节点。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/06/14/1528_ex1.png" style="height: 262px; width: 396px;"></strong></p>

<pre><strong>输入：</strong>
[&quot;TreeAncestor&quot;,&quot;getKthAncestor&quot;,&quot;getKthAncestor&quot;,&quot;getKthAncestor&quot;]
[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]

<strong>输出：</strong>
[null,1,0,-1]

<strong>解释：</strong>
TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);

treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;=&nbsp;n &lt;= 5*10^4</code></li>
	<li><code>parent[0] == -1</code> 表示编号为 <code>0</code> 的节点是根节点。</li>
	<li>对于所有的 <code>0 &lt;&nbsp;i &lt; n</code> ，<code>0 &lt;= parent[i] &lt; n</code> 总成立</li>
	<li><code>0 &lt;= node &lt; n</code></li>
	<li>至多查询 <code>5*10^4</code> 次</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        self.p = [[-1] * 17 for _ in range(n)]
        for i, v in enumerate(parent):
            self.p[i][0] = v
        for i in range(n):
            for j in range(1, 17):
                if self.p[i][j - 1] == -1:
                    continue
                self.p[i][j] = self.p[self.p[i][j - 1]][j - 1]
            
    def getKthAncestor(self, node: int, k: int) -> int:
        for i in range(17):
            if k >> i & 1 and node != -1:
                node = self.p[node][i]
        return node



# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class TreeAncestor {

        int[][] p;

        public TreeAncestor(int n, int[] parent) {
            p = new int[n][17];
            for (int[] r : p) {
                Arrays.fill(r, -1);
            }
            for (int i = 0; i < n; i++) {
                p[i][0] = parent[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 17; j++) {
                    if (p[i][j - 1] == -1) {
                        continue;
                    }
                    p[i][j] = p[p[i][j - 1]][j - 1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i < 17; i++) {
                if ((k & (1 << i)) != 0 && node != -1) {
                    node = p[node][i];
                }
            }
            return node;
        }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
```

### **...**

```

```

<!-- tabs:end -->
