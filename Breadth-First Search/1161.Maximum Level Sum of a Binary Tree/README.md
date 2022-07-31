# [1161. 最大层内元素和](https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二叉树的根节点&nbsp;<code>root</code>。设根节点位于二叉树的第 <code>1</code> 层，而根节点的子节点位于第 <code>2</code> 层，依此类推。</p>

<p>请你找出层内元素之和 <strong>最大</strong> 的那几层（可能只有一层）的层号，并返回其中&nbsp;<strong>最小</strong> 的那个。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/capture.jpeg" style="height: 175px; width: 200px;"></strong></p>

<pre><strong>输入：</strong>root = [1,7,0,7,-8,null,null]
<strong>输出：</strong>2
<strong>解释：</strong>
第 1 层各元素之和为 1，
第 2 层各元素之和为 7 + 0 = 7，
第 3 层各元素之和为 7 + -8 = -1，
所以我们返回第 2 层的层号，它的层内元素之和最大。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>root = [989,null,10250,98693,-89388,null,null,null,-32127]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的节点数介于&nbsp;<code>1</code>&nbsp;和&nbsp;<code>10^4</code>&nbsp;之间</li>
	<li><code>-10^5 &lt;= node.val &lt;= 10^5</code></li>
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
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans, row, mx = 1, 1, root.val
        q = deque()
        q.append(root)
        while q:
            m = len(q)
            tmp = 0
            for _ in range(m):
                cur = q.popleft()
                tmp += cur.val
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            if tmp > mx:
                mx = tmp
                ans = row
            row += 1
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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        long mx = root.val;
        int ans = 1, row = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            long tmp = 0;
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                tmp += cur.val;
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            if (tmp > mx) {
                mx = tmp;
                ans = row;
            }
            row++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
