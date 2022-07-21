# [814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定二叉树根结点 <code>root</code> ，此外树的每个结点的值要么是 0，要么是 1。</p>

<p>返回移除了所有不包含 1 的子树的原二叉树。</p>

<p>( 节点 X 的子树为 X 本身，以及所有 X 的后代。)</p>

<pre>
<strong>示例1:</strong>
<strong>输入:</strong> [1,null,0,0,1]
<strong>输出: </strong>[1,null,0,null,1]
 
<strong>解释:</strong> 
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_2.png" style="width:450px" />
</pre>

<pre>
<strong>示例2:</strong>
<strong>输入:</strong> [1,0,1,0,0,0,1]
<strong>输出: </strong>[1,null,1,null,1]


<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png" style="width:450px" />
</pre>

<pre>
<strong>示例3:</strong>
<strong>输入:</strong> [1,1,0,1,1,0,1,0]
<strong>输出: </strong>[1,1,0,1,1,null,1]


<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/05/1028.png" style="width:450px" />
</pre>

<p><strong>说明: </strong></p>

<ul>
	<li>给定的二叉树最多有 <code>200</code> 个节点。</li>
	<li>每个节点的值只会为 <code>0</code> 或 <code>1</code> 。</li>
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
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        if not root.left and not root.right and root.val == 0:
            return None
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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
