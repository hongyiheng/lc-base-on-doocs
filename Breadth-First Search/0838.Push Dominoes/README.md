# [838. 推多米诺](https://leetcode-cn.com/problems/push-dominoes)



## 题目描述

<!-- 这里写题目描述 -->

<p>一行中有 <code>N</code> 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。</p>

<p>在开始时，我们同时把一些多米诺骨牌向左或向右推。</p>

<p><img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/05/19/domino.png" style="height: 160px; width: 418px;"></p>

<p>每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。</p>

<p>同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。</p>

<p>如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。</p>

<p>就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。</p>

<p>给定表示初始状态的字符串 &quot;S&quot; 。如果第 i 张多米诺骨牌被推向左边，则 <code>S[i] = &#39;L&#39;</code>；如果第 i 张多米诺骨牌被推向右边，则 <code>S[i] = &#39;R&#39;</code>；如果第 i 张多米诺骨牌没有被推动，则 <code>S[i] = &#39;.&#39;</code>。</p>

<p>返回表示最终状态的字符串。</p>

<p><strong>示例 </strong><strong>1</strong><strong>：</strong></p>

<pre><strong>输入：</strong>&quot;.L.R...LR..L..&quot;
<strong>输出：</strong>&quot;LL.RR.LLRRLL..&quot;</pre>

<p><strong>示例 </strong><strong>2</strong><strong>：</strong></p>

<pre><strong>输入：</strong>&quot;RR.L&quot;
<strong>输出：</strong>&quot;RR.L&quot;
<strong>说明：</strong>第一张多米诺骨牌没有给第二张施加额外的力。</pre>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= N &lt;= 10^5</code></li>
	<li>表示多米诺骨牌状态的字符串只含有 <code>&#39;L&#39;</code>，<code>&#39;R&#39;</code>; 以及 <code>&#39;.&#39;</code>;</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        n = len(dominoes)
        q = deque()
        ans = []
        for i, v in enumerate(dominoes):
            ans.append(v)
            if v == 'L' or v == 'R':
                q.append(i)
        while q:
            m = len(q)
            for _ in range(m):
                i = q.popleft()
                cur = dominoes[i]
                if cur == "L" and i > 0 and dominoes[i - 1] == ".":
                    if i > 1 and dominoes[i - 2] == "R":
                        continue
                    ans[i - 1] = "L"
                    q.append(i - 1)
                if cur == "R" and i < n - 1 and dominoes[i + 1] == ".":
                    if i < n - 2 and dominoes[i + 2] == "L":
                        continue
                    ans[i + 1] = "R"
                    q.append(i + 1)
            dominoes = "".join(ans)
        return "".join(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ans = dominoes.toCharArray();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ans[i] == 'L' || ans[i] == 'R') {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                int i = q.pollFirst();
                char cur = ans[i];
                if (cur == 'L' && i > 0 && dominoes.charAt(i - 1) == '.') {
                    if (i > 1 && dominoes.charAt(i - 2) == 'R') {
                        continue;
                    }
                    ans[i - 1] = cur;
                    q.addLast(i - 1);
                }
                if (cur == 'R' && i < n - 1 && dominoes.charAt(i + 1) == '.') {
                    if (i < n - 2 && dominoes.charAt(i + 2) == 'L') {
                        continue;
                    }
                    ans[i + 1] = cur;
                    q.addLast(i + 1);
                }
            }
            dominoes = new String(ans);
        }
        return new String(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
