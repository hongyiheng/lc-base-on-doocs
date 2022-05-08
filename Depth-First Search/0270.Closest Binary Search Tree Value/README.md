# [270. 最接近的二叉搜索树值](https://leetcode-cn.com/problems/closest-binary-search-tree-value)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>给定的目标值 target 是一个浮点数</li>
	<li>题目保证在该二叉搜索树中只会存在一个最接近目标值的数</li>
</ul>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> root = [4,2,5,1,3]，目标值 target = 3.714286

    4
   / \
  2   5
 / \
1   3

<strong>输出:</strong> 4
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
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        ans = float('inf')

        def dfs(root):
            nonlocal ans, target
            if not root:
                return
            if abs(root.val - target) <= abs(ans - target):
                ans = root.val
            if root.val < target:
                dfs(root.right)
            else:
                dfs(root.left)

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
    int ans = Integer.MAX_VALUE;
    double target;

    public int closestValue(TreeNode root, double target) {
        this.target = target;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < Math.abs(ans - target)) {
            ans = root.val;
        }
        if (root.val < target) {
            dfs(root.right);
        } else {
            dfs(root.left);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
