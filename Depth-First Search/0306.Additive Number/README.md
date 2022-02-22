# [306. 累加数](https://leetcode-cn.com/problems/additive-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>累加数是一个字符串，组成它的数字可以形成累加序列。</p>

<p>一个有效的累加序列必须<strong>至少</strong>包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。</p>

<p>给定一个只包含数字&nbsp;<code>&#39;0&#39;-&#39;9&#39;</code>&nbsp;的字符串，编写一个算法来判断给定输入是否是累加数。</p>

<p><strong>说明:&nbsp;</strong>累加序列里的数不会以 0 开头，所以不会出现&nbsp;<code>1, 2, 03</code> 或者&nbsp;<code>1, 02, 3</code>&nbsp;的情况。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> <code>&quot;112358&quot;</code>
<strong>输出:</strong> true 
<strong>解释: </strong>累加序列为: <code>1, 1, 2, 3, 5, 8 </code>。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> <code>&quot;199100199&quot;</code>
<strong>输出:</strong> true 
<strong>解释: </strong>累加序列为: <code>1, 99, 100, 199。</code>1 + 99 = 100, 99 + 100 = 199</pre>

<p><strong>进阶:</strong><br>
你如何处理一个溢出的过大的整数输入?</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)

        def dfs(index, sum, pre, count):
            if index == n:
                return count >= 3
            cur = 0
            for i in range(index, n):
                if i > index and ord(num[index]) - ord('0') == 0:
                    break
                cur = cur * 10 + ord(num[i]) - ord('0')
                if count >= 2:
                    if cur < sum:
                        continue
                    elif cur > sum:
                        break
                if dfs(i + 1, cur + pre, cur, count + 1):
                    return True
            return False
        
        return dfs(0, 0, 0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    String s;
    int n;
    public boolean isAdditiveNumber(String num) {
        s = num;
        n = num.length();
        return dfs(0, 0, 0, 0);
    }

    public boolean dfs(int index, long sum, long pre, int count) {
        if (index == n) {
            return count >= 3;
        }
        long cur = 0;
        for (int i = index; i < n; i++) {
            if ((index == 0 || index == 1) && i >= 19) {
                break;
            }
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            cur = cur * 10 + s.charAt(i) - '0';
            if (count >= 2) {
                if (cur < sum) {
                    continue;
                } else if (cur > sum) {
                    break;
                }
            }
            if (dfs(i + 1, pre + cur, cur, count + 1)) {
                return true;
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