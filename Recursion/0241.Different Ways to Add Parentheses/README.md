# [241. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 <code>+</code>,&nbsp;<code>-</code>&nbsp;以及&nbsp;<code>*</code>&nbsp;。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> <code>&quot;2-1-1&quot;</code>
<strong>输出:</strong> <code>[0, 2]</code>
<strong>解释: </strong>
((2-1)-1) = 0 
(2-(1-1)) = 2</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入: </strong><code>&quot;2*3-4*5&quot;</code>
<strong>输出:</strong> <code>[-34, -14, -10, -10, 10]</code>
<strong>解释: 
</strong>(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        def dfs(l, r):
            nonlocal expression
            ans = []
            for i in range(l, r + 1):
                if '0' <= expression[i] <= '9':
                    continue
                left, right = dfs(l, i - 1), dfs(i + 1, r)
                for a in left:
                    for b in right:
                        if expression[i] == '+':
                            ans.append(a + b)
                        elif expression[i] == '-':
                            ans.append(a - b)
                        else:
                            ans.append(a * b)
            if not ans:
                ans.append(int(expression[l:r + 1]))
            return ans

        return dfs(0, len(expression) - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    char[] chars;
    String s;

    public List<Integer> diffWaysToCompute(String expression) {
        s = expression;
        chars = s.toCharArray();
        return dfs(0, chars.length - 1);
    }

    public List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            List<Integer> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    int cur = 0;
                    if (chars[i] == '+') {
                        cur = a + b;
                    } else if (chars[i] == '-') {
                        cur = a - b;
                    } else {
                        cur = a * b;
                    }
                    ans.add(cur);
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(s.substring(l, r + 1)));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
