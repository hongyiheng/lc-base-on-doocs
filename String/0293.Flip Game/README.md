# [293. 翻转游戏](https://leetcode-cn.com/problems/flip-game)



## 题目描述

<!-- 这里写题目描述 -->

<p>你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：</p>

<p>给你一个字符串 <code>currentState</code> ，其中只含 <code>'+'</code> 和 <code>'-'</code> 。你和朋友轮流将 <strong>连续 </strong>的两个 <code>"++"</code> 反转成 <code>"--"</code> 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。</p>

<p>计算并返回 <strong>一次有效操作</strong> 后，字符串 <code>currentState</code> 所有的可能状态，返回结果可以按 <strong>任意顺序</strong> 排列。如果不存在可能的有效操作，请返回一个空列表 <code>[]</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>currentState = "++++"
<strong>输出：</strong>["--++","+--+","++--"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>currentState = "+"
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= currentState.length <= 500</code></li>
	<li><code>currentState[i]</code> 不是 <code>'+'</code> 就是 <code>'-'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def generatePossibleNextMoves(self, currentState: str) -> List[str]:
        ans = []
        for i in range(1, len(currentState)):
            if currentState[i] == '+' and currentState[i - 1] == '+':
                cur = currentState[:i - 1] + "--" + currentState[i + 1:]
                ans.append(cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] chars = currentState.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '+' && chars[i] == '+') {
                chars[i - 1] = '-';
                chars[i] = '-';
                ans.add(new String(chars));
                chars[i - 1] = '+';
                chars[i] = '+';
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
