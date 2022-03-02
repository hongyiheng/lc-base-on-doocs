# [564. 寻找最近的回文数](https://leetcode-cn.com/problems/find-the-closest-palindrome)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。</p>

<p>&ldquo;最近的&rdquo;定义为两个整数<strong>差的绝对值</strong>最小。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> &quot;123&quot;
<strong>输出:</strong> &quot;121&quot;
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li><strong>n </strong>是由字符串表示的正整数，其长度不超过18。</li>
	<li>如果有多个结果，返回最小的那个。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nearestPalindromic(self, n: str) -> str:
        m, num, nums = len(n), int(n), set()
        nums.add(pow(10, m) + 1)
        nums.add(pow(10, m - 1) - 1)
        mid = int(n[0:(m + 1) // 2])
        for i in range(mid - 1, mid + 2):
            tmp = str(i)
            idx = len(tmp) - 1 if m % 2 == 0 else len(tmp) - 2
            while idx >= 0:
                tmp += tmp[idx]
                idx -= 1
            if int(tmp) != num:
                nums.add(int(tmp))
        ans = -1
        for v in nums:
            if ans == -1:
                ans = v
            elif abs(v - num) < abs(ans - num):
                ans = v
            elif abs(v - num) == abs(ans - num) and v < ans: 
                ans = v
        return str(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String nearestPalindromic(String n) {
        int m = n.length();
        long num = Long.parseLong(n);
        Set<Long> set = new HashSet();
        set.add((long) (Math.pow(10, m) + 1));
        set.add((long) (Math.pow(10, m - 1) - 1));
        long mid = Long.parseLong(n.substring(0, (m + 1) / 2));
        for (long i = mid - 1; i <= mid + 1; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int len = m % 2 == 0 ? sb.length() - 1 : sb.length() - 2;
            while (len >= 0) {
                sb.append(sb.charAt(len--));
            }
            long tmp = Long.parseLong(sb.toString());
            if (tmp != num) {
                set.add(tmp);
            }
        }
        long ans = -1L;
        for (long v : set) {
            if (Math.abs(num - v) < Math.abs(num - ans)) {
                ans = v;
            }
            if (Math.abs(num - v) == Math.abs(num - ans) && v < ans) {
                ans = v;
            }
        }
        return String.valueOf(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
