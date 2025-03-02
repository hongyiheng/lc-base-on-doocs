# [132. 分割回文串 II](https://leetcode-cn.com/problems/palindrome-partitioning-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，请你将 <code>s</code> 分割成一些子串，使每个子串都是回文。</p>

<p>返回符合要求的 <strong>最少分割次数</strong> 。</p>

<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aab"
<strong>输出：</strong>1
<strong>解释：</strong>只需一次分割就可将 <em>s </em>分割成 ["aa","b"] 这样两个回文子串。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a"
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "ab"
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 2000</code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
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
    def minCut(self, s: str) -> int:
        @cache
        def check(l, r):
            if l >= r:
                return True
            return s[l] == s[r] and check(l + 1, r - 1)            
    
        @cache
        def dfs(r):
            if check(0, r):
                return 0
            res = inf
            for l in range(1, r + 1):
                if check(l, r):
                    res = min(res, dfs(l - 1) + 1)
            return res

        return dfs(len(s) - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    String s;
    int[] f1 = new int[2010];
    Boolean[][] f2 = new Boolean[2010][2010];

    private boolean check(int l, int r) {
        if (l >= r) {
            return true;
        }
        if (f2[l][r] != null) {
            return f2[l][r];
        }
        boolean res = s.charAt(l) == s.charAt(r) && check(l + 1, r - 1);
        f2[l][r] = res;
        return f2[l][r];
    }

    private int dfs(int r) {
        if (check(0, r)) {
            return 0;
        }
        if (f1[r] != -1) {
            return f1[r];
        }
        int res = 0x3f3f3f3f;
        for (int l = 1; l < r + 1; l++) {
            if (check(l, r)) {
                res = Math.min(res, dfs(l - 1) + 1);
            }
        }
        f1[r] = res;
        return res;
    }

    public int minCut(String s) {
        this.s = s;
        Arrays.fill(f1, -1);
        return dfs(s.length() - 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
