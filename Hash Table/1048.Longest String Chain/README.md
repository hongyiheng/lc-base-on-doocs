# [1048. 最长字符串链](https://leetcode-cn.com/problems/longest-string-chain)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出一个单词列表，其中每个单词都由小写英文字母组成。</p>

<p>如果我们可以在&nbsp;<code>word1</code>&nbsp;的任何地方添加一个字母使其变成&nbsp;<code>word2</code>，那么我们认为&nbsp;<code>word1</code>&nbsp;是&nbsp;<code>word2</code>&nbsp;的前身。例如，<code>&quot;abc&quot;</code>&nbsp;是&nbsp;<code>&quot;abac&quot;</code>&nbsp;的前身。</p>

<p><strong>词链</strong>是单词&nbsp;<code>[word_1, word_2, ..., word_k]</code>&nbsp;组成的序列，<code>k &gt;= 1</code>，其中&nbsp;<code>word_1</code>&nbsp;是&nbsp;<code>word_2</code>&nbsp;的前身，<code>word_2</code>&nbsp;是&nbsp;<code>word_3</code>&nbsp;的前身，依此类推。</p>

<p>从给定单词列表 <code>words</code> 中选择单词组成词链，返回词链的最长可能长度。<br>
&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[&quot;a&quot;,&quot;b&quot;,&quot;ba&quot;,&quot;bca&quot;,&quot;bda&quot;,&quot;bdca&quot;]
<strong>输出：</strong>4
<strong>解释：</strong>最长单词链之一为 &quot;a&quot;,&quot;ba&quot;,&quot;bda&quot;,&quot;bdca&quot;。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 16</code></li>
	<li><code>words[i]</code>&nbsp;仅由小写英文字母组成。</li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        mp = defaultdict(list)
        for w in words:
            mp[len(w)].append(w)
        ans = 0

        @cache
        def dfs(cur):
            nonlocal ans
            cnt = 1
            for w in mp[len(cur) + 1]:
                for i in range(len(w)):
                    if w[:i] + w[i + 1:] == cur:
                        cnt = max(cnt, dfs(w) + 1)
            return cnt

        for w in words:
            ans = max(ans, dfs(w))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<Integer, List<String>> ws;

    Map<String, Integer> f;

    public int dfs(String cur) {
        if (f.containsKey(cur)) {
            return f.get(cur);
        }
        int ans = 1;
        for (String w : ws.getOrDefault(cur.length() + 1, new ArrayList<>())) {
            for (int i = 0; i < w.length(); i++) {
                if ((w.substring(0, i) + w.substring(i + 1)).equals(cur)) {
                    ans = Math.max(ans, dfs(w) + 1);
                }
            }
        }
        f.put(cur, ans);
        return ans;
    }

    public int longestStrChain(String[] words) {
        ws = new HashMap<>();
        f = new HashMap<>();
        for (String w : words) {
            ws.computeIfAbsent(w.length(), x -> new ArrayList<>()).add(w);
        }
        int ans = 0;
        for (String w : words) {
            ans = Math.max(ans, dfs(w));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
