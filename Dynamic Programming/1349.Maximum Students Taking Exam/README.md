# [1349. 参加考试的最大学生数](https://leetcode-cn.com/problems/maximum-students-taking-exam)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个&nbsp;<code>m&nbsp;* n</code>&nbsp;的矩阵 <code>seats</code>&nbsp;表示教室中的座位分布。如果座位是坏的（不可用），就用&nbsp;<code>&#39;#&#39;</code>&nbsp;表示；否则，用&nbsp;<code>&#39;.&#39;</code>&nbsp;表示。</p>

<p>学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。</p>

<p>学生必须坐在状况良好的座位上。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/09/image.png" style="height: 197px; width: 339px;"></p>

<pre><strong>输入：</strong>seats = [[&quot;#&quot;,&quot;.&quot;,&quot;#&quot;,&quot;#&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;             [&quot;.&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;#&quot;,&quot;.&quot;],
&nbsp;             [&quot;#&quot;,&quot;.&quot;,&quot;#&quot;,&quot;#&quot;,&quot;.&quot;,&quot;#&quot;]]
<strong>输出：</strong>4
<strong>解释：</strong>教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>seats = [[&quot;.&quot;,&quot;#&quot;],
&nbsp;             [&quot;#&quot;,&quot;#&quot;],
&nbsp;             [&quot;#&quot;,&quot;.&quot;],
&nbsp;             [&quot;#&quot;,&quot;#&quot;],
&nbsp;             [&quot;.&quot;,&quot;#&quot;]]
<strong>输出：</strong>3
<strong>解释：</strong>让所有学生坐在可用的座位上。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>seats = [[&quot;#&quot;,&quot;.&quot;,&quot;<strong>.</strong>&quot;,&quot;.&quot;,&quot;#&quot;],
&nbsp;             [&quot;<strong>.</strong>&quot;,&quot;#&quot;,&quot;<strong>.</strong>&quot;,&quot;#&quot;,&quot;<strong>.</strong>&quot;],
&nbsp;             [&quot;<strong>.</strong>&quot;,&quot;.&quot;,&quot;#&quot;,&quot;.&quot;,&quot;<strong>.</strong>&quot;],
&nbsp;             [&quot;<strong>.</strong>&quot;,&quot;#&quot;,&quot;<strong>.</strong>&quot;,&quot;#&quot;,&quot;<strong>.</strong>&quot;],
&nbsp;             [&quot;#&quot;,&quot;.&quot;,&quot;<strong>.</strong>&quot;,&quot;.&quot;,&quot;#&quot;]]
<strong>输出：</strong>10
<strong>解释：</strong>让学生坐在第 1、3 和 5 列的可用座位上。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>seats</code>&nbsp;只包含字符&nbsp;<code>&#39;.&#39;&nbsp;和</code><code>&#39;#&#39;</code></li>
	<li><code>m ==&nbsp;seats.length</code></li>
	<li><code>n ==&nbsp;seats[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 8</code></li>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxStudents(self, seats: List[List[str]]) -> int:
        def dfs(i, mask):
            if i == n:
                masks.add(mask)
                return
            if not i or mask >> (i - 1) & 1 == 0:
                dfs(i + 1, mask | 1 << i)
            dfs(i + 1, mask)

        def check(u, v):
            for i in range(n):
                if not v >> i & 1:
                    continue
                if i > 0 and u >> (i - 1) & 1:
                    return False
                if i < n - 1 and u >> (i + 1) & 1:
                    return False
            return True

        def get_val(mask, i):
            ans = 0
            for j in range(n):
                if mask >> j & 1 and seats[i][j] == '.':
                    ans += 1
            return ans

        m, n = len(seats), len(seats[0])
        masks = set()
        dfs(0, 0)
        g = defaultdict(list)
        for u in masks:
            for v in masks:
                if check(u, v):
                    g[v].append(u)

        f = defaultdict(int)
        for mask in masks:
            f[(0, mask)] = get_val(mask, 0)

        for i in range(1, m):
            for mask in masks:
                v = get_val(mask, i)
                for last_m in g[mask]:
                    f[(i, mask)] = max(f[(i, mask)], f[(i - 1, last_m)] + v)

        return max([f[(m - 1, mask)] for mask in masks])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Set<Integer> masks;
    int m, n;

    public void dfs(int i, int mask) {
        if (i == n) {
            masks.add(mask);
            return;
        }
        if (i == 0 || (mask >> (i - 1) & 1) == 0) {
            dfs(i + 1, mask | 1 << i);
        }
        dfs(i + 1, mask);
    }

    public boolean check(int u, int v) {
        for (int i = 0; i < n; i++) {
            if ((v >> i & 1) == 0) {
                continue;
            }
            if (i > 0 && (u >> (i - 1) & 1) == 1) {
                return false;
            }
            if (i < n - 1 && (u >> (i + 1) & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    public int getVal(char[][] seats, int i, int mask) {
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (seats[i][j] == '.' && (mask >> j & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        masks = new HashSet<>();
        dfs(0, 0);
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int u : masks) {
            for (int v : masks) {
                if (check(u, v)) {
                    g.computeIfAbsent(v, k -> new HashSet<>()).add(u);
                }
            }
        }
        Map<String, Integer> f = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int v : masks) {
                int w = getVal(seats, i, v);
                for (int u : g.getOrDefault(v, new HashSet<>())) {
                    f.put(i + ":" + v, Math.max(f.getOrDefault(i + ":" + v, 0), f.getOrDefault(i - 1 + ":" + u, 0) + w));
                }
            }
        }
        int ans = 0;
        for (int mask : masks) {
            ans = Math.max(ans, f.get(m - 1 + ":" + mask));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
