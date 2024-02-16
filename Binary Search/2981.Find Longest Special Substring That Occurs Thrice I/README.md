# [2981. 找出出现至少三次的最长特殊子字符串 I](https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个仅由小写英文字母组成的字符串 <code>s</code> 。</p>

<p>如果一个字符串仅由单一字符组成，那么它被称为 <strong>特殊 </strong>字符串。例如，字符串 <code>"abc"</code> 不是特殊字符串，而字符串 <code>"ddd"</code>、<code>"zz"</code> 和 <code>"f"</code> 是特殊字符串。</p>

<p>返回在 <code>s</code> 中出现 <strong>至少三次 </strong>的<strong> 最长特殊子字符串 </strong>的长度，如果不存在出现至少三次的特殊子字符串，则返回 <code>-1</code> 。</p>

<p><strong>子字符串 </strong>是字符串中的一个连续<strong> 非空 </strong>字符序列。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aaaa"
<strong>输出：</strong>2
<strong>解释：</strong>出现三次的最长特殊子字符串是 "aa" ：子字符串 "<em><strong>aa</strong></em>aa"、"a<em><strong>aa</strong></em>a" 和 "aa<em><strong>aa</strong></em>"。
可以证明最大长度是 2 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "abcdef"
<strong>输出：</strong>-1
<strong>解释：</strong>不存在出现至少三次的特殊子字符串。因此返回 -1 。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "abcaba"
<strong>输出：</strong>1
<strong>解释：</strong>出现三次的最长特殊子字符串是 "a" ：子字符串 "<em><strong>a</strong></em>bcaba"、"abc<em><strong>a</strong></em>ba" 和 "abcab<em><strong>a</strong></em>"。
可以证明最大长度是 1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 50</code></li>
	<li><code>s</code> 仅由小写英文字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumLength(self, s: str) -> int:
        def check(x):
            for q in cnt.values():
                k = 0
                for v in q:
                    if v < x:
                        continue
                    k += v - x + 1
                if k >= 3:
                    return True
            return False
                
        cnt = defaultdict(list)
        last_v = last_len = 0
        for c in s:
            v = ord(c) - ord('a')
            if v == last_v:
                last_len += 1
            else:
                cnt[last_v].append(last_len)
                last_len = 1
            last_v = v
        cnt[last_v].append(last_len)

        l, r = 0, len(s)
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r if r > 0 else -1            
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public boolean check(int x, Map<Integer, List<Integer>> cnt) {
        for (List<Integer> q : cnt.values()) {
            int k = 0;
            for (int v : q) {
                if (v < x) {
                    continue;
                }
                k += v - x + 1;
            }
            if (k >= 3) {
                return true;
            }
        }
        return false;
    }

    public int maximumLength(String s) {
        Map<Integer, List<Integer>> cnt = new HashMap<>();
        int lastVal = 0, lastLen = 0;
        for (char c : s.toCharArray()) {
            int v = c - 'a';
            if (v == lastVal) {
                lastLen++;
            } else {
                cnt.computeIfAbsent(lastVal, k -> new ArrayList<>()).add(lastLen);
                lastLen = 1;
            }
            lastVal = v;
        }
        cnt.computeIfAbsent(lastVal, k -> new ArrayList<>()).add(lastLen);
        
        int l = 0, r = s.length();
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, cnt)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r > 0 ? r : -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
