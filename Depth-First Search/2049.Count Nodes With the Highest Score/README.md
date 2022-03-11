# [2049. 统计最高分的节点数目](https://leetcode-cn.com/problems/count-nodes-with-the-highest-score)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵根节点为 <code>0</code> 的&nbsp;<strong>二叉树</strong>&nbsp;，它总共有 <code>n</code>&nbsp;个节点，节点编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;。同时给你一个下标从&nbsp;<strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>parents</code>&nbsp;表示这棵树，其中&nbsp;<code>parents[i]</code>&nbsp;是节点 <code>i</code>&nbsp;的父节点。由于节点 <code>0</code>&nbsp;是根，所以&nbsp;<code>parents[0] == -1</code>&nbsp;。</p>

<p>一个子树的 <strong>大小</strong>&nbsp;为这个子树内节点的数目。每个节点都有一个与之关联的&nbsp;<strong>分数</strong>&nbsp;。求出某个节点分数的方法是，将这个节点和与它相连的边全部 <strong>删除</strong>&nbsp;，剩余部分是若干个 <strong>非空</strong>&nbsp;子树，这个节点的 <strong>分数</strong>&nbsp;为所有这些子树 <strong>大小的乘积</strong>&nbsp;。</p>

<p>请你返回有 <strong>最高得分</strong>&nbsp;节点的 <strong>数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<p><img alt="example-1" src="https://assets.leetcode.com/uploads/2021/10/03/example-1.png" style="width: 604px; height: 266px;"></p>

<pre><b>输入：</b>parents = [-1,2,0,2,0]
<b>输出：</b>3
<strong>解释：</strong>
- 节点 0 的分数为：3 * 1 = 3
- 节点 1 的分数为：4 = 4
- 节点 2 的分数为：1 * 1 * 2 = 2
- 节点 3 的分数为：4 = 4
- 节点 4 的分数为：4 = 4
最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="example-2" src="https://assets.leetcode.com/uploads/2021/10/03/example-2.png" style="width: 95px; height: 143px;"></p>

<pre><b>输入：</b>parents = [-1,2,0]
<b>输出：</b>2
<strong>解释：</strong>
- 节点 0 的分数为：2 = 2
- 节点 1 的分数为：2 = 2
- 节点 2 的分数为：1 * 1 = 1
最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == parents.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>parents[0] == -1</code></li>
	<li>对于&nbsp;<code>i != 0</code>&nbsp;，有&nbsp;<code>0 &lt;= parents[i] &lt;= n - 1</code></li>
	<li><code>parents</code>&nbsp;表示一棵二叉树。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countHighestScoreNodes(self, parents: List[int]) -> int:
        ans, mx, n = 0, 0, len(parents)
        mp = dict()
        cnt = [-1] * n
        for i, v in enumerate(parents):
            if v == -1:
                continue
            children = mp.get(v, list())
            children.append(i)
            mp[v] = children

        def dfs(index):
            nonlocal mx, ans, n, cnt, mp
            left, right = 0, 0
            children = mp.get(index, list())
            if len(children) > 0:
                left = dfs(children[0]) if cnt[children[0]] == -1 else cnt[children[0]]
            if len(children) > 1:
                right = dfs(children[1]) if cnt[children[1]] == -1 else cnt[children[1]]
            source = max(1, left) * max(1, right) * max(1, (n - 1 - right - left))
            if source > mx:
                mx = source
                ans = 1
            elif source == mx:
                ans += 1
            cnt[index] = left + right + 1
            return cnt[index]

        dfs(0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Map<Integer, List<Integer>> mp;
    int[] cnt;
    int n, ans;
    long mx;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        mp = new HashMap<>();
        cnt = new int[n];
        Arrays.fill(cnt, -1);
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                continue;
            }
            mp.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        dfs(0);
        return ans;
    }

    public int dfs(int index) {
        int left = 0, right = 0;
        List<Integer> children = mp.getOrDefault(index, new ArrayList<>());
        if (children.size() > 0) {
            left = cnt[children.get(0)] != -1 ? cnt[children.get(0)] : dfs(children.get(0));
        }
        if (children.size() > 1) {
            right = cnt[children.get(1)] != -1 ? cnt[children.get(1)] : dfs(children.get(1));
        }
        long source = Math.max(1, left) * Math.max(1, right) * (long) Math.max(1, n - 1 - left - right);
        if (source > mx) {
            mx = source;
            ans = 1;
        } else if (source == mx) {
            ans++;
        }
        cnt[index] = left + right + 1;
        return cnt[index];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
