# [1096. 花括号展开 II](https://leetcode-cn.com/problems/brace-expansion-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。</p>

<p>花括号展开的表达式可以看作一个由 <strong>花括号</strong>、<strong>逗号</strong> 和 <strong>小写英文字母</strong> 组成的字符串，定义下面几条语法规则：</p>

<ul>
	<li>如果只给出单一的元素 <code>x</code>，那么表达式表示的字符串就只有 <code>"x"</code>。<code>R(x) = {x}</code>

	<ul>
		<li>例如，表达式 <code>{"a"}</code> 表示字符串 <code>"a"</code>。</li>
		<li>而表达式 <code>{"w"}</code> 就表示字符串 <code>"w"</code>。</li>
	</ul>
	</li>
	<li>当两个或多个表达式并列，以逗号分隔时，我们取这些表达式中元素的并集。<code>R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...</code>
	<ul>
		<li>例如，表达式 <code>"{a,b,c}"</code> 表示字符串 <code>"a","b","c"</code>。</li>
		<li>而表达式 <code>"{{a,b},{b,c}}"</code> 也可以表示字符串 <code>"a","b","c"</code>。</li>
	</ul>
	</li>
	<li>要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。<code>R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}</code>
	<ul>
		<li>例如，表达式 <code>"{a,b}{c,d}"</code> 表示字符串 <code>"ac","ad","bc","bd"</code>。</li>
	</ul>
	</li>
	<li>表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
	<ul>
		<li>例如，表达式 <code>"a{b,c,d}"</code> 表示字符串 <code>"ab","ac","ad"​​​​​​</code>。</li>
		<li>例如，表达式 <code>"a{b,c}{d,e}f{g,h}"</code> 可以表示字符串 <code>"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"</code>。</li>
	</ul>
	</li>
</ul>

<p>给出表示基于给定语法规则的表达式 <code>expression</code>，返回它所表示的所有字符串组成的有序列表。</p>

<p>假如你希望以「集合」的概念了解此题，也可以通过点击 “<strong>显示英文描述</strong>” 获取详情。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>"{a,b}{c,{d,e}}"
<strong>输出：</strong>["ac","ad","ae","bc","bd","be"]</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>"{{a,z},a{b,c},{ab,z}}"
<strong>输出：</strong>["a","ab","ac","z"]
<strong>解释：</strong>输出中 <strong>不应 </strong>出现重复的组合结果。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 <= expression.length <= 50</code></li>
	<li><code>expression[i]</code> 由 <code>'{'</code>，<code>'}'</code>，<code>','</code> 或小写英文字母组成</li>
	<li>给出的表达式 <code>expression</code> 用以表示一组基于题目描述中语法构造的字符串</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        ans = set()

        def dfs(s):
            j = s.find("}")
            if j == -1:
                ans.add(s)
                return
            i = s.rfind("{", 0, j - 1)
            pre, tail = s[:i], s[j + 1:]
            for v in s[i + 1:j].split(","):
                dfs(pre + v + tail)

        dfs(expression)
        return sorted(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Set<String> ans = new HashSet<>();

    public void dfs(String s) {
        int j = s.indexOf("}");
        if (j == -1) {
            ans.add(s);
            return;
        }
        int i = j - 1;
        while (i >= 0 && s.charAt(i) != '{') {
            i--;
        }
        String pre = s.substring(0, i), tail = s.substring(j + 1);
        for (String v : s.substring(i + 1, j).split(",")) {
            dfs(pre + v + tail);
        }
    }

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
