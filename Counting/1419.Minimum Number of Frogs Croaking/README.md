# [1419. 数青蛙](https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>croakOfFrogs</code>，它表示不同青蛙发出的蛙鸣声（字符串 &quot;croak&quot; ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以&nbsp;<code>croakOfFrogs</code> 中会混合多个 &ldquo;croak&rdquo; <em>。</em>请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。</p>

<p><strong>注意：</strong>要想发出蛙鸣 &quot;croak&quot;，青蛙必须 <strong>依序</strong> 输出 <code>&lsquo;c&rsquo;, &rsquo;r&rsquo;, &rsquo;o&rsquo;, &rsquo;a&rsquo;, &rsquo;k&rsquo;</code> 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。</p>

<p>如果字符串 <code>croakOfFrogs</code> 不是由若干有效的 &quot;croak&quot; 字符混合而成，请返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>croakOfFrogs = &quot;croakcroak&quot;
<strong>输出：</strong>1 
<strong>解释：</strong>一只青蛙 &ldquo;呱呱&rdquo; 两次
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>croakOfFrogs = &quot;crcoakroak&quot;
<strong>输出：</strong>2 
<strong>解释：</strong>最少需要两只青蛙，&ldquo;呱呱&rdquo; 声用黑体标注
第一只青蛙 &quot;<strong>cr</strong>c<strong>oak</strong>roak&quot;
第二只青蛙 &quot;cr<strong>c</strong>oak<strong>roak</strong>&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>croakOfFrogs = &quot;croakcrook&quot;
<strong>输出：</strong>-1
<strong>解释：</strong>给出的字符串不是 &quot;croak<strong>&quot;</strong> 的有效组合。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>croakOfFrogs = &quot;croakcroa&quot;
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;croakOfFrogs.length &lt;= 10^5</code></li>
	<li>字符串中的字符只有 <code>&#39;c&#39;</code>, <code>&#39;r&#39;</code>, <code>&#39;o&#39;</code>, <code>&#39;a&#39;</code> 或者 <code>&#39;k&#39;</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        def get_cur():
            cur = float('inf')
            for c in s:
                if cur >= mp[c]:
                    cur = mp[c]
                else:
                    return -1
            return mp['c'] - mp['k']

        s = ['c', 'r', 'o', 'a', 'k']
        mp = dict()
        for c in s:
            mp[c] = 0
        ans = 0
        for c in croakOfFrogs:
            if c not in croakOfFrogs:
                return -1
            mp[c] += 1
            cur = get_cur()
            if cur == -1:
                return -1
            ans = max(ans, cur)
        return ans if mp['c'] == mp['k'] else -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    char[] s = new char[]{'c', 'r', 'o', 'a', 'k'};
    Map<Character, Integer> cnt = new HashMap<>();

    public int minNumberOfFrogs(String croakOfFrogs) {
        for (char c : s) {
            cnt.put(c, 0);
        }
        int ans = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            cnt.put(c, cnt.get(c) + 1);
            int cur = getCur();
            if (cur == -1) {
                return -1;
            }
            ans = Math.max(ans, cur);
        }
        return cnt.get('c').equals(cnt.get('k')) ? ans : -1;
    }

    public int getCur() {
        int cur = Integer.MAX_VALUE;
        for (char c : s) {
            if (cnt.get(c) <= cur) {
                cur = cnt.get(c);
            } else {
                return -1;
            }
        }
        return cnt.get('c') - cnt.get('k');
    }
}
```

### **...**

```

```

<!-- tabs:end -->
