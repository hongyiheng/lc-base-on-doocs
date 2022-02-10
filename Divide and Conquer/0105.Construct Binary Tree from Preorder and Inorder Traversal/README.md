# [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一棵树的前序遍历 <code>preorder</code> 与中序遍历  <code>inorder</code>。请构造二叉树并返回其根节点。</p>

<p> </p>

<p><strong>示例 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
<pre>
<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [-1], inorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= preorder.length <= 3000</code></li>
	<li><code>inorder.length == preorder.length</code></li>
	<li><code>-3000 <= preorder[i], inorder[i] <= 3000</code></li>
	<li><code>preorder</code> 和 <code>inorder</code> 均无重复元素</li>
	<li><code>inorder</code> 均出现在 <code>preorder</code></li>
	<li><code>preorder</code> 保证为二叉树的前序遍历序列</li>
	<li><code>inorder</code> 保证为二叉树的中序遍历序列</li>
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
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        mp = dict()
        for i, v in enumerate(inorder):
            mp[v] = i
        
        def dfs(p_start, p_end, i_start, i_end):
            nonlocal preorder, inorder
            if p_start > p_end or i_start > i_end:
                return None
            root_val = preorder[p_start]
            root_index = mp[root_val]
            left_num = root_index - i_start
            root = TreeNode(root_val)
            root.left = dfs(p_start + 1, p_start + left_num, i_start, root_index - 1)
            root.right = dfs(p_start + left_num + 1, p_end, root_index + 1, i_end)
            return root

        return dfs(0, len(preorder) - 1, 0, len(inorder) - 1)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        int rootIndex = mp.get(rootVal);
        int leftNum = rootIndex - inStart;
        TreeNode ans = new TreeNode(rootVal);
        ans.left = dfs(preorder, pStart + 1, pStart + leftNum, inorder, inStart, rootIndex - 1);
        ans.right = dfs(preorder, pStart + leftNum + 1, pEnd, inorder, rootIndex + 1, inEnd);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
