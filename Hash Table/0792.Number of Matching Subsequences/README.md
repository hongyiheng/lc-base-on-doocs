# [792. 匹配子序列的单词数](https://leetcode-cn.com/problems/number-of-matching-subsequences)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定字符串 <code>S</code> 和单词字典 <code>words</code>, 求&nbsp;<code>words[i]</code>&nbsp;中是&nbsp;<code>S</code>&nbsp;的子序列的单词个数。</p>

<pre>
<strong>示例:</strong>
<strong>输入:</strong> 
S = &quot;abcde&quot;
words = [&quot;a&quot;, &quot;bb&quot;, &quot;acd&quot;, &quot;ace&quot;]
<strong>输出:</strong> 3
<strong>解释:</strong> 有三个是&nbsp;S 的子序列的单词: &quot;a&quot;, &quot;acd&quot;, &quot;ace&quot;。
</pre>

<p><strong>注意:</strong></p>

<ul>
	<li>所有在<code>words</code>和&nbsp;<code>S</code>&nbsp;里的单词都只由小写字母组成。</li>
	<li><code>S</code> 的长度在&nbsp;<code>[1, 50000]</code>。</li>
	<li><code>words</code>&nbsp;的长度在&nbsp;<code>[1, 5000]</code>。</li>
	<li><code>words[i]</code>的长度在<code>[1, 50]</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        ws = [deque() for _ in range(26)]
        for w in words:
            ws[ord(w[0]) - ord('a')].append(w)
        ans = 0
        for c in s:
            q = ws[ord(c) - ord('a')]
            for _ in range(len(q)):
                v = q.popleft()
                if len(v) == 1:
                    ans += 1
                else:
                    ws[ord(v[1]) - ord('a')].append(v[1:])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Deque<String>> ws = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            ws.add(new ArrayDeque<>());
        }
        for (String w : words) {
            ws.get(w.charAt(0) - 'a').addLast(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> q = ws.get(c - 'a');
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.removeFirst();
                if (w.length() == 1) {
                    ans++;
                } else {
                    ws.get(w.charAt(1) - 'a').addLast(w.substring(1));
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
