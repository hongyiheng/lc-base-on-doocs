# [2657. 找到两个数组的前缀公共数组](https://leetcode-cn.com/problems/find-the-prefix-common-array-of-two-arrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong>&nbsp;开始长度为 <code>n</code>&nbsp;的整数排列&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;。</p>

<p><code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;的 <strong>前缀公共数组</strong>&nbsp;定义为数组&nbsp;<code>C</code>&nbsp;，其中&nbsp;<code>C[i]</code>&nbsp;是数组&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;到下标为&nbsp;<code>i</code>&nbsp;之前公共元素的数目。</p>

<p>请你返回 <code>A</code>&nbsp;和 <code>B</code>&nbsp;的 <strong>前缀公共数组</strong>&nbsp;。</p>

<p>如果一个长度为 <code>n</code>&nbsp;的数组包含 <code>1</code>&nbsp;到 <code>n</code>&nbsp;的元素恰好一次，我们称这个数组是一个长度为 <code>n</code>&nbsp;的 <strong>排列</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>A = [1,3,2,4], B = [3,1,2,4]
<b>输出：</b>[0,2,3,4]
<b>解释：</b>i = 0：没有公共元素，所以 C[0] = 0 。
i = 1：1 和 3 是两个数组的前缀公共元素，所以 C[1] = 2 。
i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
i = 3：1，2，3 和 4 是两个数组的前缀公共元素，所以 C[3] = 4 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>A = [2,3,1], B = [3,1,2]
<b>输出：</b>[0,1,3]
<b>解释：</b>i = 0：没有公共元素，所以 C[0] = 0 。
i = 1：只有 3 是公共元素，所以 C[1] = 1 。
i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= A.length == B.length == n &lt;= 50</code></li>
	<li><code>1 &lt;= A[i], B[i] &lt;= n</code></li>
	<li>题目保证&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;两个数组都是&nbsp;<code>n</code>&nbsp;个元素的排列。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findThePrefixCommonArray(self, a: List[int], b: List[int]) -> List[int]:
        ans = []
        p = q = 0
        for x, y in zip(a, b):
            p |= 1 << x
            q |= 1 << y
            ans.append((p & q).bit_count())
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long p = 0, q = 0;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int x = A[i], y = B[i];
            p |= 1L << x;
            q |= 1L << y;
            ans[i] = Long.bitCount(p & q);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
