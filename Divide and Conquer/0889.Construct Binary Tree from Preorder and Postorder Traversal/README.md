# [889. 根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal)



## 题目描述

<!-- 这里写题目描述 -->

<p>返回与给定的前序和后序遍历匹配的任何二叉树。</p>

<p>&nbsp;<code>pre</code>&nbsp;和&nbsp;<code>post</code>&nbsp;遍历中的值是不同的正整数。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
<strong>输出：</strong>[1,2,3,4,5,6,7]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= pre.length == post.length &lt;= 30</code></li>
	<li><code>pre[]</code>&nbsp;和&nbsp;<code>post[]</code>&nbsp;都是&nbsp;<code>1, 2, ..., pre.length</code>&nbsp;的排列</li>
	<li>每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
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

    public int indexOf(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (n > 1) {
            int leftSize = indexOf(postorder, preorder[1]) + 1;
            int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
            int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
            int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
            int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
            root.left = constructFromPrePost(pre1, post1);
            root.right = constructFromPrePost(pre2, post2);
        }
        return root;
    }
}
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

    public int indexOf(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (n > 1) {
            int leftSize = indexOf(postorder, preorder[1]) + 1;
            int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
            int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
            int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
            int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
            root.left = constructFromPrePost(pre1, post1);
            root.right = constructFromPrePost(pre2, post2);
        }
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
