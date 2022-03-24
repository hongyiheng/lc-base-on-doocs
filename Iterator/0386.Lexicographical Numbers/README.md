# [386. 字典序排数](https://leetcode-cn.com/problems/lexicographical-numbers)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数&nbsp;<em>n</em>, 返回从&nbsp;<em>1&nbsp;</em>到&nbsp;<em>n&nbsp;</em>的字典顺序。</p>

<p>例如，</p>

<p>给定 <em>n</em> =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。</p>

<p>请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据&nbsp;<em>n&nbsp;</em>小于等于&nbsp;5,000,000。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        cur = 1
        while len(ans) < n:
            while cur <= n:
                ans.append(cur)
                cur *= 10
            while cur % 10 == 9 or cur > n:
                cur //= 10
            cur += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        while (ans.size() < n) {
            while (cur <= n) {
                ans.add(cur);
                cur *= 10;
            }
            while (cur % 10 == 9 || cur > n) {
                cur /= 10;
            }
            cur++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
