# [2458. 移除子树后的二叉树高度](https://leetcode-cn.com/problems/height-of-binary-tree-after-subtree-removal-queries)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵 <strong>二叉树</strong> 的根节点 <code>root</code> ，树中有 <code>n</code> 个节点。每个节点都可以被分配一个从 <code>1</code> 到 <code>n</code> 且互不相同的值。另给你一个长度为 <code>m</code> 的数组 <code>queries</code> 。</p>

<p>你必须在树上执行 <code>m</code> 个 <strong>独立</strong> 的查询，其中第 <code>i</code> 个查询你需要执行以下操作：</p>

<ul>
	<li>从树中 <strong>移除</strong> 以 <code>queries[i]</code> 的值作为根节点的子树。题目所用测试用例保证 <code>queries[i]</code> <strong>不</strong> 等于根节点的值。</li>
</ul>

<p>返回一个长度为 <code>m</code> 的数组<em> </em><code>answer</code><em> </em>，其中<em> </em><code>answer[i]</code><em> </em>是执行第 <code>i</code> 个查询后树的高度。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>查询之间是独立的，所以在每个查询执行后，树会回到其 <strong>初始</strong> 状态。</li>
	<li>树的高度是从根到树中某个节点的 <strong>最长简单路径中的边数</strong> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/09/07/binaryytreeedrawio-1.png" style="width: 495px; height: 281px;" /></p>

<pre>
<strong>输入：</strong>root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
<strong>输出：</strong>[2]
<strong>解释：</strong>上图展示了从树中移除以 4 为根节点的子树。
树的高度是 2（路径为 1 -&gt; 3 -&gt; 2）。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/09/07/binaryytreeedrawio-2.png" style="width: 301px; height: 284px;" /></p>

<pre>
<strong>输入：</strong>root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
<strong>输出：</strong>[3,2,3,2]
<strong>解释：</strong>执行下述查询：
- 移除以 3 为根节点的子树。树的高度变为 3（路径为 5 -&gt; 8 -&gt; 2 -&gt; 4）。
- 移除以 2 为根节点的子树。树的高度变为 2（路径为 5 -&gt; 8 -&gt; 1）。
- 移除以 4 为根节点的子树。树的高度变为 3（路径为 5 -&gt; 8 -&gt; 2 -&gt; 6）。
- 移除以 8 为根节点的子树。树的高度变为 2（路径为 5 -&gt; 9 -&gt; 3）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目是 <code>n</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= Node.val &lt;= n</code></li>
	<li>树中的所有值 <strong>互不相同</strong></li>
	<li><code>m == queries.length</code></li>
	<li><code>1 &lt;= m &lt;= min(n, 10<sup>4</sup>)</code></li>
	<li><code>1 &lt;= queries[i] &lt;= n</code></li>
	<li><code>queries[i] != root.val</code></li>
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
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        def get_height(node):
            if not node:
                return 0
            cur = 1 + max(get_height(node.left), get_height(node.right))
            h[node] = cur
            return cur

        def dfs(node, depth, rest_h):
            if not node:
                return
            res[node.val] = rest_h
            depth += 1
            dfs(node.left, depth, max(depth + h.get(node.right, 0), rest_h))
            dfs(node.right, depth, max(depth + h.get(node.left, 0), rest_h))

        h, res = defaultdict(int), defaultdict(int)
        get_height(root)
        dfs(root, -1, 0)
        ans = []
        for v in queries:
            ans.append(res[v])
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
    Map<TreeNode, Integer> h = new HashMap<>();
    Map<Integer, Integer> res = new HashMap<>();
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root);
        dfs(root, -1, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = res.get(queries[i]);
        }
        return ans;
    }
    
    public void dfs(TreeNode node, int depth, int restHeight) {
        if (node == null) {
            return;
        }
        res.put(node.val, restHeight);
        depth++;
        dfs(node.left, depth, Math.max(restHeight, depth + h.getOrDefault(node.right, 0)));
        dfs(node.right, depth, Math.max(restHeight, depth + h.getOrDefault(node.left, 0)));
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ans = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        h.put(node, ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
