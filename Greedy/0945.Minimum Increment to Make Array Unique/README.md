# [945. 使数组唯一的最小增量](https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定整数数组 A，每次 <em>move</em> 操作将会选择任意&nbsp;<code>A[i]</code>，并将其递增&nbsp;<code>1</code>。</p>

<p>返回使 <code>A</code>&nbsp;中的每个值都是唯一的最少操作次数。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入：</strong>[1,2,2]
<strong>输出：</strong>1
<strong>解释：</strong>经过一次 <em>move</em> 操作，数组将变为 [1, 2, 3]。</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入：</strong>[3,2,1,2,1,7]
<strong>输出：</strong>6
<strong>解释：</strong>经过 6 次 <em>move</em> 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 <em>move</em> 操作是不能让数组的每个值唯一的。
</pre>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= A.length &lt;= 40000</code></li>
	<li><code>0 &lt;= A[i] &lt; 40000</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        cnt = [0] * 110000
        for v in nums:
            cnt[v] += 1
        s = ans = 0
        for i in range(110000):
            if cnt[i] >= 1:
                s += cnt[i] - 1
            elif s:
                s -= 1
            ans += s
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] cnt = new int[110000];
        for (int v : nums) {
            cnt[v]++;
        }
        int ans = 0, s = 0;
        for (int i = 0; i < 110000; i++) {
            if (cnt[i] >= 1) {
                s += cnt[i] - 1;
            } else if (s > 0) {
                s--;
            }
            ans += s;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
