# [606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。</p>

<p>空节点则用一对空括号 &quot;()&quot; 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

<strong>输出:</strong> &quot;1(2(4))(3)&quot;

<strong>解释:</strong> 原本将是&ldquo;1(2(4)())(3())&rdquo;，
在你省略所有不必要的空括号对之后，
它将是&ldquo;1(2(4))(3)&rdquo;。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

<strong>输出:</strong> &quot;1(2()(4))(3)&quot;

<strong>解释:</strong> 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
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
    def tree2str(self, root: Optional[TreeNode]) -> str:
        ans = ""

        def dfs(root):
            nonlocal ans
            if root is None:
                return
            ans += str(root.val)
            if root.left is None and root.right is None:
                return
            ans += "("
            dfs(root.left)
            ans += ")"
            if root.right:
                ans += "("
                dfs(root.right)
                ans += ")"
        
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
    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return ans.toString();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        ans.append("(");
        dfs(root.left);
        ans.append(")");
        if (root.right != null) {
            ans.append("(");
            dfs(root.right);
            ans.append(")");
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
