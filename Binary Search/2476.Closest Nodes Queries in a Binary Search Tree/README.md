# [2476. 二叉搜索树最近节点查询](https://leetcode-cn.com/problems/closest-nodes-queries-in-a-binary-search-tree)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>二叉搜索树</strong> 的根节点 <code>root</code> ，和一个由正整数组成、长度为 <code>n</code> 的数组 <code>queries</code> 。</p>

<p>请你找出一个长度为 <code>n</code> 的 <strong>二维</strong> 答案数组 <code>answer</code> ，其中 <code>answer[i] = [min<sub>i</sub>, max<sub>i</sub>]</code> ：</p>

<ul>
	<li><code>min<sub>i</sub></code> 是树中小于等于&nbsp;<code>queries[i]</code> 的 <strong>最大值</strong> 。如果不存在这样的值，则使用 <code>-1</code> 代替。</li>
	<li><code>max<sub>i</sub></code> 是树中大于等于&nbsp;<code>queries[i]</code> 的 <strong>最小值</strong> 。如果不存在这样的值，则使用 <code>-1</code> 代替。</li>
</ul>

<p>返回数组 <code>answer</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1 ：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/09/28/bstreeedrawioo.png" style="width: 261px; height: 281px;" /></p>

<pre>
<strong>输入：</strong>root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
<strong>输出：</strong>[[2,2],[4,6],[15,-1]]
<strong>解释：</strong>按下面的描述找出并返回查询的答案：
- 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
- 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
- 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
</pre>

<p><strong>示例 2 ：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/09/28/bstttreee.png" style="width: 101px; height: 121px;" /></p>

<pre>
<strong>输入：</strong>root = [4,null,9], queries = [3]
<strong>输出：</strong>[[-1,4]]
<strong>解释：</strong>树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目在范围 <code>[2, 10<sup>5</sup>]</code> 内</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
	<li><code>n == queries.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries[i] &lt;= 10<sup>6</sup></code></li>
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
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            q.append(root.val)
            dfs(root.right)

        def find(i, l):
            if i >= len(qs):
                return
            t, j = qs[i]
            r = len(q) - 1
            while l < r:
                mid = (l + r) >> 1
                if q[mid] >= t:
                    r = mid
                else:
                    l = mid + 1
            if q[r] >= t:
                ans[j][1] = q[r]
            if q[r] <= t:
                ans[j][0] = q[r]
            elif r > 0 and q[r - 1] <= t:
                ans[j][0] = q[r - 1]
            find(i + 1, l)

        q = []
        dfs(root)
        qs = [(v, i) for i, v in enumerate(queries)]
        qs.sort()
        ans = [[-1, -1] for _ in range(len(queries))]
        find(0, 0)
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
    List<Integer> q = new ArrayList<>();
    List<Integer> qs = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        q.add(root.val);
        dfs(root.right);
    }

    public void search(int i, int l, List<Integer> queries, List<List<Integer>> res) {
        if (i == qs.size()) {
            return;
        }
        int j = qs.get(i), t = queries.get(j), r = q.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (q.get(r) <= t) {
            res.get(j).set(0, q.get(r));
        } else if (r > 0 && q.get(r - 1) <= t) {
            res.get(j).set(0, q.get(r - 1));
        }
        if (q.get(r) >= t) {
            res.get(j).set(1, q.get(r));
        }
        search(i + 1, l, queries, res);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        for (int i = 0; i < queries.size(); i++) {
            qs.add(i);
        }
        qs.sort((a, b) -> queries.get(a) - queries.get(b));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> item = new ArrayList<>();
            item.add(-1);
            item.add(-1);
            res.add(item);
        }
        search(0, 0, queries, res);
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
