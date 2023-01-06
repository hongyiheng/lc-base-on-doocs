# [863. 二叉树中所有距离为 K 的结点](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树（具有根结点&nbsp;<code>root</code>），&nbsp;一个目标结点&nbsp;<code>target</code>&nbsp;，和一个整数值 <code>K</code> 。</p>

<p>返回到目标结点 <code>target</code> 距离为 <code>K</code> 的所有结点的值的列表。 答案可以以任何顺序返回。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
<strong>输出：</strong>[7,4,1]
<strong>解释：</strong>
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/28/sketch0.png" style="height: 240px; width: 280px;">

注意，输入的 &quot;root&quot; 和 &quot;target&quot; 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>给定的树是非空的。</li>
	<li>树上的每个结点都具有唯一的值&nbsp;<code>0 &lt;= node.val &lt;= 500</code>&nbsp;。</li>
	<li>目标结点&nbsp;<code>target</code>&nbsp;是树上的结点。</li>
	<li><code>0 &lt;= K &lt;= 1000</code>.</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        edges = defaultdict(list)
        q = [root]
        while q:
            cur = q.pop()
            if cur.left:
                edges[cur.val].append(cur.left.val)
                edges[cur.left.val].append(cur.val)
                q.append(cur.left)
            if cur.right:
                edges[cur.val].append(cur.right.val)
                edges[cur.right.val].append(cur.val)
                q.append(cur.right)
        q = [target.val]
        vis = set()
        vis.add(target.val)
        ans = []
        while q:
            for _ in range(len(q)):
                cur = q.pop(0)
                if k == 0:
                    ans.append(cur)
                    continue
                for to in edges[cur]:
                    if to in vis:
                        continue
                    vis.add(to)
                    q.append(to)
            k -= 1
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.pollLast();
            if (cur.left != null) {
                edges.computeIfAbsent(cur.val, e -> new ArrayList<>()).add(cur.left.val);
                edges.computeIfAbsent(cur.left.val, e -> new ArrayList<>()).add(cur.val);
                q.addLast(cur.left);
            }
            if (cur.right != null) {
                edges.computeIfAbsent(cur.val, e -> new ArrayList<>()).add(cur.right.val);
                edges.computeIfAbsent(cur.right.val, e -> new ArrayList<>()).add(cur.val);
                q.addLast(cur.right);
            }
        }
        Deque<Integer> q2 = new ArrayDeque<>();
        q2.addLast(target.val);
        Set<Integer> vis = new HashSet<>();
        vis.add(target.val);
        List<Integer> ans = new ArrayList<>();
        while (!q2.isEmpty()) {
            int m = q2.size();
            for (int i = 0; i < m; i++) {
                int cur = q2.pollFirst();
                if (k == 0) {
                    ans.add(cur);
                    continue;
                }
                for (int to : edges.getOrDefault(cur, new ArrayList<>())) {
                    if (vis.contains(to)) {
                        continue;
                    }
                    vis.add(to);
                    q2.addLast(to);
                }
            }
            k--;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
