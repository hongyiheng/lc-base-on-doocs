# [3227. 字符串元音游戏](https://leetcode.cn/problems/vowels-game-in-a-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>小红和小明在玩一个字符串元音游戏。</p>

<p>给你一个字符串 <code>s</code>，小红和小明将轮流参与游戏，小红<strong> 先 </strong>开始：</p>

<ul>
	<li>在小红的回合，她必须移除 <code>s</code> 中包含 <strong>奇数 </strong>个元音的任意 <strong>非空</strong> <span data-keyword="substring">子字符串</span>。</li>
	<li>在小明的回合，他必须移除 <code>s</code> 中包含 <strong>偶数 </strong>个元音的任意 <strong>非空</strong> <span data-keyword="substring">子字符串</span>。</li>
</ul>

<p>第一个无法在其回合内进行移除操作的玩家输掉游戏。假设小红和小明都采取 <strong>最优策略 </strong>。</p>

<p>如果小红赢得游戏，返回 <code>true</code>，否则返回 <code>false</code>。</p>

<p>英文元音字母包括：<code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, 和 <code>u</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "leetcoder"</span></p>

<p><strong>输出：</strong> <span class="example-io">true</span></p>

<p><strong>解释：</strong><br />
小红可以执行如下移除操作来赢得游戏：</p>

<ul>
	<li>小红先手，她可以移除加下划线的子字符串 <code>s = "<u><strong>leetco</strong></u>der"</code>，其中包含 3 个元音。结果字符串为 <code>s = "der"</code>。</li>
	<li>小明接着，他可以移除加下划线的子字符串 <code>s = "<u><strong>d</strong></u>er"</code>，其中包含 0 个元音。结果字符串为 <code>s = "er"</code>。</li>
	<li>小红再次操作，她可以移除整个字符串 <code>s = "<strong><u>er</u></strong>"</code>，其中包含 1 个元音。</li>
	<li>又轮到小明，由于字符串为空，无法执行移除操作，因此小红赢得游戏。</li>
</ul>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">s = "bbcd"</span></p>

<p><strong>输出：</strong> <span class="example-io">false</span></p>

<p><strong>解释：</strong><br />
小红在她的第一回合无法执行移除操作，因此小红输掉了游戏。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 仅由小写英文字母组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def doesAliceWin(self, s: str) -> bool:
        cnt = 0
        for c in s:
            if c in {'a', 'e', 'i', 'o', 'u'}:
                cnt += 1
        return cnt != 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> d = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (d.contains(c)) {
                cnt++;
            }
        }
        return cnt != 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
