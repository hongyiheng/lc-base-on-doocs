# [919. 完全二叉树插入器](https://leetcode-cn.com/problems/complete-binary-tree-inserter)



## 题目描述

<!-- 这里写题目描述 -->

<p>完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。</p>

<p>设计一个用完全二叉树初始化的数据结构&nbsp;<code>CBTInserter</code>，它支持以下几种操作：</p>

<ul>
	<li><code>CBTInserter(TreeNode root)</code>&nbsp;使用头节点为&nbsp;<code>root</code>&nbsp;的给定树初始化该数据结构；</li>
	<li><code>CBTInserter.insert(int v)</code>&nbsp; 向树中插入一个新节点，节点类型为 <code>TreeNode</code>，值为 <code>v</code> 。使树保持完全二叉树的状态，<strong>并返回插入的新节点的父节点的值</strong>；</li>
	<li><code>CBTInserter.get_root()</code> 将返回树的头节点。</li>
</ul>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1]],[2],[]]
<strong>输出：</strong>[null,1,[1,2]]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
<strong>输出：</strong>[null,3,4,[1,2,3,4,5,6,7,8]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>最初给定的树是完全二叉树，且包含&nbsp;<code>1</code>&nbsp;到&nbsp;<code>1000</code>&nbsp;个节点。</li>
	<li>每个测试用例最多调用&nbsp;<code>CBTInserter.insert</code>&nbsp; 操作&nbsp;<code>10000</code>&nbsp;次。</li>
	<li>给定节点或插入节点的每个值都在&nbsp;<code>0</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;之间。</li>
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
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.idx = 0
        self.tr = [root]
        cur = 0
        while cur < len(self.tr):
            node = self.tr[cur] 
            if node.left:
                self.tr.append(node.left)
            if node.right:
                self.tr.append(node.right)
            cur += 1

    def insert(self, val: int) -> int:
        while self.tr[self.idx].left and self.tr[self.idx].right:
            self.idx += 1
        p, node = self.tr[self.idx], TreeNode(val)
        if not p.left:
            p.left = node
        else:
            p.right = node
        self.tr.append(node)
        return p.val
    
    def get_root(self) -> TreeNode:
        return self.tr[0]



# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(val)
# param_2 = obj.get_root()
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
class CBTInserter {
    List<TreeNode> tr = new ArrayList<>();
    int idx = 0;

    public CBTInserter(TreeNode root) {
        int cur = 0;
        tr.add(root);
        while (cur < tr.size()) {
            TreeNode node = tr.get(cur);
            if (node.left != null) {
                tr.add(node.left);
            }
            if (node.right != null) {
                tr.add(node.right);
            }
            cur++;
        }
    }
    
    public int insert(int val) {
        while (tr.get(idx).left != null && tr.get(idx).right != null) {
            idx++;
        }
        TreeNode node = new TreeNode(val);
        if (tr.get(idx).left == null) {
            tr.get(idx).left = node;
        } else {
            tr.get(idx).right = node;
        }
        tr.add(node);
        return tr.get(idx).val;
    }
    
    public TreeNode get_root() {
        return tr.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
```

### **...**

```

```

<!-- tabs:end -->
