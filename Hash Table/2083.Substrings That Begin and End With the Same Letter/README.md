# [2083. 求以相同字母开头和结尾的子串总数](https://leetcode-cn.com/problems/substrings-that-begin-and-end-with-the-same-letter)

## 题目描述

<!-- 这里写题目描述 -->

None

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        g = [[False] * 26 for _ in range(26)]
        for i in range(1, len(s)):
            g[ord(s[i - 1]) - ord('a')][ord(s[i]) - ord('a')] = True
        for i in range(len(s) - 2, -1, -1):
            if g[ord(s[i + 1]) - ord('a')][ord(s[i]) - ord('a')]:
                return True
        return False
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[][] g = new boolean[26][26];
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            g[cs[i - 1] - 'a'][cs[i] - 'a'] = true;
        }
        for (int i = cs.length - 2; i > -1; i--) {
            if (g[cs[i + 1] - 'a'][cs[i] - 'a']) {
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
