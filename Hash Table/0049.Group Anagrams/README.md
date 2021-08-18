# [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams)

[English Version](/solution/0000-0099/0049.Group%20Anagrams/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。</p>

<p>字母异位词指字母相同，但排列不同的字符串。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>["eat", "tea", "tan", "ate", "nat", "bat"]</code>
<strong>输出: </strong>[["bat"],["nat","tan"],["ate","eat","tea"]]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>[""]</code>
<strong>输出: </strong>[[""]]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> strs = <code>["a"]</code>
<strong>输出: </strong>[["a"]]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= strs.length <= 10<sup>4</sup></code></li>
	<li><code>0 <= strs[i].length <= 100</code></li>
	<li><code>strs[i]</code> 仅包含小写字母</li>
</ul>


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
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = new String(strArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
```

### **...**

```

```

<!-- tabs:end -->
