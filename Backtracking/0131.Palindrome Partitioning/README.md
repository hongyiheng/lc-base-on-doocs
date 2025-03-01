# [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，请你将<em> </em><code>s</code><em> </em>分割成一些子串，使每个子串都是 <strong>回文串</strong> 。返回 <code>s</code> 所有可能的分割方案。</p>

<p><strong>回文串</strong> 是正着读和反着读都一样的字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aab"
<strong>输出：</strong>[["a","a","b"],["aa","b"]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a"
<strong>输出：</strong>[["a"]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 16</code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def check(word):
            if not word:
                return True
            l, r = 0, len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return False
                l += 1
                r -= 1
            return True

        def dfs(i, word, path):
            if i >= len(s):
                if not word:
                    ans.append(path[::])
                return 
            
            word += s[i]
            if check(word):
                path.append(word)
                dfs(i + 1, "", path)
                path.pop()
            dfs(i + 1, word, path)
        
        ans = []
        dfs(0, "", [])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<List<String>> ans = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, "", new ArrayDeque<>());
        return ans;
    }

    public void dfs(int i, String word, Deque<String> path) {
        if (i >= s.length()) {
            if ("".equals(word)) {
                ans.add(new ArrayList(path));
            }
            return;
        }
        word += s.charAt(i);
        if (check(word)) {
            path.add(word);
            dfs(i + 1, "", path);
            path.pollLast();
        }
        dfs(i + 1, word, path);
    }

    public boolean check(String word) {
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (word.charAt(l++) != word.charAt(r--)) {
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
