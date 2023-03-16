# [1361. 验证二叉树](https://leetcode-cn.com/problems/validate-binary-tree-nodes)



## 题目描述

<!-- 这里写题目描述 -->

<p>二叉树上有 <code>n</code>&nbsp;个节点，按从&nbsp;<code>0</code>&nbsp;到 <code>n - 1</code>&nbsp;编号，其中节点&nbsp;<code>i</code>&nbsp;的两个子节点分别是&nbsp;<code>leftChild[i]</code>&nbsp;和&nbsp;<code>rightChild[i]</code>。</p>

<p>只有 <strong>所有</strong> 节点能够形成且 <strong>只</strong> 形成 <strong>一颗</strong>&nbsp;有效的二叉树时，返回&nbsp;<code>true</code>；否则返回 <code>false</code>。</p>

<p>如果节点&nbsp;<code>i</code>&nbsp;没有左子节点，那么&nbsp;<code>leftChild[i]</code>&nbsp;就等于&nbsp;<code>-1</code>。右子节点也符合该规则。</p>

<p>注意：节点没有值，本问题中仅仅使用节点编号。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex1.png" style="height: 287px; width: 195px;"></strong></p>

<pre><strong>输入：</strong>n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex2.png" style="height: 272px; width: 183px;"></strong></p>

<pre><strong>输入：</strong>n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex3.png" style="height: 174px; width: 82px;"></strong></p>

<pre><strong>输入：</strong>n = 2, leftChild = [1,0], rightChild = [-1,-1]
<strong>输出：</strong>false
</pre>

<p><strong>示例 4：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/23/1503_ex4.png" style="height: 191px; width: 470px;"></strong></p>

<pre><strong>输入：</strong>n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10^4</code></li>
	<li><code>leftChild.length == rightChild.length == n</code></li>
	<li><code>-1 &lt;= leftChild[i], rightChild[i] &lt;= n - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        vis = [False] * n
        for i in range(n):
            if leftChild[i] != -1:
                if vis[leftChild[i]]:
                    return False
                vis[leftChild[i]] = True
            if rightChild[i] != -1:
                if vis[rightChild[i]]:
                    return False
                vis[rightChild[i]] = True
        q = deque()
        for i, b in enumerate(vis):
            if not b:
                q.append(i)
        if len(q) != 1:
            return False
        cnt = 0
        while q:
            for _ in range(len(q)):
                cur = q.popleft()
                cnt += 1
                if leftChild[cur] != -1:
                    q.append(leftChild[cur])
                if rightChild[cur] != -1:
                    q.append(rightChild[cur])
        return cnt == n
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (vis[leftChild[i]]) {
                    return false;
                }
                vis[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (vis[rightChild[i]]) {
                    return false;
                }
                vis[rightChild[i]] = true;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                q.add(i);
            }
        }
        if (q.size() != 1) {
            return false;
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int cur = q.pollFirst();
                cnt++;
                if (leftChild[cur] != -1) {
                    q.addLast(leftChild[cur]);
                }
                if (rightChild[cur] != -1) {
                    q.addLast(rightChild[cur]);
                }
            }
        }
        return cnt == n;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
