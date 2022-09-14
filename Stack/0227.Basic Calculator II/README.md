# [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串表达式 <code>s</code> ，请你实现一个基本计算器来计算并返回它的值。</p>

<p>整数除法仅保留整数部分。</p>

<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "3+2*2"
<strong>输出：</strong>7
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = " 3/2 "
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = " 3+5 / 2 "
<strong>输出：</strong>5
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> 由整数和算符 <code>('+', '-', '*', '/')</code> 组成，中间由一些空格隔开</li>
	<li><code>s</code> 表示一个 <strong>有效表达式</strong></li>
	<li>表达式中的所有整数都是非负整数，且在范围 <code>[0, 2<sup>31</sup> - 1]</code> 内</li>
	<li>题目数据保证答案是一个 <strong>32-bit 整数</strong></li>
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
    def calculate(self, s: str) -> int:
        def cal_num(a, b, cal):
            if cal == "*":
                return a * b
            elif cal == "/":
                return a // b
            elif cal == "+":
                return a + b
            return a - b

        num, cal = deque(), deque()
        idx, n = 0, len(s)
        while idx < n:
            if s[idx] == " ":
                idx += 1
                continue
            elif "0" <= s[idx] <= "9":
                cur = 0
                while idx < n and "0" <= s[idx] <= "9":
                    cur = cur * 10 + int(s[idx])
                    idx += 1
                num.append(cur)
                if cal and (cal[-1] == "*" or cal[-1] == "/"):
                    b, a = num.pop(), num.pop()
                    num.append(cal_num(a, b, cal.pop()))
                continue
            cal.append(s[idx])
            idx += 1
        while cal:
            num.appendleft(cal_num(num.popleft(), num.popleft(), cal.popleft()))
        return num[0]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> cals = new ArrayDeque<>();
        int idx = 0, n = cs.length;
        while (idx < n) {
            if (cs[idx] == ' ') {
                idx++;
                continue;
            } else if ('0' <= cs[idx] && cs[idx] <= '9') {
                int num = 0;
                while (idx < n && '0' <= cs[idx] && cs[idx] <= '9') {
                    num = num * 10 + cs[idx] - '0';
                    idx++;
                }
                nums.addLast(num);
                if (!cals.isEmpty() && (cals.peekLast() == '*' || cals.peekLast() == '/')) {
                    int b = nums.pollLast(), a = nums.pollLast();
                    nums.addLast(calNum(a, b, cals.pollLast()));
                }
                continue;
            } else {
                cals.addLast(cs[idx]);
            }
            idx++;
        }
        while (!cals.isEmpty()) {
            nums.addFirst(calNum(nums.pollFirst(), nums.pollFirst(), cals.pollFirst()));
        }
        return nums.pollLast();
    }

    public int calNum(int a, int b, Character cal) {
        if (cal == '*') {
            return a * b;
        } else if (cal == '/') {
            return a / b;
        } else if (cal == '+') {
            return a + b;
        }
        return a - b;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
