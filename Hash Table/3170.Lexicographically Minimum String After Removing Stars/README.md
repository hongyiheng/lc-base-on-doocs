# [3170. 删除星号以后字典序最小的字符串](https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;。它可能包含任意数量的&nbsp;<code>'*'</code>&nbsp;字符。你的任务是删除所有的&nbsp;<code>'*'</code>&nbsp;字符。</p>

<p>当字符串还存在至少一个&nbsp;<code>'*'</code>&nbsp;字符时，你可以执行以下操作：</p>

<ul>
	<li>删除最左边的&nbsp;<code>'*'</code>&nbsp;字符，同时删除该星号字符左边一个字典序 <strong>最小</strong>&nbsp;的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。</li>
</ul>

<p>请你返回删除所有&nbsp;<code>'*'</code>&nbsp;字符以后，剩余字符连接而成的 <span data-keyword="lexicographically-smaller-string">字典序最小</span> 的字符串。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "aaba*"</span></p>

<p><span class="example-io"><b>输出：</b>"aab"</span></p>

<p><strong>解释：</strong></p>

<p>删除 <code>'*'</code>&nbsp;号和它左边的其中一个&nbsp;<code>'a'</code>&nbsp;字符。如果我们选择删除&nbsp;<code>s[3]</code>&nbsp;，<code>s</code>&nbsp;字典序最小。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>s = "abc"</span></p>

<p><span class="example-io"><b>输出：</b>"abc"</span></p>

<p><strong>解释：</strong></p>

<p>字符串中没有&nbsp;<code>'*'</code>&nbsp;字符。<!-- notionvc: ff07e34f-b1d6-41fb-9f83-5d0ba3c1ecde --></p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code>&nbsp;只含有小写英文字母和&nbsp;<code>'*'</code>&nbsp;字符。</li>
	<li>输入保证操作可以删除所有的&nbsp;<code>'*'</code>&nbsp;字符。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def clearStars(self, s: str) -> str:
        cnt = defaultdict(list)
        exl = set()
        d = 0
        for i, c in enumerate(list(s)):
            if c == '*':
                exl.add(i)
                d += 1
            else:
                x = ord(c) - ord('a')
                cnt[x].append(i)
            if d:
                for j in range(26):
                    if cnt[j]:
                        exl.add(cnt[j].pop())
                        break
                d -= 1
        return "".join([c for i, c in enumerate(s) if i not in exl])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String clearStars(String s) {
        Map<Integer, Deque<Integer>> cnt = new HashMap<>();
        Set<Integer> exl = new HashSet<>();
        int d = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '*') {
                exl.add(i);
                d++;
            } else {
                int x = c - 'a';
                cnt.computeIfAbsent(x, k -> new ArrayDeque()).add(i);
            }
            if (d > 0) {
                for (int j = 0; j < 26; j++) {
                    if (!cnt.getOrDefault(j, new ArrayDeque()).isEmpty()) {
                        exl.add(cnt.get(j).pollLast());
                        break;
                    }
                }
                d--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!exl.contains(i)) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
