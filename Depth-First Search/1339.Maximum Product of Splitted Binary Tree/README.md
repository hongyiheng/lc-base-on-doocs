# [1339. 分裂二叉树的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵二叉树，它的根为&nbsp;<code>root</code> 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。</p>

<p>由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/02/sample_1_1699.png" style="height: 200px; width: 495px;"></strong></p>

<pre><strong>输入：</strong>root = [1,2,3,4,5,6]
<strong>输出：</strong>110
<strong>解释：</strong>删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/02/sample_2_1699.png" style="height: 200px; width: 495px;"></p>

<pre><strong>输入：</strong>root = [1,null,2,3,4,null,null,5,6]
<strong>输出：</strong>90
<strong>解释：</strong>移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>root = [2,3,9,10,7,8,6,5,4,11,1]
<strong>输出：</strong>1025
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>root = [1,1]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>每棵树最多有&nbsp;<code>50000</code>&nbsp;个节点，且至少有&nbsp;<code>2</code>&nbsp;个节点。</li>
	<li>每个节点的值在&nbsp;<code>[1, 10000]</code>&nbsp;之间。</li>
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
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            res = root.val + left + right
            root.val = res
            return res
        
        def dfs1(root):
            nonlocal s, ans
            if not root:
                return
            dfs1(root.left)
            dfs1(root.right)
            ans = max(ans, (s - root.val) * root.val)

        s = dfs(root)
        ans = 0
        dfs1(root)
        return ans % int(1e9 + 7)
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

    long ans = 0, s = 0;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = root.val + left + right;
        root.val = res;
        return res;
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs1(root.left);
        dfs1(root.right);
        ans = Math.max(ans, (long)(s - root.val) * root.val);
    }

    public int maxProduct(TreeNode root) {
        s = dfs(root);
        dfs1(root);
        return (int)(ans % ((int)1e9 + 7));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
