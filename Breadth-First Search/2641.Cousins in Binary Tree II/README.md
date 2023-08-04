# [2641. 二叉树的堂兄弟节点 II](https://leetcode-cn.com/problems/cousins-in-binary-tree-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵二叉树的根&nbsp;<code>root</code>&nbsp;，请你将每个节点的值替换成该节点的所有 <strong>堂兄弟节点值的和&nbsp;</strong>。</p>

<p>如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 <strong>堂兄弟</strong>&nbsp;。</p>

<p>请你返回修改值之后，树的根<em>&nbsp;</em><code>root</code><em>&nbsp;</em>。</p>

<p><strong>注意</strong>，一个节点的深度指的是从树根节点到这个节点经过的边数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/11/example11.png" style="width: 571px; height: 151px;" /></p>

<pre>
<b>输入：</b>root = [5,4,9,1,10,null,7]
<b>输出：</b>[0,0,0,7,7,null,11]
<b>解释：</b>上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
- 值为 5 的节点没有堂兄弟，所以值修改为 0 。
- 值为 4 的节点没有堂兄弟，所以值修改为 0 。
- 值为 9 的节点没有堂兄弟，所以值修改为 0 。
- 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
- 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
- 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/01/11/diagram33.png" style="width: 481px; height: 91px;" /></p>

<pre>
<b>输入：</b>root = [3,1,2]
<b>输出：</b>[0,0,0]
<b>解释：</b>上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
- 值为 3 的节点没有堂兄弟，所以值修改为 0 。
- 值为 1 的节点没有堂兄弟，所以值修改为 0 。
- 值为 2 的节点没有堂兄弟，所以值修改为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目的范围是&nbsp;<code>[1, 10<sup>5</sup>]</code> 。</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
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
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        root.val = 0
        q = deque([root])
        while q:
            s = 0
            for node in q:
                s += node.left.val if node.left else 0
                s += node.right.val if node.right else 0
            for _ in range(len(q)):
                cur = q.popleft()
                child_val = cur.left.val if cur.left else 0
                child_val += cur.right.val if cur.right else 0
                child_val = s - child_val
                if cur.left:
                    cur.left.val = child_val
                    q.append(cur.left)
                if cur.right:
                    cur.right.val = child_val
                    q.append(cur.right)
        return root

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
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int s = 0;
            for (TreeNode node : q) {
                s += node.left != null ? node.left.val : 0;
                s += node.right != null ? node.right.val : 0;
            }
            int m = q.size();
            for (int i = 0; i < m; i++) {
                TreeNode node = q.pollFirst();
                int childVal = node.left != null ? node.left.val : 0;
                childVal += node.right != null ? node.right.val : 0;
                childVal = s - childVal;
                if (node.left != null) {
                    node.left.val = childVal;
                    q.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = childVal;
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
