# [646. 最长数对链](https://leetcode-cn.com/problems/maximum-length-of-pair-chain)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出 <code>n</code> 个数对。 在每一个数对中，第一个数字总是比第二个数字小。</p>

<p>现在，我们定义一种跟随关系，当且仅当 <code>b < c</code> 时，数对<code>(c, d)</code> 才可以跟在 <code>(a, b)</code> 后面。我们用这种形式来构造一个数对链。</p>

<p>给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>[[1,2], [2,3], [3,4]]
<strong>输出：</strong>2
<strong>解释：</strong>最长的数对链是 [1,2] -> [3,4]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>给出数对的个数在 <code>[1, 1000]</code> 范围内。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        def cmp(a, b):
            return a[1] - b[1]

        pairs.sort(key=cmp_to_key(cmp))
        ans, cur = 1, pairs[0][1]
        for p in pairs:
            if p[0] > cur:
                cur = p[1]
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1, cur = pairs[0][1];
        for (int[] p : pairs) {
            if (p[0] > cur) {
                cur = p[1];
                ans++;
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
