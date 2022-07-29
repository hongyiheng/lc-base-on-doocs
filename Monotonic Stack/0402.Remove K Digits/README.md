# [402. 移掉 K 位数字](https://leetcode-cn.com/problems/remove-k-digits)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个以字符串表示的非负整数 <code>num</code> 和一个整数 <code>k</code> ，移除这个数中的 <code>k</code><em> </em>位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。</p>
 

<p><strong>示例 1 ：</strong></p>

<pre>
<strong>输入：</strong>num = "1432219", k = 3
<strong>输出：</strong>"1219"
<strong>解释：</strong>移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
</pre>

<p><strong>示例 2 ：</strong></p>

<pre>
<strong>输入：</strong>num = "10200", k = 1
<strong>输出：</strong>"200"
<strong>解释：</strong>移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
</pre>

<p><strong>示例 3 ：</strong></p>

<pre>
<strong>输入：</strong>num = "10", k = 2
<strong>输出：</strong>"0"
<strong>解释：</strong>从原数字移除所有的数字，剩余为空就是 0 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= k <= num.length <= 10<sup>5</sup></code></li>
	<li><code>num</code> 仅由若干位数字（0 - 9）组成</li>
	<li>除了 <strong>0</strong> 本身之外，<code>num</code> 不含任何前导零</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stk = []
        for v in num:
            while k and stk and stk[-1] > v:
                stk.pop()
                k-= 1
            stk.append(v)
        ans = "".join(stk)
        if k:
            ans = ans[:-min(k, len(ans))]
        while ans and ans[0] == "0":
            ans = ans[1:]
        return "0" if ans == "" else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stk.isEmpty() && stk.peekLast() > c) {
                stk.pollLast();
                k--;
            }
            stk.addLast(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty() && stk.size() > k) {
            char c = stk.pollFirst();
            if (ans.length() == 0 && c == '0') {
                continue;
            } 
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
