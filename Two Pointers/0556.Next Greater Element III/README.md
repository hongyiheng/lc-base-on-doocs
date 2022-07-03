# [556. 下一个更大元素 III](https://leetcode-cn.com/problems/next-greater-element-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code> ，请你找出符合条件的最小整数，其由重新排列 <code>n</code><strong> </strong>中存在的每位数字组成，并且其值大于 <code>n</code> 。如果不存在这样的正整数，则返回 <code>-1</code> 。</p>

<p><strong>注意</strong> ，返回的整数应当是一个 <strong>32 位整数</strong> ，如果存在满足题意的答案，但不是 <strong>32 位整数</strong> ，同样返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 12
<strong>输出：</strong>21
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 21
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 2<sup>31</sup> - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        def swap(s, i, j):
            s[i], s[j] = s[j], s[i]
        
        def reverse(s, i):
            l, r = i, len(s) - 1
            while l < r:
                swap(s, l, r)
                l += 1
                r -= 1
        
        s = list(str(n))
        m = len(s)
        i = m - 2
        while i >= 0:
            if s[i] < s[i + 1]:
                break
            i -= 1
        if i < 0:
            return -1
        j = m - 1
        while j >= 0:
            if s[i] < s[j]:
                break
            j -= 1
        if j < 0:
            return -1
        swap(s, i, j)
        reverse(s, i + 1)
        ans = int("".join(s))
        return -1 if ans >= 2 ** 31 else ans 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) {
            return -1;
        }
        char[] cs = s.toCharArray();
        int i = m - 2;
        while (i >= 0) {
            if (cs[i] < cs[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = m - 1;
        while (j >= 0){
            if (cs[i] < cs[j]) {
                break;
            } 
            j--;
        }
        if (j < 0) {
            return -1;
        }
        swap(cs, i, j);
        reverse(cs, i + 1);
        long ans = Long.parseLong(new String(cs));
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    public void reverse(char[] cs, int idx) {
        int i = idx, j = cs.length - 1;
        while (i < j) {
            swap(cs, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
