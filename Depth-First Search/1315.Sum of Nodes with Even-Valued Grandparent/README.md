# [1315. 祖父节点值为偶数的节点和](https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：</p>

<ul>
	<li>该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）</li>
</ul>

<p>如果不存在祖父节点值为偶数的节点，那么返回&nbsp;<code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/10/1473_ex1.png" style="height: 214px; width: 350px;"></strong></p>

<pre><strong>输入：</strong>root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
<strong>输出：</strong>18
<strong>解释：</strong>图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目在&nbsp;<code>1</code> 到&nbsp;<code>10^4</code>&nbsp;之间。</li>
	<li>每个节点的值在&nbsp;<code>1</code> 到&nbsp;<code>100</code> 之间。</li>
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
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        even = []

        def dfs(root):
            if not root:
                return
            if root.val % 2 == 0:
                even.append(root)
            dfs(root.left)
            dfs(root.right)
        
        dfs(root)
        ans = 0
        for t in even:
            if t.left and t.left.left:
                ans += t.left.left.val
            if t.left and t.left.right:
                ans += t.left.right.val
            if t.right and t.right.left:
                ans += t.right.left.val
            if t.right and t.right.right:
                ans += t.right.right.val
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
    List<TreeNode> even = new ArrayList<>();
    
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            even.add(root);
        }
        dfs(root.left);
        dfs(root.right);
    }
    

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        int ans = 0;
        for (TreeNode node : even) {
            if (node.left != null) {
                if (node.left.left != null) {
                    ans += node.left.left.val;
                }
                if (node.left.right != null) {
                    ans += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    ans += node.right.left.val;
                }
                if (node.right.right != null) {
                    ans += node.right.right.val;
                }
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
