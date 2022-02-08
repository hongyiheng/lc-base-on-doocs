# [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>翻转一棵二叉树。</p>

<p><strong>示例：</strong></p>

<p>输入：</p>

<pre>     4
   /   \
  2     7
 / \   / \
1   3 6   9</pre>

<p>输出：</p>

<pre>     4
   /   \
  7     2
 / \   / \
9   6 3   1</pre>

<p><strong>备注:</strong><br>
这个问题是受到 <a href="https://twitter.com/mxcl" target="_blank">Max Howell </a>的 <a href="https://twitter.com/mxcl/status/608682016205344768" target="_blank">原问题</a> 启发的 ：</p>

<blockquote>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。</blockquote>


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
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return root
        q = deque()
        q.append(root)
        while q:
            n = len(q)
            for _ in range(n):
                cur = q.pop()
                cur.left, cur.right = cur.right, cur.left
                if cur.left:
                    q.append(cur.left)
                if cur.right:
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.pollFirst();
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
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
