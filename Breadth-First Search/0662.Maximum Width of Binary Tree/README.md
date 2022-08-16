# [662. 二叉树最大宽度](https://leetcode-cn.com/problems/maximum-width-of-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与<strong>满二叉树（full binary tree）</strong>结构相同，但一些节点为空。</p>

<p>每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的<code>null</code>节点也计入长度）之间的长度。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

<strong>输出:</strong> 4
<strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> 

          1
         /  
        3    
       / \       
      5   3     

<strong>输出:</strong> 2
<strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 2 (5,3)。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>
<strong>输入:</strong> 

          1
         / \
        3   2 
       /        
      5      

<strong>输出:</strong> 2
<strong>解释:</strong> 最大值出现在树的第 2 层，宽度为 2 (3,2)。
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入:</strong> 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
<strong>输出:</strong> 8
<strong>解释:</strong> 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
</pre>

<p><strong>注意:</strong> 答案在32位有符号整数的表示范围内。</p>


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
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        ans = 1
        q = deque()
        q.append(root)
        root.val = 0
        while q:
            n = len(q)
            ans = max(ans, q[-1].val - q[0].val + 1)
            for _ in range(n):
                cur = q.popleft()
                if cur.left:
                    q.append(cur.left)
                    cur.left.val = cur.val * 2 + 1
                if cur.right:
                    q.append(cur.right)
                    cur.right.val = cur.val * 2 + 2
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            ans = Math.max(ans, q.peekLast().val - q.peekFirst().val + 1);
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.pollFirst();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 + 1;
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 2;
                    q.addLast(cur.right);
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
