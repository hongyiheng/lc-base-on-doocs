# [1542. 找出最长的超赞子字符串](https://leetcode-cn.com/problems/find-longest-awesome-substring)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 。请返回 <code>s</code> 中最长的 <strong>超赞子字符串</strong> 的长度。</p>

<p>「超赞子字符串」需满足满足下述两个条件：</p>

<ul>
	<li>该字符串是 <code>s</code> 的一个非空子字符串</li>
	<li>进行任意次数的字符交换后，该字符串可以变成一个回文字符串</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;3242415&quot;
<strong>输出：</strong>5
<strong>解释：</strong>&quot;24241&quot; 是最长的超赞子字符串，交换其中的字符后，可以得到回文 &quot;24142&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;12345678&quot;
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;213123&quot;
<strong>输出：</strong>6
<strong>解释：</strong>&quot;213123&quot; 是最长的超赞子字符串，交换其中的字符后，可以得到回文 &quot;231132&quot;
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;00&quot;
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10^5</code></li>
	<li><code>s</code> 仅由数字组成</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestAwesome(self, s: str) -> int:
        n = len(s)
        pos = [n] * (1 << 10)
        pos[0] = -1
        ans = pre = 0
        for i, c in enumerate(s):
            v = int(c)
            pre ^= 1 << v
            ans = max(ans, i - pos[pre], max([i - pos[pre ^ 1 << d] for d in range(10)]))
            if pos[pre] == n:
                pos[pre] = i
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        int[] pos = new int[1 << 10];
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - '0';
            pre ^= 1 << v;
            ans = Math.max(ans, i - pos[pre]);
            for (int j = 0; j < 10; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            if (pos[pre] == n) {
                pos[pre] = i;
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
