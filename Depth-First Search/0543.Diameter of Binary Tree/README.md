# [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。</p>

<p>&nbsp;</p>

<p><strong>示例 :</strong><br>
给定二叉树</p>

<pre>          1
         / \
        2   3
       / \     
      4   5    
</pre>

<p>返回&nbsp;<strong>3</strong>, 它的长度是路径 [4,2,1,3] 或者&nbsp;[5,2,1,3]。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong>两结点之间的路径长度是以它们之间边的数目表示。</p>


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
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        ans = 0
        if not root:
            return ans
        
        def dfs(root):
            nonlocal ans
            if not root.left and not root.right:
                return 0
            left = dfs(root.left) + 1 if root.left else 0
            right = dfs(root.right) + 1 if root.right else 0
            ans = max(ans, left + right)
            return max(left, right)
        
        dfs(root)
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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = root.left == null? 0: dfs(root.left) + 1;
        int right = root.right == null? 0: dfs(root.right) + 1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }  
    
}
```

### **...**

```

```

<!-- tabs:end -->
