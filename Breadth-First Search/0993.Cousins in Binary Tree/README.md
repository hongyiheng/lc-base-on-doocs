# [993. 二叉树的堂兄弟节点](https://leetcode-cn.com/problems/cousins-in-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>在二叉树中，根节点位于深度 <code>0</code> 处，每个深度为 <code>k</code> 的节点的子节点位于深度 <code>k+1</code> 处。</p>

<p>如果二叉树的两个节点深度相同，但<strong> 父节点不同</strong> ，则它们是一对<em>堂兄弟节点</em>。</p>

<p>我们给出了具有唯一值的二叉树的根节点 <code>root</code> ，以及树中两个不同节点的值 <code>x</code> 和 <code>y</code> 。</p>

<p>只有与值 <code>x</code> 和 <code>y</code> 对应的节点是堂兄弟节点时，才返回 <code>true</code> 。否则，返回 <code>false</code>。</p>

<p> </p>

<p><strong>示例 1：<br />
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-01.png" style="height: 160px; width: 180px;" /></strong></p>

<pre>
<strong>输入：</strong>root = [1,2,3,4], x = 4, y = 3
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：<br />
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-02.png" style="height: 160px; width: 201px;" /></strong></p>

<pre>
<strong>输入：</strong>root = [1,2,3,null,4,null,5], x = 5, y = 4
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-03.png" style="height: 160px; width: 156px;" /></strong></p>

<pre>
<strong>输入：</strong>root = [1,2,3,null,4], x = 2, y = 3
<strong>输出：</strong>false</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>二叉树的节点数介于 <code>2</code> 到 <code>100</code> 之间。</li>
	<li>每个节点的值都是唯一的、范围为 <code>1</code> 到 <code>100</code> 的整数。</li>
</ul>

<p> </p>


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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])
        while q:
            a = b = False
            for _ in range(len(q)):
                v = q.popleft()
                if v.left:
                    if v.left.val == x and b:
                        return True
                    if v.left.val == y and a:
                        return True
                if v.right:
                    if v.right.val == x and b:
                        return True
                    if v.right.val == y and a:
                        return True
                if (v.left and v.left.val == x) or (v.right and v.right.val == x):
                    a = True
                if (v.left and v.left.val == y) or (v.right and v.right.val == y):
                    b = True
                if v.left:
                    q.append(v.left)
                if v.right:
                    q.append(v.right)
        return False
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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            boolean a = false, b = false;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode v = q.pollFirst();
                if (v.left != null) {
                    if ((v.left.val == x && b) || v.left.val == y && a) {
                        return true;
                    }
                }
                if (v.right != null) {
                    if ((v.right.val == x && b) || v.right.val == y && a) {
                        return true;
                    }
                }
                if ((v.left != null && v.left.val == x) || (v.right != null && v.right.val == x)) {
                    a = true;
                }
                if ((v.left != null && v.left.val == y) || (v.right != null && v.right.val == y)) {
                    b = true;
                }
                if (v.left != null) {
                    q.add(v.left);
                }
                if (v.right != null) {
                    q.add(v.right);
                }
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
