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
        def check(i, j):
            if i == j or len(strs[j]) < len(strs[j]):
                return False
            idx = 0
            for c in strs[j]:
                if c == strs[i][idx]:
                    idx += 1
                if idx == len(strs[i]):
                    return True
            return False
        
        n = len(strs)
        ans = -1
        for i in range(n):
            if len(strs[i]) < ans:
                continue
            same = False
            for j in range(n):
                if check(i, j):
                    same = True
                    break
            if not same:
                ans = len(strs[i])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean check(int i, int j, String[] strs) {
        if (i == j || strs[i].length() > strs[j].length()) {
            return false;
        }
        int idx = 0;
        for (char c : strs[j].toCharArray()) {
            if (c == strs[i].charAt(idx)) {
                if (++idx == strs[i].length()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) {
                continue;
            }
            boolean same = false;
            for (int j = 0; j < n; j++) {
                if (check(i, j, strs)) {
                    same = true;
                    break;
                }
            }
            if (!same) {
                ans = strs[i].length();
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
