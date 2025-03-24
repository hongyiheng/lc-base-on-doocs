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
class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = 0

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, s):
        node = self.root
        for c in s:
            v = ord(c) - ord('a')
            if node.children[v] is None:
                node.children[v] = Node()
            node = node.children[v]
        node.end += 1
    
    def search(self, s):
        ans = 0
        node = self.root
        for c in s:
            v = ord(c) - ord('a')
            if node.children[v] is None:
                break
            node = node.children[v]
            ans += node.end
        return ans

class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        tr = Trie()
        for w in words:
            tr.insert(w)
        return tr.search(s)
        
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    Node[] children;
    Integer end;

    public Node() {
        children = new Node[26];
        end = 0;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.end++;
    }

    public int search(String s) {
        int ans = 0;
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                break;
            }
            node = node.children[c - 'a'];
            ans += node.end;
        }
        return ans;
    }
}


class Solution {
    public int countPrefixes(String[] words, String s) {
        Trie tr = new Trie();
        for (String w : words) {
            tr.insert(w);
        }
        return tr.search(s);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
