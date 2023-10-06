# [958. 二叉树的完全性检验](https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树，确定它是否是一个<em>完全二叉树</em>。</p>

<p><strong><a href="https://baike.baidu.com/item/完全二叉树/7773232?fr=aladdin" target="_blank">百度百科</a>中对完全二叉树的定义如下：</strong></p>

<p>若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~&nbsp;2<sup>h</sup>&nbsp;个节点。）</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-1.png" style="height: 145px; width: 180px;"></p>

<pre><strong>输入：</strong>[1,2,3,4,5,6]
<strong>输出：</strong>true
<strong>解释：</strong>最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/complete-binary-tree-2.png"></strong></p>

<pre><strong>输入：</strong>[1,2,3,4,5,null,7]
<strong>输出：</strong>false
<strong>解释：</strong>值为 7 的结点没有尽可能靠向左侧。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>树中将会有 1 到 100 个结点。</li>
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
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        q = deque([root])
        last = 0
        while q:
            n = len(q)
            end = False
            for _ in range(n):
                v = q.popleft()
                if v.left:
                    if end:
                        return False
                    q.append(v.left)
                else:
                    end = True
                if v.right:
                    if end:
                        return False
                    q.append(v.right)
                else:
                    end = True
            if q and last and last * 2 != n:
                return False
            last = n
        return True
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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int last = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            boolean end = false;
            for (int i = 0; i < n; i++) {
                TreeNode v = q.pollFirst();
                if (v.left != null) {
                    if (end) {
                        return false;
                    }
                    q.addLast(v.left);
                } else {
                    end = true;
                }
                if (v.right != null) {
                    if (end) {
                        return false;
                    }
                    q.addLast(v.right);
                } else {
                    end = true;
                }
            }
            if (last != 0 && !q.isEmpty() && last * 2 != n) {
                return false;
            }
            last = n;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
