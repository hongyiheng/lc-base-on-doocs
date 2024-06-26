# [2998. 使 X 和 Y 相等的最少操作次数](https://leetcode.cn/problems/minimum-number-of-operations-to-make-x-and-y-equal)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个正整数&nbsp;<code>x</code> 和&nbsp;<code>y</code>&nbsp;。</p>

<p>一次操作中，你可以执行以下四种操作之一：</p>

<ol>
	<li>如果 <code>x</code>&nbsp;是 <code>11</code>&nbsp;的倍数，将&nbsp;<code>x</code>&nbsp;除以&nbsp;<code>11</code>&nbsp;。</li>
	<li>如果 <code>x</code>&nbsp;是 <code>5</code>&nbsp;的倍数，将 <code>x</code>&nbsp;除以 <code>5</code>&nbsp;。</li>
	<li>将&nbsp;<code>x</code> 减&nbsp;<code>1</code>&nbsp;。</li>
	<li>将&nbsp;<code>x</code>&nbsp;加&nbsp;<code>1</code>&nbsp;。</li>
</ol>

<p>请你返回让 <code>x</code>&nbsp;和 <code>y</code>&nbsp;相等的 <strong>最少</strong>&nbsp;操作次数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<b>输入：</b>x = 26, y = 1
<b>输出：</b>3
<b>解释</b><strong>：</strong>我们可以通过以下操作将 26 变为 1 ：
1. 将 x 减 1
2. 将 x 除以 5
3. 将 x 除以 5
将 26 变为 1 最少需要 3 次操作。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<b>输入：</b>x = 54, y = 2
<b>输出：</b>4
<b>解释：</b>我们可以通过以下操作将 54 变为 2 ：
1. 将 x 加 1
2. 将 x 除以 11
3. 将 x 除以 5
4. 将 x 加 1
将 54 变为 2 最少需要 4 次操作。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<b>输入：</b>x = 25, y = 30
<b>输出：</b>5
<b>解释：</b>我们可以通过以下操作将 25 变为 30 ：
1. 将 x 加 1
2. 将 x 加 1
3. 将 x 加 1
4. 将 x 加 1
5. 将 x 加 1
将 25 变为 30 最少需要 5 次操作。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= x, y &lt;= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumOperationsToMakeEqual(self, x: int, y: int) -> int:
        ans = 0
        q = deque([x])
        vis = {x}
        while q:
            for _ in range(len(q)):
                v = q.popleft()
                if v == y:
                    return ans
                for k in [5, 11]:
                    if not v % k and v // k not in vis:
                        vis.add(v // k)
                        q.append(v // k)
                for k in [-1, 1]:
                    if v + k not in vis:
                        vis.add(v + k)
                        q.append(v + k)
            ans += 1
        return ans 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        int ans = 0;
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>(Arrays.asList(x));
        q.add(x);
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int v = q.pollFirst();
                if (v == y) {
                    return ans;
                }
                for (int k : Arrays.asList(5, 11)) {
                    if (v % k == 0 && !vis.contains(v / k)) {
                        q.addLast(v / k);
                        vis.add(v / k);
                    }
                }
                for (int k : Arrays.asList(-1, 1)) {
                    if (!vis.contains(v + k)) {
                        q.addLast(v + k);
                        vis.add(v + k);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
