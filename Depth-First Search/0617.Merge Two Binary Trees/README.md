# [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。</p>

<p>你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则<strong>不为&nbsp;</strong>NULL 的节点将直接作为新二叉树的节点。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
<strong>输出:</strong> 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
</pre>

<p><strong>注意:</strong>&nbsp;合并必须从两个树的根节点开始。</p>


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
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(a, b, cur):
            if not a and not b:
                return
            cur.val = (a.val if a else 0) + (b.val if b else 0)
            if (a and a.left) or (b and b.left):
                cur.left = TreeNode()
                dfs(a.left if a else None, b.left if b else None, cur.left)
            if (a and a.right) or (b and b.right):
                cur.right = TreeNode()
                dfs(a.right if a else None, b.right if b else None, cur.right)

        if not root1 and not root2:
            return None
        ans = TreeNode()
        dfs(root1, root2, ans)
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
    public void dfs(TreeNode a, TreeNode b, TreeNode cur) {
        if (a == null && b == null) {
            return;
        }
        cur.val = (a == null ? 0 : a.val) + (b == null ? 0 : b.val);
        if ((a != null && a.left != null) || (b != null && b.left != null)) {
            cur.left = new TreeNode();
            dfs(a == null ? null : a.left, b == null ? null : b.left, cur.left);
        }
        if ((a != null && a.right != null) || (b != null && b.right != null)) {
            cur.right = new TreeNode();
            dfs(a == null ? null : a.right, b == null ? null : b.right, cur.right);
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        dfs(root1, root2, root);
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
