# [472. 连接词](https://leetcode-cn.com/problems/concatenated-words)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个 <strong>不含重复 </strong>单词的字符串数组 <code>words</code> ，编写一个程序，返回 <code>words</code> 中的所有 <strong>连接词</strong> 。</p>

<p><strong>连接词</strong> 的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
<strong>输出：</strong>["catsdogcats","dogcatsdog","ratcatdogcat"]
<strong>解释：</strong>"catsdogcats"由"cats", "dog" 和 "cats"组成; 
     "dogcatsdog"由"dog", "cats"和"dog"组成; 
     "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = ["cat","dog","catdog"]
<strong>输出：</strong>["catdog"]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 10<sup>4</sup></code></li>
	<li><code>0 <= words[i].length <= 1000</code></li>
	<li><code>words[i]</code> 仅由小写字母组成</li>
	<li><code>0 <= sum(words[i].length) <= 6 * 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False

class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        root = Node()
        words.sort(key=lambda x:len(x))

        def insert(word):
            node = root
            for c in word:
                index = ord(c) - ord('a')
                if node.children[index] is None:
                    node.children[index] = Node()
                node = node.children[index]
            node.end = True
        
        def dfs(word, i):
            n = len(word)
            if i == n:
                return True
            node = root
            while i < n:
                index = ord(word[i]) - ord('a')
                if node.children[index] is None:
                    return False
                node = node.children[index]
                if node.end and dfs(word, i + 1):
                    return True
                i += 1
            return False
        
        ans = []
        for word in words:
            if word:
                if dfs(word, 0):
                    ans.append(word)
                else:
                    insert(word)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    class Node {
        boolean end;
        Node[] children;

        Node() {
            this.end = false;
            this.children = new Node[26];
        }
    }

    Node root = new Node();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (!word.isEmpty()) {
                if (dfs(word, 0)) {
                    ans.add(word);
                } else {
                    insert(word);
                }
            }
        }
        return ans;
    }

    private void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    private boolean dfs(String word, int i) {
        if (i == word.length()) {
            return true;
        }
        Node node = root;
        while (i < word.length()) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - 'a'];
            if (node.end && dfs(word, i + 1)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
