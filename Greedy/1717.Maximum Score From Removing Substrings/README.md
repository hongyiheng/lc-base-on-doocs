# [1717. 删除子字符串的最大得分](https://leetcode-cn.com/problems/maximum-score-from-removing-substrings)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 和两个整数 <code>x</code> 和 <code>y</code> 。你可以执行下面两种操作任意次。</p>

<ul>
	<li>删除子字符串 <code>"ab"</code> 并得到 <code>x</code> 分。

	<ul>
		<li>比方说，从 <code>"c<strong>ab</strong>xbae"</code> 删除 <code>ab</code> ，得到 <code>"cxbae"</code> 。</li>
	</ul>
	</li>
	<li>删除子字符串<code>"ba"</code> 并得到 <code>y</code> 分。
	<ul>
		<li>比方说，从 <code>"cabx<strong>ba</strong>e"</code> 删除 <code>ba</code> ，得到 <code>"cabxe"</code> 。</li>
	</ul>
	</li>
</ul>

<p>请返回对 <code>s</code> 字符串执行上面操作若干次能得到的最大得分。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>s = "cdbcbbaaabab", x = 4, y = 5
<b>输出：</b>19
<strong>解释：</strong>
- 删除 "cdbcbbaaa<strong>ba</strong>b" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
- 删除 "cdbcbbaa<strong>ab</strong>" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
- 删除 "cdbcb<strong>ba</strong>a" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
- 删除 "cdbc<strong>ba</strong>" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
总得分为 5 + 4 + 5 + 5 = 19 。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>s = "aabbaaxybbaabb", x = 5, y = 4
<b>输出：</b>20
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= x, y &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> 只包含小写英文字母。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        a, b = 'a', 'b'
        if x < y:
            a, b = b, a
            x, y = y, x
        ans = cnt1 = cnt2 = 0
        for c in list(s):
            if c == a:
                cnt1 += 1
            elif c == b:
                if cnt1:
                    ans += x
                    cnt1 -= 1
                else:
                    cnt2 += 1
            else:
                ans += min(cnt1, cnt2) * y
                cnt1 = cnt2 = 0
        return ans + min(cnt1, cnt2) * y
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumGain(String s, int x, int y) {
        char a = 'a', b = 'b';
        if (x < y) {
            b = 'a';
            a = 'b';
            int z = x;
            x = y;
            y = z;
        }
        int ans = 0, cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c == a) {
                cnt1++;
            } else if (c == b) {
                if (cnt1 > 0) {
                    cnt1--;
                    ans += x;
                } else {
                    cnt2++;
                }
            } else {
                ans += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        return ans + Math.min(cnt1, cnt2) * y;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
