# [671. 二叉树中第二小的节点](https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 <code>2</code> 或 <code>0</code>。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。</p>

<p>更正式地说，<code>root.val = min(root.left.val, root.right.val)</code> 总成立。</p>

<p>给出这样的一个二叉树，你需要输出所有节点中的<strong>第二小的值。</strong>如果第二小的值不存在的话，输出 -1 <strong>。</strong></p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/smbt1.jpg" style="width: 431px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [2,2,5,null,null,5,7]
<strong>输出：</strong>5
<strong>解释：</strong>最小的值是 2 ，第二小的值是 5 。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/smbt2.jpg" style="width: 321px; height: 182px;" />
<pre>
<strong>输入：</strong>root = [2,2,2]
<strong>输出：</strong>-1
<strong>解释：</strong>最小的值是 2, 但是不存在第二小的值。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[1, 25]</code> 内</li>
	<li><code>1 <= Node.val <= 2<sup>31</sup> - 1</code></li>
	<li>对于树中每个节点 <code>root.val == min(root.left.val, root.right.val)</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {    
        dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.val != cur) {
            if (ans == -1) {
                ans = root.val;
            } else {
                ans = Math.min(ans, root.val);
            }
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
