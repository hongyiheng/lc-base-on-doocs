# [1026. 节点与其祖先之间的最大差值](https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定二叉树的根节点 <code>root</code>，找出存在于 <strong>不同</strong> 节点 <code>A</code> 和 <code>B</code> 之间的最大值 <code>V</code>，其中 <code>V = |A.val - B.val|</code>，且 <code>A</code> 是 <code>B</code> 的祖先。</p>

<p>（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg" style="width: 400px; height: 390px;" /></p>

<pre>
<strong>输入：</strong>root = [8,3,10,1,6,null,14,null,null,4,7,13]
<strong>输出：</strong>7
<strong>解释： </strong>
我们有大量的节点与其祖先的差值，其中一些如下：
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg" style="width: 250px; height: 349px;" />
<pre>
<strong>输入：</strong>root = [1,null,2,null,0,3]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的节点数在 <code>2</code> 到 <code>5000</code> 之间。</li>
	<li><code>0 <= Node.val <= 10<sup>5</sup></code></li>
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
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(mx, mi, root):
            nonlocal ans
            if not root:
                return
            ans = max(ans, abs(mx - root.val))
            ans = max(ans, abs(mi - root.val))
            mx = max(mx, root.val)
            mi = min(mi, root.val)
            dfs(mx, mi, root.left)
            dfs(mx, mi, root.right)
        
        dfs(root.val, root.val, root)
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
    int ans = 0;

    public void dfs(int mx, int mi, TreeNode root) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, Math.abs(mx - root.val));
        ans = Math.max(ans, Math.abs(mi - root.val));
        mx = Math.max(mx, root.val);
        mi = Math.min(mi, root.val);
        dfs(mx, mi, root.left);
        dfs(mx, mi, root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.val, root.val, root);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
