# [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder)



## 题目描述

<!-- 这里写题目描述 -->

<p>字典 <code>wordList</code> 中从单词 <code>beginWord</code><em> </em>和 <code>endWord</code> 的 <strong>转换序列 </strong>是一个按下述规格形成的序列：</p>

<ul>
	<li>序列中第一个单词是 <code>beginWord</code> 。</li>
	<li>序列中最后一个单词是 <code>endWord</code> 。</li>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典 <code>wordList</code> 中的单词。</li>
</ul>

<p>给你两个单词<em> </em><code>beginWord</code><em> </em>和 <code>endWord</code> 和一个字典 <code>wordList</code> ，找到从 <code>beginWord</code> 到 <code>endWord</code> 的 <strong>最短转换序列</strong> 中的 <strong>单词数目</strong> 。如果不存在这样的转换序列，返回 0。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
<strong>输出：</strong>5
<strong>解释：</strong>一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
<strong>输出：</strong>0
<strong>解释：</strong>endWord "cog" 不在字典中，所以无法进行转换。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= beginWord.length <= 10</code></li>
	<li><code>endWord.length == beginWord.length</code></li>
	<li><code>1 <= wordList.length <= 5000</code></li>
	<li><code>wordList[i].length == beginWord.length</code></li>
	<li><code>beginWord</code>、<code>endWord</code> 和 <code>wordList[i]</code> 由小写英文字母组成</li>
	<li><code>beginWord != endWord</code></li>
	<li><code>wordList</code> 中的所有字符串 <strong>互不相同</strong></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def check_next(a, b):
            diff = 0
            for v1, v2 in zip(a, b):
                if v1 != v2:
                    diff += 1
                if diff > 1:
                    break
            return diff == 1

        n = len(wordList)
        used = [False] * n
        q = deque()
        q.append(beginWord)
        ans = 1
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                for j in range(n):
                    if used[j]:
                        continue
                    ne = wordList[j]
                    if not check_next(cur, ne):
                        continue
                    if ne == endWord:
                        return ans + 1
                    q.append(ne)
                    used[j] = True
            ans += 1
        return 0


        
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[] used = new boolean[n];
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int ans = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                String cur = q.pollFirst();
                for (int j = 0; j < n; j++) {
                    if (used[j]) {
                        continue;
                    }
                    String ne = wordList.get(j);
                    if (!checkNext(cur, ne)) {
                        continue;
                    }
                    if (ne.equals(endWord)) {
                        return ans + 1;
                    }
                    q.addLast(ne);
                    used[j] = true;
                }   
            }
            ans++;
        }
        return 0;
    }

    public boolean checkNext(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                break;
            }
        }
        return diff == 1;
    }


}
```

### **...**

```

```

<!-- tabs:end -->
