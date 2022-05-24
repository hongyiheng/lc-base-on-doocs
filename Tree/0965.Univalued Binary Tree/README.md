# [965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果二叉树每个节点都具有相同的值，那么该二叉树就是<em>单值</em>二叉树。</p>

<p>只有给定的树是单值二叉树时，才返回&nbsp;<code>true</code>；否则返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50104-pm.png" style="height: 159px; width: 200px;"></p>

<pre><strong>输入：</strong>[1,1,1,1,1,null,1]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50050-pm.png" style="height: 158px; width: 200px;"></p>

<pre><strong>输入：</strong>[2,2,2,5,2]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>给定树的节点数范围是&nbsp;<code>[1, 100]</code>。</li>
	<li>每个节点的值都是整数，范围为&nbsp;<code>[0, 99]</code>&nbsp;。</li>
</ol>


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
    def isUnivalTree(self, root: TreeNode) -> bool:
        val = root.val
        pre = TreeNode()
        while root:
            if not root.left:
                if root.val != val:
                    return False
                root = root.right
            else:
                pre = root.left
                while pre.right and pre.right != root:
                    pre = pre.right
                if not pre.right:
                    if root.val != val:
                        return False
                    pre.right = root
                    root = root.left
                else:
                    root = root.right
                    pre.right = None
        return True
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
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        TreeNode pre;
        while (root != null) {
            if (root.left == null) {
                if (root.val != val) {
                    return false;
                }
                root = root.right;
            } else {
                pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    if (root.val != val) {
                        return false;
                    }
                    pre.right = root;
                    root = root.left;
                } else {
                    root = root.right;
                    pre.right = null;
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
