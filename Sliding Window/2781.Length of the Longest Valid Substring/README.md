# [2781. 最长合法子字符串的长度](https://leetcode-cn.com/problems/length-of-the-longest-valid-substring)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>word</code>&nbsp;和一个字符串数组&nbsp;<code>forbidden</code>&nbsp;。</p>

<p>如果一个字符串不包含&nbsp;<code>forbidden</code>&nbsp;中的任何字符串，我们称这个字符串是&nbsp;<strong>合法</strong>&nbsp;的。</p>

<p>请你返回字符串 <code>word</code>&nbsp;的一个 <strong>最长合法子字符串</strong>&nbsp;的长度。</p>

<p><strong>子字符串</strong> 指的是一个字符串中一段连续的字符，它可以为空。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>word = "cbaaaabc", forbidden = ["aaa","cb"]
<b>输出：</b>4
<b>解释：</b>总共有 9 个合法子字符串："c" ，"b" ，"a" ，"ba" ，"aa" ，"bc" ，"baa" ，"aab" 和 "aabc" 。最长合法子字符串的长度为 4 。
其他子字符串都要么包含 "aaa" ，要么包含 "cb" 。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>word = "leetcode", forbidden = ["de","le","e"]
<strong>输出：</strong>4
<b>解释：</b>总共有 11 个合法子字符串："l" ，"t" ，"c" ，"o" ，"d" ，"tc" ，"co" ，"od" ，"tco" ，"cod" 和 "tcod" 。最长合法子字符串的长度为 4 。
所有其他子字符串都至少包含 "de" ，"le" 和 "e" 之一。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 10<sup>5</sup></code></li>
	<li><code>word</code>&nbsp;只包含小写英文字母。</li>
	<li><code>1 &lt;= forbidden.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= forbidden[i].length &lt;= 10</code></li>
	<li><code>forbidden[i]</code>&nbsp;只包含小写英文字母。</li>
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
    
    def insert(self, s):
        cur = self.root
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            if not cur.children[idx]:
                cur.children[idx] = Node()
            cur = cur.children[idx]
        cur.end = True

    def search(self, s) -> bool:
        cur = self.root
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            if not cur.children[idx]:
                return False
            cur = cur.children[idx]
            if cur.end:
                return True
        return False

            
class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        tr = Trie()
        for s in forbidden:
            tr.insert(s)
        l = r = ans = 0
        while r < len(word):
            while tr.search(word[l:r + 1]):
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    Node[] children;
    boolean end;

    public Node() {
        children = new Node[26];
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node cur = root;
        for (int i = s.length() - 1; i > -1; i--) {
            int idx = s.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.end = true;
    }

    public boolean search(String s) {
        Node cur = root;
        for (int i = s.length() - 1; i > -1; i--) {
            int idx = s.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
            if (cur.end) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Trie tr = new Trie();
        for (String s : forbidden) {
            tr.insert(s);
        }
        int l = 0, r = 0, ans = 0;
        while (r < word.length()) {
            while (tr.search(word.substring(l, r + 1))) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
