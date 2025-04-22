# [3365. 重排子字符串以形成目标字符串](https://leetcode.cn/problems/rearrange-k-substrings-to-form-target-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串 <code>s</code> 和 <code>t</code>（它们互为字母异位词），以及一个整数 <code>k</code>。</p>

<p>你的任务是判断是否可以将字符串 <code>s</code> 分割成 <code>k</code> 个等长的子字符串，然后重新排列这些子字符串，并以任意顺序连接它们，使得最终得到的新字符串与给定的字符串 <code>t</code> 相匹配。</p>

<p>如果可以做到，返回 <code>true</code>；否则，返回 <code>false</code>。</p>

<p><strong>字母异位词&nbsp;</strong>是指由另一个单词或短语的所有字母重新排列形成的单词或短语，使用所有原始字母恰好一次。</p>

<p><strong>子字符串&nbsp;</strong>是字符串中的一个连续&nbsp;<b>非空&nbsp;</b>字符序列。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "abcd", t = "cdab", k = 2</span></p>

<p><strong>输出：</strong> <span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>将 <code>s</code> 分割成 2 个长度为 2 的子字符串：<code>["ab", "cd"]</code>。</li>
	<li>重新排列这些子字符串为 <code>["cd", "ab"]</code>，然后连接它们得到 <code>"cdab"</code>，与 <code>t</code> 相匹配。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "aabbcc", t = "bbaacc", k = 3</span></p>

<p><strong>输出：</strong> <span class="example-io">true</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>将 <code>s</code> 分割成 3 个长度为 2 的子字符串：<code>["aa", "bb", "cc"]</code>。</li>
	<li>重新排列这些子字符串为 <code>["bb", "aa", "cc"]</code>，然后连接它们得到 <code>"bbaacc"</code>，与 <code>t</code> 相匹配。</li>
</ul>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "aabbcc", t = "bbaacc", k = 2</span></p>

<p><strong>输出：</strong> <span class="example-io">false</span></p>

<p><strong>解释：</strong></p>

<ul>
	<li>将 <code>s</code> 分割成 2 个长度为 3 的子字符串：<code>["aab", "bcc"]</code>。</li>
	<li>这些子字符串无法重新排列形成 <code>t = "bbaacc"</code>，所以输出 <code>false</code>。</li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length == t.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
	<li><code>s.length</code> 能被 <code>k</code> 整除。</li>
	<li><code>s</code> 和 <code>t</code> 仅由小写英文字母组成。</li>
	<li>输入保证 <code>s</code> 和 <code>t</code> 互为字母异位词。</li>
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
        self.cnt = 0

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                head.children[ord(c) - ord('a')] = Node()
            head = head.children[ord(c) - ord('a')]
        head.cnt += 1

    def search(self, word: str) -> bool:
        head = self.root
        for c in word:
            if not head.children[ord(c) - ord('a')]:
                return False
            head = head.children[ord(c) - ord('a')]
        if head.cnt:
            head.cnt -= 1
            return True
        return False
        

class Solution:
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        n = len(s)
        tr = Trie()
        d = n // k
        for i in range(k):
            w = s[i * d: (i + 1) * d]
            tr.insert(w)
        for i in range(k):
            w = t[i * d: (i + 1) * d]
            if not tr.search(w):
                return False
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Node {
    Node[] children = new Node[26];
    int cnt = 0;
}

class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new Node();
            }
            head = head.children[c - 'a'];
        }
        head.cnt++;
    }

    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        if (head.cnt > 0) {
            head.cnt--;
            return true;
        }
        return false;
    }
}


class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        Trie tr = new Trie();
        int d = n / k;
        for (int i = 0; i < k; i++) {
            String w = s.substring(i * d, (i + 1) * d);
            tr.insert(w);
        }
        for (int i = 0; i < k; i++) {
            String w = t.substring(i * d, (i + 1) * d);
            if (!tr.search(w)) {
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
