# [30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串 <code>s</code><strong> </strong>和一些 <strong>长度相同</strong> 的单词 <code>words</code><strong> 。</strong>找出 <code>s</code><strong> </strong>中恰好可以由 <code>words</code><strong> </strong>中所有单词串联形成的子串的起始位置。</p>

<p>注意子串要与 <code>words</code><strong> </strong>中的单词完全匹配，<strong>中间不能有其他字符 </strong>，但不需要考虑 <code>words</code><strong> </strong>中单词串联的顺序。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoothefoobarman", words = ["foo","bar"]
<strong>输出：</strong><code>[0,9]</code>
<strong>解释：</strong>
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
<code><strong>输出：</strong>[]</code>
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
<strong>输出：</strong>[6,9,12]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 10<sup>4</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
	<li><code>1 <= words.length <= 5000</code></li>
	<li><code>1 <= words[i].length <= 30</code></li>
	<li><code>words[i]</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        m, n = len(words), len(words[0])
        ans = []
        if m * n > len(s):
            return ans
        t = defaultdict(int)
        for w in words:
            t[w] += 1

        for i in range(n):
            l = r = i
            cnt = 0
            cur = defaultdict(int)
            while r + n <= len(s):
                w = s[r:r+n]
                r += n
                if w not in t:
                    cur.clear()
                    cnt = 0
                    l = r
                    continue
                cnt += 1
                cur[w] += 1
                while cur[w] > t[w]:
                    cur[s[l:l+n]] -= 1
                    l += n
                    cnt -= 1
                if cnt == m:
                    ans.append(l)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, n = words[0].length();
        List<Integer> ans = new ArrayList<>();
        if (m * n > s.length()) {
            return ans;
        }
        Map<String, Integer> t = new HashMap<>();
        for (String w : words) {
            t.put(w, t.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int l = i, r = i, cnt = 0;
            Map<String, Integer> cur = new HashMap<>();
            while (r + n <= s.length()) {
                String w = s.substring(r, r + n);
                r += n;
                if (!t.containsKey(w)) {
                    l = r;
                    cnt = 0;
                    cur.clear();
                    continue;
                }
                cur.put(w, cur.getOrDefault(w, 0) + 1);
                cnt++;
                while (cur.get(w) > t.get(w)) {
                    String w2 = s.substring(l, l + n);
                    l += n;
                    cur.put(w2, cur.get(w2) - 1);
                    cnt--;
                }
                if (cnt == m) {
                    ans.add(l);
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
