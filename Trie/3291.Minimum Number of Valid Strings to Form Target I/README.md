# [3291. 形成目标字符串需要的最少字符串数 I](https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串数组 <code>words</code> 和一个字符串 <code>target</code>。</p>

<p>如果字符串 <code>x</code> 是 <code>words</code> 中<strong> 任意 </strong>字符串的 <span data-keyword="string-prefix">前缀</span>，则认为 <code>x</code> 是一个 <strong>有效</strong> 字符串。</p>

<p>现计划通过 <strong>连接 </strong>有效字符串形成 <code>target</code> ，请你计算并返回需要连接的 <strong>最少 </strong>字符串数量。如果无法通过这种方式形成 <code>target</code>，则返回 <code>-1</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">words = ["abc","aaaaa","bcdef"], target = "aabcdabc"</span></p>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p>target 字符串可以通过连接以下有效字符串形成：</p>

<ul>
	<li><code>words[1]</code> 的长度为 2 的前缀，即 <code>"aa"</code>。</li>
	<li><code>words[2]</code> 的长度为 3 的前缀，即 <code>"bcd"</code>。</li>
	<li><code>words[0]</code> 的长度为 3 的前缀，即 <code>"abc"</code>。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">words = ["abababab","ab"], target = "ababaababa"</span></p>

<p><strong>输出：</strong> <span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p>target 字符串可以通过连接以下有效字符串形成：</p>

<ul>
	<li><code>words[0]</code> 的长度为 5 的前缀，即 <code>"ababa"</code>。</li>
	<li><code>words[0]</code> 的长度为 5 的前缀，即 <code>"ababa"</code>。</li>
</ul>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">words = ["abcdef"], target = "xyz"</span></p>

<p><strong>输出：</strong> <span class="example-io">-1</span></p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 5 * 10<sup>3</sup></code></li>
	<li>输入确保 <code>sum(words[i].length) &lt;= 10<sup>5</sup></code>。</li>
	<li><code>words[i]</code> 只包含小写英文字母。</li>
	<li><code>1 &lt;= target.length &lt;= 5 * 10<sup>3</sup></code></li>
	<li><code>target</code> 只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Trie:
    def __init__(self):
        self.children = [None] * 26
    
    def insert(self, w):
        node = self
        for c in w:
            idx = ord(c) - ord('a')
            if not node.children[idx]:
                node.children[idx] = Trie()
            node = node.children[idx]

    def search(self, w):
        node = self
        for i, c in enumerate(w):
            idx = ord(c) - ord('a')
            if not node.children[idx]:
                return w[i:]
            if i == len(w) - 1:
                return None    
            node = node.children[idx]        
        return w

class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        @cache
        def dfs(i):
            if i >= n:
                return 0
            node = tr
            ans = inf
            for j in range(i, n):
                idx = ord(target[j]) - ord('a')
                if node.children[idx] is None:
                    break
                node = node.children[idx]
                nx = dfs(j + 1) + 1
                if nx < ans:
                    ans = nx
            return ans

        tr = Trie()
        for w in words:
            tr.insert(w)
        n = len(target)
        ans = dfs(0)
        return ans if ans < inf else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Trie {

    Trie[] children = new Trie[26];

    void insert(String w) {
        Trie node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
    }
}

class Solution {

    int[] f;
    char[] cs;
    Trie tr;
    int inf = 0x3f3f3f3f, n = 0;

    public int minValidStrings(String[] words, String target) {
        tr = new Trie();
        for (String w : words) {
            tr.insert(w);
        }
        n = target.length();
        f = new int[n];
        Arrays.fill(f, -1);
        cs = target.toCharArray();
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        Trie node = tr;
        f[i] = inf;
        for (int j = i; j < n; ++j) {
            int idx = cs[j] - 'a';
            if (node.children[idx] == null) {
                break;
            }
            f[i] = Math.min(f[i], dfs(j + 1) + 1);
            node = node.children[idx];
        }
        return f[i];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
