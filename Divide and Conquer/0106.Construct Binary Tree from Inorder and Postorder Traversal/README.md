# [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)



## 题目描述

<!-- 这里写题目描述 -->

<p>根据一棵树的中序遍历与后序遍历构造二叉树。</p>

<p><strong>注意:</strong><br>
你可以假设树中没有重复的元素。</p>

<p>例如，给出</p>

<pre>中序遍历 inorder =&nbsp;[9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]</pre>

<p>返回如下的二叉树：</p>

<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>


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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        mp = dict()
        for i, v in enumerate(inorder):
            mp[v] = i

        def dfs(i_start, i_end, p_start, p_end):
            if i_start > i_end or p_start > p_end:
                return None
            root_val = postorder[p_end]
            root_index = mp[root_val]
            root = TreeNode(root_val)
            left_num = root_index - i_start
            root.left = dfs(i_start, root_index - 1, p_start, p_start + left_num - 1)
            root.right = dfs(root_index + 1, i_end, p_start + left_num, p_end - 1)
            return root

        return dfs(0, len(inorder) - 1, 0, len(postorder) - 1)
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
    Map<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        int rootIndex = mp.get(rootVal);
        int leftNum = rootIndex - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + leftNum - 1);
        root.right = dfs(inorder, rootIndex + 1, iEnd, postorder, pStart + leftNum, pEnd - 1);
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
