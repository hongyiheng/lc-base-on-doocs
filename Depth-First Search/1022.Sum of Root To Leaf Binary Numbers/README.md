# [1022. 从根到叶的二进制数之和](https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一棵二叉树，其上每个结点的值都是 <code>0</code> 或 <code>1</code> 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 <code>0 -> 1 -> 1 -> 0 -> 1</code>，那么它表示二进制数 <code>01101</code>，也就是 <code>13</code> 。</p>

<p>对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。</p>

<p>返回这些数字之和。题目数据保证答案是一个 <strong>32 位 </strong>整数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png" style="width: 450px; height: 296px;" />
<pre>
<strong>输入：</strong>root = [1,0,1,0,1,0,1]
<strong>输出：</strong>22
<strong>解释：</strong>(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [0]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>root = [1,1]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的结点数介于 <code>1</code> 和 <code>1000</code> 之间。</li>
	<li><code>Node.val</code> 为 <code>0</code> 或 <code>1</code> 。</li>
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
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(root, cur):
            nonlocal ans
            if not root:
                return
            cur = cur << 1 | root.val
            if not root.left and not root.right:
                ans += cur
                return
            dfs(root.left, cur)
            dfs(root.right, cur)
        
        dfs(root, 0)
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

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur = cur << 1 | root.val;
        if (root.left == null && root.right == null) {
            ans += cur;
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
