# [187. 重复的DNA序列](https://leetcode-cn.com/problems/repeated-dna-sequences)



## 题目描述

<!-- 这里写题目描述 -->

<p>所有 DNA 都由一系列缩写为 <code>'A'</code>，<code>'C'</code>，<code>'G'</code> 和 <code>'T'</code> 的核苷酸组成，例如：<code>"ACGAATTCCG"</code>。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。</p>

<p>编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 <code>s</code> 中出现次数超过一次。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
<strong>输出：</strong>["AAAAACCCCC","CCCCCAAAAA"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAAAAAAAAAA"
<strong>输出：</strong>["AAAAAAAAAA"]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> 为 <code>'A'</code>、<code>'C'</code>、<code>'G'</code> 或 <code>'T'</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        b, p = 131313, 131313 ** 9
        n = len(s)
        ans = list()
        mp = dict()
        l = r = cur = 0
        while r < n:
            cur = cur * b + ord(s[r])
            if r - l + 1 == 10:
                v = mp.get(cur, 0)
                if v == 1:
                    ans.append(s[l:r + 1])
                    mp[cur] += 1
                mp[cur] = v + 1
                cur -= ord(s[l]) * p
                l += 1
            r += 1
        return list(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int base = 131313;
        long p = 1;
        for (int i = 0; i < 9; i++) {
            p = base * p;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0, h = 0;
        while (r < s.length()) {
            h = (h * base + s.charAt(r));
            if (r - l + 1 == 10) {
                int v = map.getOrDefault(h, 0);
                if (v == 1) {
                    ans.add(s.substring(l, r + 1));
                }
                map.put(h, v + 1);
                h = (int) (h - p * s.charAt(l));
                l++;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
