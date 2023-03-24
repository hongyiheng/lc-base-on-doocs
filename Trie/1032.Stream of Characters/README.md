# [1032. 字符流](https://leetcode-cn.com/problems/stream-of-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>按下述要求实现 <code>StreamChecker</code> 类：</p>

<ul>
	<li><code>StreamChecker(words)</code>：构造函数，用给定的字词初始化数据结构。</li>
	<li><code>query(letter)</code>：如果存在某些 <code>k &gt;= 1</code>，可以用查询的最后 <code>k</code>个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 <code>true</code>。否则，返回 <code>false</code>。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>StreamChecker streamChecker = new StreamChecker([&quot;cd&quot;,&quot;f&quot;,&quot;kl&quot;]); // 初始化字典
streamChecker.query(&#39;a&#39;);          // 返回 false
streamChecker.query(&#39;b&#39;);          // 返回 false
streamChecker.query(&#39;c&#39;);          // 返回 false
streamChecker.query(&#39;d&#39;);          // 返回 true，因为 &#39;cd&#39; 在字词表中
streamChecker.query(&#39;e&#39;);          // 返回 false
streamChecker.query(&#39;f&#39;);          // 返回 true，因为 &#39;f&#39; 在字词表中
streamChecker.query(&#39;g&#39;);          // 返回 false
streamChecker.query(&#39;h&#39;);          // 返回 false
streamChecker.query(&#39;i&#39;);          // 返回 false
streamChecker.query(&#39;j&#39;);          // 返回 false
streamChecker.query(&#39;k&#39;);          // 返回 false
streamChecker.query(&#39;l&#39;);          // 返回 true，因为 &#39;kl&#39; 在字词表中。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 2000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 2000</code></li>
	<li>字词只包含小写英文字母。</li>
	<li>待查项只包含小写英文字母。</li>
	<li>待查项最多 40000 个。</li>
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

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]
        head.end = True

    def start_with(self, prefix):
        head = self.root
        for c in prefix:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
            if head.end:
                return True
        return False

class StreamChecker:

    def __init__(self, words: List[str]):
        self.s = ""
        self.tr = Trie()
        for w in words:
            self.tr.insert(w[::-1])

    def query(self, letter: str) -> bool:
        self.s += letter
        return self.tr.start_with(self.s[::-1])


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class StreamChecker {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i > -1; i--) {
                char c = s.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Node();
                }
                cur = cur.child[c - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i > -1; i--) {
                char c = s.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
                if (cur.end) {
                    return true;
                }
            }
            return false;
        }
    }

    Trie tr;
    StringBuilder s;

    public StreamChecker(String[] words) {
        s = new StringBuilder();
        tr = new Trie();
        for (String word : words) {
            tr.insert(word);
        }
    }

    public boolean query(char letter) {
        s.append(letter);
        return tr.search(s.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
```

### **...**

```

```

<!-- tabs:end -->
