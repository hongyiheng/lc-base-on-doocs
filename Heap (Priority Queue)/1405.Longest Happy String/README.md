# [1405. 最长快乐字符串](https://leetcode-cn.com/problems/longest-happy-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>如果字符串中不含有任何 <code>&#39;aaa&#39;</code>，<code>&#39;bbb&#39;</code> 或 <code>&#39;ccc&#39;</code> 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。</p>

<p>给你三个整数 <code>a</code>，<code>b</code> ，<code>c</code>，请你返回 <strong>任意一个</strong> 满足下列全部条件的字符串 <code>s</code>：</p>

<ul>
	<li><code>s</code> 是一个尽可能长的快乐字符串。</li>
	<li><code>s</code> 中 <strong>最多</strong> 有<code>a</code> 个字母 <code>&#39;a&#39;</code>、<code>b</code>&nbsp;个字母 <code>&#39;b&#39;</code>、<code>c</code> 个字母 <code>&#39;c&#39;</code> 。</li>
	<li><code>s </code>中只含有 <code>&#39;a&#39;</code>、<code>&#39;b&#39;</code> 、<code>&#39;c&#39;</code> 三种字母。</li>
</ul>

<p>如果不存在这样的字符串 <code>s</code> ，请返回一个空字符串 <code>&quot;&quot;</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>a = 1, b = 1, c = 7
<strong>输出：</strong>&quot;ccaccbcc&quot;
<strong>解释：</strong>&quot;ccbccacc&quot; 也是一种正确答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>a = 2, b = 2, c = 1
<strong>输出：</strong>&quot;aabbc&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>a = 7, b = 1, c = 0
<strong>输出：</strong>&quot;aabaa&quot;
<strong>解释：</strong>这是该测试用例的唯一正确答案。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= a, b, c &lt;= 100</code></li>
	<li><code>a + b + c &gt; 0</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
from sortedcontainers import SortedList

class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        q = SortedList(key=lambda x: x[1])
        if a > 0:
            q.add([0, a])
        if b > 0:
            q.add([1, b])
        if c > 0:
            q.add([2, c])
        ans = ""
        while q:
            cur = q.pop()
            n = len(ans)
            if n >= 2 and ord(ans[n - 1]) - ord('a') == cur[0] and ord(ans[n - 2]) - ord('a') == cur[0]:
                if q:
                    nx = q.pop()
                    ans += chr(nx[0] + ord('a'))
                    nx[1] -= 1
                    if nx[1] > 0:
                        q.add(nx)
                    q.add(cur)
            else:
                ans += chr(cur[0] + ord('a'))
                cur[1] -= 1
                if cur[1] > 0:
                    q.add(cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if (a > 0) {
            q.add(new int[]{0, a});
        }
        if (b > 0) {
            q.add(new int[]{1, b});
        }
        if (c > 0) {
            q.add(new int[]{2, c});
        }
        String ans = "";
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int n = ans.length();
            if (n >= 2 && ans.charAt(n - 1) - 'a' == cur[0] && ans.charAt(n - 2) - 'a' == cur[0]) {
                if (!q.isEmpty()) {
                    int[] next = q.poll();
                    ans += (char)('a' + next[0]);
                    if (--next[1] > 0) {
                        q.add(next);
                    }
                    q.add(cur);
                }
            } else {
                ans += (char)('a' + cur[0]);
                if (--cur[1] > 0) {
                    q.add(cur);
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
