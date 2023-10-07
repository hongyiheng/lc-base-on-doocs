# [2571. 将整数减少到零需要的最少操作数](https://leetcode-cn.com/problems/minimum-operations-to-reduce-an-integer-to-0)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code> ，你可以执行下述操作 <strong>任意</strong> 次：</p>

<ul>
	<li><code>n</code> 加上或减去 <code>2</code> 的某个 <strong>幂</strong></li>
</ul>

<p>返回使 <code>n</code> 等于 <code>0</code> 需要执行的 <strong>最少</strong> 操作数。</p>

<p>如果 <code>x == 2<sup>i</sup></code> 且其中 <code>i &gt;= 0</code> ，则数字 <code>x</code> 是 <code>2</code> 的幂。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 39
<strong>输出：</strong>3
<strong>解释：</strong>我们可以执行下述操作：
- n 加上 2<sup>0</sup> = 1 ，得到 n = 40 。
- n 减去 2<sup>3</sup> = 8 ，得到 n = 32 。
- n 减去 2<sup>5</sup> = 32 ，得到 n = 0 。
可以证明使 n 等于 0 需要执行的最少操作数是 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 54
<strong>输出：</strong>3
<strong>解释：</strong>我们可以执行下述操作：
- n 加上 2<sup>1</sup> = 2 ，得到 n = 56 。
- n 加上 2<sup>3</sup> = 8 ，得到 n = 64 。
- n 减去 2<sup>6</sup> = 64 ，得到 n = 0 。
使 n 等于 0 需要执行的最少操作数是 3 。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minOperations(self, n: int) -> int:
        M = 20
        q = [False] * M
        for i in range(M):
            if n >> i & 1:
                q[i] = True
        ans = l = 0
        while l < M:
            if not q[l]:
                l += 1
                continue
            r = l
            while r < M and q[r + 1]:
                r += 1
            if r > l:
                q[r + 1] = True
            ans += 1
            l = r + 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minOperations(int n) {
        int M = 20;
        boolean[] q = new boolean[M];
        for (int i = 0; i < M; i++) {
            q[i] = (n >> i & 1) == 1;
        }
        int ans = 0, l = 0;
        while (l < M) {
            if (!q[l]) {
                l++;
                continue;
            }
            int r = l;
            while (r < M && q[r + 1]) {
                r++;
            }
            if (l < r) {
                q[r + 1] = true;
            }
            ans++;
            l = r + 1;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
