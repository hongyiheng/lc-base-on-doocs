# [2516. 每种字符至少取 K 个](https://leetcode-cn.com/problems/take-k-of-each-character-from-left-and-right)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由字符 <code>'a'</code>、<code>'b'</code>、<code>'c'</code> 组成的字符串 <code>s</code> 和一个非负整数 <code>k</code> 。每分钟，你可以选择取走 <code>s</code> <strong>最左侧</strong> 还是 <strong>最右侧</strong> 的那个字符。</p>

<p>你必须取走每种字符 <strong>至少</strong> <code>k</code> 个，返回需要的 <strong>最少</strong> 分钟数；如果无法取到，则返回<em> </em><code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aabaaaacaabc", k = 2
<strong>输出：</strong>8
<strong>解释：</strong>
从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
共需要 3 + 5 = 8 分钟。
可以证明需要的最少分钟数是 8 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", k = 1
<strong>输出：</strong>-1
<strong>解释：</strong>无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 仅由字母 <code>'a'</code>、<code>'b'</code>、<code>'c'</code> 组成</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        def check(x):
            cnt = [0] * 3
            l = 0
            for i, v in enumerate(s):
                cnt[ord(v) - ord('a')] += 1
                if i - l + 1 == x:
                    hit = True
                    for a, b in zip(t, cnt):
                        if a < b:
                            hit = False
                    if hit:
                        return True
                    cnt[ord(s[l]) - ord('a')] -= 1
                    l += 1
            return False
                
        if k == 0:
            return 0
        q, t = [0] * 3, [-k] * 3
        for c in s:
            pos = ord(c) - ord('a')
            q[pos] += 1
            t[pos] += 1
        for v in t:
            if v < 0:
                return -1
        l, r = 0, len(s) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return len(s) - r

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] q = new int[3], t = new int[3];
        Arrays.fill(t, -k);
        for (char c : s.toCharArray()) {
            q[c - 'a']++;
            t[c - 'a']++;
        }        
        for (int v : t) {
            if (v < 0) {
                return -1;
            }
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, s, t)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return s.length() - r;
    }

    public boolean check(int x, String s, int[] t) {
        int[] cnt = new int[3];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a']++;
            if (r - l + 1 == x) {
                boolean hit = true;
                for (int i = 0; i < 3; i++) {
                    if (cnt[i] > t[i]) {
                        hit = false;
                    }
                }
                if (hit) {
                    return true;
                }
                cnt[s.charAt(l++) - 'a']--;
            }
        }

        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
