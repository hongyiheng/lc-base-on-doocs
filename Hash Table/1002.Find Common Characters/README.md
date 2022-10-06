# [1002. 查找常用字符](https://leetcode-cn.com/problems/find-common-characters)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定仅有小写字母组成的字符串数组 <code>A</code>，返回列表中的每个字符串中都显示的全部字符（<strong>包括重复字符</strong>）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。</p>

<p>你可以按任意顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[&quot;bella&quot;,&quot;label&quot;,&quot;roller&quot;]
<strong>输出：</strong>[&quot;e&quot;,&quot;l&quot;,&quot;l&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[&quot;cool&quot;,&quot;lock&quot;,&quot;cook&quot;]
<strong>输出：</strong>[&quot;c&quot;,&quot;o&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 100</code></li>
	<li><code>1 &lt;= A[i].length &lt;= 100</code></li>
	<li><code>A[i][j]</code> 是小写字母</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        cnt = [-1] * 26
        for s in words:
            cur = [0] * 26
            for c in s:
                cur[ord(c) - ord('a')] += 1
            for i in range(26):
                if cnt[i] == -1 or cnt[i] == cur[i]:
                    cnt[i] = cur[i]
                else:
                    cnt[i] = min(cnt[i], cur[i])
        ans = []
        for i in range(26):
            while cnt[i] > 0:
                ans.append(str(chr(ord('a') + i)))
                cnt[i] -= 1
        return ans
                
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> commonChars(String[] words) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        for (String s : words) {
            char[] cs = s.toCharArray();
            int[] cur = new int[26];
            for (char c : cs) {
                cur[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == -1 || cnt[i] == cur[i]) {
                    cnt[i] = cur[i];
                } else {
                    cnt[i] = Math.min(cnt[i], cur[i]);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                ans.add(String.valueOf((char)('a' + i))); 
                cnt[i]--;
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
