# [1796. 字符串中第二大的数字](https://leetcode-cn.com/problems/second-largest-digit-in-a-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个混合字符串 <code>s</code> ，请你返回 <code>s</code> 中 <strong>第二大 </strong>的数字，如果不存在第二大的数字，请你返回 <code>-1</code> 。</p>

<p><strong>混合字符串 </strong>由小写英文字母和数字组成。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>s = "dfa12321afd"
<b>输出：</b>2
<b>解释：</b>出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>s = "abc1111"
<b>输出：</b>-1
<b>解释：</b>出现在 s 中的数字只包含 [1] 。没有第二大的数字。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 500</code></li>
	<li><code>s</code> 只包含小写英文字母和（或）数字。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def secondHighest(self, s: str) -> int:
        nums = [False] * 10
        for c in s:
            if '0' <= c <= '9':
                nums[ord(c) - ord('0')] = True
        flag = False
        for i in range(9, -1, -1):
            if nums[i]:
                if flag:
                    return i
                flag = True
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int secondHighest(String s) {
        boolean[] nums = new boolean[10];
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                nums[c - '0'] = true;
            }
        }
        boolean flag = false;
        for (int i = 9; i > -1; i--) {
            if (nums[i]) {
                if (flag) {
                    return i;
                }
                flag = true;    
            }
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
