# [3304. 找出第 K 个字符 I](https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i)

## 题目描述

<!-- 这里写题目描述 -->

<p>Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 <code>word = "a"</code>。</p>

<p>给定一个<strong>正整数</strong> <code>k</code>。</p>

<p>现在 Bob 会要求 Alice 执行以下操作<strong> 无限次 </strong>:</p>

<ul>
	<li>将 <code>word</code> 中的每个字符<strong> 更改 </strong>为英文字母表中的<strong> 下一个 </strong>字符来生成一个新字符串，并将其<strong> 追加 </strong>到原始的 <code>word</code>。</li>
</ul>

<p>例如，对 <code>"c"</code> 进行操作生成 <code>"cd"</code>，对 <code>"zb"</code> 进行操作生成 <code>"zbac"</code>。</p>

<p>在执行足够多的操作后， <code>word</code> 中 <strong>至少 </strong>存在 <code>k</code> 个字符，此时返回 <code>word</code> 中第 <code>k</code> 个字符的值。</p>

<p><strong>注意</strong>，在操作中字符 <code>'z'</code> 可以变成 <code>'a'</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">k = 5</span></p>

<p><strong>输出：</strong><span class="example-io">"b"</span></p>

<p><strong>解释：</strong></p>

<p>最初，<code>word = "a"</code>。需要进行三次操作:</p>

<ul>
	<li>生成的字符串是 <code>"b"</code>，<code>word</code> 变为 <code>"ab"</code>。</li>
	<li>生成的字符串是 <code>"bc"</code>，<code>word</code> 变为 <code>"abbc"</code>。</li>
	<li>生成的字符串是 <code>"bccd"</code>，<code>word</code> 变为 <code>"abbcbccd"</code>。</li>
</ul>
</div>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">k = 10</span></p>

<p><strong>输出：</strong><span class="example-io">"c"</span></p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def kthCharacter(self, k: int) -> str:
        q = [0]
        while len(q) < k:
            nq = [v + 1 for v in q]
            q.extend(nq)
        return chr(q[k - 1] % 26 + ord('a'))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public char kthCharacter(int k) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        while (q.size() < k) {
            List<Integer> nq = new ArrayList<>();
            for (int v : q) {
                nq.add(v + 1);
            }
            q.addAll(nq);
        }
        return (char)(q.get(k - 1) % 26 + 'a');
    }
}
```

### **...**

```

```

<!-- tabs:end -->
