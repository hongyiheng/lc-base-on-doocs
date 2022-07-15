# [745. 前缀和后缀搜索](https://leetcode-cn.com/problems/prefix-and-suffix-search)



## 题目描述

<!-- 这里写题目描述 -->

<p>设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。</p>

<p>实现 <code>WordFilter</code> 类：</p>

<ul>
	<li><code>WordFilter(string[] words)</code> 使用词典中的单词 <code>words</code> 初始化对象。</li>
	<li><code>f(string prefix, string suffix)</code> 返回词典中具有前缀 <code>prefix</code> 和后缀<code>suffix</code> 的单词的下标。如果存在不止一个满足要求的下标，返回其中 <strong>最大的下标</strong> 。如果不存在这样的单词，返回 <code>-1</code> 。</li>
</ul>

<p> </p>

<p><strong>示例</strong></p>

<pre>
<strong>输入：</strong>
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
<strong>输出：</strong>
[null, 0]

<strong>解释：</strong>
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词的 prefix = "a" 且 suffix = 'e" 。
</pre>
 

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 15000</code></li>
	<li><code>1 <= words[i].length <= 10</code></li>
	<li><code>1 <= prefix.length, suffix.length <= 10</code></li>
	<li><code>words[i]</code>、<code>prefix</code> 和 <code>suffix</code> 仅由小写英文字母组成</li>
	<li>最多对函数 <code>f</code> 进行 <code>15000</code> 次调用</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class WordFilter:
    def __init__(self, words: List[str]):
        self.pre = Node()
        self.tail = Node()
        self.words = words
        for i in range(len(words)):
            self.insert(i, False)
            self.insert(i, True)
            
    def f(self, pref: str, suff: str) -> int:
        pre_ids = self.query(pref, False)
        tail_ids = self.query(suff, True)
        i, j = len(pre_ids) - 1, len(tail_ids) - 1
        while i >= 0 and j >= 0:
            if pre_ids[i] == tail_ids[j]:
                return pre_ids[i]
            elif pre_ids[i] > tail_ids[j]:
                i -= 1
            else:
                j -= 1
        return -1

    def query(self, w, desc):
        head = self.pre
        if desc:
            head = self.tail
            w = w[::-1]
        for c in w:
            if not head.child[ord(c) - ord('a')]:
                return []
            head = head.child[ord(c) - ord('a')]
        return head.ids
    
    def insert(self, i, desc):
        head = self.pre
        w = self.words[i]
        if desc:
            head = self.tail
            w = w[::-1]
        for c in w:
            if not head.child[ord(c) - ord('a')]:
                head.child[ord(c) - ord('a')] = Node()
            head = head.child[ord(c) - ord('a')]
            head.ids.append(i)


class Node:
    def __init__(self):
        self.ids = []
        self.child = [None] * 26



# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(pref,suff)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class WordFilter {
    Node pre;
    Node tail;
    String[] words;

    public WordFilter(String[] words) {
        pre = new Node();
        tail = new Node();
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            insert(i, false);
            insert(i, true);
        }
    }
    
    public int f(String pref, String suff) {
        List<Integer> preList = query(pref, false);
        List<Integer> tailList = query(suff, true);
        int i = preList.size() - 1, j = tailList.size() - 1;
        while (i >= 0 && j >= 0) {
            int a = preList.get(i), b = tailList.get(j);
            if (a == b) {
                return preList.get(i);
            } else if (a > b) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    public void insert(int i, boolean desc) {
        Node head = pre;
        String w = words[i];
        if (desc) {
            head = tail;
            w = new StringBuilder(w).reverse().toString();
        }
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                head.child[c - 'a'] = new Node();
            }
            head = head.child[c - 'a'];
            head.ids.add(i);
        } 
    }

    public List<Integer> query(String w, boolean desc) {
        Node head = pre;
        if (desc) {
            head = tail;
            w = new StringBuilder(w).reverse().toString();
        }
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                return new ArrayList<>();
            }
            head = head.child[c - 'a'];
        } 
        return head.ids;
    }
}

class Node {
    List<Integer> ids;
    Node[] child;

    public Node() {
        ids = new ArrayList<>();
        child = new Node[26];
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
```

### **...**

```

```

<!-- tabs:end -->
