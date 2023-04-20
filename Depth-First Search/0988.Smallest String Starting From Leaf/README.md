# [988. 从叶结点开始的最小字符串](https://leetcode-cn.com/problems/smallest-string-starting-from-leaf)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一颗根结点为&nbsp;<code>root</code>&nbsp;的二叉树，树中的每一个结点都有一个从&nbsp;<code>0</code> 到&nbsp;<code>25</code>&nbsp;的值，分别代表字母&nbsp;<code>&#39;a&#39;</code> 到&nbsp;<code>&#39;z&#39;</code>：值&nbsp;<code>0</code> 代表&nbsp;<code>&#39;a&#39;</code>，值&nbsp;<code>1</code>&nbsp;代表&nbsp;<code>&#39;b&#39;</code>，依此类推。</p>

<p>找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。</p>

<p><em>（小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上&nbsp;<code>&quot;ab&quot;</code> 比&nbsp;<code>&quot;aba&quot;</code>&nbsp;要小。叶结点是指没有子结点的结点。）</em></p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/02/tree1.png" style="height: 107px; width: 160px;"></strong></p>

<pre><strong>输入：</strong>[0,1,2,3,4,3,4]
<strong>输出：</strong>&quot;dba&quot;
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/02/tree2.png" style="height: 107px; width: 160px;"></strong></p>

<pre><strong>输入：</strong>[25,1,3,1,3,0,2]
<strong>输出：</strong>&quot;adz&quot;
</pre>

<p><strong>示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/02/tree3.png" style="height: 180px; width: 172px;"></strong></p>

<pre><strong>输入：</strong>[2,2,1,null,1,0,null,0]
<strong>输出：</strong>&quot;abc&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>给定树的结点数介于&nbsp;<code>1</code> 和&nbsp;<code>8500</code>&nbsp;之间。</li>
	<li>树中的每个结点都有一个介于&nbsp;<code>0</code>&nbsp;和&nbsp;<code>25</code>&nbsp;之间的值。</li>
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
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        def dfs(root, path):
            if not root.left and not root.right:
                q.append("".join(path)[::-1])
                return
            if root.left:
                path.append(chr(root.left.val + ord('a')))
                dfs(root.left, path)
                path.pop()
            if root.right:
                path.append(chr(root.right.val + ord('a')))
                dfs(root.right, path)
                path.pop()

        q = []
        dfs(root, [chr(root.val + ord('a'))])
        q.sort()
        return q[0]
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
    
    List<String> q = new ArrayList<>();

    public void dfs(TreeNode root, List<String> path) {
        if (root.left == null && root.right == null) {
            q.add(new StringBuilder(String.join("", path)).reverse().toString());
            return;
        }
        if (root.left != null) {
            path.add(String.valueOf((char) ('a' + root.left.val)));
            dfs(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(String.valueOf((char) ('a' + root.right.val)));
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
    }


    public String smallestFromLeaf(TreeNode root) {
        List<String> path = new ArrayList<>();
        path.add(String.valueOf((char) ('a' + root.val)));
        dfs(root, path);
        Collections.sort(q);
        return q.get(0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
