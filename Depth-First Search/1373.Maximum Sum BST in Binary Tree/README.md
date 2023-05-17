# [1373. 二叉搜索子树的最大键值和](https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵以 <code>root</code> 为根的 <strong>二叉树</strong> ，请你返回 <strong>任意</strong> 二叉搜索子树的最大键值和。</p>

<p>二叉搜索树的定义如下：</p>

<ul>
	<li>任意节点的左子树中的键值都 <strong>小于</strong> 此节点的键值。</li>
	<li>任意节点的右子树中的键值都 <strong>大于</strong> 此节点的键值。</li>
	<li>任意节点的左子树和右子树都是二叉搜索树。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/07/sample_1_1709.png" style="height: 250px; width: 320px;" /></p>

<pre>
<strong>输入：</strong>root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
<strong>输出：</strong>20
<strong>解释：</strong>键值为 3 的子树是和最大的二叉搜索树。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/07/sample_2_1709.png" style="height: 180px; width: 134px;" /></p>

<pre>
<strong>输入：</strong>root = [4,3,null,1,2]
<strong>输出：</strong>2
<strong>解释：</strong>键值为 2 的单节点子树是和最大的二叉搜索树。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [-4,-2,-5]
<strong>输出：</strong>0
<strong>解释：</strong>所有节点键值都为负数，和最大的二叉搜索树为空。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>root = [2,1,3]
<strong>输出：</strong>6
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>root = [5,4,8,3,null,6,3]
<strong>输出：</strong>7
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>每棵树有 <code>1</code> 到 <code>40000</code> 个节点。</li>
	<li>每个节点的键值在 <code>[-4 * 10^4 , 4 * 10^4]</code> 之间。</li>
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
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        ans = 0
        f = dict()

        def get_sum(root):
            if root in f:
                return f[root]
            if not root:
                return 0
            l, r = get_sum(root.left), get_sum(root.right)
            f[root] = l + r + root.val
            return f[root]

        def dfs(root):
            nonlocal ans
            flag = True
            mx = mi = root.val
            if root.left:
                l_flag, l_mx, l_mi = dfs(root.left)
                flag = flag and l_flag and l_mx < root.val
                mx, mi = max(mx, l_mx), min(mi, l_mi)
            if root.right:
                r_flag, r_mx, r_mi = dfs(root.right)
                flag = flag and r_flag and root.val < r_mi
                mx, mi = max(mx, r_mx), min(mi, r_mi)
            if flag:
                ans = max(ans, get_sum(root))
            return (flag, mx, mi)

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

    int ans = 0;
    Map<TreeNode, Integer> f = new HashMap<>();

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public Pair<Boolean, int[]> dfs(TreeNode root) {
        boolean flag = true;
        int mx = root.val, mi = root.val;
        if (root.left != null) {
            Pair<Boolean, int[]> left = dfs(root.left);
            int lMx = left.getValue()[0], lMi = left.getValue()[1];
            flag = flag && left.getKey() && lMx < root.val;
            mx = Math.max(mx, lMx);
            mi = Math.min(mi, lMi);
        }
        if (root.right != null) {
            Pair<Boolean, int[]> right = dfs(root.right);
            int rMx = right.getValue()[0], rMi = right.getValue()[1];
            flag = flag && right.getKey() && rMi > root.val;
            mx = Math.max(mx, rMx);
            mi = Math.min(mi, rMi);
        }
        if (flag) {
            ans = Math.max(ans, getSum(root));
        }
        return new Pair<>(flag, new int[]{mx, mi});
    }

    private int getSum(TreeNode root) {
        if (f.containsKey(root)) {
            return f.get(root);
        }
        if (root == null) {
            return 0;
        }
        int l = getSum(root.left), r = getSum(root.right);
        f.put(root, l + r + root.val);
        return f.get(root);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
