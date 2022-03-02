# [246. 中心对称数](https://leetcode-cn.com/problems/strobogrammatic-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>中心对称数是指一个数字在旋转了&nbsp;180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>

<p>请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> num = &quot;69&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> num = &quot;88&quot;
<strong>输出:</strong> true</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> num = &quot;962&quot;
<strong>输出:</strong> false</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>num = &quot;1&quot;
<strong>输出：</strong>true
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        mp = dict()
        mp['9'] = '6'
        mp['6'] = '9'
        mp['8'] = '8'
        mp['1'] = '1'
        mp['0'] = '0'
        l, r = 0, len(num) - 1
        while l <= r:
            if mp.get(num[l], 'a') != num[r] or mp.get(num[r], 'b') != num[l]:
                return False
            l += 1
            r -= 1
        return True 
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put('6', '9');
        mp.put('9', '6');
        mp.put('8', '8');
        mp.put('1', '1');
        mp.put('0', '0');
        char[] chars = num.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (mp.getOrDefault(chars[l], 'a') != chars[r] || mp.getOrDefault(chars[r], 'b') != chars[l]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
