# [2385. 感染二叉树需要的总时间](https://leetcode-cn.com/problems/amount-of-time-for-binary-tree-to-be-infected)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵二叉树的根节点 <code>root</code> ，二叉树中节点的值 <strong>互不相同</strong> 。另给你一个整数 <code>start</code> 。在第 <code>0</code> 分钟，<strong>感染</strong> 将会从值为 <code>start</code> 的节点开始爆发。</p>

<p>每分钟，如果节点满足以下全部条件，就会被感染：</p>

<ul>
	<li>节点此前还没有感染。</li>
	<li>节点与一个已感染节点相邻。</li>
</ul>

<p>返回感染整棵树需要的分钟数<em>。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/06/25/image-20220625231744-1.png" style="width: 400px; height: 306px;">
<pre><strong>输入：</strong>root = [1,5,3,null,4,10,6,9,2], start = 3
<strong>输出：</strong>4
<strong>解释：</strong>节点按以下过程被感染：
- 第 0 分钟：节点 3
- 第 1 分钟：节点 1、10、6
- 第 2 分钟：节点5
- 第 3 分钟：节点 4
- 第 4 分钟：节点 9 和 2
感染整棵树需要 4 分钟，所以返回 4 。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/06/25/image-20220625231812-2.png" style="width: 75px; height: 66px;">
<pre><strong>输入：</strong>root = [1], start = 1
<strong>输出：</strong>0
<strong>解释：</strong>第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目在范围 <code>[1, 10<sup>5</sup>]</code> 内</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>每个节点的值 <strong>互不相同</strong></li>
	<li>树中必定存在值为 <code>start</code> 的节点</li>
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
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        mp = defaultdict(list)
        q = deque()
        vis = set()

        def dfs(parent, root):
            if not root:
                return
            if root.val == start:
                q.append(root)
                vis.add(root)
            if parent:
                mp[parent].append(root)
                mp[root].append(parent)
            dfs(root, root.left)
            dfs(root, root.right)

        dfs(None, root)
        ans = -1
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                for v in mp[cur]:
                    if v in vis:
                        continue
                    q.append(v)
                    vis.add(v)
            ans += 1
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
    Map<TreeNode, List<TreeNode>> mp;
    int t;
    Deque<TreeNode> q;
    Set<Integer> vis;

    public int amountOfTime(TreeNode root, int start) {
        mp = new HashMap<>();
        q = new ArrayDeque<>();
        vis = new HashSet<>();
        t = start;
        dfs(null, root);
        int ans = -1;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                for (TreeNode v : mp.getOrDefault(cur, new ArrayList<>())) {
                    if (vis.contains(v.val)) {
                        continue;
                    }
                    q.addLast(v);
                    vis.add(v.val);
                }
            }
            ans++;
        }
        return ans;
    }

    public void dfs(TreeNode parent, TreeNode root) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            mp.computeIfAbsent(root, k -> new ArrayList<>()).add(parent);
            mp.computeIfAbsent(parent, k -> new ArrayList<>()).add(root);
        }
        if (root.val == t) {
            q.addLast(root);
            vis.add(root.val);
        }
        dfs(root, root.left);
        dfs(root, root.right);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
