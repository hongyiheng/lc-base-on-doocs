# [2182. 构造限制重复的字符串](https://leetcode-cn.com/problems/construct-string-with-repeat-limit)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 和一个整数 <code>repeatLimit</code> ，用 <code>s</code> 中的字符构造一个新字符串 <code>repeatLimitedString</code> ，使任何字母 <strong>连续</strong> 出现的次数都不超过 <code>repeatLimit</code> 次。你不必使用 <code>s</code> 中的全部字符。</p>

<p>返回 <strong>字典序最大的</strong><em> </em><code>repeatLimitedString</code> 。</p>

<p>如果在字符串 <code>a</code> 和 <code>b</code> 不同的第一个位置，字符串 <code>a</code> 中的字母在字母表中出现时间比字符串 <code>b</code> 对应的字母晚，则认为字符串 <code>a</code> 比字符串 <code>b</code> <strong>字典序更大</strong> 。如果字符串中前 <code>min(a.length, b.length)</code> 个字符都相同，那么较长的字符串字典序更大。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "cczazcc", repeatLimit = 3
<strong>输出：</strong>"zzcccac"
<strong>解释：</strong>使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
字母 'a' 连续出现至多 1 次。
字母 'c' 连续出现至多 3 次。
字母 'z' 连续出现至多 2 次。
因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "aababab", repeatLimit = 2
<strong>输出：</strong>"bbabaa"
<strong>解释：</strong>
使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。 
字母 'a' 连续出现至多 2 次。 
字母 'b' 连续出现至多 2 次。 
因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。 
该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。 
注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= repeatLimit &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        ans, q = [], []
        for i, v in enumerate(cnt):
            if not v:
                continue
            heapq.heappush(q, (-i, v))
        while q:
            i, v = heapq.heappop(q)
            if ans and ans[-1] == i:
                if not q:
                    break
                ni, nv = heapq.heappop(q)
                ans.append(ni)
                if nv > 1:
                    heapq.heappush(q, (ni, nv - 1))
                heapq.heappush(q, (i, v))
            else:
                t = min(v, repeatLimit)
                ans.extend([i] * t)
                if v > t:
                    heapq.heappush(q, (i, v - t))
        return "".join([chr(-v + ord('a')) for v in ans])
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            q.offer(new int[]{i, cnt[i]});
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] a = q.poll();
            if (!ans.isEmpty() && ans.get(ans.size() - 1) == a[0]) {
                if (q.isEmpty()) {
                    break;
                }
                int[] b = q.poll();
                ans.add(b[0]);
                if (--b[1] > 0) {
                    q.offer(b);
                }
                q.offer(a);
            } else {
                int t = Math.min(a[1], repeatLimit);
                for (int i = 0; i < t; i++) {
                    ans.add(a[0]);
                }
                a[1] -= t;
                if (a[1] > 0) {
                    q.offer(a);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
