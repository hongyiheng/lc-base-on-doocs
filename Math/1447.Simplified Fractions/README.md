# [1447. 最简分数](https://leetcode-cn.com/problems/simplified-fractions)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数&nbsp;<code>n</code>&nbsp;，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于&nbsp;&nbsp;<code>n</code>&nbsp;的 <strong>最简&nbsp;</strong>分数&nbsp;。分数可以以 <strong>任意&nbsp;</strong>顺序返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 2
<strong>输出：</strong>[&quot;1/2&quot;]
<strong>解释：</strong>&quot;1/2&quot; 是唯一一个分母小于等于 2 的最简分数。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 3
<strong>输出：</strong>[&quot;1/2&quot;,&quot;1/3&quot;,&quot;2/3&quot;]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 4
<strong>输出：</strong>[&quot;1/2&quot;,&quot;1/3&quot;,&quot;1/4&quot;,&quot;2/3&quot;,&quot;3/4&quot;]
<strong>解释：</strong>&quot;2/4&quot; 不是最简分数，因为它可以化简为 &quot;1/2&quot; 。</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>n = 1
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)

        ans = []
        for i in range(2, n + 1):
            for j in range(1, i):
                if gcd(i, j) == 1:
                    ans.append(str(j) + "/" + str(i))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
