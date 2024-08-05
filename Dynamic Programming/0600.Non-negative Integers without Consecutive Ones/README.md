# [600. 不含连续1的非负整数](https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含&nbsp;<strong>连续的1&nbsp;</strong>的个数。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 5
<strong>输出:</strong> 5
<strong>解释:</strong> 
下面是带有相应二进制表示的非负整数&lt;= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。</pre>

<p><strong>说明:</strong> 1 &lt;= n &lt;= 10<sup>9</sup></p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findIntegers(self, n: int) -> int:
        @cache
        def dfs(pos, pre, limit):
            if pos == len(s):
                return 1
            up = int(s[pos]) if limit else 1
            ans = 0
            for i in range(up + 1):
                if pre == 1 and i == 1:
                    continue
                ans += dfs(pos + 1, i, limit and i == up)
            return ans

        s = bin(n)[2:]
        return dfs(0, 0, True)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    
    String s;
    Map<String, Integer> f = new HashMap<>();
    
    public int dfs(int pos, int pre, boolean limit) {
        if (pos == s.length()) {
            return 1;
        }
        String key = pos + ":" + pre;
        if (!limit && f.containsKey(key)) {
            return f.get(key);
        }
        int up = limit ? s.charAt(pos) - '0' : 1;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            if (i == 1 && pre == 1) {
                continue;
            }
            ans += dfs(pos + 1, i, limit && i == up);
        }
        if (!limit) {
            f.put(key, ans);
        }
        return ans;
    }

    public int findIntegers(int n) {
        s = Integer.toBinaryString(n);
        return dfs(0, 0, true);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
