# [1080. 根到叶路径上的不足节点](https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一棵二叉树的根 <code>root</code>，请你考虑它所有&nbsp;<strong>从根到叶的路径</strong>：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）</p>

<p>假如通过节点 <code>node</code> 的每种可能的 &ldquo;根-叶&rdquo; 路径上值的总和全都小于给定的 <code>limit</code>，则该节点被称之为「不足节点」，需要被删除。</p>

<p>请你删除所有不足节点，并返回生成的二叉树的根。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/08/insufficient-1.png" style="height: 200px; width: 482px;">
输入：</strong>root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
<strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/08/insufficient-2.png" style="height: 200px; width: 258px;">
输出：</strong>[1,2,3,4,null,null,7,8,9,null,14]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/08/insufficient-3.png" style="height: 200px; width: 292px;">
输入：</strong>root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
<strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/08/insufficient-4.png" style="height: 200px; width: 264px;">
输出：</strong>[5,4,8,11,null,17,4,7,null,null,null,5]</pre>

<p><strong>示例 3：</strong></p>

<pre><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/08/insufficient-5.png" style="height: 100px; width: 140px;">
输入：</strong>root = [5,-6,-6], limit = 0<strong>
输出：</strong>[]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>给定的树有&nbsp;<code>1</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;个节点</li>
	<li><code>-10^5&nbsp;&lt;= node.val &lt;= 10^5</code></li>
	<li><code>-10^9 &lt;= limit&nbsp;&lt;= 10^9</code></li>
</ol>

<p>&nbsp;</p>


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
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def dfs(root, s):
            s += root.val
            if not root.left and not root.right:
                return (root if s >= limit else None, s)
            mx = -inf
            if root.left:
                l = dfs(root.left, s)
                mx = max(mx, l[1])
                root.left = l[0]
            if root.right:
                r = dfs(root.right, s)
                mx = max(mx, r[1])
                root.right = r[0]
            return (root if mx >= limit else None, mx)
        
        return dfs(root, 0)[0]
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

    int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return dfs(root, 0).getKey();
    }

    public Pair<TreeNode, Integer> dfs(TreeNode root, int s) {
        s += root.val;
        if (root.left == null && root.right == null) {
            return new Pair<>(s < limit ? null: root, s);
        }
        int mx = -0x3f3f3f3f;
        if (root.left != null) {
            Pair<TreeNode, Integer> left = dfs(root.left, s);
            root.left = left.getKey();
            mx = Math.max(mx, left.getValue());
        }
        if (root.right != null) {
            Pair<TreeNode, Integer> right = dfs(root.right, s);
            root.right = right.getKey();
            mx = Math.max(mx, right.getValue());
        }
        return new Pair<>(mx < limit ? null : root, mx);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
