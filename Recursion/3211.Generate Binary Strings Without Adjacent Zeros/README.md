# [3211. 生成不含相邻零的二进制字符串](https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个正整数 <code>n</code>。</p>

<p>如果一个二进制字符串 <code>x</code> 的所有长度为 2 的<span data-keyword="substring-nonempty">子字符串</span>中包含 <strong>至少</strong> 一个 <code>"1"</code>，则称 <code>x</code> 是一个<strong> 有效</strong> 字符串。</p>

<p>返回所有长度为 <code>n</code> 的<strong> 有效</strong> 字符串，可以以任意顺序排列。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 3</span></p>

<p><strong>输出：</strong> <span class="example-io">["010","011","101","110","111"]</span></p>

<p><strong>解释：</strong></p>

<p>长度为 3 的有效字符串有：<code>"010"</code>、<code>"011"</code>、<code>"101"</code>、<code>"110"</code> 和 <code>"111"</code>。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">n = 1</span></p>

<p><strong>输出：</strong> <span class="example-io">["0","1"]</span></p>

<p><strong>解释：</strong></p>

<p>长度为 1 的有效字符串有：<code>"0"</code> 和 <code>"1"</code>。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 18</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validStrings(self, n: int) -> List[str]:
        def dfs(s):
            if len(s) == n:
                ans.append(s[::])
                return
            if s[-1] == '1':
                s += '0'
                dfs(s)
                s = s[:-1]
            s += '1'
            dfs(s)
        
        ans = []
        dfs('0')
        dfs('1')
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<String> ans = new ArrayList<>();
    int n;

    public void dfs(int i, char[] cs) {
        if (i == n) {
            ans.add(new String(cs));
            return;
        }
        if (cs[i - 1] == '1') {
            cs[i] = '0';
            dfs(i + 1, cs);
        }
        cs[i] = '1';
        dfs(i + 1, cs);
    }

    public List<String> validStrings(int n) {
        this.n = n;
        char[] cs = new char[n];
        cs[0] = '0';
        dfs(1, cs);
        cs[0] = '1';
        dfs(1, cs);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
