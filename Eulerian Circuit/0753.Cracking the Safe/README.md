# [753. 破解保险箱](https://leetcode-cn.com/problems/cracking-the-safe)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个需要密码才能打开的保险箱。密码是&nbsp;<code>n</code> 位数, 密码的每一位是&nbsp;<code>k</code>&nbsp;位序列&nbsp;<code>0, 1, ..., k-1</code>&nbsp;中的一个 。</p>

<p>你可以随意输入密码，保险箱会自动记住最后&nbsp;<code>n</code>&nbsp;位输入，如果匹配，则能够打开保险箱。</p>

<p>举个例子，假设密码是&nbsp;<code>&quot;345&quot;</code>，你可以输入&nbsp;<code>&quot;012345&quot;</code>&nbsp;来打开它，只是你输入了 6&nbsp;个字符.</p>

<p>请返回一个能打开保险箱的最短字符串。</p>

<p>&nbsp;</p>

<p><strong>示例1:</strong></p>

<pre><strong>输入:</strong> n = 1, k = 2
<strong>输出:</strong> &quot;01&quot;
<strong>说明:</strong> &quot;10&quot;也可以打开保险箱。
</pre>

<p>&nbsp;</p>

<p><strong>示例2:</strong></p>

<pre><strong>输入:</strong> n = 2, k = 2
<strong>输出:</strong> &quot;00110&quot;
<strong>说明: </strong>&quot;01100&quot;, &quot;10011&quot;, &quot;11001&quot; 也能打开保险箱。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>n</code> 的范围是&nbsp;<code>[1, 4]</code>。</li>
	<li><code>k</code> 的范围是&nbsp;<code>[1, 10]</code>。</li>
	<li><code>k^n</code> 最大可能为&nbsp;<code>4096</code>。</li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def crackSafe(self, n: int, k: int) -> str:
        def dfs(u):
            for i in range(k):
                v = u * 10 + i
                if v in vis:
                    continue
                vis.add(v)
                dfs(v % mod)
                ans.append(i)
        
        vis = set()
        mod = 10 ** (n - 1)
        ans = []
        dfs(0)
        ans += [0 for _ in range(n - 1)]
        return "".join(map(str, ans))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int mod, k;
    Set<Integer> vis;
    List<Integer> ans;

    public String crackSafe(int n, int k) {
        this.k = k;
        mod = (int) Math.pow(10, n - 1);
        vis = new HashSet<>();
        ans = new ArrayList<>();
        dfs(0);
        for (int i = 0; i < n - 1; i++) {
            ans.add(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void dfs(int u) {
        for (int i = 0; i < k; i++) {
            int v = u * 10 + i;
            if (vis.contains(v)) {
                continue;
            }
            vis.add(v);
            dfs(v % mod);
            ans.add(i);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
