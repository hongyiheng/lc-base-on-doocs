# [886. 可能的二分法](https://leetcode-cn.com/problems/possible-bipartition)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一组 <code>N</code> 人（编号为 <code>1, 2, ..., N</code>）， 我们想把每个人分进<strong>任意</strong>大小的两组。</p>

<p>每个人都可能不喜欢其他人，那么他们不应该属于同一组。</p>

<p>形式上，如果 <code>dislikes[i] = [a, b]</code>，表示不允许将编号为 <code>a</code> 和 <code>b</code> 的人归入同一组。</p>

<p>当可以用这种方法将所有人分进两组时，返回 <code>true</code>；否则返回 <code>false</code>。</p>

<p> </p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>N = 4, dislikes = [[1,2],[1,3],[2,4]]
<strong>输出：</strong>true
<strong>解释：</strong>group1 [1,4], group2 [2,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>N = 3, dislikes = [[1,2],[1,3],[2,3]]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= N <= 2000</code></li>
	<li><code>0 <= dislikes.length <= 10000</code></li>
	<li><code>dislikes[i].length == 2</code></li>
	<li><code>1 <= dislikes[i][j] <= N</code></li>
	<li><code>dislikes[i][0] < dislikes[i][1]</code></li>
	<li>对于 <code>dislikes[i] == dislikes[j]</code> 不存在 <code>i != j</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        def dfs(i, c):
            color[i] = c
            for j in g[i]:
                if color[j] == c:
                    return False
                if color[j] == -1 and not dfs(j, c ^ 1):
                    return False
            return True
        
        g = defaultdict(list)
        for a, b in dislikes:
            g[a].append(b)
            g[b].append(a)
        color = [-1] * (n + 1)
        for i in range(1, n + 1):
            if color[i] == -1:
                if not dfs(i, 1):
                    return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] color;

    public boolean dfs(int i, int c) {
        color[i] = c;
        for (int j : g.getOrDefault(i, new ArrayList<>())) {
            if (color[j] == c) {
                return false;
            }
            if (color[j] == -1 && !dfs(j, c ^ 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int[] v : dislikes) {
            g.computeIfAbsent(v[0], k -> new ArrayList()).add(v[1]);
            g.computeIfAbsent(v[1], k -> new ArrayList()).add(v[0]);
        }
        color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i < n + 1; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
