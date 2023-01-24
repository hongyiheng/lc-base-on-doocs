# [654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个不含重复元素的整数数组 <code>nums</code> 。一个以此数组直接递归构建的 <strong>最大二叉树</strong> 定义如下：</p>

<ol>
	<li>二叉树的根是数组 <code>nums</code> 中的最大元素。</li>
	<li>左子树是通过数组中 <strong>最大值左边部分</strong> 递归构造出的最大二叉树。</li>
	<li>右子树是通过数组中 <strong>最大值右边部分</strong> 递归构造出的最大二叉树。</li>
</ol>

<p>返回有给定数组 <code>nums</code> 构建的 <strong>最大二叉树 </strong>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg" style="width: 302px; height: 421px;" />
<pre>
<strong>输入：</strong>nums = [3,2,1,6,0,5]
<strong>输出：</strong>[6,3,5,null,2,0,null,null,1]
<strong>解释：</strong>递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg" style="width: 182px; height: 301px;" />
<pre>
<strong>输入：</strong>nums = [3,2,1]
<strong>输出：</strong>[3,null,2,null,1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 1000</code></li>
	<li><code>0 <= nums[i] <= 1000</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
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
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        def dfs(l, r):
            if l > r:
                return None
            mx = l
            for i in range(l, r + 1):
                if nums[i] > nums[mx]:
                    mx = i
            root = TreeNode(nums[mx])
            root.left = dfs(l, mx - 1)
            root.right = dfs(mx + 1, r)
            return root

        return dfs(0, len(nums) - 1)
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
    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    public TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int mx = l;
        for (int i = l; i <= r; i++) {
            if (nums[mx] < nums[i]) {
                mx = i;
            }
        }
        TreeNode root = new TreeNode(nums[mx]);
        root.left = dfs(l, mx - 1);
        root.right = dfs(mx + 1, r);
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
