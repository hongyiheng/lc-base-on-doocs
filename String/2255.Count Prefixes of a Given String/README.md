# [2255. 统计是给定字符串前缀的字符串数目](https://leetcode-cn.com/problems/count-prefixes-of-a-given-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串数组&nbsp;<code>words</code>&nbsp;和一个字符串&nbsp;<code>s</code>&nbsp;，其中&nbsp;<code>words[i]</code> 和&nbsp;<code>s</code>&nbsp;只包含 <strong>小写英文字母</strong>&nbsp;。</p>

<p>请你返回 <code>words</code>&nbsp;中是字符串 <code>s</code>&nbsp;<strong>前缀&nbsp;</strong>的 <strong>字符串数目</strong>&nbsp;。</p>

<p>一个字符串的 <strong>前缀</strong>&nbsp;是出现在字符串开头的子字符串。<strong>子字符串</strong>&nbsp;是一个字符串中的连续一段字符序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>words = ["a","b","c","ab","bc","abc"], s = "abc"
<b>输出：</b>3
<strong>解释：</strong>
words 中是 s = "abc" 前缀的字符串为：
"a" ，"ab" 和 "abc" 。
所以 words 中是字符串 s 前缀的字符串数目为 3 。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>words = ["a","a"], s = "aa"
<b>输出：</b>2
<strong>解释：
</strong>两个字符串都是 s 的前缀。
注意，相同的字符串可能在 words 中出现多次，它们应该被计数多次。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length, s.length &lt;= 10</code></li>
	<li><code>words[i]</code> 和&nbsp;<code>s</code>&nbsp;<strong>只</strong>&nbsp;包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        tr = Trie()
        tr.insert(s)
        ans = 0
        for w in words:
            if tr.start_with(w):
                ans += 1
        return ans


class Node:
    def __init__(self):
        self.children = [None] * 26

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]
    
    def start_with(self, prefix):
        head = self.root
        for c in prefix:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
        return True

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countPrefixes(String[] words, String s) {
        Trie tr = new Trie();
        tr.insert(s);
        int ans = 0;
        for (String w : words) {
            if (tr.startsWith(w)) {
                ans++;
            }
        }
        return ans;
    }
}

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

    public Node() {
        childrens = new Node[26];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
