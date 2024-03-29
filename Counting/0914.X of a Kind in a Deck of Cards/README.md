# [914. 卡牌分组](https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一副牌，每张牌上都写着一个整数。</p>

<p>此时，你需要选定一个数字 <code>X</code>，使我们可以将整副牌按下述规则分成 1 组或更多组：</p>

<ul>
	<li>每组都有&nbsp;<code>X</code>&nbsp;张牌。</li>
	<li>组内所有的牌上都写着相同的整数。</li>
</ul>

<p>仅当你可选的 <code>X &gt;= 2</code> 时返回&nbsp;<code>true</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[1,2,3,4,4,3,2,1]
<strong>输出：</strong>true
<strong>解释：</strong>可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[1,1,1,2,2,2,3,3]
<strong>输出：</strong>false
<strong>解释：</strong>没有满足要求的分组。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[1]
<strong>输出：</strong>false
<strong>解释：</strong>没有满足要求的分组。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>[1,1]
<strong>输出：</strong>true
<strong>解释：</strong>可行的分组是 [1,1]
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>[1,1,2,2,2,2]
<strong>输出：</strong>true
<strong>解释：</strong>可行的分组是 [1,1]，[2,2]，[2,2]
</pre>

<p><br>
<strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= deck.length &lt;= 10000</code></li>
	<li><code>0 &lt;= deck[i] &lt;&nbsp;10000</code></li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        def gcd(a, b):
            return a if b == 0 else gcd(b, a % b)

        cnt = Counter(deck)
        x = 0
        for v in cnt.values():
            x = gcd(v, x)
            if x == 1:
                return False
        return x >= 2
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int k : deck) {
            int v = cnt.getOrDefault(k, 0) + 1;
            cnt.put(k, v);
        }
        int x = 0;
        for (int v : cnt.values()) {
            x = gcd(x, v);
            if (x == 1) {
                return false;
            }
        }
        return x >= 2;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
