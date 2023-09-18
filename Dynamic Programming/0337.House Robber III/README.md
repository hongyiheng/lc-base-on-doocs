# [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为&ldquo;根&rdquo;。 除了&ldquo;根&rdquo;之外，每栋房子有且只有一个&ldquo;父&ldquo;房子与之相连。一番侦察之后，聪明的小偷意识到&ldquo;这个地方的所有房屋的排列类似于一棵二叉树&rdquo;。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。</p>

<p>计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入: </strong>[3,2,3,null,3,null,1]

     <strong>3</strong>
    / \
   2   3
    \   \ 
     <strong>3</strong>   <strong>1</strong>

<strong>输出:</strong> 7 
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = <strong>7</strong>.</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入: </strong>[3,4,5,1,3,null,1]

&nbsp;    3
    / \
   <strong>4</strong>   <strong>5</strong>
  / \   \ 
 1   3   1

<strong>输出:</strong> 9
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额&nbsp;= <strong>4</strong> + <strong>5</strong> = <strong>9</strong>.
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
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            if not root:
                return 0, 0
            la, lb = dfs(root.left)
            ra, rb = dfs(root.right)
            return root.val + lb + rb, max(la, lb) + max(ra, rb)

        return max(dfs(root))      
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

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])}; 
    }

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
