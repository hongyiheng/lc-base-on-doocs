# [968. 监控二叉树](https://leetcode-cn.com/problems/binary-tree-cameras)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树，我们在树的节点上安装摄像头。</p>

<p>节点上的每个摄影头都可以监视<strong>其父对象、自身及其直接子对象。</strong></p>

<p>计算监控树的所有节点所需的最小摄像头数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_01.png" style="height: 163px; width: 138px;"></p>

<pre><strong>输入：</strong>[0,0,null,0,0]
<strong>输出：</strong>1
<strong>解释：</strong>如图所示，一台摄像头足以监控所有节点。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_02.png" style="height: 312px; width: 139px;"></p>

<pre><strong>输入：</strong>[0,0,null,0,null,0,null,null,0]
<strong>输出：</strong>2
<strong>解释：</strong>需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
</pre>

<p><br>
<strong>提示：</strong></p>

<ol>
	<li>给定树的节点数的范围是&nbsp;<code>[1, 1000]</code>。</li>
	<li>每个节点的值都是 0。</li>
</ol>


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
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            nonlocal ans
            if not root:
                return -1
            l, r = dfs(root.left), dfs(root.right)
            if l == 0 or r == 0:
                ans += 1
                return 1
            return -1 if l == 1 or r == 1 else 0
        
        ans = 0
        if dfs(root) == 0:
            ans += 1
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

    public int minCameraCover(TreeNode root) {
        ans = 0;
        if (dfs(root) == 0) {
            ans++;
        }
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = dfs(root.left), r = dfs(root.right);
        if (l == 0 || r == 0) {
            ans++;
            return 1;
        }
        return l == 1 || r == 1 ? -1 : 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
