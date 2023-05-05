# [1128. 等价多米诺骨牌对的数量](https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由一些多米诺骨牌组成的列表&nbsp;<code>dominoes</code>。</p>

<p>如果其中某一张多米诺骨牌可以通过旋转 <code>0</code>&nbsp;度或 <code>180</code> 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。</p>

<p>形式上，<code>dominoes[i] = [a, b]</code>&nbsp;和&nbsp;<code>dominoes[j] = [c, d]</code>&nbsp;等价的前提是&nbsp;<code>a==c</code>&nbsp;且&nbsp;<code>b==d</code>，或是&nbsp;<code>a==d</code> 且&nbsp;<code>b==c</code>。</p>

<p>在&nbsp;<code>0 &lt;= i &lt; j &lt; dominoes.length</code>&nbsp;的前提下，找出满足&nbsp;<code>dominoes[i]</code> 和&nbsp;<code>dominoes[j]</code>&nbsp;等价的骨牌对 <code>(i, j)</code> 的数量。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>dominoes = [[1,2],[2,1],[3,4],[5,6]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= dominoes.length &lt;= 40000</code></li>
	<li><code>1 &lt;= dominoes[i][j] &lt;= 9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        mp = defaultdict(int)
        ans = 0
        for a, b in dominoes:
            v = (1 << a) | (1 << b)
            ans += mp[v]
            mp[v] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int[] p : dominoes) {
            int v = (1 << p[0]) | (1 << p[1]);
            ans += mp.getOrDefault(v, 0);
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
