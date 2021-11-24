# [474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二进制字符串数组 <code>strs</code> 和两个整数 <code>m</code> 和 <code>n</code> 。</p>

<div class="MachineTrans-Lines">
<p class="MachineTrans-lang-zh-CN">请你找出并返回 <code>strs</code> 的最大子集的大小，该子集中 <strong>最多</strong> 有 <code>m</code> 个 <code>0</code> 和 <code>n</code> 个 <code>1</code> 。</p>

<p class="MachineTrans-lang-zh-CN">如果 <code>x</code> 的所有元素也是 <code>y</code> 的元素，集合 <code>x</code> 是集合 <code>y</code> 的 <strong>子集</strong> 。</p>
</div>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
<strong>输出：</strong>4
<strong>解释：</strong>最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["10", "0", "1"], m = 1, n = 1
<strong>输出：</strong>2
<strong>解释：</strong>最大的子集是 {"0", "1"} ，所以答案是 2 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= strs.length <= 600</code></li>
	<li><code>1 <= strs[i].length <= 100</code></li>
	<li><code>strs[i]</code> 仅由 <code>'0'</code> 和 <code>'1'</code> 组成</li>
	<li><code>1 <= m, n <= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        strs_len = len(strs)
        cnt = [[0 for _ in range(2)] for _ in range(strs_len)]
        for k in range(strs_len):
            item = strs[k]
            zero, one = 0, 0
            for i in range(len(item)):
                if '0' == item[i]:
                    zero += 1
                else:
                    one += 1
            cnt[k][0] = zero
            cnt[k][1] = one
        dp = [[[0 for _ in range(n + 1)] for _ in range(m + 1)] for _ in range(strs_len)]
        for i in range(m + 1):
            for j in range(n + 1):
                dp[0][i][j] = 1 if i >= cnt[0][0] and j >= cnt[0][1] else 0
        for k in range(1, strs_len):
            zero, one = cnt[k][0], cnt[k][1]
            for i in range(m + 1):
                for j in range(n + 1):
                    a = dp[k - 1][i][j]
                    b = dp[k - 1][i - zero][j - one] + 1 if i >= zero and j >= one else 0
                    dp[k][i][j] = max(a, b)
        return dp[strs_len - 1][m][n]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            int zero = 0, one = 0;
            for (char c : chars) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            cnt[i][0] = zero;
            cnt[i][1] = one;
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][i][j] = i >= cnt[0][0] && j >= cnt[0][1] ? 1 : 0;
            }
        }
        for (int k = 1; k < len; k++) {
            int zero = cnt[k][0], one = cnt[k][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int a = dp[k - 1][i][j];
                    int b = i >= zero && j >= one ? dp[k - 1][i - zero][j - one] + 1 : 0;
                    dp[k][i][j] = Math.max(a, b);
                }
            }
        }
        return dp[len - 1][m][n];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
