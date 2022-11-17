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
        def find(i, ss):
            left, right = 0, len(ss)
            while left < right:
                mid = (left + right) >> 1
                if ss[mid] <= i:
                    left = mid + 1
                else:
                    right = mid
            return left

        mp = dict()
        for i, c in enumerate(s):
            ids = mp.get(c, list())
            ids.append(i)
            mp[c] = ids
        ans = 0
        for w in words:
            flag = True
            cur = -1
            for i, c in enumerate(w):
                ss = mp.get(c, list())
                t = find(cur, ss)
                if t == len(ss):
                    flag = False
                    break
                cur = ss[t]
            if flag:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> mp = new HashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            mp.computeIfAbsent(cs[i], k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (String w : words) {
            char[] ws = w.toCharArray();
            boolean flag = true;
            int cur = -1;
            for (int i = 0; i < ws.length; i++) {
                char c = ws[i];
                List<Integer> ids = mp.getOrDefault(c, new ArrayList<>());
                int left = 0, right = ids.size();
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (ids.get(mid) <= cur) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (right == ids.size() || cur >= ids.get(right)) {
                    flag = false;
                    break;
                }
                cur = ids.get(right);
            }
            if (flag) {
                ans++;
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
