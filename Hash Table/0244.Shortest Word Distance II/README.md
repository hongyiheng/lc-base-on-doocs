# [244. 最短单词距离 II](https://leetcode-cn.com/problems/shortest-word-distance-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 <em>word1</em>&nbsp;和&nbsp;<em>word2，</em>并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用&nbsp;<em>多次</em>。</p>

<p><strong>示例:</strong><br>
假设 words = <code>[&quot;practice&quot;, &quot;makes&quot;, &quot;perfect&quot;, &quot;coding&quot;, &quot;makes&quot;]</code></p>

<pre><strong>输入:</strong> <em>word1</em> = <code>&ldquo;coding&rdquo;</code>, <em>word2</em> = <code>&ldquo;practice&rdquo;</code>
<strong>输出:</strong> 3
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>&quot;makes&quot;</code>, <em>word2</em> = <code>&quot;coding&quot;</code>
<strong>输出:</strong> 1</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> <strong>不等于</strong> <em>word2</em>, 并且 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.mp = defaultdict(list)
        for i, v in enumerate(wordsDict):
            self.mp[hash(v)].append(i)


    def shortest(self, word1: str, word2: str) -> int:
        index1, index2 = self.mp[hash(word1)], self.mp[hash(word2)]
        ans = float('inf')
        for i in index1:
            for j in index2:
                ans = min(ans, abs(i - j))
        return ans



# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class WordDistance {
    Map<Integer, List<Integer>> mp;

    public WordDistance(String[] wordsDict) {
        mp = new HashMap();
        for (int i = 0; i < wordsDict.length; i++) {
            mp.computeIfAbsent(wordsDict[i].hashCode(), k -> new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        List<Integer> index1 = mp.get(word1.hashCode());
        List<Integer> index2 = mp.get(word2.hashCode());
        for (int i : index1) {
            for (int j : index2) {
                ans = Math.min(Math.abs(i - j), ans);
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
```

### **...**

```

```

<!-- tabs:end -->
