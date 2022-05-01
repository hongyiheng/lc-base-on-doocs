# [1305. 两棵二叉搜索树中的所有元素](https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你&nbsp;<code>root1</code> 和 <code>root2</code>&nbsp;这两棵二叉搜索树。</p>

<p>请你返回一个列表，其中包含&nbsp;<strong>两棵树&nbsp;</strong>中的所有整数并按 <strong>升序</strong> 排序。.</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e1.png"></p>

<pre><strong>输入：</strong>root1 = [2,1,4], root2 = [1,0,3]
<strong>输出：</strong>[0,1,1,2,3,4]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>root1 = [0,-10,10], root2 = [5,1,7,0,2]
<strong>输出：</strong>[-10,0,0,1,2,5,7,10]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>root1 = [], root2 = [5,1,7,0,2]
<strong>输出：</strong>[0,1,2,5,7]
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>root1 = [0,-10,10], root2 = []
<strong>输出：</strong>[-10,0,10]
</pre>

<p><strong>示例 5：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e5-.png"></p>

<pre><strong>输入：</strong>root1 = [1,null,8], root2 = [8,1]
<strong>输出：</strong>[1,1,8,8]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>每棵树最多有&nbsp;<code>5000</code>&nbsp;个节点。</li>
	<li>每个节点的值在&nbsp;<code>[-10^5, 10^5]</code>&nbsp;之间。</li>
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
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def dfs(root, nums):
            if not root:
                return
            dfs(root.left, nums)
            nums.append(root.val)
            dfs(root.right, nums)
        
        nums1, nums2 = [], []
        dfs(root1, nums1)
        dfs(root2, nums2)
        ans = []
        idx1, idx2 = 0, 0
        while idx1 < len(nums1) or idx2 < len(nums2):
            if idx1 < len(nums1) and idx2 < len(nums2):
                if nums1[idx1] <= nums2[idx2]:
                    ans.append(nums1[idx1])
                    idx1 += 1
                else:
                    ans.append(nums2[idx2])
                    idx2 += 1
                continue
            if idx1 < len(nums1):
                ans.append(nums1[idx1])
                idx1 += 1
            else:
                ans.append(nums2[idx2])
                idx2 += 1
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        dfs(root1, nums1);
        dfs(root2, nums2);
        int idx1 = 0, idx2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (idx1 < nums1.size() || idx2 < nums2.size()) {
            if (idx1 < nums1.size() && idx2 < nums2.size()) {
                if (nums1.get(idx1) <= nums2.get(idx2)) {
                    ans.add(nums1.get(idx1));
                    idx1++;   
                } else {
                    ans.add(nums2.get(idx2));
                    idx2++;
                }
                continue;
            }
            if (idx1 < nums1.size()) {
                ans.add(nums1.get(idx1));
                idx1++;
            } else {
                ans.add(nums2.get(idx2));
                idx2++;
            }
        }
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
