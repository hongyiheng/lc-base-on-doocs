# [366. 寻找二叉树的叶子节点](https://leetcode-cn.com/problems/find-leaves-of-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵二叉树，请按以下要求的顺序收集它的全部节点：</p>

<ol>
	<li>依次从左到右，每次收集并删除所有的叶子节点</li>
	<li>重复如上过程直到整棵树为空</li>
</ol>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入: </strong>[1,2,3,4,5]
&nbsp; 
&nbsp;         1
         / \
        2   3
       / \     
      4   5    

<strong>输出: </strong>[[4,5,3],[2],[1]]
</pre>

<p>&nbsp;</p>

<p><strong>解释:</strong></p>

<p>1. 删除叶子节点&nbsp;<code>[4,5,3]</code> ，得到如下树结构：</p>

<pre>          1
         / 
        2          
</pre>

<p>&nbsp;</p>

<p>2. 现在删去叶子节点&nbsp;<code>[2]</code>&nbsp;，得到如下树结构：</p>

<pre>          1          
</pre>

<p>&nbsp;</p>

<p>3. 现在删去叶子节点&nbsp;<code>[1]</code>&nbsp;，得到空树：</p>

<pre>          []         
</pre>


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
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        mp = defaultdict(list)

        def dfs(root):
            if not root:
                return 0
            l = dfs(root.left)
            r = dfs(root.right)
            mp[max(l, r) + 1].append(root.val)
            return max(l, r) + 1
        
        ans = []
        n = dfs(root)
        for i in range(1, n + 1):
            ans.append(mp[i])
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
    Map<Integer, List<Integer>> mp = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        int n = dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            ans.add(mp.get(i));
        }
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left), r = dfs(root.right);
        mp.computeIfAbsent(Math.max(l, r) + 1, k -> new ArrayList<>()).add(root.val);
        return Math.max(l, r) + 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
