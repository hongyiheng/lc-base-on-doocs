# [987. 二叉树的垂序遍历](https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你二叉树的根结点 <code>root</code> ，请你设计算法计算二叉树的<em> </em><strong>垂序遍历</strong> 序列。</p>

<p>对位于 <code>(row, col)</code> 的每个结点而言，其左右子结点分别位于 <code>(row + 1, col - 1)</code> 和 <code>(row + 1, col + 1)</code> 。树的根结点位于 <code>(0, 0)</code> 。</p>

<p>二叉树的 <strong>垂序遍历</strong> 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。</p>

<p>返回二叉树的 <strong>垂序遍历</strong> 序列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree1.jpg" style="width: 431px; height: 304px;" />
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[9],[3,15],[20],[7]]
<strong>解释：</strong>
列 -1 ：只有结点 9 在此列中。
列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
列  1 ：只有结点 20 在此列中。
列  2 ：只有结点 7 在此列中。</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree2.jpg" style="width: 512px; height: 304px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,4,5,6,7]
<strong>输出：</strong>[[4],[2],[1,5,6],[3],[7]]
<strong>解释：</strong>
列 -2 ：只有结点 4 在此列中。
列 -1 ：只有结点 2 在此列中。
列  0 ：结点 1 、5 和 6 都在此列中。
          1 在上面，所以它出现在前面。
          5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
列  1 ：只有结点 3 在此列中。
列  2 ：只有结点 7 在此列中。
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree3.jpg" style="width: 512px; height: 304px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,4,6,5,7]
<strong>输出：</strong>[[4],[2],[1,5,6],[3],[7]]
<strong>解释：</strong>
这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中结点数目总数在范围 <code>[1, 1000]</code> 内</li>
	<li><code>0 <= Node.val <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        M, N = 1010, 2010
        g = [[None] * N for _ in range(M)]
        q = deque()
        q.append((0, 1000, root))
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                x, y, node = cur[0], cur[1], cur[2]
                if not g[x][y]:
                    g[x][y] = []
                heapq.heappush(g[x][y], node.val)
                if node.left:
                    q.append((x + 1, y - 1, node.left))
                if node.right:
                    q.append((x + 1, y + 1, node.right))
        ans = []
        for j in range(N):
            col = []
            for i in range(M):
                while g[i][j]:
                    col.append(heapq.heappop(g[i][j]))
            if col:
                ans.append(col)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int M = 1010, N = 2010;
        PriorityQueue<Integer>[][] g = new PriorityQueue[M][N];
        Deque<Pair<int[], TreeNode>> q = new ArrayDeque<>();
        q.addLast(new Pair(new int[]{0, 1000}, root));
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                Pair<int[], TreeNode> cur = q.pollFirst();
                int x = cur.getKey()[0], y = cur.getKey()[1];
                TreeNode node = cur.getValue();
                if (g[x][y] == null) {
                    g[x][y] = new PriorityQueue();
                }
                g[x][y].add(node.val);
                if (node.left != null) {
                    q.addLast(new Pair(new int[]{x + 1, y - 1}, node.left));
                }
                if (node.right != null) {
                    q.addLast(new Pair(new int[]{x + 1, y + 1}, node.right));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (g[i][j] != null) {
                    while (!g[i][j].isEmpty()) {
                        col.add(g[i][j].poll());
                    }   
                }
            }
            if (!col.isEmpty()) {
                ans.add(col);
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
