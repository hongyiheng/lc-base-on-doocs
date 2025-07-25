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
        def dfs(x):
            if x > n:
                return
            ans.append(x)
            for i in range(10):
                nx = x * 10 + i
                dfs(nx)

        if n < 10:
            return [i for i in range(1, n + 1)]
        ans = []
        for i in range(1, 10):
            dfs(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<Integer> ans;
    int n;

    public void dfs(int x) {
        if (x > n) {
            return;
        }
        ans.add(x);
        for (int i = 0; i < 10; i++) {
            int nx = x * 10 + i;
            dfs(nx);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        if (n < 10) {
            for (int i = 1; i < n + 1; i++) {
                ans.add(i);
            }
            return ans;
        }
        this.n = n;
        for (int i = 1; i < 10; i++) {
            dfs(i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
