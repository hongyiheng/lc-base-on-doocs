# [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>s = &quot;leetcode&quot;
返回 0

s = &quot;loveleetcode&quot;
返回 2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong>你可以假定该字符串只包含小写字母。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1) {
                return i;
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
