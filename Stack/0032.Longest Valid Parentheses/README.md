# [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个只包含 <code>'('</code> 和 <code>')'</code> 的字符串，找出最长有效（格式正确且连续）括号子串的长度。</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "(()"
<strong>输出：</strong>2
<strong>解释：</strong>最长有效括号子串是 "()"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = ")()())"
<strong>输出：</strong>4
<strong>解释：</strong>最长有效括号子串是 "()()"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = ""
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li>
</ul>
</div>
</div>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        q = []
        for i, v in enumerate("".join(s)):
            cur = 0 if v == '(' else 1
            if not q:
                q.append([cur, i])
            else:
                if cur == 1 and q[-1][0] == 0:
                    q.pop()
                else:
                    q.append([cur, i])
        nums = [0] * len(s)
        while q:
            nums[q.pop()[1]] = 1
        ans = cur = 0
        for v in nums:
            if v == 1:
                ans = max(ans, cur)
                cur = 0
            else:
                cur += 1
        ans = max(ans, cur)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestValidParentheses(String s) {
        Deque<int[]> q = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cur = chars[i] == '(' ? 0 : 1;
            if (q.isEmpty()) {      
                q.addLast(new int[]{cur, i});
            } else {
                if (cur == 1 && q.peekLast()[0] == 0) {
                    q.pollLast();
                } else {
                    q.addLast(new int[]{cur, i});
                }
            }
        }
        int[] nums = new int[s.length()];
        while (!q.isEmpty()) {
            nums[q.poll()[1]] = 1;
        }
        int ans = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] == 1) {
                ans = Math.max(ans, cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        ans = Math.max(ans, cur);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
