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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        //终止条件
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        //从后序遍历中拿到根节点
        int root = postorder[postRight];
        //从中序取出根节点的索引
        int index = map.get(root);
        //构建根节点
        TreeNode tree = new TreeNode(root);
        tree.left = buildTree(inLeft, index - 1, postorder, postLeft, postRight - inRight + index - 1);
        tree.right = buildTree(index + 1, inRight, postorder, postRight - inRight + index, postRight - 1);
        return tree;
    }
}
```
![in_post_tree.JPG](https://pic.leetcode-cn.com/1615811318-MUUgPs-in_post_tree.JPG)
### **...**

```

```

<!-- tabs:end -->
