# [1233. 删除子文件夹](https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem)



## 题目描述

<!-- 这里写题目描述 -->

<p>你是一位系统管理员，手里有一份文件夹列表 <code>folder</code>，你的任务是要删除该列表中的所有 <strong>子文件夹</strong>，并以 <strong>任意顺序</strong> 返回剩下的文件夹。</p>

<p>我们这样定义「子文件夹」：</p>

<ul>
	<li>如果文件夹&nbsp;<code>folder[i]</code>&nbsp;位于另一个文件夹&nbsp;<code>folder[j]</code>&nbsp;下，那么&nbsp;<code>folder[i]</code>&nbsp;就是&nbsp;<code>folder[j]</code>&nbsp;的子文件夹。</li>
</ul>

<p>文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：</p>

<ul>
	<li><code>/</code>&nbsp;后跟一个或者多个小写英文字母。</li>
</ul>

<p>例如，<code>/leetcode</code>&nbsp;和&nbsp;<code>/leetcode/problems</code>&nbsp;都是有效的路径，而空字符串和&nbsp;<code>/</code>&nbsp;不是。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>folder = [&quot;/a&quot;,&quot;/a/b&quot;,&quot;/c/d&quot;,&quot;/c/d/e&quot;,&quot;/c/f&quot;]
<strong>输出：</strong>[&quot;/a&quot;,&quot;/c/d&quot;,&quot;/c/f&quot;]
<strong>解释：</strong>&quot;/a/b/&quot; 是 &quot;/a&quot; 的子文件夹，而 &quot;/c/d/e&quot; 是 &quot;/c/d&quot; 的子文件夹。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>folder = [&quot;/a&quot;,&quot;/a/b/c&quot;,&quot;/a/b/d&quot;]
<strong>输出：</strong>[&quot;/a&quot;]
<strong>解释：</strong>文件夹 &quot;/a/b/c&quot; 和 &quot;/a/b/d/&quot; 都会被删除，因为它们都是 &quot;/a&quot; 的子文件夹。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>folder = [&quot;/a/b/c&quot;,&quot;/a/b/d&quot;,&quot;/a/b/ca&quot;]
<strong>输出：</strong>[&quot;/a/b/c&quot;,&quot;/a/b/ca&quot;,&quot;/a/b/d&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= folder.length&nbsp;&lt;= 4 * 10^4</code></li>
	<li><code>2 &lt;= folder[i].length &lt;= 100</code></li>
	<li><code>folder[i]</code>&nbsp;只包含小写字母和 <code>/</code></li>
	<li><code>folder[i]</code>&nbsp;总是以字符 <code>/</code>&nbsp;起始</li>
	<li>每个文件夹名都是唯一的</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Node:
    def __init__(self):
        self.children = [None] * 27
        self.end = False

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        def find_and_save(s):
            son = False
            r = root
            for i, c in enumerate(s):
                idx = 26 if c == '/' else ord(c) - ord('a')
                if not r.children[idx]:
                    r.children[idx] = Node()
                if r.children[idx].end and s[i + 1] == '/':
                    son = True
                r = r.children[idx]
            r.end = True
            return son

        root = Node()
        folder.sort(key=lambda x: len(x))
        ans = list()
        for s in folder:
            is_son = find_and_save(s[1:])
            if not is_son:
                ans.append(s)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    class Node {
        private Node[] children;
        private boolean end;

        public Node() {
            children = new Node[27];
            end = false;
        }
    }

    Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        List<String> ans = new ArrayList<>();
        for (String s :folder) {
            boolean son = findAndSave(s);
            if (!son) {
                ans.add(s);
            }
        }
        return ans;
    }

    public boolean findAndSave(String s) {
        boolean son = false;
        Node r = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = '/' == s.charAt(i) ? 26 : s.charAt(i) - 'a';
            if (r.children[idx] == null) {
                r.children[idx] = new Node();
            }
            if (r.children[idx].end && s.charAt(i + 1) == '/') {
                son = true;
            }
            r = r.children[idx];
        }
        r.end = true;
        return son;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
