# [2217. 找到指定长度的回文数](https://leetcode-cn.com/problems/find-palindrome-with-fixed-length)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>queries</code>&nbsp;和一个 <strong>正</strong>&nbsp;整数&nbsp;<code>intLength</code>&nbsp;，请你返回一个数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code> 是长度为&nbsp;<code>intLength</code>&nbsp;的&nbsp;<strong>正回文数</strong> 中第<em>&nbsp;</em><code>queries[i]</code>&nbsp;小的数字，如果不存在这样的回文数，则为 <code>-1</code>&nbsp;。</p>

<p><strong>回文数</strong> 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>queries = [1,2,3,4,5,90], intLength = 3
<b>输出：</b>[101,111,121,131,141,999]
<strong>解释：</strong>
长度为 3 的最小回文数依次是：
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
第 90 个长度为 3 的回文数是 999 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>queries = [2,4,6], intLength = 4
<b>输出：</b>[1111,1331,1551]
<strong>解释：</strong>
长度为 4 的前 6 个回文数是：
1001, 1111, 1221, 1331, 1441 和 1551 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= queries.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= queries[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= intLength&nbsp;&lt;= 15</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        event = intLength % 2 == 0
        n = intLength // 2 if event else intLength // 2 + 1
        start = 10 ** (n - 1)
        ans = []
        for v in queries:
            left = str(start + v - 1)
            right = left[:] if event else left[:-1]
            right = right[::-1]
            cur = left + right
            if len(cur) == intLength:
                ans.append(int(cur))
            else:
                ans.append(-1)              
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        boolean event = intLength % 2 == 0;
        int n = event ? intLength / 2 : intLength / 2 + 1;
        int start = (int)Math.pow(10, n - 1);
        int m = queries.length;
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            StringBuilder left = new StringBuilder();
            left.append(start + queries[i] - 1);
            String cur = left.toString();
            String right = left.reverse().toString();
            cur += event ? right : right.substring(1);
            if (cur.length() == intLength) {
                ans[i] = Long.parseLong(cur);
            } else {
                ans[i] = -1;
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
