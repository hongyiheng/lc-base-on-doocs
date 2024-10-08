# [997. 找到小镇的法官](https://leetcode-cn.com/problems/find-the-town-judge)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一个小镇里，按从 <code>1</code> 到 <code>n</code> 为 <code>n</code> 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。</p>

<p>如果小镇的法官真的存在，那么：</p>

<ol>
	<li>小镇的法官不相信任何人。</li>
	<li>每个人（除了小镇法官外）都信任小镇的法官。</li>
	<li>只有一个人同时满足条件 1 和条件 2 。</li>
</ol>

<p>给定数组 <code>trust</code>，该数组由信任对 <code>trust[i] = [a, b]</code> 组成，表示编号为 <code>a</code> 的人信任编号为 <code>b</code> 的人。</p>

<p>如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 <code>-1</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2, trust = [[1,2]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3, trust = [[1,3],[2,3]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3, trust = [[1,3],[2,3],[3,1]]
<strong>输出：</strong>-1
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>n = 3, trust = [[1,2],[2,3]]
<strong>输出：</strong>-1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
<strong>输出：</strong>3</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 1000</code></li>
	<li><code>0 <= trust.length <= 10<sup>4</sup></code></li>
	<li><code>trust[i].length == 2</code></li>
	<li><code>trust[i]</code> 互不相同</li>
	<li><code>trust[i][0] != trust[i][1]</code></li>
	<li><code>1 <= trust[i][0], trust[i][1] <= n</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        q = [[0] * 2 for _ in range(n + 1)]
        for u, v in trust:
            q[u][0] += 1
            q[v][1] += 1
        for i, v in enumerate(q):
            if i == 0:
                continue
            if v[0] == 0 and v[1] == n - 1:
                return i
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] q = new int[n + 1][2];
        for (int[] t : trust) {
            q[t[0]][0]++;
            q[t[1]][1]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (q[i][0] == 0 && q[i][1] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
