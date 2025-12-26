# [2489. Number of Substrings With Fixed Ratio](https://leetcode-cn.com/problems/number-of-substrings-with-fixed-ratio)



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
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)
        totalY = sum(1 for c in customers if c == 'Y')
        mi = totalY
        ans = 0
        openY = 0
        for i in range(1, n + 1):
            if customers[i-1] == 'Y':
                openY += 1
            v = i - 2 * openY + totalY
            if v < mi:
                mi = v
                ans = i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**

```

```

<!-- tabs:end -->
