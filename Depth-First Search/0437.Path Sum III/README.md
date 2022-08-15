# [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树的根节点 <code>root</code> ，和一个整数 <code>targetSum</code> ，求该二叉树里节点值之和等于 <code>targetSum</code> 的 <strong>路径</strong> 的数目。</p>

<p><strong>路径</strong> 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 452px; " /></p>

<pre>
<strong>输入：</strong>root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
<strong>输出：</strong>3
<strong>解释：</strong>和等于 8 的路径有 3 条，如图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li>二叉树的节点个数的范围是 <code>[0,1000]</code></li>
	<li><meta charset="UTF-8" /><code>-10<sup>9</sup> <= Node.val <= 10<sup>9</sup></code> </li>
	<li><code>-1000 <= targetSum <= 1000</code> </li>
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
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        ans = 0

        def dfs(root, t):
            nonlocal ans
            if not root:
                return
            if root.val == t:
                ans += 1
            dfs(root.left, t - root.val)
            dfs(root.right, t - root.val)
        
        q = [root]
        while q:
            cur = q.pop()
            if not cur:
                continue
            dfs(cur, targetSum)
            q.append(cur.left)
            q.append(cur.right)
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
    int ans;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            dfs(cur, targetSum);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }            
        }
        return ans;
    }

    public void dfs(TreeNode root, long t) {
        if (root == null) {
            return;
        }
        if (root.val == t) {
            ans++;
        }
        dfs(root.left, t - root.val);
        dfs(root.right, t - root.val);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
