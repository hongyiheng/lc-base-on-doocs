# [894. 所有可能的满二叉树](https://leetcode-cn.com/problems/all-possible-full-binary-trees)



## 题目描述

<!-- 这里写题目描述 -->

<p><em>满二叉树</em>是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。</p>

<p>返回包含 <code>N</code> 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。</p>

<p>答案中每个树的每个<code>结点</code>都<strong>必须</strong>有 <code>node.val=0</code>。</p>

<p>你可以按任何顺序返回树的最终列表。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>7
<strong>输出：</strong>[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
<strong>解释：</strong>
<img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/08/24/fivetrees.png" style="height: 400px; width: 700px;">
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= N &lt;= 20</code></li>
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
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        ans = []
        if n % 2 == 0:
            return ans
        if n == 1:
            ans.append(TreeNode(0))
            return ans
        for i in range(1, n):
            lr = self.allPossibleFBT(i)
            rr = self.allPossibleFBT(n - i - 1)
            for l in lr:
                for r in rr:
                    root = TreeNode(0)
                    root.left = l
                    root.right = r
                    ans.append(root)
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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) {
            return ans;
        }
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < n; i++) {
            List<TreeNode> lt = allPossibleFBT(i);
            List<TreeNode> rt = allPossibleFBT(n - i - 1);
            for (TreeNode l : lt) {
                for (TreeNode r : rt) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
