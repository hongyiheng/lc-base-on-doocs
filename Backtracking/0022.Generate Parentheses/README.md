# [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses)



## 题目描述

<!-- 这里写题目描述 -->

<p>数字 <code>n</code> 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>["()"]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 8</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        choose = ["(", ")"]

        def backTrace(lefts, rights, temp_str, res):
            if lefts == 0 and rights == 0:
                res.append(temp_str)
            if rights < lefts:
                return
            for cur in choose:
                temp_str += cur
                if cur == "(" and lefts > 0:
                    backTrace(lefts - 1, rights, temp_str, res)
                elif cur == ")" and rights > 0:
                    backTrace(lefts, rights - 1, temp_str, res)
                temp_str = temp_str[:-1]

        res = []
        backTrace(n, n, "", res)
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    String[] choose = new String[]{"(", ")"};

     public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backTrack(n, n, new StringBuilder(), res);
        return res;
    }

    private void backTrack(int lefts, int rights, StringBuilder tempStr, List<String> res) {
        if (lefts == 0 && rights == 0) {
            res.add(new String(tempStr));
            return;
        }
        if (lefts > rights) {
            return;
        }
        for (String cur : choose) {
            tempStr.append(cur);
            if (cur.equals("(") && lefts > 0) {
                backTrack(lefts - 1, rights, tempStr, res);
            } else if (cur.equals(")") && rights > 0) {
                backTrack(lefts, rights - 1, tempStr, res);
            }
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
