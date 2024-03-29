# [1408. 数组中的字符串匹配](https://leetcode-cn.com/problems/string-matching-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串数组 <code>words</code> ，数组中的每个字符串都可以看作是一个单词。请你按 <strong>任意</strong> 顺序返回 <code>words</code> 中是其他单词的子字符串的所有单词。</p>

<p>如果你可以删除 <code>words[j]</code>&nbsp;最左侧和/或最右侧的若干字符得到 <code>word[i]</code> ，那么字符串 <code>words[i]</code> 就是 <code>words[j]</code> 的一个子字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>words = [&quot;mass&quot;,&quot;as&quot;,&quot;hero&quot;,&quot;superhero&quot;]
<strong>输出：</strong>[&quot;as&quot;,&quot;hero&quot;]
<strong>解释：</strong>&quot;as&quot; 是 &quot;mass&quot; 的子字符串，&quot;hero&quot; 是 &quot;superhero&quot; 的子字符串。
[&quot;hero&quot;,&quot;as&quot;] 也是有效的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>words = [&quot;leetcode&quot;,&quot;et&quot;,&quot;code&quot;]
<strong>输出：</strong>[&quot;et&quot;,&quot;code&quot;]
<strong>解释：</strong>&quot;et&quot; 和 &quot;code&quot; 都是 &quot;leetcode&quot; 的子字符串。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>words = [&quot;blue&quot;,&quot;green&quot;,&quot;bu&quot;]
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 30</code></li>
	<li><code>words[i]</code> 仅包含小写英文字母。</li>
	<li>题目数据 <strong>保证</strong> 每个 <code>words[i]</code> 都是独一无二的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        n = len(words)
        ans = []
        used = [False] * n
        for i in range(n):
            for j in range(n):
                if i == j or used[j]:
                    continue
                if words[i].__contains__(words[j]):
                    ans.append(words[j])
                    used[j] = True
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || used[j]) {
                    continue;
                }
                if (words[i].indexOf(words[j]) != -1) {
                    ans.add(words[j]);
                    used[j] = true;
                }
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
