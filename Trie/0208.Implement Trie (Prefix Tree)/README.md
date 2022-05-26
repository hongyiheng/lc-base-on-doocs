# [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree)



## 题目描述

<!-- 这里写题目描述 -->

<p><strong><a href="https://baike.baidu.com/item/字典树/9825209?fr=aladdin" target="_blank">Trie</a></strong>（发音类似 "try"）或者说 <strong>前缀树</strong> 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。</p>

<p>请你实现 Trie 类：</p>

<ul>
	<li><code>Trie()</code> 初始化前缀树对象。</li>
	<li><code>void insert(String word)</code> 向前缀树中插入字符串 <code>word</code> 。</li>
	<li><code>boolean search(String word)</code> 如果字符串 <code>word</code> 在前缀树中，返回 <code>true</code>（即，在检索之前已经插入）；否则，返回 <code>false</code> 。</li>
	<li><code>boolean startsWith(String prefix)</code> 如果之前已经插入的字符串 <code>word</code> 的前缀之一为 <code>prefix</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
<strong>输出</strong>
[null, null, true, false, true, null, true]

<strong>解释</strong>
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= word.length, prefix.length <= 2000</code></li>
	<li><code>word</code> 和 <code>prefix</code> 仅由小写英文字母组成</li>
	<li><code>insert</code>、<code>search</code> 和 <code>startsWith</code> 调用次数 <strong>总计</strong> 不超过 <code>3 * 10<sup>4</sup></code> 次</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        head = self.root
        for c in word:
            if not head.childrens[ord(c) - ord('a')]:
                head.childrens[ord(c) - ord('a')] = Node()
            head = head.childrens[ord(c) - ord('a')]
        head.is_word = True

    def search(self, word: str) -> bool:
        head = self.root
        for c in word:
            if not head.childrens[ord(c) - ord('a')]:
                return False
            head = head.childrens[ord(c) - ord('a')]
        return head.is_word


    def startsWith(self, prefix: str) -> bool:
        head = self.root
        for c in prefix:
            if not head.childrens[ord(c) - ord('a')]:
                return False
            head = head.childrens[ord(c) - ord('a')]
        return True

class Node:
    def __init__(self):
        self.childrens = [None] * 26
        self.is_word = False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                head.childrens[c - 'a'] = new Node();
            }
            head = head.childrens[c - 'a'];
        }
        head.isWord = true;
    }
    
    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                return false;
            }
            head = head.childrens[c - 'a'];
        }
        return head.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node head = root;
        for (char c : prefix.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                return false;
            }
            head = head.childrens[c - 'a'];
        }
        return true;
    }
}

class Node {
    Node[] childrens;
    boolean isWord;

    public Node() {
        childrens = new Node[26];
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

### **...**

```

```

<!-- tabs:end -->
