# [99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你二叉搜索树的根节点 <code>root</code> ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。</p>

<p><strong>进阶：</strong>使用 O(<em>n</em>) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/28/recover1.jpg" style="width: 422px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [1,3,null,null,2]
<strong>输出：</strong>[3,1,null,null,2]
<strong>解释：</strong>3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/28/recover2.jpg" style="width: 581px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [3,1,4,null,null,2]
<strong>输出：</strong>[2,1,4,null,null,3]
<strong>解释：</strong>2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树上节点的数目在范围 <code>[2, 1000]</code> 内</li>
	<li><code>-2<sup>31</sup> <= Node.val <= 2<sup>31</sup> - 1</code></li>
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
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        pre, first, second = None, None, None
        def dfs(root):
            nonlocal pre, first, second
            if root is None:
                return
            dfs(root.left)
            if first is None and pre and pre.val > root.val:
                first = pre
            if first and pre.val > root.val:
                second = root
            pre = root
            dfs(root.right)
        
        dfs(root)
        first.val, second.val = second.val, first.val
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
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (first == null && pre != null && pre.val > root.val) {
            first = pre;
        }
        if (first != null && pre.val > root.val) {
            second = root;
        }
        pre = root;
        dfs(root.right);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
