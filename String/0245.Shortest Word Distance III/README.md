# [245. 最短单词距离 III](https://leetcode-cn.com/problems/shortest-word-distance-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个单词列表和两个单词 <em>word1</em> 和 <em>word2</em>，返回列表中这两个单词之间的最短距离。</p>

<p><em>word1</em> 和 <em>word2</em>&nbsp;是有可能相同的，并且它们将分别表示为列表中两个独立的单词。</p>

<p><strong>示例:</strong><br>
假设 words = <code>[&quot;practice&quot;, &quot;makes&quot;, &quot;perfect&quot;, &quot;coding&quot;, &quot;makes&quot;]</code>.</p>

<pre><strong>输入:</strong> <em>word1</em> = <code>&ldquo;makes&rdquo;</code>, <em>word2</em> = <code>&ldquo;coding&rdquo;</code>
<strong>输出:</strong> 1
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>&quot;makes&quot;</code>, <em>word2</em> = <code>&quot;makes&quot;</code>
<strong>输出:</strong> 3
</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        mp = dict()
        ans = float('inf')
        for i, v in enumerate(wordsDict):
            if v != word1 and v != word2:
                continue
            if v == word1:
                if word2 in mp:
                    ans = min(ans, i - mp[word2])
            else:
                if word1 in mp:
                    ans = min(ans, i - mp[word1])
            mp[v] = i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if (!w.equals(word1) && !w.equals(word2)) {
                continue;
            }
            if (w.equals(word1)) {
                if (mp.containsKey(word2)) {
                    ans = Math.min(ans, i - mp.get(word2));
                } 
            } else {
                if (mp.containsKey(word1)) {
                    ans = Math.min(ans, i - mp.get(word1));
                } 
            }
            mp.put(w, i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
