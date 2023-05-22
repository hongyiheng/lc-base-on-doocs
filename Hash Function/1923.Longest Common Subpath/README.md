# [1923. 最长公共子路径](https://leetcode-cn.com/problems/longest-common-subpath)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个国家由 <code>n</code> 个编号为 <code>0</code> 到 <code>n - 1</code> 的城市组成。在这个国家里，<strong>每两个</strong> 城市之间都有一条道路连接。</p>

<p>总共有 <code>m</code> 个编号为 <code>0</code> 到 <code>m - 1</code> 的朋友想在这个国家旅游。他们每一个人的路径都会包含一些城市。每条路径都由一个整数数组表示，每个整数数组表示一个朋友按顺序访问过的城市序列。同一个城市在一条路径中可能 <strong>重复</strong> 出现，但同一个城市在一条路径中不会连续出现。</p>

<p>给你一个整数 <code>n</code> 和二维数组 <code>paths</code> ，其中 <code>paths[i]</code> 是一个整数数组，表示第 <code>i</code> 个朋友走过的路径，请你返回 <strong>每一个</strong> 朋友都走过的 <strong>最长公共子路径</strong> 的长度，如果不存在公共子路径，请你返回 <code>0</code> 。</p>

<p>一个 <strong>子路径</strong> 指的是一条路径中连续的城市序列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>n = 5, paths = [[0,1,<strong>2,3</strong>,4],
                     [<strong>2,3</strong>,4],
                     [4,0,1,<strong>2,3</strong>]]
<b>输出：</b>2
<b>解释：</b>最长公共子路径为 [2,3] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>n = 3, paths = [[0],[1],[2]]
<b>输出：</b>0
<b>解释：</b>三条路径没有公共子路径。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>n = 5, paths = [[<strong>0</strong>,1,2,3,4],
                     [4,3,2,1,<strong>0</strong>]]
<b>输出：</b>1
<b>解释：</b>最长公共子路径为 [0]，[1]，[2]，[3] 和 [4] 。它们长度都为 1 。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 10<sup>5</sup></code></li>
	<li><code>m == paths.length</code></li>
	<li><code>2 <= m <= 10<sup>5</sup></code></li>
	<li><code>sum(paths[i].length) <= 10<sup>5</sup></code></li>
	<li><code>0 <= paths[i][j] < n</code></li>
	<li><code>paths[i]</code> 中同一个城市不会连续重复出现。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestCommonSubpath(self, n: int, paths: List[List[int]]) -> int:
        def check(k):
            cnt = defaultdict(int)
            for s in paths:
                vis = set()
                l = r = h1 = h2 = 0
                while r < len(s):
                    h1 = (h1 * base1 + s[r]) % M
                    h2 = (h2 * base2 + s[r]) % M
                    if r - l + 1 >= k:
                        if (h1, h2) not in vis:
                            cnt[(h1, h2)] += 1
                            vis.add((h1, h2))
                        h1 -= (s[l] * p1[k - 1])
                        h2 -= (s[l] * p2[k - 1])
                        l += 1
                    r += 1
            return max(cnt.values()) == len(paths)


        base1, base2, M = 131, 131313, int(1e9 + 7)
        m = 100010
        p1, p2 = [1] * m, [1] * m
        for i in range(1, m):
            p1[i] = p1[i - 1] * base1 % M
            p2[i] = p2[i - 1] * base2 % M
        l, r = 0, min([len(s) for s in paths])

        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    int M = (int)1e9 + 7, m = 100010;
    long[] p1 = new long[m], p2 = new long[m];
    int base1 = 131, base2 = 1313131;

    public int longestCommonSubpath(int n, int[][] paths) {
        p1[0] = p2[0] = 1;
        for (int i = 1; i < m; i++) {
            p1[i] = p1[i - 1] * base1 % M;
            p2[i] = p2[i - 1] * base2 % M;
        }
        int l = 0, r = m;
        for (int[] s : paths) {
            r = Math.min(r, s.length);
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, paths)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k, int[][] paths) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] s : paths) {
            long h1 = 0, h2 = 0;
            Set<String> vis = new HashSet<>();
            int l = 0, r = 0;
            while (r < s.length) {
                h1 = (h1 * base1 + s[r]) % M;
                h2 = (h2 * base2 + s[r]) % M;
                if (r - l + 1 >= k) {
                    String h = h1 + "_" + h2;
                    if (!vis.contains(h)) {
                        vis.add(h);
                        cnt.put(h, cnt.getOrDefault(h, 0) + 1);
                    }
                    h1 = (h1 - s[l] * p1[k - 1] % M + M) % M;
                    h2 = (h2 - s[l] * p2[k - 1] % M + M) % M;
                    l++;
                }
                r++;
            }
        }
        for (int v : cnt.values()) {
            if (v == paths.length) {
                return true;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
