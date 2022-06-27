# [522. 最长特殊序列 II](https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。</p>

<p><strong>子序列</strong>可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。</p>

<p>输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> &quot;aba&quot;, &quot;cdc&quot;, &quot;eae&quot;
<strong>输出:</strong> 3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>所有给定的字符串长度不会超过 10 。</li>
	<li>给定字符串列表的长度将在 [2, 50 ] 之间。</li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def check(a, b):
            m, n = len(a), len(b)
            if m > n:
                return False
            f = [[0] * (n + 1) for _ in range(m + 1)]
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if a[i - 1] == b[j - 1]:
                        f[i][j] = f[i - 1][j - 1] + 1
                    f[i][j] = max(f[i][j], f[i][j - 1]) 
                    f[i][j] = max(f[i][j], f[i - 1][j])
                    if f[i][j] == m:
                        return True
            return False

        n = len(strs)
        ans = -1
        for i in range(n):
            if len(strs[i]) < ans:
                continue
            flag = True
            for j in range(n):
                if i == j:
                    continue
                if check(strs[i], strs[j]):
                    flag = False
                    break
            if flag:
                ans = len(strs[i])
        return ans
                
                 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1, n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = strs[i].length();
            }
        }
        return ans;
    }
    
    public boolean check(String a, String b) {
        int m = a.length(), n = b.length();
        if (m > n) {
            return false;
        }
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (f[i][j] == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
